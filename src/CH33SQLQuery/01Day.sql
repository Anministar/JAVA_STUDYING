-- -----------------------
-- DDL
-- -----------------------
-- 1) ���̺� �߰�
CREATE TABLE tmp_tbl (
col1 int primary key,
col2 int,
col3 int
);

SELECT * FROM tmp_tbl;
DESC tmp_tbl;

-- 2) ���߰�
ALTER TABLE tmp_tbl ADD (col4 int);
DESC tmp_tbl;

-- 3) ������(�ڷ���)
ALTER TABLE tmp_tbl MODIFY (col1 varchar(10));
DESC tmp_tbl;

-- 4) ������(�̸�����)
ALTER TABLE tmp_tbl RENAME COLUMN col1 TO column1;
DESC tmp_tbl;

-- 5) ������
ALTER TABLE tmp_tbl DROP COLUMN col2;
DESC tmp_tbl;

-- UserTbl �����
CREATE TABLE userTbl( -- ȸ�����̺�
userID CHAR(8) NOT NULL PRIMARY KEY, -- ����ھ��̵�
name VARCHAR(10) NOT NULL, -- �̸�
birthYear INT NOT NULL, -- ����⵵
addr NCHAR(2) NOT NULL, --����(2���ڸ� �Է�, �泲,����,���..)
mobile1 CHAR(3), -- �޴����� ����(011,016...)
mobile2 CHAR(8), -- �޴����� ������ ��ȭ��ȣ
height SMALLINT, -- Ű
mDate DATE --ȸ��������
);

-- Buytbl �����
CREATE TABLE buyTbl( -- ȸ�� ���� ���̺�
num INT NOT NULL PRIMARY KEY, -- ����(PK) 
userID CHAR(8) NOT NULL, --
prodName CHAR(15) NOT NULL, -- ��ǰ��
groupName CHAR(15), -- �з�
price INT NOT NULL, -- �ܰ�
amount SMALLINT NOT NULL, -- ����
FOREIGN KEY (userID) REFERENCES userTbl(userID)
);

-- Usertbl ������
INSERT INTO userTbl VALUES('LSG','�̽±�',1987,'����','011','1111111',182,'2008-8-8');
INSERT INTO userTbl VALUES('KBS','�����',1979,'�泲','011','2222222',173,'2012-4-4');
INSERT INTO userTbl VALUES('KKH','���ȣ',1971,'����','019','3333333',177,'2007-7-7');
INSERT INTO userTbl VALUES('JYP','������',1950,'���','011','4444444',166,'2009-4-4');
INSERT INTO userTbl VALUES('SSK','���ð�',1979,'����',NULL,NULL,186,'2013-12-12');
INSERT INTO userTbl VALUES('LJB','�����',1963,'����','016','6666666',182,'2009-9-9');
INSERT INTO userTbl VALUES('YJS','������',1969,'�泲',NULL,NULL,170,'2005-5-5');
INSERT INTO userTbl VALUES('EJW','������',1972,'���','011','8888888',174,'2014-3-3');
INSERT INTO userTbl VALUES('JKW','������',1965,'���','018','9999999',172,'2010-10-10');
INSERT INTO userTbl VALUES('BBK','�ٺ�Ŵ',1973,'����','010','0000000',176,'2013-5-5');

select * from usertbl;

-- Buytbl �� ����

INSERT INTO buyTbl VALUES(1,'KBS','�ȭ',NULL,30,2);
INSERT INTO buyTbl VALUES(2,'KBS','��Ʈ��','����',1000,1);
INSERT INTO buyTbl VALUES(3,'JYP','�����','����',200,1);
INSERT INTO buyTbl VALUES(4,'BBK','�����','����',200,5);
INSERT INTO buyTbl VALUES(5,'KBS','û����','�Ƿ�',50,3);
INSERT INTO buyTbl VALUES(6,'BBK','�޸�','����',80,10);
INSERT INTO buyTbl VALUES(7,'SSK','å','����',15,5);
INSERT INTO buyTbl VALUES(8,'EJW','å','����',15,2);
INSERT INTO buyTbl VALUES(9,'EJW','û����','�Ƿ�',50,1);
INSERT INTO buyTbl VALUES(10,'BBK','�ȭ',NULL,30,2);
INSERT INTO buyTbl VALUES(11,'EJW','å','����',15,1);
INSERT INTO buyTbl VALUES(12,'BBK','�ȭ',NULL,30,2);


