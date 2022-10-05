package com.tmp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmp.dao.BoardDAO;
import com.tmp.dto.BoardDTO;
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

}
