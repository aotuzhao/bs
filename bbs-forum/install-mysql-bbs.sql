/*
 Navicat MySQL Data Transfer

 Source Server         : dev
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost
 Source Database       : bbs

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : utf-8

 Date: 04/06/2019 10:13:56 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `bbs_message`
-- ----------------------------
DROP TABLE IF EXISTS `bbs_message`;
CREATE TABLE `bbs_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `topic_id` int(11) DEFAULT NULL,
  `status` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `bbs_message`
-- ----------------------------
BEGIN;
INSERT INTO `bbs_message` VALUES ('7', '105', '95', '0'), ('8', '104', '94', '0'), ('9', '107', '100', '1'), ('10', '105', '94', '0'), ('11', '107', '95', '1');
COMMIT;

-- ----------------------------
--  Table structure for `bbs_module`
-- ----------------------------
DROP TABLE IF EXISTS `bbs_module`;
CREATE TABLE `bbs_module` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `detail` varchar(100) DEFAULT NULL,
  `turn` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `bbs_module`
-- ----------------------------
BEGIN;
INSERT INTO `bbs_module` VALUES ('3', 'java', null, '1'), ('4', '前端', null, '2'), ('5', '大数据', null, '3'), ('6', '数据库', null, '4'), ('7', 'python', null, '5'), ('8', 'c++', null, '6');
COMMIT;

-- ----------------------------
--  Table structure for `bbs_post`
-- ----------------------------
DROP TABLE IF EXISTS `bbs_post`;
CREATE TABLE `bbs_post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `topic_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL DEFAULT '0',
  `content` text NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `has_reply` bit(1) NOT NULL DEFAULT b'0',
  `update_time` timestamp NULL DEFAULT NULL,
  `pros` int(11) DEFAULT '0',
  `cons` int(11) DEFAULT '0',
  `is_accept` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `topicID_P` (`topic_id`),
  KEY `userID_P` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=300 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `bbs_post`
-- ----------------------------
BEGIN;
INSERT INTO `bbs_post` VALUES ('286', '94', '104', '<p>eureka 注册中心报错<br/></p>', '2019-04-05 21:32:10', b'0', null, '1', '0', '1'), ('287', '95', '105', '<p>现在前端最新技术有哪些<br/></p>', '2019-04-05 21:53:50', b'0', null, '1', '0', '0'), ('288', '96', '104', '<p>大数据测试数据</p>', '2019-04-05 21:57:48', b'0', null, '0', '0', '0'), ('289', '97', '104', '<p>数据库测试数据</p>', '2019-04-05 21:58:08', b'0', null, '0', '0', '0'), ('290', '98', '104', '<p>python测试数据</p>', '2019-04-05 21:58:30', b'0', null, '0', '0', '0'), ('291', '99', '104', '<p>c++测试数据</p>', '2019-04-05 21:58:45', b'0', null, '0', '0', '0'), ('292', '94', '105', '<p><img src=\"/bbs/image/20190405/1554472830407068555.gif\" title=\"1554472830407068555.gif\" alt=\"c16f01569f58cb50c6b9bb06795ee1e7.gif\"/><img src=\"http://img.baidu.com/hi/jx2/j_0014.gif\"/>测试数据</p>', '2019-04-05 22:00:40', b'0', null, '0', '0', '0'), ('293', '94', '105', '<p><span style=\"text-decoration: line-through;\"></span></p><p style=\"line-height: 16px;\"><img src=\"http://localhost:7210/bbs/dialogs/attachment/fileTypeImages/icon_rar.gif\"/><a style=\"font-size:12px; color:#0066cc;\" href=\"/bbs/ueditor/jsp/upload/file/20190405/1554473228874088174.zip\" title=\"bbs-forum201904041803.zip\">bbs-forum201904041803.zip</a></p><p style=\"line-height: 16px;\"><img src=\"http://localhost:7210/bbs/dialogs/attachment/fileTypeImages/icon_txt.gif\"/><a style=\"font-size:12px; color:#0066cc;\" href=\"/bbs/ueditor/jsp/upload/file/20190405/1554473229107076388.mp4\" title=\"01 简介.mp4\">01 简介.mp4</a></p><p>测试上传文件<span style=\"text-decoration: line-through;\"></span><br/></p>', '2019-04-05 22:07:19', b'0', null, '0', '0', '0'), ('294', '100', '107', '<p>我不吃，我不喝 我就想学前端<img src=\"/bbs/image/20190405/1554474047330067358.gif\" title=\"1554474047330067358.gif\" alt=\"c16f01569f58cb50c6b9bb06795ee1e7.gif\"/><img src=\"http://img.baidu.com/hi/jx2/j_0013.gif\"/>阿斯顿</p>', '2019-04-05 22:20:53', b'0', null, '2', '0', '0'), ('297', '95', '107', '<p>撒打算打算的 修改一下<br/></p>', '2019-04-05 22:21:56', b'0', null, '0', '0', '0'), ('299', '94', '104', '<p style=\"line-height: 16px;\"><img src=\"http://localhost:7210/bbs/dialogs/attachment/fileTypeImages/icon_rar.gif\"/><a style=\"font-size:12px; color:#0066cc;\" href=\"/bbs/ueditor/jsp/upload/file/20190405/1554474261358086567.zip\" title=\"bbs-forum201904041803.zip\">bbs-forum201904041803.zip</a></p><p style=\"line-height: 16px;\"><img src=\"http://localhost:7210/bbs/dialogs/attachment/fileTypeImages/icon_txt.gif\"/><a style=\"font-size:12px; color:#0066cc;\" href=\"/bbs/ueditor/jsp/upload/file/20190405/1554474261706017701.mp4\" title=\"01 简介.mp4\">01 简介.mp4</a></p><p><img src=\"http://img.baidu.com/hi/jx2/j_0026.gif\"/><img src=\"/bbs/image/20190405/1554474277442050185.gif\" title=\"1554474277442050185.gif\" alt=\"c16f01569f58cb50c6b9bb06795ee1e7.gif\"/></p>', '2019-04-05 22:24:40', b'0', null, '0', '0', '0');
COMMIT;

-- ----------------------------
--  Table structure for `bbs_reply`
-- ----------------------------
DROP TABLE IF EXISTS `bbs_reply`;
CREATE TABLE `bbs_reply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `topic_id` int(11) NOT NULL DEFAULT '1',
  `post_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL DEFAULT '0',
  `content` varchar(300) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `topicID_R` (`topic_id`),
  KEY `postID_R` (`post_id`),
  KEY `userID_R` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `bbs_reply`
-- ----------------------------
BEGIN;
INSERT INTO `bbs_reply` VALUES ('36', '95', '287', '105', '好多，进', '2019-04-05 21:54:24'), ('37', '95', '287', '104', '测试回复数据', '2019-04-05 21:55:33'), ('38', '94', '286', '105', '张校长测试数据', '2019-04-05 21:56:38'), ('39', '100', '294', '107', '哈哈', '2019-04-05 22:21:19'), ('40', '95', '287', '107', '哈哈', '2019-04-05 22:21:38'), ('41', '100', '294', '104', 'zhendou', '2019-04-05 22:23:15'), ('42', '100', '294', '104', 'zhendou', '2019-04-05 22:23:16'), ('43', '94', '299', '105', '可是上传文件视频等 视频可是在线观看 文件可以下载', '2019-04-05 22:26:48'), ('44', '95', '297', '105', '我的消息zhong 恢复的消失书', '2019-04-05 22:27:18');
COMMIT;

-- ----------------------------
--  Table structure for `bbs_topic`
-- ----------------------------
DROP TABLE IF EXISTS `bbs_topic`;
CREATE TABLE `bbs_topic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL DEFAULT '0',
  `module_id` int(11) NOT NULL,
  `post_count` int(11) NOT NULL DEFAULT '1',
  `reply_count` int(11) NOT NULL DEFAULT '0',
  `pv` int(11) NOT NULL DEFAULT '0',
  `content` varchar(150) NOT NULL,
  `emotion` tinyint(2) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `is_nice` bit(1) NOT NULL DEFAULT b'0',
  `is_up` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`),
  KEY `moduleID_T` (`module_id`),
  KEY `userID_T` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `bbs_topic`
-- ----------------------------
BEGIN;
INSERT INTO `bbs_topic` VALUES ('94', '104', '3', '4', '0', '12', 'SpringBoot 注册中心注入不进去', null, '2019-04-05 21:32:10', b'1', b'0'), ('95', '105', '4', '4', '0', '7', '前端最新技术', null, '2019-04-05 21:53:50', b'1', b'1'), ('96', '104', '5', '1', '0', '2', '大数据测试数据', null, '2019-04-05 21:57:48', b'0', b'0'), ('97', '104', '6', '1', '0', '2', '数据库测试数据', null, '2019-04-05 21:58:08', b'0', b'0'), ('98', '104', '7', '1', '0', '2', 'python测试数据', null, '2019-04-05 21:58:30', b'0', b'0'), ('99', '104', '8', '1', '0', '2', 'c++测试数据', null, '2019-04-05 21:58:45', b'0', b'0'), ('100', '107', '4', '1', '0', '4', '我叫苏大强我想学前端', null, '2019-04-05 22:20:53', b'0', b'0');
COMMIT;

-- ----------------------------
--  Table structure for `bbs_user`
-- ----------------------------
DROP TABLE IF EXISTS `bbs_user`;
CREATE TABLE `bbs_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `score` int(11) DEFAULT '0' COMMENT '积分',
  `level` int(11) DEFAULT '1' COMMENT '积分换算成等级，新生，老生，班主任，教导主任，校长',
  `balance` int(11) DEFAULT '0' COMMENT '积分余额',
  `corp` varchar(128) DEFAULT NULL COMMENT '公司',
  `sex` int(2) DEFAULT NULL COMMENT '性别(0 女 1 男)',
  `status` int(2) NOT NULL DEFAULT '0' COMMENT '状态 (0 正常, 1冻结, -1 删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `bbs_user`
-- ----------------------------
BEGIN;
INSERT INTO `bbs_user` VALUES ('104', 'admin', 'e10adc3949ba59abbe56e057f20f883e', 'admin@qq.com', '82', '1', '82', '阿里巴巴', '1', '0'), ('105', '张校长', 'e10adc3949ba59abbe56e057f20f883e', 'zhangxiaoz@qq.com', '38', '1', '38', '华为', '0', '0'), ('106', '测试账号1', 'e10adc3949ba59abbe56e057f20f883e', 'ceshizhanghao@qq.com', '10', '1', '10', '测试公司', '1', '0'), ('107', '苏大强', null, 'sudaqiang@qq.com', '25', '1', '25', '家里', '1', '0');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
