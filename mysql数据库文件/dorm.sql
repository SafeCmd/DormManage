/*
 Navicat Premium Data Transfer

 Source Server         : 我本机的mysql
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : dorm

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 21/08/2020 17:45:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for pdman_db_version
-- ----------------------------
DROP TABLE IF EXISTS `pdman_db_version`;
CREATE TABLE `pdman_db_version`  (
  `DB_VERSION` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `VERSION_DESC` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `CREATED_TIME` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pdman_db_version
-- ----------------------------
INSERT INTO `pdman_db_version` VALUES ('v0.0.0', '默认版本，新增的版本不能低于此版本', '2020-06-15 12:53:30');
INSERT INTO `pdman_db_version` VALUES ('V1.0', '数据库第一次初始化', '2020-06-15 12:53:36');

-- ----------------------------
-- Table structure for tb_building
-- ----------------------------
DROP TABLE IF EXISTS `tb_building`;
CREATE TABLE `tb_building`  (
  `ID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `NO` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '楼号',
  `DROM_NAME` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '宿舍编号',
  `DROM_PHONE` int(0) DEFAULT NULL COMMENT '宿舍电话',
  `TOTAL` int(0) DEFAULT NULL COMMENT '可住人数',
  `USED` int(0) DEFAULT NULL COMMENT '已住人数',
  `REVISION` int(0) DEFAULT NULL COMMENT '技术野生菌',
  `CREATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime(0) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '宿舍楼栋表 ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_equipment
-- ----------------------------
DROP TABLE IF EXISTS `tb_equipment`;
CREATE TABLE `tb_equipment`  (
  `ID` int(0) NOT NULL COMMENT 'ID',
  `NO` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '设备编号',
  `NAME` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '设备名称',
  `RENT_STUDEN_NO` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '租凭人编号',
  `RENT_TIME` datetime(0) DEFAULT NULL COMMENT '租凭日期',
  `RETURN_TIME` datetime(0) DEFAULT NULL COMMENT '归还日期',
  `RENT_COST` decimal(32, 8) DEFAULT NULL COMMENT '租凭费用',
  `REMARK` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注信息',
  `REVISION` int(0) DEFAULT NULL COMMENT '技术野生菌',
  `CREATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime(0) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '设备租凭表 ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_equipment_fix
-- ----------------------------
DROP TABLE IF EXISTS `tb_equipment_fix`;
CREATE TABLE `tb_equipment_fix`  (
  `ID` int(0) NOT NULL COMMENT 'ID',
  `DORM_NO` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '宿舍编号',
  `EQ_NO` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '设备编号',
  `REPAIR_REASON` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '报修原因',
  `SUB_TIME` datetime(0) DEFAULT NULL COMMENT '上报时间',
  `HANDLE_TIME` datetime(0) DEFAULT NULL COMMENT '处理时间',
  `COST` decimal(32, 8) DEFAULT NULL COMMENT '报修金额',
  `REVISION` int(0) DEFAULT NULL COMMENT '技术野生菌',
  `CREATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime(0) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '设备报修表 ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_ewcost
-- ----------------------------
DROP TABLE IF EXISTS `tb_ewcost`;
CREATE TABLE `tb_ewcost`  (
  `ID` int(0) NOT NULL COMMENT 'ID',
  `BUILDING_NO` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '楼号',
  `DORM_NO` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '宿舍号',
  `MONTH` int(0) DEFAULT NULL COMMENT '月份',
  `ELECTRICITY` decimal(32, 10) DEFAULT NULL COMMENT '用电量',
  `ELE_COST` decimal(32, 8) DEFAULT NULL COMMENT '电费',
  `WATER` decimal(32, 10) DEFAULT NULL COMMENT '用水量',
  `WATER_COST` decimal(32, 8) DEFAULT NULL COMMENT '水费',
  `REVISION` int(0) DEFAULT NULL COMMENT '技术野生菌',
  `CREATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime(0) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '水电计费表 ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_menu
-- ----------------------------
DROP TABLE IF EXISTS `tb_menu`;
CREATE TABLE `tb_menu`  (
  `ID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `PARENT_ID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '父级菜单ID',
  `NAME` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单名称',
  `URL` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单url',
  `PERMISSION` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '授权',
  `ICON` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '图标',
  `TYPE` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '类型',
  `Sort` int(0) DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单表 ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_menu
-- ----------------------------
INSERT INTO `tb_menu` VALUES ('12345', '0000000', 'save', '/sys/user', 'sys:user:save', NULL, 'add', 1);

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role`  (
  `ID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `NAME` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色名',
  `ROLE_SIGN` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色标识',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表 ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES ('000000', 'add', 'sys:user:save');

-- ----------------------------
-- Table structure for tb_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_menu`;
CREATE TABLE `tb_role_menu`  (
  `ID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `ROLE_ID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色ID',
  `MENU_ID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色菜单表 ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_role_menu
-- ----------------------------
INSERT INTO `tb_role_menu` VALUES ('12345', '000000', '12345');

-- ----------------------------
-- Table structure for tb_studens
-- ----------------------------
DROP TABLE IF EXISTS `tb_studens`;
CREATE TABLE `tb_studens`  (
  `ID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `NO` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学号',
  `NAME` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '姓名',
  `GENDER` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '性别',
  `REVISION` int(0) DEFAULT NULL COMMENT '技术野生菌',
  `SPECIALITIES` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '专业',
  `PHONE` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '联系方式',
  `CREATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime(0) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '学生信息表 记录住宿学生基本信息的表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `ID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '姓名',
  `PASSWORD` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `SALT` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '盐',
  `updated_time` datetime(0) DEFAULT NULL,
  `updated_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `created_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `created_time` datetime(0) DEFAULT NULL,
  `del_flag` int(0) DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理员信息表 ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('493878171238662145', 'safecmd', '$2a$10$rfAtn1cDcTgVns8DGc3IKuwfiH2W5ziadh.v./0hs30COIq/tKydm', 'cmd', '2020-08-20 17:36:37', '493878171238662144', '493878171238662144', '2020-08-20 17:36:37', 0);
INSERT INTO `tb_user` VALUES ('493928879799402496', 'admin3', '$2a$10$RSvOvFNdkb9cDza/q5rPNO0QVvPTssZVYAqaiv/XmscAguUYwZC3y', 'cmd', '2020-08-20 20:58:07', '493878171238662145', '493878171238662145', '2020-08-20 20:58:07', 0);
INSERT INTO `tb_user` VALUES ('493974558353653760', 'admin4', '$2a$10$761hXElLymIzRHEm/lqO6epxCaIgYxY9qSVk0YeaHfFHzugY7lzwq', 'cmd', '2020-08-20 23:59:38', '493878171238662145', '493878171238662145', '2020-08-20 23:59:38', 0);
INSERT INTO `tb_user` VALUES ('493974729439313920', 'admin42', '$2a$10$.Fk/SA5vBYWKpS3miw4WOut6On.atrftiPwWxAkDUwj5.UTBCJ4zK', 'cmd', '2020-08-21 00:00:19', '493878171238662145', '493878171238662145', '2020-08-21 00:00:19', 0);
INSERT INTO `tb_user` VALUES ('493975040442761216', 'admin4233', '$2a$10$gYKjGKjbp/bjNFpGcArMDugUgg7/I/5.1883gHjfErM5BvVVOmFNG', 'cmd', '2020-08-21 00:01:33', '493878171238662145', '493878171238662145', '2020-08-21 00:01:33', 0);
INSERT INTO `tb_user` VALUES ('493988407005937664', '1222', '$2a$10$KAsK8wkjxHVkwrArpBXQuurto8QJcGPdTQVVh8/2ANFr6KKePly3K', 'cmd', '2020-08-21 00:54:40', '493878171238662145', '493878171238662145', '2020-08-21 00:54:40', 0);
INSERT INTO `tb_user` VALUES ('493988555429773312', '1222333', '$2a$10$OMZ9AcZSTm3a7ng6KbbndOodVhwncztT9XqziBd01t4In5z9NcqAO', 'cmd', '2020-08-21 00:55:15', '493878171238662145', '493878171238662145', '2020-08-21 00:55:15', 0);
INSERT INTO `tb_user` VALUES ('493988877229359104', '4444', '$2a$10$7NORB8RuIbrwA1l08V0oq.eWnGg0yC3cF6D9AM9fybgxJbPCbUiLy', 'cmd', '2020-08-21 00:56:32', '493878171238662145', '493878171238662145', '2020-08-21 00:56:32', 0);
INSERT INTO `tb_user` VALUES ('493990240470433792', '666', '$2a$10$EUnEr1Mh./rtr1KQeYDXS.9qJ1i9qbBUCRumciWIU4LHPoehvB29S', 'cmd', '2020-08-21 01:01:57', '493878171238662145', '493878171238662145', '2020-08-21 01:01:57', 0);
INSERT INTO `tb_user` VALUES ('493990354752634880', '666wee', '$2a$10$mfUL1t5K7QnsQ11e0SgZauApy5koTsZabJ0oW5oHSDt3okhGvxjOu', 'cmd', '2020-08-21 01:02:24', '493878171238662145', '493878171238662145', '2020-08-21 01:02:24', 0);

-- ----------------------------
-- Table structure for tb_user_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_role`;
CREATE TABLE `tb_user_role`  (
  `ID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `USER_ID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户ID',
  `ROLE_ID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色表 ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user_role
-- ----------------------------
INSERT INTO `tb_user_role` VALUES ('493877895505117184', '493878171238662145', '000000');
INSERT INTO `tb_user_role` VALUES ('493988407521837056', '493988407005937664', '000000');
INSERT INTO `tb_user_role` VALUES ('493988555807260672', '493988555429773312', '000000');
INSERT INTO `tb_user_role` VALUES ('493988877594263552', '493988877229359104', '000000');
INSERT INTO `tb_user_role` VALUES ('493990240915030016', '493990240470433792', '000000');
INSERT INTO `tb_user_role` VALUES ('493990355117539328', '493990354752634880', '000000');

-- ----------------------------
-- Table structure for tb_visitor
-- ----------------------------
DROP TABLE IF EXISTS `tb_visitor`;
CREATE TABLE `tb_visitor`  (
  `ID` int(0) NOT NULL COMMENT 'ID',
  `VISITOR_NAME` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '来访者姓名',
  `RESPONDENTS_NAME` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '被访者姓名',
  `RELATION` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '与被访人关系',
  `CAR_TYPE` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '证件类型',
  `CAR_NO` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '证件号码',
  `VISITOR_TIME` datetime(0) DEFAULT NULL COMMENT '来访时间',
  `LEVE_TIME` datetime(0) DEFAULT NULL COMMENT '离开时间',
  `REMARK` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `REVISION` int(0) DEFAULT NULL COMMENT '技术野生菌',
  `CREATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime(0) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '访客登记表 ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_worker
-- ----------------------------
DROP TABLE IF EXISTS `tb_worker`;
CREATE TABLE `tb_worker`  (
  `ID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `NO` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '员工编号',
  `NAME` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '员工姓名',
  `AGE` int(0) DEFAULT NULL COMMENT '年龄',
  `POSITION` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '职位',
  `PHONE` int(0) DEFAULT NULL COMMENT '联系方式',
  `REVISION` int(0) DEFAULT NULL COMMENT '技术野生菌',
  `CREATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime(0) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '宿舍员工表 ' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
