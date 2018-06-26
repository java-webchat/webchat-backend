package com.aichat.controller;

/**
 * Created by zhengpeng on 2018/3/9.
 */

import com.aichat.common.Response;
import com.aichat.common.mvc.AuthPassport;
import com.aichat.common.service.UserService;
import com.aichat.dao.genrated.model.UserInfoEntity;
import com.aichat.dto.LoginInfoDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户接口
 */
@AuthPassport(value = false)
@Api(tags = "用户接口")
@RestController
@RequestMapping("user")
public class UserController extends  BaseController{

    final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @ApiOperation(value = "注册")
    @PostMapping("register")
    public Response<?> register(String loginCount,String pwd,String nickName){
        Map result = userService.register(loginCount,pwd,nickName);
        logger.info("注册信息：" + result);
        return success(result);
    }


    @ApiOperation(value = "登录")
    @PostMapping("login")
    public Response<?> login(String loginCount, String pwd){
        Map resultMap = this.getBaseResultMap();
        UserInfoEntity userInfoEntity = userService.getByLoginAccountAndPwd(loginCount,pwd);
        if(null != userInfoEntity){
            String jwt = userService.getJwtByUser(userInfoEntity);
            resultMap.put("access_token",jwt);
            resultMap.put("msg","登录成功");
            resultMap.put("status",true);
            return success(resultMap);
        }
        resultMap.put("msg","登录失败,用户不存在");
        return success(resultMap);
    }

    @ApiOperation(value = "登录信息")
    @GetMapping("loginInfo")
    public Response<?> loginInfo(){
        LoginInfoDto loginInfoDto = this.getLoginInfo();
        logger.info("注册信息：" + loginInfoDto);
        return success(loginInfoDto);
    }




}
