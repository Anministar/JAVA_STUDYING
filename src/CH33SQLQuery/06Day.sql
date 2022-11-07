
-- INNER JOIN

SELECT * FROM usertbl;
SELECT * FROM buytbl;


SELECT *
FROM usertbl
INNER JOIN buytbl
ON usertbl.userid = buytbl.userid;
-- ���Ÿ� ���� ���� '������'�� ������ ����.


SELECT name, mobile1, mobile2, prodname, groupname, amount
FROM usertbl
INNER JOIN buytbl
ON usertbl.userid = buytbl.userid;


SELECT usertbl.userid, name, mobile1, mobile2, prodname, groupname, amount
FROM usertbl
INNER JOIN buytbl
ON usertbl.userid = buytbl.userid;
-- userid�� ���������� �𸣴ϱ� column ambiguously(��ȣ��) defined ��� ������ ��. �׷��� usertbl. �� �ٿ��� ��ø� ���ִ°�.


SELECT U.userid, U.name, U.mobile1, U.mobile2, B.prodname, B.groupname, amount
FROM usertbl U
INNER JOIN buytbl B
ON U.userid = B.userid
WHERE amount >= 5
ORDER BY U.name;


-- ------------------------------------------------------------------------------
-- ����
-- ------------------------------------------------------------------------------
SELECT * FROM usertbl;
SELECT * FROM buytbl;

-- �ٺ�Ŵ�� userid, birthyear, prodname, groupname�� ����ϼ���
SELECT U.userid, U.birthyear, B.prodname, B.groupname
FROM usertbl U
INNER JOIN buytbl B
ON U.userid = B.userid
WHERE U.name = '�ٺ�Ŵ';

-- amount * price ���� 100�̻��� ���� name, addr, prodname, mobile1 - mobile2 �� ����ϼ���
-- (concat() �Լ�����غ��ϴ� - ����Ŭ concat ã�ƺ���)
SELECT U.name, U.addr, B.prodname, CONCAT(CONCAT(U.mobile1, '-'), U.mobile2) AS ��ȭ��ȣ
FROM usertbl U
INNER JOIN buytbl B
ON U.userid = B.userid
WHERE B.amount * B.price >= 100;

SELECT U.name, U.addr, B.prodname, CASE WHEN mobile1 IS NOT NULL THEN mobile1 ||'-'|| mobile2 END CASE
FROM usertbl U
INNER JOIN buytbl B
ON U.userid = B.userid;
-- CASE��
-- CASE WHEN ������ THEN(���̶��) �ڵ� ����


-- groupname�� ������ ���� userid, name, birthyear, prodname�� ����ϼ���
SELECT U.userid, U.name, U.birthyear, B.prodname
FROM usertbl U
INNER JOIN buytbl B
ON U.userid = B.userid
WHERE B.groupname = '����';


-- OUTER JOIN

SELECT *
FROM usertbl U
LEFT OUTER JOIN buytbl B
ON U.userid = B.userid;

-- ������ �������� ���� USER �������� ��ȸ

SELECT *
FROM buytbl B
RIGHT OUTER JOIN usertbl U
ON U.userid = B.userid;

SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME = 'BUYTBL';

ALTER TABLE buytbl DROP CONSTRAINT SYS_C007009;


-- ������ ���̺� JOIN�� �����ϴ�!!!

-- ���Ƹ� �ڵ� �������� 
-- [�л�Tbl]

drop table stdTbl;
drop table clubTbl;
drop table stdclubTbl;
commit;

CREATE TABLE stdTbl(
	stdName CHAR(10) NOT NULL PRIMARY KEY,
	addr CHAR(10) NOT NULL
);
-- [���Ƹ�Tbl]
CREATE TABLE clubTbl(
	clubName CHAR(10) NOT NULL PRIMARY KEY,
	roomNo CHAR(10) NOT NULL
);
-- [�л����Ƹ�Tbl]
CREATE TABLE stdclubTbl(
	num INT PRIMARY KEY,
	stdName CHAR(10) NOT NULL,
	clubName CHAR(10) NOT NULL,
    FOREIGN KEY(stdName) REFERENCES stdtbl(stdName),
	FOREIGN KEY(clubName)REFERENCES clubTbl(clubname)
);
INSERT INTO stdTbl VALUES('�����','�泲');
INSERT INTO stdTbl values('���ð�','����');
INSERT INTO stdTbl values('������','���');
INSERT INTO stdTbl values('������','���');
INSERT INTO stdTbl values('�ٺ�Ŵ','����');

