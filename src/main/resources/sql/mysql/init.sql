--liquibase formatted sql
--changeset Ximpermanence:202412201339
CREATE TABLE user_info (
   id INT AUTO_INCREMENT PRIMARY KEY COMMENT '用户ID，自动递增',
   username VARCHAR(50) NOT NULL UNIQUE COMMENT '用户名，唯一且不能为空',
   password VARCHAR(255) NOT NULL COMMENT '密码，不能为空，假设存储加密后的密码',
   email VARCHAR(100) UNIQUE COMMENT '邮箱，唯一',
   phone VARCHAR(20) COMMENT '手机号',
   nickname VARCHAR(50) COMMENT '昵称，选填',
   gender ENUM('male', 'female', 'other') DEFAULT 'other' COMMENT '性别，默认‘other’',
   birthday DATE COMMENT '生日，选填',
   register_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间，默认为当前时间',
   last_login_time TIMESTAMP NULL COMMENT '最后登录时间，选填',
   status ENUM('active', 'inactive', 'suspended') DEFAULT 'active' COMMENT '状态，默认‘active’',
   avatar_url VARCHAR(255) COMMENT '头像URL，选填',
   address TEXT COMMENT '地址，选填',
   notes TEXT COMMENT '备注，选填',
   create_time datetime    null comment '创建时间',
   create_by   varchar(50)         null comment '创建人',
   update_time datetime    null comment '修改时间',
   update_by   varchar(50)         null comment '修改人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '用户表';

--changeset Ximpermanence:202412301515
create table room
(
    id INT AUTO_INCREMENT PRIMARY KEY COMMENT 'ID，自动递增',
    name        varchar(50) not null comment '房间名',
    description text        null comment '描述',
    create_time datetime    null comment '创建时间',
    create_by   varchar(50)         null comment '创建人',
    update_time datetime    null comment '修改时间',
    update_by   varchar(50)         null comment '修改人',
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '房间';

--changeset Ximpermanence:202502071647
create table furniture
(
    id INT AUTO_INCREMENT PRIMARY KEY COMMENT 'ID，自动递增',
    name        varchar(50) not null comment '家具名',
    description text        null comment '描述',
    room_id INT        null comment '房间id',
    create_time datetime    null comment '创建时间',
    create_by   varchar(50)         null comment '创建人',
    update_time datetime    null comment '修改时间',
    update_by   varchar(50)         null comment '修改人',
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '家具';

create table item
(
    id INT AUTO_INCREMENT PRIMARY KEY COMMENT 'ID，自动递增',
    name        varchar(50) not null comment '物品名',
    description text        null comment '描述',
    room_id INT        null comment '房间id',
    furniture_id INT        null comment '家具id',
    create_time datetime    null comment '创建时间',
    create_by   varchar(50)         null comment '创建人',
    update_time datetime    null comment '修改时间',
    update_by   varchar(50)         null comment '修改人',
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '物品';
