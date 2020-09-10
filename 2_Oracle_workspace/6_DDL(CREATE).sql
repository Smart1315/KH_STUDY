-- DDL : ������ ���� ���
-- ��ü�� �����(CREATE), �����ϰ�(ALTER), �����ϴ�(DROP) ����

-- CREATE : �����ͺ��̽� ��ü�� �����ϴ� ����
-- ���̺� ���� ����
CREATE TABLE MEMBER(
    MEMBER_ID VARCHAR2(20),
    MEMBER_PWD VARCHAR2(20),
    MEMBER_NAME VARCHAR2(20)
);

SELECT * FROM MEMBER;

-- �÷��� �ּ� �ޱ�
COMMENT ON COLUMN MEMBER.MEMBER_ID IS 'ȸ�����̵�';
COMMENT ON COLUMN MEMBER.MEMBER_PWD IS 'ȸ����й�ȣ';
COMMENT ON COLUMN MEMBER.MEMBER_NAME IS 'ȸ���̸�';

DESC MEMBER;

-- ��������(CONSTRAINTS)
-- ���̺� �ۼ� �� �� �÷��� ���� �� ��Ͽ� ���� ���� ���� ���� ����
-- ������ ���Ἲ : �������� ��Ȯ��, �ϰ���, ��ȿ���� �����Ǵ� ��
-- �Է� �����Ϳ� ������ ������ �ڵ����� �˻��ϴ� ����
-- ���������� ���̺��� ó�� ���� �� �����ص� �ǰ�, ���̺��� ����� ���� �����ص� ��

-- ���� ���� Ȯ��
DESC USER_CONSTRAINTS;
SELECT * FROM USER_CONSTRAINTS; -- ����ڰ� �ۼ��� �������� Ȯ��
SELECT * FROM USER_CONS_COLUMNS; -- ���������� �ɷ��ִ� �÷� Ȯ��

-- NOT NULL : �÷��� �ݵ�� ���� ��ϵǾ�� �ϴ� ��� ���
-- ����/���� �� NULL���� ������� �ʵ��� �÷��������� ����
CREATE TABLE USER_NOCONST(
    USER_NO NUMBER,
    USER_ID VARCHAR2(20),
    USER_PWD VARCHAR2(20),
    USER_NAME VARCHAR2(30),
    GENDER VARCHAR2(10),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50)
);

INSERT INTO USER_NOCONST 
VALUES(1, 'user01', 'pass01', '���ǰ�', '��', '010-1111-2222', 'kang123@kh.or.kr');

INSERT INTO USER_NOCONST
VALUES(2, NULL, NULL, NULL, NULL, '010-1111-2222', 'kang123@kh.or.kr');

-- ���� ���� �����ϴ� ���
-- 1. ���̺��� ���� �� ���� �����ϱ�
--      1-1. ���̺� ������ ����
--      1-2. �÷� ������ ����
-- 2. ���̺��� ���� �� �߰��� �����ϱ�

CREATE TABLE USER_NOTNULL(
    USER_NO NUMBER NOT NULL, -- �÷��������� �������� ����
    USER_ID VARCHAR2(20) NOT NULL,
    USER_PWD VARCHAR2(20) NOT NULL,
    USER_NAME VARCHAR2(30) NOT NULL,
    GENDER VARCHAR2(10),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50)
);

INSERT INTO USER_NOTNULL 
VALUES(1, 'user01', 'pass01', '���ǰ�', '��', '010-1111-2222', 'kang123@kh.or.kr');

INSERT INTO USER_NOTNULL
VALUES(2, NULL, NULL, NULL, NULL, '010-1111-2222', 'kang123@kh.or.kr');
-- ORA-01400: cannot insert NULL into ("KH"."USER_NOTNULL"."USER_ID")

-- UNIQUE : �÷��� �Է��ϴ� ���� ���� �ߺ��� �����ϴ� ��������
-- �÷�����, ���̺� �������� ���� ����
SELECT * FROM USER_NOCONST;

INSERT INTO USER_NOCONST 
VALUES(1, 'user01', 'pass01', '���ǰ�', '��', '010-1111-2222', 'kang123@kh.or.kr');

