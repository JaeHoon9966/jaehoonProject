package com.board.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.board.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession sql;
 
	private static String namespace = "com.board.mappers.board";

	// 게시물 목록
	@Override
	public List<BoardVO> list(int displayPost, int postNum) throws Exception { 
		
		HashMap<String, Integer> data = new HashMap<String, Integer>();
		
		data.put("displayPost", displayPost);
		data.put("postNum", postNum);
  		return sql.selectList(namespace + ".list", data);
	}
	
	// 게시물 총 갯수
	@Override
	public int count() throws Exception { 
		return sql.selectOne(namespace + ".count");
	}

	// 게시물 작성
	@Override
	public void write(BoardVO vo) throws Exception {
		sql.insert(namespace + ".write", vo);
	}

	// 게시물 조회
	@Override
	public BoardVO view(int bo_num) throws Exception {
		return sql.selectOne(namespace + ".view" , bo_num);
	}

	// 게시물 수정
	@Override
	public void modify(BoardVO vo) throws Exception {			
		sql.update(namespace + ".modify", vo);
	}
	
	// 게시물 삭제
	@Override
	public void delete(int bo_num) throws Exception {
		sql.delete(namespace + ".delete", bo_num);
	}

	// 추천수 증가
    @Override
    public void recommend(int bo_num) throws Exception {       
        sql.update(namespace + ".recommend", bo_num);
    }
    
    // 조회수 증가
    @Override
    public void viewCnt(int bo_num) throws Exception {        
        sql.update(namespace + ".viewCnt", bo_num);
    }
}