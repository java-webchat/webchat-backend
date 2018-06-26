package com.aichat.dao.genrated.dao;

import com.aichat.dao.genrated.model.GroupInfoEntity;
import com.aichat.dao.genrated.model.GroupInfoEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GroupInfoEntityMapper {
    long countByExample(GroupInfoEntityExample example);

    int deleteByExample(GroupInfoEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GroupInfoEntity record);

    int insertSelective(GroupInfoEntity record);

    List<GroupInfoEntity> selectByExample(GroupInfoEntityExample example);

    GroupInfoEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GroupInfoEntity record, @Param("example") GroupInfoEntityExample example);

    int updateByExample(@Param("record") GroupInfoEntity record, @Param("example") GroupInfoEntityExample example);

    int updateByPrimaryKeySelective(GroupInfoEntity record);

    int updateByPrimaryKey(GroupInfoEntity record);
}