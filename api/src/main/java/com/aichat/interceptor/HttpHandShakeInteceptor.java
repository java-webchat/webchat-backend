package com.aichat.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.util.Map;


public class HttpHandShakeInteceptor implements HandshakeInterceptor {

	private static final Logger LOGGER = LoggerFactory.getLogger(HttpHandShakeInteceptor.class);


	@Override
	public boolean beforeHandshake(ServerHttpRequest request,
								   ServerHttpResponse response, WebSocketHandler wsHandler,
								   Map<String, Object> attributes) throws Exception {

		LOGGER.info("【握手拦截器】beforeHandshake");

		if(request instanceof ServletServerHttpRequest) {
			ServletServerHttpRequest servletRequest = (ServletServerHttpRequest)request;
			Cookie[] cookies = servletRequest.getServletRequest().getCookies();
			//cookie存入attributes中
			if(null != cookies){
				for (Cookie cookie : cookies) {
					attributes.put(cookie.getName(),cookie.getValue());
				}
			}

		}
		
		return true;
	}

	
	
	@Override
	public void afterHandshake(ServerHttpRequest request,
							   ServerHttpResponse response, WebSocketHandler wsHandler,
							   Exception exception) {
		LOGGER.info("【握手拦截器】afterHandshake");
		
		if(request instanceof ServletServerHttpRequest) {
			ServletServerHttpRequest servletRequest = (ServletServerHttpRequest)request;
			HttpSession session =  servletRequest.getServletRequest().getSession();
			String sessionId = session.getId();
			LOGGER.info("【握手拦截器】afterHandshake sessionId="+sessionId);
		}
		
		
		
	}

}
