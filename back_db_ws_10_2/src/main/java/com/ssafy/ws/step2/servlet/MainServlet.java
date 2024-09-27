package com.ssafy.ws.step2.servlet;

import java.io.IOException;
import java.net.Authenticator.RequestorType;

import org.w3c.dom.bootstrap.DOMImplementationRegistry;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//이 서블릿이 호출되기 위해서는 url 상에 http://server_ip:port/context_name/main 이 필요하다.

@WebServlet("/main")
public class MainServlet extends HttpServlet{
	
	
	/**
	 * get 방식의 요청에 대해 응답하는 메서드.
	 * 프론트 컨트롤러 패턴 적용 내부 procces 호출
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		process(request, response);
	}
	
	/**
	 * request 객체에서 act 파라미터를 추출해서 실제 비즈니스 로직 메서드 
	 * doRegist
	 * 
	 * attribute = 뷰 매개변수 가져옴
	 * Parameter = 클라이언트 HTML 페이지에서 필요한  얻음정보 
	 */
	
	private void process(HttpServletRequest request, HttpServletResponse response) {
		String act = request.getParameter("act");
		switch (act) {
			case "regist":
				doRegist(request,response);
				break;
		
		}
		
	}
	/**
	 * 사용자 정보를 등록하기 위해 파라미터가 잘 전달되는지 확인 전달 결과 화면에 출력
		이를 위해 request에서 전달받은 내용을 추출하여 User 객체를 생성후 response로 출력
	 */

	private void doRegist(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String title = request.getParameter("password");
		String director = request.getParameter("director");
		String genre = request.getParameter("genre");
		String runningTime = request.getParameter("runningTime");
		
		
	}
	
	
	
	
	
	
	
}
