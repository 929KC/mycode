create database if not exists java_gobang;

use java_gobang;

drop table if exists user;
create table user (
                      userId int primary key auto_increment,
                      username varchar(50) unique,
                      password varchar(255),
                      score int,        -- 天梯积分
                      totalCount int,   -- 比赛总场数
                      winCount int      -- 获胜场数
);
