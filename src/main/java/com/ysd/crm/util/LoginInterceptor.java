package com.ysd.crm.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import io.jsonwebtoken.Claims;

@Component
public class LoginInterceptor implements HandlerInterceptor{
	 @Override
	    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
	            throws Exception {
	        // TODO Auto-generated method stub
	        
	    }

	    @Override
	    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
	            throws Exception {
	        // TODO Auto-generated method stub
	        
	    }

	    @Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
	        // TODO Auto-generated method stub
	        
	        // 获取session
	        // HttpSession session = request.getSession();
	        // 判断session里是否有用户信息
			/*
			 * if (session.getAttribute("employee") != null) { 
			 * // 如果有就正常执行 
			 * return true; 
			 * }
			 * else { 
			 * // 如果没有就跳转至登陆页面
			 * request.getRequestDispatcher("toSignin").forward(request, response); 
			 * }
			 */
	    	
	    	System.out.println("进入拦截器");
	    	
	    	String token = request.getParameter("token");
	    	System.out.println("token=" + token);
	    	
	    	if (TokenUtil.parserTonken(token).get("secretKey").equals("哈哈")) {
	    		return true;
	    	}
	        
	        return false;
	    }
}
