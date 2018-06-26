package com.aichat.listener;

import com.aichat.common.util.JwtUtil;
import com.aichat.dao.genrated.model.UserInfoEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.socket.messaging.SessionConnectEvent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * websocket 连接监听
 */
@Component
public class ConnectEventListener implements ApplicationListener<SessionConnectEvent> {

	@Autowired
	WebApplicationContext applicationContext;

	private static final Logger LOGGER = LoggerFactory.getLogger(ConnectEventListener.class);

	public void onApplicationEvent(SessionConnectEvent event) {
		StompHeaderAccessor headerAccessor =  StompHeaderAccessor.wrap(event.getMessage());
		LOGGER.info("【ConnectEventListener监听器事件 类型】"+headerAccessor.getCommand().getMessageType());

		//
		saveUserLoginInfo(headerAccessor.getMessageHeaders().get("simpSessionAttributes"));


	}




	/**
	 *
	 * @param simpSessionAttributes
     */
	private void saveUserLoginInfo(Object simpSessionAttributes) {
		if(null != simpSessionAttributes){
			Map<String,String> paramMap = (Map) simpSessionAttributes;
			//遍历map
			for (Map.Entry<String, String> entry : paramMap.entrySet()) {
				String key = entry.getKey();
				if("ACCESS_TOKEN".equals(key)){
					String token = entry.getValue();
					UserInfoEntity loginUser = JwtUtil.unsign(token,UserInfoEntity.class);
					if(null != loginUser){
						saveLoginUserToApplication(loginUser);
					}
				}


			}

		}
	}

	private void saveLoginUserToApplication(UserInfoEntity loginUser) {

		Object onlineUserMapObj =  applicationContext.getServletContext().getAttribute("onlineuser");
		if(null != onlineUserMapObj){
			ConcurrentHashMap userOnlineMap = (ConcurrentHashMap) onlineUserMapObj;
			userOnlineMap.put(loginUser.getId().toString(),loginUser);
			applicationContext.getServletContext().setAttribute("onlineuser",userOnlineMap);
		}else {
			ConcurrentHashMap userOnlineMap = new ConcurrentHashMap();
			userOnlineMap.put(loginUser.getId().toString(),loginUser);
			applicationContext.getServletContext().setAttribute("onlineuser",userOnlineMap);

		}
		LOGGER.info("存储在线用户成功!");
	}


}
