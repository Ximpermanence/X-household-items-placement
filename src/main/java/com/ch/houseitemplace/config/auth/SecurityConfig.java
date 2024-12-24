package com.ch.houseitemplace.config.auth;

import com.ch.houseitemplace.filter.AuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

/*    @Autowired
    private AuthenticationManagerBuilder authenticationManagerBuilder;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;

    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFilter authenticationFilter; // 注入过滤器

    @Autowired
    private MyAuthenticationProvider myAuthenticationProvider;*/
@Autowired
private AuthenticationFilter jwtAuthFilter; // 直接注入 JwtAuthFilter

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.formLogin().disable();
//        http
//                .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)  // 确保 AuthenticationFilter 先于认证过滤器执行
//                .authorizeRequests()
//                .antMatchers("/login", "/register").permitAll()
//                .antMatchers("/**/*.css","/**/*.js","/**/*.html").permitAll() // 静态资源放行
//                .anyRequest().authenticated()
//                .and()
//                .exceptionHandling()
//                .authenticationEntryPoint(authenticationEntryPoint())
//        ;
                        /*
                .and()
                .formLogin().disable()
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .successHandler(customAuthenticationSuccessHandler)
                .failureHandler(customAuthenticationFailureHandler)*/

    /*    http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/login").permitAll()  // 登录接口不需要认证
                .anyRequest().authenticated()      // 其他接口需要认证
                .and()
                .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);*/

        http.csrf().disable();  // 禁用 CSRF 防护，通常用于REST API

        // 调试时可以放行所有请求
        if(isDevProfile()){
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

/*
    @Bean
    public AuthenticationManager authenticationManager()
    {
        return new ProviderManager(myAuthenticationProvider);
    }


    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return (request, response, authException) -> {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication required");
        };
    }*/

    @Autowired
    private Environment environment;
    private boolean isDevProfile() {
//        return environment.acceptsProfiles("dev");  // 判断是否为开发环境
//        return true;
        return false;
    }
}


