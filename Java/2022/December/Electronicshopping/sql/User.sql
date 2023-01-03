create table T_user(
                       id int not null auto_increment primary key comment '用户编号',
                       name varchar(255) not null comment '用户昵称',
                       trueName varchar(255) not null comment '真实姓名',
                       cardId varchar(255) not null comment '身份证号码',
                       email varchar(50) not null comment '电子邮箱',
                       telephone varchar(25) not null comment '电话号码',
                       qqId varchar(pom.xml
                           controller
                           mapper
                           model
                           utils
                           vo5)  null comment 'QQ',
                       pwd varchar(50) not null default '123456' comment '密码',
                       regTime timestamp not null default   CURRENT_TIMESTAMP   comment '注册时间',
                       question varchar(60) null comment '密码提问',
                       answer varchar(100) null comment '密码答案',
                       state int not   null  default 1 comment  '0表示冻结,1表示未冻结,默认为1'
);
insert into T_user(name,trueName,cardId,email,telephone,qqId,question,answer) values ('929kc','叶秋涵','43102320030945127','3076675259Q@qq.com','18711585787','3076675259','你的生日','不告诉你');