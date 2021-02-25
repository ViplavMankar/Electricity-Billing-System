-- Generation time: Fri, 20 Mar 2020 15:02:44 +0000
-- Host: mysql.hostinger.ro
-- DB name: u574849695_22
/*!40030 SET NAMES UTF8 */;
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

use ElectricityBillingSystem;
DROP TABLE IF EXISTS `Administrator`;
CREATE TABLE `Administrator` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pincode` int(11) DEFAULT NULL,
  `phone` int(11) DEFAULT NULL,
  `password` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `salary` int(11) DEFAULT NULL,
  `area` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `Administrator` VALUES ('100','Hilda','Hilll','6138','801821774','sit','28671','Rajharsh Colony'),
('101','Queen','Windler','36285','619247589','nobis','49337','Kham Kheda'),
('102','Charlene','Kshlerin','54264','698254247','dicta','25630','Chuna Bhatti'),
('103','Gia','Johns','1280','656639855','minus','33622','TT Nagar'),
('104','Jayda','Tromp','64189','739994256','quam','31024','Arera Colony'),
('105','Alisa','Padberg','56845','633185217','eligendi','28135','Bhojpur'),
('106','Jaleel','Lind','35453','884638834','ullam','36904','MP Nagar'),
('107','Helena','Stokes','57820','888643573','perferendis','48402','Ayodhya Nagar'),
('108','Marian','Runolfsdottir','18579','890394715','enim','27803','Kolar Road'),
('109','Hosea','Bergstrom','75889','630893838','laboriosam','42013','Shahpura'),
('110','Patience','Hegmann','54154','652764361','eius','34244','Nehru Nagar'),
('111','Patience','Gusikowski','5449','628316201','voluptas','34300','Hari Ganga Nagar'); 


DROP TABLE IF EXISTS `Bill`;
CREATE TABLE `Bill` (
  `sr` int(11) NOT NULL AUTO_INCREMENT,
  `ID` int(11)  DEFAULT NULL,
  `Admin_id` int(11) DEFAULT NULL,
  `current_reading` int(11) DEFAULT NULL,
  `previous_reading` int(11) DEFAULT NULL,
  `total_units` int(11) DEFAULT NULL,
  `charge_per_unit` int(11) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `due_date` date DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`sr`),
  KEY `Admin_id` (`Admin_id`),
  KEY `ID` (`ID`),
  CONSTRAINT `Bill_ibfk_1` FOREIGN KEY (`Admin_id`) REFERENCES `Administrator` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Bill_ibfk_2` FOREIGN KEY (`ID`) REFERENCES `Customer` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `Bill` VALUES ('1','1','100','964','438',NULL,'7','0','2023-07-24','0'),
