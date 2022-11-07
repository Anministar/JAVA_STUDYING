SELECT * FROM buytbl;


-- 4)다음 행중에 그룹네임이 있는 행만 출력
SELECT * FROM buytbl WHERE groupname != 'null';

-- 강사님 해답
SELECT * FROM buytbl WHERE groupname <> 'null';
SELECT * FROM buytbl WHERE groupname is not null;

-- 5)prodName 별로 총합을 구해보세요 (ROLLUP사용)
SELECT prodName, SUM(price * amount) FROM buytbl GROUP BY ROLLUP(prodName);

SELECT prodname, SUM(amount) FROM buytbl GROUP BY ROLLUP(prodname);
SELECT num, prodname, SUM(amount) FROM buytbl GROUP BY ROLLUP(prodname, num);
-- 소합계는 PRIMARY KEY를 이용함으로써 구한다.

-- ------------------------------------------------------------------------
DROP TABLE tmp_tbl;
CREATE TABLE tmp_tbl (
    id INT,
    username CHAR(10),
    age INT
);
DROP SEQUENCE tmp_seq;
CREATE SEQUENCE tmp_seq
START WITH 1
INCREMENT BY 1
MAXVALUE 100
CYCLE NOCACHE;
-- developer가 문법자체가 문제가 있다고 판단하는데 START WITH 1 이 부분을. 근데 사실 이어붙어쓰면 문제가 안됨. 그냥 잘못 잡아주는거, 즉 맞음.

INSERT INTO tmp_tbl VALUES (tmp_seq.NEXTVAL, 'aaa', 11);
INSERT INTO tmp_tbl VALUES (tmp_seq.NEXTVAL, 'aab', 11);
INSERT INTO tmp_tbl VALUES (tmp_seq.NEXTVAL, 'aac', 11);
INSERT INTO tmp_tbl VALUES (tmp_seq.NEXTVAL, 'aad', 11);
-- NEXTVAL == 다음 값

SELECT * FROM tmp_tbl;

SELECT tmp_seq.CURRVAL FROM dual;
-- dual이라는 테이블은 오라클 자체에서 제공되는 테이블임. 현재 저장된 시퀀스 값.


-- -----------------------------------------------------------------------------------------
CREATE TABLE test_01 (
userid CHAR(10) PRIMARY KEY,
name CHAR(10) NOT NULL
);

CREATE TABLE test_02 (
userid CHAR(10),
name CHAR(10) NOT NULL,
PRIMARY KEY(userid)
);

SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME = 'TEST_01';
-- 모든 CONSTRAINTS 중에 TEST_01 테이블의 제약조건을 보여달라.
-- 조회해보면 CONSTRAINT_TYPE 이 있는데 C == NOT NULL, P == PRIMARY KEY
-- C : NOT NULL, P : PRIMARY KEY

SELECT * FROM ALL_CONS_COLUMNS WHERE TABLE_NAME = 'TEST_01';


ALTER TABLE test_01 DROP PRIMARY KEY;
SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME = 'TEST_01';

ALTER TABLE test_01 ADD CONSTRAINT PK_Tbl_01 PRIMARY KEY(userid);
SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME = 'TEST_01';

CREATE TABLE test_03 (
userid CHAR(10),
name CHAR(10) NOT NULL,
PRIMARY KEY(userid, name)
);

SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME = 'TEST_03';
SELECT * FROM ALL_CONS_COLUMNS WHERE TABLE_NAME = 'TEST_03';

CREATE TABLE test_04 (
userid CHAR(10),
name CHAR(10) NOT NULL
);


ALTER TABLE test_04 ADD CONSTRAINT PK_TEST_04 PRIMARY KEY(userid, name);
SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME = 'TEST_04';
SELECT * FROM ALL_CONS_COLUMNS WHERE TABLE_NAME = 'TEST_04';

-- --------------------------------------------------------------------------
CREATE TABLE tbl_prod (
prod_id INT PRIMARY KEY,
prod_name VARCHAR(40)
);

CREATE TABLE tbl_order (
order_id INT PRIMARY KEY,
prod_id INT,
order_date date,
CONSTRAINT FK_ORDER_PROD FOREIGN KEY(prod_id) REFERENCES tbl_prod(prod_id)
);

