package com.saeyan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/upload2.do")
public class MultiUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MultiUploadServlet() {
        super();
       
    }

	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8" );
		PrintWriter out = response.getWriter();
		
		//여기서 바꿔주면 다운받는 경로가 바뀜
		String savePatth = "upload";
		//최대 업로드 파일 크기 5메가바이트로 제한
		int uploadFileSizelimit = 5 * 1024 * 1024;
		String encType = "UTF-8";
		
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePatth);
		
		try {
		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSizelimit, encType, new DefaultFileRenamePolicy());
		
		Enumeration files = multi.getFileNames();
		
		while(files.hasMoreElements()) {
			
			String file = (String) files.nextElement();
			String file_name = multi.getFilesystemName(file);
			
			String ori_file_name = multi.getOriginalFileName(file);
			out.println("<br> 업로드된 파일명:" +file_name);
			out.println("<br> 원본 파일명:" +ori_file_name);
			out.print("<hr>");
		}
	
		}catch (Exception e) {
			System.out.print("예외 발생:" + e);
		}
	}

}
