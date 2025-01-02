package com.ch.houseitemplace.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author Ximpermanence
 * @since 2024-12-24
 */
@Getter
@Setter
@TableName("user_info")
@EqualsAndHashCode(callSuper = true)
public class UserInfo extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID，自动递增
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名，唯一且不能为空
     */
    private String username;

    /**
     * 密码，不能为空，假设存储加密后的密码
     */
    private String password;

    /**
     * 邮箱，唯一
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 昵称，选填
     */
    private String nickname;

    /**
     * 性别，默认‘other’
     */
    private String gender;

    /**
     * 生日，选填
     */
    private LocalDate birthday;

    /**
     * 注册时间，默认为当前时间
     */
    private LocalDateTime registerTime;

    /**
     * 最后登录时间，选填
     */
    private LocalDateTime lastLoginTime;

    /**
     * 状态，默认‘active’
     */
    private String status;

    /**
     * 头像URL，选填
     */
    private String avatarUrl;

    /**
     * 地址，选填
     */
    private String address;

    /**
     * 备注，选填
     */
    private String notes;
}
