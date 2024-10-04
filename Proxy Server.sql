/*
SQLyog Community v12.02 (32 bit)
MySQL - 5.5.29 : Database - proxy
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`proxy` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `proxy`;

/*Table structure for table `oreg` */

DROP TABLE IF EXISTS `oreg`;

CREATE TABLE `oreg` (
  `profile` varchar(200) DEFAULT NULL,
  `id` int(11) DEFAULT NULL,
  `user` varchar(200) DEFAULT NULL,
  `pass` varchar(200) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `dob` varchar(200) DEFAULT NULL,
  `gender` varchar(200) DEFAULT NULL,
  `mobile` varchar(200) DEFAULT NULL,
  `location` varchar(200) DEFAULT NULL,
  `status` varchar(255) DEFAULT 'Deactivated'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `oreg` */

LOCK TABLES `oreg` WRITE;

insert  into `oreg`(`profile`,`id`,`user`,`pass`,`email`,`dob`,`gender`,`mobile`,`location`,`status`) values ('admin.png',1,'Lakshmi','lakshmi','lakshmi@gmail.com','14/08/98','female','8285956652','Chennai','Activated'),('aaa.jpg',12,'Laks','laks','lakshmi@gmail.com','14/09/200','female','7878675656','Chennai','Deactivated'),('images.jpg',2123,'Jhansi','jhansi','jhansi@gmail.com','14/09/200','female','7878675656','Chennai','Activated'),('aaa.jpg',453,'Test','test','test@gmail.com','14/09/200','male','7878675656','Chennai','Activated'),('admin.png',657,'Testing','testing','testin@gmail.com','14/09/200','male','7878675656','Chennai','Activated'),('attack.png',121,'Gokul','1234','gokul123@gmail.com','12/07/2000','male','6726371873','Chennai','Activated');

UNLOCK TABLES;

/*Table structure for table `porequest` */

DROP TABLE IF EXISTS `porequest`;

CREATE TABLE `porequest` (
  `id` int(11) DEFAULT NULL,
  `user` varchar(200) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `mobile` varchar(200) DEFAULT NULL,
  `paname` varchar(200) DEFAULT NULL,
  `keyword` varchar(200) DEFAULT NULL,
  `file` varchar(200) DEFAULT NULL,
  `status` varchar(200) DEFAULT 'Waiting',
  `tkey` varchar(200) DEFAULT NULL,
  `skey` varchar(200) DEFAULT NULL,
  `Dstatus` varchar(200) DEFAULT 'Waiting'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `porequest` */

LOCK TABLES `porequest` WRITE;

insert  into `porequest`(`id`,`user`,`email`,`mobile`,`paname`,`keyword`,`file`,`status`,`tkey`,`skey`,`Dstatus`) values (1,'Lakshmi','testing@gmail.com',NULL,NULL,'Java','Java.txt','Accept','66526859A516220A','wsek ,E','Waiting'),(453,'Test','otpsendermessage@gmail.com',NULL,NULL,'Database connection','digital.txt','Accept','453F2CE2CA98D284','aNJT<CS0','Waiting'),(657,'Testing','otpsendermessage@gmail.com',NULL,NULL,'Digital','travel.txt','Accept','18F1F554F070251B','An!Yw,5$','Waiting'),(121,'Gokul','abi12@gmail.com',NULL,NULL,'Digital','Readme.txt','Accept','B728C0BB2CF3A5D9','ooaQZ','Waiting'),(121,'Gokul','abi12@gmail.com',NULL,NULL,'Flower','Readme.txt','Accept','653BC10FE46A6F37','MsQ','Waiting');

UNLOCK TABLES;

/*Table structure for table `upload` */

DROP TABLE IF EXISTS `upload`;

CREATE TABLE `upload` (
  `sno` int(22) NOT NULL AUTO_INCREMENT,
  `id` int(22) DEFAULT NULL,
  `user` varchar(200) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `mobile` varchar(200) DEFAULT NULL,
  `keyword` varchar(200) DEFAULT NULL,
  `tkey` varchar(200) DEFAULT NULL,
  `skey` varchar(200) DEFAULT NULL,
  `file` varchar(200) DEFAULT NULL,
  KEY `sno` (`sno`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `upload` */

LOCK TABLES `upload` WRITE;

insert  into `upload`(`sno`,`id`,`user`,`email`,`mobile`,`keyword`,`tkey`,`skey`,`file`) values (1,1,'Lakshmi','lakshmi@gmail.com','8285956652','Java','66526859A516220A','wsek+,E','Java.txt'),(2,2123,'Jhansi','jhansi@gmail.com','7878675656','db','8892F92D5463E3E3','Y','JDBC.txt'),(3,453,'Test','test@gmail.com','7878675656','Database connection','453F2CE2CA98D284','aNJT<CS0','digital.txt'),(6,121,'Gokul','gokul123@gmail.com','6726371873','Flower','653BC10FE46A6F37','MsQ','Readme.txt'),(7,121,'Gokul','gokul123@gmail.com','6726371873','Digital','DEC0CF986DFCDC31','*eW\"LY&+','ANALYSIS OF THE SECURITY THREATS IN CLOUD COMPUTING TECHNOLOGY (2) (2).docx');

UNLOCK TABLES;

/*Table structure for table `ureg` */

DROP TABLE IF EXISTS `ureg`;

CREATE TABLE `ureg` (
  `profile` varchar(200) DEFAULT NULL,
  `id` int(100) DEFAULT NULL,
  `user` varchar(200) DEFAULT NULL,
  `pass` varchar(200) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `dob` varchar(200) DEFAULT NULL,
  `gender` varchar(200) DEFAULT NULL,
  `mobile` varchar(200) DEFAULT NULL,
  `location` varchar(200) DEFAULT NULL,
  `status` varchar(200) DEFAULT 'Deactivated'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `ureg` */

LOCK TABLES `ureg` WRITE;

insert  into `ureg`(`profile`,`id`,`user`,`pass`,`email`,`dob`,`gender`,`mobile`,`location`,`status`) values ('13-132360_size-admin-user-icon-png.png',11,'Deepa','deepa','1cp.javateam2020@gmail.com','14/08/98','female','8285956652','Chennai','Activated'),('bluebg.jpg',3,'Testing','testing','testing@gmail.com','14/08/98','female','8285956652','Chennai','Activated'),('admin.png',343,'Rani','rani','otpsendermessage@gmail.com','14/09/200','female','7878675656','Chennai','Activated'),('admin.png',341,'Vel','vel','otpsendermessage@gmail.com','14/09/200','male','7878675656','Chennai','Activated'),('aaa.jpg',746,'Murugan','murugan','otpsendermessage@gmail.com','14/09/200','male','7878675656','Chennai','Activated'),('attack.png',121,'Abi','1234','abi12@gmail.com','12/07/2000','male','7645646436','Chennai','Activated');

UNLOCK TABLES;

/*Table structure for table `ureq` */

DROP TABLE IF EXISTS `ureq`;

CREATE TABLE `ureq` (
  `id` int(11) DEFAULT NULL,
  `user` varchar(200) DEFAULT NULL,
  `keyword` varchar(200) DEFAULT NULL,
  `file` varchar(200) DEFAULT NULL,
  `uid` varchar(200) DEFAULT NULL,
  `uname` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `ureq` */

LOCK TABLES `ureq` WRITE;

insert  into `ureq`(`id`,`user`,`keyword`,`file`,`uid`,`uname`) values (12,'lakshmi','null',' sheart.jpg','null','null'),(12,'lakshmi','Heart','sheart.jpg','13','Jeni');

UNLOCK TABLES;

/*Table structure for table `urequest` */

DROP TABLE IF EXISTS `urequest`;

CREATE TABLE `urequest` (
  `sno` int(22) NOT NULL AUTO_INCREMENT,
  `id` int(11) DEFAULT NULL,
  `user` varchar(200) DEFAULT NULL,
  `keyword` varchar(200) DEFAULT NULL,
  `file` varchar(200) DEFAULT NULL,
  `uid` varchar(200) DEFAULT NULL,
  `uname` varchar(200) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `status` varchar(200) DEFAULT 'Waiting',
  `tkey` varchar(200) DEFAULT NULL,
  `skey` varchar(200) DEFAULT NULL,
  `Dstatus` varchar(200) DEFAULT 'Waiting',
  KEY `sno` (`sno`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*Data for the table `urequest` */

LOCK TABLES `urequest` WRITE;

insert  into `urequest`(`sno`,`id`,`user`,`keyword`,`file`,`uid`,`uname`,`email`,`status`,`tkey`,`skey`,`Dstatus`) values (5,1,'Lakshmi','Java','Java.txt','3','Testing','testing@gmail.com','Accept','66526859A516220A','wsek+,E','Delivery'),(6,2123,'Jhansi','db','JDBC.txt','343','Rani','otpsendermessage@gmail.com','Accept','8892F92D5463E3E3','Y','Delivery'),(7,453,'Test','Database connection','digital.txt','341','Vel','otpsendermessage@gmail.com','Accept','453F2CE2CA98D284','aNJT<CS0','Delivery'),(8,657,'Testing','Digital','travel.txt','746','Murugan','otpsendermessage@gmail.com','Accept','18F1F554F070251B','An!Yw,5$','Delivery'),(10,121,'Gokul','Flower','Readme.txt','121','Abi','abi12@gmail.com','Accept','A28ACD3E6EE847D2','_81BA$3X','Waiting');

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
