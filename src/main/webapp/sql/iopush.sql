/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : iopush

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2015-07-31 20:32:47
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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_entry
-- ----------------------------
INSERT INTO `t_entry` VALUES ('1', 'xxxx', 'dsafas', '', 'asfsa', '0', 'sfsa', 'http://finance.caixin.com/2015-04-14/100800012.html', 'asfasfas', 'sfas', 'dsfafdsfasdfasdfa', '4', '0', null, '1', null, '2015-07-30 21:01:37', null);
INSERT INTO `t_entry` VALUES ('2', 'safdsa', 'fsdf', '', 'afsaf', '0', 'fsafs', 'sdafdsafs', 'afdsa', 'fsadf', 'fsdfsa', '21', '0', null, '0', null, '2015-07-30 21:04:44', null);
INSERT INTO `t_entry` VALUES ('3', 'dffasf', 'asfsadf', '', 'asfdasf', '0', 'safsaf', 'sdfsaf', 'safdsaf', 'afa', 'fsafas', '21', '0', null, '0', null, '2015-07-30 21:09:34', null);
INSERT INTO `t_entry` VALUES ('4', 'dfasfsdafd', 'dafdsafda', '', 'asfdasfasfa', '0', 'sfasf', 'fsdaf', 'asfasfa', 'fasfasf', 'asfass', '21', '0', null, '0', null, '2015-07-30 21:14:16', null);
INSERT INTO `t_entry` VALUES ('5', 'fsadfas', 'safas', '', 'asfasfa', '0', 'sdfa', 'fsafasfa', 'sfsaf', 'sdafas', 'asfassaf', '21', '0', null, '0', null, '2015-07-30 21:18:07', null);
INSERT INTO `t_entry` VALUES ('6', 'dfsa', 'fsafsaf', 'fsdafdasf', 'sfdsa', '0', 'saf', '', 'asfdasf', 'dasfdasfdasfd', 'asfsafaf', '21', '0', null, '0', null, '2015-07-30 21:25:38', null);
INSERT INTO `t_entry` VALUES ('7', 'cc', 'cccccccccccccccc', '<p style=\"color:#333333;font-family:宋体;font-size:16px;text-align:justify;background-color:#FFFFFF;\">\r\n	征求意见稿规定，只要具有证券投资咨询业务资格，注册资本不低于5000万元，拥有超过10名取得证券投资咨询从业资格并满足相关条件的从业人员，以及满足其他法务、内控相关制度的公司均可以开展账户管理业务。这意味着目前市场上主流证券公司全部符合条件，但是部分第三方投资咨询机构或将受困于5000万准入门槛限制。\r\n</p>\r\n<p style=\"color:#333333;font-family:宋体;font-size:16px;text-align:justify;background-color:#FFFFFF;\">\r\n	中金认为，代客理财类似于券商传统的资管计划，但又有些许差别。主要体现在三个方面，第一是，低门槛。目前券商设立的限定性集合理财接受单个客户资金不得低于5万元，非限定性集合理财接受资金不低于10万元。而征求意见稿中并无明确规定账户管理业务的准入门槛。理论上只要券商愿意与客户约定，客户可以几乎零门槛享受账户管理业务。\r\n</p>\r\n<p style=\"color:#333333;font-family:宋体;font-size:16px;text-align:justify;background-color:#FFFFFF;\">\r\n	第二是一对一的定制服务。与其他集合类或公募资产管理计划相比，此次账户管理的亮点在于“定制化”。通过《账户管理服务协议》，券商与客户可对服务内容、方式、期限、当事人权利义务等等方面进行约定，针对客户需求打造量身定制的投顾类产品。\r\n</p>\r\n<p style=\"color:#333333;font-family:宋体;font-size:16px;text-align:justify;background-color:#FFFFFF;\">\r\n	第三是券商可代理账户投资交易，客户体验更优。意见稿明确表示符合账户管理资格的持牌机构可以代理客户执行账户投资或交易管理。这意味证券公司终于可以在特定账户突破不能动用客户资金和客户证券规定，主动替客户理财投资。只有约定明确，客户不需要实行投顾给予投资建议→客户筛选→下达交易指令→投顾下单的繁琐流程，投顾直接就投资结果向客户负责。\r\n</p>', 'cccc', '0', 'ccc', '', 'ccccc', 'ccc', 'ccc', '21', '0', null, '0', null, '2015-07-30 21:37:44', null);
INSERT INTO `t_entry` VALUES ('8', 'dsfsa', 'fdasfdsa', 'sdfasfasfasfasf', 'fsdafdsaf', '0', '', '', 'dsfsafsadfas', '', '', '3', '0', null, '0', null, '2015-07-30 22:21:26', null);
INSERT INTO `t_entry` VALUES ('9', 'fsfsafas', 'asfasf', '', '', '0', 'fsaf', '', 'fsadfasfas', '', '', '21', '0', null, '0', null, '2015-07-30 22:22:22', null);
INSERT INTO `t_entry` VALUES ('10', 'sfsaf', 'safsaf', 'safsafa', 'fsafs', '0', 'afsaf', '', 'safsaf', '', '', '21', '0', null, '0', null, '2015-07-30 22:22:35', null);
INSERT INTO `t_entry` VALUES ('11', 'sdfs', 'afsafsadfdadf', 'fsda', '', '0', 'afd', '', 'fsafdasff', '', '', '21', '0', null, '0', null, '2015-07-30 22:22:46', null);
INSERT INTO `t_entry` VALUES ('12', 'sfdsaf', 'fsafsafsafasf', '', '', '0', '', '', 'fsfsaf', '', '', '21', '0', null, '0', null, '2015-07-30 22:22:59', null);
INSERT INTO `t_entry` VALUES ('13', 'sfsdafsa', 'afafa', 'sdfdas', 'fasfsa', '0', 'fsafsaf', '', 'dsaf', '', '', '21', '0', null, '0', null, '2015-07-30 22:23:12', null);
INSERT INTO `t_entry` VALUES ('14', 'dfsaf', 'sfdsaf', '', 'dsafdsafas', '0', 'faf', '', 'fsdafs', '', '', '21', '0', null, '0', null, '2015-07-30 22:23:25', null);
INSERT INTO `t_entry` VALUES ('15', 'sdfsaf', 'safsafd', 'fsdaf', 'safasfdsa', '0', 'fsafsaf', '', 'sfsadfs', 'fsafda', '', '21', '0', null, '0', null, '2015-07-30 22:23:40', null);
INSERT INTO `t_entry` VALUES ('16', 'mmmmmmmmmmmmmm', '', '', 'm', '0', 'mmmmmmmmmmmmmmmm', '', 'fsdafas', 'mmmmmmmmmmmmmmmmm', 'mmmmmmmmmmmmmmm', '21', '0', null, '1', null, '2015-07-30 22:23:59', '2015-07-31 09:31:22');

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
) ENGINE=MyISAM AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_subject
-- ----------------------------
INSERT INTO `t_subject` VALUES ('44', '新浪', '', '21', null, '1', null, '1', null, '21', '', '', '0', 'sina', '2015-07-30 15:59:31', null);
INSERT INTO `t_subject` VALUES ('45', '凤凰网', '', '21', null, '1', null, '1', null, '21', '', '', '0', 'ifeng', '2015-07-30 15:59:43', null);
INSERT INTO `t_subject` VALUES ('46', '搜狐', '', '21', null, '1', null, '1', null, '21', '', '', '0', 'sohu', '2015-07-30 15:59:51', null);
INSERT INTO `t_subject` VALUES ('47', '平安保险', '', '21', null, '1', null, '1', null, '21', '', '', '0', 'pingan', '2015-07-30 16:00:09', null);
INSERT INTO `t_subject` VALUES ('48', '天乐科技', '', '21', null, '1', null, '1', null, '21', '', '', '0', 'tianlerkeji', '2015-07-30 16:00:32', null);
INSERT INTO `t_subject` VALUES ('49', '天乐联线', '', '21', null, '2', '0', '1', null, '21', '', '', '0', 'tianleronline', '2015-07-30 16:00:43', '2015-07-30 20:06:12');
INSERT INTO `t_subject` VALUES ('50', '天音集团', '', '21', null, '1', null, '1', null, '21', '', '', '0', 'tianyin', '2015-07-30 16:00:54', null);
INSERT INTO `t_subject` VALUES ('51', '普元', '', '21', null, '1', null, '1', null, '21', '', '', '0', 'primeton', '2015-07-30 16:01:10', null);
INSERT INTO `t_subject` VALUES ('52', '阿里巴巴', '', '21', null, '1', null, '1', null, '21', '', '', '0', 'alibaba', '2015-07-30 16:01:30', null);
INSERT INTO `t_subject` VALUES ('53', '新生科技', '', '21', null, '1', null, '1', null, '21', '', '', '0', 'xinsheng', '2015-07-30 16:02:28', null);
INSERT INTO `t_subject` VALUES ('54', '百灵药业', '', '21', null, '1', null, '1', null, '21', '', '', '0', 'baingling', '2015-07-30 16:02:54', null);
INSERT INTO `t_subject` VALUES ('55', '红壳技术', '', '21', null, '1', null, '1', null, '21', '', '', '0', '红壳', '2015-07-30 16:08:11', null);
INSERT INTO `t_subject` VALUES ('56', '易壳', '', '21', null, '1', null, '1', null, '21', '', '', '0', 'yike', '2015-07-30 16:08:31', null);
INSERT INTO `t_subject` VALUES ('57', 'aaa', '', '21', null, '1', null, '1', null, '21', '', '', '0', 'aaa', '2015-07-30 16:09:15', null);
INSERT INTO `t_subject` VALUES ('43', '百度', '', '21', null, '1', null, '1', null, '21', '', '', '0', 'baidu', '2015-07-30 15:59:20', null);
INSERT INTO `t_subject` VALUES ('42', '和讯xx', '', '21', null, '1', '0', '1', null, '21', '', '', '0', 'hexun', '2015-07-30 15:59:07', '2015-07-30 17:48:05');

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
INSERT INTO `t_user` VALUES ('20', 'krisjin', 'krisjin', '81dc9bdb52d04dc20036dbd8313ed055', '', '100', '0', 'krisibm@163.com', '', '', '', '2015-07-21 22:12:05', '2015-07-31 18:27:00', '0');
