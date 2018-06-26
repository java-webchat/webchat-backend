/*
 Navicat Premium Data Transfer

 Source Server         : 59.110.158.56
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : 59.110.158.56
 Source Database       : chat

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : utf-8

 Date: 06/26/2018 20:42:10 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `group_info`
-- ----------------------------
DROP TABLE IF EXISTS `group_info`;
CREATE TABLE `group_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='群组';

-- ----------------------------
--  Records of `group_info`
-- ----------------------------
BEGIN;
INSERT INTO `group_info` VALUES ('1', '群组1');
COMMIT;

-- ----------------------------
--  Table structure for `group_record`
-- ----------------------------
DROP TABLE IF EXISTS `group_record`;
CREATE TABLE `group_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `send_id` int(11) NOT NULL DEFAULT '0' COMMENT '发送者帐号',
  `content` varchar(255) DEFAULT '',
  `create_date` datetime NOT NULL,
  `group_id` int(11) NOT NULL DEFAULT '0' COMMENT '群组id',
  `send_avatar` varchar(255) NOT NULL DEFAULT '' COMMENT '发送者头像',
  `nick_name` varchar(255) NOT NULL DEFAULT '' COMMENT '昵称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=387 DEFAULT CHARSET=utf8 COMMENT='群组消息记录';

-- ----------------------------
--  Records of `group_record`
-- ----------------------------
BEGIN;
INSERT INTO `group_record` VALUES ('374', '15', '', '2018-06-26 20:00:59', '1', 'http://i1.umei.cc/uploads/tu/201711/9999/rn34c9be61cf.jpg', '123456'), ('375', '15', '你是谁', '2018-06-26 20:01:49', '1', 'http://i1.umei.cc/uploads/tu/201711/9999/rn34c9be61cf.jpg', '123456'), ('376', '15', '你是谁', '2018-06-26 20:02:26', '1', 'http://i1.umei.cc/uploads/tu/201711/9999/rn34c9be61cf.jpg', '123456'), ('377', '16', '我是小米', '2018-06-26 20:03:36', '1', 'http://i1.umei.cc/uploads/tu/201712/10032/f499e94760.jpg', '鹏哥'), ('378', '15', '我是鹏哥', '2018-06-26 20:04:24', '1', 'http://i1.umei.cc/uploads/tu/201711/9999/rn34c9be61cf.jpg', '123456'), ('379', '15', '啦啦啦', '2018-06-26 20:04:32', '1', 'http://i1.umei.cc/uploads/tu/201711/9999/rn34c9be61cf.jpg', '123456'), ('380', '15', '你是', '2018-06-26 20:10:44', '1', 'http://i1.umei.cc/uploads/tu/201711/9999/rn34c9be61cf.jpg', '123456'), ('381', '15', '我是测试帐号', '2018-06-26 12:22:46', '1', 'http://i1.umei.cc/uploads/tu/201711/9999/rn34c9be61cf.jpg', '123456'), ('382', '17', '卧槽，秀啊', '2018-06-26 12:25:02', '1', 'http://i1.umei.cc/uploads/tu/201711/10102/5ad0d16ebf.jpg', 'lll'), ('383', '15', '哈哈哈', '2018-06-26 12:26:11', '1', 'http://i1.umei.cc/uploads/tu/201711/9999/rn34c9be61cf.jpg', '123456'), ('384', '15', '我给你发消息啦', '2018-06-26 12:26:36', '1', 'http://i1.umei.cc/uploads/tu/201711/9999/rn34c9be61cf.jpg', '123456'), ('385', '17', '头像不错', '2018-06-26 12:27:12', '1', 'http://i1.umei.cc/uploads/tu/201711/10102/5ad0d16ebf.jpg', 'lll'), ('386', '15', '哈哈哈 网上拔下来的', '2018-06-26 12:30:36', '1', 'http://i1.umei.cc/uploads/tu/201711/9999/rn34c9be61cf.jpg', '123456');
COMMIT;

-- ----------------------------
--  Table structure for `user_group_relation`
-- ----------------------------
DROP TABLE IF EXISTS `user_group_relation`;
CREATE TABLE `user_group_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL DEFAULT '0' COMMENT '用户id',
  `group_id` int(11) NOT NULL DEFAULT '0',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '状态1启用',
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户群组关联';

-- ----------------------------
--  Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login_num` varchar(255) NOT NULL DEFAULT '0' COMMENT '登录帐号',
  `pwd` varchar(255) NOT NULL DEFAULT '',
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '状态 1启用',
  `avator` varchar(255) DEFAULT '',
  `nick_name` varchar(255) NOT NULL DEFAULT '' COMMENT '昵称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
--  Records of `user_info`
-- ----------------------------
BEGIN;
INSERT INTO `user_info` VALUES ('15', '123456', 'E10ADC3949BA59ABBE56E057F20F883E', '2018-06-26 19:55:28', '2018-06-26 19:55:28', '1', 'http://i1.umei.cc/uploads/tu/201711/9999/rn34c9be61cf.jpg', '123456'), ('16', '234567', 'E10ADC3949BA59ABBE56E057F20F883E', '2018-06-26 20:03:20', '2018-06-26 20:03:20', '1', 'http://i1.umei.cc/uploads/tu/201712/10032/f499e94760.jpg', '鹏哥'), ('17', 'lll123', '110F7C358BA79F7455432548B9BEC781', '2018-06-26 12:24:38', '2018-06-26 12:24:38', '1', 'http://i1.umei.cc/uploads/tu/201711/10102/5ad0d16ebf.jpg', 'lll');
COMMIT;

-- ----------------------------
--  Table structure for `user_to_user_record`
-- ----------------------------
DROP TABLE IF EXISTS `user_to_user_record`;
CREATE TABLE `user_to_user_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_relation_id` int(11) NOT NULL DEFAULT '0',
  `content` varchar(255) NOT NULL DEFAULT '',
  `send_id` int(11) NOT NULL DEFAULT '0' COMMENT '发送方id',
  `send_type` int(11) NOT NULL DEFAULT '0' COMMENT '1 primary 2 secondary',
  `recive_id` int(11) NOT NULL DEFAULT '0' COMMENT '接收方id',
  `recive_type` int(11) NOT NULL DEFAULT '0' COMMENT '1 primary 2 secondary',
  `create_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户聊天记录';

-- ----------------------------
--  Table structure for `user_user_relation`
-- ----------------------------
DROP TABLE IF EXISTS `user_user_relation`;
CREATE TABLE `user_user_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id_primary` int(11) DEFAULT '0' COMMENT '主要方user_id',
  `user_id_secondary` int(11) DEFAULT '0' COMMENT '次要方user_id',
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '状态 1启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户-用户关联';

SET FOREIGN_KEY_CHECKS = 1;
