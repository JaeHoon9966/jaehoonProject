package com.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.board.dao.MemberDAO;
import com.board.domain.MemberVO;
import com.board.domain.SchoolVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAO dao;
 
	// 회원 가입
	@Override
	public void register(MemberVO vo) throws Exception {	
		dao.register(vo);	
	}

	// 로그인
	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		return dao.login(vo);
	}

	// 아이디 중복확인
	@Override
	public int idCheck(MemberVO vo) throws Exception {
		return dao.idCheck(vo);
	}
	
	// 학교 목록
	@Override
	public List<SchoolVO> scList() throws Exception {
		return dao.scList();
	}

	// 회원 목록 + 검색
	@Override
	public List<MemberVO> memberList(String searchType, String keyword) throws Exception {
		return dao.memberList(searchType, keyword);
	}
}