/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : iopush

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2015-07-02 22:22:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_channel`
-- ----------------------------
DROP TABLE IF EXISTS `t_channel`;
CREATE TABLE `t_channel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `dir` varchar(100) DEFAULT NULL,
  `isDel` int(11) DEFAULT '0',
  `createTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_channel
-- ----------------------------
INSERT INTO `t_channel` VALUES ('3', '美食', 'meishi', '0', '2015-06-23 23:43:46');
INSERT INTO `t_channel` VALUES ('4', '经济', 'jingji', '0', '2015-06-23 23:42:33');
INSERT INTO `t_channel` VALUES ('5', '', '', '0', '2015-06-26 08:30:19');
INSERT INTO `t_channel` VALUES ('6', '', '', '0', '2015-06-26 08:34:51');
INSERT INTO `t_channel` VALUES ('7', '', '', '0', '2015-06-26 08:36:34');
INSERT INTO `t_channel` VALUES ('8', '', '', '0', '2015-06-26 08:41:15');
INSERT INTO `t_channel` VALUES ('9', '', '', '1', '2015-06-26 20:12:26');
INSERT INTO `t_channel` VALUES ('10', '', '', '1', '2015-06-26 20:12:25');
INSERT INTO `t_channel` VALUES ('11', '', '', '1', '2015-06-26 20:12:25');
INSERT INTO `t_channel` VALUES ('12', '', '', '1', '2015-06-26 20:12:24');
INSERT INTO `t_channel` VALUES ('13', '', '', '1', '2015-06-26 20:12:24');
INSERT INTO `t_channel` VALUES ('14', '', '', '1', '2015-06-26 20:12:24');
INSERT INTO `t_channel` VALUES ('15', '', '', '1', '2015-06-26 20:12:23');
INSERT INTO `t_channel` VALUES ('16', '', '', '1', '2015-06-26 20:12:23');
INSERT INTO `t_channel` VALUES ('17', '', '', '1', '2015-06-26 20:12:27');
INSERT INTO `t_channel` VALUES ('18', '', '', '1', '2015-06-26 20:12:22');

-- ----------------------------
-- Table structure for `t_function`
-- ----------------------------
DROP TABLE IF EXISTS `t_function`;
CREATE TABLE `t_function` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `pid` bigint(20) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `action` varchar(50) DEFAULT NULL,
  `param` varchar(100) DEFAULT NULL,
  `isGroup` int(11) DEFAULT '0',
  `isDel` int(11) DEFAULT '0',
  `createTime` timestamp NULL DEFAULT NULL,
  `updateTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_function
-- ----------------------------
INSERT INTO `t_function` VALUES ('1', '0', '文章管理', '/adm/article/list', '', '1', '1', '2015-06-25 21:55:08', '2015-06-25 22:30:57');
INSERT INTO `t_function` VALUES ('2', '0', '栏目管理', '/adm/channel', '', '1', '1', '2015-06-25 22:40:00', '2015-06-29 23:27:09');

-- ----------------------------
-- Table structure for `t_media`
-- ----------------------------
DROP TABLE IF EXISTS `t_media`;
CREATE TABLE `t_media` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `desc` varchar(100) DEFAULT NULL,
  `siteUrl` varchar(50) DEFAULT NULL,
  `logoUrl` varchar(50) DEFAULT NULL,
  `isDel` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_media
-- ----------------------------

-- ----------------------------
-- Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '',
  `description` varchar(50) DEFAULT '',
  `funcId` varchar(100) DEFAULT '',
  `createTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('3', '测试角色', 'cc', '2,3', '2015-06-29 23:39:51');
INSERT INTO `t_role` VALUES ('4', '财经呯到', '', 'sfas', '2015-06-29 23:41:02');
INSERT INTO `t_role` VALUES ('5', '生活频道编辑角色', '生活频道编辑角色', '242,232', '2015-06-29 23:42:59');

-- ----------------------------
-- Table structure for `t_subject`
-- ----------------------------
DROP TABLE IF EXISTS `t_subject`;
CREATE TABLE `t_subject` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `category` varchar(200) DEFAULT NULL,
  `pid` bigint(20) DEFAULT '0',
  `priority` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `templateId` bigint(20) DEFAULT NULL,
  `channelId` bigint(20) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `tags` varchar(500) DEFAULT NULL,
  `isDel` int(11) DEFAULT '0',
  `shortName` varchar(100) DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT NULL,
  `updateTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_subject
-- ----------------------------
INSERT INTO `t_subject` VALUES ('1', '新闻', '', '-1', '-1', null, '-1', null, '-1', 'fdfas', '', '1', '', null, null);
INSERT INTO `t_subject` VALUES ('2', 'fsdfasf', '', '22', '-1', null, '-1', null, '-1', 'dsaf', '', '1', 'df', '2015-06-24 23:33:10', null);
INSERT INTO `t_subject` VALUES ('3', 'fdsfsaf', '', '-1', '-1', null, '-1', null, '-1', 'daf', '', '1', '', '2015-06-24 23:43:41', null);
INSERT INTO `t_subject` VALUES ('4', '', '1', '1', '1', null, '1', null, '12', 'fdsfas', 'dfd', '1', 'ddd', '2015-06-25 08:20:53', null);
INSERT INTO `t_subject` VALUES ('5', 'aaaaaaaaaaaaaaa', '', '2', '-1', '0', '-1', null, '12', '', '', '1', 'ssssssssssssssssss', '2015-06-25 08:26:26', '2015-06-25 09:08:31');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `account` varchar(100) DEFAULT NULL,
  `userName` varchar(100) DEFAULT '',
  `password` varchar(100) DEFAULT '',
  `mobileTel` varchar(20) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `work` varchar(100) DEFAULT NULL,
  `workYear` varchar(50) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `isDel` char(1) DEFAULT '0' COMMENT '0：正常，1：删除',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'sysadmin', 'sysadmin', '96e79218965eb72c92a549dd5a330112', null, null, null, null, null, null, null, '2015-05-27 15:37:09', '2015-06-23 16:04:04', '0');
