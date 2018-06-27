package com.aichat.common.service;

import com.aichat.common.util.ConstantsUtils;
import com.aichat.dao.genrated.dao.GroupRecordEntityMapper;
import com.aichat.dao.genrated.dao.UserInfoEntityMapper;
import com.aichat.dao.genrated.dao.UserRobotRecordEntityMapper;
import com.aichat.dao.genrated.model.*;
import org.apache.commons.lang3.StringUtils;
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
    RobotService robotService;
    @Autowired
    GroupRecordEntityMapper groupRecordEntityMapper;
    @Autowired
    UserInfoEntityMapper userInfoEntityMapper;
    @Autowired
    UserRobotRecordEntityMapper userRobotRecordEntityMapper;

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

        //ID为0的用户为机器人

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


    public UserRobotRecordEntity robotChatTest(String question) {
        UserRobotRecordEntity result = new UserRobotRecordEntity();
        if(StringUtils.isNotBlank(question)){
            Integer userId = 1;
            //step1 封装请求
            String chatResponse = robotService.robotChat(question,userId);
            result.setNickName("机器人");
            result.setContent(chatResponse);
            result.setCreateDate(new Date());
            result.setId(userId);
            result.setSendAvatar("机器人头像");


        }
        return result;
    }

    public UserRobotRecordEntity bulidEntityAndSaveUserRecord(UserRobotRecordEntity userRobotRecordEntity) {

        if(null != userRobotRecordEntity){
            UserRobotRecordEntity result = new UserRobotRecordEntity();
            UserInfoEntity userInfoEntity = getUserInfoByUserId(userRobotRecordEntity.getSendId());
            result.setCreateDate(new Date());
            result.setSendAvatar(userInfoEntity.getAvator());
            result.setNickName(userInfoEntity.getNickName());
            result.setOwnerId(userRobotRecordEntity.getSendId());
            result.setContent(userRobotRecordEntity.getContent());
            result.setSendId(userRobotRecordEntity.getSendId());
            userRobotRecordEntityMapper.insert(result);
            return result;
        }
        return null;


    }

    /**
     * 机器人对话
     * @param dbUserRecordEntity
     * @return
     */
    public UserRobotRecordEntity bulidEntityAndSaveRobotRecord(UserRobotRecordEntity dbUserRecordEntity) {

        String answer = robotService.robotChat(dbUserRecordEntity.getContent(),dbUserRecordEntity.getOwnerId());
        UserRobotRecordEntity robotRecord = new UserRobotRecordEntity();
        UserInfoEntity robot = getUserInfoByUserId(ConstantsUtils.ROBOT_ID);
        robotRecord.setOwnerId(dbUserRecordEntity.getOwnerId());
        robotRecord.setNickName(robot.getNickName());
        robotRecord.setSendAvatar(robot.getAvator());
        robotRecord.setSendId(robot.getId());
        robotRecord.setCreateDate(new Date());
        robotRecord.setContent(answer);
        userRobotRecordEntityMapper.insert(robotRecord);
        return robotRecord;
    }

    /**
     * 机器人聊天列表
     * @param userId
     * @return
     */
    public List<UserRobotRecordEntity> getRobotList(Integer userId) {
        List<UserRobotRecordEntity> result = new ArrayList<UserRobotRecordEntity>();
        UserRobotRecordEntityExample userRobotRecordEntityExample = new UserRobotRecordEntityExample();
        userRobotRecordEntityExample.createCriteria().andOwnerIdEqualTo(userId);
        result = userRobotRecordEntityMapper.selectByExample(userRobotRecordEntityExample);
        return result;
    }
}
