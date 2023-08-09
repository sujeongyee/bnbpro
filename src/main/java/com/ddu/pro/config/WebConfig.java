package com.ddu.pro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ddu.pro.util.interceptor.UserAuthHandler;

@Configuration 
public class WebConfig implements WebMvcConfigurer{ 
	
	
	
	@Bean
	public UserAuthHandler userAuthHandler() {
		return new UserAuthHandler();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(userAuthHandler())
				.addPathPatterns("/main")
				.addPathPatterns("/calendar")
				.addPathPatterns("/inquiry/**")
				.addPathPatterns("/lodgment/**")
				.addPathPatterns("/reservation/**")
				.addPathPatterns("/review/**")
				.addPathPatterns("/room/**")
				.excludePathPatterns("/join") 
				.excludePathPatterns("/login") 
				.excludePathPatterns("/loginForm"); 
		
	}
	
	
}
