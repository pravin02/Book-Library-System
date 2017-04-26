-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.39


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema booklibrary
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ booklibrary;
USE booklibrary;

--
-- Table structure for table `booklibrary`.`book`
--

DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `bookId` int(11) NOT NULL AUTO_INCREMENT,
  `categoryId` int(11) NOT NULL,
  `title` varchar(200) NOT NULL,
  `author` varchar(200) NOT NULL,
  `publication` varchar(200) NOT NULL,
  `ISBN` varchar(100) DEFAULT NULL,
  `year` int(4) NOT NULL,
  `image` varchar(100) DEFAULT 'default-50x50.gif',
  `description` varchar(200) DEFAULT NULL,
  `copies` int(11) NOT NULL,
  `rackNo` varchar(45) NOT NULL,
  PRIMARY KEY (`bookId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `booklibrary`.`book`
--

/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` (`bookId`,`categoryId`,`title`,`author`,`publication`,`ISBN`,`year`,`image`,`description`,`copies`,`rackNo`) VALUES 
 (1,3,'C Programming','Pravin','Prashant','101',2015,'28_02_2017_11_46_22.jpg','dfdf',5,'A2'),
 (2,3,'C++  Programming','Pravin Patil','Prashant','101',2015,'28_02_2017_11_43_50.jpg','',15,'A3'),
 (7,1,'Test','Pravin P Patil','PRavin','100',2017,NULL,'Desc',15,'A1'),
 (8,2,'Harry Potter','James Gosling','Harry','200',2016,'23_03_2017_10_28_46.jpg','asa',20,'XZ2');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;


--
-- Table structure for table `booklibrary`.`bookcategory`
--

DROP TABLE IF EXISTS `bookcategory`;
CREATE TABLE `bookcategory` (
  `categoryId` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(100) NOT NULL,
  `description` varchar(50) NOT NULL,
  `image` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`categoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `booklibrary`.`bookcategory`
--

/*!40000 ALTER TABLE `bookcategory` DISABLE KEYS */;
INSERT INTO `bookcategory` (`categoryId`,`category`,`description`,`image`) VALUES 
 (1,'Novel','novel',''),
 (2,'Fiction','fiction',''),
 (3,'Programing','code',NULL);
/*!40000 ALTER TABLE `bookcategory` ENABLE KEYS */;


--
-- Table structure for table `booklibrary`.`bookissue`
--

DROP TABLE IF EXISTS `bookissue`;
CREATE TABLE `bookissue` (
  `bookIssueId` int(11) NOT NULL AUTO_INCREMENT,
  `bookId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `issueDateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `issuedBy` int(11) NOT NULL,
  `leagleReturnDateTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `actualReturnDateTime` timestamp NULL DEFAULT NULL,
  `comment` varchar(200) NOT NULL,
  `status` enum('ISSUED','RETURNED') DEFAULT 'ISSUED',
  PRIMARY KEY (`bookIssueId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `booklibrary`.`bookissue`
--

/*!40000 ALTER TABLE `bookissue` DISABLE KEYS */;
INSERT INTO `bookissue` (`bookIssueId`,`bookId`,`userId`,`issueDateTime`,`issuedBy`,`leagleReturnDateTime`,`actualReturnDateTime`,`comment`,`status`) VALUES 
 (1,1,2,'2017-02-14 12:15:48',0,'2017-03-23 12:15:48',NULL,'','ISSUED'),
 (2,2,2,'2017-02-14 12:16:28',0,'2017-02-16 12:16:28',NULL,'','ISSUED'),
 (3,1,4,'2017-02-14 12:32:34',0,'2017-03-25 12:32:34',NULL,'','ISSUED'),
 (4,3,4,'2017-02-14 15:14:36',0,'2017-02-16 15:14:36',NULL,'','ISSUED'),
 (5,8,2,'2017-03-23 10:44:51',0,'2017-03-25 10:44:51','2017-03-25 10:44:51','','ISSUED');
/*!40000 ALTER TABLE `bookissue` ENABLE KEYS */;


--
-- Table structure for table `booklibrary`.`bookrenewal`
--

DROP TABLE IF EXISTS `bookrenewal`;
CREATE TABLE `bookrenewal` (
  `renewalId` int(11) NOT NULL AUTO_INCREMENT,
  `bookIssueId` int(11) NOT NULL,
  `status` enum('REQUESTED','ACCEPTED','REJECTED') NOT NULL DEFAULT 'REQUESTED',
  `dateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `extendedDateTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`renewalId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `booklibrary`.`bookrenewal`
--

/*!40000 ALTER TABLE `bookrenewal` DISABLE KEYS */;
INSERT INTO `bookrenewal` (`renewalId`,`bookIssueId`,`status`,`dateTime`,`extendedDateTime`) VALUES 
 (2,1,'REQUESTED','2017-01-10 16:16:59','2017-01-14 14:22:35'),
 (3,1,'REQUESTED','2017-01-10 16:19:58','2017-01-16 14:22:35'),
 (4,2,'ACCEPTED','2017-01-10 16:20:12','2017-01-14 14:22:51');
/*!40000 ALTER TABLE `bookrenewal` ENABLE KEYS */;


--
-- Table structure for table `booklibrary`.`education`
--

DROP TABLE IF EXISTS `education`;
CREATE TABLE `education` (
  `educationId` int(11) NOT NULL AUTO_INCREMENT,
  `degree` varchar(100) NOT NULL,
  `college` varchar(100) NOT NULL,
  `board` varchar(100) NOT NULL,
  `percentage` decimal(5,2) DEFAULT NULL,
  `year` int(4) DEFAULT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`educationId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `booklibrary`.`education`
--

/*!40000 ALTER TABLE `education` DISABLE KEYS */;
INSERT INTO `education` (`educationId`,`degree`,`college`,`board`,`percentage`,`year`,`userId`) VALUES 
 (1,'MSc','SMA Science college, Chalisgaon','NMU','100.00',2015,1),
 (2,'Bsc','SMA Science college, Chalisgaon','NMU','70.00',2012,1);
/*!40000 ALTER TABLE `education` ENABLE KEYS */;


--
-- Table structure for table `booklibrary`.`fine`
--

DROP TABLE IF EXISTS `fine`;
CREATE TABLE `fine` (
  `fineId` int(11) NOT NULL AUTO_INCREMENT,
  `bookIssueId` int(11) NOT NULL,
  `fineAmount` float NOT NULL,
  `dateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `comment` varchar(200) NOT NULL,
  PRIMARY KEY (`fineId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `booklibrary`.`fine`
--

/*!40000 ALTER TABLE `fine` DISABLE KEYS */;
INSERT INTO `fine` (`fineId`,`bookIssueId`,`fineAmount`,`dateTime`,`comment`) VALUES 
 (1,1,200,'2017-01-10 15:39:22','fine paid'),
 (2,3,200,'2017-03-24 16:09:42',''),
 (3,3,400,'2017-03-24 16:10:34','testing');
/*!40000 ALTER TABLE `fine` ENABLE KEYS */;


--
-- Table structure for table `booklibrary`.`user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `emailId` varchar(120) NOT NULL,
  `password` varchar(20) NOT NULL,
  `fullName` varchar(100) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `dob` varchar(10) DEFAULT NULL,
  `mobileNumber` varchar(10) NOT NULL,
  `address` varchar(200) NOT NULL,
  `image` varchar(100) DEFAULT NULL,
  `designation` varchar(45) NOT NULL,
  `country` varchar(45) NOT NULL,
  `state` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `userType` enum('ADMIN','STUDENT','STAFF') NOT NULL,
  `status` enum('ACTIVE','INACTIVE','DELETED') DEFAULT 'INACTIVE',
  PRIMARY KEY (`userId`),
  UNIQUE KEY `emailId_UNIQUE` (`emailId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `booklibrary`.`user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`userId`,`emailId`,`password`,`fullName`,`gender`,`dob`,`mobileNumber`,`address`,`image`,`designation`,`country`,`state`,`city`,`userType`,`status`) VALUES 
 (1,'admin@gmail.com','admin','Staff Tester','MALE','12/2/1991','7276622442','AAAA',NULL,'AAAA','','','','ADMIN','INACTIVE'),
 (2,'ppp@gmail.com','Student Tester@','Student Tester','MALE','12/2/1991','7276622441','Jalgaon',NULL,'Student','','','','STUDENT','INACTIVE'),
 (3,'staff1@gmail.com','staff1','Staff1','MALE','1991-12-2','7276622443','Jalgaon',NULL,'Teacher','','','','STAFF','ACTIVE'),
 (4,'student1@gmail.com','student1','Student1','MALE','1991-3-23','7276622444','Jalgaon',NULL,'Student','','','','STUDENT','ACTIVE'),
 (5,'staff3@gmail.com','staff3123','Staff3','MALE','1991-2-12','7276622449','Shiv Colony,',NULL,'HOD','','','','STAFF','INACTIVE'),
 (6,'student2@gmail.com','student2','Student2','MALE','1991-2-12','7276622445','Shiv Colony,',NULL,'Student','India','Maharashtra','Pachora','STUDENT','INACTIVE');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


--
-- Procedure `booklibrary`.`addBook`
--

DROP PROCEDURE IF EXISTS `addBook`;
DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `addBook`(
	IN p_categoryId 	VARCHAR(100),
    IN p_title 			VARCHAR(200),
    IN p_author 		VARCHAR(200),
    IN p_publication 	VARCHAR(200),
    IN p_ISBN	 		VARCHAR(20),
    IN p_year	 		VARCHAR(200),
    IN p_image			VARCHAR(20),
    IN p_description	VARCHAR(200),
    IN p_copies			INT,
    IN p_rackNo			VARCHAR(10)
)
BEGIN

	INSERT INTO book
    (
		categoryId, 
        title,
        author,
        publication,
        ISBN,
        year,
        image,
        description,
        copies,
        rackNo
    )
    VALUES
    (
		p_categoryId,
        p_title,
        p_author,
        p_publication,
        p_ISBN,
        p_year,		
        p_image,
        p_description,
        p_copies,
        p_rackNo
    );
END $$

DELIMITER ;

--
-- Procedure `booklibrary`.`addBookCategory`
--

DROP PROCEDURE IF EXISTS `addBookCategory`;
DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `addBookCategory`(
	IN p_category VARCHAR(100),
    IN p_description VARCHAR(200)
)
BEGIN
	INSERT INTO bookCategory
    (
		category, 
        description
    )
    VALUES
    (
		p_category,
		p_description
    );
END $$

DELIMITER ;

--
-- Procedure `booklibrary`.`addEducation`
--

DROP PROCEDURE IF EXISTS `addEducation`;
DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `addEducation`(
	IN p_userId 	INT,
    IN p_degree 	VARCHAR(100),
    IN p_college 	VARCHAR(100),
    IN p_board		VARCHAR(100),
    IN p_percentage DECIMAL(5, 2),
    IN p_year 		INT(4)    
    )
BEGIN

	INSERT INTO education
    (
		userId,
        degree,
        college,
        board,
        percentage,
        year        
    )
    VALUES
    (
		p_userId,
        p_degree,
        p_college,
        p_board,
        p_percentage,
        p_year
    );

END $$

DELIMITER ;

--
-- Procedure `booklibrary`.`getBookById`
--

DROP PROCEDURE IF EXISTS `getBookById`;
DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getBookById`(

	IN p_categoryId INT,

    IN p_bookId INT

)
BEGIN



	IF(p_categoryId = 0)

    THEN    

		SELECT 

			b.*, availableBookCopies(B.bookId) AS availableBookCopies, bc.*

		FROM

			book b

		INNER JOIN

			bookCategory bc ON b.categoryId = bc.categoryId

		WHERE

			b.bookId = p_bookId;

	ELSE

    

    SELECT 

			b.*, availableBookCopies(B.bookId) AS availableBookCopies, bc.*

		FROM

			book b

		INNER JOIN

			bookCategory bc ON b.categoryId = bc.categoryId

		WHERE

			b.bookId = p_bookId

            AND b.categoryId = p_categoryId;

            

    END IF;



END $$

DELIMITER ;

--
-- Procedure `booklibrary`.`getBookCategories`
--

DROP PROCEDURE IF EXISTS `getBookCategories`;
DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getBookCategories`()
BEGIN
	
    SELECT * FROM bookCategory;

END $$

DELIMITER ;

--
-- Procedure `booklibrary`.`getBookCategoryById`
--

DROP PROCEDURE IF EXISTS `getBookCategoryById`;
DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getBookCategoryById`(
	IN p_categoryId INT
)
BEGIN

	SELECT * FROM bookCategory WHERE categoryId = p_categoryId;

END $$

DELIMITER ;

--
-- Procedure `booklibrary`.`getBooksByCategoryId`
--

DROP PROCEDURE IF EXISTS `getBooksByCategoryId`;
DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getBooksByCategoryId`(
IN p_categoryId INT)
BEGIN



	SELECT 

    b.*, availableBookCopies(B.bookId) AS availableBookCopies, bc.*

FROM

    book b

        INNER JOIN

    bookCategory bc ON b.categoryId = bc.categoryId

WHERE

        b.categoryId = p_categoryId;
END $$

DELIMITER ;

--
-- Procedure `booklibrary`.`getDashboardData`
--

DROP PROCEDURE IF EXISTS `getDashboardData`;
DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getDashboardData`()
BEGIN
	DECLARE p_totalBookCategories 	INT DEFAULT 0;
    DECLARE p_totalBooks 			INT DEFAULT 0;
    DECLARE p_totalStudents 		INT DEFAULT 0;
    DECLARE p_totalStaffs 			INT DEFAULT 0;
    
    SELECT COUNT(*) INTO p_totalBookCategories  FROM bookCategory;
    SELECT COUNT(*) INTO p_totalBooks		  	FROM book;
    SELECT COUNT(*) INTO p_totalStudents		FROM user WHERE userType IN ('STUDENT');
    SELECT COUNT(*) INTO p_totalStaffs		  	FROM user WHERE userType IN ('STAFF');
    
    
    SELECT p_totalBookCategories AS totalBookCategories, 
    p_totalBooks AS totalBooks, 
    p_totalStudents AS totalStudents, 
    p_totalStaffs AS totalStaffs;
    
END $$

DELIMITER ;

--
-- Procedure `booklibrary`.`getEducationById`
--

DROP PROCEDURE IF EXISTS `getEducationById`;
DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getEducationById`(
	IN p_educationId	INT
)
BEGIN
	SELECT e.* 
    FROM education e
    INNER JOIN user u
    ON e.userId = u.userId
    WHERE e.educationId = p_educationId
    AND u.status = 'ACTIVE'
    AND u.userType IN ('STUDENT', 'STAFF');
END $$

DELIMITER ;

--
-- Procedure `booklibrary`.`getEducationListByUserId`
--

DROP PROCEDURE IF EXISTS `getEducationListByUserId`;
DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getEducationListByUserId`(
	IN p_userId INT
)
BEGIN
	SELECT e.* 
    FROM education e
    INNER JOIN user u
    ON e.userId = u.userId
    WHERE e.userId = p_userId
    AND u.status = 'ACTIVE'
    AND u.userType IN ('STUDENT', 'STAFF');
END $$

DELIMITER ;

--
-- Procedure `booklibrary`.`getIssuedBooks`
--

DROP PROCEDURE IF EXISTS `getIssuedBooks`;
DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getIssuedBooks`()
BEGIN
SELECT 
    u.userId, u.fullName,  bc.*, b.*, availableBookCopies(B.bookId) AS availableBookCopies, bi.* 
FROM
    book b
        INNER JOIN
    bookCategory bc ON b.categoryId = bc.categoryId
        INNER JOIN
    bookIssue bi ON b.bookId = bi.bookId
       INNER JOIN user u
       ON u.userId = bi.userId
    group by bi.userId, bi.bookId
    ORDER BY bi.leagleReturnDateTime ASC;
END $$

DELIMITER ;

--
-- Procedure `booklibrary`.`getIssuedBooksByUserId`
--

DROP PROCEDURE IF EXISTS `getIssuedBooksByUserId`;
DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getIssuedBooksByUserId`(

	IN p_userId INT

)
BEGIN

SELECT 

    u.userId, u.fullName,  bc.*, b.*, availableBookCopies(B.bookId) AS availableBookCopies, bi.* 

FROM

    book b

        INNER JOIN

    bookCategory bc ON b.categoryId = bc.categoryId

        INNER JOIN

    bookIssue bi ON b.bookId = bi.bookId
       INNER JOIN user u
       ON u.userId = p_userId
    WHERE bi.userId = p_userId;

END $$

DELIMITER ;

--
-- Procedure `booklibrary`.`getUserDetails`
--

DROP PROCEDURE IF EXISTS `getUserDetails`;
DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getUserDetails`(
	IN p_userId		INT
)
BEGIN

	SELECT * FROM user WHERE userId = p_userId;

END $$

DELIMITER ;

--
-- Procedure `booklibrary`.`getUsersByUserType`
--

DROP PROCEDURE IF EXISTS `getUsersByUserType`;
DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getUsersByUserType`(
	IN p_userType VARCHAR(30)
)
BEGIN

	SELECT * FROM user WHERE userType = p_userType
    AND status NOT IN ('DELETED')
    AND userType NOT IN ('ADMIN');

END $$

DELIMITER ;

--
-- Procedure `booklibrary`.`isBookIssued`
--

DROP PROCEDURE IF EXISTS `isBookIssued`;
DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `isBookIssued`(
	IN p_bookId INT, 
    IN p_userId INT
)
BEGIN
	SELECT * FROM bookIssue WHERE bookId = p_bookId AND userId = p_userId
    AND status ='ISSUED'
    AND leagleReturnDateTime > NOW();
END $$

DELIMITER ;

--
-- Procedure `booklibrary`.`issueBook`
--

DROP PROCEDURE IF EXISTS `issueBook`;
DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `issueBook`(
	IN p_bookId INT,
	IN p_userId INT    
)
BEGIN

	INSERT INTO bookIssue(bookId, userId, leagleReturnDateTime, actualReturnDateTime)
    VALUES(p_bookId, p_userId, 
    DATE_ADD(CURRENT_TIMESTAMP, INTERVAL 2 DAY ), DATE_ADD(CURRENT_TIMESTAMP, INTERVAL 2 DAY ));

END $$

DELIMITER ;

--
-- Procedure `booklibrary`.`isUserExists`
--

DROP PROCEDURE IF EXISTS `isUserExists`;
DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `isUserExists`(	
    IN p_emailId	VARCHAR(120),
    IN p_mobileNumber	VARCHAR(10)
)
BEGIN
	DECLARE p_message VARCHAR(100);    

	IF(SELECT userId FROM user WHERE emailId = p_emailId LIMIT 1)
		THEN
			SET	p_message = 'EmailId Already Exists';            
	ELSE 
		IF(SELECT userId FROM user WHERE mobileNumber = p_mobileNumber LIMIT 1)
		THEN
			SET	p_message = 'Mobile Number Already Exists';	        	
	END IF;    
    END IF;
    
    SELECT p_message AS message;
END $$

DELIMITER ;

--
-- Procedure `booklibrary`.`loginAdmin`
--

DROP PROCEDURE IF EXISTS `loginAdmin`;
DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `loginAdmin`(

	IN p_emailId VARCHAR(120),

    IN p_password VARCHAR(20)

)
BEGIN



	SELECT * FROM user WHERE emailId = p_emailId

	AND password = p_password AND userType IN ('ADMIN');

END $$

DELIMITER ;

--
-- Procedure `booklibrary`.`loginUser`
--

DROP PROCEDURE IF EXISTS `loginUser`;
DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `loginUser`(
	IN p_emailId VARCHAR(120),
    IN p_password VARCHAR(20)
)
BEGIN

	SELECT * FROM user WHERE emailId = p_emailId
	AND password = p_password AND status IN ('ACTIVE', 'INACTIVE');
END $$

DELIMITER ;

--
-- Procedure `booklibrary`.`registerFine`
--

DROP PROCEDURE IF EXISTS `registerFine`;
DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `registerFine`(
	IN p_bookIssueId	INT,
    IN p_fine			DOUBLE,
    IN p_comment		VARCHAR(200)
)
BEGIN

	INSERT INTO fine
    (
		bookIssueId,
        fineAmount,
        comment
    )
    VALUES
    (
		p_bookIssueId,
        p_fine,
        p_comment
    );
END $$

DELIMITER ;

--
-- Procedure `booklibrary`.`registerUser`
--

DROP PROCEDURE IF EXISTS `registerUser`;
DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `registerUser`(
	IN p_fullName 	VARCHAR(100),
    IN p_emailId 	VARCHAR(120),
    IN p_password 	VARCHAR(20),
    IN p_gender 	VARCHAR(6),
    IN p_dob 		VARCHAR(10),
    IN p_mobileNumber 	VARCHAR(10),
    
    IN p_country 	VARCHAR(200),
    
    IN p_state	 	VARCHAR(200),
    
    IN p_city 	VARCHAR(200),
    
    IN p_address 	VARCHAR(200),
    IN p_image		VARCHAR(20),
    IN p_designation VARCHAR(50),
    IN p_userType	VARCHAR(20)
    )
BEGIN
	INSERT INTO user
    (
		fullName, 
		emailId, 
		password, 
		gender, 
		dob, 
		mobileNumber,
		
        country,
        
        state,
        
        city,
        
		address, 
		image,
        designation,
        userType)
	VALUES
    (
		p_fullName, 
        p_emailId, 
        p_password, 
        p_gender, 
        p_dob, 
        p_mobileNumber,
        
		p_country,
        
        p_state,
        
        p_city,
        p_address, 
        p_image,
        p_designation,
        p_userType
	);
END $$

DELIMITER ;

--
-- Procedure `booklibrary`.`requestForRenewal`
--

DROP PROCEDURE IF EXISTS `requestForRenewal`;
DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `requestForRenewal`(
	IN p_bookIssueId	INT    
)
BEGIN
	DECLARE p_extendedDateTime TIMESTAMP;

	IF NOT EXISTS(SELECT extendedDateTime FROM bookRenewal WHERE bookIssueId = p_bookIssueId)
    THEN
		SELECT DATE_ADD(leagleReturnDateTime, INTERVAL 2 DAY) INTO p_extendedDateTime
		FROM bookIssue WHERE bookIssueId = p_bookIssueId;
	ELSE
		SELECT DATE_ADD(extendedDateTime, INTERVAL 2 DAY) INTO p_extendedDateTime
		FROM bookRenewal WHERE bookIssueId = p_bookIssueId ORDER BY extendedDateTime DESC LIMIT 1;
	END IF;
        
	INSERT INTO bookRenewal
    (
		bookIssueId,
        extendedDateTime
    )
    VALUES
    (
		p_bookIssueId,
        p_extendedDateTime
    );
END $$

DELIMITER ;

--
-- Procedure `booklibrary`.`searchBook`
--

DROP PROCEDURE IF EXISTS `searchBook`;
DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `searchBook`(

	IN p_title VARCHAR(100),

    IN p_author VARCHAR(100),

    IN p_publication VARCHAR(100),

    IN p_category	VARCHAR(100)

)
BEGIN



	SELECT 

    b.*, availableBookCopies(B.bookId) AS availableBookCopies, bc.*

FROM

    book b

        INNER JOIN

    bookCategory bc ON b.categoryId = bc.categoryId

WHERE

    title LIKE	CONCAT('%', p_title, '%')

        AND publication LIKE CONCAT('%', p_publication, '%')

        AND category LIKE CONCAT('%', p_category, '%')

		AND author LIKE CONCAT('%', p_author, '%');

END $$

DELIMITER ;

--
-- Procedure `booklibrary`.`updateBook`
--

DROP PROCEDURE IF EXISTS `updateBook`;
DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateBook`(
	IN p_bookId INT, 
	IN p_image VARCHAR(100), 
    IN p_description VARCHAR(200)
)
BEGIN
	UPDATE book SET image = p_image, description = p_description WHERE bookId = p_bookId;
END $$

DELIMITER ;

--
-- Procedure `booklibrary`.`updateBookImage`
--

DROP PROCEDURE IF EXISTS `updateBookImage`;
DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateBookImage`(
	IN p_bookId INT,
    IN p_imageName VARCHAR(100)
)
BEGIN
	UPDATE book SET image = p_imageName WHERE bookId = p_bookId;
END $$

DELIMITER ;

--
-- Procedure `booklibrary`.`updateBookIssueStatus`
--

DROP PROCEDURE IF EXISTS `updateBookIssueStatus`;
DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateBookIssueStatus`(
	IN p_bookIssueId 	INT,    
    IN p_comment		VARCHAR(200)
)
BEGIN
		UPDATE bookIssue 
			SET comment = p_comment,    
			status = 'RETURNED',
            actualReturnDateTime = NOW()
		WHERE
			bookIssueId = p_bookIssueId;    
END $$

DELIMITER ;

--
-- Procedure `booklibrary`.`updateRenewalStatus`
--

DROP PROCEDURE IF EXISTS `updateRenewalStatus`;
DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateRenewalStatus`(
	IN p_renewalId	INT,
    IN p_status	VARCHAR(20)
)
BEGIN
	UPDATE bookRenewal
    SET status = p_status
    WHERE renewalId = p_renewalId;
END $$

DELIMITER ;

--
-- Procedure `booklibrary`.`updateUser`
--

DROP PROCEDURE IF EXISTS `updateUser`;
DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateUser`(
	IN p_userId 	INT,
    IN p_mobileNumber	VARCHAR(10),
    IN p_address		VARCHAR(200)    
)
BEGIN
	UPDATE user 
    SET 
		mobileNumber= p_mobileNumber,
        address 	= p_address
	WHERE userId = p_userId;
END $$

DELIMITER ;

--
-- Procedure `booklibrary`.`updateUserPassword`
--

DROP PROCEDURE IF EXISTS `updateUserPassword`;
DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateUserPassword`(
		p_userId 			INT,
        p_oldPassword   	VARCHAR(20),
        p_newPassword 		VARCHAR(20)
        )
BEGIN
	DECLARE p_message VARCHAR(200);
    IF( 
		SELECT userId FROM user 
		WHERE userId = p_userId 
		AND password = P_oldPassword 
		AND status IN ('ACTIVE') 
        AND userType IN('STUDENT', 'STAFF')
	)
    THEN
		UPDATE user SET password = p_newPassword WHERE userId = p_userId;
		SET	p_message = 'password updated Successfully';
	ELSE IF (    
		SELECT userId FROM user 
		WHERE userId = p_userId 
		AND password = P_oldPassword 
		AND status IN ('ACTIVE')
        OR userType IN('ADMIN') 
    )
    THEN
		SET	p_message = 'Unauthorized user.';
	ELSE
		SET	p_message = 'Old and new password not matched.';
    END IF;
    END IF;
    SELECT p_message AS message;
END $$

DELIMITER ;

--
-- Procedure `booklibrary`.`updateUserProfilePic`
--

DROP PROCEDURE IF EXISTS `updateUserProfilePic`;
DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateUserProfilePic`(
	IN p_userId 	INT,
    IN p_imageName	VARCHAR(100)
)
BEGIN

	UPDATE user SET image = p_imageName WHERE userId = p_userId;

END $$

DELIMITER ;

--
-- Procedure `booklibrary`.`updateUserStatus`
--

DROP PROCEDURE IF EXISTS `updateUserStatus`;
DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateUserStatus`(
	IN p_userId INT, 
    IN p_status VARCHAR(20)
)
BEGIN
	UPDATE user SET status = p_status WHERE userId = p_userId;
END $$

DELIMITER ;

--
-- Function `booklibrary`.`availableBookCopies`
--

DROP FUNCTION IF EXISTS `availableBookCopies`;
DELIMITER $$

CREATE DEFINER=`root`@`localhost` FUNCTION `availableBookCopies`(	p_bookId INT) RETURNS int(11)
BEGIN
	DECLARE p_totalQuantity			INT;
    DECLARE p_totalBookedQuantity	INT;
    
	-- DATE_ADD(leagleReturnDateTime, INTERVAL 2 DAY) INTO p_extendedDateTime
    
    SELECT
		IFNULL(B.copies, 0)
	INTO
		p_totalQuantity
	FROM
		book						AS B
	WHERE
		B.bookId = p_bookId;
        
	SELECT
		COUNT(*) 
	INTO
		p_totalBookedQuantity
	FROM 
		bookIssue					AS BI
	WHERE
		BI.bookId = p_bookId
	AND
		CURDATE() BETWEEN DATE(issueDateTime)
	AND 
		DATE(BI.leagleReturnDateTime)
	;
    
    RETURN p_totalQuantity - p_totalBookedQuantity;
END $$

DELIMITER ;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
