create table student
(
    id        int auto_increment comment '学号'
        primary key,
    name      varchar(255) null comment '姓名',
    gender    char(10)     null comment '性别',
    classname varchar(255) null comment ''
);