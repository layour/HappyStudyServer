/*
Navicat MySQL Data Transfer

Source Server         : jdbc:mysql://127.0.0.1:3306/data
Source Server Version : 50151
Source Host           : 127.0.0.1:3306
Source Database       : happystudy

Target Server Type    : MYSQL
Target Server Version : 50151
File Encoding         : 65001

Date: 2015-06-22 20:38:14
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `hs_chapter`
-- ----------------------------
DROP TABLE IF EXISTS `hs_chapter`;
CREATE TABLE `hs_chapter` (
  `CHAPTER_ID` varchar(255) NOT NULL COMMENT '章节ID',
  `CHAPTER_NAME` varchar(255) DEFAULT NULL COMMENT '章节名称',
  PRIMARY KEY (`CHAPTER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='章节';

-- ----------------------------
-- Records of hs_chapter
-- ----------------------------
INSERT INTO `hs_chapter` VALUES ('C01', '第一章');
INSERT INTO `hs_chapter` VALUES ('C02', '第二章');
INSERT INTO `hs_chapter` VALUES ('C03', '第三章');
INSERT INTO `hs_chapter` VALUES ('C04', '第四章');
INSERT INTO `hs_chapter` VALUES ('C05', '第五章');
INSERT INTO `hs_chapter` VALUES ('C06', '第六章');
INSERT INTO `hs_chapter` VALUES ('C07', '第七章');
INSERT INTO `hs_chapter` VALUES ('C08', '第八章');
INSERT INTO `hs_chapter` VALUES ('C09', '第九章');
INSERT INTO `hs_chapter` VALUES ('C10', '法律法规');

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
INSERT INTO `hs_check` VALUES ('402881ed4e0c3559014e0c3876410002', '2015-06-19 22:28:23', '北京市昌平区东小口地区和谐家园(二区)', '签到', '402881ed4e0c3559014e0c3559eb0000');
INSERT INTO `hs_check` VALUES ('402881ed4e0c3559014e0c3884e90003', '2015-06-19 22:28:27', '北京市昌平区东小口地区和谐家园(二区)', '签到', '402881ed4e0c3559014e0c3559eb0000');

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
INSERT INTO `hs_class` VALUES ('402881e94e01e801014e01e801470000', '20150615');
INSERT INTO `hs_class` VALUES ('402881e94e01e801014e01e813260001', '20150616');
INSERT INTO `hs_class` VALUES ('402881e94e01e801014e01e8233e0002', '20150617');
INSERT INTO `hs_class` VALUES ('402881e94e01e801014e01e835560003', '20150614');
INSERT INTO `hs_class` VALUES ('402881e94e01e801014e01e84eb70004', '20150618');
INSERT INTO `hs_class` VALUES ('402881e94e01e801014e01e86fce0005', '20150619');

-- ----------------------------
-- Table structure for `hs_collect`
-- ----------------------------
DROP TABLE IF EXISTS `hs_collect`;
CREATE TABLE `hs_collect` (
  `COLLECT_ID` varchar(255) NOT NULL COMMENT '收藏ID',
  `TOPIC_ID` varchar(255) DEFAULT NULL COMMENT '题目ID',
  `USER_ID` varchar(255) DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`COLLECT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收藏';

-- ----------------------------
-- Records of hs_collect
-- ----------------------------
INSERT INTO `hs_collect` VALUES ('402881ed4e1adeef014e1ae62c060001', '402881ed4e0c3559014e0c3c7f760004', '402881ed4e0c3559014e0c3559eb0000');

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
INSERT INTO `hs_opinion` VALUES ('402881ed4e0c3559014e0c35e91b0001', '这个应用很好', '12345678901', '2015-06-19 22:25:36', '402881ed4e0c3559014e0c3559eb0000');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='题目试卷';

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
  `CHAPTER_ID` varchar(255) DEFAULT NULL COMMENT '章节ID',
  PRIMARY KEY (`TOPIC_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='题目';

-- ----------------------------
-- Records of hs_topic
-- ----------------------------
INSERT INTO `hs_topic` VALUES ('402881ed4e0c3559014e0c3c7f760004', '一年期的意外伤害保险费率厘定的因素主要是考虑（）', '预定利率##意外的持续时间##被保险人的职业、工种##被保险人的死亡率', 'C', '1', '答案：C ', '1', 'C01');
INSERT INTO `hs_topic` VALUES ('402881ed4e0c3559014e0c3dbe4f0005', '下列不属于人身保险特征的是（）', '正确##错误', 'C', '1', '答案：C', '1', 'C01');
INSERT INTO `hs_topic` VALUES ('402881ed4e0c3559014e0c3ee4290006', '在家庭财产保险中，保险事故发生后，保险人对于房屋及室内附属设备、室内装潢的赔偿处理主要采取（）', '第一危险赔偿方式##比例赔偿方式##限额责任制##顺序责任制', 'B', '1', '答案：B', '1', 'C02');
INSERT INTO `hs_topic` VALUES ('402881ed4e0c3559014e0c3ff41d0007', '下面属于投机风险的是（）', '在期货市场上发生盈亏##房屋发生水灾遭受损失##行人被汽车撞死##庄稼被冰雹破坏', 'A', '1', '答案：A', '1', 'C03');
INSERT INTO `hs_topic` VALUES ('402881ed4e0c3559014e0c40f2540008', '在人寿保险中，当投保人申请退保时，保险人对保单现金价值的处理是（）', '不予退还##全部退还##部分退还##协商退还', 'B', '1', '答案：B', '1', 'C04');
INSERT INTO `hs_topic` VALUES ('402881ed4e14f6ad014e14f6adf20000', '财产保险合同是给付性合同', '正确##错误', 'B', '1', '答案：B', '1', 'C02');
INSERT INTO `hs_topic` VALUES ('402881ed4e14f6ad014e14f750190001', '根据我国《保险法》的规定，保险公司分支机构不具有法人资格，其民事责任由保险公司承担', '人身风险的特殊性##保险标的的特殊性##保险费率厘定的特殊性##保险金额确定的特殊性', 'A', '1', '答案：A', '1', 'C01');
INSERT INTO `hs_topic` VALUES ('402881ed4e14f6ad014e1500ec780002', '根据我国《保险法》的规定，我国制定《保险法》的目的是：为了规范保险活动，保护保险人的合法权益，加强对保险业的监督管理，促进保险事业的健康发展', '正确##错误', 'A', '1', '答案：B', '1', 'C05');

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
  `USER_ID` varchar(255) DEFAULT NULL COMMENT '用户ID',
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
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Records of hs_user
-- ----------------------------
INSERT INTO `hs_user` VALUES ('402881ed4e0c3559014e0c3559eb0000', '15801611227', 'q', '姚磊', '女', '123456789012345678', '123', '12345678901', '合肥1', '导师技能提升班', '普通用户', '20150615');
