create table  user
(
    id        int auto_increment primary key comment 'id',
    username varchar(255) null comment ' username',
    password  varchar(255) null comment 'password',
    email     varchar(255) null comment 'email',
    gender    varchar(255) null comment 'gender',
    educationBackground varchar(255) null comment 'educationBackground'
);
