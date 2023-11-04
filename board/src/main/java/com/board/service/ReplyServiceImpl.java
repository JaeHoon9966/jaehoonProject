package com.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.board.dao.ReplyDAO;
import com.board.domain.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Inject
	private ReplyDAO dao;
 
	// 댓글 목록
	@Override
	public List<ReplyVO> list(int bo_num) throws Exception {
		List<ReplyVO> replyList = dao.list(bo_num);
		
		if ( replyList.size() > 0 ) {
			for ( int i = 0 ; i < replyList.size() ; i++ ) {
				ReplyVO vo = replyList.get(i);
				vo.setContent(vo.getContent().replaceAll("\r\n", "<br />"));
			}
		}
		
		return replyList;
	}
	
	// 댓글 갯수
	@Override
	public int count() throws Exception {
		return dao.count();
	}
		
	// 댓글 상세 조회
	@Override
	public ReplyVO view(int re_num) throws Exception {
		return dao.view(re_num);
	}
	
	// 댓글 작성
	@Override
	public void write(ReplyVO vo) throws Exception {	
		dao.write(vo);	
	}


	// 댓글 수정
	@Override
	public void modify(ReplyVO vo) throws Exception {
		dao.modify(vo);
	}
	
	// 댓글 삭제
	@Override
	public void delete(ReplyVO vo) throws Exception {
		dao.delete(vo);
	}

}