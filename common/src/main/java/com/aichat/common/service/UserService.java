package com.aichat.common.service;

import com.aichat.common.util.EncryptAndDecryptUtils;
import com.aichat.common.util.JwtUtil;
import com.aichat.common.util.UserUtils;
import com.aichat.dao.genrated.dao.UserInfoEntityMapper;
import com.aichat.dao.genrated.model.UserInfoEntity;
import com.aichat.dao.genrated.model.UserInfoEntityExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhengpeng on 2018/3/6.
 */
@Service
public class UserService {

  static final int SECOND_1_DAYS = 7 * 24 * 3600 * 6 * 24;

  @Autowired
  UserInfoEntityMapper userInfoEntityMapper;


  public Map register(String loginCount, String pwd,String nickName) {
    Map result = new HashMap();
    result.put("status",false);
    result.put("msg","注册失败");

    //校验
    boolean countStatus = check(loginCount);
    if(!countStatus){
      result.put("msg","帐号不正确,请输入6-14位数数字和字母组合!");
      return result;
    }
    boolean pwdStatus = check(pwd);
    if(!pwdStatus){
      result.put("msg","密码正确，请输入6-14位数数字和字母组合!");
      return result;
    }
    UserInfoEntity userInfoEntity = getUserInfoByloginCount(loginCount);
    if(null != userInfoEntity){
      result.put("msg","帐号已经存在！");
      return result;
    }
    //新增
    userInfoEntity = new UserInfoEntity();
    userInfoEntity.setStatus(1);
    userInfoEntity.setCreateDate(new Date());
    userInfoEntity.setUpdateDate(new Date());
    userInfoEntity.setNickName(nickName);

    userInfoEntity.setAvator(UserUtils.getRodomAvatar());
    userInfoEntity.setLoginNum(loginCount);
    userInfoEntity.setPwd(EncryptAndDecryptUtils.md5Encrypt(pwd));
    userInfoEntityMapper.insert(userInfoEntity);
    result.put("msg","注册成功！");
    result.put("status",true);

    return result;
  }

  private UserInfoEntity getUserInfoByloginCount(String loginCount) {

    UserInfoEntityExample userInfoEntityExample  = new UserInfoEntityExample();
    userInfoEntityExample.createCriteria().andLoginNumEqualTo(loginCount);
    List<UserInfoEntity> lists = userInfoEntityMapper.selectByExample(userInfoEntityExample);
    if(!lists.isEmpty()){
      return lists.get(0);
    }
    return null;

  }

  private boolean check(String pwd) {
    boolean result = false;
    if(StringUtils.isNotBlank(pwd)){
      String reg="^[a-zA-Z0-9]{6,14}$";
      result = pwd.matches(reg);
    }
    return result ;
  }


  public UserInfoEntity getByLoginAccountAndPwd(String loginCount, String pwd) {
    UserInfoEntityExample userInfoEntityExample = new UserInfoEntityExample();
    userInfoEntityExample.createCriteria().andLoginNumEqualTo(loginCount).andPwdEqualTo(EncryptAndDecryptUtils.md5Encrypt(pwd));
    List<UserInfoEntity> lists = userInfoEntityMapper.selectByExample(userInfoEntityExample);
    if(!lists.isEmpty()){
      return lists.get(0);
    }
    return null;
  }

  public String getJwtByUser(UserInfoEntity userInfoEntity) {
    String jwt = JwtUtil.sign(userInfoEntity,SECOND_1_DAYS );

    return jwt;
  }
}
