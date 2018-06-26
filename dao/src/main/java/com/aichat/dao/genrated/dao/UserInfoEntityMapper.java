package com.aichat.dao.genrated.dao;

import com.aichat.dao.genrated.model.UserInfoEntity;
import com.aichat.dao.genrated.model.UserInfoEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserInfoEntityMapper {
    long countByExample(UserInfoEntityExample example);

    int deleteByExample(UserInfoEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserInfoEntity record);

    int insertSelective(UserInfoEntity record);

    List<UserInfoEntity> selectByExample(UserInfoEntityExample example);

    UserInfoEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserInfoEntity record, @Param("example") UserInfoEntityExample example);

    int updateByExample(@Param("record") UserInfoEntity record, @Param("example") UserInfoEntityExample example);

    int updateByPrimaryKeySelective(UserInfoEntity record);

    int updateByPrimaryKey(UserInfoEntity record);
}