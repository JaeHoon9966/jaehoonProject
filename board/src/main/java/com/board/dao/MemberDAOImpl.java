package com.board.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.board.domain.MemberVO;
import com.board.domain.SchoolVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	private SqlSession sql;
 
	private static String namespace = "com.board.mappers.member";

	// 회원가입
	@Override
	public void register(MemberVO vo) throws Exception {
		sql.insert(namespace + ".register", vo);		
	}

	// 로그인
	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		return sql.selectOne(namespace + ".loginBcrypt", vo);
	}
	
	// 아이디 중복확인
	@Override
	public int idCheck(MemberVO vo) throws Exception {
		return sql.selectOne(namespace + ".idCheck", vo);
	}
	
	// 학교 목록
	@Override
	public List<SchoolVO> scList() throws Exception {
		return sql.selectList(namespace + ".scList");
	}

	// 멤버 목록 + 검색
	@Override
	public List<MemberVO> memberList(String searchType, String keyword) throws Exception {
		HashMap<String, Object>	data = new HashMap<String, Object>();
		
		data.put("searchType",searchType);
		data.put("keyword",keyword);
		return sql.selectList(namespace + ".memberList", data);
	}
}