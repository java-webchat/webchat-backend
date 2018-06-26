package com.aichat.common.service;

import com.aichat.dao.genrated.dao.GroupInfoEntityMapper;
import com.aichat.dao.genrated.dao.GroupRecordEntityMapper;
import com.aichat.dao.genrated.model.GroupInfoEntity;
import com.aichat.dao.genrated.model.GroupInfoEntityExample;
import com.aichat.dao.genrated.model.GroupRecordEntity;
import com.aichat.dao.genrated.model.GroupRecordEntityExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhengpeng on 2018/6/18.
 */
@Service
public class GroupService {

    @Autowired
    GroupInfoEntityMapper groupInfoEntityMapper;


    public GroupInfoEntity currentGroupInfo(){
        GroupInfoEntityExample groupInfoEntityExample = new GroupInfoEntityExample();
        groupInfoEntityExample.createCriteria();
        List<GroupInfoEntity> lists =  groupInfoEntityMapper.selectByExample(groupInfoEntityExample);
        if(!lists.isEmpty()){
            return lists.get(0);
        }
        return null;
    }
}