CREATE TABLE USER_UNIQUE(
    USER_NO NUMBER,
    USER_ID VARCHAR2(20) UNIQUE, -- �÷� �������� �������� ����
    USER_PWD VARCHAR2(20),
    USER_NAME VARCHAR2(30),
    GENDER VARCHAR2(10),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50)
);

INSERT INTO USER_UNIQUE
VALUES(1, 'user01', 'pass01', '���ǰ�', '��', '010-1111-2222', 'kang123@kh.or.kr');

INSERT INTO USER_UNIQUE
VALUES(1, 'user01', 'pass01', '���ǰ�', '��', '010-1111-2222', 'kang123@kh.or.kr');
-- ORA-00001: unique constraint (KH.SYS_C007032) violated

CREATE TABLE USER_UNIQUE2(
    USER_NO NUMBER,
    USER_ID VARCHAR2(20),
    USER_PWD VARCHAR2(20),
    USER_NAME VARCHAR2(30),
    GENDER VARCHAR2(10),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50),
    UNIQUE(USER_ID) -- ���̺� �������� �������� ����
);

CREATE TABLE USER_UNIQUE3(
    USER_NO NUMBER,
    USER_ID VARCHAR2(20),
    USER_PWD VARCHAR2(20) NOT NULL,
    USER_NAME VARCHAR2(30),
    GENDER VARCHAR2(10),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50),
    UNIQUE(USER_ID, USER_NO) -- ���̺� �������� �������� ����
);

INSERT INTO USER_UNIQUE3
VALUES(1, 'user01', 'pass01', '���ǰ�', '��', '010-1111-2222', 'kang123@kh.or.kr');

INSERT INTO USER_UNIQUE3
VALUES(2, 'user01', 'pass01', '���ǰ�', '��', '010-1111-2222', 'kang123@kh.or.kr');

INSERT INTO USER_UNIQUE3
VALUES(2, 'user02', 'pass01', '���ǰ�', '��', '010-1111-2222', 'kang123@kh.or.kr');

INSERT INTO USER_UNIQUE3
VALUES(1, 'user02', 'pass01', '���ǰ�', '��', '010-1111-2222', 'kang123@kh.or.kr');

INSERT INTO USER_UNIQUE3
VALUES(1, 'user01', 'pass01', '���ǰ�', '��', '010-1111-2222', 'kang123@kh.or.kr');

CREATE TABLE CONS_NAME(
    TSET_DATA1 VARCHAR2(20) CONSTRAINT CN_TD1_NN NOT NULL,
    TEST_DATA2 VARCHAR2(20) CONSTRAINT CN_TD2_UQ UNIQUE,
    TEST_DATA3 VARCHAR2(30),
    CONSTRAINT CN_TD3_UK UNIQUE(TEST_DATA3)
);

INSERT INTO CONS_NAME
VALUES(NULL, 'TEST2', 'TEST3');

INSERT INTO CONS_NAME
VALUES('TEST1', 'TEST2', 'TEST3');

INSERT INTO CONS_NAME
VALUES('TEST1', 'TEST2', 'TEST3');
-- ORA-00001: unique constraint (KH.CN_TD2_UQ) violated

-- PRIMARY KET (PK, �⺻Ű)
-- NOT NULL + UNIQUE
-- ���̺��� �� ���� ������ ã�� ���� ����� �÷� �ǹ� : ���̺� ���� �ĺ��� ����
-- �� ���̺� �� �� ���� ���� ����
-- �÷� ����, ���̺� ���� �� �� ���� ����

CREATE TABLE USER_PRIMARYKEY(
    USER_NO NUMBER CONSTRAINT UR_UN_PK PRIMARY KEY, -- �÷� ����
    USER_ID VARCHAR2(20) UNIQUE,
    USER_PWD VARCHAR2(20) NOT NULL,
    USER_NAME VARCHAR2(30),
    GENDER VARCHAR2(10),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50)
);

INSERT INTO USER_PRIMARYKEY 
VALUES(1, 'user01', 'pass01', '���ǰ�', '��', '010-1111-2222', 'kang123@kh.or.kr');

INSERT INTO USER_PRIMARYKEY 
VALUES(1, 'user02', 'pass02', '������', '��', '010-2222-3333', 'nam123@kh.or.kr');

