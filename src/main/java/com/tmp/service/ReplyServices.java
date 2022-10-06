package com.tmp.service;

import java.util.List;

import com.tmp.dto.ReplyDTO;

public interface ReplyServices {
	
	// 댓글 조회
		public List<ReplyDTO> replyList(int bno);

		// 댓글 작성
		public void replyWrite(ReplyDTO dto);

		// 댓글 수정
		public void replyModify(ReplyDTO dto);

		// 댓글 삭제 
		public void replyDelete(ReplyDTO dto);
}
