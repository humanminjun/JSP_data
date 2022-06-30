package com.saeyan.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/upload.do")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
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
		System.out.println("서버상의 실제 디렉토리 :");
		System.out.println(uploadFilePath);
		
		try {
		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSizelimit, encType, new DefaultFileRenamePolicy());
		
		String fileName = multi.getFilesystemName("uploadFilePath");
		
		if(fileName == null) {
			System.out.print("파일이 업로드 되지 않았음");
		}else {
			out.println("<br> 글쓴이:" +multi.getParameter("name"));
			out.println("<br> 제 목:" +multi.getParameter("title"));
			out.println("<br> 파일명:" +fileName);
		}
		}catch (Exception e) {
			System.out.print("예외 발생:" + e);
		}
	}

}
