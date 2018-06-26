package com.aichat.interceptor;

import com.aichat.common.ApiConfig;
import com.aichat.common.mvc.AuthPassport;
import com.aichat.common.util.JwtUtil;
import com.aichat.dao.genrated.model.UserInfoEntity;
import com.aichat.exception.ApiErrorEnum;
import com.aichat.exception.ApiUnauthorizedException;
import com.aichat.helper.CookieHelper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 登录拦截器 <br>
 * 1. 验证登录
 *
 */
public class LoginInterceptor implements HandlerInterceptor, Ordered {

	private static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
			HandlerMethod handlerMethod = ((HandlerMethod) handler);

			// 没登录成功检测是否需要登陆验证
			// 目前默认都需要验证登录
			if (!this.needAuthPassport(request, handlerMethod)) {
				return true;
			} else {

				String accessToken = CookieHelper.getCookieValueByName(request, ApiConfig.ACCESS_TOKEN);
				if (StringUtils.isNotBlank(accessToken)) {
					try {
						boolean signed = false;
						try {
							UserInfoEntity userInfoEntity = JwtUtil.unsign(accessToken, UserInfoEntity.class);
							if(null != userInfoEntity){
								logger.info("当前登录信息："   +  userInfoEntity);
								signed = true;
							}
						} catch (Exception e) {
							//TODO 抛出异常 校验失败异常 token过期异常
							logger.warn("验签失败: " + e);
						}
						//验签成功 校验来自那个系统


						return signed;
					} catch (Exception e) {
						logger.error(String.format("验签错误: %s", accessToken), e);
					}
				}
			}

			throw new ApiUnauthorizedException(ApiErrorEnum.Request.Unauthorized.getCode(),
					ApiErrorEnum.Request.Unauthorized.getMessage());
		}

		return true;
	}


	/**
	 * 验证方法或类是否需要登陆
	 *
	 * @param handlerMethod
	 * @return
	 */
	private boolean needAuthPassport(HttpServletRequest request, HandlerMethod handlerMethod) {

		if (request.getRequestURI().startsWith("//swagger-resources")
				|| request.getRequestURI().startsWith("/swagger-resources")) {
			return false;
		}

		AuthPassport authPassport = handlerMethod.getMethodAnnotation(AuthPassport.class);
		// 函数注解
		if (authPassport != null) {
			return authPassport.value();
		}

		Object controller = handlerMethod.getBean();
		AuthPassport authPassportInController = controller.getClass().getAnnotation(AuthPassport.class);
		// 类注解
		if (authPassportInController != null) {
			return authPassportInController.value();
		}

		// 默认
		boolean needAuth = true;
		return needAuth;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
						   ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

	@Override
	public int getOrder() {
		return 1;
	}

}
