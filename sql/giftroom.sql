USE `giftroom`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NULL COMMENT '用户名 注册后不可修改 唯一',
  `nickname` varchar(45) NOT NULL COMMENT '昵称 可修改',
  `realname` varchar(45) NULL DEFAULT '' COMMENT '姓名',
  `password` varchar(45) NOT NULL DEFAULT '' COMMENT '密码',
  `gender` varchar(10) NULL COMMENT '性别',
  `telnumber` varchar(12) NOT NULL COMMENT '手机号',
  `user_type` int(11) NOT NULL DEFAULT 1 COMMENT '用户类型 1-普通会员 2-vip',
  `user_status` int(11) NOT NULL DEFAULT 1 COMMENT '用户状态 0-注销 1-正常',
  `reg_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  `modify_time` timestamp NOT NULL DEFAULT '2017-10-21 00:00:00' COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT '用户表';

CREATE TABLE `rooms` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num` varchar(45) NOT NULL COMMENT '房间号-唯一',
  `name` varchar(45) NOT NULL COMMENT '房间名',
  `url` varchar(45) NOT NULL DEFAULT '' COMMENT '房间路径',
  `picture` varchar(45) NOT NULL DEFAULT '' COMMENT '房间图像路径',
  `onlinenum` INTEGER NOT NULL DEFAULT 0 COMMENT '房间在线人数',
  `status` int(11) NOT NULL DEFAULT 1 COMMENT '房间状态 0-删除 1-正常',
  `c1` varchar(12) NULL COMMENT '扩展1',
  `c2` int(11) NULL COMMENT '扩展2',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT '房间表';

INSERT INTO rooms (id,num,name, url, picture, onlinenum, status, c1, c2) VALUE (1, "10001","测试房间1",'','',0,1,null,null);
INSERT INTO rooms (id,num,name, url, picture, onlinenum, status, c1, c2) VALUE (2, "10002","测试房间2",'','',0,1,null,null);
INSERT INTO rooms (id,num,name, url, picture, onlinenum, status, c1, c2) VALUE (3, "10003","测试房间3",'','',0,1,null,null);
INSERT INTO rooms (id,num,name, url, picture, onlinenum, status, c1, c2) VALUE (4, "10004","测试房间4",'','',0,1,null,null);
INSERT INTO rooms (id,num,name, url, picture, onlinenum, status, c1, c2) VALUE (5, "10005","测试房间5",'','',0,1,null,null);
