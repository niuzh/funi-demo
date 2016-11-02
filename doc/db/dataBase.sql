DROP DATABASE if EXISTS demo;
CREATE DATABASE demo DEFAULT CHARACTER SET utf8;
USE demo;
# 用户表
CREATE TABLE t_user(
  user_id int AUTO_INCREMENT PRIMARY KEY ,
  user_name VARCHAR(30),
  credits int,
  password VARCHAR(32),
  last_visit DATETIME,
  last_ip VARCHAR(23)
)ENGINE=innoDB;
# 用户登录日志表
CREATE TABLE t_login_log(
  login_log_id int AUTO_INCREMENT PRIMARY KEY ,
  user_id INT,
  ip VARCHAR(23),
  login_datetime DATETIME
)ENGINE=innoDB;
INSERT INTO t_user(user_name,password) VALUES ('admin','123456');
COMMIT ;