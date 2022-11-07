SELECT * FROM buytbl;

-- 유저별 총 구매 수량
SELECT userid, SUM(amount) FROM buytbl GROUP BY userid;
SELECT userid, AVG(amount) as 총구매수량 FROM buytbl GROUP BY userid;

SELECT userid, cast(avg(amount) as decimal(5, 2)) as 총구매수량 FROM buytbl GROUP BY userid;
--                  ↑ 기존 값       ↑ 변환값 (decimal은 double형), 정수 부분(자리수), 실수 부분(자리수)
SELECT MAX(height) FROM usertbl;
SELECT MIN(height) FROM usertbl;
SELECT MAX(birthyear) FROM usertbl;
SELECT MIN(birthyear) FROM usertbl;

-- ----------------------------------------------
-- MAX, MIN + 조건절 서브쿼리를 이용한 문제
-- ----------------------------------------------

-- usertbl에서 가장 키가 큰 행의 모든 열을 출력
SELECT * FROM usertbl;
SELECT * FROM usertbl WHERE height = (SELECT MAX(height) FROM usertbl);
-- buytbl에서 구매량이 가장 큰 행의 모든 열을 출력
SELECT * FROM buytbl;
SELECT * FROM buytbl WHERE amount = (SELECT MAX(amount) FROM buytbl);



-- COUNT()

SELECT COUNT(*) FROM usertbl;
SELECT COUNT(mobile1) FROM usertbl;
-- mobile 중에 null인 부분은 세지 않음.

SELECT avg(amount) FROM buytbl;
SELECT CAST(avg(amount) as decimal(5,2)) FROM buytbl;
-- decimal은 반올림
SELECT TRUNC(AVG(amount), 3) from buytbl;
-- 소수점 이하의 자릿수 3 제한!
-- 절삭



-- -------------------------------------------------------
-- 문제
-- -------------------------------------------------------
SELECT * FROM buytbl;
SELECT * FROM usertbl;
-- 1)buytbl에서 userid 별로 구매량(amount)의 합을 출력하세요
SELECT userid, SUM(amount) as 총구매량 FROM buytbl GROUP BY userid;
-- 2)usertbl에서 키의 평균값을 구하세요
SELECT AVG(height) FROM usertbl;
-- 3)buy테이블에서 최대구매량과 최소구매량을 userid와 함께 출력하세요 
SELECT userid, MAX(AMOUNT) AS 최대구매량, MIN(AMOUNT) AS 최소구매량 FROM buytbl GROUP BY userid;
-- 4)buytbl의 groupname의 개수를 출력하세요
SELECT COUNT(DISTINCT groupname) FROM buytbl;

-- Having

SELECT userid, SUM(amount) FROM buytbl GROUP BY userid;
--SELECT userid, SUM(amount) FROM buytbl GROUP BY userid WHERE SUM(amount) >= 5;
--집계함수가 포함되어있는 조건절을 잡을 때는 WHERE을 사용하는게 아니라 Having이라는 예약어를 사용해야함.
SELECT userid, SUM(amount) AS 구매수량 FROM buytbl GROUP BY userid HAVING SUM(amount) >= 5;

SELECT userid, SUM(amount * price) AS 구매액수 FROM buytbl GROUP BY userid HAVING SUM(amount * price) >= 100;
SELECT userid, SUM(amount * price) AS 구매액수 FROM buytbl GROUP BY userid HAVING SUM(amount * price) >= 100 ORDER BY SUM(amount * price) ASC;


-- -------------------------------------------------------
-- 문제
-- -------------------------------------------------------
SELECT * FROM buytbl;
-- 1)prodName 별로 그룹화 한 뒤 userID / prodName / Price * amount 순으로 출력될 수 있도록 설정
SELECT prodName, SUM(price * amount) FROM buytbl GROUP BY ProdName;

SELECT userid, prodName, SUM(price * amount) FROM buytbl GROUP BY userid, prodname;

-- 2)1번 명령어에서 price * amount 값이 1000이상인 행만 출력
SELECT prodName, SUM(price * amount) FROM buytbl GROUP BY prodName HAVING SUM(price * amount) >= 1000;

-- 3)price 가격이 가장 큰 행과 작은 행의 userid, prodName, price을 출력
SELECT distinct userid, prodName, price FROM buytbl where price = (SELECT MAX(price) FROM buytbl) OR price = (SELECT MIN(price) FROM buytbl);

--SELECT userid, prodname, price WHERE price = MAX(price) OR price = MIN(price);
-- 오류


-- 총 합계
SELECT groupName, SUM(price * amount) FROM buytbl GROUP BY ROLLUP(groupname);
-- groupname으로 묶어놓은 값의 총합을 구하겠다.
-- 마지막의 값은 위 네개의 총합임.

--소 합계

SELECT num, groupname, sum(price * amount) FROM buytbl GROUP BY ROLLUP(groupname, num);
SELECT prodname, groupname, sum(price*amount) FROM buytbl GROUP BY ROLLUP(groupname, prodname);
-- 쭉 소합계 나오다가 마지막에 총합계가 나옴.

SELECT * FROM buytbl;



-- 4)다음 행중에 그룹네임이 있는 행만 출력
SELECT * FROM buytbl where groupname != 'null';

-- 5)prodName 별로 총합을 구해보세요 (ROLLUP사용)
SELECT prodName, SUM(price * amount) FROM buytbl GROUP BY ROLLUP(prodName);









