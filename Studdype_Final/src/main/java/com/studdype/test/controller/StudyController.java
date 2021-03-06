package com.studdype.test.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.studdype.test.common.FileHandler;
import com.studdype.test.common.PageMaker;
import com.studdype.test.common.SearchPagination;
import com.studdype.test.common.UploadFile;
import com.studdype.test.model.biz.board.BookBiz;
import com.studdype.test.model.biz.member.MemberBiz;
import com.studdype.test.model.biz.study.StudyBiz;
import com.studdype.test.model.biz.study.StudyMemberBiz;
import com.studdype.test.model.dto.board.BookDto;
import com.studdype.test.model.dto.board.FileDto;
import com.studdype.test.model.dto.location.LocationGuDto;
import com.studdype.test.model.dto.location.LocationSiDto;
import com.studdype.test.model.dto.member.MemberDto;
import com.studdype.test.model.dto.study.StudyCategoryDto;
import com.studdype.test.model.dto.study.StudyDto;
import com.studdype.test.model.dto.study.StudyMemberDto;

@Controller
public class StudyController {

	private static final Logger logger = LoggerFactory.getLogger(StudyController.class);
	private final static int pageSize = 15; // 한페이지에 보여줄 개수
	private final static int pageGroupSize = 5; // 페이지 그룹 사이즈

	@Autowired
	private StudyBiz studyBiz;
	@Autowired
	private MemberBiz memberBiz;
	@Autowired
	private BookBiz bookBiz;
	@Autowired
	private StudyMemberBiz StudyMemberBiz;
	
	private FileHandler fileHandler = new FileHandler(); // 스터디 대표사진 관련 파일 핸들러

	@RequestMapping(value = "/studyList.do", method = RequestMethod.GET)
	public String list(Model model, @ModelAttribute("searchPagination") SearchPagination searchPagination, HttpSession session) {

		Map<Integer, String> studyMainLeaderNameMap = null; // 리더이름을 담을 MAP 설정
		List<StudyDto> studyList = null; // 스터디 리스트 담을 곳
		Map<Integer, String> selectSiForMainMap = null; // 시 리스트 담을 곳
		Map<Integer, String> selectGuForMainMap = null; // 구 리스트 담을 곳
		Map<Integer, String> selectCateForMainMap = null; // 카테고리 리스트 담을 곳

		// 로그
		logger.info("STUDY - SELECTLIST");

		studyList = studyBiz.studyList(searchPagination); // 스터디 리스트
		PageMaker pageMaker = new PageMaker();
		pageMaker.setPagination(searchPagination);
		pageMaker.setTotalCount(studyBiz.selectTotalStudyListNum(searchPagination));
		selectSiForMainMap = studyBiz.selectSiForMainPage(studyList); // 구 리스트
		selectGuForMainMap = studyBiz.selectGuForMainPage(studyList); // 시 리스트
		studyMainLeaderNameMap = studyBiz.selectLeaderNameByMainPage(studyList); // 리더이름 리스트
		selectCateForMainMap = studyBiz.categoryListForHome(studyList); // 카테고리 리스트

		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("studyList", studyList);
		model.addAttribute("leaderName", studyMainLeaderNameMap);
		model.addAttribute("siList", selectSiForMainMap);
		model.addAttribute("guList", selectGuForMainMap);
		model.addAttribute("cateList", selectCateForMainMap);
		session.setAttribute("headerMenu", "home");

		return "studdype/studdypeHome";
	}

	// 스터디 생성 폼
	@RequestMapping("/createStuddypeform.do")
	public String createStuddypeForm(Model model,HttpSession session) {
		List<LocationSiDto> sidtos = studyBiz.locationSiList();
		List<LocationGuDto> gudtos = studyBiz.locationGuList();
		List<StudyCategoryDto> catedtos = studyBiz.categoryList();
		MemberDto login = (MemberDto)session.getAttribute("login");

		model.addAttribute("login", login);
		model.addAttribute("sidtos", sidtos);
		model.addAttribute("gudtos", gudtos);
		model.addAttribute("catedtos", catedtos);
		session.setAttribute("headerMenu", "create");

		return "studdype/createStuddype";
	}

