
-- INNER JOIN

SELECT * FROM usertbl;
SELECT * FROM buytbl;


SELECT *
FROM usertbl
INNER JOIN buytbl
ON usertbl.userid = buytbl.userid;
-- 구매를 하지 않은 '윤종신'은 나오지 않음.


SELECT name, mobile1, mobile2, prodname, groupname, amount
FROM usertbl
INNER JOIN buytbl
ON usertbl.userid = buytbl.userid;


SELECT usertbl.userid, name, mobile1, mobile2, prodname, groupname, amount
FROM usertbl
INNER JOIN buytbl
ON usertbl.userid = buytbl.userid;
-- userid가 누구껀지를 모르니깐 column ambiguously(모호한) defined 라고 오류가 뜸. 그래서 usertbl. 을 붙여서 명시를 해주는것.


SELECT U.userid, U.name, U.mobile1, U.mobile2, B.prodname, B.groupname, amount
FROM usertbl U
INNER JOIN buytbl B
ON U.userid = B.userid
WHERE amount >= 5
ORDER BY U.name;


-- ------------------------------------------------------------------------------
-- 문제
-- ------------------------------------------------------------------------------
SELECT * FROM usertbl;
SELECT * FROM buytbl;

-- 바비킴의 userid, birthyear, prodname, groupname을 출력하세요
SELECT U.userid, U.birthyear, B.prodname, B.groupname
FROM usertbl U
INNER JOIN buytbl B
ON U.userid = B.userid
WHERE U.name = '바비킴';

-- amount * price 값이 100이상인 행의 name, addr, prodname, mobile1 - mobile2 를 출력하세요
-- (concat() 함수사용해봅니다 - 오라클 concat 찾아볼것)
SELECT U.name, U.addr, B.prodname, CONCAT(CONCAT(U.mobile1, '-'), U.mobile2) AS 전화번호
FROM usertbl U
INNER JOIN buytbl B
ON U.userid = B.userid
WHERE B.amount * B.price >= 100;

SELECT U.name, U.addr, B.prodname, CASE WHEN mobile1 IS NOT NULL THEN mobile1 ||'-'|| mobile2 END CASE
FROM usertbl U
INNER JOIN buytbl B
ON U.userid = B.userid;
-- CASE문
-- CASE WHEN 조건절 THEN(참이라면) 코드 실행


-- groupname이 전자인 행의 userid, name, birthyear, prodname을 출력하세요
SELECT U.userid, U.name, U.birthyear, B.prodname
FROM usertbl U
INNER JOIN buytbl B
ON U.userid = B.userid
WHERE B.groupname = '전자';


-- OUTER JOIN

SELECT *
FROM usertbl U
LEFT OUTER JOIN buytbl B
ON U.userid = B.userid;

-- 물건을 구매하지 않은 USER 정보까지 조회

SELECT *
FROM buytbl B
RIGHT OUTER JOIN usertbl U
ON U.userid = B.userid;

SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME = 'BUYTBL';

ALTER TABLE buytbl DROP CONSTRAINT SYS_C007009;


-- 세개의 테이블도 JOIN이 가능하다!!!

-- 동아리 코드 가져오기 
-- [학생Tbl]

drop table stdTbl;
drop table clubTbl;
drop table stdclubTbl;
commit;

CREATE TABLE stdTbl(
	stdName CHAR(10) NOT NULL PRIMARY KEY,
	addr CHAR(10) NOT NULL
);
-- [동아리Tbl]
CREATE TABLE clubTbl(
	clubName CHAR(10) NOT NULL PRIMARY KEY,
	roomNo CHAR(10) NOT NULL
);
-- [학생동아리Tbl]
CREATE TABLE stdclubTbl(
	num INT PRIMARY KEY,
	stdName CHAR(10) NOT NULL,
	clubName CHAR(10) NOT NULL,
    FOREIGN KEY(stdName) REFERENCES stdtbl(stdName),
	FOREIGN KEY(clubName)REFERENCES clubTbl(clubname)
);
INSERT INTO stdTbl VALUES('김범수','경남');
INSERT INTO stdTbl values('성시경','서울');
INSERT INTO stdTbl values('조용필','경기');
INSERT INTO stdTbl values('은지원','경북');
INSERT INTO stdTbl values('바비킴','서울');

