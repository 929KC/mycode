create table blog (
                      blogId int auto_increment primary key comment  '博客id',
                      title varchar(255)  null comment '博客标题',
                      content mediumtext  null  comment '博客内容',
                      userId int null,
                      postTime datetime
);