INSERT INTO USER_PRIMARYKEY 
VALUES(NULL, 'user03', 'pass03', '�����', '��', '010-3333-4444', 'doh123@kh.or.kr');

CREATE TABLE USER_PRIMARYKEY2(
    USER_NO NUMBER, -- �÷� ����
    USER_ID VARCHAR2(20),
    USER_PWD VARCHAR2(20) NOT NULL,
    USER_NAME VARCHAR2(30),
    GENDER VARCHAR2(10),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50),
    CONSTRAINT UR_USERNO_PK PRIMARY KEY(USER_NO, USER_ID)
);

INSERT INTO USER_PRIMARYKEY2 
VALUES(1, 'user01', 'pass01', '���ǰ�', '��', '010-1111-2222', 'kang123@kh.or.kr');

INSERT INTO USER_PRIMARYKEY2 
VALUES(1, 'user02', 'pass02', '������', '��', '010-2222-3333', 'nam123@kh.or.kr');

INSERT INTO USER_PRIMARYKEY2 
VALUES(2, 'user01', 'pass01', '�����', '��', '010-3333-4444', 'doh123@kh.or.kr');

-- FOREIGN KEY(FK, �ܺ�Ű/�ܷ�Ű)
-- ������ �ٸ� ���̺��� �����ϴ� ���� ��� ����
-- FOREIGN KEY�������ǿ� ���� ���̺� ���� ���� ����
-- ���� �Ǵ� �� �ܿ��� NULL ��� ����

-- �÷� �������� �����ϴ� ���
-- �÷��� �ڷ���(ũ��) [CONSTRAINT �������Ǹ�] REPERENCES �����ϴ� ���̺� �� [(������ �÷�)] [���� ��]

-- ���̺� �������� �����ϴ� ���
-- [CONSTRAINT �������Ǹ�] FOREIGN KEY(������ �÷� ��) REFERENCES �����ϴ� ���̺� �� [(������ �÷�)] [���� ��]
CREATE TABLE USER_GRADE(
    GRADE_CODE NUMBER PRIMARY KEY,
    GRADE_NAME VARCHAR2(30) NOT NULL
);

INSERT INTO USER_GRADE VALUES(10, '�Ϲ�ȸ��');
INSERT INTO USER_GRADE VALUES(20, '���ȸ��');
INSERT INTO USER_GRADE VALUES(30, 'Ư��ȸ��');

SELECT * FROM USER_GRADE;

CREATE TABLE USER_FOREIGNKEY(
    USER_NO NUMBER PRIMARY KEY,
    USER_ID VARCHAR2(20) UNIQUE,
    USER_PWD VARCHAR2(20) NOT NULL,
    USER_NAME VARCHAR2(30),
    GENDER VARCHAR2(10),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50),
    GRADE_CODE NUMBER,
    CONSTRAINT UF_GRAGE_FK FOREIGN KEY(GRADE_CODE) REFERENCES USER_GRADE(GRADE_CODE)
);

INSERT INTO USER_FOREIGNKEY
VALUES(1, 'user01', 'pass01', '���ǰ�', '��', '010-1111-2222', 'kang123@kh.or.kr', 10);

INSERT INTO USER_FOREIGNKEY
VALUES(2, 'user02', 'pass02', '������', '��', '010-2222-3333', 'nam123@kh.or.kr', 10);

INSERT INTO USER_FOREIGNKEY
VALUES(3, 'user03', 'pass02', '�����', '��', '010-3333-4444', 'doh123@kh.or.kr', 30);

INSERT INTO USER_FOREIGNKEY
VALUES(4, 'user04', 'pass04', '�����', '��', '010-4444-5555', 'ryu123@kh.or.kr', NULL);

SELECT * FROM USER_FOREIGNKEY;

INSERT INTO USER_FOREIGNKEY
VALUES(5, 'user05', 'pass05', '���̹�', '��', '010-5555-6666', 'moon123@kh.or.kr', 50);
-- ORA-02291: integrity constraint (KH.UF_GRAGE_FK) violated - parent key not found

SELECT * FROM USER_GRADE;