INSERT INTO clubTbl VALUES('수영','101호');
INSERT INTO clubTbl VALUES('바둑','102호');
INSERT INTO clubTbl VALUES('축구','103호');
INSERT INTO clubTbl VALUES('봉사','104호');

INSERT INTO stdclubTbl VALUES(1,'김범수','바둑');
INSERT INTO stdclubTbl VALUES(2,'김범수','축구');
INSERT INTO stdclubTbl VALUES(3,'조용필','축구');
INSERT INTO stdclubTbl VALUES(4,'은지원','축구');
INSERT INTO stdclubTbl VALUES(5,'은지원','봉사');
INSERT INTO stdclubTbl VALUES(6,'바비킴','봉사');

select * from stdtbl;
select * from clubtbl;
select * from stdclubtbl;

-- 다 대 다 관계형 테이블
SELECT *
FROM stdtbl S
INNER JOIN stdclubtbl SC
ON S.stdname = SC.stdname;
-- 학생의 정보, 동아리에 가입한 학생의 정보, but 성시경은 없음.

SELECT *
FROM stdtbl S
INNER JOIN stdclubtbl SC
ON S.stdname = SC.stdname
INNER JOIN clubtbl C
ON SC.clubname = C.clubname;
-- 학생의 정보, 동아리 가입한 학생의 정보, 가입한 학생의 클럽정보

SELECT *
FROM stdtbl S
LEFT OUTER JOIN stdclubtbl SC
ON S.stdname = SC.stdname
LEFT OUTER JOIN clubtbl C
ON SC.clubname = C.clubname;
-- 가입하지 않은 학생의 정보까지 조회

SELECT *
FROM stdtbl S
RIGHT OUTER JOIN stdclubtbl SC
ON S.stdname = SC.stdname
RIGHT OUTER JOIN clubtbl C
ON SC.clubname = C.clubname;
-- 아무도 가입하지 않은 클럽의 정보까지 조회


-- ------------------------------------------------------------------------------
-- 문제
-- ------------------------------------------------------------------------------
-- stdname, clubname, roomno, addr 을 출력합니다.
-- inner join 을 사용합니다.

SELECT S.stdname, C.clubname, C.roomno, S.addr
FROM stdtbl S
INNER JOIN stdclubtbl SC
ON S.stdname = SC.stdname
INNER JOIN clubtbl C
ON SC.clubname = C.clubname;

-- FULL OUTER JOIN
-- 모두 출력하고 싶을때는 FULL OUTER JOIN을 사용하면 됨.

SELECT *
FROM stdtbl S
FULL OUTER JOIN stdclubtbl SC
ON S.stdname= SC.stdname
FULL OUTER JOIN clubtbl C
ON SC.clubname = C.clubname;

-- CROSS JOIN (MYSQL에서 사용), ORACLE에서는 CROSS JOIN이라는 예약어를 사용하지않음.
-- 데이터양을 늘리는데 목적을 둠.
-- 테이블 ( 속성 4개 ) --------테이블 ( 속성 4개 )
-- SELECT 해보면 총 16개가 나옴.
CREATE TABLE tmp_01 AS
SELECT U.userid, name, birthyear, prodname, groupname, price, amount
FROM usertbl U, buytbl B;

SELECT * FROM tMp_01;
-- 대소문자 구별 X



-- SELF JOIN

SELECT *
FROM usertbl U1, usertbl U2;

CREATE TABLE emptbl (emp CHAR(15), manager CHAR(15), empTel VARCHAR(15));
INSERT INTO emptbl values ('나사장', null, '0000');
INSERT INTO emptbl values ('재무실장', '나사장', '1111');
INSERT INTO emptbl values ('김부장', '재무실장', '2222');
INSERT INTO emptbl values ('이부장', '재무실장', '3333');
INSERT INTO emptbl values ('이대리', '김부장', '4444');
INSERT INTO emptbl values ('정대리', '이부장', '5555');
INSERT INTO emptbl values ('지사원', '이부장', '6666');
INSERT INTO emptbl values ('강사원', '김부장', '7777');

