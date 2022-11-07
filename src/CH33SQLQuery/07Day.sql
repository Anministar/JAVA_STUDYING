-- --------------------------------------------------------------------------------
-- ���ν���
-- --------------------------------------------------------------------------------

-- --------------------------------------------------------------------------------
-- ���ν��� �⺻
-- --------------------------------------------------------------------------------
SET serveroutput ON;

drop procedure Proc01;
create or replace PROCEDURE Proc01
IS
    START_MESSAGE VARCHAR2(100) := '------test_START----------';
    END_MESSAGE VARCHAR2(100) := '-------test_END------------';
BEGIN
    DBMS_OUTPUT.PUT_LINE(START_MESSAGE);
    DBMS_OUTPUT.PUT_LINE(END_MESSAGE);
END;

exec Proc01;


-- --------------------------------
-- ���ν��� +if
-- --------------------------------

drop procedure Proc02;
create or replace PROCEDURE Proc02 
IS
    score number := 90;
    var1 varchar2(10);
    START_MESSAGE VARCHAR2(100) := '------test_START----------';
    END_MESSAGE VARCHAR2(100) := '-------test_END------------';
BEGIN
    DBMS_OUTPUT.PUT_LINE(START_MESSAGE);
    IF (score>=90) then
       var1 :='A';
    Elsif (score>=80) Then
       var1 :='B';
    Elsif (score>=70) Then
        var1 :='C';
    Elsif (score>=60) Then   
        var1 :='D';
    else
       var1 :='E';
    END IF;
    DBMS_OUTPUT.PUT_LINE(var1);
    DBMS_OUTPUT.PUT_LINE(end_message);
END;

exec Proc02 ;


-- --------------------------------
--   ���ν��� + �ݺ���
-- --------------------------------
drop procedure Proc03;
create or replace PROCEDURE Proc03 
IS
    NUM1 NUMBER :=1;
BEGIN
    WHILE(NUM1<10) --NUM�� 10���� ���������� LOOP����
    LOOP
    DBMS_OUTPUT.PUT_LINE(NUM1); --���
    NUM1 := NUM1+1; --NUM = NUM +1
    END LOOP;

END;

exec Proc03;



-- --------------------------------
--  ���ν��� + �Ű����� 
-- --------------------------------
drop procedure Proc04;

create or replace procedure Proc04
(
    s IN number,
    e IN number
)
IS
    num1 number := s;
BEGIN
   
    WHILE(num1<=e) --NUM�� 10���� ���������� LOOP����
    LOOP
    DBMS_OUTPUT.PUT_LINE(num1); --���
    num1 := num1+1;  
    END LOOP;
END;

exec Proc04(5,10);
exec Proc04(7,20);

-- -----------------------------------------------------------------------
-- ����
-- -----------------------------------------------------------------------

-- �ܺηκ��� �����ܼ��� �Է¹޾� �ܼ���ŭ�� ������ ���
-- ���ν����� : googoodan( dan IN number)

CREATE OR REPLACE PROCEDURE googoodan (
    dan IN NUMBER
)
IS
    num NUMBER := 1;
BEGIN
    WHILE(num <= 9)
    LOOP
    DBMS_OUTPUT.PUT_LINE(dan || ' x ' || num || ' =  ' || dan * num);
    num := num +1;
    END LOOP;
END;

EXEC googoodan(2);
EXEC googoodan(6);


-- --------------------------------
--   ���ϰ�
-- --------------------------------

drop procedure Proc07;
create or replace procedure Proc07
(
    s IN number,
    e IN number,
    r OUT number
)
IS
    i number :=s;
    s1 number :=0;
BEGIN   
    WHILE(i<=e) --NUM�� 10���� ���������� LOOP����
    LOOP
        DBMS_OUTPUT.PUT_LINE(i); --���
        s1:=s1 + i;
        i := i + 1;  
    END LOOP;
    
    r := s1;
    commit;
END;


exec proc07(1,10); -- ���� �߻�

-- Ȯ�� 
declare
    r number;
begin
    Proc07(1,10,r);
    DBMS_OUTPUT.PUT_LINE('��� : ' || r);
end;

-- Proc07 ���⼭�� r�� number��� �ڷ����� ���� �ְ� �ƴ϶�, �ּҰ��� �ް� �Ǵ°� (��������ó��)
-- r OUT NUMBER ������ r�� ����������� �����ص� ��.
-- �׷��� r�̶�� �ּҰ��� �޾Ƽ� ������ Proc07���� r�� �ּҰ��� ���޹޾� collbackó���� �ϰԵǰ� �׷��� ó���� ���� ���ϰ� r�� �����.
-- �װ� r�� ��� DMBS_OUTPUTPUT_LINE�� ��ܼ� ��� �Ǵ� ����!
-- �������� �����̶�� ���� ��.

-- ���� �� ���صǱ� ���� ÷���� ���ڸ�,
-- ��� ORACLE�� ���α׷��� �� �ƴϱ� ������, ���α׷��� ���� ó���ϴ� ������� ó���� �� ����
-- ���ø� ���ڸ� �ڹٿ����� ��ü�� �����ϰ� �� �ּҰ��� �ް� �ȴٸ� �ڷ����� Ŭ������������ ���⼭�� �׷� ���α׷��� �� �ƴ϶� ���α׷����� ������ �������� ORACLE���ٰ� �̷� ��ɵ��� �����ߴٰ� ���� ��.
-- �׷��� ��������� DECLARE�� BEGIN, END ������ ���� r������ �����ؼ� PROCEDURE �����ؼ� ������� ������.
-- �̰� �� �����ε� r�̶�� �������� Proc07�� ���ڷ� �ֱ� ���ؼ� r ������ �����ϰ� �� ������ BEGIN �κ��� ���ؼ� ���� r�� ���ϰ��� �޾ƿ��°� �ƴѰ��ϴ� ������ �����.