-- C : CHECK, NOT NULL , P : PRIMARY KEY, R : FOREIGN KEY, U : UNIQUE
SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME = 'TBL_ORDER';
SELECT * FROM ALL_CONS_COLUMNS WHERE TABLE_NAME = 'TBL_ORDER';
-- ALL_CONSTRAINTS나 ALL_CONS_COLUMNS가 들어가는 조건절은 다 대문자를 사용해야함.

ALTER TABLE tbl_order DROP CONSTRAINT FK_ORDER_PROD;
SELECT * FROM ALL_CONSTRAINS WHERE TABLE_NAME = 'TBL_ORDER';

ALTER TABLE tbl_order ADD CONSTRAINT FK_O_P FOREIGN KEY(prod_id) REFERENCES tbl_prod(prod_id)
    ON DELETE CASCADE;  -- 오라클에서는 On update cascade 지원하지 않는다. 트리거 설정을 통해 동일한 기능 구현

SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME = 'TBL_ORDER';

-- -------------------------------------------------------------------
-- 문제
-- -------------------------------------------------------------------
SELECT * FROM buytbl;
SELECT * FROM usertbl;


CREATE TABLE productTbl (
code INT PRIMARY KEY,
prodNAME VARCHAR2(25) NOT NULL,
price INT,
count INT 
);


CREATE TABLE customerTbl (
num INT PRIMARY KEY,
userid VARCHAR2(50) NOT NULL,
name VARCHAR2(10) NOT NULL,
addr VARCHAR2(10) NOT NULL,
grade VARCHAR2(5) NOT NULL,
phone VARCHAR2(15) NOT NULL,
code INT NOT NULL,
amount INT NOT NULL,
CONSTRAINTS FK_cd_code FOREIGN KEY (code) REFERENCES productTbl(code)
ON DELETE CASCADE
);


ALTER TABLE customertbl ADD CONSTRAINT FK_C_P FOREIGN KEY(code) REFERENCES producttbl(code)
ON DELETE CASCADE;
-- 만약에 위에서 FOREIGN KEY 를 추가하지 않고 만들면 얘도 실행

SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME = 'PRODUCTTBL';
SELECT * FROM ALL_CONS_COLUMNS WHERE TABLE_NAME = 'PRODUCTTBL';

SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME = 'CUSTOMERTBL';
SELECT * FROM ALL_CONS_COLUMNS WHERE TABLE_NAME = 'CUSTOMERTBL';

-- -------------------------------------------------------------------
-- 문제
-- -------------------------------------------------------------------
/*
[tbl_bookstore]

-book_code(PK)
-book_name
-publisher


[tbl_customer]

-id(PK)
-name
-addr


[tbl_order]

-order_id(PK)
-book_code(FK)
-id(FK)
-order_date date
-- ON DELETE CASCADE 설정합니다.
*/

CREATE TABLE tbl_bookstore (
book_code INT PRIMARY KEY,
book_name VARCHAR(20),
publisher VARCHAR(20) 
);

CREATE TABLE tbl_customer (
id VARCHAR2(25) PRIMARY KEY,
name VARCHAR2(20) NOT NULL,
addr VARCHAR2(100)
);

CREATE TABLE tbl_order1 (
order_id INT PRIMARY KEY,
book_code INT,
id VARCHAR2(25),
order_date DATE NOT NULL,
CONSTRAINT FK_O_B FOREIGN KEY(book_code) REFERENCES tbl_bookstore(book_code),
CONSTRAINT FK_O_C FOREIGN KEY(id) REFERENCES tbl_customer(id)
);

-- DATE 는 기본적으로 문자열 형태이고 포매팅이 되어있음.(Ex) 2022-12-21, 이 형식이 아니면 못 넣는다거나 그럼)

SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME = 'TBL_CUSTOMER';
SELECT * FROM ALL_CONS_COLUMNS WHERE TABLE_NAME = 'TBL_CUSTOMER';
SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME = 'TBL_BOOKSTORE';
SELECT * FROM ALL_CONS_COLUMNS WHERE TABLE_NAME = 'TBL_BOOKSTORE';
SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME = 'TBL_ORDER1';
SELECT * FROM ALL_CONS_COLUMNS WHERE TABLE_NAME = 'TBL_ORDER1';

SELECT A.CONSTRAINT_NAME, A.TABLE_NAME, A.CONSTRAINT_TYPE, B.COLUMN_NAME
FROM ALL_CONSTRAINTS A, ALL_CONS_COLUMNS B
WHERE A.CONSTRAINT_NAME = B.CONSTRAINT_NAME AND A.TABLE_NAME = 'TBL_ORDER';

select * from tbl_order;
DESC tbl_order;

-- -----------------------------------------------------------------------------
CREATE TABLE test_05 (
userid CHAR(8) PRIMARY KEY,
name VARCHAR(10) NOT NULL,
email CHAR(30) UNIQUE
);

SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME = 'TEST_05';
SELECT * FROM ALL_CONS_COLUMNS WHERE TABLE_NAME = 'TEST_05';

SELECT A.CONSTRAINT_NAME, A.TABLE_NAME, A.CONSTRAINT_TYPE, B.COLUMN_NAME
FROM ALL_CONSTRAINTS A, ALL_CONS_COLUMNS B
WHERE A.CONSTRAINT_NAME = B.CONSTRAINT_NAME AND A.TABLE_NAME = 'TEST_05';


CREATE TABLE test_06 (
userid CHAR(8) PRIMARY KEY,
name VARCHAR(10) NOT NULL,
email CHAR(30),
CONSTRAINT UK_EMAIL UNIQUE(email)
);

INSERT INTO test_06 VALUES('aaa', '홍길동1', 'example@example');
INSERT INTO test_06 VALUES('bbb', '홍길동2', 'example@example'); -- 중복 허용 x
INSERT INTO test_06(userid, name) VALUES('ccc', '홍길동3'); -- 빈값 허용
SELECT * FROM test_06;

SELECT A.CONSTRAINT_NAME, A.TABLE_NAME, A.CONSTRAINT_TYPE, B.COLUMN_NAME
FROM ALL_CONSTRAINTS A, ALL_CONS_COLUMNS B
WHERE A.CONSTRAINT_NAME = B.CONSTRAINT_NAME AND A.TABLE_NAME = 'TEST_06';



SELECT * FROM usertbl;

-- SELECT CONCAT(mobile1 + mobile2) FROM usertbl;
-- SELECT mobile1 ||'-'|| mobile2 FROM usertbl;
-- 찾아보기


-- CHECK
-- 들어가는 데이터를 제한하거나 값의 범위를 제한하는 제약조건
CREATE TABLE TEST_07 (
userid CHAR(8) PRIMARY KEY,
name VARCHAR(10),
email CHAR(30) UNIQUE,
birthyear INT CHECK(birthyear >= 1900 AND birthyear <= 2025),
phone CHAR(20) UNIQUE,
CONSTRAINT CK_name CHECK(name IS NOT NULL)
);

INSERT INTO TEST_07(userid, name, birthyear) VALUES('a', '홍길동1', 1901);
INSERT INTO TEST_07(userid, name, birthyear) VALUES('b', '홍길동2', 1800); -- 오류
INSERT INTO TEST_07(userid, name, birthyear) VALUES('c', 2000); -- 오류

SELECT * FROM TEST_07;

SELECT A.CONSTRAINT_NAME, A.TABLE_NAME, A.CONSTRAINT_TYPE, B.COLUMN_NAME
FROM ALL_CONSTRAINTS A, ALL_CONS_COLUMNS B
WHERE A.CONSTRAINT_NAME = B.CONSTRAINT_NAME AND A.TABLE_NAME = 'TEST_07';



CREATE TABLE tbl_user AS SELECT * FROM usertbl;
CREATE TABLE tbl_buy AS SELECT * FROM buytbl;

SELECT A.CONSTRAINT_NAME, A.TABLE_NAME, A.CONSTRAINT_TYPE, B.COLUMN_NAME
FROM ALL_CONSTRAINTS A, ALL_CONS_COLUMNS B
WHERE A.CONSTRAINT_NAME = B.CONSTRAINT_NAME AND A.TABLE_NAME = 'USERTBL';