-- ���� �ɼ�
DELETE FROM USER_GRADE
WHERE GRADE_CODE = 10;
-- ORA-02292: integrity constraint (KH.UF_GRAGE_FK) violated - child record found

COMMIT;
-- Ʈ������ : �����ͺ��̽��� ���¸� ��ȭ��Ű�� ���ؼ� �����ϴ� �۾� ����
-- COMMIT : ��� �۾��� ���������� ó���ϰڴٰ� Ȯ���ϴ� ��ɾ�
--          ����� ������ ��� ���� ����
--          COMMIT�� �����ϸ� �ϳ��� Ʈ������ ������ ������
-- ROLLBACK : �۾� �� ������ �߻����� ��, Ʈ�������� ó�� �������� �߻��� ���� ����(������ COMMIT)�� ����ϰ� Ʈ����� ���� ����

DELETE FROM USER_GRADE
WHERE GRADE_CODE = 20;

SELECT * FROM USER_GRADE;

ROLLBACK;

CREATE TABLE USER_GRADE2(
    GRADE_CODE NUMBER PRIMARY KEY,
    GRADE_NAME VARCHAR2(30) NOT NULL
);

INSERT INTO USER_GRADE2 VALUES(10, '�Ϲ�ȸ��');
INSERT INTO USER_GRADE2 VALUES(20, '���ȸ��');
INSERT INTO USER_GRADE2 VALUES(30, 'Ư��ȸ��');

CREATE TABLE USER_FOREIGNKEY2(
    USER_NO NUMBER PRIMARY KEY,
    USER_ID VARCHAR2(20) UNIQUE,
    USER_PWD VARCHAR2(20) NOT NULL,
    USER_NAME VARCHAR2(30),
    GENDER VARCHAR2(10),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50),
    GRADE_CODE NUMBER,
    CONSTRAINT UF_GRAGE_FK2 FOREIGN KEY(GRADE_CODE) REFERENCES USER_GRADE2(GRADE_CODE) ON DELETE SET NULL
    -- �θ� Ű ���� �� �ڽ� Ű�� NULL�� �����ϴ� �ɼ�
);

INSERT INTO USER_FOREIGNKEY2
VALUES(1, 'user01', 'pass01', '���ǰ�', '��', '010-1111-2222', 'kang123@kh.or.kr', 10);

INSERT INTO USER_FOREIGNKEY2
VALUES(2, 'user02', 'pass02', '������', '��', '010-2222-3333', 'nam123@kh.or.kr', 10);

INSERT INTO USER_FOREIGNKEY2
VALUES(3, 'user03', 'pass03', '�����', '��', '010-3333-4444', 'doh123@kh.or.kr', 30);

INSERT INTO USER_FOREIGNKEY2
VALUES(4, 'user04', 'pass04', '�����', '��', '010-4444-5555', 'ryu123@kh.or.kr', NULL);

INSERT INTO USER_FOREIGNKEY2
VALUES(5, 'user05', 'pass05', '���̹�', '��', '010-5555-6666', 'moon123@kh.or.kr', 50);

COMMIT;

CREATE TABLE USER_GRADE3(
    GRADE_CODE NUMBER PRIMARY KEY,
    GRADE_NAME VARCHAR2(30) NOT NULL
);

INSERT INTO USER_GRADE3 VALUES(10, '�Ϲ�ȸ��');
INSERT INTO USER_GRADE3 VALUES(20, '���ȸ��');
INSERT INTO USER_GRADE3 VALUES(30, 'Ư��ȸ��');

CREATE TABLE USER_FOREIGNKEY3(
    USER_NO NUMBER PRIMARY KEY,
    USER_ID VARCHAR2(20) UNIQUE,
    USER_PWD VARCHAR2(20) NOT NULL,
    USER_NAME VARCHAR2(30),
    GENDER VARCHAR2(10),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50),
    GRADE_CODE NUMBER,
    CONSTRAINT UF_GRAGE_FK3 FOREIGN KEY(GRADE_CODE) REFERENCES USER_GRADE3(GRADE_CODE) ON DELETE CASCADE
    -- �θ� Ű ���� �� ����� �ڽ� Ű�� �����ϴ� �ɼ�
);

