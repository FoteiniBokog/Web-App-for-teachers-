CREATE DATABASE IF NOT EXIST 'test';
USE 'test';

--
--Table structure for table 'course'
--
DROP TABLE IF EXISTS 'course';
CREATE TABLE 'course'(
	'CourseId' int(11) NOT NULL AUTO_INCREMENT,
	'professor' varchar(45) DEFAULT NULL,
	'semester' int(11) NOT NUL AUTO_INCREMENT,
	'CourseName' varchar(45) DEFAULT NULL,
	'year' int(11) NOT NUL AUTO_INCREMENT,
	'syllabus' varchar (45) DEFAULT NULL,
	PRIMARY KEY('CourseId')
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


	
