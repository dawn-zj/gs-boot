set names UTF8;
create database DB_MIS default character set UTF8;
use DB_MIS;

--
-- Table structure for table gs_book
--
DROP TABLE IF EXISTS gs_book;
CREATE TABLE gs_book (
  id int(10) unsigned NOT NULL AUTO_INCREMENT,
  name varchar(128) DEFAULT NULL,
  author varchar(64) DEFAULT NULL,
  publish varchar(64) DEFAULT NULL,
  time datetime DEFAULT NULL,
  price double(64,2) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table gs_button
--
DROP TABLE IF EXISTS gs_button;
CREATE TABLE gs_button (
  id int(22) NOT NULL AUTO_INCREMENT,
  name varchar(64) NOT NULL,
  url varchar(256) NOT NULL,
  menuId int(22) DEFAULT NULL,
  buttonCode varchar(256) DEFAULT NULL,
  generateTime int(22) DEFAULT NULL,
  updateTime int(22) DEFAULT NULL,
  mac varchar(256) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table gs_menu
--
DROP TABLE IF EXISTS gs_menu;
CREATE TABLE gs_menu (
  ID int(22) NOT NULL AUTO_INCREMENT,
  NAME varchar(64) NOT NULL,
  URL varchar(256) NOT NULL,
  PID int(22) DEFAULT NULL,
  IMG varchar(256) DEFAULT NULL,
  GENERATE_TIME int(22) DEFAULT NULL,
  UPDATE_TIME int(22) DEFAULT NULL,
  MAC varchar(256) DEFAULT NULL,
  MENUCODE varchar(64) DEFAULT NULL,
  PRIMARY KEY (ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table gs_role
--
DROP TABLE IF EXISTS gs_role;
CREATE TABLE gs_role (
  ID int(22) NOT NULL AUTO_INCREMENT,
  NAME varchar(64) NOT NULL,
  MENU_ID varchar(2560) DEFAULT NULL,
  BUTTON_ID varchar(2560) DEFAULT NULL,
  GENERATE_TIME int(22) DEFAULT NULL,
  UPDATE_TIME int(22) DEFAULT NULL,
  MAC varchar(256) DEFAULT NULL,
  PRIMARY KEY (ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table gs_user
--
DROP TABLE IF EXISTS gs_user;
CREATE TABLE gs_user (
  id int(22) NOT NULL AUTO_INCREMENT,
  name varchar(64) NOT NULL,
  account varchar(256) NOT NULL,
  password varchar(256) NOT NULL,
  roleId int(22) DEFAULT NULL,
  status int(22) DEFAULT NULL,
  failedNum int(22) DEFAULT NULL,
  changePass int(22) DEFAULT NULL,
  companyId int(22) DEFAULT NULL,
  generateTime int(22) DEFAULT NULL,
  updateTime int(22) DEFAULT NULL,
  mac varchar(256) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO gs_user VALUES (1001,'admin','admin','admin',2001,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

INSERT INTO gs_book VALUES (1001,'1','1','简氏出版社','2020-07-03 00:00:00',1.00),
                           (1002,'2','2','简氏出版社','2020-07-09 17:19:54',2.00),
                           (1003,'3','3','简氏出版社','2020-07-09 17:23:10',3.00),
                           (1004,'4','4','简氏出版社','2020-07-09 17:22:54',4.00),
                           (1005,'5','5','简氏出版社','2020-07-10 10:33:11',5.00),
                           (1006,'6','6','简氏出版社','2020-07-10 10:58:08',6.00),
                           (1007,'7','7','7','2020-07-10 11:03:16',7.00);

INSERT INTO gs_role VALUES (2001,'超级管理员','100000, 100100, 100101, 100200, 100201, 110000, 110100, 110101, 120000, 120100, 120101, 120200, 120201, 130000, 130100, 130101, 130200, 130201, 130300, 130301, 130302, 130400, 130401, 140000, 140100, 140101, 140200, 140201','3001, 3002',-1,917903259,NULL),
                           (2002,'图书管理员','110000, 110100, 110101','3001, 3002',-1,-1467843596,NULL);

INSERT INTO gs_menu VALUES (100000,'用户管理','#',-1,'Hui-iconfont-root\r\nHui-iconfont-root\r\nHui-iconfont-root',NULL,NULL,NULL,NULL),
                           (100100,'管理员管理','/sysUser/sysUserList.do',100000,NULL,NULL,NULL,NULL,NULL),
                           (100101,'管理员管理','#',100100,NULL,NULL,NULL,NULL,NULL),
                           (100200,'角色管理','/role/roleList.do',100000,NULL,NULL,NULL,NULL,NULL),
                           (100201,'角色管理','#',100200,NULL,NULL,NULL,NULL,NULL),
                           (110000,'图书管理','#',-1,'Hui-iconfont-news',NULL,NULL,NULL,NULL),
                           (110100,'图书管理','/book/bookList.do',110000,NULL,NULL,NULL,NULL,NULL),
                           (110101,'图书管理','#',110100,NULL,NULL,NULL,NULL,NULL),
                           (120000,'系统管理','#',-1,'Hui-iconfont-tongji',NULL,NULL,NULL,NULL),
                           (120100,'系统设置','/system/systemManage.do',120000,NULL,NULL,NULL,NULL,NULL),
                           (120101,'系统设置','#',120100,NULL,NULL,NULL,NULL,NULL),
                           (120200,'数据字典','/system/dictionaryList.do',120000,NULL,NULL,NULL,NULL,NULL),
                           (120201,'数据字典','#',120200,NULL,NULL,NULL,NULL,NULL),
                           (130000,'工具管理','#',-1,'Hui-iconfont-manage2',NULL,NULL,NULL,NULL),
                           (130100,'在线二维码','/tool/barcode/barcodeManage.do',130000,NULL,NULL,NULL,NULL,NULL),
                           (130101,'在线二维码','#',130100,NULL,NULL,NULL,NULL,NULL),
                           (130200,'邮件测试','/tool/email/emailManage.do',130000,NULL,NULL,NULL,NULL,NULL),
                           (130201,'邮件测试','#',130200,NULL,NULL,NULL,NULL,NULL),
                           (130300,'Base64编解码','/tool/base64/toBase64.do',130000,NULL,NULL,NULL,NULL,'base64:toBase64'),
                           (130301,'Base64编码','/tool/base64/toBase64Encode.do',130300,NULL,NULL,NULL,NULL,'base64:toBase64Encode'),
                           (130302,'Base64解码','/tool/base64/toBase64Decode.do',130300,NULL,NULL,NULL,NULL,'base64:toBase64Decode'),
                           (130400,'拾色器','/tool/colorpicker/toColorpicker.do',130000,NULL,NULL,NULL,NULL,NULL),
                           (130401,'拾色器','#',130400,NULL,NULL,NULL,NULL,NULL),
                           (140000,'日志管理','#',-1,'Hui-iconfont-manage2',NULL,NULL,NULL,NULL),
                           (140100,'错误日志','/log/errorLogList.do',140000,NULL,NULL,NULL,NULL,NULL),
                           (140101,'错误日志','#',140100,NULL,NULL,NULL,NULL,NULL),
                           (140200,'调试日志','/log/debugLogList.do',140000,NULL,NULL,NULL,NULL,NULL),
                           (140201,'调试日志','#',140200,NULL,NULL,NULL,NULL,NULL);
INSERT INTO gs_button VALUES (3001,'添加图书','/book/toAddBook.do',110101,'book:toAdd',NULL,NULL,NULL),
                             (3002,'修改图书','/book/toAddBook.do',110101,'book:toUpdate',NULL,NULL,NULL),
                             (3003,'批量删除','/book/deleteBook.do',110101,'book:delete',NULL,NULL,NULL);
