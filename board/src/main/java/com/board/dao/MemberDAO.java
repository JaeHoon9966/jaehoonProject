package com.board.dao;

import java.util.List;

import com.board.domain.MemberVO;
import com.board.domain.SchoolVO;

public interface MemberDAO {
 	
	// 회원 가입
	public void register(MemberVO vo) throws Exception;
	
	// 로그인
	public MemberVO login(MemberVO vo) throws Exception;

	// 아이디 중복확인
	public int idCheck(MemberVO vo) throws Exception;

	// 학교 목록
	public List<SchoolVO> scList() throws Exception;

	// 회원 목록 + 검색
	public List<MemberVO> memberList(String searchType, String keyword) throws Exception;	
}