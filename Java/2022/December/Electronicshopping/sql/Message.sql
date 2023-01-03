create table T_message
(
    id      int          not null auto_increment primary key auto_increment comment '主键',
    userId  int          not null comment '留言用户id',
    title   varchar(255) not null comment '标题',
    content text         not null comment '留言内容',
    time    timestamp    not null default CURRENT_TIMESTAMP comment '留言时间',
    foreign key (userId) references T_user (id)
);
insert in