SELECT * FROM buytbl;
SELECT * FROM usertbl;

-- -------------------------------------------
-- SELECT ���̸�,���̸� FROM ���̺��;
SELECT * FROM usertbl;
SELECT * FROM usertbl WHERE NAME ='���ȣ';

SELECT * FROM usertbl WHERE birthyear >= 1970 AND height >= 180;
SELECT * FROM usertbl WHERE birthyear BETWEEN 1970 AND 1980;
SELECT * FROM usertbl WHERE birthyear >= 1970 AND birthyear <=1980;

SELECT * FROM usertbl WHERE birthyear >= 1970 OR height >= 180;

SELECT name, height, addr FROM usertbl WHERE addr IN('�泲', '����', '���');

SELECT * FROM usertbl WHERE name LIKE '��%';
-- %�� �������Ѿ��� ��� ���ڸ� ����.
SELECT * FROM usertbl WHERE name LIKE '%��';
SELECT * FROM usertbl WHERE name LIKE '��__';
-- _�� ���������ִ� ��� ����
SELECT * FROM usertbl WHERE name LIKE '%��%';
-- �� ���� �յڷ� ���ڰ� �־ �ǰ� ��� �ǰ�.



-- -------------------------------------------------------
-- ����
-- -------------------------------------------------------

SELECT * FROM buyTbl;
-- 1���ž�(amount)�� 5�� �̻��� ���� ���
SELECT * FROM buyTbl WHERE amount >= 5;

-- 2������(price) 50�̻� 500 ������ ���� UserID�� prodName�� ���
SELECT * FROM buyTbl WHERE price BETWEEN 50 AND 500;

-- 3���ž�(amount)�� 10 �̻�  �̰ų� ������ 100 �̻��� �� ���
SELECT * FROM buyTbl WHERE amount >= 10 OR price >= 100;

-- 4UserID �� K�� �����ϴ� �� ���S
SELECT * FROM buyTbl WHERE UserID LIKE 'K%';

-- 5'����' �̰ų� '����'�� �� ���
SELECT * FROM buyTbl WHERE groupname = '����' OR groupname = '����';
SELECT * FROM buyTbl WHERE groupname IN ('����', '����');
-- �Ȱ��� ��� ���

-- 6��ǰ(prodName)�� å�̰ų� userID�� W�� ������ �����
SELECT * FROM buyTbl WHERE prodName = 'å' OR UserID LIKE '%W';
SELECT * FROM tbl_pump;

SELECT * FROM tbl_pump WHERE �����������ּ� LIKE '%�Ϻ��%';

-- ----------------------------------------------------------
-- ��������
-- ----------------------------------------------------------

-- ���ȣ ���� ū Ű��� ��� ���
-- SELECT * FROM usertbl WHERE height >= (���ȣ�� Ű);
SELECT * FROM usertbl WHERE height > (SELECT height FROM usertbl WHERE name = '���ȣ') AND name <> '���ȣ';

-- ��������� ���̰� ���� ����� ���
SELECT * FROM usertbl;
-- SELECT * FROM usertbl WHERE birthyear > (������� ����);
SELECT * FROM usertbl WHERE birthyear > (SELECT birthyear FROM usertbl WHERE name = '�����');

-- �泲 ������ Ű���� ū ���� ���
SELECT * FROM usertbl WHERE height > ANY(SELECT height FROM usertbl WHERE addr = '�泲');
-- �泲 ������ ��� ������� Ű�� 170, 173 �ΰ��� �ִµ� ����� �������� ��Ƽ� �������� ��. ==> �׷��� ���� �߻�
-- ANY�� 170, 173 ����� ������� �ʰ� �� ��� �׷��� 172�� ����� ��.
SELECT * FROM usertbl WHERE height > ALL(SELECT height FROM usertbl WHERE addr = '�泲');
-- ALL�� 170���ٵ� Ŀ���ϰ� 173���ٵ� Ŀ���� �׷��� �ᱸ 173���� Ŀ���Ѵٴ� �ǹ�.



