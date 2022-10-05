package com.tmp.dao;

import java.util.List;

import com.tmp.dto.ReplyDTO;

public interface ReplyDAO {
	
	// ��� ��ȸ
	public List<ReplyDTO> replyList(int bno);

	// ��� ��ȸ
	public void replyWrite(ReplyDTO dto);

	// ��� ����
	public void replyModify(ReplyDTO dto);

	// ��� ����
	public void replyDelete(ReplyDTO dto);
}