INSERT INTO clubTbl VALUES('����','101ȣ');
INSERT INTO clubTbl VALUES('�ٵ�','102ȣ');
INSERT INTO clubTbl VALUES('�౸','103ȣ');
INSERT INTO clubTbl VALUES('����','104ȣ');

INSERT INTO stdclubTbl VALUES(1,'�����','�ٵ�');
INSERT INTO stdclubTbl VALUES(2,'�����','�౸');
INSERT INTO stdclubTbl VALUES(3,'������','�౸');
INSERT INTO stdclubTbl VALUES(4,'������','�౸');
INSERT INTO stdclubTbl VALUES(5,'������','����');
INSERT INTO stdclubTbl VALUES(6,'�ٺ�Ŵ','����');

select * from stdtbl;
select * from clubtbl;
select * from stdclubtbl;

-- �� �� �� ������ ���̺�
SELECT *
FROM stdtbl S
INNER JOIN stdclubtbl SC
ON S.stdname = SC.stdname;
-- �л��� ����, ���Ƹ��� ������ �л��� ����, but ���ð��� ����.

SELECT *
FROM stdtbl S
INNER JOIN stdclubtbl SC
ON S.stdname = SC.stdname
INNER JOIN clubtbl C
ON SC.clubname = C.clubname;
-- �л��� ����, ���Ƹ� ������ �л��� ����, ������ �л��� Ŭ������

SELECT *
FROM stdtbl S
LEFT OUTER JOIN stdclubtbl SC
ON S.stdname = SC.stdname
LEFT OUTER JOIN clubtbl C
ON SC.clubname = C.clubname;
-- �������� ���� �л��� �������� ��ȸ

SELECT *
FROM stdtbl S
RIGHT OUTER JOIN stdclubtbl SC
ON S.stdname = SC.stdname
RIGHT OUTER JOIN clubtbl C
ON SC.clubname = C.clubname;
-- �ƹ��� �������� ���� Ŭ���� �������� ��ȸ


-- ------------------------------------------------------------------------------
-- ����
-- ------------------------------------------------------------------------------
-- stdname, clubname, roomno, addr �� ����մϴ�.
-- inner join �� ����մϴ�.

SELECT S.stdname, C.clubname, C.roomno, S.addr
FROM stdtbl S
INNER JOIN stdclubtbl SC
ON S.stdname = SC.stdname
INNER JOIN clubtbl C
ON SC.clubname = C.clubname;

-- FULL OUTER JOIN
-- ��� ����ϰ� �������� FULL OUTER JOIN�� ����ϸ� ��.

SELECT *
FROM stdtbl S
FULL OUTER JOIN stdclubtbl SC
ON S.stdname= SC.stdname
FULL OUTER JOIN clubtbl C
ON SC.clubname = C.clubname;

-- CROSS JOIN (MYSQL���� ���), ORACLE������ CROSS JOIN�̶�� ���� �����������.
-- �����;��� �ø��µ� ������ ��.
-- ���̺� ( �Ӽ� 4�� ) --------���̺� ( �Ӽ� 4�� )
-- SELECT �غ��� �� 16���� ����.
CREATE TABLE tmp_01 AS
SELECT U.userid, name, birthyear, prodname, groupname, price, amount
FROM usertbl U, buytbl B;

SELECT * FROM tMp_01;
-- ��ҹ��� ���� X



-- SELF JOIN

SELECT *
FROM usertbl U1, usertbl U2;

CREATE TABLE emptbl (emp CHAR(15), manager CHAR(15), empTel VARCHAR(15));
INSERT INTO emptbl values ('������', null, '0000');
INSERT INTO emptbl values ('�繫����', '������', '1111');
INSERT INTO emptbl values ('�����', '�繫����', '2222');
INSERT INTO emptbl values ('�̺���', '�繫����', '3333');
INSERT INTO emptbl values ('�̴븮', '�����', '4444');
INSERT INTO emptbl values ('���븮', '�̺���', '5555');
INSERT INTO emptbl values ('�����', '�̺���', '6666');
INSERT INTO emptbl values ('�����', '�����', '7777');

