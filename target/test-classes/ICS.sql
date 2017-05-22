DROP TABLE IF EXISTS `financing_application`;
CREATE TABLE `financing_application` (
  `id` varchar(32) NOT NULL COMMENT '主键id',
  `proposer` varchar(500) NOT NULL COMMENT '申请人',
  `identity` varchar(500) NOT NULL COMMENT '身份',
  `credit_id` varchar(32) NOT NULL COMMENT '信誉表id',
  `financing_type` varchar(500) NOT NULL COMMENT '融资方式',
  `amount` varchar(32) NOT NULL COMMENT '融资金额',
  `submit_date` date NOT NULL COMMENT '申请日期',
  `state` varchar(4) NOT NULL COMMENT '流程状态',
  `updated_by` varchar(200) COMMENT '更新人',
  `updated_date` date COMMENT '更新日期',
  `created_by` varchar(200) COMMENT '创建者',
  `created_date` date COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='融资申请表';

DROP TABLE IF EXISTS `credit`;
CREATE TABLE `credit` (
  `id` varchar(32) NOT NULL COMMENT '主键id',
  `star` varchar(4) NOT NULL COMMENT '信誉星级',
  `amount_ceiling` varchar(32) NOT NULL COMMENT '融资金额上限',
  `updated_by` varchar(200) COMMENT '更新人',
  `updated_date` date COMMENT '更新日期',
  `created_by` varchar(200) COMMENT '创建者',
  `created_date` date COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='信誉等级表';


DROP TABLE IF EXISTS `repayment`;
CREATE TABLE `repayment` (
  `id` varchar(32) NOT NULL COMMENT '主键id',
  `application_id` varchar(32) NOT NULL COMMENT '申请表id',
  `is_pay_off` varchar(4) NOT NULL COMMENT '是否还清',
  `total_amount` varchar(32) NOT NULL COMMENT '应还金额',
  `bad_record` varchar(32) NOT NULL COMMENT '不良记录次数',
  `rate` varchar(32) NOT NULL COMMENT '利率',
  `updated_by` varchar(200) COMMENT '更新人',
  `updated_date` date COMMENT '更新日期',
  `created_by` varchar(200) COMMENT '创建者',
  `created_date` date COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='还款表';

DROP TABLE IF EXISTS `repayment_record`;
CREATE TABLE `repayment_record` (
  `id` varchar(32) NOT NULL COMMENT '主键id',
  `repayment_id` varchar(32) NOT NULL COMMENT '还款表id',
  `period_begin` date NOT NULL COMMENT '还款周期开始时间',
  `period_end` date NOT NULL COMMENT '还款周期结束时间',
  `should_pay` varchar(32) NOT NULL COMMENT '每周期应还金额',
  `payed` varchar(32) NOT NULL COMMENT '每周期实还金额',
  `rate_period` varchar(32) NOT NULL COMMENT '每周期内利率',
  `updated_by` varchar(200) COMMENT '更新人',
  `updated_date` date COMMENT '更新日期',
  `created_by` varchar(200) COMMENT '创建者',
  `created_date` date COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='还款记录表';
