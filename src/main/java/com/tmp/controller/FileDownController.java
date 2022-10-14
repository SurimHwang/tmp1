package com.tmp.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tmp.dto.FileDTO;
import com.tmp.service.BoardServices;

@Controller
public class FileDownController {
    
	@Autowired
	private BoardServices BoardServices;
	
    @RequestMapping(value = "fileDownload.do")
    public void fileDownload4(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //String path =  request.getSession().getServletContext().getRealPath("저장경로");
    	
        int fno = Integer.parseInt(request.getParameter("fno"));
        String realFilename="";
        
        FileDTO dto = BoardServices.selectDownFile(fno);
        String filename = URLEncoder.encode(dto.getOrgFileName(),"UTF-8");
        //filename = filename.replaceAll("\\+", " ");
        
        filename = URLDecoder.decode(filename, "ISO-8859-1");
        //System.out.println("ISO: "+filename);
        
        filename = URLDecoder.decode(filename, "UTF-8");
        //System.out.println("UTF-8: "+filename);
        
        try {
        	request.setCharacterEncoding("UTF-8");
            String browser = request.getHeader("User-Agent");
            //파일 인코딩
            if (browser.contains("MSIE") || browser.contains("Trident")
                    ||
                    browser.contains("Chrome")) {
                filename = new String(filename.getBytes("ISO-8859-1"),"utf-8" );
            } else {
                filename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+",
                        "%20");
            }
        } catch (UnsupportedEncodingException ex) {
            System.out.println("UnsupportedEncodingException");
        }
        realFilename = dto.getFileUrl() + filename;
        System.out.println(realFilename);
        File file1 = new File(realFilename);
        if (!file1.exists()) {
            return ;
        }
         
        // 파일명 지정        
        response.setContentType("application/octer-stream; UTF-8");
        response.setHeader("Content-Transfer-Encoding", "binary;");
        response.setHeader("Content-Disposition", "attachment; filename=\""+ URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", " ") + "\"");
        response.setCharacterEncoding("utf-8");
        try {
            OutputStream os = response.getOutputStream();
            FileInputStream fis = new FileInputStream(realFilename);
 
            int ncount = 0;
            byte[] bytes = new byte[512];
 
            while ((ncount = fis.read(bytes)) != -1 ) {
                os.write(bytes, 0, ncount);
            }
            fis.close();
            os.close();
        } catch (Exception e) {
            System.out.println("FileNotFoundException : " + e);
        }
    }
}