SELECT * FROM emptbl;
-- ���� ������ ���ӻ���� ����ó (Self JOin)
-- �����忡 ���� ���ӻ���� ���� ������ null.
SELECT E1.emp AS ������, E1.manager AS ���ӻ��, E2.empTel AS ���ӻ��TEL
FROM emptbl E1 JOIN emptbl E2
ON E1.manager = E2.emp;




-- EQUAL JOIN (= �� ����ϴ� join)
SELECT *
FROM usertbl U, buytbl B
WHERE U.userid = B.userid;

SELECT *
FROM usertbl U
INNER JOIN buytbl B
ON U.userid = B.userid;


-- NON-EQUAL JOIN ( = �̿��� �����ڸ� ����ϴ� JOIN)
SELECT *
FROM usertbl U, buytbl B
WHERE U.userid = B.userid AND B.amount >= 4;

-- NATURAL JOIN
-- ������ �̸��� ���� �÷��� ��� ���ε�
-- ���� ���� ������ ���� ���� ��� INNER JOIN
SELECT * FROM usertbl NATURAL JOIN buytbl;

-- USING
-- ������ �̸��� ���� �÷��� ���ε�.
SELECT * FROM usertbl JOIN buytbl USING (userid);

[INNER JOIN]
SELECT ���̸� FROM ���̺� A INNER JOIN ���̺� B ON ������

[LEFT OUTER JOIN]
SELECT ���̸� FROM ���̺� A LEFT OUTER JOIN ���̺� B ON ������

[RIGHT OUTER JOIN]
SELECT ���̸� FROM ���̺� A RIGHT OUTER JOIN ���̺� B ON ������

[FULL OUTER JOIN]
SELECT ���̸� FROM ���̺� A FULL OUTER JOIN ���̺� B ON ������

[CROSS JOIN]
SELECT * FROM ���̺�A, ���̺�B

[SELF JOIN]
SELECT ���̸� FROM ���̺�A E1 JOIN ���̺�B E2 ON ������

-- ������� �⺻ ���� --
[EQUAL JOIN]

[NON-EQUAL JOIN]

[NATURAL JOIN]
SELECT *
FROM stdtbl
NATURAL JOIN stdclubtbl
NATURAL JOIN clubtbl;

[USING JOIN]
--stdtbl, stdclubtbl, clubtbl;

SELECT *
FROM stdtbl
JOIN stdclubtbl USING (stdname)
JOIN clubtbl USING(clubname);

-- ����Ŭ���� ���ϰ� �� �� �ֵ��� ���ִ� ���ε�.



-- ------------------------------------------------------
SELECT * FROM usertbl;
SELECT * FROM buytbl;

CREATE OR REPLACE VIEW view_01
AS
SELECT U.userid, name, birthyear, prodname, groupname, price, amount
FROM usertbl U
INNER JOIN buytbl B
ON U.userid = B.userid;

SELECT * FROM view_01;


CREATE TABLE a_tbl (
col1 INT PRIMARY KEY,
col2 INT,
col3 INT NOT NULL,
col4 INT
);

-- ���� �ִ°�. ���������� ���� �� ���� �� ����.
-- ���� ���������� �ִٸ� ���������� �������Ѿ� ���� �� ����.

DROP VIEW VIEW_02;

CREATE OR REPLACE VIEW view_01
AS
SELECT col1, col3 FROM a_tbl;

SELECT * FROM view_01;

INSERT INTO view_01 VALUES(10, 20);
INSERT INTO view_01 VALUES(30, 40);
SELECT * FROM view_01;
SELECT * FROM a_tbl;

CREATE OR REPLACE VIEW view_02
AS
SELECT col2, col4 FROM a_tbl;

