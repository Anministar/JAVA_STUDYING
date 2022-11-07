SELECT * FROM buytbl;

-- ������ �� ���� ����
SELECT userid, SUM(amount) FROM buytbl GROUP BY userid;
SELECT userid, AVG(amount) as �ѱ��ż��� FROM buytbl GROUP BY userid;

SELECT userid, cast(avg(amount) as decimal(5, 2)) as �ѱ��ż��� FROM buytbl GROUP BY userid;
--                  �� ���� ��       �� ��ȯ�� (decimal�� double��), ���� �κ�(�ڸ���), �Ǽ� �κ�(�ڸ���)
SELECT MAX(height) FROM usertbl;
SELECT MIN(height) FROM usertbl;
SELECT MAX(birthyear) FROM usertbl;
SELECT MIN(birthyear) FROM usertbl;

-- ----------------------------------------------
-- MAX, MIN + ������ ���������� �̿��� ����
-- ----------------------------------------------

-- usertbl���� ���� Ű�� ū ���� ��� ���� ���
SELECT * FROM usertbl;
SELECT * FROM usertbl WHERE height = (SELECT MAX(height) FROM usertbl);
-- buytbl���� ���ŷ��� ���� ū ���� ��� ���� ���
SELECT * FROM buytbl;
SELECT * FROM buytbl WHERE amount = (SELECT MAX(amount) FROM buytbl);



-- COUNT()

SELECT COUNT(*) FROM usertbl;
SELECT COUNT(mobile1) FROM usertbl;
-- mobile �߿� null�� �κ��� ���� ����.

SELECT avg(amount) FROM buytbl;
SELECT CAST(avg(amount) as decimal(5,2)) FROM buytbl;
-- decimal�� �ݿø�
SELECT TRUNC(AVG(amount), 3) from buytbl;
-- �Ҽ��� ������ �ڸ��� 3 ����!
-- ����



-- -------------------------------------------------------
-- ����
-- -------------------------------------------------------
SELECT * FROM buytbl;
SELECT * FROM usertbl;
-- 1)buytbl���� userid ���� ���ŷ�(amount)�� ���� ����ϼ���
SELECT userid, SUM(amount) as �ѱ��ŷ� FROM buytbl GROUP BY userid;
-- 2)usertbl���� Ű�� ��հ��� ���ϼ���
SELECT AVG(height) FROM usertbl;
-- 3)buy���̺��� �ִ뱸�ŷ��� �ּұ��ŷ��� userid�� �Բ� ����ϼ��� 
SELECT userid, MAX(AMOUNT) AS �ִ뱸�ŷ�, MIN(AMOUNT) AS �ּұ��ŷ� FROM buytbl GROUP BY userid;
-- 4)buytbl�� groupname�� ������ ����ϼ���
SELECT COUNT(DISTINCT groupname) FROM buytbl;

-- Having

SELECT userid, SUM(amount) FROM buytbl GROUP BY userid;
--SELECT userid, SUM(amount) FROM buytbl GROUP BY userid WHERE SUM(amount) >= 5;
--�����Լ��� ���ԵǾ��ִ� �������� ���� ���� WHERE�� ����ϴ°� �ƴ϶� Having�̶�� ���� ����ؾ���.
SELECT userid, SUM(amount) AS ���ż��� FROM buytbl GROUP BY userid HAVING SUM(amount) >= 5;

SELECT userid, SUM(amount * price) AS ���ž׼� FROM buytbl GROUP BY userid HAVING SUM(amount * price) >= 100;
SELECT userid, SUM(amount * price) AS ���ž׼� FROM buytbl GROUP BY userid HAVING SUM(amount * price) >= 100 ORDER BY SUM(amount * price) ASC;


-- -------------------------------------------------------
-- ����
-- -------------------------------------------------------
SELECT * FROM buytbl;
-- 1)prodName ���� �׷�ȭ �� �� userID / prodName / Price * amount ������ ��µ� �� �ֵ��� ����
SELECT prodName, SUM(price * amount) FROM buytbl GROUP BY ProdName;

SELECT userid, prodName, SUM(price * amount) FROM buytbl GROUP BY userid, prodname;

-- 2)1�� ��ɾ�� price * amount ���� 1000�̻��� �ุ ���
SELECT prodName, SUM(price * amount) FROM buytbl GROUP BY prodName HAVING SUM(price * amount) >= 1000;

-- 3)price ������ ���� ū ��� ���� ���� userid, prodName, price�� ���
SELECT distinct userid, prodName, price FROM buytbl where price = (SELECT MAX(price) FROM buytbl) OR price = (SELECT MIN(price) FROM buytbl);

--SELECT userid, prodname, price WHERE price = MAX(price) OR price = MIN(price);
-- ����


-- �� �հ�
SELECT groupName, SUM(price * amount) FROM buytbl GROUP BY ROLLUP(groupname);
-- groupname���� ������� ���� ������ ���ϰڴ�.
-- �������� ���� �� �װ��� ������.

--�� �հ�

SELECT num, groupname, sum(price * amount) FROM buytbl GROUP BY ROLLUP(groupname, num);
SELECT prodname, groupname, sum(price*amount) FROM buytbl GROUP BY ROLLUP(groupname, prodname);
-- �� ���հ� �����ٰ� �������� ���հ谡 ����.

SELECT * FROM buytbl;



-- 4)���� ���߿� �׷������ �ִ� �ุ ���
SELECT * FROM buytbl where groupname != 'null';

-- 5)prodName ���� ������ ���غ����� (ROLLUP���)
SELECT prodName, SUM(price * amount) FROM buytbl GROUP BY ROLLUP(prodName);









