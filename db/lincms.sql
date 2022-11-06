/*
MySQL Backup
Database: lin-cms
Backup Time: 2022-11-04 17:36:41
*/
CREATE DATABASE IF NOT EXISTS `lin-cms`;
USE `lin-cms`;
SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `lin-cms`.`dict`;
DROP TABLE IF EXISTS `lin-cms`.`dict_data`;
DROP TABLE IF EXISTS `lin-cms`.`lin_permission`;
DROP TABLE IF EXISTS `lin-cms`.`lin_role`;
DROP TABLE IF EXISTS `lin-cms`.`lin_role_permission`;
DROP TABLE IF EXISTS `lin-cms`.`lin_user`;
DROP TABLE IF EXISTS `lin-cms`.`lin_user_role`;
CREATE TABLE `dict` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '字典id',
  `dict_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字典码',
  `dict_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字典名称',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `deleted` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '是否已删除',
  `dict_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字典描述信息',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1587438924709629955 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;
CREATE TABLE `dict_data` (
  `id` int NOT NULL,
  `dict_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `dict_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `dict_value` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `deleted` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `data_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '数据描述信息',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;
CREATE TABLE `lin_permission` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(60) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `url` varchar(60) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `code` varchar(60) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `delete_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `name` (`name`) USING BTREE COMMENT '权限操作名'
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;
CREATE TABLE `lin_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '角色名',
  `note` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `status` tinyint NOT NULL COMMENT '1正常 0禁用',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `delete_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `role_name` (`role_name`) USING BTREE COMMENT '唯一角色'
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;
CREATE TABLE `lin_role_permission` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_id` int NOT NULL COMMENT '角色id',
  `permission_id` int NOT NULL COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;
CREATE TABLE `lin_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(24) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '用户名',
  `nickname` varchar(24) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '昵称',
  `password` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT 'MD5加密密码',
  `sex` tinyint DEFAULT NULL COMMENT '男(0) 女(1)',
  `salt` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '加盐',
  `email` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '邮箱',
  `avatar` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '头像地址',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `delete_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `username` (`username`) USING BTREE COMMENT 'username唯一标识'
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;
CREATE TABLE `lin_user_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL COMMENT '用户id',
  `role_id` int NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;
BEGIN;
LOCK TABLES `lin-cms`.`dict` WRITE;
DELETE FROM `lin-cms`.`dict`;
INSERT INTO `lin-cms`.`dict` (`id`,`dict_code`,`dict_name`,`create_time`,`update_time`,`deleted`,`dict_desc`) VALUES (1, 'cp_alarm_moude', '警告方式', NULL, NULL, NULL, '测试警告方式'),(2, 'sex', '性别', NULL, NULL, NULL, '性别数据字典');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `lin-cms`.`dict_data` WRITE;
DELETE FROM `lin-cms`.`dict_data`;
INSERT INTO `lin-cms`.`dict_data` (`id`,`dict_code`,`dict_key`,`dict_value`,`create_time`,`update_time`,`deleted`,`data_desc`) VALUES (1, 'cp_alarm_moude', '1', '系统告警', NULL, NULL, NULL, '系统异常'),(2, 'cp_alarm_moude', '2', '邮件告警', NULL, NULL, NULL, '邮件异常'),(3, 'cp_alarm_moude', '3', '短信告警', NULL, NULL, NULL, '短信异常'),(4, 'sex', '0', '男', NULL, NULL, NULL, '男性'),(5, 'sex', '1', '女', NULL, NULL, NULL, '女性');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `lin-cms`.`lin_permission` WRITE;
DELETE FROM `lin-cms`.`lin_permission`;
INSERT INTO `lin-cms`.`lin_permission` (`id`,`name`,`url`,`code`,`create_time`,`update_time`,`delete_time`) VALUES (1, '所有权限', '/*', '200', '2022-10-25 21:05:19', '2022-10-25 21:05:22', NULL);
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `lin-cms`.`lin_role` WRITE;
DELETE FROM `lin-cms`.`lin_role`;
INSERT INTO `lin-cms`.`lin_role` (`id`,`role_name`,`note`,`status`,`create_time`,`update_time`,`delete_time`) VALUES (1, 'admin', '管理者', 1, '2022-10-25 20:50:28', '2022-10-25 20:50:31', NULL),(2, 'tourist', '游客', 1, '2022-10-25 22:17:54', '2022-10-25 22:17:57', NULL);
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `lin-cms`.`lin_role_permission` WRITE;
DELETE FROM `lin-cms`.`lin_role_permission`;
INSERT INTO `lin-cms`.`lin_role_permission` (`id`,`role_id`,`permission_id`) VALUES (1, 1, 1);
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `lin-cms`.`lin_user` WRITE;
DELETE FROM `lin-cms`.`lin_user`;
INSERT INTO `lin-cms`.`lin_user` (`id`,`username`,`nickname`,`password`,`sex`,`salt`,`email`,`avatar`,`create_time`,`update_time`,`delete_time`) VALUES (1, 'admin', '管理员', '123456', 0, NULL, NULL, NULL, '2022-10-13 22:23:57', '2022-10-13 22:23:59', NULL),(2, 'test', 'test12345', '12345', 1, NULL, '1312342604@qq.com', '12345', '2022-10-23 20:01:46', '2022-10-23 20:01:50', NULL);
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `lin-cms`.`lin_user_role` WRITE;
DELETE FROM `lin-cms`.`lin_user_role`;
INSERT INTO `lin-cms`.`lin_user_role` (`id`,`user_id`,`role_id`) VALUES (1, 2, 1),(2, 2, 2);
UNLOCK TABLES;
COMMIT;
