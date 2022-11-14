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
-- -----------------------------------------------------
DESC tbl_member;

-- role 열 추가
ALTER TABLE `libdb`.`tbl_member` ADD COLUMN role INT;

DELETE FROM tbl_member;
SELECT * FROM `libdb`.`tbl_member`;

INSERT INTO tbl_member VALUES('mem1', '1111', 0);
INSERT INTO tbl_member VALUES('mgr1', '1111', 1);

SELECT * FROM `libdb`.`tbl_member`;

CREATE TABLE tbl_Lend (
	lid INT AUTO_INCREMENT PRIMARY KEY ,
	bookCode INT NOT NULL,
	memId VARCHAR(45) NOT NULL,
	startDate DATE,
	endDate DATE
);

DESC `libdb`.`tbl_Lend`;

DROP TABLE `libdb`.`tbl_Lend`;


SELECT * FROM `libdb`.`tbl_lend`;
SELECT * FROM `libdb`.`tbl_member`;
SELECT * FROM `libdb`.`tbl_book`;


DELETE FROM `libdb`.`tbl_member`;
INSERT INTO `libdb`.`tbl_member` VALUES('mem1', '1111', 1);
INSERT INTO `libdb`.`tbl_member` VALUES('mgr1', '1111', 2)
SELECT * FROM `libdb`.`tbl_member`;


-- 2022/11/14 MON
SELECT * FROM tbl_book;
SELECT * FROM tbl_lend;
SELECT * FROM tbl_member;

DELETE FROM tbl_book;
DELETE FROM tbl_lend;

INSERT INTO tbl_book VALUES(1010, '자바의 정석1', 1);
INSERT INTO tbl_book VALUES(1011, '자바의 정석2', 1);
INSERT INTO tbl_book VALUES(2000, 'DoItJava', 1);
-- --------------------------------------------------











