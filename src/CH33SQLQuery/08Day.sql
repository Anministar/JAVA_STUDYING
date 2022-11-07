SELECT * FROM tbl_member;

DESC tbl_member;

BEGIN
    FOR i IN 1..100
    LOOP
    INSERT INTO tbl_member VALUES(member_seq.NEXTVAL, 'exam' || i || '@naver.com', '¿Œ√µ', '010-222-3333');
    
    END LOOP;
END;
COMMIT;
SELECT * FROM tbl_member;