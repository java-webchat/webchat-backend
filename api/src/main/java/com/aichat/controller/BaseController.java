package com.aichat.controller;

import com.aichat.common.ApiConfig;
import com.aichat.common.Response;
import com.aichat.common.ResponseGenerator;
import com.aichat.common.util.JwtUtil;
import com.aichat.dao.genrated.model.UserInfoEntity;
import com.aichat.dto.LoginInfoDto;
import com.aichat.helper.CookieHelper;
import com.aichat.helper.RequestHelper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


/**
 *
 */
public abstract class BaseController {
    protected Logger logger = LoggerFactory.getLogger(getClass().getName());

    static final int SECOND_1_DAYS = 7 * 24 * 3600 * 6 * 24;
    //static final int SECOND_1_DAYS = 7 * 24 * 3600 * 6 /6 /10;

    protected Response success() {
        return ResponseGenerator.genResult();
    }

    protected <T> Response<T> success(T data) {
        return ResponseGenerator.genResult(data);
    }

    protected <T> Response<T> success(String message, T data) {
        return ResponseGenerator.genResult(message, data);
    }

    /**
     * 登录信息生成jwt 存储到cookie
     * @param request
     * @param response
     * @param userInfoEntity
     */
    protected void saveLoginCookie(HttpServletRequest request, HttpServletResponse response, UserInfoEntity userInfoEntity){

        String jwt = JwtUtil.sign(userInfoEntity,SECOND_1_DAYS );
        logger.info("存储登录jwt信息到cookie的jwt:" + jwt);
        CookieHelper.addCookieByDomain(request, response, ApiConfig.ACCESS_TOKEN, jwt, SECOND_1_DAYS);

    }

    protected LoginInfoDto getLoginInfo(){

        HttpServletRequest request = this.getCurrentRequest();
        String jwt = CookieHelper.getCookieValueByName(request, ApiConfig.ACCESS_TOKEN);
        if(StringUtils.isNotBlank(jwt)){
            UserInfoEntity userInfoEntity = JwtUtil.unsign(jwt,UserInfoEntity.class);
            if(null != userInfoEntity){
                LoginInfoDto loginInfoDto = new LoginInfoDto();
                BeanUtils.copyProperties(userInfoEntity,loginInfoDto);
                loginInfoDto.setUserId(userInfoEntity.getId());
                loginInfoDto.setNickName(userInfoEntity.getNickName());
                return loginInfoDto;
            }
        }
        logger.info("登录信息为null");
        return null;

    }

    public HttpServletRequest getCurrentRequest() {
        return RequestHelper.getCurrentRequst();
    }


    protected Map getBaseResultMap(){
        Map resultMap = new HashMap();
        resultMap.put("status",false);
        resultMap.put("msg","");
        return resultMap;
    }
}
