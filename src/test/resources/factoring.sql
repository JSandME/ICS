/*
Navicat MySQL Data Transfer

Source Server         : aaa
Source Server Version : 50709
Source Host           : localhost:3306
Source Database       : factoring

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2017-05-23 17:06:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for credit
-- ----------------------------
DROP TABLE IF EXISTS `credit`;
CREATE TABLE `credit` (
  `id` varchar(40) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `star` char(1) DEFAULT NULL,
  `bad_record` int(11) DEFAULT NULL,
  `created_time` char(20) DEFAULT NULL,
  `creator_id` varchar(50) DEFAULT NULL,
  `modified_time` char(20) DEFAULT NULL,
  `modifier_id` varchar(50) DEFAULT NULL,
  `record_state` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `credit_Index` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of credit
-- ----------------------------

-- ----------------------------
-- Table structure for financing_apply
-- ----------------------------
DROP TABLE IF EXISTS `financing_apply`;
CREATE TABLE `financing_apply` (
  `id` varchar(40) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `role_name` varchar(32) DEFAULT NULL,
  `product_id` varchar(40) DEFAULT NULL,
  `app_amt` decimal(10,2) DEFAULT NULL,
  `rate` decimal(10,6) DEFAULT NULL,
  `use_date` int(11) DEFAULT NULL,
  `app_date` char(10) DEFAULT NULL,
  `state` varchar(10) DEFAULT NULL,
  `created_time` char(20) DEFAULT NULL,
  `creator_id` varchar(50) DEFAULT NULL,
  `modified_time` char(20) DEFAULT NULL,
  `modifier_id` varchar(50) DEFAULT NULL,
  `record_state` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of financing_apply
-- ----------------------------

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` varchar(40) NOT NULL COMMENT '权限id',
  `permission_name` varchar(32) DEFAULT NULL COMMENT '权限名',
  `permission_sign` varchar(128) DEFAULT NULL COMMENT '权限标识,程序中判断使用,如"user:create"',
  `description` varchar(256) DEFAULT NULL COMMENT '权限描述,UI界面显示使用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='权限表';

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('e8b9a3ba3dc511e7b5a200ff3db8cbf4', '管理员', 'super_admin', '管理员');
INSERT INTO `permission` VALUES ('f039e3bb3dc511e7b5a200ff3db8cbf4', '用户新增', 'user:create', '用户新增');
INSERT INTO `permission` VALUES ('f4e50d4f3dc511e7b5a200ff3db8cbf4', '用户更新', 'user:update', '用户更新');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` varchar(40) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `product_name` varchar(60) DEFAULT NULL,
  `min_amt` decimal(10,2) DEFAULT NULL,
  `max_amt` decimal(10,2) DEFAULT NULL,
  `rate` decimal(10,6) DEFAULT NULL,
  `use_date` int(11) DEFAULT NULL,
  `created_time` char(20) DEFAULT NULL,
  `creator_id` varchar(50) DEFAULT NULL,
  `modified_time` char(20) DEFAULT NULL,
  `modifier_id` varchar(50) DEFAULT NULL,
  `record_state` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------

-- ----------------------------
-- Table structure for repayment_detail
-- ----------------------------
DROP TABLE IF EXISTS `repayment_detail`;
CREATE TABLE `repayment_detail` (
  `id` varchar(40) NOT NULL,
  `pan_id` varchar(40) DEFAULT NULL,
  `repay_date` char(10) DEFAULT NULL,
  `pay_corpus` decimal(10,2) DEFAULT NULL,
  `pay_accrual` decimal(10,2) DEFAULT NULL,
  `created_time` char(20) DEFAULT NULL,
  `creator_id` varchar(50) DEFAULT NULL,
  `modified_time` char(20) DEFAULT NULL,
  `modifier_id` varchar(50) DEFAULT NULL,
  `record_state` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of repayment_detail
-- ----------------------------

-- ----------------------------
-- Table structure for repayment_plan
-- ----------------------------
DROP TABLE IF EXISTS `repayment_plan`;
CREATE TABLE `repayment_plan` (
  `id` varchar(40) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `app_id` varchar(40) DEFAULT NULL,
  `begin_date` char(10) DEFAULT NULL,
  `end_date` char(10) DEFAULT NULL,
  `app_amt` decimal(10,2) DEFAULT NULL,
  `payed_corpus` decimal(10,2) DEFAULT NULL,
  `unpay_corpus` decimal(10,2) DEFAULT NULL,
  `repay_accrual` decimal(10,2) DEFAULT NULL,
  `payed_accrual` decimal(10,2) DEFAULT NULL,
  `rate` decimal(10,6) DEFAULT NULL,
  `repay_state` char(0) DEFAULT NULL,
  `created_time` char(20) DEFAULT NULL,
  `creator_id` varchar(50) DEFAULT NULL,
  `modified_time` char(20) DEFAULT NULL,
  `modifier_id` varchar(50) DEFAULT NULL,
  `record_state` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `credit_Index` (`app_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of repayment_plan
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` varchar(40) NOT NULL COMMENT '角色id',
  `role_name` varchar(32) DEFAULT NULL COMMENT '角色名',
  `role_sign` varchar(128) DEFAULT NULL COMMENT '角色标识,程序中判断使用,如"admin"',
  `description` varchar(256) DEFAULT NULL COMMENT '角色描述,UI界面显示使用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='角色表';

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('d716bea23f9411e7811200ff3db8cbf4', '保理商', 'factor', '保理商');
INSERT INTO `role` VALUES ('ec17577e3f9411e7811200ff3db8cbf4', '核心企业', 'core_company', '核心企业');
INSERT INTO `role` VALUES ('f791caf93f9411e7811200ff3db8cbf4', '下游企业', 'downstream_firms', '下游企业');
INSERT INTO `role` VALUES ('ffb140553dc511e7b5a200ff3db8cbf4', 'admin', 'admin', '管理员');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` varchar(40) NOT NULL COMMENT '表id',
  `role_id` varchar(40) DEFAULT NULL COMMENT '角色id',
  `permission_id` varchar(40) DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='角色与权限关联表';

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('ef1357be3ec211e7811200ff3db8cbf4', 'ffb140553dc511e7b5a200ff3db8cbf4', 'e8b9a3ba3dc511e7b5a200ff3db8cbf4');
INSERT INTO `role_permission` VALUES ('f0338c713f9411e7811200ff3db8cbf4', 'd716bea23f9411e7811200ff3db8cbf4', '');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(40) NOT NULL COMMENT '用户id',
  `name` varchar(20) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `password` char(64) DEFAULT NULL COMMENT '密码',
  `state` varchar(32) DEFAULT NULL COMMENT '状态',
  `create_time` varchar(20) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('16e6d7553dc611e7b5a200ff3db8cbf4', '吴思楠', 'admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', '', '2014-07-17 12:59:08');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` varchar(40) NOT NULL COMMENT '表id',
  `user_id` varchar(40) DEFAULT NULL COMMENT '用户id',
  `role_id` varchar(40) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='用户与角色关联表';

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('b5c0b67d3ed111e7811200ff3db8cbf4', '16e6d7553dc611e7b5a200ff3db8cbf4', 'ffb140553dc511e7b5a200ff3db8cbf4');

-- ----------------------------
-- Function structure for newUUID
-- ----------------------------
DROP FUNCTION IF EXISTS `newUUID`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `newUUID`() RETURNS varchar(40) CHARSET utf8
BEGIN
	select replace(uuid(), '-', '') into @reslut;
	RETURN @reslut;
END
;;
DELIMITER ;
