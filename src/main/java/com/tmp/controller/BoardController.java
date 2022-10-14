package com.tmp.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import com.tmp.dto.BoardDTO;
import com.tmp.dto.FileDTO;
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
		// 파일 찾기
		List<FileDTO> files = BoardServices.selectFile(bno);

		model.addAttribute("board", board);
		model.addAttribute("files", files);
		//model.addAttribute("fileList", BoardServices.getBoardFileList());

		// 댓글 리스트 조회
		List<ReplyDTO> reply = ReplyServices.replyList(bno);
		model.addAttribute("reply", reply);

		return "selectone";
	}

	@RequestMapping(value = "writeboard.do")
	public String writeBoard(HttpSession session, Model model) {
		return "writeboard";
	}

	@PostMapping(value = "/insertboard")
	public String insertBoard(BoardDTO dto) throws IllegalStateException, IOException {
		// 파일 업로드 처리
		String fileName = null;
		String fileUrl = "C:\\upload\\";
		File destinationFile;
		UUID uuid = null;

		 List<MultipartFile> uploadfile = dto.getFiles();
		// 파일리스트가 들어오는지 System.out으로 확인한 후 DB에 연결하고 화면뷰에 띄우기
		
		List<FileDTO> list = new ArrayList<FileDTO>();

		BoardServices.insertBoard(dto);
		
		for (MultipartFile file : uploadfile) {
			if (!uploadfile.isEmpty()) {
				String originalFileName =  new String(file.getOriginalFilename());
				String ext = FilenameUtils.getExtension(originalFileName); // 확장자 구하기
			    System.out.println("orgFileName: "+originalFileName);
				
			    do { 
			    	uuid = UUID.randomUUID(); // UUID 구하기 
			    	fileName = uuid + "." + ext;
			    	destinationFile = new File(fileUrl + fileName);
				} while (destinationFile.exists());
			  
				destinationFile.getParentFile().mkdirs();
				file.transferTo(destinationFile);

				FileDTO fdto = new FileDTO();
				
				fdto.setBno(dto.getBno());
				fdto.setFileUrl(fileUrl);
				fdto.setMetaFileName(fileName);
				fdto.setOrgFileName(originalFileName);
				
				list.add(fdto);
			
				BoardServices.insertFile(fdto);
			}
		}
		
		

		System.out.println("저장 성공");

		return "redirect:/boardlist.do";
	}

	@RequestMapping(value = "/deleteboard.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteBoard(HttpServletRequest request) throws Exception {
		String title = request.getParameter("title");
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		BoardServices.deleteFile(bno);
		BoardServices.deleteReply(bno);
		BoardServices.deleteBoard(title);
		System.out.println("삭제 성공");

		return "redirect:/boardlist.do";
	}

	@RequestMapping(value = "/updateboard", method = { RequestMethod.GET, RequestMethod.POST })
	public String updateBoard(BoardDTO dto) {
		System.out.println(dto.getBdContent());
		System.out.println(dto.getBdTitle());
		System.out.println(dto.getBno());

		BoardServices.updateBoard(dto);
		System.out.println("수정 성공");

		return "forward:/boardlist.do";
	}
	
//	public void deleteFiles(List<FileDTO> filelist) {
//		if(filelist == null || filelist.size()==0) return;
//		System.out.println(filelist);
//		
//		filelist.forEach(attach -> {
//			try {
//				Path file = Paths.get("C:\\upload\\"+attach.getFileUrl()+"\\"+attach.getMetaFileName()+"_"+attach.getOrgFileName());
//			}
//		});
//	}
}