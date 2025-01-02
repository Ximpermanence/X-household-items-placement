package com.ch.houseitemplace.web.controller;

import cn.hutool.json.JSONUtil;
import com.ch.houseitemplace.auth.RedisAuthenticationService;
import com.ch.houseitemplace.pojo.LoginUserDetail;
import com.ch.houseitemplace.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

// 自定义登录控制器
@RestController
@RequestMapping("/")
public class LoginController {

    @Autowired
    private RedisAuthenticationService redisService; // 用于存储token


    // 用户登录接口
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
       /* LoginUserDetail user = userService.findByUsername(username); // 假设UserService能返回用户信息
        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }*/
        // TODO 查库 加密密码 转换对象
        LoginUserDetail user = new LoginUserDetail();
        user.setUsername("admin");
        user.setPassword("admin");

        if (user == null || !Objects.equals(password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        // 生成JWT
        String token = JwtUtil.generateToken(username);

        // 存储token和用户信息到Redis
        redisService.storeToken(token, JSONUtil.toJsonStr(user));

        return token;  // 返回JWT给前端
    }
}