('2','2','101','702','399',NULL,'7','2','2023-12-03','0'),
('3','3','102','928','648',NULL,'7','73067','2020-10-23','0'),
('4','4','103','343','213',NULL,'8','1609835','2020-01-20','0'),
('5','5','104','907','883',NULL,'8','0','2022-05-13','0'),
('6','6','105','368','181',NULL,'7','21','2023-09-09','0'),
('7','7','106','577','992',NULL,'7','2978','2020-01-08','0'),
('8','8','107','433','394',NULL,'8','2168482','2020-09-05','0'),
('9','9','108','857','551',NULL,'8','56','2020-08-19','0'),
('10','10','109','799','477',NULL,'7','51409','2021-05-07','0'),
('11','11','110','582','996',NULL,'8','8','2024-02-08','0'),
('12','12','111','864','260',NULL,'7','0','2021-04-30','0'),
('13','13','100','573','116',NULL,'7','11153','2020-03-16','0'),
('14','14','101','394','956',NULL,'7','1','2021-01-02','0'),
('15','15','102','167','808',NULL,'7','46361','2022-06-21','0'),
('16','16','103','704','697',NULL,'8','6021848','2023-05-25','0'),
('17','17','104','380','124',NULL,'8','1','2023-06-22','0'),
('18','18','105','816','422',NULL,'7','5434','2021-06-29','0'),
('19','19','106','925','365',NULL,'8','1857965','2020-08-22','0'),
('20','20','107','572','433',NULL,'8','6','2024-09-02','0'),
('21','21','108','229','299',NULL,'8','41','2024-11-24','0'),
('22','22','109','914','904',NULL,'8','19655730','2022-06-12','0'),
('23','23','110','528','794',NULL,'7','17619632','2021-10-13','0'),
('24','24','111','244','231',NULL,'8','6','2023-01-06','0'),
('25','25','100','558','580',NULL,'8','54','2020-09-25','0'),
('26','26','101','857','332',NULL,'7','19564','2023-02-10','0'),
('27','27','102','726','618',NULL,'8','24210551','2020-09-01','0'),
('28','28','103','859','213',NULL,'7','0','2024-10-09','0'),
('29','29','104','797','680',NULL,'7','42427453','2020-10-23','0'),
('30','30','105','868','239',NULL,'8','4048714','2022-06-28','0'),
('31','31','106','571','791',NULL,'7','159','2024-03-23','0'),
('32','32','107','847','546',NULL,'7','152907370','2022-08-16','0'),
('33','33','108','510','169',NULL,'8','34','2020-06-09','0'),
('34','34','109','676','979',NULL,'8','2781','2020-07-30','0'),
('35','35','110','895','673',NULL,'7','978','2021-12-15','0'),
('36','36','111','905','155',NULL,'8','136722','2021-04-16','0'),
('37','37','100','326','158',NULL,'8','20','2022-07-29','0'),
('38','38','101','178','905',NULL,'8','34049','2021-05-09','0'),
('39','39','102','987','106',NULL,'8','532009615','2023-05-20','0'),
('40','40','103','187','225',NULL,'7','15','2020-07-06','0'),
('41','41','104','897','701',NULL,'7','24644261','2021-07-23','0'),
('42','42','105','996','283',NULL,'8','213936','2021-11-01','0'),
('43','43','106','246','469',NULL,'8','2','2020-04-15','0'),
('44','44','107','767','576',NULL,'7','1576','2021-04-27','0'),
('45','45','108','265','662',NULL,'7','0','2021-03-18','0'),
('46','46','109','677','698',NULL,'8','58536','2024-09-13','0'),
('47','47','110','812','929',NULL,'7','627886','2021-01-08','0'),
('48','48','111','497','567',NULL,'8','9503342','2023-05-09','0'),
('49','49','100','199','513',NULL,'8','2','2024-03-16','0'),
('50','50','101','148','432',NULL,'8','32','2022-04-01','0'),
('51','1','102','666','980',NULL,'8','30293','2023-06-18','0'),
('52','2','103','949','823',NULL,'8','1309523','2020-06-30','0'),
('53','3','104','874','141',NULL,'8','856','2021-02-18','0'),
('54','4','105','429','730',NULL,'8','16941551','2024-10-25','0'),
('55','5','106','679','650',NULL,'7','261863','2020-04-19','0'),
('56','6','107','406','292',NULL,'8','437987','2020-07-06','0'),
('57','7','108','523','855',NULL,'7','29689239','2020-02-05','0'),
('58','8','109','436','154',NULL,'8','10086182','2020-11-06','0'),
('59','9','110','326','784',NULL,'7','4836','2021-08-04','0'),
('60','10','111','107','413',NULL,'8','3938','2020-05-07','0'),
('61','11','100','534','854',NULL,'8','386','2021-12-09','0'),
('62','12','101','642','554',NULL,'7','311914741','2022-04-04','0'),
('63','13','102','986','881',NULL,'8','44','2022-04-02','0'),
('64','14','103','508','236',NULL,'8','9','2021-11-04','0'),
('65','15','104','286','998',NULL,'8','5822','2020-11-10','0'),
('66','16','105','981','633',NULL,'7','34317','2021-08-15','0'),
('67','17','106','722','536',NULL,'7','39290','2021-01-05','0'),
('68','18','107','240','507',NULL,'7','189606609','2023-01-07','0'),
('69','19','108','797','289',NULL,'8','3509','2021-04-04','0'),
('70','20','109','430','606',NULL,'7','84','2021-11-27','0'),
('71','21','110','389','346',NULL,'7','5811316','2021-11-10','0'),
('72','22','111','846','456',NULL,'8','0','2023-04-06','0'),
('73','23','100','957','415',NULL,'7','9920','2020-04-29','0'),
('74','24','101','468','106',NULL,'8','13737','2021-07-19','0'),
('75','25','102','553','913',NULL,'8','2015','2024-06-02','0'),
('76','26','103','433','748',NULL,'8','70038399','2024-09-09','0'),
('77','27','104','788','321',NULL,'8','13','2024-01-22','0'),
('78','28','105','303','489',NULL,'7','350','2021-01-05','0'),
('79','29','106','122','300',NULL,'8','159','2022-08-03','0'),
('80','30','107','773','735',NULL,'8','1591891','2023-07-04','0'),
('81','31','108','916','368',NULL,'8','217','2023-05-19','0'),
('82','32','109','601','693',NULL,'7','488811091','2021-04-27','0'),
('83','33','110','549','903',NULL,'7','3256','2022-12-16','0'),
('84','34','111','153','172',NULL,'7','196309','2023-11-17','0'),
('85','35','100','325','236',NULL,'7','3','2020-06-05','0'),
('86','36','101','508','837',NULL,'8','12','2021-12-14','0'),
('87','37','102','101','334',NULL,'7','84169','2024-08-16','0'),
('88','38','103','976','131',NULL,'7','588786','2020-05-15','0'),
('89','39','104','565','571',NULL,'7','13','2021-01-21','0'),
('90','40','105','290','475',NULL,'7','70','2022-03-22','0'),
('91','41','106','738','234',NULL,'8','331606','2023-02-21','0'),
('92','42','107','176','678',NULL,'7','12011','2024-03-25','0'),
('93','43','108','766','912',NULL,'7','250047308','2024-05-21','0'),
('94','44','109','699','984',NULL,'7','3192','2024-06-03','0'),
('95','45','110','630','741',NULL,'7','1518835','2020-12-10','0'),
('96','46','111','836','371',NULL,'8','121','2024-01-09','0'),
('97','47','100','990','305',NULL,'7','33','2021-07-25','0'),
('98','48','101','847','543',NULL,'7','1137951','2024-12-31','0'),
('99','49','102','257','257',NULL,'8','0','2023-02-22','0'),
('100','50','103','959','151',NULL,'7','448728','2021-11-30','0'); 