INSERT INTO USER_FOREIGNKEY3
VALUES(1, 'user01', 'pass01', '���ǰ�', '��', '010-1111-2222', 'kang123@kh.or.kr', 10);

INSERT INTO USER_FOREIGNKEY3
VALUES(2, 'user02', 'pass02', '������', '��', '010-2222-3333', 'nam123@kh.or.kr', 10);

INSERT INTO USER_FOREIGNKEY3
VALUES(3, 'user03', 'pass03', '�����', '��', '010-3333-4444', 'doh123@kh.or.kr', 30);

INSERT INTO USER_FOREIGNKEY3
VALUES(4, 'user04', 'pass04', '�����', '��', '010-4444-5555', 'ryu123@kh.or.kr', NULL);

INSERT INTO USER_FOREIGNKEY3
VALUES(5, 'user05', 'pass05', '���̹�', '��', '010-5555-6666', 'moon123@kh.or.kr', 50);

COMMIT;

SELECT * FROM USER_GRADE3;
SELECT * FROM USER_FOREIGNKEY3;

DELETE FROM USER_GRADE3
WHERE GRADE_CODE = 10;

-- CHECK : �÷��� ��ϵǴ� ���� ���� ����
-- CHECK(�÷��� �񱳿����� �񱳰�)
-- �� ���� ���ͷ��� ��� ����, ���ϴ� ���̳� �Լ� ��� �Ұ���

CREATE TABLE USER_CHECK(
    USER_NO NUMBER PRIMARY KEY,
    USER_ID VARCHAR2(20) UNIQUE,
    USER_PWD VARCHAR2(20) NOT NULL,
    USER_NAME VARCHAR2(30),
    GENDER VARCHAR2(10) CHECK(GENDER IN ('��', '��')),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50)
);

INSERT INTO USER_CHECK
VALUES(1, 'user01', 'pass01', '���ǰ�', '��', '010-1111-2222', 'kang123@kh.or.kr');

INSERT INTO USER_FOREIGNKEY3
VALUES(2, 'user02', 'pass02', '������', '����', '010-2222-3333', 'nam123@kh.or.kr');

CREATE TABLE USER_CHECK2(
    TEST_NUMBER NUMBER,
    CONSTRAINT UC_TN_CK CHECK(TEST_NUMBER > 0)
);

INSERT INTO USER_CHECK2
VALUES(10);

INSERT INTO USER_CHECK2
VALUES(-10);

CREATE TABLE USER_CHECK3(
    C_NAME VARCHAR2(15 CHAR), -- 15���� ũ��
    C_PRICE NUMBER,
    C_LEVEL CHAR(1),
    C_DATE DATE,
    CONSTRAINT UC3_CN_PK PRIMARY KEY(C_NAME),
--    CONSTRAINT UC3_CP_CK CHECK(C_PRICE >= 1 AND C_PRICE <= 99999)
    CONSTRAINT UC3_CP_CK CHECK(C_PRICE BETWEEN 1 AND 99999),
    CONSTRAINT UC3_CL_CK CHECK(C_LEVEL = 'A' OR C_LEVEL = 'C'),
    CONSTRAINT UC3_CD_CK CHECK(C_DATE >= TO_DATE('2016/01/01', 'YYYY/MM/DD'))
);

-- [�ǽ� ����]
-- ȸ�����Կ� ���̺� ����(USER_TEST)
-- �÷��� : USER_NO(ȸ����ȣ) - �⺻Ű(PK_USER_NO), 
--         USER_ID(ȸ�����̵�) - �ߺ�����(UK_USER_ID),
--         USER_PWD(ȸ����й�ȣ) - NULL�� ������(NN_USER_PWD),
--         PNO(�ֹε�Ϲ�ȣ) - �ߺ�����(UK_PNO), NULL ������(NN_PNO),
--         GENDER(����) - '��' Ȥ�� '��'�� �Է�(CK_GENDER),
--         PHONE(����ó),
--         ADDRESS(�ּ�),
--         STATUS(Ż�𿩺�) - NOT NULL(NN_STATUS), 'Y' Ȥ�� 'N'���� �Է�(CK_STATUS)
-- �� �÷��� �������ǿ� �̸� �ο��� ��
-- 5�� �̻� INSERT�� ��
CREATE TABLE USER_TEST(
    USER_NO NUMBER CONSTRAINT PK_USER_NO PRIMARY KEY,
    USER_ID VARCHAR2(20) CONSTRAINT UK_USER_ID UNIQUE,
    USER_PWD VARCHAR2(20) CONSTRAINT NN_USER_PWD NOT NULL,
    PNO VARCHAR2(30) CONSTRAINT UK_PNO UNIQUE CONSTRAINT NN_PNO NOT NULL,
    GENDER VARCHAR2(10) CONSTRAINT CK_GENDER CHECK(GENDER IN ('��', '��')),
    PHONE VARCHAR2(30),
    ADDRESS VARCHAR2(50),
    STATUS CHAR(1) CONSTRAINT NN_STATUS NOT NULL CONSTRAINT CK_STATUS CHECK(STATUS IN('Y', 'N'))
);

