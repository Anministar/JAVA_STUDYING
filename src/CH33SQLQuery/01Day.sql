-- -----------------------
-- DDL
-- -----------------------
-- 1) 테이블 추가
CREATE TABLE tmp_tbl (
col1 int primary key,
col2 int,
col3 int
);

SELECT * FROM tmp_tbl;
DESC tmp_tbl;

-- 2) 열추가
ALTER TABLE tmp_tbl ADD (col4 int);
DESC tmp_tbl;

-- 3) 열변경(자료형)
ALTER TABLE tmp_tbl MODIFY (col1 varchar(10));
DESC tmp_tbl;

-- 4) 열변경(이름변경)
ALTER TABLE tmp_tbl RENAME COLUMN col1 TO column1;
DESC tmp_tbl;

-- 5) 열삭제
ALTER TABLE tmp_tbl DROP COLUMN col2;
DESC tmp_tbl;

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


SELECT * FROM buytbl;
SELECT * FROM usertbl;

-- -------------------------------------------
-- SELECT 열이름,열이름 FROM 테이블명;
SELECT * FROM usertbl;
SELECT * FROM usertbl WHERE NAME ='김경호';

SELECT * FROM usertbl WHERE birthyear >= 1970 AND height >= 180;
SELECT * FROM usertbl WHERE birthyear BETWEEN 1970 AND 1980;
SELECT * FROM usertbl WHERE birthyear >= 1970 AND birthyear <=1980;

SELECT * FROM usertbl WHERE birthyear >= 1970 OR height >= 180;

SELECT name, height, addr FROM usertbl WHERE addr IN('경남', '전남', '경북');

SELECT * FROM usertbl WHERE name LIKE '김%';
-- %는 길이제한없는 모든 문자를 말함.
SELECT * FROM usertbl WHERE name LIKE '%기';
SELECT * FROM usertbl WHERE name LIKE '김__';
-- _는 길이제한있는 모든 문자
SELECT * FROM usertbl WHERE name LIKE '%김%';
-- 김 기준 앞뒤로 문자가 있어도 되고 없어도 되고.



-- -------------------------------------------------------
-- 문제
-- -------------------------------------------------------

SELECT * FROM buyTbl;
-- 1구매양(amount)가 5개 이상인 행을 출력
SELECT * FROM buyTbl WHERE amount >= 5;

-- 2가격이(price) 50이상 500 이하인 행의 UserID와 prodName만 출력
SELECT * FROM buyTbl WHERE price BETWEEN 50 AND 500;

-- 3구매양(amount)이 10 이상  이거나 가격이 100 이상인 행 출력
SELECT * FROM buyTbl WHERE amount >= 10 OR price >= 100;

-- 4UserID 가 K로 시작하는 행 출력S
SELECT * FROM buyTbl WHERE UserID LIKE 'K%';

-- 5'서적' 이거나 '전자'인 행 출력
SELECT * FROM buyTbl WHERE groupname = '서적' OR groupname = '전자';
SELECT * FROM buyTbl WHERE groupname IN ('서적', '전자');
-- 똑같은 결과 출력

-- 6상품(prodName)이 책이거나 userID가 W로 끝나는 행출력
SELECT * FROM buyTbl WHERE prodName = '책' OR UserID LIKE '%W';
SELECT * FROM tbl_pump;

SELECT * FROM tbl_pump WHERE 소재지지번주소 LIKE '%하빈면%';

-- ----------------------------------------------------------
-- 서브쿼리
-- ----------------------------------------------------------

-- 김경호 보다 큰 키라면 모두 출력
-- SELECT * FROM usertbl WHERE height >= (김경호의 키);
SELECT * FROM usertbl WHERE height > (SELECT height FROM usertbl WHERE name = '김경호') AND name <> '김경호';

-- 임재범보다 나이가 적은 행들을 출력
SELECT * FROM usertbl;
-- SELECT * FROM usertbl WHERE birthyear > (임재범의 나이);
SELECT * FROM usertbl WHERE birthyear > (SELECT birthyear FROM usertbl WHERE name = '임재범');

