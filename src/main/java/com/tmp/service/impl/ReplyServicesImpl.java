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
	
	// 댓글 조회
		public List<ReplyDTO> replyList(int bno){
			return replyDAO.replyList(bno);
		};

		// 댓글 작성
		public void replyWrite(ReplyDTO dto) {
			replyDAO.replyWrite(dto);
		};

		// 댓글 수정
		public void replyModify(ReplyDTO dto) {
			replyDAO.replyModify(dto);
		};

		// 댓글 삭제
		public void replyDelete(ReplyDTO dto) {
			replyDAO.replyDelete(dto);
		};
}
