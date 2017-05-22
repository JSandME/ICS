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
  `updated_by` varchar(200) COMMENT '������',
  `updated_date` date COMMENT '��������',
  `created_by` varchar(200) COMMENT '������',
  `created_date` date COMMENT '��������',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='���������';

DROP TABLE IF EXISTS `credit`;
CREATE TABLE `credit` (
  `id` varchar(32) NOT NULL COMMENT '����id',
  `star` varchar(4) NOT NULL COMMENT '�����Ǽ�',
  `amount_ceiling` varchar(32) NOT NULL COMMENT '���ʽ������',
  `updated_by` varchar(200) COMMENT '������',
  `updated_date` date COMMENT '��������',
  `created_by` varchar(200) COMMENT '������',
  `created_date` date COMMENT '��������',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='�����ȼ���';


DROP TABLE IF EXISTS `repayment`;
CREATE TABLE `repayment` (
  `id` varchar(32) NOT NULL COMMENT '����id',
  `application_id` varchar(32) NOT NULL COMMENT '�����id',
  `is_pay_off` varchar(4) NOT NULL COMMENT '�Ƿ���',
  `total_amount` varchar(32) NOT NULL COMMENT 'Ӧ�����',
  `bad_record` varchar(32) NOT NULL COMMENT '������¼����',
  `rate` varchar(32) NOT NULL COMMENT '����',
  `updated_by` varchar(200) COMMENT '������',
  `updated_date` date COMMENT '��������',
  `created_by` varchar(200) COMMENT '������',
  `created_date` date COMMENT '��������',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='�����';

DROP TABLE IF EXISTS `repayment_record`;
CREATE TABLE `repayment_record` (
  `id` varchar(32) NOT NULL COMMENT '����id',
  `repayment_id` varchar(32) NOT NULL COMMENT '�����id',
  `period_begin` date NOT NULL COMMENT '�������ڿ�ʼʱ��',
  `period_end` date NOT NULL COMMENT '�������ڽ���ʱ��',
  `should_pay` varchar(32) NOT NULL COMMENT 'ÿ����Ӧ�����',
  `payed` varchar(32) NOT NULL COMMENT 'ÿ����ʵ�����',
  `rate_period` varchar(32) NOT NULL COMMENT 'ÿ����������',
  `updated_by` varchar(200) COMMENT '������',
  `updated_date` date COMMENT '��������',
  `created_by` varchar(200) COMMENT '������',
  `created_date` date COMMENT '��������',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='�����¼��';
