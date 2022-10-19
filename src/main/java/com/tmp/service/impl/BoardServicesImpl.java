package com.tmp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmp.dao.BoardDAO;
import com.tmp.dto.BoardDTO;
import com.tmp.dto.FileDTO;
import com.tmp.service.BoardServices;


@Service
public class BoardServicesImpl implements BoardServices {

	@Autowired
	private BoardDAO boardDAO;

	public List<BoardDTO> selectAll() {
		List<BoardDTO> dao = boardDAO.selectAll();
		return dao;
	}
	
	public BoardDTO selectOne(int bno){
		return boardDAO.selectOne(bno);	
	}; 
	
	public void insertBoard(BoardDTO dto) {
		boardDAO.insertBoard(dto);
	}
	
	public void deleteBoard(String title) {
		boardDAO.deleteBoard(title);
	}

	public void updateBoard(BoardDTO dto) {
		boardDAO.updateBoard(dto);
	};
	
	public void insertFile(FileDTO fdto) {
		boardDAO.insertFile(fdto);
	}
	
	public List<FileDTO> selectFile(int bno){
		List<FileDTO> dao = boardDAO.selectFile(bno);
		return dao;
	};

	public FileDTO selectDownFile(int fno) {
		return boardDAO.selectDownFile(fno);
	};
	
	public void deleteFile(int bno) {
		boardDAO.deleteFile(bno);
	};
	
	public void deleteOneFile(int fno) {
		boardDAO.deleteOneFile(fno);
	};
	
	public void deleteReply(int bno) {
		boardDAO.deleteReply(bno);
	};
	
	public int selectNextBno() {
		return boardDAO.selectNextBno();
	}
}
