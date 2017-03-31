﻿
--產品
DROP TABLE IF EXISTS `sun_product`;
CREATE TABLE `sun_product` (
	`id` VARCHAR(100) NOT NULL COMMENT '流水編號',
	`name` VARCHAR(50) NOT NULL COMMENT '產品名稱',
	`price` DECIMAL(10,2) NOT NULL DEFAULT 0 COMMENT '價格',
	`create_time` DATETIME NOT NULL COMMENT '建立時間',
	PRIMARY KEY (`id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;

--帳號
DROP TABLE IF EXISTS `sun_account`;
CREATE TABLE `sun_account` (
	`id` VARCHAR(50) NOT NULL COMMENT '帳號id',
	`account` VARCHAR(20) NOT NULL COMMENT '帳號',
	`password` VARCHAR(20) NOT NULL COMMENT '密碼',
	`user_id` VARCHAR(50) NOT NULL COMMENT '使用者id',
	`status` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '狀態:0=正常',
	`create_time` DATETIME NOT NULL COMMENT '建立時間',
	PRIMARY KEY (`id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;

--使用者
DROP TABLE IF EXISTS `sun_user`;
CREATE TABLE `sun_user` (
	`id` VARCHAR(50) NOT NULL COMMENT '使用者id',
	`name` VARCHAR(50) NOT NULL COMMENT '使用者名稱',
	`nick_name` VARCHAR(50) NOT NULL COMMENT '使用者暱稱',
	`birthday` DATE NOT NULL COMMENT '生日',
	`create_time` DATETIME NOT NULL COMMENT '建立時間',
	PRIMARY KEY (`id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;