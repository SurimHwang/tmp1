package com.tmp.dao;

import java.util.List;

import com.tmp.dto.BoardDTO;

public interface BoardDAO {

	List<BoardDTO> selectAll();
	
	BoardDTO selectOne(int bno); 
	
	void insertBoard(BoardDTO dto); 
	
	void deleteBoard(String title); 
	
	void updateBoard(BoardDTO dto);
}
