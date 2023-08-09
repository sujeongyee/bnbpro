package com.ddu.pro.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class UserAuthHandler implements HandlerInterceptor{



	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//세션 검사
		HttpSession session = request.getSession();
		if(session.getAttribute("userid")!=null) { //로그인이 된 사람
			
			return true;
		} else {//로그인이 안되어 있는 경우
			
			response.sendRedirect(request.getContextPath()+"/login");
			return false;
		}
		
	}
	
	
}
