
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `available` int(1) NULL DEFAULT 1 COMMENT '是否可用，1 可用，0 不可用',
  `create_time` datetime(6) NULL DEFAULT NULL COMMENT '创建时间',
  `deleted` int(1) NULL DEFAULT 0 COMMENT '是否删除，0 未删除， 1 删除',
  `update_time` datetime(6) NULL DEFAULT NULL COMMENT '修改时间',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `salt` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '盐',
  `sex` int(1) NULL DEFAULT NULL COMMENT '性别 0未知 1女 2男',
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '姓名',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_info_user_name`(`user_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, 1, '2020-12-30 10:59:22.386000', 0, '2020-12-30 10:59:22.386000', NULL, '1111@qq.com', '55555', '1234567890', NULL, 0, 'test1');
INSERT INTO `user_info` VALUES (2, 1, '2020-12-30 10:59:43.250000', 0, '2020-12-30 10:59:43.250000', NULL, '1111@qq.com', '55555', '1234567890', NULL, 0, 'test2');
INSERT INTO `user_info` VALUES (3, 1, '2020-12-30 10:59:57.773000', 0, '2020-12-30 10:59:57.773000', NULL, '1111@qq.com', '55555', '1234567890', NULL, 0, 'test3');
INSERT INTO `user_info` VALUES (4, 1, '2020-12-30 11:05:33.969000', 0, '2020-12-30 11:05:33.970000', NULL, '1111@qq.com', '55555', '1234567890', NULL, 0, 'test4');

SET FOREIGN_KEY_CHECKS = 1;
