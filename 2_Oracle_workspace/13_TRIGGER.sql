-- TRIGGER(Ʈ����)
-- ���̺��̳� �䰡 INSERT, UPDATE, DELETE ���� DML���� ���� ����� ���(���̺� �̺�Ʈ�� �߻����� ��)
-- �ڵ����� ����� ������ �����Ͽ� �����ϴ� ��ü

-- Ʈ���� ����
-- SQL���� ���� �ñ⿡ ���� �з�
--      BEFORE TRIGGER : SQL�� ���� �� Ʈ���� ����
--      AFTER TRIGGER : SQL�� ���� �� Ʈ���� ����

-- SQL���� ���� ������ �޴� �� ROW�� ���� �з�
--      ROW TRIGGER(��Ʈ����)
--          SQL�� �� ROW�� ���� �� ���� ����
--          Ʈ���� �ۼ� �� FOR EACH ROW �ɼ� �ۼ�
--          :OLD --> ���� ���� ���� ��(UPDATE : ���� �� �ڷ�, DELETE : ���� �� �ڷ�)
--          :NEW --> ���� ���� ���� ��(INSERT : �Է� �� �ڷ�, UPDATE : ���� �� �ڷ�) 
--      STATEMENT TRIGGER(���� Ʈ����)
--          SQL���� ���� �� ���� ����(DEFAULT TRIGGER)

-- Ʈ���� ������
/*
    CREATE [OR REPLACE] TRIGGER Ʈ���� ��
    BEFORE | AFTER
    INSERT | UPDATE | DELETE
    ON ���̺� ��
    [FOR EACH ROW]
    [WHEN ����]
    DECLARE
        -- �����
    BEGIN
        -- �����
    [EXCEPTION]
    END;
    /
*/

-- EMPLOYEE���̺� ����� �߰��Ǹ� '���Ի���� �Ի��߽��ϴ�.'��� ������ ��µǴ� TRG_01 Ʈ���� ����
CREATE OR REPLACE TRIGGER TRG_01
AFTER INSERT ON EMPLOYEE
BEGIN
    DBMS_OUTPUT.PUT_LINE('���Ի���� �Ի��߽��ϴ�.');
END;
/

INSERT INTO EMPLOYEE
VALUES(905, '�漺��', '691011-1257943', 'gil_sc@kh.or.kr', '01075431357', 'D5', 'J3', 'S5',
        3000000, 0.1, 200, SYSDATE, NULL, DEFAULT);
DELETE FROM EMPLOYEE WHERE EMP_ID = 905;
ROLLBACK;
COMMIT;

SET SERVEROUTPUT ON;

COMMIT;

-- ��ǰ ���� ���̺�
CREATE TABLE PRODUCT(
    PCODE NUMBER PRIMARY KEY, -- ��ǰ�ڵ�
    PNAME VARCHAR2(30), -- ��ǰ ��
    BRAND VARCHAR2(30), -- �귣��
    PRICE NUMBER, -- ����
    STOCK NUMBER DEFAULT 0 -- ���
);

-- ��ǰ ����� �� �̷� ���̺�
CREATE TABLE PRO_DETAIL(
    DCODE NUMBER PRIMARY KEY, -- ���ڵ�
    PCODE NUMBER, -- ��ǰ �ڵ�
    PDATE DATE, -- ��ǰ �������
    AMOUNT NUMBER, -- ����� ����
    STATUS VARCHAR2(10) CHECK(STATUS IN ('�԰�', '���')), -- �԰�/���
    FOREIGN KEY(PCODE) REFERENCES PRODUCT(PCODE)
);

CREATE SEQUENCE SEQ_PCODE;
CREATE SEQUENCE SEQ_DCODE;

INSERT INTO PRODUCT
VALUES (SEQ_PCODE.NEXTVAL, '�����ó�Ʈ20', '�Ｚ', 9000, DEFAULT);
INSERT INTO PRODUCT
VALUES (SEQ_PCODE.NEXTVAL, '������11', '����', 9500, DEFAULT);
INSERT INTO PRODUCT
VALUES (SEQ_PCODE.NEXTVAL, '������ڵ���', '���Ǿ�', 15000, DEFAULT);

SELECT * FROM PRODUCT;
SELECT * FROM PRO_DETAIL;

-- ��ǰ ����� ���̺� �԰�/��� �� ������ PRODUCT�� �ִ� ���(STOCK)�� �ٲ��� ��
-- ���� PRO_DETAIL ���̺� ������ ����(INSERT) ��
-- STATUS�÷� ���� ���� PRODUCT���̺� STOCK�÷� �� ���� Ʈ���� �ۼ�
CREATE OR REPLACE TRIGGER TGR_02
AFTER INSERT ON PRO_DETAIL
FOR EACH ROW
BEGIN
    IF :NEW.STATUS = '�԰�'
    THEN
        UPDATE PRODUCT
        SET STOCK = STOCK + :NEW.AMOUNT
        WHERE PCODE = :NEW.PCODE;
    END IF;
    
    IF :NEW.STATUS = '���'
    THEN
        UPDATE PRODUCT
        SET STOCK = STOCK - :NEW.AMOUNT
        WHERE PCODE = :NEW.PCODE;
    END IF;
END;
/

SELECT * FROM PRODUCT;
SELECT * FROM PRO_DETAIL;

INSERT INTO PRO_DETAIL VALUES(SEQ_DCODE.NEXTVAL, 1, SYSDATE, 5, '�԰�');
INSERT INTO PRO_DETAIL VALUES(SEQ_DCODE.NEXTVAL, 2, SYSDATE, 15, '�԰�');
INSERT INTO PRO_DETAIL VALUES(SEQ_DCODE.NEXTVAL, 3, SYSDATE, 1, '�԰�');
INSERT INTO PRO_DETAIL VALUES(SEQ_DCODE.NEXTVAL, 1, SYSDATE, 2, '���');

COMMIT;