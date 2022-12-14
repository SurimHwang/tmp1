package com.tmp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tmp.dto.ReplyDTO;
import com.tmp.service.ReplyServices;

@Controller
public class ReplyController {

	@Autowired
	private ReplyServices replyServices;

	// 댓글 작성
	@RequestMapping(value = "/replyWrite", method = RequestMethod.GET)
	public String replyWrite(ReplyDTO dto) {
		
		replyServices.replyWrite(dto);
		
		return "redirect:/selectone?bno=" + dto.getBno();
	}
	
	// 댓글 변경
		@RequestMapping(value = "/replyModify", method = RequestMethod.GET)
		public String replyModify(@RequestParam(value="bno", required=false)int bno, ReplyDTO dto) {
			
			System.out.println(dto.getRno());
			System.out.println(dto.getBno());
			
			replyServices.replyModify(dto);
			
			return "redirect:/selectone?bno=" + dto.getBno();
		}
		
		// 댓글 삭제
		@RequestMapping(value = "/replyDelete", method = RequestMethod.GET)
		public String replyDelete(ReplyDTO dto) {
			
			replyServices.replyDelete(dto);
			
			return "redirect:/selectone?bno=" + dto.getBno();
		}

}