SELECT * FROM tbl_user;
SELECT * FROM tbl_buy;
SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME = 'TBL_USER';
SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME = 'TBL_BUY';
-- 테이블을 복사한다고 해서 PK와 FK가 복사되는건 아님.


-- -----------------------------------------------------------------------------
-- 문제
-- -----------------------------------------------------------------------------

-- tbl_user의 userid 열을 PRIMARY KEY 설정합니다.
ALTER TABLE tbl_user ADD CONSTRAINT PK_Tbl_User PRIMARY KEY(userid);
-- tbl_buy의 userid 열을 tbl_user의 userid을 기본키로 하는 외래키 설정 하세요
ALTER TABLE tbl_buy ADD CONSTRAINT FK_U_B FOREIGN KEY (userid) REFERENCES tbl_user(userid)
ON DELETE CASCADE;
-- tbl_buy의  amount 를 1 - 1000개 사이올 제한합니다. CHECK 제약 조건
ALTER TABLE tbl_buy ADD CONSTRAINT CK_amount CHECK(amount >= 1 AND amount <= 1000);
-- tbl_user 의 birthyear 를 1950 - 2000 으로 제한합니다 CHECK 제약 조건
ALTER TABLE tbl_user ADD CONSTRAINT CK_birthyear CHECK(birthyear BETWEEN 1950 AND 2000);


ALTER TABLE tbl_user DROP CONSTRAINT CK_BIRTHYEAR;
ALTER TABLE tbl_buy DROP CONSTRAINT FK_U_B;
ALTER TABLE tbl_user DROP PRIMARY KEY;


SELECT A.CONSTRAINT_NAME, A.TABLE_NAME, A.CONSTRAINT_TYPE, B.COLUMN_NAME
FROM ALL_CONSTRAINTS A, ALL_CONS_COLUMNS B
WHERE A.CONSTRAINT_NAME = B.CONSTRAINT_NAME AND A.TABLE_NAME = 'TBL_USER';

SELECT A.CONSTRAINT_NAME, A.TABLE_NAME, A.CONSTRAINT_TYPE, B.COLUMN_NAME
FROM ALL_CONSTRAINTS A, ALL_CONS_COLUMNS B
WHERE A.CONSTRAINT_NAME = B.CONSTRAINT_NAME AND A.TABLE_NAME = 'TBL_BUY';


SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME = 'TBL_BUY';
SELECT * FROM ALL_CONS_COLUMNS WHERE TABLE_NAME = 'TBL_BUY';

SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME = 'TBL_USER';
SELECT * FROM ALL_CONS_COLUMNS WHERE TABLE_NAME = 'TBL_USER';


COMMIT;

CREATE TABLE tbl_a (
id INT PRIMARY KEY
);

CREATE TABLE tbl_b (
id INT,
CONSTRAINT FK_A_B FOREIGN KEY(id) REFERENCES tbl_a(id)
);

CREATE TABLE tbl_c (
id INT,
CONSTRAINT FK_A_C FOREIGN KEY(id) REFERENCES tbl_a(id)
);

DROP TABLE tbl_c;
-- FK로 PK를 참조하는 테이블은 삭제가 되는데
DROP TABLE tbl_a;
-- pk는 삭제가 안됨.


-- 제약조건 무시 삭제
DROP TABLE tbl_a CASCADE CONSTRAINTS;
-- ==> 참조했던 A 테이블이 사라지니깐 문제가 생김. 그러니깐 사용하는걸 지양해야함.


DESC test_01;
SELECT * FROM test_01;
ALTER TABLE test_01 MODIFY(name DEFAULT '없음');
INSERT INTO test_01 VALUES('aaa', DEFAULT);
INSERT INTO test_01 VALUES('bbb', DEFAULT);
INSERT INTO test_01 VALUES('ccc', DEFAULT);

SELECT * FROM test_01;
SELECT column_name, data_default FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'TEST_01';
-- 컬럼 값 조회

SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME = 'TEST_01';



