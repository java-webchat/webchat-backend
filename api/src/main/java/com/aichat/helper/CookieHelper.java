package com.aichat.helper;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhengpeng on 2018/6/15.
 */
public class CookieHelper {

    public static void addCookieByDomain(HttpServletRequest request, HttpServletResponse response, String name,
                                         String value, int maxAge) {
        String domain = RequestHelper.getMainHostName(request);
        if ("upstream_api".equals(domain)) {
            //domain = "xxx.com";
        }
        if ("upstream_chatapi".equals(domain)) {
            //domain = "local.betago2016.com";
            //domain = "chat.wtfcoder.com";
        }
        /**/
        System.out.println("domain:" + domain);
        addCookieByDomain(response, domain, name, value, maxAge);
    }

    /**
     * 设置cookie
     *
     * @param response
     * @param name     cookie名字
     * @param value    cookie值
     * @param maxAge   cookie生命周期 以秒为单位
     */
    public static void addCookieByDomain(HttpServletResponse response, String domain, String name, String value,
                                         int maxAge) {
        System.out.println("save cookie");
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setDomain(domain);
        if (maxAge > 0) {
            cookie.setMaxAge(maxAge);
        }
        System.out.println("save cookie:" + cookie);
        response.addCookie(cookie);
    }

    /**
     * 根据名字获取cookie
     *
     * @param request
     * @param name    cookie名字
     * @return
     */
    public static Cookie getCookieByName(HttpServletRequest request, String name) {
        Map<String, Cookie> cookieMap = readCookieMap(request);
        if (cookieMap.containsKey(name)) {
            Cookie cookie = (Cookie) cookieMap.get(name);
            return cookie;
        } else {
            return null;
        }
    }

    /**
     * 根据名字获取cookie value
     *
     * @param request
     * @param name    cookie名字
     * @return
     */
    public static String getCookieValueByName(HttpServletRequest request, String name) {
        Cookie cookie = getCookieByName(request, name);
        if (cookie != null) {
            return cookie.getValue();
        } else {
            return null;
        }
    }

    /**
     * 删除cookie
     *
     * @param response
     * @param name
     */
    public static void deleteCookieByName(HttpServletResponse response, String name) {

        Cookie cookie = new Cookie(name, null);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        Cookie cookie2 = new Cookie(name, null);
        cookie2.setPath("/");
        cookie2.setMaxAge(0);
        cookie2.setDomain(".xxx.com");
        response.addCookie(cookie2);
    }

    /**
     * 删除cookie
     *
     * @param response
     * @param name
     */
    public static void deleteCookieByNameAndDomain(HttpServletResponse response, String domain, String name) {
        //强制设置domain为http://wxp.xxx.com
        if ("upstream_api".equals(domain)) {
            domain = "xxx.com";
        }
        if ("upstream_sh_api".equals(domain)) {
            domain = "xxx.com";
        }
        Cookie cookie = new Cookie(name, null);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        cookie.setDomain(domain);
        response.addCookie(cookie);

        Cookie cookie2 = new Cookie(name, null);
        cookie2.setPath("/");
        cookie2.setMaxAge(0);
        cookie2.setDomain(domain);
        response.addCookie(cookie2);
    }

    /**
     * 将cookie封装到Map里面
     *
     * @param request
     * @return
     */
    private static Map<String, Cookie> readCookieMap(HttpServletRequest request) {
        Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }

}
