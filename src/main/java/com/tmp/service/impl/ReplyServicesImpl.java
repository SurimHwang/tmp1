package com.tmp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmp.dao.ReplyDAO;
import com.tmp.dto.ReplyDTO;
import com.tmp.service.ReplyServices;

@Service
public class ReplyServicesImpl implements ReplyServices{
 
	@Autowired
	ReplyDAO replyDAO;
	
	public void insertReply(ReplyDTO dto) {
		replyDAO.insertReply(dto);
	};
}
