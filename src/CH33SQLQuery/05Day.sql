COMMIT;

-- �ǽ��� ���̺� ����
CREATE TABLE TEST(
NO NUMBER(3),
NAME VARCHAR2(10),
AGE NUMBER(3),
GENDER VARCHAR(6)
);

-- ������ �߰�
INSERT INTO TEST VALUES(1, 'JOKER', '28', 'M');
-- ������ �߰�
INSERT INTO TEST VALUES(2, 'ADAMS', '33', 'M');

SELECT * FROM test;

-- ���̺�����Ʈ S1 ����
SAVEPOINT S1;
COMMIT;

-- ������ �߰�
INSERT INTO TEST VALUES(3, 'SMITH', '35', 'M');
-- ���̺�����Ʈ S2 ����
SAVEPOINT S2;
COMMIT;


INSERT INTO TEST VALUES(4, 'MARRY', '40', 'W');
INSERT INTO TEST VALUES(5, 'KIM', '45', 'M');
SELECT * FROM test;

ROLLBACK;
-- COMMIT �������� �� ���ư� (���̺��� ���� ��ü�� ������µ�, ������ �� �����.)

ROLLBACK TO S2;
SELECT * FROM test;

ROLLBACK TO S1;
SELECT * FROM test;

ROLLBACK;
SELECT * FROM test;