INSERT INTO `t_user` VALUES ('2', 'test', 'test-ccccc', '098f6bcd4621d373cade4e832627b4f6', '', '100', '0', '', '', '', '', '2015-06-18 21:34:35', '2015-06-23 16:11:22', '0');
INSERT INTO `t_user` VALUES ('3', 'cc', 'cc', 'd41d8cd98f00b204e9800998ecf8427e', null, null, null, null, null, null, null, '2015-06-18 21:39:47', '2015-06-30 08:13:48', '1');
INSERT INTO `t_user` VALUES ('4', 'a', 'a', '0cc175b9c0f1b6a831c399e269772661', '', '100', '0', 'krisibm@163.com', '', '', '', '2015-06-19 19:44:40', '2015-06-30 08:13:48', '1');
INSERT INTO `t_user` VALUES ('5', 'b', 'b', '92eb5ffee6ae2fec3ad71c777531578f', 'bb', '100', '0', 'krisibm@163.com', '', '', 'bb', '2015-06-19 19:47:25', '2015-06-23 16:11:22', '0');
INSERT INTO `t_user` VALUES ('6', 'ceshi', 'c', '4a8a08f09d37b73795649038408b5f33', '321412432143', '100', '0', 'krisibm@163.com', '', '', '北京', '2015-06-19 19:47:42', '2015-06-23 16:08:25', '0');
INSERT INTO `t_user` VALUES ('7', '的', 'd', '8277e0910d750195b448797616e091ad', 'd', '100', '0', 'krisibm@163.com', '', '', 'd', '2015-06-19 19:47:51', '2015-06-23 16:08:25', '0');
INSERT INTO `t_user` VALUES ('8', 'e', 'e', 'e1671797c52e15f763380b45e841ec32', 'e', '100', '0', 'krisibm@163.com', '', '', 'e', '2015-06-19 19:48:03', '2015-06-23 16:08:25', '0');
INSERT INTO `t_user` VALUES ('9', 'f', 'f', '8fa14cdd754f91cc6554c9e71929cce7', 'f', '100', '0', 'krisibm@163.com', '', '', 'f', '2015-06-19 19:48:18', '2015-06-23 16:08:25', '0');
INSERT INTO `t_user` VALUES ('10', 'h', 'h', '2510c39011c5be704182423e3a695e91', 'h', '100', '0', 'krisibm@163.com', '', '', 'h', '2015-06-19 19:48:25', '2015-06-23 16:08:25', '0');
INSERT INTO `t_user` VALUES ('11', 'i', 'i', '865c0c0b4ab0e063e5caa3387c1a8741', 'i', '100', '0', 'krisibm@163.com', '', '', 'i', '2015-06-19 19:48:34', '2015-06-23 16:08:25', '0');
INSERT INTO `t_user` VALUES ('12', 'j', 'j', '363b122c528f54df4a0446b6bab05515', 'j', '100', '0', 'krisibm@163.com', '', '', 'j', '2015-06-19 19:48:42', '2015-06-30 08:01:05', '1');
INSERT INTO `t_user` VALUES ('13', 'k', 'k', '8ce4b16b22b58894aa86c421e8759df3', 'k', '100', '0', 'krisibm@163.com', '', '', 'k', '2015-06-19 19:48:51', '2015-06-23 16:08:25', '0');
INSERT INTO `t_user` VALUES ('14', 'l', 'l', '2db95e8e1a9267b7a1188556b2013b33', 'l', '100', '0', 'krisibm@163.com', '', '', 'l', '2015-06-19 19:49:00', '2015-06-23 16:08:25', '0');
INSERT INTO `t_user` VALUES ('15', 'm', 'm', '6f8f57715090da2632453988d9a1501b', 'm', '100', '0', 'krisibm@163.com', '', '', 'm', '2015-06-19 19:49:09', '2015-06-29 23:26:59', '1');
INSERT INTO `t_user` VALUES ('16', 'n', 'n-cccccc', '7b8b965ad4bca0e41ab51de7b31363a1', 'n', '100', '0', 'krisibm@163.com', '', '', 'n', '2015-06-19 19:49:17', '2015-06-29 23:26:59', '1');
INSERT INTO `t_user` VALUES ('17', 'n', '', '7b8b965ad4bca0e41ab51de7b31363a1', '', '100', '0', '', '', '', '', '2015-06-19 19:54:35', '2015-06-30 08:27:48', '1');
INSERT INTO `t_user` VALUES ('18', 'sdafdsaf', 'fdsafsda', '202cb962ac59075b964b07152d234b70', 'a43253153531', '100', '0', 'krisibm@163.com', '', '', '', '2015-06-23 18:01:08', '2015-06-30 08:01:05', '1');
INSERT INTO `t_user` VALUES ('19', 'sysadmin', '', '96e79218965eb72c92a549dd5a330112', '', '100', '0', '', '', '', '', '2015-06-26 19:50:31', '2015-06-26 19:55:34', '1');
