package com.ch.houseitemplace.config.auth;

import com.ch.houseitemplace.filter.AuthenticationFilter;
import com.ch.houseitemplace.util.EnvUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


@Autowired
private AuthenticationFilter jwtAuthFilter; // 直接注入 JwtAuthFilter

    @Autowired
    private EnvUtil envUtil;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf().disable();  // 禁用 CSRF 防护，通常用于REST API

        // dev环境放行所有请求
        if(envUtil.isDevProfile()){
            http.authorizeRequests()
                    .anyRequest().permitAll(); // 允许所有请求
        }else {
            http.authorizeRequests()
                    .antMatchers("/login").permitAll() // 允许所有用户访问/login接口
                    .anyRequest().authenticated() // 其他请求需要认证
                    .and()
                    .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);  // 添加自定义的JWT认证过滤器
        }


        return http.build();
    }

}


