package com.tmp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tmp.dto.BoardDTO;
import com.tmp.dto.ReplyDTO;
import com.tmp.service.BoardServices;
import com.tmp.service.ReplyServices;

@Controller
public class BoardController {

	@Autowired
	private BoardServices BoardServices;
	
	@Autowired
	private ReplyServices ReplyServices;

	@RequestMapping(value = "/boardlist.do", method = RequestMethod.GET)
	public String selectAll(Model model) {
		List<BoardDTO> boardlist = BoardServices.selectAll();
		
		model.addAttribute("boardlist", boardlist);
		return "boardlist";
	}
	
	@RequestMapping(value = "/selectone", method = RequestMethod.GET)
	public String selectOne(@RequestParam("bno") int bno, Model model, HttpSession session) throws Exception {
		BoardDTO board = BoardServices.selectOne(bno);
		
		model.addAttribute("board", board);
		
		//댓글 리스트 조회
		List<ReplyDTO> reply = ReplyServices.replyList(bno);
		model.addAttribute("reply", reply);
		
		return "selectone";
	}
	
	@RequestMapping(value="writeboard.do")
	public String writeBoard(HttpSession session, Model model) {
		return "writeboard";
	}

	@RequestMapping(value="/insertboard", method = {RequestMethod.GET, RequestMethod.POST})
	public String insertBoard(BoardDTO dto) {
		BoardServices.insertBoard(dto);
		
		System.out.println("저장 성공");
		
		return "forward:/boardlist.do";
	}
	
	@RequestMapping(value="/deleteboard.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String deleteBoard(HttpServletRequest request)throws Exception {
		String title = request.getParameter("title");
		
		BoardServices.deleteBoard(title);
		System.out.println("삭제 성공");
		
		return "redirect:/boardlist.do";
	}
	
	@RequestMapping(value="/updateboard", method = {RequestMethod.GET, RequestMethod.POST})
	public String updateBoard(BoardDTO dto) {
		System.out.println(dto.getBdContent());
		System.out.println(dto.getBdTitle());
		
		BoardServices.updateBoard(dto);
		System.out.println("수정 성공");
		
		return "forward:/boardlist.do";
	}
}