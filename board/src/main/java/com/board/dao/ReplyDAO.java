package com.board.dao;

import java.util.List;

import com.board.domain.ReplyVO;

public interface ReplyDAO {
 
	// 댓글 목록
	public List<ReplyVO> list(int bo_num) throws Exception;
	
	// 댓글 갯수
	public int count() throws Exception;
		
	// 댓글 상세 조회
	public ReplyVO view(int re_num) throws Exception;
	
	// 댓글 작성
	public void write(ReplyVO vo) throws Exception;
	
	// 댓글 수정
	public void modify(ReplyVO vo) throws Exception;
	
	// 댓글 삭제
	public void delete(ReplyVO vo) throws Exception;

}