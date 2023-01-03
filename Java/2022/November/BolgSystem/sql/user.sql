create table user(
                     userId int primary key auto_increment comment '用户Id',
                     username varchar(255) unique comment '用户名',
                     password varchar(255)  comment '用户密码'
);