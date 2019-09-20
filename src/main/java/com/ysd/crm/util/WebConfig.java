package com.ysd.crm.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
@SpringBootConfiguration
public class WebConfig extends WebMvcConfigurationSupport {
	
		@Autowired
		private LoginInterceptor log;
		@Override
	    public void addInterceptors(InterceptorRegistry registry) {
	        // addPathPatterns("/**") 表示拦截所有的请求，
	        // excludePathPatterns("/login", "/register") 表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问
	        registry.addInterceptor(log).addPathPatterns("/**").excludePathPatterns("/checkCode", "/signin");
	        super.addInterceptors(registry);    //较新Spring Boot的版本中这里可以直接去掉，否则会报错
	    }
	
}
