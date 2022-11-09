select * from tbl_book;
DESC `libdb`.`tbl_book`;

CREATE SCHEMA `libdb`;

CREATE TABLE `libdb`.`tbl_book` (
   bookCode INT PRIMARY KEY,
    bookName VARCHAR(45),
    isLend INT
);

INSERT INTO `libdb`.`tbl_book` VALUES(1000, '자바의정석', 1),
                           		     (2020, '윤성우C언어', 1);

CREATE TABLE `libdb`.`tbl_member` (
	memID VARCHAR(20) PRIMARY KEY,
	pwd VARCHAR(255) NOT NULL
);

SELECT * FROM tbl_member;

SELECT * FROM tbl_book;