INSERT INTO USER_TEST
VALUES(1, 'user01', 'pass01', '621235-1985634', '��', '010-1111-2222', 'kang123@kh.or.kr', 'Y');

INSERT INTO USER_TEST
VALUES(2, 'user02', 'pass02', '861015-1356452', '��', '010-2222-3333', 'nam123@kh.or.kr', 'N');

INSERT INTO USER_TEST
VALUES(3, 'user03', 'pass03', '631010-1653546', '��', '010-3333-4444', 'doh123@kh.or.kr', 'N');

INSERT INTO USER_TEST
VALUES(4, 'user04', 'pass04', '770102-2357951', '��', '010-4444-5555', 'ryu123@kh.or.kr', 'Y');

INSERT INTO USER_TEST
VALUES(5, 'user05', 'pass05', '770808-2665412', '��', '010-5555-6666', 'moon123@kh.or.kr', 'Y');

-- SUBQUERY�� �̿��� ���̺� ����
CREATE TABLE EMPLOYEE_COPY
AS
SELECT * FROM EMPLOYEE;

SELECT * FROM EMPLOYEE_COPY;

CREATE TABLE EMPLOYEE_COPY2
AS
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE
     LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
     JOIN JOB USING(JOB_CODE);
     
SELECT * FROM EMPLOYEE_COPY2;

-- �������� �߰�
-- ALTER TABLE ���̺�� ADD PRIMARY KEY(�÷���)
-- ALTER TABLE ���̺�� ADD FOREIGN KEY(�÷���) REFERENCES ���̺��(�÷���)
-- ALTER TABLE ���̺�� ADD UNIQUE(�÷���)
-- ALTER TABLE ���̺�� ADD CHECK(�÷���)
-- ALTER TABLE ���̺�� MODIFY �÷��� NOT NULL
CREATE TABLE USER_GRADE4(
    GRADE_CODE NUMBER,
    GRADE_NAME VARCHAR2(30)
);

ALTER TABLE USER_GRADE4 ADD PRIMARY KEY(GRADE_CODE);

CREATE TABLE USER_FOREIGNKEY4(
    USER_NO NUMBER PRIMARY KEY,
    USER_ID VARCHAR2(20), -- UNIQUE
    USER_PWD VARCHAR2(20), -- NOT NULL
    USER_NAME VARCHAR2(30),
    GENDER VARCHAR2(10), -- CHECK
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50),
    GRADE_CODE NUMBER -- FOREIGN KEY
);

ALTER TABLE USER_FOREIGNKEY4 ADD UNIQUE(USER_ID);
ALTER TABLE USER_FOREIGNKEY4 MODIFY USER_PWD NOT NULL;
ALTER TABLE USER_FOREIGNKEY4 ADD CHECK(GENDER IN('��', '��'));
ALTER TABLE USER_FOREIGNKEY4 ADD FOREIGN KEY(GRADE_CODE) REFERENCES USER_GRADE4;

-- DEPARTMENT���̺��� LOACTION_ID�� �ܷ�Ű �������� �߰�
-- ���� ���̺��� LOCATION, ���� �÷��� LOCATION�� �⺻Ű
ALTER TABLE DEPARTMENT ADD FOREIGN KEY(LOCATION_ID) REFERENCES LOCATION;


