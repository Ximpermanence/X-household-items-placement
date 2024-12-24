/*
package com.ch.houseitemplace.auth;

import cn.hutool.json.JSONUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {


    private final RedisAuthenticationService redisAuthenticationService;


    public CustomAuthenticationSuccessHandler(RedisAuthenticationService redisAuthenticationService) {
        this.redisAuthenticationService = redisAuthenticationService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        // 用户认证成功后，将 Authentication 存储到 Redis
        String token = redisAuthenticationService.saveAuthenticationToRedis(authentication);
        Object user = authentication.getPrincipal();
        String jsonStr = JSONUtil.toJsonStr(user);
        // 返回用户信息，也可以只返回token
        response.getWriter().write(jsonStr);

*/
/*        // 只返回token
        response.getWriter().write(token);*//*


//        response.sendRedirect("/home");
    }


}
*/
