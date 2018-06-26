package com.aichat.controller;

import com.aichat.common.Response;
import com.aichat.common.service.ChatService;
import com.aichat.dao.genrated.model.GroupRecordEntity;
import com.aichat.dao.genrated.model.UserInfoEntity;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by zhengpeng on 2018/6/15.
 */
@Api(tags = "对话接口")
@RestController
@RequestMapping("chat")
public class ChatController extends BaseController {

    @Autowired
    ChatService chatService;
    @Autowired
    SimpMessagingTemplate messagingTemplate;

    @ApiOperation(value = "聊天室列表")
    @PostMapping("chatroomlist")
    public Response<?> chatroomlist(){
        List<GroupRecordEntity> groupList = chatService.getChatRoomList();
        return success(groupList);
    }


    @ApiOperation(value = "在线列表")
    @PostMapping("onlinelist")
    public Response<?> onlinelist(){
        List<UserInfoEntity> onlineList = chatService.getOnlineList();
        return success(onlineList);
    }

    @MessageMapping("/chatroom")
    public void chatroom(String chatStr){

        logger.info("在线聊天信息：" + chatStr);
        if(StringUtils.isNotBlank(chatStr)){
            //step1 存储消息到记录库
            JSONObject obj  = JSON.parseObject(chatStr);
            GroupRecordEntity groupRecordEntity = JSONObject.toJavaObject(obj,GroupRecordEntity.class);
            GroupRecordEntity dbGroupRecordEntity = chatService.bulidEntityAndSaveGroupRecord(groupRecordEntity);
            //转发
            fowardChatRoomMsg(dbGroupRecordEntity);

        }

    }

    private void fowardChatRoomMsg(GroupRecordEntity dbGroupRecordEntity) {

        messagingTemplate.convertAndSend("/topic/chatroom/" ,dbGroupRecordEntity);
    }


}
