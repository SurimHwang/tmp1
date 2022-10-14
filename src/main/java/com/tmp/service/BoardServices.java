package com.tmp.service;

import java.util.List;

import com.tmp.dto.BoardDTO;
import com.tmp.dto.FileDTO;

public interface BoardServices {
	List<BoardDTO> selectAll();
	
	BoardDTO selectOne(int bno);
	
	void insertBoard(BoardDTO dto);
	
	void deleteBoard(String title);
	
	void updateBoard(BoardDTO dto);
	
	void insertFile(FileDTO fdto);
	
	List<FileDTO> selectFile(int bno);
	
	FileDTO selectDownFile(int fno);
	
	void deleteFile(int bno);
	
	void deleteReply(int bno);
}
