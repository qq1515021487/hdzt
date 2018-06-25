package com.bnuz.interceptor;


import com.bnuz.commons.constant.SystemConstant;
import com.bnuz.commons.entity.CheckResult;
import com.bnuz.commons.result.ErrorCode;
import com.bnuz.commons.result.Result;
import com.bnuz.commons.utils.JwtUtils;
import com.bnuz.utils.Utils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 用户登录管理
 *
 * @author: QuanQqqqq
 * @date: 2018-04-18
 */

@Component("LoginInterceptor")
public class LoginInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (handler instanceof HandlerMethod){
            // 拦截token
            String authHeader = request.getHeader("Authorization");
            if (StringUtils.isEmpty(authHeader)) {
                logger.info("验证失败");
                Utils.printByJSON(response, Result.fail("签名验证不存在", ErrorCode.UNAUTHORIZED));
                return false;
            } else {
                //验证JWT的签名，返回CheckResult对象
                CheckResult checkResult = JwtUtils.validateJWT(authHeader);
                if (checkResult.isSuccess()) {
                    return true;
                } else {
                    switch (checkResult.getErrCode()) {
                        // 签名验证不通过
                        case SystemConstant.JWT_ERRCODE_FAIL:
                            logger.info("签名验证不通过");
                            Utils.printByJSON(response, Result.fail("签名验证不通过", ErrorCode.UNAUTHORIZED));
                            break;
                        // 签名过期，返回过期提示码
                        case SystemConstant.JWT_ERRCODE_EXPIRE:
                            logger.info("签名过期");
                            Utils.printByJSON(response, Result.fail("签名过期", checkResult.getErrCode()));
                            break;
                        default:
                            break;
                    }
                    return false;
                }
            }
        }else{
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}