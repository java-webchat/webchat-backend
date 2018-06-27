package com.aichat.common.service;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.http.HttpUtil;
import com.aichat.common.util.ConstantsUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhengpeng on 2018/6/27.
 */
@Service
public class RobotService {


    /**
     * 机器人聊天
     * @param question
     * @param userId
     * @return
     */
    public String robotChat(String question,Integer userId) {
        String result = "你好呀～，我是机器人";

        JSONObject obj = new JSONObject();
        Map userMap = new HashMap();
        Map perceptionMap = new HashMap();
        Map inputTextMap = new HashMap();

        userMap.put("apiKey", ConstantsUtils.ROBOT_APP_KEY);
        userMap.put("userId",userId);
        inputTextMap.put("text",question);
        perceptionMap.put("inputText",inputTextMap);

        obj.put("perception",perceptionMap);
        obj.put("reqType",0);
        obj.put("userInfo",userMap);

        String responseStr = HttpUtil.createPost(ConstantsUtils.ROBOT_API_URL).charset(CharsetUtil.UTF_8).body(obj.toJSONString()).execute().body();
        System.out.println("机器人回调数据：" + responseStr);
        JSONObject jsonObj = JSONObject.parseObject(responseStr);
        if(null != jsonObj){
            JSONObject intentObj =  jsonObj.getJSONObject("intent");
            if(null != intentObj){
                JSONArray results = jsonObj.getJSONArray("results");
                result = results.getJSONObject(0).getJSONObject("values").getString("text");

            }

        }

        return result;
    }
}