DROP TABLE IF EXISTS `Customer`;
CREATE TABLE `Customer` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Admin_id` int(11) DEFAULT NULL,
  `Bill_id` int(11) DEFAULT NULL,
  `Connection_id` int(11) DEFAULT NULL,
  `first_name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pincode` int(11) DEFAULT NULL,
  `phone` mediumtext COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `house_no` int(11) DEFAULT NULL,
  `area` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `city` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `state` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `Admin_id` (`Admin_id`),
  KEY `Bill_id` (`Bill_id`),
  KEY `Connection_id` (`Connection_id`),
  KEY `area` (`area`),
  CONSTRAINT `Customer_ibfk_1` FOREIGN KEY (`Admin_id`) REFERENCES `Administrator` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Customer_ibfk_2` FOREIGN KEY (`Bill_id`) REFERENCES `Bill` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Customer_ibfk_3` FOREIGN KEY (`Connection_id`) REFERENCES `Service` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Customer_ibfk_4` FOREIGN KEY (`area`) REFERENCES `Locations` (`area`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `Customer` VALUES ('1','100','1','1','Darian','Herman','350910','848271728','et','berge.loraine@example.com','1','Bhojpur','Bhopal','MP'),
('2','101','2','2','Hortense','Ruecker','247048','619881328','molestiae','ollie.wilkinson@example.com','1','Ayodhya Nagar','Bhopal','MP'),
('3','102','3','3','Moises','Jones','242102','662324995','molestiae','krista69@example.org','3','Hari Ganga Nagar','Bhopal','MP'),
('4','103','4','4','Raphael','Yost','173014','778866263','velit','knader@example.net','5','Chuna Bhatti','Bhopal','MP'),
('5','104','5','5','Korbin','Grimes','384083','866723892','tenetur','qrolfson@example.org','2','Rajharsh Colony','Bhopal','MP'),
('6','105','6','6','Houston','Dach','314204','783765714','rerum','willms.nasir@example.com','1','Arera Colony','Bhopal','MP'),
('7','106','7','7','Peyton','Morar','464700','872278222','nemo','walter.melyssa@example.org','3','Shahpura','Bhopal','MP'),
('8','107','8','8','Mabel','Hodkiewicz','419023','779544070','aliquid','darian26@example.org','5','MP Nagar','Bhopal','MP'),
('9','108','9','9','Conrad','Romaguera','195396','823046481','perspiciatis','abshire.paxton@example.com','4','Nehru Nagar','Bhopal','MP'),
('10','109','10','10','Gabriella','Schaden','307253','853651119','aut','tromp.cierra@example.com','2','Arera Colony','Bhopal','MP'),
('11','110','11','11','Alayna','Hammes','209493','785602967','maiores','fgerlach@example.com','6','Hari Ganga Nagar','Bhopal','MP'),
('12','111','12','12','Gregory','Beatty','443169','853035531','non','rico.harris@example.net','9','Kham Kheda','Bhopal','MP'),
('13','100','13','13','Waldo','Jast','412296','671015261','vel','okuneva.lilliana@example.net','2','Arera Colony','Bhopal','MP'),
('14','101','14','14','Alyce','D\'Amore','223424','750990497','neque','torp.ewald@example.org','6','Hari Ganga Nagar','Bhopal','MP'),
('15','102','15','15','Annetta','Hamill','433433','631734598','numquam','dayana.haley@example.com','4','Chuna Bhatti','Bhopal','MP'),
('16','103','16','16','Cordell','Carter','322489','716838156','doloribus','randall59@example.net','1','MP Nagar','Bhopal','MP'),
('17','104','17','17','Savanah','Nikolaus','361264','817593828','dicta','damaris11@example.org','8','Nehru Nagar','Bhopal','MP'),
('18','105','18','18','Jeanie','King','428645','740775552','quis','orin25@example.com','3','Ayodhya Nagar','Bhopal','MP'),
('19','106','19','19','Camron','Blanda','142534','666381666','quo','gruecker@example.com','5','Nehru Nagar','Bhopal','MP'),
('20','107','20','20','Garry','Stoltenberg','262000','847761948','saepe','fay.noelia@example.org','9','Ayodhya Nagar','Bhopal','MP'),
('21','108','21','21','Dolores','Wyman','339144','820949340','sit','gerhold.ana@example.org','4','TT Nagar','Bhopal','MP'),
('22','109','22','22','Lambert','Ratke','110950','814844220','reprehenderit','stefanie67@example.org','9','Kham Kheda','Bhopal','MP'),
('23','110','23','23','Angelica','Bogisich','120577','854858618','sit','sherman36@example.com','3','Arera Colony','Bhopal','MP'),
('24','111','24','24','Mandy','Fadel','347457','776542746','quam','ptrantow@example.org','5','TT Nagar','Bhopal','MP'),
('25','100','25','25','Trever','Herzog','381817','766861508','voluptatem','greg87@example.net','9','Chuna Bhatti','Bhopal','MP'),
('26','101','26','26','Alfonzo','Hand','218860','649302542','quas','streich.zoila@example.net','9','Bhojpur','Bhopal','MP'),
('27','102','27','27','Liam','Barrows','430002','845249024','nisi','kayden.hartmann@example.net','7','MP Nagar','Bhopal','MP'),
('28','103','28','28','Luz','Nienow','499798','768843333','debitis','justyn.sawayn@example.net','2','Chuna Bhatti','Bhopal','MP'),
('29','104','29','29','Tanya','Fisher','270167','728119434','optio','herman33@example.net','7','TT Nagar','Bhopal','MP'),
('30','105','30','30','Kiel','Cormier','299370','678914671','distinctio','gordon.ankunding@example.com','2','TT Nagar','Bhopal','MP'),
('31','106','31','31','Rhiannon','Mills','321373','893803090','ullam','ubaldo38@example.net','1','Bhojpur','Bhopal','MP'),
('32','107','32','32','Tanya','Waters','252364','814350652','est','hillary.jacobi@example.net','1','Hari Ganga Nagar','Bhopal','MP'),
('33','108','33','33','Michaela','Feeney','270556','743657054','necessitatibus','henderson10@example.net','9','Rajharsh Colony','Bhopal','MP'),
('34','109','34','34','Carlo','Lueilwitz','261814','766753477','alias','ara.ebert@example.com','9','Bhojpur','Bhopal','MP'),
('35','110','35','35','Patience','Cruickshank','389275','885026683','aperiam','pstracke@example.com','7','Kolar Road','Bhopal','MP'),
('36','111','36','36','Brycen','Dooley','215775','753530247','dolorem','aufderhar.elliot@example.net','4','Rajharsh Colony','Bhopal','MP'),
('37','100','37','37','Rebeca','Kassulke','323279','859357655','non','sharon92@example.com','3','Rajharsh Colony','Bhopal','MP'),
('38','101','38','38','Sienna','Hansen','227177','740747205','assumenda','rutherford.carole@example.net','8','Shahpura','Bhopal','MP'),
('39','102','39','39','Javon','Roob','460280','848231319','officia','enola63@example.com','5','Kolar Road','Bhopal','MP'),
('40','103','40','40','Rosalinda','Tromp','141152','807798308','velit','keanu.howell@example.com','6','MP Nagar','Bhopal','MP'),
('41','104','41','41','Earline','Cartwright','181736','706907775','libero','ulemke@example.net','5','Kham Kheda','Bhopal','MP'),
('42','105','42','42','Everett','Medhurst','283883','787558952','qui','verona94@example.com','2','MP Nagar','Bhopal','MP'),
('43','106','43','43','Isabell','Doyle','494591','624698810','ab','elsa.blanda@example.com','9','Kham Kheda','Bhopal','MP'),
('44','107','44','44','Hilbert','Fritsch','371700','801251664','non','icartwright@example.org','5','Shahpura','Bhopal','MP'),
('45','108','45','45','Myrtis','Veum','435841','763969510','perspiciatis','wisozk.alayna@example.org','9','Arera Colony','Bhopal','MP'),
('46','109','46','46','Una','Hessel','434238','660998346','voluptatum','orville.lueilwitz@example.org','4','Bhojpur','Bhopal','MP'),
('47','110','47','47','Deshawn','Yost','185471','810886354','excepturi','champlin.arne@example.org','7','Rajharsh Colony','Bhopal','MP'),
('48','111','48','48','Emilio','Reilly','313530','651627694','vel','evert30@example.org','6','Kolar Road','Bhopal','MP'),
('49','100','49','49','Holly','Konopelski','471362','728378614','eum','cmosciski@example.net','2','Arera Colony','Bhopal','MP'),
('50','101','50','50','Vladimir','Zulauf','413554','691606098','occaecati','ywintheiser@example.com','5','Ayodhya Nagar','Bhopal','MP'); 


DROP TABLE IF EXISTS `Locations`;
CREATE TABLE `Locations` (
  `area` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `city` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`area`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `Locations` VALUES ('Arera Colony','Bhopal'),
('Ayodhya Nagar','Bhopal'),
('Bhojpur','Bhopal'),
('Chuna Bhatti','Bhopal'),
('Hari Ganga Nagar','Bhopal'),
('Kham Kheda','Bhopal'),
('Kolar Road','Bhopal'),
('MP Nagar','Bhopal'),
('Nehru Nagar','Bhopal'),
('Rajharsh Colony','Bhopal'),
('Shahpura','Bhopal'),
('TT Nagar','Bhopal'); 


DROP TABLE IF EXISTS `Service`;
CREATE TABLE `Service` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `connection_type` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `connection_date` date DEFAULT NULL,
  `occupation` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `house_no` int(11) DEFAULT NULL,
  `area` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `city` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `state` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `load_size` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `Service` VALUES ('1',' business','2007-05-24','business','1','Rajharsh Colony','Bhopal','MP','50'),
('2',' business','2004-01-20','government','9','Bhojpur','Bhopal','MP','150'),
('3',' business','2000-05-03','press','5','MP Nagar','Bhopal','MP','150'),
('4',' business','2012-04-16','press','5','Ayodhya Nagar','Bhopal','MP','150'),
('5',' business','2008-08-11','farming','2','Arera Colony','Bhopal','MP','200'),
('6','household ','2001-03-31','private company','7','Ayodhya Nagar','Bhopal','MP','100'),
('7','household ','2013-01-23','press','9','Kham Kheda','Bhopal','MP','50'),
('8',' business','2011-07-08','business','2','Kolar Road','Bhopal','MP','200'),
('9',' business','2015-04-11','private company','6','Chuna Bhatti','Bhopal','MP','50'),
('10',' business','2016-02-28','private company','8','Nehru Nagar','Bhopal','MP','150'),
('11',' business','2019-01-20','farming','3','Nehru Nagar','Bhopal','MP','100'),
('12',' business','2009-10-01','farming','8','Ayodhya Nagar','Bhopal','MP','100'),
('13',' business','2005-11-17','government','9','Arera Colony','Bhopal','MP','200'),
('14',' business','2006-09-18','government','1','Shahpura','Bhopal','MP','50'),
('15','household ','2002-12-23','farming','8','Nehru Nagar','Bhopal','MP','100'),
('16',' business','2013-04-21','press','2','Arera Colony','Bhopal','MP','200'),
('17',' business','2005-06-11','press','1','Rajharsh Colony','Bhopal','MP','50'),
('18','household ','2006-10-10','private company','8','Bhojpur','Bhopal','MP','50'),
('19',' business','2004-07-04','press','5','Ayodhya Nagar','Bhopal','MP','150'),
('20',' business','2018-06-09','business','7','Bhojpur','Bhopal','MP','200'),
('21',' business','2019-02-16','business','3','Kolar Road','Bhopal','MP','150'),
('22',' business','2003-01-29','business','2','Hari Ganga Nagar','Bhopal','MP','50'),
('23','household ','2011-09-10','press','5','Bhojpur','Bhopal','MP','100'),
('24','household ','2011-06-08','farming','8','Chuna Bhatti','Bhopal','MP','150'),
('25',' business','2014-11-01','government','5','Rajharsh Colony','Bhopal','MP','150'),
('26','household ','2014-11-03','government','7','Bhojpur','Bhopal','MP','100'),
('27',' business','2006-12-12','press','8','Rajharsh Colony','Bhopal','MP','150'),
('28','household ','2004-02-13','private company','6','MP Nagar','Bhopal','MP','150'),
('29','household ','2001-02-19','farming','8','Kolar Road','Bhopal','MP','150'),
('30','household ','2003-07-11','government','4','Kham Kheda','Bhopal','MP','200'),
('31','household ','2003-09-14','private company','4','Kham Kheda','Bhopal','MP','50'),
('32',' business','2004-06-20','business','4','Rajharsh Colony','Bhopal','MP','150'),
('33',' business','2000-03-17','farming','1','Nehru Nagar','Bhopal','MP','50'),
('34','household ','2009-07-15','farming','1','Hari Ganga Nagar','Bhopal','MP','200'),
('35','household ','2016-07-24','government','7','Kolar Road','Bhopal','MP','50'),
('36','household ','2015-08-18','business','7','Arera Colony','Bhopal','MP','50'),
('37',' business','2014-12-31','business','3','Rajharsh Colony','Bhopal','MP','200'),
('38',' business','2015-08-17','business','3','Rajharsh Colony','Bhopal','MP','150'),
('39','household ','2003-08-27','press','8','Kolar Road','Bhopal','MP','100'),
('40','household ','2010-04-28','farming','9','MP Nagar','Bhopal','MP','150'),
('41','household ','2001-03-16','government','2','Arera Colony','Bhopal','MP','50'),
('42','household ','2009-02-28','government','7','Kham Kheda','Bhopal','MP','150'),
('43',' business','2004-03-06','farming','3','Bhojpur','Bhopal','MP','100'),
('44','household ','2000-04-26','business','7','TT Nagar','Bhopal','MP','150'),
('45',' business','2001-10-07','farming','3','MP Nagar','Bhopal','MP','200'),
('46',' business','2006-10-06','press','2','Rajharsh Colony','Bhopal','MP','200'),
('47',' business','2016-09-09','press','4','MP Nagar','Bhopal','MP','50'),
('48',' business','2019-03-20','private company','3','Kham Kheda','Bhopal','MP','200'),
('49','household ','2005-03-08','business','6','Ayodhya Nagar','Bhopal','MP','150'),
('50','household ','2002-03-08','government','8','Nehru Nagar','Bhopal','MP','150'); 

DROP TABLE IF EXISTS `credit_card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `credit_card` (
  `card_id` int(3) NOT NULL,
  `card_no` bigint(16) NOT NULL,
  `cvv` int(3) unsigned NOT NULL,
  PRIMARY KEY (`card_id`),
  KEY `card_id` (`card_id`),
  CONSTRAINT `credit_ibfk_1` FOREIGN KEY (`card_id`) REFERENCES `Customer` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `credit_card`
--


/*!40000 ALTER TABLE `credit_card` DISABLE KEYS */;
INSERT INTO `credit_card` VALUES (1,3784781146794558,563),(2,2611532183829695,195),(3,9403773815836758,146),(4,6294718603137881,211),(5,6555856456980110,743),(6,3871809261385351,925),(7,4272417860105634,204),(8,7748881401494146,833),(9,7660603218246252,226),(10,2223483066540211,414),(11,7437705396208913,518),(12,4656013722531498,976),(13,8139774892479182,289),(14,6773728133644909,950),(15,4971908110659570,774),(16,3735838807653636,273),(17,4509762370027602,547),(18,1113187359645962,712),(19,9289947118144483,155),(20,7485233632847667,324),(21,5150664693210274,271),(22,4192122702021152,272),(23,7207764592021704,736),(24,5635499956551940,783),(25,6497268202714623,317),(26,5167892915662378,877),(27,9414780859835447,684),(28,8909624975640328,161),(29,3961521822959185,223),(30,5183629331178963,449),(31,6663003255613149,291),(32,6294736946932972,591),(33,1214977212715894,562),(34,9563017147593201,676),(35,8112098786979915,748),(36,3493179001845419,636),(37,9047010617330671,385),(38,5721044214442373,519),(39,7557422338053585,196),(40,9262280551251025,896),(41,8728742323350162,992),(42,1445527402218431,815),(43,4278244468849152,308),(44,1032895420212298,371),(45,4005257059819996,938),(46,9452524318359793,832),(47,8911096439696849,456),(48,6181563819758595,229),(49,8729809113312513,703),(50,9724122561048717,536);
/*!40000 ALTER TABLE `credit_card` ENABLE KEYS */;
UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- drop table myTable;