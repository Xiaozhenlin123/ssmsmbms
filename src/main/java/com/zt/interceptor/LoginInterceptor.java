package com.zt.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request,
							 HttpServletResponse response, Object handler) throws Exception {
		//System.out.println("执行LoginInterceptor拦截器。。。");
		HttpSession session= request.getSession();
		if(session.getAttribute("us")==null){
			response.sendRedirect("index.jsp");
			return false;
		}
		//放行
		return true;
	}

}
