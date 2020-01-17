
CREATE DATABASE demo1; --创建数据库demo1
USE demo1; --使用数据库
-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE user(
id INT PRIMARY KEY auto_increment,
name VARCHAR(20) NOT NULL,
gender VARCHAR(5),
age INT,
address VARCHAR(50),
qq VARCHAR(20),
email VARCHAR(50)
);