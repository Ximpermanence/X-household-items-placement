package com.ch.houseitemplace.util;

import com.ch.houseitemplace.auth.RedisAuthenticationService;
import com.ch.houseitemplace.pojo.LoginUserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Component
public class LoginUtil {

    @Autowired
    private RedisAuthenticationService redisAuthenticationService;

    public LoginUserDetail getLoginUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal == null) {
            return LoginUserDetail.getSystemUser();
        }
        // 获取HttpServletRequest对象
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        // 获取用户信息
        return redisAuthenticationService.getUserInfo(request.getHeader("Authorization").replace("Bearer ", ""));
    }
}
