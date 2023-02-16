package com.greedy.section01.xml;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycleTestServlet extends HttpServlet{

	private int initCount = 1;
	private int serviceCount = 1;
	private int destroyCount = 1;
	
	/* 오버라이드 소스 경로를 통해 오버라이드 할 메소드를 선택함 */
	/* 서블릿의 요청이 최초인 경우 한 번 동작하는 메소드 */
	@Override
	public void init() throws ServletException {
		
		/* 메소드의 호출 횟수를 카운트 하기 위한 용도의 필드 */
		System.out.println("xml 매핑 inti()메소드 호출 : " +initCount++);
		
	}

	/* 서블릿의 요청이 일어났을 때 동작(수행)하는 메소드 */
	/* 서블릿 컨테이너에 의해 호출 되며 최초 요청시에는 init() 이후에 동작하고 두 번째 요청부터는 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("xml 매핑 service() 메소드 호출 : " +serviceCount++);
	}

	/* 컨테이너가 종료 될 때 호출되는 메소드로 주로 자원을 반납하는 용도로 사용한다. */
	@Override
	public void destroy() {
		System.out.println("xml 매핑 destroy() 메소드 호출 : " + destroyCount++);
	}
	
	/* was서버안에 서블릿을 관리하는 컨테이너가 있다. 다양한 요청을 매핑하는 용도이다. */
	//배포서술자 xml
	
	
	
		
	
}
