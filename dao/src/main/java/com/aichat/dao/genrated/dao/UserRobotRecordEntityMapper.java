package com.aichat.dao.genrated.dao;

import com.aichat.dao.genrated.model.UserRobotRecordEntity;
import com.aichat.dao.genrated.model.UserRobotRecordEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRobotRecordEntityMapper {
    long countByExample(UserRobotRecordEntityExample example);

    int deleteByExample(UserRobotRecordEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserRobotRecordEntity record);

    int insertSelective(UserRobotRecordEntity record);

    List<UserRobotRecordEntity> selectByExample(UserRobotRecordEntityExample example);

    UserRobotRecordEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserRobotRecordEntity record, @Param("example") UserRobotRecordEntityExample example);

    int updateByExample(@Param("record") UserRobotRecordEntity record, @Param("example") UserRobotRecordEntityExample example);

    int updateByPrimaryKeySelective(UserRobotRecordEntity record);

    int updateByPrimaryKey(UserRobotRecordEntity record);
}