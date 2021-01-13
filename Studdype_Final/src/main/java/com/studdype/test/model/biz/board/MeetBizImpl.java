package com.studdype.test.model.biz.board;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.studdype.test.common.SearchPagination;
import com.studdype.test.model.dao.board.meet.MeetBoardDao;
import com.studdype.test.model.dao.member.MemberDao;
import com.studdype.test.model.dto.board.MeetDto;
import com.studdype.test.model.dto.study.StudyDto;
import com.studdype.test.model.dto.member.MemberDto;

@Validated
@Service
public class MeetBizImpl implements MeetBiz {
	
	@Autowired
	private MeetBoardDao meetBoardDao;
	@Autowired
	private MemberDao memberDao;

	// 모임게시판 게시물 총 개수
	@Override
	public int selectTotalMeetBoardNum(int s_no) {		
		return meetBoardDao.selectTotalMeetBoardNum(s_no);
	}

	// 페이징(5개 게시글만 가져오기)
	@Override
	public List<MeetDto> selectPagingMeetBoardList(Map pageMap) {
		return meetBoardDao.selectPagingMeetBoardList(pageMap);
	}
	
	// 모임게시판 검색 게시물 총 개수
	@Override
	public int selectSearchMeetBoardNum(Map searchNumMap) {
		return meetBoardDao.selectSearchMeetBoardNum(searchNumMap);
	}
	
	// 모임게시판 검색 페이징
	@Override
	public List<MeetDto> selectPagingSearchMeetList(Map searchPageMap) {
		return meetBoardDao.selectPagingSearchMeetList(searchPageMap);
	}
	
	// 리스트로 작성자 이름 가져오기
	@Override
	public Map<Integer, MemberDto> getMemberMap(List<MeetDto> list) {
		return memberDao.selectMemberByMeetList(list);
	}
	
	// 모임게시판 디테일
	@Transactional
	@Override
	public MeetDto selectOne(int meet_no, int isVisitPage) {
		if(isVisitPage == 0) {
			meetBoardDao.updateMeetCnt(meet_no);
		}
		MeetDto dto = meetBoardDao.meetBoardSelectOne(meet_no);
		
		return dto;
	}
	
	// 모임게시판 모임생성
	@Override
	public int insert(MeetDto dto) {
		return meetBoardDao.insertMeetBoard(dto);
	}

	@Override
	public int update(MeetDto dto) {
		return meetBoardDao.updateMeetBoard(dto);
	}
	
	// 모임게시판 모임삭제
	@Override
	public int delete(int meet_no) {
		return meetBoardDao.deleteMeetBoard(meet_no);
	}

	@Override
	public List<MeetDto> selectMeetDBForCalendar(int s_no) {
		return meetBoardDao.selectMeetDBForCalendar(s_no);
	}

}
