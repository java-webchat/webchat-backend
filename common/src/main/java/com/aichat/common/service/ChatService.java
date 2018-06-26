package com.aichat.common.service;

import com.aichat.dao.genrated.dao.GroupRecordEntityMapper;
import com.aichat.dao.genrated.dao.UserInfoEntityMapper;
import com.aichat.dao.genrated.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zhengpeng on 2018/6/18.
 */
@Service
public class ChatService {

    protected Logger LOGGER = LoggerFactory.getLogger(getClass().getName());

    @Autowired
    WebApplicationContext applicationContext;

    @Autowired
    GroupService groupService;
    @Autowired
    UserService userService;
    @Autowired
    GroupRecordEntityMapper groupRecordEntityMapper;
    @Autowired
    UserInfoEntityMapper userInfoEntityMapper;

    /**
     * 拼装实体消息入库
     * @param groupRecordEntity
     */
    public GroupRecordEntity bulidEntityAndSaveGroupRecord(GroupRecordEntity groupRecordEntity) {
        if(null != groupRecordEntity){
            GroupInfoEntity groupInfoEntity = groupService.currentGroupInfo();
            UserInfoEntity userInfoEntity = getUserInfoByUserId(groupRecordEntity.getSendId());
            groupRecordEntity.setCreateDate(new Date());
            groupRecordEntity.setGroupId(groupInfoEntity.getId());
            groupRecordEntity.setSendAvatar(userInfoEntity.getAvator());
            groupRecordEntity.setNickName(userInfoEntity.getNickName());
            groupRecordEntityMapper.insert(groupRecordEntity);
            return groupRecordEntity;
        }
        return null;
    }

    private UserInfoEntity getUserInfoByUserId(Integer userId) {

        UserInfoEntityExample userInfoEntityExample = new UserInfoEntityExample();
        userInfoEntityExample.createCriteria().andIdEqualTo(userId);
        List<UserInfoEntity> lists = userInfoEntityMapper.selectByExample(userInfoEntityExample);
        if(!lists.isEmpty()){
            return lists.get(0);
        }
        return null;
    }

    public List<GroupRecordEntity> getChatRoomList() {
        GroupRecordEntityExample groupRecordEntityExample = new GroupRecordEntityExample();
        List<GroupRecordEntity> result = new ArrayList<GroupRecordEntity>();
        result = groupRecordEntityMapper.selectByExample(groupRecordEntityExample);
        return result;
    }

    public List<UserInfoEntity> getOnlineList() {


        Object onlineMapObj = applicationContext.getServletContext().getAttribute("onlineuser");
        if(null != onlineMapObj){
            ConcurrentHashMap onlineMap = (ConcurrentHashMap) onlineMapObj;
            LOGGER.info("在线用户map。。。。：" + onlineMap);
        }
        return new ArrayList<UserInfoEntity>();
    }
}
