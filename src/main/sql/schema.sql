--创建数据库脚本

--创建数据库
CREATE DATABASE seckill;
--使用数据库
use seckill;

CREATE TABLE seckill (
    `seckill_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '商品库存ID',
    `name` VARCHAR(50) NOT NULL COMMENT '商品名称',
    `number` INT NOT NULL COMMENT '库存数量',
    `start_time` TIMESTAMP NOT NULL COMMENT '秒杀开始时间',
    `end_time` TIMESTAMP NOT NULL COMMENT '秒杀结束时间',
    `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (seckill_id),
    key idx_start_time(start_time),
    key idx_end_time(end_time),
    key idx_create_time(create_time)
)ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT '秒杀库存表' ;


-- 初始化数据
INSERT into seckill(name,number,start_time,end_time)
VALUES
  ('1000元秒杀iphone6',100,'2016-01-01 00:00:00','2016-01-02 00:00:00'),
  ('800元秒杀ipad',200,'2016-01-01 00:00:00','2016-01-02 00:00:00'),
  ('6600元秒杀mac book pro',300,'2016-01-01 00:00:00','2016-01-02 00:00:00'),
  ('7000元秒杀iMac',400,'2016-01-01 00:00:00','2016-01-02 00:00:00');

--秒杀成功明细表
--用户登陆认证信息简化为手机号码
CREATE TABLE success_killed(
    `seckill_id` BIGINT NOT NULL COMMENT '商品ID',
    `user_phone` VARCHAR(20) NOT NULL COMMENT '用户手机号码'
    `state` TINYINT NOT NULL DEFAULT -1 COMMENT,
    `create_time` TIMESTAMP NOT NULL COMMENT '创建时间',
    PRIMARY KEY (seckill_id,user_phone),/*联合组建*/
    key idx_create_time(create_time)
)ENGINE=INNODB  DEFAULT CHARSET=utf8 COMMENT '秒杀成功明细表';

-- SHOW CREATE TABLE seckill;#显示表的创建信息