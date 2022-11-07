SELECT * FROM buytbl;


-- 4)���� ���߿� �׷������ �ִ� �ุ ���
SELECT * FROM buytbl WHERE groupname != 'null';

-- ����� �ش�
SELECT * FROM buytbl WHERE groupname <> 'null';
SELECT * FROM buytbl WHERE groupname is not null;

-- 5)prodName ���� ������ ���غ����� (ROLLUP���)
SELECT prodName, SUM(price * amount) FROM buytbl GROUP BY ROLLUP(prodName);

SELECT prodname, SUM(amount) FROM buytbl GROUP BY ROLLUP(prodname);
SELECT num, prodname, SUM(amount) FROM buytbl GROUP BY ROLLUP(prodname, num);
-- ���հ�� PRIMARY KEY�� �̿������ν� ���Ѵ�.

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
-- developer�� ������ü�� ������ �ִٰ� �Ǵ��ϴµ� START WITH 1 �� �κ���. �ٵ� ��� �̾�پ�� ������ �ȵ�. �׳� �߸� ����ִ°�, �� ����.

INSERT INTO tmp_tbl VALUES (tmp_seq.NEXTVAL, 'aaa', 11);
INSERT INTO tmp_tbl VALUES (tmp_seq.NEXTVAL, 'aab', 11);
INSERT INTO tmp_tbl VALUES (tmp_seq.NEXTVAL, 'aac', 11);
INSERT INTO tmp_tbl VALUES (tmp_seq.NEXTVAL, 'aad', 11);
-- NEXTVAL == ���� ��

SELECT * FROM tmp_tbl;

SELECT tmp_seq.CURRVAL FROM dual;
-- dual�̶�� ���̺��� ����Ŭ ��ü���� �����Ǵ� ���̺���. ���� ����� ������ ��.


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
-- ��� CONSTRAINTS �߿� TEST_01 ���̺��� ���������� �����޶�.
-- ��ȸ�غ��� CONSTRAINT_TYPE �� �ִµ� C == NOT NULL, P == PRIMARY KEY
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
-- ALL_CONSTRAINTS�� ALL_CONS_COLUMNS�� ���� �������� �� �빮�ڸ� ����ؾ���.

ALTER TABLE tbl_order DROP CONSTRAINT FK_ORDER_PROD;
SELECT * FROM ALL_CONSTRAINS WHERE TABLE_NAME = 'TBL_ORDER';

ALTER TABLE tbl_order ADD CONSTRAINT FK_O_P FOREIGN KEY(prod_id) REFERENCES tbl_prod(prod_id)
    ON DELETE CASCADE;  -- ����Ŭ������ On update cascade �������� �ʴ´�. Ʈ���� ������ ���� ������ ��� ����

SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME = 'TBL_ORDER';

-- -------------------------------------------------------------------
-- ����
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
-- ���࿡ ������ FOREIGN KEY �� �߰����� �ʰ� ����� �굵 ����

SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME = 'PRODUCTTBL';
SELECT * FROM ALL_CONS_COLUMNS WHERE TABLE_NAME = 'PRODUCTTBL';

SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME = 'CUSTOMERTBL';
SELECT * FROM ALL_CONS_COLUMNS WHERE TABLE_NAME = 'CUSTOMERTBL';

-- -------------------------------------------------------------------
-- ����
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
-- ON DELETE CASCADE �����մϴ�.
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

-- DATE �� �⺻������ ���ڿ� �����̰� �������� �Ǿ�����.(Ex) 2022-12-21, �� ������ �ƴϸ� �� �ִ´ٰų� �׷�)

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

INSERT INTO test_06 VALUES('aaa', 'ȫ�浿1', 'example@example');
INSERT INTO test_06 VALUES('bbb', 'ȫ�浿2', 'example@example'); -- �ߺ� ��� x
INSERT INTO test_06(userid, name) VALUES('ccc', 'ȫ�浿3'); -- �� ���
SELECT * FROM test_06;

SELECT A.CONSTRAINT_NAME, A.TABLE_NAME, A.CONSTRAINT_TYPE, B.COLUMN_NAME
FROM ALL_CONSTRAINTS A, ALL_CONS_COLUMNS B
WHERE A.CONSTRAINT_NAME = B.CONSTRAINT_NAME AND A.TABLE_NAME = 'TEST_06';



SELECT * FROM usertbl;

-- SELECT CONCAT(mobile1 + mobile2) FROM usertbl;
-- SELECT mobile1 ||'-'|| mobile2 FROM usertbl;
-- ã�ƺ���


-- CHECK
-- ���� �����͸� �����ϰų� ���� ������ �����ϴ� ��������
CREATE TABLE TEST_07 (
userid CHAR(8) PRIMARY KEY,
name VARCHAR(10),
email CHAR(30) UNIQUE,
birthyear INT CHECK(birthyear >= 1900 AND birthyear <= 2025),
phone CHAR(20) UNIQUE,
CONSTRAINT CK_name CHECK(name IS NOT NULL)
);

INSERT INTO TEST_07(userid, name, birthyear) VALUES('a', 'ȫ�浿1', 1901);
INSERT INTO TEST_07(userid, name, birthyear) VALUES('b', 'ȫ�浿2', 1800); -- ����
INSERT INTO TEST_07(userid, name, birthyear) VALUES('c', 2000); -- ����

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
-- ���̺��� �����Ѵٰ� �ؼ� PK�� FK�� ����Ǵ°� �ƴ�.


-- -----------------------------------------------------------------------------
-- ����
-- -----------------------------------------------------------------------------

-- tbl_user�� userid ���� PRIMARY KEY �����մϴ�.
ALTER TABLE tbl_user ADD CONSTRAINT PK_Tbl_User PRIMARY KEY(userid);
-- tbl_buy�� userid ���� tbl_user�� userid�� �⺻Ű�� �ϴ� �ܷ�Ű ���� �ϼ���
ALTER TABLE tbl_buy ADD CONSTRAINT FK_U_B FOREIGN KEY (userid) REFERENCES tbl_user(userid)
ON DELETE CASCADE;
-- tbl_buy��  amount �� 1 - 1000�� ���̿� �����մϴ�. CHECK ���� ����
ALTER TABLE tbl_buy ADD CONSTRAINT CK_amount CHECK(amount >= 1 AND amount <= 1000);
-- tbl_user �� birthyear �� 1950 - 2000 ���� �����մϴ� CHECK ���� ����
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
-- FK�� PK�� �����ϴ� ���̺��� ������ �Ǵµ�
DROP TABLE tbl_a;
-- pk�� ������ �ȵ�.


-- �������� ���� ����
DROP TABLE tbl_a CASCADE CONSTRAINTS;
-- ==> �����ߴ� A ���̺��� ������ϱ� ������ ����. �׷��ϱ� ����ϴ°� �����ؾ���.


DESC test_01;
SELECT * FROM test_01;
ALTER TABLE test_01 MODIFY(name DEFAULT '����');
INSERT INTO test_01 VALUES('aaa', DEFAULT);
INSERT INTO test_01 VALUES('bbb', DEFAULT);
INSERT INTO test_01 VALUES('ccc', DEFAULT);

SELECT * FROM test_01;
SELECT column_name, data_default FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'TEST_01';
-- �÷� �� ��ȸ

SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME = 'TEST_01';