-- -------------------------------------------------------
-- ����
-- -------------------------------------------------------
SELECT * FROM buyTbl;

-- 1)amount�� 10�� ���� price���� ū ���� ����ϼ��� (��������)
SELECT * FROM buyTbl WHERE price > (SELECT price FROM buyTbl WHERE amount = '10');

-- 2)UserID�� K�� �����ϴ� ���� amount ���� ū ���� ����ϼ��� (�������� + ANY)
SELECT * FROM buyTbl WHERE amount > ANY(SELECT amount FROM buyTbl WHERE userid LIKE 'K%');

-- 3)amount�� 5�� ���� price���� ū ���� ����ϼ��� (�������� + ALL)
SELECT * FROM buyTbl WHERE price > ALL(SELECT price FROM buyTbl WHERE amount = 5);


-- ----------------------------------------------------------
-- ���� (ORDER BY)
-- ----------------------------------------------------------


SELECT * FROM usertbl ORDER BY mdate;
-- �������� �⺻
SELECT * FROM usertbl ORDER BY mdate DESC;
-- DESC ��������

SELECT * FROM usertbl ORDER BY birthyear ASC, name DESC;
SELECT addr FROM usertbl;


SELECT distinct addr FROM usertbl ORDER BY addr;
-- distinct : �ߺ��� �� ����

SELECT rownum as RN, * FROM usertbl;
-- rownum�� RN���� �ٲ��༭ ��ȸ����. SELECT �ϸ鼭 ���� �߰����شٴ� �ǹ�( AS )

SELECT * FROM (SELECT rownum AS RN,  usertbl.* FROM usertbl);
--              ��RN�� ���Ե� usertbl
SELECT * FROM (SELECT rownum AS RN, usertbl.* FROM usertbl) WHERE RN >= 2 AND RN <= 4;

-- ���̺� ���� + ������
CREATE TABLE buytbl2 AS SELECT * FROM buytbl;
-- SELECT������� �������� buytbl2 ���̺��� �����Ѵٴ� �ǹ� (����)
SELECT * FROM buytbl2;
DESC buytbl2;

-- ������
CREATE TABLE buytbl3 AS SELECT * FROM buytbl WHERE 1 = 2;
-- false ���� �߰��ϸ�, ������ �Ȱ��� ���簡 ��. ���� ���� X
SELECT * FROM buytbl3;
DESC buytbl3;

INSERT INTO buytbl3 SELECT * FROM buytbl;
SELECT * FROM buytbl3;

-- -------------------------------------------------------
-- ����
-- -------------------------------------------------------
SELECT * FROM buyTbl;
-- 1)UserID ������ �������� ����
SELECT * FROM buyTbl ORDER BY UserID;
-- 2)price ������ �������� ����
SELECT * FROM buyTbl ORDER BY price DESC;
-- 3)amount ������ �������� prodName���� ������������
SELECT * FROM buyTbl ORDER BY amount ASC, prodName DESC;
-- 4)prodName�� ������������ ���� �� �ߺ� ����
SELECT distinct prodname FROM buyTbl ORDER BY prodname ASC;
-- 5)userID���� �˻� �� �ߺ��� ���̵������ϰ� SELECT
SELECT DISTINCT UserID FROM buyTbl;
-- 6)���ž�(amount)�� 3�̻��� ���� prodName ������������ ����
SELECT * FROM buyTbl WHERE amount >= 3 ORDER BY prodname DESC;
-- 7)usertbl�� addr �� ����, ����� ������ CUsertbl�� ����
CREATE TABLE CUsertbl AS SELECT * FROM usertbl WHERE addr IN ('����', '���');
SELECT * FROM usertbl;
SELECT * FROM CUsertbl;




