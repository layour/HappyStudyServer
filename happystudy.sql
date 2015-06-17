/*
Navicat MySQL Data Transfer

Source Server         : jdbc:mysql://127.0.0.1:3306/happystudy
Source Server Version : 50151
Source Host           : 127.0.0.1:3306
Source Database       : happystudy

Target Server Type    : MYSQL
Target Server Version : 50151
File Encoding         : 65001

Date: 2015-06-17 16:30:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `hs_check`
-- ----------------------------
DROP TABLE IF EXISTS `hs_check`;
CREATE TABLE `hs_check` (
  `CHECK_ID` varchar(255) NOT NULL COMMENT '签到ID',
  `CHECK_TIME` varchar(255) DEFAULT NULL COMMENT '签到时间',
  `CHECK_ADDR` varchar(255) DEFAULT NULL COMMENT '签到地点',
  `CHECK_TYPE` varchar(255) DEFAULT NULL COMMENT '签到类型',
  `USER_ID` varchar(255) DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`CHECK_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='签到';

-- ----------------------------
-- Records of hs_check
-- ----------------------------
INSERT INTO `hs_check` VALUES ('8a82f0d04dfc6e77014dfcb0169d0006', '2015-06-16 22:05:08', '北京市海淀区西北旺镇北清路54号', '签到', '8a82f0d04dfc6e77014dfcaf0f4a0004');

-- ----------------------------
-- Table structure for `hs_class`
-- ----------------------------
DROP TABLE IF EXISTS `hs_class`;
CREATE TABLE `hs_class` (
  `TEAM_CLASS_ID` varchar(255) NOT NULL COMMENT '班级ID',
  `TEAM_CLASS_NAME` varchar(255) DEFAULT NULL COMMENT '班级名称',
  PRIMARY KEY (`TEAM_CLASS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='班级';

-- ----------------------------
-- Records of hs_class
-- ----------------------------
INSERT INTO `hs_class` VALUES ('8a82f0d04dfaa4b8014dfaa4b8370000', '20150616');
INSERT INTO `hs_class` VALUES ('8a82f0d04dfaa4b8014dfaa4d4d80001', '20150617');
INSERT INTO `hs_class` VALUES ('8a82f0d04dfaa4b8014dfaa4eee80002', '20150618');
INSERT INTO `hs_class` VALUES ('8a82f0d04dfaa4b8014dfaa50bdc0003', '20150619');

-- ----------------------------
-- Table structure for `hs_exam_record`
-- ----------------------------
DROP TABLE IF EXISTS `hs_exam_record`;
CREATE TABLE `hs_exam_record` (
  `EXAM_RECORD_ID` varchar(255) NOT NULL COMMENT '考试记录ID',
  `EXAM_SCORE` varchar(255) DEFAULT NULL COMMENT '考试得分',
  `EXAM_TIME` varchar(255) DEFAULT NULL COMMENT '考试时间',
  `USE_TIME` varchar(255) DEFAULT NULL COMMENT '用时',
  `USER_ID` varchar(255) DEFAULT NULL COMMENT '用户ID',
  `PAPER_ID` varchar(255) DEFAULT NULL COMMENT '试卷ID',
  PRIMARY KEY (`EXAM_RECORD_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='考试记录';

-- ----------------------------
-- Records of hs_exam_record
-- ----------------------------

-- ----------------------------
-- Table structure for `hs_opinion`
-- ----------------------------
DROP TABLE IF EXISTS `hs_opinion`;
CREATE TABLE `hs_opinion` (
  `OPINION_ID` varchar(255) NOT NULL COMMENT '意见反馈ID',
  `OPINION_DESC` varchar(255) DEFAULT NULL COMMENT '意见描述',
  `CONTACT_INFO` varchar(255) DEFAULT NULL COMMENT '联系方式',
  `OPINION_TIME` varchar(255) DEFAULT NULL COMMENT '反馈时间',
  `USER_ID` varchar(255) DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`OPINION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='意见反馈';

-- ----------------------------
-- Records of hs_opinion
-- ----------------------------
INSERT INTO `hs_opinion` VALUES ('8a82f0cc4dffc5c5014dffc5c5b70000', '我们', 'yaolei@163.com', '2015-06-17 12:27:40', '8a82f0d04dfc6e77014dfcaf0f4a0004');
INSERT INTO `hs_opinion` VALUES ('8a82f0d04dfc6e77014dfcaf9d350005', '这个应用真好用', '12345678901', '2015-06-16 22:04:37', '8a82f0d04dfc6e77014dfcaf0f4a0004');

-- ----------------------------
-- Table structure for `hs_paper`
-- ----------------------------
DROP TABLE IF EXISTS `hs_paper`;
CREATE TABLE `hs_paper` (
  `PAPER_ID` varchar(255) NOT NULL COMMENT '试卷ID',
  `PAPER_NAME` varchar(255) DEFAULT NULL COMMENT '试卷名称',
  `TOPIC_COUNT` varchar(255) DEFAULT NULL COMMENT '题目数',
  `TOTAL_SCORE` varchar(255) DEFAULT NULL COMMENT '总分',
  `PAPER_TIME` varchar(255) DEFAULT NULL COMMENT '组卷时间',
  PRIMARY KEY (`PAPER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='试卷';

-- ----------------------------
-- Records of hs_paper
-- ----------------------------

-- ----------------------------
-- Table structure for `hs_paper_topic`
-- ----------------------------
DROP TABLE IF EXISTS `hs_paper_topic`;
CREATE TABLE `hs_paper_topic` (
  `PAPER_TOPIC_ID` varchar(255) NOT NULL COMMENT '试卷题目ID',
  `PAPER_ID` varchar(255) DEFAULT NULL COMMENT '试卷ID',
  `TOPIC_ID` varchar(255) DEFAULT NULL COMMENT '题目ID',
  PRIMARY KEY (`PAPER_TOPIC_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='试卷题目';

-- ----------------------------
-- Records of hs_paper_topic
-- ----------------------------

-- ----------------------------
-- Table structure for `hs_topic`
-- ----------------------------
DROP TABLE IF EXISTS `hs_topic`;
CREATE TABLE `hs_topic` (
  `TOPIC_ID` varchar(255) NOT NULL COMMENT '题目ID',
  `TOPIC` varchar(255) DEFAULT NULL COMMENT '题目描述',
  `ANSWER` varchar(255) DEFAULT NULL COMMENT '答案描述',
  `RIGHT_ANSWER` varchar(255) DEFAULT NULL COMMENT '正确答案',
  `TOPIC_SCORE` varchar(255) DEFAULT NULL COMMENT '题目分值',
  `ANALYSIS` varchar(255) DEFAULT NULL COMMENT '详解',
  `DIFFICULTY` varchar(255) DEFAULT NULL COMMENT '难易度',
  `CHAPTER` varchar(255) DEFAULT NULL COMMENT '所属章节',
  PRIMARY KEY (`TOPIC_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='题目';

-- ----------------------------
-- Records of hs_topic
-- ----------------------------

-- ----------------------------
-- Table structure for `hs_topic_record`
-- ----------------------------
DROP TABLE IF EXISTS `hs_topic_record`;
CREATE TABLE `hs_topic_record` (
  `TOPIC_RECORD_ID` varchar(255) NOT NULL COMMENT '做题记录ID',
  `USER_ANSWER` varchar(255) DEFAULT NULL COMMENT '用户答案',
  `TOPIC_TIME` varchar(255) DEFAULT NULL COMMENT '做题时间',
  `IS_RIGHT` varchar(255) DEFAULT NULL COMMENT '是否正确',
  `TOPIC_ID` varchar(255) DEFAULT NULL COMMENT '题目ID',
  `EXAM_RECORD_ID` varchar(255) DEFAULT NULL COMMENT '考试记录ID',
  PRIMARY KEY (`TOPIC_RECORD_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='做题记录';

-- ----------------------------
-- Records of hs_topic_record
-- ----------------------------

-- ----------------------------
-- Table structure for `hs_user`
-- ----------------------------
DROP TABLE IF EXISTS `hs_user`;
CREATE TABLE `hs_user` (
  `USER_ID` varchar(255) NOT NULL COMMENT '用户ID',
  `PHONE_NO` varchar(255) DEFAULT NULL COMMENT '手机号',
  `PASSWORD` varchar(255) DEFAULT NULL COMMENT '密码',
  `USER_NAME` varchar(255) DEFAULT NULL COMMENT '用户姓名',
  `SEX` varchar(255) DEFAULT NULL COMMENT '性别',
  `ID_NO` varchar(255) DEFAULT NULL COMMENT '身份证号',
  `REFERRER_NO` varchar(255) DEFAULT NULL COMMENT '推荐人工号',
  `REFERRER_PHONE_NO` varchar(255) DEFAULT NULL COMMENT '推荐人手机号',
  `CITY` varchar(255) DEFAULT NULL COMMENT '城市',
  `TEAM_TYPE` varchar(255) DEFAULT NULL COMMENT '班型',
  `ROLE` varchar(255) DEFAULT NULL COMMENT '角色',
  `TEAM_CLASS` varchar(255) DEFAULT NULL COMMENT '班级',
  PRIMARY KEY (`USER_ID`),
  UNIQUE KEY `USER_PHONE_NO` (`PHONE_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Records of hs_user
-- ----------------------------
INSERT INTO `hs_user` VALUES ('8a82f0d04dfc6e77014dfcaf0f4a0004', '15801611227', 'q', '姚磊', '女', '123456789012345', 'q1', '12345678901', '合肥1', '职前班', '普通用户', '20150616');

-- ----------------------------
-- Table structure for `hs_user_topic`
-- ----------------------------
DROP TABLE IF EXISTS `hs_user_topic`;
CREATE TABLE `hs_user_topic` (
  `USER_TOPIC_ID` varchar(255) NOT NULL COMMENT '用户题目ID',
  `COLLECT` varchar(255) DEFAULT NULL COMMENT '标记收藏',
  `TOPIC_ID` varchar(255) DEFAULT NULL COMMENT '题目ID',
  `USER_ID` varchar(255) DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`USER_TOPIC_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户题目';

-- ----------------------------
-- Records of hs_user_topic
-- ----------------------------
