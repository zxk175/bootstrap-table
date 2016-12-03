/*
Navicat MySQL Data Transfer

Source Server         : Local
Source Server Version : 50633
Source Host           : localhost:3306
Source Database       : ssm

Target Server Type    : MYSQL
Target Server Version : 50633
File Encoding         : 65001

Date: 2016-12-01 17:30:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `user_phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `user_email` varchar(255) DEFAULT NULL COMMENT '邮箱地址',
  `user_pwd` varchar(32) DEFAULT NULL COMMENT '加盐后用户密码',
  `user_sex` tinyint(4) DEFAULT NULL COMMENT '性别',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `is_delete` tinyint(4) DEFAULT NULL COMMENT '是否删除，0-未删除；1-已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=560 DEFAULT CHARSET=utf8 COMMENT='用户表';