-- EXEC Proc07(1, 10) ���δ� r�� ���ϰ��� ���� ���� ����.
-- ���������� ���ϰ��� ��� ������ �ѹ� �� DECLARE, BEGIN, END ���� ó���� �ؾ��ϴ� �� ����!!!

-- --------------------------------
-- ����ó�� (�������)
-- --------------------------------
drop procedure Proc05;

create or replace procedure Proc05
(
    num number,
    div number
)
IS 
BEGIN
    
    DBMS_OUTPUT.PUT_LINE(num/div);
    EXCEPTION 
        WHEN ZERO_DIVIDE THEN 
            DBMS_OUTPUT.PUT_LINE('0���� ���� �� �����ϴ�. �⺻�� 0���� ġȯ �մϴ�.');
END;    

exec Proc05(10,4);
exec Proc05(10,0);


-- ����Ŭ �������� ����(https://rongscodinghistory.tistory.com/104)



-- ---------------------------------------------------------------------------
-- Ʈ����
-- ---------------------------------------------------------------------------

-- --------------------------------
-- AFTER Ʈ����(����)
-- --------------------------------

CREATE TABLE backup_user AS SELECT * FROM usertbl WHERE 1 = 2; -- ���� ����
SELECT * FROM backup_user;
ALTER TABLE backup_user ADD type VARCHAR(10) NOT NULL; -- �����̳�, ������ ����ִ� COLUMN
ALTER TABLE backup_user ADD moddate DATE NOT NULL; -- MODIFY DATE�� �� ����, ���� ��¥ COLUMN
SELECT * FROM backup_user;

CREATE OR REPLACE TRIGGER trg_01
AFTER
UPDATE
ON usertbl
FOR EACH ROW
BEGIN
    INSERT INTO backup_user VALUES(:old.userid, :old.name, :old.birthyear, 
    :old.addr, :old.mobile1, :old.mobile2, :old.height, :old.mdate, '����', SYSDATE); -- old���̺� �տ� : �־������. SYSDATE : ����Ŭ���� ���Ǵ� ��¥������ ����.
END;


SELECT * FROM usertbl;
UPDATE usertbl SET addr = '�뱸' WHERE userid = 'LJB';
SELECT * FROM backup_user;

-- --------------------------------
-- AFTER Ʈ����(����)
-- --------------------------------

CREATE OR REPLACE TRIGGER trg_02
AFTER
DELETE
ON usertbl
FOR EACH ROW
BEGIN
    INSERT INTO backup_user VALUES(:old.userid, :old.name, :old.birthyear, 
    :old.addr, :old.mobile1, :old.mobile2, :old.height, :old.mdate, '����', SYSDATE); -- old���̺� �տ� : �־������. SYSDATE : ����Ŭ���� ���Ǵ� ��¥������ ����.
END;

SELECT * FROM usertbl;
DELETE FROM usertbl WHERE userid  = 'EJW';
SELECT * FROM backup_user;



-- --------------------------------
-- AFTER Ʈ����(�߰�)
-- --------------------------------

CREATE OR REPLACE TRIGGER trg_03
AFTER
INSERT
ON usertbl
FOR EACH ROW
BEGIN
    INSERT INTO backup_user VALUES(:new.userid, :new.name, :new.birthyear, 
    :new.addr, :new.mobile1, :new.mobile2, :new.height, :new.mdate, '�߰�', SYSDATE); -- old���̺� �տ� : �־������. SYSDATE : ����Ŭ���� ���Ǵ� ��¥������ ����.
END;


SELECT * FROM usertbl;
INSERT INTO usertbl VALUES('aaa', '����', 1999, '�뱸', '010', '0111111', 177, SYSDATE);
SELECT * FROM backup_user;




-- ON UPDATE CASCADE

-- �ٽ� usertbl�� buytbl�� ���� ����. BCZ OF ��������(������ ����)

DROP TABLE usertbl;
DROP TABLE buytbl;

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

SELECT * FROM usertbl;
SELECT * FROM buytbl;



-- MYSQL������ ON UPDATE CASCADE


CREATE TRIGGER on_Update_trg
AFTER
UPDATE
ON usertbl
FOR EACH ROW
BEGIN
    UPDATE buytbl SET userid = :new.userid WHERE userid = :old.userid;
END;

SELECT * FROM buytbl;
SELECT * FROM usertbl;


UPDATE usertbl SET userid = 'AAA' WHERE userid = 'KBS';
-- usertbl�� ������Ʈ �� �� Ʈ���Ÿ� ����Ͽ� buytbl������ userid�� ������Ʈ�ǵ��� �ϴ� ��.





-- ����Ŭ JDBC ����
DROP TABLE a_tbl;

CREATE TABLE a_tbl (
    no INT PRIMARY KEY,
    name VARCHAR(20),
    addr VARCHAR(100)
);
-- ����, �̸�, �ּ�

CREATE SEQUENCE atbl_seq
        INCREMENT BY 1
        START WITH 1
        MINVALUE 1
        MAXVALUE 9999
        NOCYCLE
        NOCACHE
        NOORDER;
SELECT * FROM a_tbl;


CREATE TABLE tbl_member
(
    no INT PRIMARY KEY,
    email VARCHAR(50) UNIQUE,
    addr VARCHAR(100),
    phone VARCHAR(20)
);
SELECT * FROM tbl_member;


CREATE SEQUENCE member_seq
        INCREMENT BY 1
        START WITH 1
        MINVALUE 1
        MAXVALUE 9999
        NOCYCLE
        NOCACHE
        NOORDER;