INSERT INTO view_02 VALUES(11, 21); -- ����
-- COL1, COL3 �� ���� PK�� NOT NULL ���������̱� ������ 2,4���� ���� ���� ���� ����.
-- �׷��� ������ �ߴ°���.
INSERT INTO view_02 VALUES(31, 41); -- ����
SELECT * FROM view_02;
SELECT * FROM a_tbl;

CREATE OR REPLACE VIEW view_01
AS
SELECT col1, col3 FROM a_tbl
WITH READ ONLY;

INSERT INTO view_01 VALUES(7, 9); -- ����, �б� ����
-- -------------------------------------------------------------------
SET serveroutput ON;

BEGIN
    dbms_output.put_line('HELLO WORLD');
END;


DECLARE
    var1 INT:= 10;
    var2 INT:= 20;
BEGIN
    dbms_output.put_line('�� : ' || (var1 + var2));
END;

SELECT * FROM buytbl;
DECLARE
    var1 buytbl.price%TYPE := 100;
    var2 buytbl.amount%TYPE := 200;
BEGIN
    dbms_output.put_line('�� : ' || (var1 + var2));
END;


DECLARE
    var1 buytbl.price%TYPE;
    var2 buytbl.amount%TYPE;
BEGIN
    SELECT price, amount INTO var1, var2 FROM buytbl WHERE price = 1000;
    dbms_output.put_line('var1 : ' || var1 || ' var2 : ' || var2);
END;


SELECT price, amount FROM buytbl WHERE price = 1000;




-- IF

DECLARE
    n INT := 1;
BEGIN
    IF n >= 5 THEN 
        dbms_output.put_line('5���� ŭ');
    ELSIF n >= 3 THEN
        dbms_output.put_line('3���� ŭ');
    ELSE
        dbms_output.put_line('3���� ����');
    end if ;
END;


-- CASE

--DECLARE
--    n INT := 1;
--BEGIN
--    CASE n
--    WHEN ���ǽ� THEN
--        ���ӹ���;
--    WHEN ���ǽ� THEN
--        ���ӹ���;
--    END CASE;
--END;

DECLARE
    n INT := 15;
BEGIN
    CASE
    WHEN n < 10 THEN
        dbms_output.put_line('10���� ����');
    WHEN n < 20 THEN
        dbms_output.put_line('10���� ũ�� 20���ٴ� ����');
    ELSE
        dbms_output.put_line('20���� ŭ');
    END CASE;
END;

SELECT userid, price, amount,
CASE
WHEN amount <= 1 THEN '�Ϲ�'
WHEN amount <= 5 THEN '���'
WHEN amount <= 10 THEN 'VIP'
END CASE
FROM buytbl;

COMMIT;


-- �ݺ��� 

DECLARE
    n INT := 1;
BEGIN
    WHILE(n < 10)
    LOOP
        dbms_output.put_line('n : ' || n);
        n := n + 1;
    END LOOP;
END;


BEGIN
    FOR i IN 1..9
    LOOP
        dbms_output.put_line('i : ' || i);
    END LOOP;
END;



-- for, while 2 x 1 ~ 2 x 9

BEGIN
    FOR i IN 1..9
    LOOP
        dbms_output.put_line('2 x ' || i || ' = ' || 2 * i);
    END LOOP;
END;



-- 1 ����
DECLARE 
    i INT := 100; j INT := 200; hap INT := 0;
    sub INT := 0; mul INT := 0; div INT := 0;
BEGIN
    -- i + j = hap
    hap := i + j;
    sub := i - j;
    mul := i * j;
    div := i / j;
    dbms_output.put_line(i || ' + ' || j || ' = ' || hap);
    -- i - j = sub
    dbms_output.put_line(i || ' - ' || j || ' = ' || sub);
    -- i * j = mul
    dbms_output.put_line(i || ' * ' || j || ' = ' || mul);
    -- i / j = div
    dbms_output.put_line(i || ' / ' || j || ' = ' || div);
END;




-- 2 ����
DROP TABLE test_01 CASCADE CONSTRAINTS;
-- �������� �����ϰ� ���̺� ����
CREATE TABLE test_01 (
    no INT,
    name VARCHAR(20)
);


