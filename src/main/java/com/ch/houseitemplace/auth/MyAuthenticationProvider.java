/*
package com.ch.houseitemplace.auth;

import com.ch.houseitemplace.pojo.LoginUserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

    // ~ Instance Fields
    // -----------------------------------------------------------------------------------------------------------------

    @Autowired
    private CustomUserDetailsService userDetailsService;

    private  PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // ~ Override Methods
    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 获取用户输入的用户名和密码
        final String username = authentication.getName();
        final String password = authentication.getCredentials().toString();

        // 获取封装用户信息的对象(也可自定义获取用户的相关信息)
//        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        // 这里可以做一些自定义的校验操作，当然也可以在 userDetailsServiceImpl.loadUserByUsername()中做
        UserDetails userDetails = new LoginUserDetail(); // 假定从数据库中取

        // 进行密码的比对
        boolean flag = passwordEncoder.matches(password, userDetails.getPassword());
        // 校验通过
        if (flag) {
            // 将权限信息也封装进去
            return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
        }

        throw new AccessDeniedException("密码错误");
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
*/
/*

myAuthenticationProvider不能依赖 自己注入的bean
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
*//*


}
*/
