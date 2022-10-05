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

	// ¥Ò±€ ¿€º∫
	@RequestMapping(value = "/replyWrite", method = RequestMethod.GET)
	public String replyWrite(ReplyDTO dto) {
		
		replyServices.replyWrite(dto);
		
		return "redirect:/selectone?bno=" + dto.getBno();
	}
}