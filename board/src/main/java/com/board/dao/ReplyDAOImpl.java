package com.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.board.domain.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

	@Inject
	private SqlSession sql;
 
	private static String namespace = "com.board.mappers.reply";

	// 댓글 목록
	@Override
	public List<ReplyVO> list(int bo_num) throws Exception { 
  		return sql.selectList(namespace + ".replyList", bo_num);
	}
	
	// 댓글 갯수
	@Override
	public int count() throws Exception {
		return sql.selectOne(namespace + ".count");
	}
	
	// 댓글 상세 조회
	@Override
	public ReplyVO view(int re_num) throws Exception {
		return sql.selectOne(namespace + ".replyView", re_num);	
	}
	
	// 댓글 작성
	@Override
	public void write(ReplyVO vo) throws Exception {
		sql.insert(namespace + ".replyWrite", vo);
	}

	// 댓글 수정
	@Override
	public void modify(ReplyVO vo) throws Exception {			
		sql.update(namespace + ".replyModify", vo);
	}
	
	// 댓글 삭제
	@Override
	public void delete(ReplyVO vo) throws Exception {
		sql.delete(namespace + ".replyDelete", vo);
	}
	
}