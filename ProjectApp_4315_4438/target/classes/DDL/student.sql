CREATE DATABASE  IF NOT EXISTS `employee_directory`;
USE `employee_directory`;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `ExamGrade`int(11) NOT NULL AUTO_INCREMENT,
  `ProjectGrade`int(11) NOT NULL AUTO_INCREMENT,
  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `student`
--

INSERT INTO `student` VALUES 
	(1, "Fotini", "Bokogianni", 5.0, 5.0),
	(2,'Effrosyni','Andreou',5.0, 8.0),
	(3,'Maria','Papadopoulou',6.0, 9.0);
	
