/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : iopush

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2015-06-19 17:55:33
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
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `isDel` char(1) DEFAULT '0' COMMENT '0£ºÕý³££¬1£ºÉ¾³ý',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'sysadmin', 'sysadmin', '96e79218965eb72c92a549dd5a330112', '2015-05-27 15:37:09', null, '0');
INSERT INTO `user` VALUES ('2', 'test', 'test', '098f6bcd4621d373cade4e832627b4f6', '2015-06-18 21:34:35', null, '0');
INSERT INTO `user` VALUES ('3', 'cc', 'cc', 'd41d8cd98f00b204e9800998ecf8427e', '2015-06-18 21:39:47', null, '0');
