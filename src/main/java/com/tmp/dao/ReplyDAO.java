package com.tmp.dao;

import java.util.List;

import com.tmp.dto.ReplyDTO;

public interface ReplyDAO {
	
	// ´ñ±Û Á¶È¸
	public List<ReplyDTO> replyList(int bno);

	// ´ñ±Û Á¶È¸
	public void replyWrite(ReplyDTO dto);

	// ´ñ±Û ¼öÁ¤
	public void replyModify(ReplyDTO dto);

	// ´ñ±Û »èÁ¦
	public void replyDelete(ReplyDTO dto);
}
