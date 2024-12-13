package com.jbedu.member.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 컨트롤러 기본
// 1. extends HttpServlet 상속을 받고, 2. @WebServlet() annotation 설정  3. source 에서 doget, dopost 오보라이드
// 4. super.doPost(req, resp) doget, dopost 에서 지우고, 인수 request, response 로
// 5. System.out.println(".naver 로 끝나는 요청이 들어왔네요.");  .naver 로 끝나는 모든 페이지 요청에 반응. 콘솔에 내용이 찍힘

@WebServlet("*.naver")
public class MemberController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(".naver 로 끝나는 요청이 들어왔네요.");
		
		// /jsp_241213_controllerTest -> contextPath 라고함
		// http://localhost:8888 서버주소
		String uri = request.getRequestURI(); // client 가 요청한 젠체주소
		System.out.println(uri); // /jsp_241213_controllerTest/baseball.naver
		String conPath = request.getContextPath();
		System.out.println(conPath);  // /jsp_241213_controllerTest
		String com = uri.substring(conPath.length()); // uri 주소 앞에서 부터 conPath 길이만큼 삭제
		System.out.println(com); // /baseball.naver
		
		String viewPage = ""; //  실제 유저에게 전달될 jsp 파일의 이름이 들어갈 문자 변수
		if (com.equals("/baseball.naver")) {
			viewPage = "baseball.jsp";
		} else if (com.equals("/golf.naver")) {
			viewPage = "golf.jsp";
		} else if (com.equals("/soccer.naver")) {
			viewPage = "soccer.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage); // 실제 유저에게 jsp 파일을 전달하는 클래스
		dispatcher.forward(request, response); // viewPage 파일이름의 jsp 파일을 유저에게 전달
				
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	
}
