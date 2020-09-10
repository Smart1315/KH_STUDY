-- ������(SEQUENCE) : �ڵ� ��ȣ �߻��� ������ �ϴ� ��ü
-- ���������� ���� ���� �ڵ����� ����

CREATE SEQUENCE SEQ_EMPID
START WITH 300 -- ���� ����
INCREMENT BY 5 -- ���� ����
MAXVALUE 310 -- �ִ� ��
NOCYCLE -- ����Ŭ ���� �ʰڴ�
NOCACHE; -- �޸� �󿡼� �������� �ʰڴ�

SELECT * FROM USER_SEQUENCES;

-- ������ ���
-- ��������.CURRVAL : ���� ������ ������ ��(���������� ȣ��� NEXTVAL�� ���� ����)
-- ��������.NEXTVAL : ���� ������ ������ ����ġ��ŭ ������ ��
--                   ���ʷ� �������� �����Ŵ
SELECT SEQ_EMPID.CURRVAL FROM DUAL;
-- sequence SEQ_EMPID.CURRVAL is not yet defined in this session

SELECT SEQ_EMPID.NEXTVAL FROM DUAL; -- 300
SELECT SEQ_EMPID.CURRVAL FROM DUAL; -- 300
SELECT SEQ_EMPID.NEXTVAL FROM DUAL; -- 305
SELECT SEQ_EMPID.NEXTVAL FROM DUAL; -- 310
SELECT SEQ_EMPID.NEXTVAL FROM DUAL;
-- ORA-08004: sequence SEQ_EMPID.NEXTVAL exceeds MAXVALUE and cannot be instantiated

SELECT * FROM USER_SEQUENCES;

-- START WITH ���� �Ұ��� : ���� ������ DROP �� �����
ALTER SEQUENCE SEQ_EMPID
INCREMENT BY 10
MAXVALUE 400
NOCYCLE
NOCACHE;

SELECT * FROM USER_SEQUENCES;
SELECT SEQ_EMPID.NEXTVAL FROM DUAL;
SELECT SEQ_EMPID.CURRVAL FROM DUAL;

/*
    CURRVAL / NEXTVAL ��� ���� ����
        ��� ����
            ���������� �ƴ� SELECT��
            INSERT���� SELECT��
            INSERT���� VALUES��
            UPDATE���� SET��
            
        ��� �Ұ���
            VIEW�� SELECT��
            DISTINCTŰ���尡 �ִ� SELECT��
            GROUP BY, HAVING, ORDER BY�� SELECT��
            SELECT, DELETE, UPDATE���� ��������
            CREATE TABLE, ALTER TABLE����� DEFAULT��

*/

INSERT INTO EMPLOYEE
VALUES (SEQ_EMPID.NEXTVAL, 'ȫ�浿', '660606-1666666', 'hong_gd123@kh.or.kr',
        '01011112222', 'D2', 'J7', 'S1', 5000000, 0.1, 200, SYSDATE, NULL, DEFAULT);
        
SELECT * FROM EMPLOYEE;

CREATE TABLE TMP_EMPLOYEE(
    E_ID NUMBER DEFAULT SEQ_EMPID.CURRVAL,
    E_NAME VARCHAR2(20)
);

ROLLBACK;