BEGIN
    -- test_01 ���̺� 1���� 100���� �ݺ��Ͽ� 1 �̸����� / 2 �̸����� / 3 �̸����� ... 100 �̸�����
    -- �� ����� �� �ֵ��� �غ��ϴ�.
    FOR i IN 1..100
    LOOP
        INSERT INTO test_01 VALUES(i, '�̸�����' || i);
    END LOOP;
END;

SELECT * FROM test_01;

-- ------------------------------------------------------------

CREATE TABLE tmp2_tbl AS SELECT userid, birthyear
FROM usertbl WHERE 1 = 2;

-- ���� ����

SELECT * FROM tmp2_tbl;

DESC tmp2_tbl;




DECLARE 
    userid usertbl.userid%TYPE;  -- usertbl�� userid�� TYPE�� �Ȱ��� ����
    birthyear usertbl.birthyear%TYPE;
    CURSOR CUR_01 -- Ŀ�� ����
    IS
    SELECT
    userid,birthyear
    FROM
    usertbl;
BEGIN
    open CUR_01; -- Ŀ�� ����
    LOOP
        FETCH CUR_01 INTO userid, birthyear; -- Ŀ������ ������ ��������
        EXIT when CUR_01 %NOTFOUND; -- Ŀ���� ���� ��� ����
        
        IF birthyear >= 1970 THEN
--            DBMS_OUTPUT.PUT_LINE(userid || ' ' || birthyear);
            INSERT INTO tmp2_tbl VALUES(userid, birthyear);
        END IF;
        
        DBMS_OUTPUT.PUT_LINE(userid || ' ' || birthyear);
    END LOOP;
    CLOSE CUR_01; --Ŀ���ݱ�
END;


SELECT * FROM tmp2_tbl;


-- -----------------------------------------------------------------------------
-- ����
-- -----------------------------------------------------------------------------

-- Ŀ���� ���� price*amount�� 500������ groupname�� prodname�� 
-- tmp3_tbl(prodname,groupname)�� �����ϼ���
-- Ŀ���� : CUR_02
-- tmp3_tbl�� ���� buytbl�� prodname,groupname�� ���̺� ����� ó���մϴ�(������ ����)
SELECT * FROM buytbl;

CREATE TABLE tmp3_tbl AS SELECT prodname, groupname FROM buytbl WHERE 1 = 2;

SELECT * FROM tmp3_tbl;

DECLARE
    price buytbl.price%TYPE;
    amount buytbl.amount%TYPE;
    pdname buytbl.prodname%TYPE;
    gpname buytbl.groupname%TYPE;
    CURSOR CUR_02
    IS
    SELECT 
    price, amount, prodname, groupname
    FROM
    buytbl;
BEGIN
    OPEN CUR_02;
    LOOP
    FETCH CUR_02 INTO price, amount, pdname, gpname;
    EXIT WHEN CUR_02 %NOTFOUND;
    IF (price * amount  <= 500) THEN
        INSERT INTO tmp3_tbl VALUES(pdname, gpname);
    END IF;
    END LOOP;    
    CLOSE CUR_02;
END;

SELECT * FROM tmp3_tbl;

-- ���� 1

--alter table buytbl add grade varchar(25);
--
--select * from buytbl;
--
--declare 
--    n buytbl.num%TYPE;
--    price buytbl.price%TYPE;
--    amount buytbl.amount%TYPE;
--    CURSOR CUR_01
--    IS
--    select 
--    num,price,amount
--    from 
--    buytbl;
--begin
-- open CUR_01;   -- Ŀ������
-- Loop
--    Fetch CUR_01 into n,price,amount;   -- Ŀ������ ������ ��������
--    exit when CUR_01 %NOTFOUND; --Ŀ���� ���� ��� ����
--    
--    if price*amount<=50 then
--        dbms_output.put_line('�Ϲݰ�');
--        update  buytbl set grade='�Ϲݰ�' where num=n;
--    elsif price*amount<=100 then
--        dbms_output.put_line('�����');
--        update  buytbl set grade='�����' where num=n;
--    else
--        dbms_output.put_line('VIP');
--         update  buytbl set grade='VIP' where num=n;
--    end if;
-- end Loop;
-- CLOSE CUR_01;  --Ŀ���ݱ�
--end;
--
--select * from buytbl;







