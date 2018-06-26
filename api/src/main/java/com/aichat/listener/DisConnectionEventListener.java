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
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 关闭连接监听
 * Created by zhengpeng on 2018/6/10.
 */
@Component
public class DisConnectionEventListener implements ApplicationListener<SessionDisconnectEvent> {

    @Autowired
    WebApplicationContext applicationContext;

    private static final Logger LOGGER = LoggerFactory.getLogger(ConnectEventListener.class);

    /**
     * 关闭连接事件
     * @param sessionDisconnectEvent
     */
    @Override
    public void onApplicationEvent(SessionDisconnectEvent sessionDisconnectEvent) {

        StompHeaderAccessor headerAccessor =  StompHeaderAccessor.wrap(sessionDisconnectEvent.getMessage());

        //step2 普通c端用户存储到在线用户
        removeUserLoginInfo(headerAccessor.getMessageHeaders().get("simpSessionAttributes"));
    }

    private void removeUserLoginInfo(Object simpSessionAttributes) {

        if(null != simpSessionAttributes){
            Map<String,String> paramMap = (Map) simpSessionAttributes;
            //遍历map
            for (Map.Entry<String, String> entry : paramMap.entrySet()) {
                String key = entry.getKey();
                if("ACCESS_TOKEN".equals(key)){
                    String token = entry.getValue();
                    UserInfoEntity loginUser = JwtUtil.unsign(token,UserInfoEntity.class);
                    if(null != loginUser){
                        removeLoginUserToApplication(loginUser);
                    }
                }
            }
        }
    }

    private void removeLoginUserToApplication(UserInfoEntity loginUser) {

        Object userOnlineMapObj =  applicationContext.getServletContext().getAttribute("onlineuser");
        if(null != userOnlineMapObj){
            ConcurrentHashMap userOnlineMap = (ConcurrentHashMap) userOnlineMapObj;
            userOnlineMap.remove(loginUser.getId().toString());
            applicationContext.getServletContext().setAttribute("onlineuser",userOnlineMap);
        }else {
            ConcurrentHashMap userOnlineMap = new ConcurrentHashMap();
            userOnlineMap.remove(loginUser.getId().toString());
            applicationContext.getServletContext().setAttribute("onlineuser",userOnlineMap);

        }
        LOGGER.info("清除登录用户成功!");
    }


}
