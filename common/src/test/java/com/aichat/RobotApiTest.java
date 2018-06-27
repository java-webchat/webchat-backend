package com.aichat;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSON;
import com.aichat.common.util.ConstantsUtils;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhengpeng on 2018/6/27.
 */
public class RobotApiTest {

    @Test
    public void robotApiTest(){
        String quesiton = "你是谁";
        /*
        *
        * {
                "reqType":0,
                "perception": {
                    "inputText": {
                        "text": "附近的酒店"
                    },
                    "inputImage": {
                        "url": "imageUrl"
                    },
                    "selfInfo": {
                        "location": {
                            "city": "北京",
                            "province": "北京",
                            "street": "信息路"
                        }
                    }
                },
                "userInfo": {
                    "apiKey": "",
                    "userId": ""
                }
            }
        *
        *
        *
        * */

        JSONObject obj = new JSONObject();
        obj.put("reqType",0);
        Map userMap = new HashMap();
        Map perceptionMap = new HashMap();
        Map inputTextMap = new HashMap();

        userMap.put("apiKey",ConstantsUtils.ROBOT_APP_KEY);
        userMap.put("userId","284227");
        obj.put("userInfo",userMap);
        inputTextMap.put("text",quesiton);
        perceptionMap.put("inputText",inputTextMap);

        obj.put("perception",perceptionMap);
        System.out.println(obj.toJSONString());

        String result = HttpUtil.createPost(ConstantsUtils.ROBOT_API_URL).charset(CharsetUtil.UTF_8).body(obj.toJSONString()).execute().body();
        System.out.println(result);
    }
}
