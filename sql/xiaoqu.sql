/*
 Navicat Premium Data Transfer

 Source Server         : Local-Mysql5.7
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : xiaoqu

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 27/04/2020 11:37:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `admin_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `admin_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `admin_sex` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `admin_age` int(5) NULL DEFAULT NULL,
  `create_date` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_date` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `roles` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像地址，代码中有默认地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, '88888888888', 'e10adc3949ba59abbe56e057f20f883e', '管理员A', '男', 22, '2020-03-03 15:11:57', '2020-04-24 11:24:07', 'admin', 'https://s2.ax1x.com/2019/07/17/ZLWJSA.gif?imageView2/1/w/80/h/80');
INSERT INTO `admin` VALUES (3, '12345678900', 'e10adc3949ba59abbe56e057f20f883e', '张三', '男', 6, '2020-03-03 20:13:23', '2020-04-24 11:24:05', 'editor', 'https://s2.ax1x.com/2019/07/17/ZLWJSA.gif?imageView2/1/w/80/h/80');
INSERT INTO `admin` VALUES (4, '12345678901', '14e1b600b1fd579f47433b88e8d85291', '李四2', '女', 5, '2020-03-03 20:17:13', '2020-04-24 11:24:05', 'editor', 'https://s2.ax1x.com/2019/07/17/ZLWJSA.gif?imageView2/1/w/80/h/80');
INSERT INTO `admin` VALUES (8, '66666666666', 'e10adc3949ba59abbe56e057f20f883e', '东方不败', '女', 6, '2020-03-20 16:15:05', '2020-04-24 11:24:05', 'editor', 'https://s2.ax1x.com/2019/07/17/ZLWJSA.gif?imageView2/1/w/80/h/80');

-- ----------------------------
-- Table structure for backup
-- ----------------------------
DROP TABLE IF EXISTS `backup`;
CREATE TABLE `backup`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_id` int(11) NULL DEFAULT NULL COMMENT '操作者id',
  `backup_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `backup_text` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备份信息',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of backup
-- ----------------------------
INSERT INTO `backup` VALUES (1, 1, 'E:\\xiaoqu\\xiaoqu_data_backup\\2020-04-06-09-42-53.sql', '第一次备份', '2020-04-06 09:42:53');
INSERT INTO `backup` VALUES (2, 1, 'E:\\xiaoqu\\xiaoqu_data_backup\\2020-04-06-09-58-39.sql', '测试第二次备份这个数据', '2020-04-06 09:58:39');
INSERT INTO `backup` VALUES (3, 3, 'E:\\xiaoqu\\xiaoqu_data_backup\\2020-04-06-10-27-18.sql', '我是张三，来备份数据试试', '2020-04-06 10:27:18');

-- ----------------------------
-- Table structure for building
-- ----------------------------
DROP TABLE IF EXISTS `building`;
CREATE TABLE `building`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bu_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '楼房名字',
  `bu_home` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '楼房地址',
  `bu_remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `create_date` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_date` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of building
-- ----------------------------
INSERT INTO `building` VALUES (1, '金鑫A单元楼', '803房', '这是备注222', '2020-03-04 21:23:09', '2020-03-04 21:23:09');
INSERT INTO `building` VALUES (2, '金鑫B单元楼', '806房', '这是备注1', '2020-03-04 21:23:09', '2020-03-04 21:23:52');
INSERT INTO `building` VALUES (3, '金鑫A单元楼', '888房', '没装修', '2020-03-04 21:51:35', '2020-03-04 21:51:35');
INSERT INTO `building` VALUES (4, '金鑫A单元楼', '878房', '采光好', '2020-03-04 22:01:12', '2020-03-04 22:01:12');
INSERT INTO `building` VALUES (5, '康龙国际C楼', '101', '低楼房，采光不好', '2020-03-05 12:53:44', '2020-03-05 12:53:44');
INSERT INTO `building` VALUES (6, '龙门花园A栋', '101房间', '豪华装修', '2020-03-30 16:23:56', '2020-03-30 16:23:56');

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL COMMENT '停车位所属的用户',
  `car_addr` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '停车位位置',
  `car_long` float(6, 2) NULL DEFAULT NULL COMMENT '停车位长度',
  `car_width` float(6, 2) NULL DEFAULT NULL COMMENT '停车位宽度',
  `car_remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `create_date` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_date` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of car
-- ----------------------------
INSERT INTO `car` VALUES (1, 1, '车位再北楼，地下2层，最右边2', 3.10, 2.10, '第一个车位添加完毕2', '2020-03-06 22:38:06', '2020-03-06 23:33:28');
INSERT INTO `car` VALUES (3, 9, '车位再北楼，地下2层，最右边2', 3.10, 2.10, '车位再北楼，地下2层，最右边2', '2020-03-06 22:39:45', '2020-03-06 23:34:13');
INSERT INTO `car` VALUES (4, 9, 'B楼左侧 第三个 B003号', 3.00, 2.00, '有点小', '2020-03-06 22:56:41', '2020-03-06 23:33:52');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `topic_id` int(11) NULL DEFAULT NULL COMMENT '所属话题',
  `comment_text` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '评论内容',
  `comment_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '评论中附带的图片',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '评论者id',
  `comment_parent_id` int(11) NOT NULL DEFAULT 0 COMMENT '此评论的父评论，默认0 不属于其他评论',
  `comment_love` int(8) NOT NULL DEFAULT 0 COMMENT '点赞量',
  `create_date` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_date` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, 5, '这个问题呢很严重', '/jpg/2020-3-13/1584103050429.jpg,/jpg/2020-3-13/1584103050475.jpg,/jpg/2020-3-13/1584103050475.jpg', 1, 0, 14, '2020-03-13 13:01:42', '2020-03-14 21:51:41');
INSERT INTO `comment` VALUES (2, 5, '这是回复', '/jpg/2020-3-13/1584101046187.jpg', 1, 0, 2, '2020-03-13 20:04:05', '2020-03-13 20:04:05');
INSERT INTO `comment` VALUES (3, 5, '测试一下吧', '/jpg/2020-3-13/1584101046187.jpg', 2, 1, 2, '2020-03-13 20:08:09', '2020-03-13 22:16:51');
INSERT INTO `comment` VALUES (4, 5, '测试，，，，，，', '/jpg/2020-3-13/1584102944566.jpg', 3, 1, 4, '2020-03-13 20:35:44', '2020-03-13 22:16:52');
INSERT INTO `comment` VALUES (5, 5, '是是是是是是', '/jpg/2020-3-13/1584103050429.jpg,/jpg/2020-3-13/1584103050475.jpg', 4, 3, 0, '2020-03-13 20:37:30', '2020-03-13 22:16:59');
INSERT INTO `comment` VALUES (6, 5, '水水水水是是是寻寻寻寻寻寻寻', '/jpg/2020-3-13/1584103063114.jpg', 5, 3, 0, '2020-03-13 20:37:43', '2020-03-13 22:17:01');
INSERT INTO `comment` VALUES (7, 5, '啊啊啊啊啊啊啊啊', '/jpg/2020-3-13/1584103050429.jpg,/jpg/2020-3-13/1584103050475.jpg', 1, 5, 0, '2020-03-13 20:37:47', '2020-03-14 21:23:48');
INSERT INTO `comment` VALUES (8, 5, '嘻嘻嘻嘻嘻嘻嘻嘻寻寻寻寻', '', 1, 2, 0, '2020-03-13 20:37:50', '2020-03-13 20:39:06');
INSERT INTO `comment` VALUES (9, 5, '第三次评论', '', 1, 0, 1, '2020-03-14 13:06:45', '2020-03-14 13:06:45');
INSERT INTO `comment` VALUES (10, 5, '这是回复用户5的评论测试', '/jpg/2020-3-14/1584183594891.jpg', 1, 6, 0, '2020-03-14 18:59:54', '2020-03-14 18:59:54');
INSERT INTO `comment` VALUES (11, 5, '回复自己一下', '', 1, 9, 1, '2020-03-14 19:01:25', '2020-03-14 19:01:25');
INSERT INTO `comment` VALUES (12, 5, '哈哈哈  真有意思啊', '/jpg/2020-3-14/1584183728840.jpg', 1, 11, 0, '2020-03-14 19:02:08', '2020-03-14 19:02:08');
INSERT INTO `comment` VALUES (13, 6, '说的对，这个问题确实很严重啊！', '/jpg/2020-3-14/1584191632679.jpg', 4, 0, 1, '2020-03-14 21:13:52', '2020-03-14 21:13:52');
INSERT INTO `comment` VALUES (14, 6, '赞成，必须马上解决，要不会出事啊！', '', 10, 13, 0, '2020-03-14 21:14:33', '2020-03-14 21:14:33');
INSERT INTO `comment` VALUES (15, 6, '我去，还真是哈', '', 1, 14, 0, '2020-03-14 21:15:12', '2020-03-14 21:15:12');
INSERT INTO `comment` VALUES (16, 5, '哈哈哈 这个不错', '/jpg/2020-3-14/1584194431319.jpg,/png/2020-3-14/1584194431441.png', 1, 1, 3, '2020-03-14 22:00:31', '2020-03-14 22:00:31');
INSERT INTO `comment` VALUES (17, 5, '可以', '/jpg/2020-3-14/1584194544078.jpg,/jpg/2020-3-14/1584194544146.jpg,/png/2020-3-14/1584194544230.png', 1, 4, 1, '2020-03-14 22:02:23', '2020-03-14 22:02:23');
INSERT INTO `comment` VALUES (18, 5, '第四次评论啊', '/jpg/2020-3-14/1584196302111.jpg', 1, 0, 0, '2020-03-14 22:31:41', '2020-03-14 22:31:41');
INSERT INTO `comment` VALUES (19, 7, '我来测试一下！', '/jpg/2020-3-19/1584597554286.jpg', 1, 0, 3, '2020-03-19 13:59:15', '2020-03-19 13:59:15');
INSERT INTO `comment` VALUES (20, 7, '测试2 ', '/jpg/2020-3-19/1584597759920.jpg', 1, 0, 0, '2020-03-19 14:02:40', '2020-03-19 14:02:40');
INSERT INTO `comment` VALUES (22, 7, '回复自己试试', '/jpg/2020-3-19/1584597890680.jpg', 1, 19, 1, '2020-03-19 14:04:51', '2020-03-19 14:04:51');
INSERT INTO `comment` VALUES (23, 7, '真无聊', '', 1, 22, 1, '2020-03-19 14:04:59', '2020-03-19 14:04:59');
INSERT INTO `comment` VALUES (24, 7, '吧吧吧吧吧吧吧吧v     ', '/jpg/2020-3-19/1584598000494.jpg,/jpg/2020-3-19/1584598001795.jpg', 1, 20, 0, '2020-03-19 14:06:42', '2020-03-19 14:06:42');

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作者姓名',
  `operation` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作',
  `operation_status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作状态，成功，失败等',
  `date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '操作事件',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 49 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES (2, '管理员A', '登录', 'success', '2020-03-20 15:53:28');
INSERT INTO `log` VALUES (3, '管理员A', '删除管理员->风清扬', 'success', '2020-03-20 16:11:56');
INSERT INTO `log` VALUES (4, '管理员A', '新增管理员东方不败', '服务异常，新增失败！', '2020-03-20 16:15:05');
INSERT INTO `log` VALUES (5, '管理员A', '删除用户->用户4', 'success', '2020-03-20 17:05:42');
INSERT INTO `log` VALUES (6, '管理员A', '登录', 'success', '2020-03-20 20:58:33');
INSERT INTO `log` VALUES (7, '管理员A', '登录', 'success', '2020-03-30 16:11:50');
INSERT INTO `log` VALUES (8, '管理员A', '新增楼房信息->龙门花园A栋-101房间', 'success', '2020-03-30 16:23:56');
INSERT INTO `log` VALUES (9, '管理员A', '登录', 'success', '2020-03-30 16:39:57');
INSERT INTO `log` VALUES (10, '管理员A', '登录', 'success', '2020-04-05 20:49:18');
INSERT INTO `log` VALUES (11, '管理员A', '登录', 'success', '2020-04-05 22:59:00');
INSERT INTO `log` VALUES (12, '管理员A', '登录', 'success', '2020-04-06 09:41:16');
INSERT INTO `log` VALUES (13, '管理员A', '数据备份->第一次备份', 'success', '2020-04-06 09:42:53');
INSERT INTO `log` VALUES (14, '管理员A', '数据备份->测试第二次备份这个数据', 'success', '2020-04-06 09:58:39');
INSERT INTO `log` VALUES (15, '管理员A', '登录', 'success', '2020-04-06 10:01:23');
INSERT INTO `log` VALUES (16, '张三', '登录', 'success', '2020-04-06 10:26:51');
INSERT INTO `log` VALUES (17, '张三', '数据备份->我是张三，来备份数据试试', 'success', '2020-04-06 10:27:18');
INSERT INTO `log` VALUES (18, '管理员A', '登录', 'success', '2020-04-09 12:05:29');
INSERT INTO `log` VALUES (19, '管理员A', '新增物业缴费->水水水水是是是所所所所', 'success', '2020-04-09 15:34:42');
INSERT INTO `log` VALUES (20, '管理员A', '新增物业缴费->水水水水是是是所所所', 'success', '2020-04-09 15:35:02');
INSERT INTO `log` VALUES (21, '管理员A', '登录', 'success', '2020-04-09 16:46:05');
INSERT INTO `log` VALUES (22, '管理员A', '登录', 'success', '2020-04-09 17:09:31');
INSERT INTO `log` VALUES (23, '管理员A', '登录', 'success', '2020-04-14 10:49:05');
INSERT INTO `log` VALUES (24, '管理员A', '登录', 'success', '2020-04-14 10:51:40');
INSERT INTO `log` VALUES (25, '管理员A', '登录', 'success', '2020-04-20 09:43:43');
INSERT INTO `log` VALUES (26, '管理员A', '登录', 'success', '2020-04-23 11:35:57');
INSERT INTO `log` VALUES (27, '张三', '登录', 'success', '2020-04-23 12:09:22');
INSERT INTO `log` VALUES (28, '管理员A', '登录', 'success', '2020-04-23 12:13:07');
INSERT INTO `log` VALUES (29, '张三', '登录', 'success', '2020-04-23 12:14:19');
INSERT INTO `log` VALUES (30, '管理员A', '登录', 'success', '2020-04-23 18:01:43');
INSERT INTO `log` VALUES (31, '管理员A', '登录', 'success', '2020-04-24 10:07:37');
INSERT INTO `log` VALUES (32, '张三', '登录', 'success', '2020-04-24 10:38:58');
INSERT INTO `log` VALUES (33, '管理员A', '登录', 'success', '2020-04-24 11:06:43');
INSERT INTO `log` VALUES (34, '管理员A', '登录', 'success', '2020-04-24 11:07:10');
INSERT INTO `log` VALUES (35, '管理员A', '登录', '密码错误', '2020-04-24 11:09:27');
INSERT INTO `log` VALUES (36, '李四', '登录', 'success', '2020-04-24 11:09:33');
INSERT INTO `log` VALUES (37, '张三', '登录', 'success', '2020-04-24 11:14:16');
INSERT INTO `log` VALUES (38, '东方不败', '登录', 'success', '2020-04-24 11:14:36');
INSERT INTO `log` VALUES (39, '张三', '登录', 'success', '2020-04-24 11:15:55');
INSERT INTO `log` VALUES (40, '管理员A', '登录', 'success', '2020-04-24 20:22:56');
INSERT INTO `log` VALUES (41, '管理员A', '登录', 'success', '2020-04-25 10:13:45');
INSERT INTO `log` VALUES (42, '张三', '登录', 'success', '2020-04-25 10:31:54');
INSERT INTO `log` VALUES (43, '管理员A', '登录', 'success', '2020-04-25 10:32:58');
INSERT INTO `log` VALUES (44, '张三', '登录', 'success', '2020-04-25 10:33:57');
INSERT INTO `log` VALUES (45, '东方不败', '登录', 'success', '2020-04-25 12:17:41');
INSERT INTO `log` VALUES (46, '东方不败', '登录', 'success', '2020-04-25 12:18:20');
INSERT INTO `log` VALUES (47, '管理员A', '登录', 'success', '2020-04-27 10:11:52');
INSERT INTO `log` VALUES (48, '李四', '登录', 'success', '2020-04-27 11:12:09');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `no_text` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '公告内容',
  `no_enddate` timestamp(0) NULL DEFAULT NULL COMMENT '公告截止时间',
  `create_date` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_date` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES (1, '家和贵分工会尽快了利库家和贵哈哈哈哈哈哈哈哈哈哈或或或或或或或或或', '2020-05-15 00:00:00', '2020-03-05 00:00:00', '2020-03-05 17:39:00');
INSERT INTO `notice` VALUES (2, '最新公告，小区有一粒感染请大家注意防范!!!!!!!!!', '2020-03-13 00:00:00', '2020-03-05 00:00:00', '2020-03-05 17:43:51');
INSERT INTO `notice` VALUES (3, '疫情严重，请不要乱跑！疫情严重，请不要乱跑！疫情严重，请不要乱跑！疫情严重，请不要乱跑！疫情严重，请不要乱跑！疫情严重，请不要乱跑！', '2020-03-20 00:00:00', '2020-03-05 00:00:00', '2020-03-08 20:19:29');
INSERT INTO `notice` VALUES (4, '嘎嘎嘎嘎嘎过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过', '2020-03-04 00:00:00', '2020-03-05 17:47:00', '2020-03-05 21:22:11');
INSERT INTO `notice` VALUES (7, '胜利就在眼前，抗疫战争马上就胜利了，请坚持住', '2020-04-20 00:00:00', '2020-03-19 20:49:17', '2020-04-01 12:32:04');

-- ----------------------------
-- Table structure for payorder
-- ----------------------------
DROP TABLE IF EXISTS `payorder`;
CREATE TABLE `payorder`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pay_text` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `pay_remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `pay_money` float(6, 2) NULL DEFAULT NULL,
  `pay_enddate` timestamp(0) NULL DEFAULT NULL,
  `create_date` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_date` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `pay_type` int(3) NULL DEFAULT NULL COMMENT '缴费类型 1物业，2停车 3水 4电',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '订单对应的用户',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of payorder
-- ----------------------------
INSERT INTO `payorder` VALUES (2, '三月份的物业费 10元 请速度缴纳', '快点啊好的吧6', 10.10, '2020-03-30 00:00:00', '2020-03-07 14:23:49', '2020-03-07 21:07:18', 2, 1);
INSERT INTO `payorder` VALUES (3, '今年的停车位钱该交了啊', '速度', 100.00, '2020-03-14 00:00:00', '2020-03-07 14:24:21', '2020-03-07 21:07:18', 2, 1);
INSERT INTO `payorder` VALUES (4, '1月物业费还没交的清速到办公室缴费', '撒旦飞规划局看', 10.00, '2020-03-18 00:00:00', '2020-03-07 14:42:09', '2020-03-07 21:07:18', 1, 1);
INSERT INTO `payorder` VALUES (5, '三月没交电费的麻利点，', '水水水水是是是所所所所所', 12.89, '2020-04-30 00:00:00', '2020-03-07 18:28:32', '2020-03-07 21:07:18', 4, 1);
INSERT INTO `payorder` VALUES (6, '请用户8赶紧交电费 20.09元', '啥的复购会', 20.09, '2020-03-14 00:00:00', '2020-03-07 21:21:43', '2020-03-07 21:21:43', 4, 10);
INSERT INTO `payorder` VALUES (7, '请快点交水费', '撒旦飞规划局考虑', 2.40, '2020-03-13 00:00:00', '2020-03-07 21:28:08', '2020-03-07 21:28:08', 3, 4);
INSERT INTO `payorder` VALUES (8, '噢噢噢噢噢噢噢噢哦哦哦哦哦哦哦哦哦', '男男女女女女女女女女女女女女女女女女女女女女女女', 2.90, '2020-03-12 00:00:00', '2020-03-07 21:49:32', '2020-03-07 21:49:32', 1, 10);
INSERT INTO `payorder` VALUES (9, '四月的费用该教了啊', '这是备注，请快点', 55.00, '2020-04-30 00:00:00', '2020-04-09 15:34:42', '2020-04-09 17:34:05', 2, 1);
INSERT INTO `payorder` VALUES (10, '水水水水是是是所所所所', '水水水水是是是所所所所', 0.60, '2020-04-29 00:00:00', '2020-04-09 15:34:42', '2020-04-09 15:34:42', 2, 7);
INSERT INTO `payorder` VALUES (11, '水水水水是是是所所所', '的顶顶顶顶顶顶顶顶顶顶', 0.60, '2020-04-22 00:00:00', '2020-04-09 15:35:02', '2020-04-09 15:35:02', 3, 8);

-- ----------------------------
-- Table structure for payrecord
-- ----------------------------
DROP TABLE IF EXISTS `payrecord`;
CREATE TABLE `payrecord`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `payorder_id` int(11) NULL DEFAULT NULL COMMENT '缴费单 id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '缴费用户id',
  `payorder_status` int(3) NULL DEFAULT NULL COMMENT '订单状态 1完成支付，2未完成支付',
  `create_date` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_date` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of payrecord
-- ----------------------------
INSERT INTO `payrecord` VALUES (2, 3, 1, 1, '2020-03-07 18:11:01', '2020-03-07 18:11:01');
INSERT INTO `payrecord` VALUES (3, 4, 4, 1, '2020-03-07 18:25:35', '2020-03-07 18:25:35');
INSERT INTO `payrecord` VALUES (6, 6, 10, 1, '2020-03-07 21:43:37', '2020-03-07 21:43:37');
INSERT INTO `payrecord` VALUES (12, 5, 1, 1, '2020-03-20 22:29:01', '2020-03-20 22:29:01');
INSERT INTO `payrecord` VALUES (13, 2, 1, 1, '2020-03-20 22:31:54', '2020-03-20 22:31:54');
INSERT INTO `payrecord` VALUES (14, 9, 1, 1, '2020-03-20 22:31:54', '2020-03-20 22:31:54');

-- ----------------------------
-- Table structure for repair
-- ----------------------------
DROP TABLE IF EXISTS `repair`;
CREATE TABLE `repair`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `repair_text` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `repair_imgs` varchar(400) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `repair_status` int(3) NULL DEFAULT NULL,
  `repair_evaluate` int(3) NOT NULL DEFAULT -1 COMMENT '用户的评分',
  `repair_evaluate_text` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户的评语',
  `admin_id` int(11) NULL DEFAULT 0 COMMENT '此维修信息分配给的管理员',
  `create_date` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_date` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of repair
-- ----------------------------
INSERT INTO `repair` VALUES (1, 1, '我家的下水道堵了，请速修，谢谢....', '/jpg/2020-3-6/1583496143940.jpg', 3, 1, '不错，五星分期给你们', 3, '2020-03-06 20:02:25', '2020-04-27 10:57:00');
INSERT INTO `repair` VALUES (2, 1, '我家的下水道坏了，请速修，谢谢。。。。。', '/jpg/2020-3-6/1583496184402.jpg', 1, -1, NULL, 3, '2020-03-06 20:03:04', '2020-04-27 10:57:00');
INSERT INTO `repair` VALUES (3, 1, '我家的煤气管道不通啊，怎么回事..', '/jpg/2020-3-6/1583496379831.jpg', 3, 4, '很棒，谢谢，很棒，谢谢很棒，谢谢很棒，谢谢', 3, '2020-03-06 20:06:20', '2020-04-27 10:57:00');
INSERT INTO `repair` VALUES (4, 4, '我要报修', '/jpg/2020-3-6/1583500423417.jpg', 2, -1, NULL, 3, '2020-03-06 21:13:44', '2020-04-27 10:57:00');
INSERT INTO `repair` VALUES (6, 4, '我在此报修 不不不不不不不不不不不不不不不不不不不不不不不不', '/jpg/2020-3-6/1583500423417.jpg,/jpg/2020-3-6/1583500524818.jpg,/jpg/2020-3-6/1583500617085.jpg', 3, -1, NULL, 3, '2020-03-06 21:16:58', '2020-04-27 10:57:00');
INSERT INTO `repair` VALUES (7, 1, '微信小程序报修测试', '/jpg/2020-3-8/1583672698148.jpg,/jpg/2020-3-8/1583672698222.jpg', 2, -1, NULL, 4, '2020-03-08 21:04:58', '2020-04-27 11:17:49');
INSERT INTO `repair` VALUES (8, 1, '测试报修啊！！！！！！测试报修啊测试报修啊测试报修啊测试报修啊测试报修啊测试报修啊', '/jpg/2020-3-8/1583672764814.jpg', 3, 3, '还是没有彻底的维修好，请继续维修一下', 8, '2020-03-08 21:06:04', '2020-04-27 10:57:04');
INSERT INTO `repair` VALUES (9, 1, '又来测试报修了啊', '/jpg/2020-4-27/1587957042057.jpg', 3, 4, '很不错，感谢xxxxxxxxxxxx', 4, '2020-04-27 11:10:43', '2020-04-27 11:16:59');
INSERT INTO `repair` VALUES (10, 1, '大数据啊开大会大胜靠德黑爱好是立法法律师费建安费', '/jpg/2020-4-27/1587957042057.jpg,/jpg/2020-4-27/1587957064409.jpg', 1, -1, NULL, 8, '2020-04-27 11:11:05', '2020-04-27 11:11:05');

-- ----------------------------
-- Table structure for suggestion
-- ----------------------------
DROP TABLE IF EXISTS `suggestion`;
CREATE TABLE `suggestion`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `su_text` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `su_imgs` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '投诉建议上传的图片',
  `su_status` int(3) NULL DEFAULT NULL COMMENT '投诉，建议的状态  1 发起投诉，2 收到投诉，3 已处理投诉',
  `su_evaluate` int(3) NOT NULL DEFAULT -1 COMMENT '评分',
  `admin_id` int(11) NULL DEFAULT 0 COMMENT '该投诉建议被分配到的管理员的id',
  `su_evaluate_text` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '评价',
  `create_date` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_date` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of suggestion
-- ----------------------------
INSERT INTO `suggestion` VALUES (1, 4, '下水道坏了啊，快点来修一下吧嘻嘻嘻嘻嘻嘻嘻嘻寻寻寻', '/jpg/2020-3-6/1583470610659.jpg,/jpg/2020-3-6/1583470616092.jpg', 2, -1, 3, NULL, '2020-03-06 12:57:22', '2020-04-25 11:15:35');
INSERT INTO `suggestion` VALUES (2, 1, '北门的栏杆坏了，存在很大的安全隐患，请抓紧维修吧', '/jpg/2020-3-6/1583471394017.jpg', 1, -1, 3, NULL, '2020-03-06 13:09:55', '2020-04-25 11:15:35');
INSERT INTO `suggestion` VALUES (3, 0, '建议你们在大门空增加一个门禁，保护大家的安全吧！！！', '/jpg/2020-3-6/1583471462306.jpg', 2, -1, 3, NULL, '2020-03-06 13:11:03', '2020-04-25 11:15:35');
INSERT INTO `suggestion` VALUES (4, 4, '大家的栏杆都生锈了啊 ，，，，姐姐姐姐军军军军军军军军军军军军军军军军军军军军军军', '/jpg/2020-3-6/1583471501122.jpg', 3, -1, 4, NULL, '2020-03-06 13:11:42', '2020-04-25 11:15:40');
INSERT INTO `suggestion` VALUES (5, 4, '这是我的投诉建议', '/jpg/2020-3-6/1583475566897.jpg', 3, -1, 4, NULL, '2020-03-06 14:19:28', '2020-04-25 11:15:40');
INSERT INTO `suggestion` VALUES (6, 1, '我发现小区的树该修剪了啊............................我发现小区的树该修剪了啊............................我发现小区的树该修剪了啊............................我发现小区的树该修剪了啊............................我发现小区的树该修剪了啊............................', '/jpg/2020-3-6/1583489822778.jpg,/jpg/2020-3-6/1583489825599.jpg', 3, 5, 4, '感谢你们采纳我们的建议', '2020-03-06 18:17:07', '2020-04-25 11:15:40');
INSERT INTO `suggestion` VALUES (7, 1, '啦啦啦啦啦啦啦啦绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿', '/jpg/2020-3-6/1583497505578.jpg', 1, -1, 4, NULL, '2020-03-06 20:25:12', '2020-04-25 11:15:40');
INSERT INTO `suggestion` VALUES (8, 2, '我要投诉你们啊啊 阿达大大的      ', '/jpg/2020-3-6/1583497550780.jpg', 2, -1, 8, NULL, '2020-03-06 20:25:53', '2020-04-25 12:28:05');
INSERT INTO `suggestion` VALUES (9, 1, '你们服务人员态度极差！', '/jpg/2020-3-10/1583836105317.jpg', 3, 3, 8, '应该还不错', '2020-03-10 18:28:25', '2020-04-25 11:15:43');
INSERT INTO `suggestion` VALUES (10, 1, '宋丹丹拉大手领款单带我啊啊大大傻傻的', '/jpg/2020-4-25/1587787223761.jpg', 2, -1, 8, NULL, '2020-04-25 12:05:26', '2020-04-27 10:27:59');
INSERT INTO `suggestion` VALUES (11, 1, '考虑啦啦啦啦啦啦啦啦啦啦啦啦啦', '/jpg/2020-4-25/1587787223761.jpg,/jpg/2020-4-25/1587787564346.jpg', 1, -1, 3, NULL, '2020-04-25 12:06:05', '2020-04-25 12:06:05');

-- ----------------------------
-- Table structure for topic
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL COMMENT '创建话题的用户',
  `topic_text` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '话题的标题',
  `topic_remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '话题备注字段',
  `topic_love` int(8) NOT NULL DEFAULT 0 COMMENT '点赞数',
  `create_date` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_date` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of topic
-- ----------------------------
INSERT INTO `topic` VALUES (5, 1, '测试输入话题', NULL, 10, '2020-03-13 12:29:53', '2020-03-13 12:29:53');
INSERT INTO `topic` VALUES (6, 4, '这是用户2添加的话题 哈哈哈哈', NULL, 1, '2020-03-14 21:11:36', '2020-03-14 21:11:36');
INSERT INTO `topic` VALUES (8, 5, '我不是用户1 来创个话题看看效果', NULL, 1, '2020-04-06 20:34:52', '2020-04-06 20:34:52');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bu_id` int(11) NULL DEFAULT NULL COMMENT '所属楼房id',
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `user_phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `user_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `user_sex` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '性别',
  `user_age` int(4) NULL DEFAULT NULL COMMENT '年龄',
  `user_avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户头像',
  `user_remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `roles` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_date` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_date` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 2, '用户1', '12345678001', 'fcea920f7412b5da7be0cf42b8c93759', '男', 22, '/jpg/2020-3-5/1583418715536.jpg', '这是备注3222', 'user', '2020-03-03 22:39:00', '2020-04-27 11:10:20');
INSERT INTO `user` VALUES (2, 2, '用户2', '1234567890', 'e10adc3949ba59abbe56e057f20f883e', '女', 4, 'https://s2.ax1x.com/2019/07/17/ZLWJSA.gif?imageView2/1/w/80/h/80', '啥的复购会', 'user', '2020-03-04 23:59:20', '2020-03-05 21:04:40');
INSERT INTO `user` VALUES (3, 1, '用户3', '1234567890', 'e10adc3949ba59abbe56e057f20f883e', '男', 5, 'https://s2.ax1x.com/2019/07/17/ZLWJSA.gif?imageView2/1/w/80/h/80', '啥的复购会', 'user', '2020-03-05 00:00:21', '2020-03-05 21:04:40');
INSERT INTO `user` VALUES (5, 2, '用户5', '12345678003', 'e10adc3949ba59abbe56e057f20f883e', '女', 22, 'https://s2.ax1x.com/2019/07/17/ZLWJSA.gif?imageView2/1/w/80/h/80', '这是用户的备注信息 密码 123456', 'user', '2020-03-05 13:12:23', '2020-04-06 20:34:22');
INSERT INTO `user` VALUES (7, 2, '用户7', '12345678004', 'e10adc3949ba59abbe56e057f20f883e', '女', 22, 'https://s2.ax1x.com/2019/07/17/ZLWJSA.gif?imageView2/1/w/80/h/80', '这是用户的备注信息 密码 123456    333', 'user', '2020-03-05 13:14:20', '2020-03-30 22:20:08');
INSERT INTO `user` VALUES (8, 5, '用户8', '12345678006', 'e10adc3949ba59abbe56e057f20f883e', '男', 22, 'https://s2.ax1x.com/2019/07/17/ZLWJSA.gif?imageView2/1/w/80/h/80', 'ass水水水水是是是所所所所所所所所所所所', 'user', '2020-03-05 20:52:11', '2020-03-13 22:20:10');
INSERT INTO `user` VALUES (9, 5, '用户7', '12345678007', 'e10adc3949ba59abbe56e057f20f883e', '女', 22, 'https://s2.ax1x.com/2019/07/17/ZLWJSA.gif?imageView2/1/w/80/h/80', '水水水水是是是所所', 'user', '2020-03-05 21:00:39', '2020-03-29 21:00:39');
INSERT INTO `user` VALUES (10, 5, '用户8', '12345678008', 'e10adc3949ba59abbe56e057f20f883e', '女', 33, 'https://s2.ax1x.com/2019/07/17/ZLWJSA.gif?imageView2/1/w/80/h/80', '幸福感和健康', 'user', '2020-03-05 21:04:17', '2020-03-30 21:04:40');

SET FOREIGN_KEY_CHECKS = 1;
