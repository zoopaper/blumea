/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : iopush

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2015-07-23 23:25:32
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
) ENGINE=MyISAM AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_channel
-- ----------------------------
INSERT INTO `t_channel` VALUES ('3', '美食', 'meishi', '0', '2015-07-13 22:31:04');
INSERT INTO `t_channel` VALUES ('4', '经济', 'jingji', '0', '2015-06-23 23:42:33');
INSERT INTO `t_channel` VALUES ('19', '美食', 'meishi', '1', '2015-07-15 18:45:42');
INSERT INTO `t_channel` VALUES ('20', '股票', 'stock', '0', '2015-07-20 20:38:16');
INSERT INTO `t_channel` VALUES ('21', '舆情监测', 'yuqing', '0', '2015-07-20 20:41:45');
INSERT INTO `t_channel` VALUES ('22', '', '', '1', '2015-07-21 12:41:47');

-- ----------------------------
-- Table structure for `t_entry`
-- ----------------------------
DROP TABLE IF EXISTS `t_entry`;
CREATE TABLE `t_entry` (
  `id` bigint(1) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(300) DEFAULT NULL,
  `subhead` varchar(200) DEFAULT NULL,
  `content` longtext,
  `author` varchar(30) DEFAULT NULL,
  `editor` varchar(30) DEFAULT NULL,
  `dutyEditor` varchar(30) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `keyword` varchar(200) DEFAULT NULL,
  `tag` varchar(100) DEFAULT NULL,
  `summary` varchar(300) DEFAULT NULL,
  `channelId` int(11) DEFAULT NULL,
  `subjectId` int(11) DEFAULT NULL,
  `category` varchar(30) DEFAULT NULL,
  `isDel` int(11) DEFAULT '0',
  `status` int(11) DEFAULT NULL,
  `ctime` timestamp NULL DEFAULT NULL,
  `utime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_entry
-- ----------------------------

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
  `descs` varchar(100) DEFAULT NULL,
  `siteUrl` varchar(50) DEFAULT NULL,
  `logoUrl` varchar(150) DEFAULT NULL,
  `isDel` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_media
-- ----------------------------
INSERT INTO `t_media` VALUES ('1', 'fdsfdasfsaf', 'fsad', 'f', 'fsaf', '1');
INSERT INTO `t_media` VALUES ('2', '搜狐IT', '', 'http://it.sohu.com/', '', '0');
INSERT INTO `t_media` VALUES ('3', '腾讯科技', '', 'http://it.qq.com/', '', '0');

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
INSERT INTO `t_role` VALUES ('4', '财经呯到', 'ddd', 'sfas', '2015-06-29 23:41:02');
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
  `parentPath` varchar(100) DEFAULT NULL,
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
) ENGINE=MyISAM AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_subject
-- ----------------------------
INSERT INTO `t_subject` VALUES ('12', '新疆菜', '', '3', null, '1', '0', '1', null, '3', '', '', '0', 'xinjiang', '2015-07-13 22:04:05', '2015-07-22 22:16:40');
INSERT INTO `t_subject` VALUES ('8', 'ceshi', '', '4', null, '1', '0', '1', null, '4', '', '', '0', 'ceshis', '2015-07-13 21:34:50', '2015-07-22 22:22:26');
INSERT INTO `t_subject` VALUES ('9', '鲁菜xxx', '', '3', null, '1', '0', '0', null, '3', '', '', '1', 'lucai', '2015-07-13 21:36:25', '2015-07-22 21:47:54');
INSERT INTO `t_subject` VALUES ('10', '杭帮菜sss', '', '3', null, '2', '0', '1', null, '3', '', '', '1', 'dfd', '2015-07-13 21:37:31', '2015-07-22 22:26:40');
INSERT INTO `t_subject` VALUES ('11', '海派菜', '', '3', null, '2', '0', '0', null, '3', '', '', '0', 'haipai', '2015-07-13 21:38:06', '2015-07-22 21:50:23');
INSERT INTO `t_subject` VALUES ('13', '港股', '', '20', null, '0', null, '1', null, '20', '', '港股', '0', 'hongkong', '2015-07-20 20:39:54', null);
INSERT INTO `t_subject` VALUES ('14', '上市公司', '', '21', null, '2', '0', '1', null, '21', '', '', '1', 'news', '2015-07-20 20:42:22', '2015-07-22 22:27:57');
INSERT INTO `t_subject` VALUES ('15', '公司研究', '', '14', null, '0', null, '1', null, '21', '', '研究', '0', 'research', '2015-07-20 20:43:43', null);
INSERT INTO `t_subject` VALUES ('16', '川菜', '', '0', null, '1', null, '0', null, '0', '', '', '0', 'chuancai', '2015-07-21 22:07:52', null);
INSERT INTO `t_subject` VALUES ('17', '川菜', '', '0', null, '1', null, '0', null, '0', '', '', '0', 'chuancai', '2015-07-21 22:08:07', null);
INSERT INTO `t_subject` VALUES ('18', '川菜', '', '0', null, '1', null, '0', null, '0', '', '', '0', 'chuancai', '2015-07-21 22:08:10', null);
INSERT INTO `t_subject` VALUES ('19', '川菜', '', '0', null, '1', null, '0', null, '0', '', '', '0', 'chuancai', '2015-07-21 22:08:15', null);
INSERT INTO `t_subject` VALUES ('20', '川菜', '', '0', null, '1', null, '0', null, '0', '', '', '0', 'chuancai', '2015-07-21 22:08:44', null);
INSERT INTO `t_subject` VALUES ('21', '北京菜', '', '0', null, '1', null, '0', null, '0', '', '', '0', 'beijingcai', '2015-07-22 17:45:34', null);
INSERT INTO `t_subject` VALUES ('22', '北京菜', '', '0', null, '1', null, '0', null, '0', '', '', '0', 'beijingcai', '2015-07-22 17:50:59', null);
INSERT INTO `t_subject` VALUES ('23', '北京菜', '', '0', null, '1', null, '0', null, '0', '', '', '0', 'beijingcai', '2015-07-22 17:51:57', null);
INSERT INTO `t_subject` VALUES ('24', '北京菜', '', '0', null, '1', null, '0', null, '0', '', '', '0', 'beijingcai', '2015-07-22 19:19:55', null);
INSERT INTO `t_subject` VALUES ('25', '北京菜', '', '0', null, '1', null, '0', null, '0', '', '', '0', 'beijingcai', '2015-07-22 19:19:57', null);
INSERT INTO `t_subject` VALUES ('26', '北京菜', '', '0', null, '1', null, '0', null, '0', '', '', '0', 'beijingcai', '2015-07-22 19:19:58', null);
INSERT INTO `t_subject` VALUES ('27', '北京菜', '', '0', null, '1', null, '0', null, '0', '', '', '0', 'beijingcai', '2015-07-22 19:20:12', null);
INSERT INTO `t_subject` VALUES ('28', '北京菜', '', '0', null, '1', null, '0', null, '0', '', '', '0', 'beijingcai', '2015-07-22 19:20:13', null);
INSERT INTO `t_subject` VALUES ('29', '北京菜', '', '0', null, '1', null, '0', null, '0', '', '', '0', 'beijingcai', '2015-07-22 19:20:13', null);
INSERT INTO `t_subject` VALUES ('30', '北京菜', '', '0', null, '1', null, '0', null, '0', '', '', '0', 'beijingcai', '2015-07-22 19:20:14', null);
INSERT INTO `t_subject` VALUES ('31', '北京菜s', '', '0', null, '1', null, '0', null, '0', '', '', '0', 'beijingcai', '2015-07-22 19:20:16', null);
INSERT INTO `t_subject` VALUES ('32', '北京菜', '', '0', null, '1', null, '0', null, '0', '', '', '0', 'beijingcai', '2015-07-22 19:24:45', null);
INSERT INTO `t_subject` VALUES ('33', '北京菜', '', '0', null, '1', null, '0', null, '0', '', '', '0', 'beijingcai', '2015-07-22 19:25:01', null);
INSERT INTO `t_subject` VALUES ('34', '北京菜', '', '0', null, '1', null, '0', null, '0', '', '', '0', 'beijingcai', '2015-07-22 19:25:27', null);
INSERT INTO `t_subject` VALUES ('35', '北京菜sss', '', '0', null, '1', null, '0', null, '0', '', '', '0', 'beijingcai', '2015-07-22 19:47:52', null);

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
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'sysadmin', 'sysadmin', '96e79218965eb72c92a549dd5a330112', '', '100', '0', '', '', '', 'dsfsaf', '2015-05-27 15:37:09', '2015-07-10 21:36:19', '0');
INSERT INTO `t_user` VALUES ('2', 'test', 'test-ccccc', '098f6bcd4621d373cade4e832627b4f6', 'fa', '100', '0', 'krisibm@163.com', '', '', '', '2015-06-18 21:34:35', '2015-07-10 21:36:05', '0');
INSERT INTO `t_user` VALUES ('3', 'cc', 'cc', 'd41d8cd98f00b204e9800998ecf8427e', null, null, null, null, null, null, null, '2015-06-18 21:39:47', '2015-06-30 08:13:48', '1');
INSERT INTO `t_user` VALUES ('4', 'a', 'a', '0cc175b9c0f1b6a831c399e269772661', '', '100', '0', 'krisibm@163.com', '', '', '', '2015-06-19 19:44:40', '2015-06-30 08:13:48', '1');
INSERT INTO `t_user` VALUES ('5', 'b', 'b', '92eb5ffee6ae2fec3ad71c777531578f', 'bb', '100', '0', 'krisibm@163.com', '', '', 'bb', '2015-06-19 19:47:25', '2015-06-23 16:11:22', '0');
INSERT INTO `t_user` VALUES ('6', 'ceshi', 'c', '4a8a08f09d37b73795649038408b5f33', '321412432143', '100', '0', 'krisibm@163.com', '', '', '北京', '2015-06-19 19:47:42', '2015-07-10 21:36:13', '0');
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
INSERT INTO `t_user` VALUES ('20', 'krisjin', 'krisjin', '81dc9bdb52d04dc20036dbd8313ed055', '', '100', '0', 'krisibm@163.com', '', '', '', '2015-07-21 22:12:05', null, '0');
