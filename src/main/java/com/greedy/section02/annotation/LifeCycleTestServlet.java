package com.greedy.section02.annotation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 등록하고 싶은 서블릿 클래스 상단에 @WebServlet 어노테이션으로 서블릿을 등록하고 
 * 속성값으로 mapping url을 작성하여 xml을 대체할 수 있다. */
/* 여러 속성을 추가하려면 속성명을 적고 콤마로 나열한다.*/
/* 사용자의 요청이있었을때 객체가 생성되고 init 되었는데 우선순위 부여를 원하는 경우 
 * loadOnStartup 에 우선 순위를 지정하면 (낮을수록 우선 순위가 높다) 서버가 start될 때 
 * 인스턴스를 생성하고 init을 호출한다. */
@WebServlet(value="/annotation-lifecycle", loadOnStartup=1)
public class LifeCycleTestServlet extends HttpServlet{
	
	/* 메소드의 호출 횟수를 카운트 하기 위한 용도의 필드 */
	private int initCount = 1;
	private int serviceCount = 1;
	private int destroyCount = 1;
	
	@Override
	public void init() throws ServletException {
		System.out.println("annotation 매핑 inti()메소드 호출 : " +initCount++);
	}

	/* 서블릿의 요청이 일어났을 때 동작(수행)하는 메소드 */
	/* 서블릿 컨테이너에 의해 호출 되며 최초 요청시에는 init() 이후에 동작하고 두 번째 요청부터는 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("annotation 매핑 service() 메소드 호출 : " +serviceCount++);
	}

	/* 컨테이너가 종료 될 때 호출되는 메소드로 주로 자원을 반납하는 용도로 사용한다. */
	@Override
	public void destroy() {
		System.out.println("annotation 매핑 destroy() 메소드 호출 : " + destroyCount++);
	}
	
	/* was서버안에 서블릿을 관리하는 컨테이너가 있다. 다양한 요청을 매핑하는 용도이다. */
	//배포서술자 xml
	
	
	
		
	
}