-- 경남 지역의 키보다 큰 행을 출력
SELECT * FROM usertbl WHERE height > ANY(SELECT height FROM usertbl WHERE addr = '경남');
-- 경남 지역에 사는 사람들의 키가 170, 173 두개가 있는데 어느걸 기준으로 잡아서 비교할지를 모름. ==> 그래서 에러 발생
-- ANY는 170, 173 어떤것을 상관하지 않고 다 출력 그래서 172도 출력이 됨.
SELECT * FROM usertbl WHERE height > ALL(SELECT height FROM usertbl WHERE addr = '경남');
-- ALL은 170보다도 커야하고 173보다도 커야함 그래서 결구 173보다 커야한다는 의미.



-- -------------------------------------------------------
-- 문제
-- -------------------------------------------------------
SELECT * FROM buyTbl;

-- 1)amount가 10인 행의 price보다 큰 행을 출력하세요 (서브쿼리)
SELECT * FROM buyTbl WHERE price > (SELECT price FROM buyTbl WHERE amount = '10');

-- 2)UserID가 K로 시작하는 행의 amount 보다 큰 행을 출력하세요 (서브쿼리 + ANY)
SELECT * FROM buyTbl WHERE amount > ANY(SELECT amount FROM buyTbl WHERE userid LIKE 'K%');

-- 3)amount가 5인 행의 price보다 큰 행을 출력하세요 (서브쿼리 + ALL)
SELECT * FROM buyTbl WHERE price > ALL(SELECT price FROM buyTbl WHERE amount = 5);


-- ----------------------------------------------------------
-- 정렬 (ORDER BY)
-- ----------------------------------------------------------


SELECT * FROM usertbl ORDER BY mdate;
-- 오름차순 기본
SELECT * FROM usertbl ORDER BY mdate DESC;
-- DESC 내림차순

SELECT * FROM usertbl ORDER BY birthyear ASC, name DESC;
SELECT addr FROM usertbl;


SELECT distinct addr FROM usertbl ORDER BY addr;
-- distinct : 중복된 값 제거

SELECT rownum as RN, * FROM usertbl;
-- rownum를 RN으로 바꿔줘서 조회해줌. SELECT 하면서 열에 추가해준다는 의미( AS )

SELECT * FROM (SELECT rownum AS RN,  usertbl.* FROM usertbl);
--              ↑RN이 포함된 usertbl
SELECT * FROM (SELECT rownum AS RN, usertbl.* FROM usertbl) WHERE RN >= 2 AND RN <= 4;

-- 테이블 구조 + 데이터
CREATE TABLE buytbl2 AS SELECT * FROM buytbl;
-- SELECT결과물을 기준으로 buytbl2 테이블을 생성한다는 의미 (복사)
SELECT * FROM buytbl2;
DESC buytbl2;

-- 구조만
CREATE TABLE buytbl3 AS SELECT * FROM buytbl WHERE 1 = 2;
-- false 값을 추가하면, 구조만 똑같이 복사가 됨. 값은 복사 X
SELECT * FROM buytbl3;
DESC buytbl3;

INSERT INTO buytbl3 SELECT * FROM buytbl;
SELECT * FROM buytbl3;

-- -------------------------------------------------------
-- 문제
-- -------------------------------------------------------
SELECT * FROM buyTbl;
-- 1)UserID 순으로 오름차순 정렬
SELECT * FROM buyTbl ORDER BY UserID;
-- 2)price 순으로 내림차순 정렬
SELECT * FROM buyTbl ORDER BY price DESC;
-- 3)amount 순으로 오름차순 prodName으로 내림차순정렬
SELECT * FROM buyTbl ORDER BY amount ASC, prodName DESC;
-- 4)prodName을 오름차순으로 정렬 시 중복 제거
SELECT distinct prodname FROM buyTbl ORDER BY prodname ASC;
-- 5)userID열의 검색 시 중복된 아이디제거하고 SELECT
SELECT DISTINCT UserID FROM buyTbl;
-- 6)구매양(amount)가 3이상인 행을 prodName 내림차순으로 정렬
SELECT * FROM buyTbl WHERE amount >= 3 ORDER BY prodname DESC;
-- 7)usertbl의 addr 가 서울, 경기인 값들을 CUsertbl에 복사
CREATE TABLE CUsertbl AS SELECT * FROM usertbl WHERE addr IN ('서울', '경기');
SELECT * FROM usertbl;
SELECT * FROM CUsertbl;




