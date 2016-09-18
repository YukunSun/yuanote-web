/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50015
Source Host           : localhost:3306
Source Database       : yuanote

Target Server Type    : MYSQL
Target Server Version : 50015
File Encoding         : 65001

Date: 2016-09-18 20:13:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for yn_note
-- ----------------------------
DROP TABLE IF EXISTS `yn_note`;
CREATE TABLE `yn_note` (
  `sid` bigint(100) NOT NULL auto_increment COMMENT '笔记ID',
  `yn_notebook_id` bigint(100) default NULL COMMENT '笔记本ID',
  `yn_user_id` varchar(100) default NULL COMMENT '用户ID',
  `yn_note_status_id` varchar(100) default NULL COMMENT '笔记状态ID:备用',
  `yn_note_type_id` varchar(100) default NULL COMMENT '笔记本类型ID：备用',
  `yn_note_title` varchar(500) default NULL COMMENT '笔记标题',
  `yn_note_body` text COMMENT '笔记内容',
  `yn_note_create_time` bigint(20) default NULL COMMENT '笔记创建时间',
  `yn_note_last_modify_time` bigint(20) default NULL COMMENT '笔记最近修改时间',
  PRIMARY KEY  (`sid`),
  KEY `FK_Reference_2` (`yn_notebook_id`),
  KEY `FK_Reference_3` (`yn_user_id`),
  KEY `FK_Reference_7` (`yn_note_status_id`),
  KEY `FK_Reference_8` (`yn_note_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for yn_notebook
-- ----------------------------
DROP TABLE IF EXISTS `yn_notebook`;
CREATE TABLE `yn_notebook` (
  `sid` bigint(100) NOT NULL auto_increment COMMENT '笔记本ID',
  `yn_user_id` varchar(100) default NULL COMMENT '用户ID',
  `yn_notebook_type_id` varchar(100) default NULL COMMENT '笔记本类型ID',
  `yn_notebook_name` varchar(500) default NULL COMMENT '笔记本名',
  `yn_notebook_desc` text COMMENT '笔记本说明',
  `yn_notebook_createtime` timestamp NOT NULL default '0000-00-00 00:00:00' on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`sid`),
  KEY `FK_Note_User_Reference` (`yn_user_id`),
  KEY `FK_Reference_6` (`yn_notebook_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for yn_notebook_type
-- ----------------------------
DROP TABLE IF EXISTS `yn_notebook_type`;
CREATE TABLE `yn_notebook_type` (
  `sid` bigint(100) NOT NULL auto_increment COMMENT '笔记本类型ID',
  `notebook_type_code` varchar(100) default NULL COMMENT '笔记本类型Code',
  `notebook_type_name` varchar(500) default NULL COMMENT '笔记本类型名称',
  `notebook_type_desc` text COMMENT '笔记本类型说明',
  PRIMARY KEY  (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for yn_user
-- ----------------------------
DROP TABLE IF EXISTS `yn_user`;
CREATE TABLE `yn_user` (
  `yn_user_id` varchar(100) NOT NULL COMMENT '用户ID',
  `yn_user_name` varchar(100) default NULL COMMENT '用户名',
  `yn_user_password` varchar(100) default NULL COMMENT '密码',
  `yn_user_desc` varchar(100) default NULL COMMENT '说明',
  PRIMARY KEY  (`yn_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
