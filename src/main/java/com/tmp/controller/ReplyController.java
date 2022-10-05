package com.tmp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tmp.dto.ReplyDTO;
import com.tmp.service.ReplyServices;

@Controller
public class ReplyController {

	@Autowired
	private ReplyServices replyServices;

	@RequestMapping(value = "/insertreply", method = {RequestMethod.POST, RequestMethod.GET})
	public String insertReply(Model model, ReplyDTO dto, HttpSession session) {
		replyServices.insertReply(dto);
		return "forward:/boardlist.do";
	}
}