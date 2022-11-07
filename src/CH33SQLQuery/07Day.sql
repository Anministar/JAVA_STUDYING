-- --------------------------------------------------------------------------------
-- 프로시저
-- --------------------------------------------------------------------------------

-- --------------------------------------------------------------------------------
-- 프로시저 기본
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
-- 프로시저 +if
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
--   프로시저 + 반복문
-- --------------------------------
drop procedure Proc03;
create or replace PROCEDURE Proc03 
IS
    NUM1 NUMBER :=1;
BEGIN
    WHILE(NUM1<10) --NUM이 10보다 작을때까지 LOOP실행
    LOOP
    DBMS_OUTPUT.PUT_LINE(NUM1); --출력
    NUM1 := NUM1+1; --NUM = NUM +1
    END LOOP;

END;

exec Proc03;



-- --------------------------------
--  프로시저 + 매개변수 
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
   
    WHILE(num1<=e) --NUM이 10보다 작을때까지 LOOP실행
    LOOP
    DBMS_OUTPUT.PUT_LINE(num1); --출력
    num1 := num1+1;  
    END LOOP;
END;

exec Proc04(5,10);
exec Proc04(7,20);

-- -----------------------------------------------------------------------
-- 문제
-- -----------------------------------------------------------------------

-- 외부로부터 구구단수를 입력받아 단수만큼의 구구단 출력
-- 프로시저명 : googoodan( dan IN number)

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
--   리턴값
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
    WHILE(i<=e) --NUM이 10보다 작을때까지 LOOP실행
    LOOP
        DBMS_OUTPUT.PUT_LINE(i); --출력
        s1:=s1 + i;
        i := i + 1;  
    END LOOP;
    
    r := s1;
    commit;
END;


exec proc07(1,10); -- 오류 발생

-- 확인 
declare
    r number;
begin
    Proc07(1,10,r);
    DBMS_OUTPUT.PUT_LINE('결과 : ' || r);
end;

-- Proc07 여기서의 r은 number라는 자료형을 가진 애가 아니라, 주소값을 받게 되는것 (참조변수처럼)
-- r OUT NUMBER 에서의 r은 참조변수라고 생각해도 됨.
-- 그래서 r이라는 주소값을 받아서 위에서 Proc07에서 r의 주소값을 전달받아 collback처리를 하게되고 그렇게 처리된 값이 리턴값 r에 저장됨.
-- 그게 r에 담겨 DMBS_OUTPUTPUT_LINE에 담겨서 출력 되는 형태!
-- 포인터의 개념이라고 보면 됨.

-- 조금 더 이해되기 쉽게 첨언을 하자면,
-- 사실 ORACLE은 프로그래밍 언어가 아니기 때문에, 프로그래밍 언어에서 처리하는 방식으로 처리할 수 없음
-- 예시를 들자면 자바에서는 객체를 형성하고 그 주소값을 받게 된다면 자료형이 클래스형이지만 여기서는 그런 프로그래밍 언어가 아니라 프로그래밍의 절차를 만들어내려고 ORACLE에다가 이런 기능들을 가미했다고 보면 됨.
-- 그래서 결론적으로 DECLARE과 BEGIN, END 로직을 통해 r변수를 선언해서 PROCEDURE 실행해서 결과값을 봐야함.
-- 이건 내 생각인데 r이라는 변수값을 Proc07의 인자로 주기 위해서 r 변수를 선언하고 그 이후의 BEGIN 부분을 통해서 얻은 r의 리턴값을 받아오는게 아닌가하는 생각이 들었음.

-- EXEC Proc07(1, 10) 으로는 r의 리턴값을 얻을 수가 없음.
-- 최종적으로 리턴값을 얻고 싶으면 한번 더 DECLARE, BEGIN, END 로직 처리를 해야하는 것 같음!!!

-- --------------------------------
-- 예외처리 (산술예외)
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
            DBMS_OUTPUT.PUT_LINE('0으로 나눌 수 없습니다. 기본앖 0으로 치환 합니다.');
END;    

exec Proc05(10,4);
exec Proc05(10,0);


