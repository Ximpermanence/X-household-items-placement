/*
package com.ch.houseitemplace.auth;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  */
/*  @Autowired
    private UserRepository userRepository;  // 假设你有一个 JPA 仓库用于访问数据库

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

           // 查询数据库中的用户信息
        UserEntity userEntity = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        // 返回 Spring Security 的 UserDetails 实现类
        return User.builder()
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())  // 从数据库获取加密后的密码
                .authorities(userEntity.getRoles().stream().map(role -> role.getName()).toArray(String[]::new))
                .build();
    }*//*


        @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        username = "admin";
        String password = "admin";
        return User.builder()
                .username(username)
                .password(password)
                .build();

    }
}
*/
