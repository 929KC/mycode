/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.5.15 : Database - task
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`task` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `task`;

/*Table structure for table `tb_fittings` */

DROP TABLE IF EXISTS `tb_fittings`;

CREATE TABLE `tb_fittings` (
  `fit_id` int(11) NOT NULL AUTO_INCREMENT,
  `fit_name` varchar(20) DEFAULT NULL COMMENT '配件名',
  `fit_no` varchar(20) DEFAULT NULL COMMENT '配件编号',
  `fit_qty` int(11) DEFAULT NULL COMMENT '库存数量',
  `fit_factory` varchar(50) DEFAULT NULL COMMENT '配件产地',
  PRIMARY KEY (`fit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `tb_fittings` */

insert  into `tb_fittings`(`fit_id`,`fit_name`,`fit_no`,`fit_qty`,`fit_factory`) values (1,'摄像头','0001',7,'武汉'),(2,'电池','0002',18,'广州'),(3,'外屏','0003',15,'长沙'),(4,'内屏','0004',29,'天津'),(5,'主板','0005',24,'北京');

/*Table structure for table `tb_task` */

DROP TABLE IF EXISTS `tb_task`;

CREATE TABLE `tb_task` (
  `task_id` int(11) NOT NULL AUTO_INCREMENT,
  `cus_name` varchar(20) DEFAULT NULL COMMENT '客户姓名',
  `cus_phone` varchar(20) DEFAULT NULL COMMENT '客户电话',
  `task_name` varchar(20) DEFAULT NULL COMMENT '业务项目',
  `task_no` varchar(20) DEFAULT NULL COMMENT '业务编号',
  `task_status` int(11) DEFAULT NULL COMMENT '0 录单 1 维修 2取机',
  `task_time` datetime DEFAULT NULL COMMENT '下单时间',
  PRIMARY KEY (`task_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `tb_task` */

insert  into `tb_task`(`task_id`,`cus_name`,`cus_phone`,`task_name`,`task_no`,`task_status`,`task_time`) values (6,'阮卫','12331313123123','主板','T-132545',0,'2023-04-28 14:04:15'),(7,'吴门','123445555','外屏','T-134116',0,'2023-04-05 13:45:23'),(8,'李老师','13548636761','摄像头','T-144341',0,'2023-04-05 14:45:41'),(9,'麻六','123131313','电池','T-145334',1,'2023-04-05 14:53:34'),(10,'麻六','123131313','摄像头','T-145350',1,'2023-04-05 14:53:50'),(11,'李老师','1234455666','外屏','T-211924',2,'2023-04-05 21:19:24'),(12,'李老师','12326655','内屏','T-212031',2,'2023-04-05 21:20:31'),(13,'阮卫','13548636761','电池','T-221146',2,'2023-04-05 22:11:46');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
