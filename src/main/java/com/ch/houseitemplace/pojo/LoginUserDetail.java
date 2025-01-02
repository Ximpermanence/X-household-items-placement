package com.ch.houseitemplace.pojo;

import lombok.Data;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

@Data
public class LoginUserDetail implements UserDetails, CredentialsContainer {

    private Long id;

    private String age;


    private String username;

    private String password;


    private Set<GrantedAuthority> authorities;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    private boolean enabled;


    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }


    @Override
    public void eraseCredentials() {
        this.password = null;
    }

    /**
     * 获取系统用户
     *
     * @return
     */
    public static LoginUserDetail getSystemUser() {
        // TODO @Ximepmanence 系统用户不能注册
        LoginUserDetail loginUserDetail = new LoginUserDetail();
        loginUserDetail.setUsername("system");
        loginUserDetail.setId(-1L);
        return loginUserDetail;
    }
}