-- 오라클 예외종류 참고(https://rongscodinghistory.tistory.com/104)



-- ---------------------------------------------------------------------------
-- 트리거
-- ---------------------------------------------------------------------------

-- --------------------------------
-- AFTER 트리거(수정)
-- --------------------------------

CREATE TABLE backup_user AS SELECT * FROM usertbl WHERE 1 = 2; -- 구조 복사
SELECT * FROM backup_user;
ALTER TABLE backup_user ADD type VARCHAR(10) NOT NULL; -- 수정이냐, 삭제냐 담아주는 COLUMN
ALTER TABLE backup_user ADD moddate DATE NOT NULL; -- MODIFY DATE인 것 같음, 수정 날짜 COLUMN
SELECT * FROM backup_user;

CREATE OR REPLACE TRIGGER trg_01
AFTER
UPDATE
ON usertbl
FOR EACH ROW
BEGIN
    INSERT INTO backup_user VALUES(:old.userid, :old.name, :old.birthyear, 
    :old.addr, :old.mobile1, :old.mobile2, :old.height, :old.mdate, '수정', SYSDATE); -- old테이블 앞에 : 넣어줘야함. SYSDATE : 오라클에서 사용되는 날짜정보를 가짐.
END;


SELECT * FROM usertbl;
UPDATE usertbl SET addr = '대구' WHERE userid = 'LJB';
SELECT * FROM backup_user;

-- --------------------------------
-- AFTER 트리거(삭제)
-- --------------------------------

CREATE OR REPLACE TRIGGER trg_02
AFTER
DELETE
ON usertbl
FOR EACH ROW
BEGIN
    INSERT INTO backup_user VALUES(:old.userid, :old.name, :old.birthyear, 
    :old.addr, :old.mobile1, :old.mobile2, :old.height, :old.mdate, '삭제', SYSDATE); -- old테이블 앞에 : 넣어줘야함. SYSDATE : 오라클에서 사용되는 날짜정보를 가짐.
END;

SELECT * FROM usertbl;
DELETE FROM usertbl WHERE userid  = 'EJW';
SELECT * FROM backup_user;



-- --------------------------------
-- AFTER 트리거(추가)
-- --------------------------------

CREATE OR REPLACE TRIGGER trg_03
AFTER
INSERT
ON usertbl
FOR EACH ROW
BEGIN
    INSERT INTO backup_user VALUES(:new.userid, :new.name, :new.birthyear, 
    :new.addr, :new.mobile1, :new.mobile2, :new.height, :new.mdate, '추가', SYSDATE); -- old테이블 앞에 : 넣어줘야함. SYSDATE : 오라클에서 사용되는 날짜정보를 가짐.
END;


SELECT * FROM usertbl;
INSERT INTO usertbl VALUES('aaa', '에이', 1999, '대구', '010', '0111111', 177, SYSDATE);
SELECT * FROM backup_user;




-- ON UPDATE CASCADE

-- 다시 usertbl과 buytbl을 새로 만듦. BCZ OF 제약조건(이전에 없앰)

DROP TABLE usertbl;
DROP TABLE buytbl;

-- UserTbl 만들기
CREATE TABLE userTbl( -- 회원테이블
userID CHAR(8) NOT NULL PRIMARY KEY, -- 사용자아이디
name VARCHAR(10) NOT NULL, -- 이름
birthYear INT NOT NULL, -- 출생년도
addr NCHAR(2) NOT NULL, --지역(2글자만 입력, 경남,서울,경기..)
mobile1 CHAR(3), -- 휴대폰의 국번(011,016...)
mobile2 CHAR(8), -- 휴대폰의 나머지 전화번호
height SMALLINT, -- 키
mDate DATE --회원가입일
);

-- Buytbl 만들기
CREATE TABLE buyTbl( -- 회원 구매 테이블
num INT NOT NULL PRIMARY KEY, -- 순번(PK) 
userID CHAR(8) NOT NULL, --
prodName CHAR(15) NOT NULL, -- 물품명
groupName CHAR(15), -- 분류
price INT NOT NULL, -- 단가
amount SMALLINT NOT NULL, -- 수량
FOREIGN KEY (userID) REFERENCES userTbl(userID)
);

-- Usertbl 값삽입
INSERT INTO userTbl VALUES('LSG','이승기',1987,'서울','011','1111111',182,'2008-8-8');
INSERT INTO userTbl VALUES('KBS','김범수',1979,'경남','011','2222222',173,'2012-4-4');
INSERT INTO userTbl VALUES('KKH','김경호',1971,'전남','019','3333333',177,'2007-7-7');
INSERT INTO userTbl VALUES('JYP','조용필',1950,'경기','011','4444444',166,'2009-4-4');
INSERT INTO userTbl VALUES('SSK','성시경',1979,'서울',NULL,NULL,186,'2013-12-12');
INSERT INTO userTbl VALUES('LJB','임재범',1963,'서울','016','6666666',182,'2009-9-9');
INSERT INTO userTbl VALUES('YJS','윤종신',1969,'경남',NULL,NULL,170,'2005-5-5');
INSERT INTO userTbl VALUES('EJW','은지원',1972,'경북','011','8888888',174,'2014-3-3');
INSERT INTO userTbl VALUES('JKW','조관우',1965,'경기','018','9999999',172,'2010-10-10');
INSERT INTO userTbl VALUES('BBK','바비킴',1973,'서울','010','0000000',176,'2013-5-5');

select * from usertbl;

-- Buytbl 값 삽입

INSERT INTO buyTbl VALUES(1,'KBS','운동화',NULL,30,2);
INSERT INTO buyTbl VALUES(2,'KBS','노트북','전자',1000,1);
INSERT INTO buyTbl VALUES(3,'JYP','모니터','전자',200,1);
INSERT INTO buyTbl VALUES(4,'BBK','모니터','전자',200,5);
INSERT INTO buyTbl VALUES(5,'KBS','청바지','의류',50,3);
INSERT INTO buyTbl VALUES(6,'BBK','메모리','전자',80,10);
INSERT INTO buyTbl VALUES(7,'SSK','책','서적',15,5);
INSERT INTO buyTbl VALUES(8,'EJW','책','서적',15,2);
INSERT INTO buyTbl VALUES(9,'EJW','청바지','의류',50,1);
INSERT INTO buyTbl VALUES(10,'BBK','운동화',NULL,30,2);
INSERT INTO buyTbl VALUES(11,'EJW','책','서적',15,1);
INSERT INTO buyTbl VALUES(12,'BBK','운동화',NULL,30,2);

SELECT * FROM usertbl;
SELECT * FROM buytbl;



-- MYSQL에서의 ON UPDATE CASCADE


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
-- usertbl이 업데이트 될 때 트리거를 사용하여 buytbl에서도 userid가 업데이트되도록 하는 것.





-- 오라클 JDBC 연결
DROP TABLE a_tbl;

CREATE TABLE a_tbl (
    no INT PRIMARY KEY,
    name VARCHAR(20),
    addr VARCHAR(100)
);
-- 순번, 이름, 주소

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

