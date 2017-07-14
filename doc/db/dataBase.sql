#新增用户
mysql -uroot -pNiu*2017
# 如果存在用户则删除，删除都刷新权限
delete from user where user='demo';
FLUSH PRIVILEGES;
create user 'demo'@'%' identified by 'Niu*2017';
grant all on *.* to 'demo'@'%';
#新用户的登陆
mysql -udemo -pNiu*2017
#配置数据源
在tomcate>conf>context.xml>Context 节点下新增如下数据源
<Resource name="jdbc/demoDB" auth="Container"
type="javax.sql.DataSource"
driverClassName="com.mysql.jdbc.Driver"
url="jdbc:mysql://localhost:3306/demo"
username="demo"
password="Niu*2017"
maxActive="50"
maxIdle="30"
maxWait="10000"/>
#新增数据库
DROP DATABASE if EXISTS demo;
CREATE DATABASE demo DEFAULT CHARACTER SET utf8;

USE demo;
drop table if exists t_login_rec;

drop table if exists t_user;

/*==============================================================*/
/* Table: t_login_rec                                           */
/*==============================================================*/
create table t_login_rec
(
   id                   varchar(50) not null comment 'pk',
   user_id              varchar(50) comment '用户id',
   password             varchar(100) comment '密码',
   login_date           date comment '最后登录日期',
   login_ip             varchar(50) comment '最后登录ip',
   REMARK               varchar(500) comment '备注',
   IS_DELETED           bit comment '是否逻辑删除',
   VERSION              integer comment '版本号',
   SYS_CREATE_TIME      DATE comment '创建时间',
   SYS_UPDATE_TIME      DATE comment '更新时间',
   SYS_DELETE_TIME      DATE comment '删除时间',
   SYS_CREATE_ID        varchar(50) comment '创建者',
   SYS_UPDATE_ID        varchar(50) comment '最后更新人',
   SYS_DELETE_ID        varchar(50) comment '删除人',
   primary key (id)
);

alter table t_login_rec comment '用户登录日志';

/*==============================================================*/
/* Table: t_user                                                */
/*==============================================================*/
create table t_user
(
   id                   varchar(50) not null comment 'pk',
   user_name            varchar(50) comment '用户名',
   password             varchar(100) comment '密码',
   last_login_date      date comment '最后登录日期',
   last_login_ip        varchar(50) comment '最后登录ip',
   REMARK               varchar(500) comment '备注',
   IS_DELETED           bit comment '是否逻辑删除',
   VERSION              integer comment '版本号',
   SYS_CREATE_TIME      DATE comment '创建时间',
   SYS_UPDATE_TIME      DATE comment '更新时间',
   SYS_DELETE_TIME      DATE comment '删除时间',
   SYS_CREATE_ID        varchar(50) comment '创建者',
   SYS_UPDATE_ID        varchar(50) comment '最后更新人',
   SYS_DELETE_ID        varchar(50) comment '删除人',
   primary key (id)
);

alter table t_user comment '用户';
INSERT INTO t_user(id,user_name,password) VALUES (uuid(),'admin','123456');
COMMIT ;