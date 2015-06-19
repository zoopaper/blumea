/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : iopush

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2015-06-19 20:03:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'sysadmin', 'sysadmin', '96e79218965eb72c92a549dd5a330112', null, null, null, null, null, null, null, '2015-05-27 15:37:09', null, '0');
INSERT INTO `user` VALUES ('2', 'test', 'test', '098f6bcd4621d373cade4e832627b4f6', null, null, null, null, null, null, null, '2015-06-18 21:34:35', null, '0');
INSERT INTO `user` VALUES ('3', 'cc', 'cc', 'd41d8cd98f00b204e9800998ecf8427e', null, null, null, null, null, null, null, '2015-06-18 21:39:47', null, '0');
INSERT INTO `user` VALUES ('4', 'a', 'a', '0cc175b9c0f1b6a831c399e269772661', '', '100', '0', 'krisibm@163.com', '', '', '', '2015-06-19 19:44:40', null, '0');
INSERT INTO `user` VALUES ('5', 'b', 'b', '92eb5ffee6ae2fec3ad71c777531578f', 'bb', '100', '0', 'krisibm@163.com', '', '', 'bb', '2015-06-19 19:47:25', null, '0');
INSERT INTO `user` VALUES ('6', 'ceshi', 'c', '4a8a08f09d37b73795649038408b5f33', '321412432143', '100', '0', 'krisibm@163.com', '', '', '北京', '2015-06-19 19:47:42', null, '0');
INSERT INTO `user` VALUES ('7', '的', 'd', '8277e0910d750195b448797616e091ad', 'd', '100', '0', 'krisibm@163.com', '', '', 'd', '2015-06-19 19:47:51', null, '0');
INSERT INTO `user` VALUES ('8', 'e', 'e', 'e1671797c52e15f763380b45e841ec32', 'e', '100', '0', 'krisibm@163.com', '', '', 'e', '2015-06-19 19:48:03', null, '0');
INSERT INTO `user` VALUES ('9', 'f', 'f', '8fa14cdd754f91cc6554c9e71929cce7', 'f', '100', '0', 'krisibm@163.com', '', '', 'f', '2015-06-19 19:48:18', null, '0');
INSERT INTO `user` VALUES ('10', 'h', 'h', '2510c39011c5be704182423e3a695e91', 'h', '100', '0', 'krisibm@163.com', '', '', 'h', '2015-06-19 19:48:25', null, '0');
INSERT INTO `user` VALUES ('11', 'i', 'i', '865c0c0b4ab0e063e5caa3387c1a8741', 'i', '100', '0', 'krisibm@163.com', '', '', 'i', '2015-06-19 19:48:34', null, '0');
INSERT INTO `user` VALUES ('12', 'j', 'j', '363b122c528f54df4a0446b6bab05515', 'j', '100', '0', 'krisibm@163.com', '', '', 'j', '2015-06-19 19:48:42', null, '0');
INSERT INTO `user` VALUES ('13', 'k', 'k', '8ce4b16b22b58894aa86c421e8759df3', 'k', '100', '0', 'krisibm@163.com', '', '', 'k', '2015-06-19 19:48:51', null, '0');
INSERT INTO `user` VALUES ('14', 'l', 'l', '2db95e8e1a9267b7a1188556b2013b33', 'l', '100', '0', 'krisibm@163.com', '', '', 'l', '2015-06-19 19:49:00', null, '0');
INSERT INTO `user` VALUES ('15', 'm', 'm', '6f8f57715090da2632453988d9a1501b', 'm', '100', '0', 'krisibm@163.com', '', '', 'm', '2015-06-19 19:49:09', null, '0');
INSERT INTO `user` VALUES ('16', 'n', 'n', '7b8b965ad4bca0e41ab51de7b31363a1', 'n', '100', '0', 'krisibm@163.com', '', '', 'n', '2015-06-19 19:49:17', null, '0');
INSERT INTO `user` VALUES ('17', 'n', '', '7b8b965ad4bca0e41ab51de7b31363a1', '', '100', '0', '', '', '', '', '2015-06-19 19:54:35', null, '0');