SELECT * FROM emptbl;
-- 부하 직원별 직속상관의 연락처 (Self JOin)
-- 나사장에 대한 직속상관이 없기 때문에 null.
SELECT E1.emp AS 직원명, E1.manager AS 직속상관, E2.empTel AS 직속상관TEL
FROM emptbl E1 JOIN emptbl E2
ON E1.manager = E2.emp;




-- EQUAL JOIN (= 를 사용하는 join)
SELECT *
FROM usertbl U, buytbl B
WHERE U.userid = B.userid;

SELECT *
FROM usertbl U
INNER JOIN buytbl B
ON U.userid = B.userid;


-- NON-EQUAL JOIN ( = 이외의 연산자를 사용하는 JOIN)
SELECT *
FROM usertbl U, buytbl B
WHERE U.userid = B.userid AND B.amount >= 4;

-- NATURAL JOIN
-- 동일한 이름을 갖는 컬럼은 모두 조인됨
-- 동일 열이 있으면 동일 열은 모두 INNER JOIN
SELECT * FROM usertbl NATURAL JOIN buytbl;

-- USING
-- 지정된 이름을 갖는 컬럼만 조인됨.
SELECT * FROM usertbl JOIN buytbl USING (userid);

[INNER JOIN]
SELECT 열이름 FROM 테이블 A INNER JOIN 테이블 B ON 조건절

[LEFT OUTER JOIN]
SELECT 열이름 FROM 테이블 A LEFT OUTER JOIN 테이블 B ON 조건절

[RIGHT OUTER JOIN]
SELECT 열이름 FROM 테이블 A RIGHT OUTER JOIN 테이블 B ON 조건절

[FULL OUTER JOIN]
SELECT 열이름 FROM 테이블 A FULL OUTER JOIN 테이블 B ON 조건절

[CROSS JOIN]
SELECT * FROM 테이블A, 테이블B

[SELF JOIN]
SELECT 열이름 FROM 테이블A E1 JOIN 테이블B E2 ON 조건절

-- 여기까지 기본 조인 --
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

-- 오라클에서 편하게 쓸 수 있도록 해주는 조인들.



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

-- 값을 넣는건. 제약조건이 없을 때 넣을 수 있음.
-- 만약 제약조건이 있다면 제약조건을 만족시켜야 넣을 수 있음.

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

INSERT INTO view_02 VALUES(11, 21); -- 오류
-- COL1, COL3 이 각각 PK와 NOT NULL 제약조건이기 때문에 2,4에만 값을 넣을 수가 없음.
-- 그래서 오류가 뜨는거임.
INSERT INTO view_02 VALUES(31, 41); -- 오류
SELECT * FROM view_02;
SELECT * FROM a_tbl;

CREATE OR REPLACE VIEW view_01
AS
SELECT col1, col3 FROM a_tbl
WITH READ ONLY;

INSERT INTO view_01 VALUES(7, 9); -- 오류, 읽기 전용
-- -------------------------------------------------------------------
SET serveroutput ON;

BEGIN
    dbms_output.put_line('HELLO WORLD');
END;


DECLARE
    var1 INT:= 10;
    var2 INT:= 20;
BEGIN
    dbms_output.put_line('합 : ' || (var1 + var2));
END;

SELECT * FROM buytbl;
DECLARE
    var1 buytbl.price%TYPE := 100;
    var2 buytbl.amount%TYPE := 200;
BEGIN
    dbms_output.put_line('합 : ' || (var1 + var2));
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
        dbms_output.put_line('5보다 큼');
    ELSIF n >= 3 THEN
        dbms_output.put_line('3보다 큼');
    ELSE
        dbms_output.put_line('3보다 작음');
    end if ;
