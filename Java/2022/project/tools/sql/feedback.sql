DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
                            `id` varchar(36) NOT NULL COMMENT '主键',
                            `content` varchar(255) NOT NULL COMMENT '问题/建议内容',
                            `status` tinyint(2) NOT NULL DEFAULT '1' COMMENT '是否有效 1是0否',
                            `type` tinyint(2) DEFAULT NULL COMMENT '类型 0：问题 1：建议 2：其他',
                            `contact_way` tinyint(2) DEFAULT NULL COMMENT '联系方式：0：无 1：QQ 2：微信 3：邮箱 4：其他',
                            `contact_no` varchar(16) DEFAULT NULL COMMENT '联系号码',
                            `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                            PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;



INSERT INTO `feedback` VALUES ('18d6e41ab9674caf986325c72601', '伏尔泰太1热', '1', '1', '2', 'rtret', '2022-07-15 23:24:10');
INSERT INTO `feedback` VALUES ('18d6e41ab9674caf9865c7260', '伏尔泰太热', '1', '2', '2', 'rtret', '2022-07-15 23:13:30');
INSERT INTO `feedback` VALUES ('18d6e41ab9674caf9865c72601', '伏尔泰太1热', '1', '1', '2', 'rtret', '2022-07-15 23:20:26');
INSERT INTO `feedback` VALUES ('18d6e41ab9674caf9865c726e138aa30', '伏尔泰太热', '1', '2', '2', 'rtret', '2022-07-13 21:42:23');
INSERT INTO `feedback` VALUES ('1c04853910d5413d9376f7c76d329540', '234234324', '1', '1', '2', '234324234', '2022-07-13 21:41:16');
INSERT INTO `feedback` VALUES ('1c04853910d5413d937c76d329540', '234234324', '1', '1', '2', '234324234', '2022-07-15 23:13:31');
INSERT INTO `feedback` VALUES ('3fc759cbdfb6487b817a4f717360cae6', '78768', '1', '1', '3', '768976867', '2022-07-13 21:41:37');
INSERT INTO `feedback` VALUES ('3fc759cbdfb6487b817a4f760cae6', '78768', '1', '1', '3', '768976867', '2022-07-15 23:13:31');
INSERT INTO `feedback` VALUES ('4a828d5c2c5f467e8a40808f9ca3898f', '伏尔泰太1热', '1', '1', '2', 'rtret', '2022-07-15 23:58:21');
INSERT INTO `feedback` VALUES ('56c7320dea854bfd88050261bcb1da79', '768678678', '1', '3', '2', '678678678', '2022-07-13 21:41:47');
INSERT INTO `feedback` VALUES ('56c7320dea854bfd8805026da79', '768678678', '1', '3', '2', '678678678', '2022-07-15 23:13:30');
INSERT INTO `feedback` VALUES ('5e1479503e0346d4b5234dcb2185', '破', '1', '3', '3', 'i;o;', '2022-07-15 23:13:31');
INSERT INTO `feedback` VALUES ('5e1479503e0346d4b523b4cd4dcb2185', '破', '1', '3', '3', 'i;o;', '2022-07-04 23:09:56');
INSERT INTO `feedback` VALUES ('601fab8195504047be68d79cf8e529b7', '伏尔泰太1热11', '1', '1', '2', 'rtret', '2022-07-15 23:58:21');
INSERT INTO `feedback` VALUES ('67c4fb3110734a4722bda62486291', '伏尔泰太1热11', '1', '1', '2', 'rtret', '2022-07-15 23:24:10');
INSERT INTO `feedback` VALUES ('67c4fb3110734a47bda6248627ebe399', '伏尔泰太热', '1', '2', '2', 'rtret', '2022-07-13 21:42:21');
INSERT INTO `feedback` VALUES ('67c4fb3110734a47bda6248629', '伏尔泰太热', '1', '2', '2', 'rtret', '2022-07-15 23:13:30');
INSERT INTO `feedback` VALUES ('67c4fb3110734a47bda62486291', '伏尔泰太1热11', '1', '1', '2', 'rtret', '2022-07-15 23:20:26');
INSERT INTO `feedback` VALUES ('6f5ca2ef83e94e619d41ea572727cf15', '99', '1', '1', '1', '6666', '2022-07-19 23:20:57');
INSERT INTO `feedback` VALUES ('75bff67ee02d479596b677e66d14', '大声点', '1', '2', '2', '萨达萨达', '2022-07-15 23:13:30');
INSERT INTO `feedback` VALUES ('75bff67ee02d479596b677e66db9ef14', '大声点', '1', '2', '2', '萨达萨达', '2022-07-13 21:42:13');
INSERT INTO `feedback` VALUES ('8c9e1f5dc1a741e785437f452d749cb3', '-==】-=】', '1', '3', '1', '=8i87u', '2022-07-03 11:42:27');
INSERT INTO `feedback` VALUES ('9238654d6b774f96bdbfa0ea610d7f', '78768', '1', '1', '3', '768976867', '2022-07-15 23:13:31');
INSERT INTO `feedback` VALUES ('9238654d6b774f96bdbfa0f1ea610d7f', '78768', '1', '1', '3', '768976867', '2022-07-13 21:41:36');
INSERT INTO `feedback` VALUES ('ae82910b27d049b19c3dad92e8547606', '头uty', '1', '2', '2', 'i;iuop', '2022-07-03 11:41:58');
INSERT INTO `feedback` VALUES ('aebaf1f6f84a4c9fb73eb31ac5034413', '伏尔泰太1热11', '1', '1', '2', 'rtret', '2022-07-15 23:27:01');
INSERT INTO `feedback` VALUES ('af59abfbbe124ead82154d389456b3bd', '伏尔泰太1热', '1', '1', '2', 'rtret', '2022-07-15 23:27:19');
INSERT INTO `feedback` VALUES ('d1b078d6a0754f898d6644df72b4a7ba', '去', '1', '3', '1', '324234', '2022-07-13 21:41:03');
INSERT INTO `feedback` VALUES ('d1b078d6a0754f898d66f72b4a7ba', '去', '1', '3', '1', '324234', '2022-07-15 23:13:31');
INSERT INTO `feedback` VALUES ('d5dea27c9dfe49bd80f3eff378ca6160', '伏尔泰太1热11', '1', '1', '2', 'rtret', '2022-07-15 23:27:19');
INSERT INTO `feedback` VALUES ('e89e84aca36e4b729753d93ad11636e1', '伏尔泰太1热', '1', '1', '2', 'rtret', '2022-07-15 23:27:01');
INSERT INTO `feedback` VALUES ('f26ca4108fc440399ed014ebfdaba011', 'のwqrwer', '1', '1', '1', 'gfdgfdg', '2022-07-13 21:41:29');
INSERT INTO `feedback` VALUES ('f26ca4108fc440399ed0bfdaba011', 'のwqrwer', '1', '1', '1', 'gfdgfdg', '2022-07-15 23:13:31');