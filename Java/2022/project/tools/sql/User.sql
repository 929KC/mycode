SET FOREIGN_KEY_CHECKS=0;


DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
                        `id` int(11) NOT NULL COMMENT '用户编号',
                        `role` varchar(1) NOT NULL COMMENT '角色（0：管理员，1：普通用户）',
                        `name` varchar(10) NOT NULL COMMENT '姓名',
                        `password` varchar(20) NOT NULL COMMENT '登录密码',
                        `id_card` varchar(20) NOT NULL COMMENT '身份证号',
                        `phone` varchar(11) NOT NULL COMMENT '电话号码',
                        `gender` varchar(1) NOT NULL COMMENT '性别：''男''&''女''',
                        `entry_time` date DEFAULT NULL COMMENT '时间',
                        `status` varchar(1) NOT NULL COMMENT '状态（0：异常，1：正常）',
                        PRIMARY KEY (`id`) USING BTREE,
                        UNIQUE KEY `id_card` (`id_card`) USING BTREE,
                        UNIQUE KEY `phone` (`phone`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

INSERT INTO `user` VALUES ('123456', '0', '马经理', '123456', '441735197603083473', '16778125803', '女', '2016-08-19', '1');
INSERT INTO `user` VALUES ('1703001', '1', '邓布利多', '123456', '447155185404257737', '18234234672', '男', '2017-03-06', '1');
INSERT INTO `user` VALUES ('1810001', '1', '何熙洋', '123456', '451444189404143116', '18152812298', '男', '2018-10-08', '1');
INSERT INTO `user` VALUES ('1810002', '1', '赫敏·格兰杰', '123456', '464623180411106738', '18757331422', '女', '2018-10-29', '1');
INSERT INTO `user` VALUES ('1812001', '1', '罗冠杰', '123456', '421752198911232716', '15862113190', '男', '2018-12-12', '1');
INSERT INTO `user` VALUES ('1901001', '1', '张晓兰', '123456', '46152119900316571X', '18255406146', '女', '2019-01-08', '1');




