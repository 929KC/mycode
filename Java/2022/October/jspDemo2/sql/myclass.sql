create table myclass
(
    id           int auto_increment comment '班级号'
        primary key,
    classname    varchar(255) null comment '班级名称',
    teacher      varchar(255) null comment '老师',
    professional varchar(255) null comment '专业'
);
