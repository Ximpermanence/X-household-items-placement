package com.ch.houseitemplace.service.impl;

import com.ch.houseitemplace.pojo.entity.UserInfo;
import com.ch.houseitemplace.mapper.UserInfoMapper;
import com.ch.houseitemplace.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Ximpermanence
 * @since 2024-12-24
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

}
