# Host: localhost  (Version 5.7.19-log)
# Date: 2017-11-22 04:36:31
# Generator: MySQL-Front 6.0  (Build 2.20)


#
# Structure for table "admin"
#

DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `adminID` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`adminID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "admin"
#

INSERT INTO `admin` VALUES (1,'admin','admin');

#
# Structure for table "category"
#

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

#
# Data for table "category"
#

INSERT INTO `category` VALUES (1,'小说'),(5,'计算机');

#
# Structure for table "categorysecond"
#

DROP TABLE IF EXISTS `categorysecond`;
CREATE TABLE `categorysecond` (
  `csid` int(11) NOT NULL AUTO_INCREMENT,
  `csname` varchar(255) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`csid`),
  KEY `cid` (`cid`),
  CONSTRAINT `categorysecond_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

#
# Data for table "categorysecond"
#

INSERT INTO `categorysecond` VALUES (1,'东方小说',1),(2,'西方小说',1),(8,'计算机网络',5),(9,'12',1);

#
# Structure for table "book"
#

DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `bookID` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(60) NOT NULL,
  `author` varchar(20) DEFAULT NULL,
  `press` varchar(50) DEFAULT NULL,
  `ISBN` varchar(50) DEFAULT NULL,
  `paddress` varchar(100) DEFAULT NULL,
  `description` text,
  `price` double DEFAULT '0',
  `soldnum` int(11) DEFAULT '0',
  `stock` int(11) DEFAULT '0',
  `csid` int(11) DEFAULT NULL,
  PRIMARY KEY (`bookID`),
  KEY `csid` (`csid`),
  CONSTRAINT `book_ibfk_1` FOREIGN KEY (`csid`) REFERENCES `categorysecond` (`csid`)
) ENGINE=InnoDB AUTO_INCREMENT=100003 DEFAULT CHARSET=utf8;

#
# Data for table "book"
#

INSERT INTO `book` VALUES (100000,'红楼梦','55','55','55','picture/123.jpg','',1,14,7,1),(100001,'夏洛克','555','555','555','picture/124.jpg','',555,0,555,2),(100002,'十宗罪','匿名','东方出版社','111','picture/125.jpg','',2,0,2,8);

#
# Structure for table "moneycard"
#

DROP TABLE IF EXISTS `moneycard`;
CREATE TABLE `moneycard` (
  `cardID` int(11) NOT NULL AUTO_INCREMENT,
  `money` double NOT NULL,
  `password` varchar(20) DEFAULT NULL,
  `customerID` int(11) DEFAULT '0',
  PRIMARY KEY (`cardID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Data for table "moneycard"
#

INSERT INTO `moneycard` VALUES (1,50,'1819450',0),(2,100,'6290279',0),(3,100,'4480354',100005);

#
# Structure for table "role"
#

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `roleID` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(20) DEFAULT NULL,
  `rightCode` int(11) DEFAULT '0',
  PRIMARY KEY (`roleID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Data for table "role"
#

INSERT INTO `role` VALUES (1,'普通用户',0),(2,'特殊用户',5);

#
# Structure for table "customer"
#

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `customerID` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `sex` enum('男','女') NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `money` double DEFAULT '0',
  `usedmoney` double DEFAULT '0',
  `inmoney` double DEFAULT '0',
  `roleID` int(11) DEFAULT '1',
  PRIMARY KEY (`customerID`),
  UNIQUE KEY `account` (`account`),
  KEY `roleID` (`roleID`),
  CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`roleID`) REFERENCES `role` (`roleID`)
) ENGINE=InnoDB AUTO_INCREMENT=100006 DEFAULT CHARSET=utf8;

#
# Data for table "customer"
#

INSERT INTO `customer` VALUES (100005,'lujianhao','111','卢健豪','男','15218783052','594830589@qq.com',32,68,100,1);

#
# Structure for table "address"
#

DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `addressID` int(11) NOT NULL AUTO_INCREMENT,
  `customerID` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `address` varchar(100) DEFAULT NULL,
  `zipcode` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`addressID`),
  KEY `customerID` (`customerID`),
  CONSTRAINT `address_ibfk_1` FOREIGN KEY (`customerID`) REFERENCES `customer` (`customerID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "address"
#

INSERT INTO `address` VALUES (1,100005,'lll','lll','lll','lll');

#
# Structure for table "sysadmin"
#

DROP TABLE IF EXISTS `sysadmin`;
CREATE TABLE `sysadmin` (
  `sysadminID` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`sysadminID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "sysadmin"
#

INSERT INTO `sysadmin` VALUES (1,'sysadmin','sysadmin');

#
# Structure for table "userorder"
#

DROP TABLE IF EXISTS `userorder`;
CREATE TABLE `userorder` (
  `orderID` int(11) NOT NULL AUTO_INCREMENT,
  `customerID` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `kdnum` varchar(20) DEFAULT NULL,
  `finalPrice` double DEFAULT '0',
  `discountname` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `zipcode` varchar(10) DEFAULT NULL,
  `price` double DEFAULT '0',
  `orderstate` int(11) NOT NULL,
  PRIMARY KEY (`orderID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

#
# Data for table "userorder"
#

INSERT INTO `userorder` VALUES (1,100005,'lll','lll','10',55,'无折扣','lll','lll',55,4),(3,100005,'lll','lll',NULL,1,'无折扣','lll','lll',1,2),(4,100005,'lll','lll',NULL,1,'无折扣','lll','lll',1,2),(6,100005,'lll','lll',NULL,1,'无折扣','lll','lll',1,2),(7,100005,'lll','lll',NULL,1,'无折扣','lll','lll',1,2),(8,100005,'lll','lll',NULL,1,'无折扣','lll','lll',1,2),(9,100005,'lll','lll',NULL,2,'无折扣','lll','lll',2,2),(10,100005,'lll','lll',NULL,3,'无折扣','lll','lll',3,2),(11,100005,'lll','lll',NULL,2,'无折扣','lll','lll',2,2),(12,100005,'lll','lll',NULL,1,'无折扣','lll','lll',1,2);

#
# Structure for table "orderitem"
#

DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem` (
  `itemID` int(11) NOT NULL AUTO_INCREMENT,
  `bookID` int(11) DEFAULT NULL,
  `booktitle` varchar(60) DEFAULT NULL,
  `bookprice` double DEFAULT '0',
  `orderID` int(11) DEFAULT NULL,
  `num` int(11) DEFAULT '0',
  `price` double DEFAULT '0',
  PRIMARY KEY (`itemID`),
  KEY `bookID` (`bookID`),
  KEY `orderID` (`orderID`),
  CONSTRAINT `orderitem_ibfk_1` FOREIGN KEY (`bookID`) REFERENCES `book` (`bookID`),
  CONSTRAINT `orderitem_ibfk_2` FOREIGN KEY (`orderID`) REFERENCES `userorder` (`orderID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

#
# Data for table "orderitem"
#

INSERT INTO `orderitem` VALUES (1,100000,'红楼梦',55,1,1,55),(3,100000,'红楼梦',1,3,1,1),(4,100000,'红楼梦',1,4,1,1),(6,100000,'红楼梦',1,6,1,1),(7,100000,'红楼梦',1,7,1,1),(8,100000,'红楼梦',1,8,1,1),(9,100000,'红楼梦',1,9,2,2),(10,100000,'红楼梦',1,10,3,3),(11,100000,'红楼梦',1,11,2,2),(12,100000,'红楼梦',1,12,1,1);
