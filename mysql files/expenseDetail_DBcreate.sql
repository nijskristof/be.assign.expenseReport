CREATE DATABASE IF NOT EXISTS `ExpenseReport`;
USE `ExpenseReport`;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS user;
CREATE TABLE user ( 
  USER_ID int(11) NOT NULL AUTO_INCREMENT,  
  FIRST_NAME varchar(50) NOT NULL,  
  LAST_NAME varchar(50) NOT NULL, 
  EMAIL varchar(50) NOT NULL,
  NATIONALIDNUMBER varchar(50) NOT NULL,
  BANK_ACCOUNT varchar(50) NOT NULL,
  USERROLE_ID int(11) NOT NULL,
  PRIMARY KEY (`USER_ID`),
  KEY `USER_ID`(`USER_ID`),
  KEY `USERROLE_ID`(`USERROLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8; 

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
INSERT INTO `user` VALUES (0,'admin', 'admin', 'admin@assign.be', '70010110010', 'BE98 7654 3210 9876', 0),(1,'mede','werker','medewerker@assign.be', '80010110010', 'BE01 2345 6789 0123',1),(2, 'col', 'lega','collega@assign.be', '80010110011', 'BE56 7890 1234 5678',1);
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS userRole;
CREATE TABLE userRole(
  USERROLE_ID int(11) NOT NULL auto_increment,
  ROLE varchar(50) NOT NULL,
  PRIMARY KEY (USERROLE_ID)
)ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `userRole`
--

LOCK TABLES userRole WRITE;
INSERT INTO userRole VALUES(0, 'admin'),(1,'medewerker');
UNLOCK TABLES;

--
-- Table structure for table `file`
--

DROP TABLE IF EXISTS file;
CREATE TABLE file(
  FILE_ID int(11) NOT NULL AUTO_INCREMENT,
  USER_ID int(11) NOT NULL,
  MONTH varchar(12) NOT NULL,
  YEAR int(4) NOT NULL,
  APPROVAL boolean DEFAULT NULL,
  PRIMARY KEY (FILE_ID),
  KEY USER_ID(USER_ID)
  )ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8; 
  
--
-- Dumping data for table `file`
--
  
  LOCK TABLES file WRITE;
  INSERT INTO file VALUES(0,1,'januari',2016,0),(1,2,'januari',2016,0),(2,1,'februari',2016,0),(3,1,'maart',2016,0);
  UNLOCK TABLES;  
  
--
-- Table structure for table `details`
--

DROP TABLE IF EXISTS details;
CREATE TABLE details(
  DETAILS_ID int(11) NOT NULL AUTO_INCREMENT,
  FILE_ID int(11) NOT NULL,
  DESCRIPTION varchar(250),
  SUBSISTANCE_COSTS int(10),
  RESTAURANT_COSTS int(10),
  TRANSPORT_COSTS int(10),
  PARKING_COSTS int(10),
  OTHER_COSTS int(10),
  PRIMARY KEY(DETAILS_ID),
  KEY FILE_ID(FILE_ID)
)  ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8; 

--
-- Dumping data for table `details`
--

  LOCK TABLES details WRITE;
  INSERT INTO details VALUES(0, 0, 'hier komt een beschrijving', 0,0,150,0,0),(1,2,'2de onkost op deze file',250,0,0,0,0),(2,1,'collegas file',0,100,0,0,0),(3,3,'medewerkers onkosten 2de maand',0,0,0,0,200);
  UNLOCK TABLES;  