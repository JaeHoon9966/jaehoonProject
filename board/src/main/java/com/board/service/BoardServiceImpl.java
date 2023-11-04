package com.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.board.dao.BoardDAO;
import com.board.domain.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;
 
	// 게시물 목록
	@Override
	public List<BoardVO> list(int displayPost, int postNum ) throws Exception {
		return dao.list(displayPost, postNum);	
	}
	
	// 게시물 총 갯수
	@Override
	public int count() throws Exception {
		return dao.count();
	}

	// 게시물 작성
	@Override
	public void write(BoardVO vo) throws Exception {	
		dao.write(vo);	
	}

	// 게시물 조회
	@Override
	public BoardVO view(int bo_num) throws Exception {
		BoardVO vo = dao.view(bo_num);
		vo.setContent(vo.getContent().replaceAll("\r\n", "<br />"));		
		return vo;
	}

	// 게시물 수정
	@Override
	public void modify(BoardVO vo) throws Exception {
		dao.modify(vo);
	}
	
	// 게시물 삭제
	@Override
	public void delete(int bo_num) throws Exception {
		dao.delete(bo_num);
	}
	
	//게시글 추천
    @Override
    public void recommend(int bo_num) throws Exception {       
        dao.recommend(bo_num);        
    }	
    
    // 조회수 증가
    @Override
    public void viewCnt(int bo_num) throws Exception {        
    	dao.viewCnt(bo_num);
    }
}