package com.example.dao;

import java.util.HashMap;
import java.util.List;

import com.example.vo.BoardVO;

public interface BoardDAO {
	
	public int insertBoardBatch(List<BoardVO> list); //여러개쓰기
	
	public int insertBoard(BoardVO obj); //한개쓰기 
	
	public List<BoardVO> selectBoard(HashMap<String, Object> map);
	
	public BoardVO selectBoardOne(long id);
	
	public int updateBoard(BoardVO obj);
	
	public int deleteBoard(BoardVO obj);
	
	public int countBoard(); //전체 개수 구하기
	
	public int updateHit(long no); //조회수
	
	public int insertBatch(List<BoardVO> list);
	
	public BoardVO selectBoardImg(int no);
}
