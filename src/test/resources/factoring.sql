/*
Navicat MySQL Data Transfer

Source Server         : aaa
Source Server Version : 50709
Source Host           : localhost:3306
Source Database       : factoring

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2017-05-22 17:35:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for credit
-- ----------------------------
DROP TABLE IF EXISTS `credit`;
CREATE TABLE `credit` (
  `id` varchar(32) NOT NULL COMMENT '����id',
  `star` varchar(4) NOT NULL COMMENT '�����Ǽ�',
  `amount_ceiling` varchar(32) NOT NULL COMMENT '���ʽ������',
  `updated_by` varchar(200) DEFAULT NULL COMMENT '������',
  `updated_date` date DEFAULT NULL COMMENT '��������',
  `created_by` varchar(200) DEFAULT NULL COMMENT '������',
  `created_date` date DEFAULT NULL COMMENT '��������',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='�����ȼ���';

-- ----------------------------
-- Records of credit
-- ----------------------------

-- ----------------------------
-- Table structure for financing_application
-- ----------------------------
DROP TABLE IF EXISTS `financing_application`;
CREATE TABLE `financing_application` (
  `id` varchar(32) NOT NULL COMMENT '����id',
  `proposer` varchar(500) NOT NULL COMMENT '������',
  `identity` varchar(500) NOT NULL COMMENT '���',
  `credit_id` varchar(32) NOT NULL COMMENT '������id',
  `financing_type` varchar(500) NOT NULL COMMENT '���ʷ�ʽ',
  `amount` varchar(32) NOT NULL COMMENT '���ʽ��',
  `submit_date` date NOT NULL COMMENT '��������',
  `state` varchar(4) NOT NULL COMMENT '����״̬',
  `updated_by` varchar(200) DEFAULT NULL COMMENT '������',
  `updated_date` date DEFAULT NULL COMMENT '��������',
  `created_by` varchar(200) DEFAULT NULL COMMENT '������',
  `created_date` date DEFAULT NULL COMMENT '��������',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='���������';

-- ----------------------------
-- Records of financing_application
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
-- Table structure for repayment
-- ----------------------------
DROP TABLE IF EXISTS `repayment`;
CREATE TABLE `repayment` (
  `id` varchar(32) NOT NULL COMMENT '����id',
  `application_id` varchar(32) NOT NULL COMMENT '�����id',
  `is_pay_off` varchar(4) NOT NULL COMMENT '�Ƿ���',
  `total_amount` varchar(32) NOT NULL COMMENT 'Ӧ�����',
  `bad_record` varchar(32) NOT NULL COMMENT '������¼����',
  `rate` varchar(32) NOT NULL COMMENT '����',
  `updated_by` varchar(200) DEFAULT NULL COMMENT '������',
  `updated_date` date DEFAULT NULL COMMENT '��������',
  `created_by` varchar(200) DEFAULT NULL COMMENT '������',
  `created_date` date DEFAULT NULL COMMENT '��������',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='�����';

-- ----------------------------
-- Records of repayment
-- ----------------------------

-- ----------------------------
-- Table structure for repayment_record
-- ----------------------------
DROP TABLE IF EXISTS `repayment_record`;
CREATE TABLE `repayment_record` (
  `id` varchar(32) NOT NULL COMMENT '����id',
  `repayment_id` varchar(32) NOT NULL COMMENT '�����id',
  `period_begin` date NOT NULL COMMENT '�������ڿ�ʼʱ��',
  `period_end` date NOT NULL COMMENT '�������ڽ���ʱ��',
  `should_pay` varchar(32) NOT NULL COMMENT 'ÿ����Ӧ�����',
  `payed` varchar(32) NOT NULL COMMENT 'ÿ����ʵ�����',
  `rate_period` varchar(32) NOT NULL COMMENT 'ÿ����������',
  `updated_by` varchar(200) DEFAULT NULL COMMENT '������',
  `updated_date` date DEFAULT NULL COMMENT '��������',
  `created_by` varchar(200) DEFAULT NULL COMMENT '������',
  `created_date` date DEFAULT NULL COMMENT '��������',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='�����¼��';

-- ----------------------------
-- Records of repayment_record
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
INSERT INTO `role` VALUES ('ffb140553dc511e7b5a200ff3db8cbf4', 'admin', 'admin', '管理员');
INSERT INTO `role` VALUES ('ffb659083dc511e7b5a200ff3db8cbf4', 'merchant1', 'merchant', '商家');

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
INSERT INTO `role_permission` VALUES ('a6162dac3de811e7b5a200ff3db8cbf4', 'ffb659083dc511e7b5a200ff3db8cbf4', 'f039e3bb3dc511e7b5a200ff3db8cbf4');
INSERT INTO `role_permission` VALUES ('ef1357be3ec211e7811200ff3db8cbf4', 'ffb140553dc511e7b5a200ff3db8cbf4', 'e8b9a3ba3dc511e7b5a200ff3db8cbf4');

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
