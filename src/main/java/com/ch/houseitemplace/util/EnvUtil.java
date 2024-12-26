package com.ch.houseitemplace.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class EnvUtil {

    @Autowired
    private Environment environment;
    public boolean isDevProfile() {
//        return environment.acceptsProfiles("dev");  // 判断是否为开发环境
        return true;
//        return false;
    }
}
