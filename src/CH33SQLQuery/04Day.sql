DROP TABLE test_01;
DROP TABLE test_02;
CREATE TABLE test_01 (
col1 INT PRIMARY KEY,
col2 INT
);

SELECT * FROM USER_INDEXES WHERE TABLE_NAME = 'TEST_01';

CREATE TABLE test_02 (
col1 INT PRIMARY KEY,
col2 INT UNIQUE
);

SELECT * FROM USER_INDEXES WHERE TABLE_NAME = 'TEST_02'

DROP TABLE test_03;
CREATE TABLE test_03 (
col1 INT PRIMARY KEY,
col2 INT,
col3 INT,
col4 INT,
CONSTRAINT FK_03_01 FOREIGN KEY(col3) REFERENCES test_01(col1)
);

SELECT * FROM USER_INDEXES WHERE TABLE_NAME = 'TEST_03';
-- �ܷ�Ű�� ���� INDEX�� ��������� �ʴ´ٴ� �̾߱�.
-- MYSQL������ �ܷ�Ű�� ���� INDEX�� �������.

-- ���� IDX ����

CREATE INDEX IDX_COL2 ON test_03(col2);
-- ���� ���̺� - ���������� �ε������� Ȯ���� �� ����.
SELECT * FROM USER_INDEXES WHERE TABLE_NAME = 'TEST_03';

CREATE INDEX IDX_COL34 ON test_03(col3, col4);

DROP INDEX IDX_COL34;
DROP INDEX SYS_C007094; -- PK INDEX ���� �Ұ�
DROP INDEX SYS_C007097; -- PK INDEX ���� �Ұ�
ALTER TABLE test_04 DROP PRIMARY KEY;
-- UNIQUE�� �����ϰų� PRIMARY KEY�� �����ؾ߸� INDEX�� �����.
ALTER TABLE test_03 DROP CONSTRAINT SYS_C007097;

SELECT * FROM ALL_CONS_COLUMNS WHERE TABLE_NAME = 'TEST_03';
SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME = 'TEST_03';
