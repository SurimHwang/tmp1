package com.tmp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmp.dao.ReplyDAO;
import com.tmp.dto.ReplyDTO;
import com.tmp.service.ReplyServices;

@Service
public class ReplyServicesImpl implements ReplyServices{
 
	@Autowired
	ReplyDAO replyDAO;
	
	// ��� ��ȸ
		public List<ReplyDTO> replyList(int bno){
			return replyDAO.replyList(bno);
		};

		// ��� ��ȸ
		public void replyWrite(ReplyDTO dto) {
			replyDAO.replyWrite(dto);
		};

		// ��� ����
		public void replyModify(ReplyDTO dto) {
			replyDAO.replyModify(dto);
		};

		// ��� ����
		public void replyDelete(ReplyDTO dto) {
			replyDAO.replyDelete(dto);
		};
}
