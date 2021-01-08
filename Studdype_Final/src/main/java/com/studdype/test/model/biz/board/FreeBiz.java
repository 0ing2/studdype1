package com.studdype.test.model.biz.board;

import java.util.List;
import java.util.Map;

import com.studdype.test.model.dto.board.BoardDto;
import com.studdype.test.model.dto.member.MemberDto;

public interface FreeBiz {

	public int selectTotalBoardNum(int s_no); // 자유게시판 총 게시글 갯수
	public List<BoardDto> selectPagingBoardList(Map pageMap); //페이징( 15개 게시글만 가져오기)
	public Map<Integer, String> getWriterNameByList(List<BoardDto> list); //리스트로 작성자 이름 가져오기
	public int writeBoard(BoardDto board); //자유게시판 글 작성
	public BoardDto selectDetail(int b_no, int isVisitPage); //자유게시판 글 디테일
	public Map<Integer, MemberDto> getMemberMap(List<BoardDto> list); //자유게시판 memberMap
	public int deleteBoard(int b_no); //자유게시판 글 삭제
	public int updateBoard(BoardDto board); // 자유게시판 글 수정
	public BoardDto selectOne(int b_no); //자유게시판 글 하나 가져오기

}
