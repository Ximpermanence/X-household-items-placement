package com.ch.houseitemplace.web.controller;

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

/*
    @Resource
    private RedisAuthenticationService redisAuthenticationService;
    @Resource
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public String loginPage(@RequestBody LoginUserDetail loginUserDetail) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUserDetail.getUsername(), loginUserDetail.getPassword());
        // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        String key = redisAuthenticationService.saveAuthenticationToRedis(authenticate);
        return key;

    }*/

/*    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        // 如果需要，可以在这里手动校验用户名密码
        return "home";  // 登录成功后重定向到主页
    }*/

/*    @Autowired
    private UserService userService; // 用于获取用户信息

        @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    */
    @Autowired
    private RedisAuthenticationService redisService; // 用于存储token


    // 用户登录接口
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
       /* LoginUserDetail user = userService.findByUsername(username); // 假设UserService能返回用户信息
        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }*/
        LoginUserDetail user = new LoginUserDetail();
        user.setUsername("admin");
        user.setPassword("admin");

        if (user == null || !Objects.equals(password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        // 生成JWT
        String token = JwtUtil.generateToken(username);

        // 存储token和用户信息到Redis
        redisService.storeToken(token, user.toString());

        return token;  // 返回JWT给前端
    }
}