END;


-- CASE

--DECLARE
--    n INT := 1;
--BEGIN
--    CASE n
--    WHEN 조건식 THEN
--        종속문장;
--    WHEN 조건식 THEN
--        종속문장;
--    END CASE;
--END;

DECLARE
    n INT := 15;
BEGIN
    CASE
    WHEN n < 10 THEN
        dbms_output.put_line('10보다 작음');
    WHEN n < 20 THEN
        dbms_output.put_line('10보다 크고 20보다는 작음');
    ELSE
        dbms_output.put_line('20보다 큼');
    END CASE;
END;

SELECT userid, price, amount,
CASE
WHEN amount <= 1 THEN '일반'
WHEN amount <= 5 THEN '우수'
WHEN amount <= 10 THEN 'VIP'
END CASE
FROM buytbl;

COMMIT;


-- 반복문 

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



-- 1 문제
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




-- 2 문제
DROP TABLE test_01 CASCADE CONSTRAINTS;
-- 제약조건 무시하고 테이블 삭제
CREATE TABLE test_01 (
    no INT,
    name VARCHAR(20)
);


BEGIN
    -- test_01 테이블에 1부터 100까지 반복하여 1 이름없음 / 2 이름없음 / 3 이름없음 ... 100 이름없이
    -- 이 저장될 수 있도록 해봅니다.
    FOR i IN 1..100
    LOOP
        INSERT INTO test_01 VALUES(i, '이름없음' || i);
    END LOOP;
END;

SELECT * FROM test_01;

-- ------------------------------------------------------------

CREATE TABLE tmp2_tbl AS SELECT userid, birthyear
FROM usertbl WHERE 1 = 2;

-- 구조 복사

SELECT * FROM tmp2_tbl;

DESC tmp2_tbl;




DECLARE 
    userid usertbl.userid%TYPE;  -- usertbl의 userid와 TYPE을 똑같이 설정
    birthyear usertbl.birthyear%TYPE;
    CURSOR CUR_01 -- 커서 설정
    IS
    SELECT
    userid,birthyear
    FROM
    usertbl;
BEGIN
    open CUR_01; -- 커서 열기
    LOOP
        FETCH CUR_01 INTO userid, birthyear; -- 커서에서 데이터 가져오기
        EXIT when CUR_01 %NOTFOUND; -- 커서가 없을 경우 종료
        
        IF birthyear >= 1970 THEN
--            DBMS_OUTPUT.PUT_LINE(userid || ' ' || birthyear);
            INSERT INTO tmp2_tbl VALUES(userid, birthyear);
        END IF;
        
        DBMS_OUTPUT.PUT_LINE(userid || ' ' || birthyear);
    END LOOP;
    CLOSE CUR_01; --커서닫기
END;


SELECT * FROM tmp2_tbl;


-- -----------------------------------------------------------------------------
-- 문제
-- -----------------------------------------------------------------------------

-- 커서를 만들어서 price*amount가 500이하인 groupname과 prodname을 
-- tmp3_tbl(prodname,groupname)에 저장하세요
-- 커서명 : CUR_02
-- tmp3_tbl의 열은 buytbl의 prodname,groupname을 테이블 복사로 처리합니다(구조만 복사)
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

-- 예시 1

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
-- open CUR_01;   -- 커서열기
-- Loop
--    Fetch CUR_01 into n,price,amount;   -- 커서에서 데이터 가져오기
--    exit when CUR_01 %NOTFOUND; --커서가 없을 경우 종료
--    
--    if price*amount<=50 then
--        dbms_output.put_line('일반고객');
--        update  buytbl set grade='일반고객' where num=n;
--    elsif price*amount<=100 then
--        dbms_output.put_line('우수고객');
--        update  buytbl set grade='우수고객' where num=n;
--    else
--        dbms_output.put_line('VIP');
--         update  buytbl set grade='VIP' where num=n;
--    end if;
-- end Loop;
-- CLOSE CUR_01;  --커서닫기
--end;
--
--select * from buytbl;







