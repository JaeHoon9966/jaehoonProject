package com.board.service;

import java.util.List;

import com.board.domain.BoardVO;

public interface BoardService {
     
	 // 게시물 목록
	 public List<BoardVO> list(int displayPost, int postNum) throws Exception; 
	 
	 // 게시물 총 갯수
	 public int count() throws Exception;
	 
	 // 게시물 작성
	 public void write(BoardVO vo) throws Exception;
	 
	 // 게시물 조회
	 public BoardVO view(int bo_num) throws Exception;
	
	 // 게시물 수정
	 public void modify(BoardVO vo) throws Exception;
	
	 // 게시물 삭제
	 public void delete(int bo_num) throws Exception;

     // 게시물 추천
	 public void recommend(int bo_num) throws Exception;
	 
	 // 게시물 조회수
	 public void viewCnt(int bo_num) throws Exception;
}
