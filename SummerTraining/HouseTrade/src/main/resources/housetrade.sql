/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50619
Source Host           : 127.0.0.1:3306
Source Database       : housetrade

Target Server Type    : MYSQL
Target Server Version : 50619
File Encoding         : 65001

Date: 2016-01-02 17:56:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_house
-- ----------------------------
DROP TABLE IF EXISTS `t_house`;
CREATE TABLE `t_house` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `smallArea` varchar(255) NOT NULL,
  `room` int(1) NOT NULL,
  `hall` int(1) NOT NULL,
  `bathroom` int(1) NOT NULL,
  `houseArea` double NOT NULL,
  `totalFloor` int(3) NOT NULL,
  `floor` int(3) NOT NULL,
  `hasElevator` tinyint(1) NOT NULL,
  `orientation` varchar(255) NOT NULL,
  `decoration` varchar(255) NOT NULL,
  `buildingStructure` varchar(255) NOT NULL,
  `housingType` varchar(255) NOT NULL,
  `propertyRightYear` int(3) NOT NULL,
  `propertyRightType` varchar(255) NOT NULL,
  `constructionYear` varchar(255) NOT NULL,
  `salePrice` decimal(10,2) NOT NULL,
  `title` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `person` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `publishTime` date NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_house
-- ----------------------------
INSERT INTO `t_house` VALUES ('1', '水木青华', '2', '2', '2', '139', '12', '5', '1', '南北', '精装修', '低层板楼', '普通住宅', '50', '商品房', '2012', '85.85', '水木青华精品好房渝北回兴宝胜湖旁精装大三房', '123', 'abc', '10086', '2015-06-26', '1');
INSERT INTO `t_house` VALUES ('2', '水木青华', '1', '2', '2', '120', '12', '5', '1', '南北', '精装修', '低层板楼', '普通住宅', '50', '商品房', '2012', '320.00', '水木青华精品好房渝北回兴宝胜湖旁精装大三房', '123', 'abc', '10086', '2015-06-26', '2');
INSERT INTO `t_house` VALUES ('3', '水木青华', '3', '2', '2', '50', '12', '5', '1', '南北', '精装修', '低层板楼', '普通住宅', '50', '商品房', '2012', '25.00', '水木青华精品好房渝北回兴宝胜湖旁精装大三房', '123', 'abc', '10086', '2015-06-26', '2');
INSERT INTO `t_house` VALUES ('4', '水木青华', '4', '2', '2', '55', '12', '5', '1', '南北', '精装修', '低层板楼', '普通住宅', '50', '商品房', '2012', '28.00', '水木青华精品好房渝北回兴宝胜湖旁精装大三房', '123', 'abc', '10086', '2015-06-26', '1');
INSERT INTO `t_house` VALUES ('5', '水木青华', '5', '2', '2', '250', '12', '5', '1', '南北', '精装修', '低层板楼', '普通住宅', '50', '商品房', '2012', '150.00', '水木青华精品好房渝北回兴宝胜湖旁精装大三房', '123', 'abc', '10086', '2015-06-26', '1');
INSERT INTO `t_house` VALUES ('6', '水木青华', '8', '2', '2', '330', '12', '5', '1', '南北', '精装修', '低层板楼', '普通住宅', '50', '商品房', '2012', '250.00', '水木青华精品好房渝北回兴宝胜湖旁精装大三房', '123', 'abc', '10086', '2015-06-26', '1');
INSERT INTO `t_house` VALUES ('7', '水木青华', '2', '2', '2', '70', '12', '5', '1', '南北', '精装修', '低层板楼', '普通住宅', '50', '商品房', '2012', '290.00', '水木青华精品好房渝北回兴宝胜湖旁精装大三房', '123', 'abc', '10086', '2015-06-26', '1');
INSERT INTO `t_house` VALUES ('8', '水木青华', '2', '2', '2', '20', '12', '5', '1', '南北', '精装修', '低层板楼', '普通住宅', '50', '商品房', '2012', '110.00', '水木青华精品好房渝北回兴宝胜湖旁精装大三房', '123', 'abc', '10086', '2015-06-26', '2');
INSERT INTO `t_house` VALUES ('9', 'sadasd', '13', '32', '32', '324', '32', '23', '1', '东', '豪华装修', '低层板楼', '平房/四合院', '70', '商品房', '321321', '321.00', 'sdfds', '124sasa', 'fsa', 'fsasa', '2015-07-28', '1');
INSERT INTO `t_house` VALUES ('10', '十大股东', '1', '1', '1', '1', '1', '1', '1', '东', '豪华装修', '低层板楼', '平房/四合院', '70', '商品房', '1', '7.00', 'Test T', '付款了', '的', '2435', '2015-07-28', '1');

-- ----------------------------
-- Table structure for t_houseimage
-- ----------------------------
DROP TABLE IF EXISTS `t_houseimage`;
CREATE TABLE `t_houseimage` (
  `id` int(13) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `house_id` int(11) NOT NULL,
  `cover` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_houseimage
-- ----------------------------
INSERT INTO `t_houseimage` VALUES ('1', '0814417b-a70c-483a-ac35-90aa72bab1bf.jpg', '1', '1');
INSERT INTO `t_houseimage` VALUES ('2', '232945a3-8ec3-4930-929a-667074b86adf.jpg', '2', '1');
INSERT INTO `t_houseimage` VALUES ('3', '6c4a7903-585c-4c1f-9ad9-b7dfc2390ee1.jpg', '3', '1');
INSERT INTO `t_houseimage` VALUES ('4', '74ea288c-7f26-4537-a5c1-77521a609a15.jpg', '4', '1');
INSERT INTO `t_houseimage` VALUES ('5', '7d5ff610-f908-4332-bea8-89031c28d91b.jpg', '5', '1');
INSERT INTO `t_houseimage` VALUES ('6', '98fca9a1-f05b-4906-a435-9d6388319e31.jpg', '6', '1');
INSERT INTO `t_houseimage` VALUES ('7', 'adbb6be6-6251-4f6a-94f0-f9acdfe63d0a.jpg', '7', '1');
INSERT INTO `t_houseimage` VALUES ('8', 'c2a4ba37-a9c9-4310-84cc-5a802c44549a.jpg', '8', '1');
INSERT INTO `t_houseimage` VALUES ('9', '6d95fa70-fb85-4913-8df3-0e4b34263ca0.jpg', '9', '1');
INSERT INTO `t_houseimage` VALUES ('10', 'dea039f8-084f-4476-9b06-77bf49274b7e.jpg', '9', '0');
INSERT INTO `t_houseimage` VALUES ('11', 'b61152d6-7792-4605-95f6-8a088d9d3838.jpg', '10', '1');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `account` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '111', '111');
INSERT INTO `t_user` VALUES ('2', '222', '222');
INSERT INTO `t_user` VALUES ('3', 'abc', 'abc');
INSERT INTO `t_user` VALUES ('4', '道具卡过', 'sdgdg');
