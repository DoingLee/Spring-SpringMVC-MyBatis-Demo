-- 数据库初始化脚本

-- 创建数据库
CREATE DATABASE user_db;
-- 使用数据库
use user_db;
-- 创建user表
CREATE TABLE user(
  `user_id` bigint NOT NULL COMMENT '用户id',
  `user_name` varchar(30) NOT NULL COMMENT '名字',
  key idx_user_id(user_id) COMMENT '为user_id创建索引',
  PRIMARY KEY (user_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- 初始化数据
insert into
  user(user_id, user_name)
values
  (1001, "张三");

-- 上线V1.0
