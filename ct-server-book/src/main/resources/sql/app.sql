--
CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `t_card_info` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键自增id',
  `bank` varchar(50) NOT NULL DEFAULT '' COMMENT '银行',
  `card_no` varchar(50) NOT NULL DEFAULT '' COMMENT '卡号',
  `bill_date` varchar(50) NOT NULL DEFAULT '' COMMENT '账单日',
  `bill_last_data` varchar(50) NOT NULL DEFAULT '' COMMENT '最后还款日',
  `fee` varchar(50) NOT NULL DEFAULT '' COMMENT '年费',
  `policy` varchar(100) NOT NULL DEFAULT '' COMMENT '年费政策',
  `create_time` datetime NOT NULL COMMENT '时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_tid` (`card_no`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='卡信息表';

CREATE TABLE `t_card_swipe` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键自增id',
  `bid` bigint(20) DEFAULT NULL COMMENT '关联卡id',
  `card_no` varchar(50) NOT NULL DEFAULT '' COMMENT '卡号',
  `amount` varchar(50) NOT NULL DEFAULT '' COMMENT '消费金额',
  `platform` varchar(50) NOT NULL DEFAULT '' COMMENT '消费平台：',
  `machine_type` varchar(50) NOT NULL DEFAULT '' COMMENT '机具类型',
  `rate` varchar(10) NOT NULL DEFAULT '' COMMENT '费率',
  `commission` varchar(10) NOT NULL DEFAULT '' COMMENT '佣金',
  `consume_date` varchar(50) NOT NULL DEFAULT '' COMMENT '消费日期',
  `bill_cycle` varchar(50) NOT NULL DEFAULT '' COMMENT '账期',
  `mcc` varchar(20) NOT NULL DEFAULT '' COMMENT 'mcc类型',
  `create_time` datetime NOT NULL COMMENT '时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_cno` (`card_no`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='刷卡信息';