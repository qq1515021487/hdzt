package com.bnuz.interceptor;

import com.bnuz.commons.annotation.ActivityAccess;
import com.bnuz.commons.result.ErrorCode;
import com.bnuz.commons.result.Result;
import com.bnuz.commons.utils.JwtUtils;
import com.bnuz.entity.dto.ActivityDto;
import com.bnuz.repository.ActivityRepository;
import com.bnuz.service.activity.ActivityService;
import com.bnuz.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component("ActivityOperateInterceptor")
public class ActivityOperateInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private ActivityRepository activityRepository;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            // 将handler强转为HandlerMethod, 前面已经证实这个handler就是HandlerMethod
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            // 从方法处理器中获取出要调用的方法
            Method method = handlerMethod.getMethod();
            // 获取出方法上的Access注解
            ActivityAccess access = method.getAnnotation(ActivityAccess.class);
            if (access == null) {
                // 如果注解为null, 说明不需要拦截, 直接放过
                return true;
            }
            String token = request.getHeader("Authorization");
            String acid = request.getParameter("acid");
            ActivityDto activityDto = activityRepository.findByAcid(acid);
            if (activityDto == null) {
                Utils.printByJSON(response, Result.fail("不存在活动", ErrorCode.BAD_REQUEST));
                return false;
            }
            if (!activityDto.equals(JwtUtils.parseJWT(token).get("sub"))) {
                Utils.printByJSON(response, Result.fail("没有操作权限", ErrorCode.FORBIDDEN));
                return false;
            }
        }
        return true;
    }
}
