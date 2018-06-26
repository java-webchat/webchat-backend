package com.aichat.common.util;

import com.aichat.common.enums.DefaultAvatarEnums;

import java.util.Random;

/**
 * Created by zhengpeng on 2018/6/26.
 * 用户相关工具类
 */
public class UserUtils {

    /**
     * 生成随机头像
     * @return
     */
    public static String getRodomAvatar(){

        Random random = new Random();
        //[1-4]
        Integer randomNum = random.nextInt(3) + 1;
        String avatar = DefaultAvatarEnums.getSrcById(randomNum);
        return avatar;
    }

    public static void main(String[] args) {
        System.out.println(UserUtils.getRodomAvatar());
    }
}