	// 스터디 생성 후 Stduddypehome으로
	@RequestMapping("createStuddype.do")
	public String createStuddype(HttpServletRequest request, StudyDto studyDto, UploadFile uploadFile) {
		int res = 0;
		
		// 스터디 마지막 번호 가져오기
		int studyFinalNumber = studyBiz.selectStudyFinalNumber();
		studyDto.setS_no(studyFinalNumber + 1);
		
		//파일 업로드
		MultipartFile[] mfileList =   uploadFile.getFile();  //multipartFile 리스트 반환해서 생성
		
		// 파일요소들 뽑아서 fileList에 저장
		List<FileDto> fileList = fileHandler.getFileList(mfileList, request);//파일리스트 생성
		
		String path = fileHandler.getPath(request); //파일이 저장될 가장 기본 폴더
		
		//파일이있으면
		if(mfileList != null) {
			studyDto.setPhoto(fileList.get(0).getF_url());
		}else {
			studyDto.setPhoto("noImage");
		}
		
		System.out.println(studyDto);
		
		res = studyBiz.insertStudy(studyDto, mfileList, path, fileList);

		// 성공 시 -> 스터디 커뮤니티 홈
		// 실패 시 -> 스터디 생성 폼
		if (res > 0) {
			return "redirect:studyList.do";
		} else {
			return "redirect:createStuddypeform.do";
		}
	}

	// 스터디 관리 페이지 이동
	@RequestMapping("/updateStudy.do")
	public String updateStudy(HttpSession session, Model model,HttpServletRequest request) {
		MemberDto login = (MemberDto)session.getAttribute("login");
		MemberDto dto = memberBiz.selectOne(login.getMem_no());
		List<StudyCategoryDto> category = studyBiz.categoryList();
		List<LocationGuDto> gudto = studyBiz.locationGuList();
		List<LocationSiDto> sidto = studyBiz.locationSiList();
		List<BookDto> bookList = bookBiz.bookList(Integer.parseInt(request.getParameter("s_no")));
		List<StudyDto> LeaderList = studyBiz.studyLeader(login.getMem_no());
		List<StudyMemberDto> memberlist = StudyMemberBiz.StudyMemberList(Integer.parseInt(request.getParameter("s_no")));
		List<MemberDto> membername = new ArrayList<MemberDto>();
		for (int i = 0; i < memberlist.size(); i++) {
			MemberDto dto2 = memberBiz.selectOne(memberlist.get(i).getMem_no());
			membername.add(dto2);
		}

		System.out.println(membername);

		model.addAttribute("membername", membername);
		model.addAttribute("memberlist", memberlist);
		session.setAttribute("login", dto);
		model.addAttribute("bookList", bookList);
		model.addAttribute("gudto", gudto);
		model.addAttribute("sidto", sidto);
		model.addAttribute("category", category);

		session.setAttribute("leftnavi", "updateStudy");

		return "studdype/updateStudy";
	}
	// 스터디 관리 페이지 update버튼 클릭시
	@RequestMapping(value="/studyupdate.do",method = RequestMethod.GET)
	public String studyupdate(HttpServletRequest request,Model model) {
		System.out.println("들어오긴함");
		System.out.println(request.getParameter("mem_no"));
		int dto = bookBiz.bookmain(Integer.parseInt(request.getParameter("b_no")));
		System.out.println("s_no : "+request.getParameter("s_no"));
		StudyDto dto3 = new StudyDto(Integer.parseInt(request.getParameter("mem_no")),Integer.parseInt(request.getParameter("s_no")) );
		int dto2 = studyBiz.newLeader(dto3);
		
		System.out.println("dto3 :"+dto3);
		if(dto>0) {
			if(dto2>0) {
			model.addAttribute("msg","대표 수정성공!");
			model.addAttribute("url","communityhome.do");
			return "commond/alert";
			}else {
				model.addAttribute("msg","대표수정 실패 !");
				model.addAttribute("url","communityhome.do");
				return "commond/alert";
			}
			}else {
			if(dto2>0) {
			model.addAttribute("msg","대표 수정 성공!");
			model.addAttribute("url","communityhome.do");
			return "commond/alert";
			}else {
				model.addAttribute("msg","대표 수정 실패!");
				model.addAttribute("url","communityhome.do");
				return "commond/alert";
				
			}
	
	}

	}
	
	// 스터디 디테일 페이지(스터디 홈에서 리스트 클릭 시 넘어옴)
	@RequestMapping("/studdypeDetailForm.do")
	public String studdypeDetailForm(Model model, HttpServletRequest request) {
		int s_no = Integer.parseInt(request.getParameter("s_no"));
		
		StudyDto studyDto = studyBiz.selectOneBySno(s_no);	// 스터디 정보
		System.out.println(studyDto);
		studyDto.setPhoto(fileHandler.getFileName(studyDto.getPhoto(), "Studdype_Final"));
		MemberDto memberDto = memberBiz.selectOne(studyDto.getLeader_no());	// 스터디 팀장 정보
		Map<Integer, String> siDto = studyBiz.selectLocationSiOfStudy(studyDto.getSi_no());
		
		BookDto bookDto = bookBiz.selectMainBookOfStudy(s_no);	// 스터디 대표도서 정보
		
		model.addAttribute("study", studyDto);
		model.addAttribute("leader", memberDto);
		model.addAttribute("mainBook", bookDto);
		
		return "studdype/StuddypeDetailForm";
	}
}
















