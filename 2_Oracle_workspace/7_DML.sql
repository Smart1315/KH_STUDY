-- DML : ������ ���� ���
-- ���̺� ���� �����ϰų�(INSERT), �����ϰų�(UPDATE), ����(DELETE)�ϴ� ����

-- INSERT : ���ο� ���� �߰��ϴ� ����(���̺� �� ���� ����)
-- INSERT INTO ���̺� ��[(�÷���1, �÷���2, �÷���3, ...)]
-- VALUES(������1, ������2, ������3, ...);
-- ���̺� ���� ������ �÷��� ���� ���� INSERT�� �ϰ� ���� ���� ���̺� �� �ڿ� �÷��� �ۼ� : ���� �ȵ� �÷��� NULL�� ��
-- ���̺� �� �ڿ� �÷� ���� �ۼ����� �ʴ´ٸ� ��� �÷��� ���� ���� INSERT�� : ��, �÷��� ������ ���Ѽ� VALUES�� ����

-- EMPLOYEE���̺� ��ä�� ��� ���� ����
INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, EMP_NO, EMAIL, PHONE, DEPT_CODE, JOB_CODE, SAL_LEVEL, 
                     SALARY, BONUS, MANAGER_ID, HIRE_DATE, ENT_DATE, ENT_YN)
VALUES(900, '��ä��', '901111-2050503', 'jang_ch@kh.or.kr', '01055557834', 'D1', 'J7', 'S3', 
       4300000, 0.2, '200', SYSDATE, NULL, DEFAULT);
       
ROLLBACK;

INSERT INTO EMPLOYEE
VALUES(900, '��ä��', '901111-2050503', 'jang_ch@kh.or.kr', '01055557834', 'D1', 'J7', 'S3', 
       4300000, 0.2, '200', SYSDATE, NULL, DEFAULT);

SELECT * FROM EMPLOYEE;

COMMIT;

-- ��� ����� ��� ��ȣ, ��� �̸�, �μ� ���� ��� �ִ� ���̺�
CREATE TABLE EMP_01(
    EMP_ID NUMBER,
    EMP_NAME VARCHAR2(30),
    DEPT_TITLE VARCHAR2(20)
);

INSERT INTO EMP_01(
    SELECT EMP_ID, EMP_NAME, DEPT_TITLE
    FROM EMPLOYEE
         LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
);

SELECT * FROM EMP_01;

-- INSERT ALL
-- INSERT �� ���� ������ ����ϴ� ���̺��� ���� ���
-- �� �� �̻��� ���̺� INSERT ALL�� �̿��Ͽ� �� ���� ���� ����
-- ��, ���������� �������� ���ƾ� ��

CREATE TABLE EMP_DEPT_D1
AS SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE
   FROM EMPLOYEE
   WHERE 1 = 0;

SELECT * FROM EMP_DEPT_D1;

CREATE TABLE EMP_MANAGER
AS SELECT EMP_ID, EMP_NAME, MANAGER_ID
   FROM EMPLOYEE
   WHERE 1 = 0;
   
SELECT * FROM EMP_MANAGER;

-- EMP_DEPT_D1���̺� EMPLOYEE���̺� �ִ� �μ��ڵ尡 D1�� ������ ��ȸ�Ͽ� ���, �̸�, �ҼӺμ�, �Ի��� ����
-- EMP_MANAGER���̺� EMPLOYEE���̺� �ִ� �μ��ڵ尡 D1�� ������ ��ȸ�Ͽ� ���, �̸�, ������ ��� ����
INSERT INTO EMP_DEPT_D1(
    SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE
    FROM EMPLOYEE
    WHERE DEPT_CODE = 'D1'
);

INSERT INTO EMP_MANAGER(
    SELECT EMP_ID, EMP_NAME, MANAGER_ID
    FROM EMPLOYEE
    WHERE DEPT_CODE = 'D1'
);

SELECT * FROM EMP_DEPT_D1;
SELECT * FROM EMP_MANAGER;

ROLLBACK;

INSERT ALL
INTO EMP_DEPT_D1 VALUES(EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE)
INTO EMP_MANAGER VALUES(EMP_ID, EMP_NAME, MANAGER_ID)
    SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE, MANAGER_ID
    FROM EMPLOYEE
    WHERE DEPT_CODE = 'D1';
    
-- EMPLOYEE���̺��� ������ �����Ͽ� ���, �̸�, �Ի���, �޿��� ����� �� �ִ� EMP_OLD���̺�, EMP_NEW���̺� ����
CREATE TABLE EMP_OLD
AS SELECT EMP_ID, EMP_NAME, HIRE_DATE, SALARY
   FROM EMPLOYEE
   WHERE 1 = 0;
CREATE TABLE EMP_NEW
AS SELECT EMP_ID, EMP_NAME, HIRE_DATE, SALARY
   FROM EMPLOYEE
   WHERE 1 = 0;
   
-- EMPLOYEE���̺��� �Ի��� �������� 2000�� 1�� 1�� ������ �Ի��� �����
-- ���, �̸�, �Ի���, �޿��� ��ȸ�ؼ� EMP_OLD���̺� ����
-- ���Ŀ� �Ի��� ����� ������ EMP_NEW���̺� ����
INSERT INTO EMP_OLD(
    SELECT EMP_ID, EMP_NAME, HIRE_DATE, SALARY
    FROM EMPLOYEE
    WHERE HIRE_DATE < '2000/01/01'
);
INSERT INTO EMP_NEW(
    SELECT EMP_ID, EMP_NAME, HIRE_DATE, SALARY
    FROM EMPLOYEE
    WHERE HIRE_DATE >= '2000/01/01'
);

SELECT * FROM EMP_OLD;
SELECT * FROM EMP_NEW;

ROLLBACK;

INSERT ALL
WHEN HIRE_DATE < '2000/01/01'
    THEN INTO EMP_OLD VALUES(EMP_ID, EMP_NAME, HIRE_DATE, SALARY)
ELSE
    INTO EMP_NEW VALUES(EMP_ID, EMP_NAME, HIRE_DATE, SALARY)
SELECT EMP_ID, EMP_NAME, HIRE_DATE, SALARY
FROM EMPLOYEE;

-- UPDATE : ���̺� ��ϵ� �÷��� �� ����(��ü �� �������� ��ȯ ����)
-- UPDATE ���̺��
-- SET �÷��� = �ٲܰ�
-- [WHERE �÷��� �� ������ �񱳰�];

CREATE TABLE DEPT_COPY
AS SELECT * FROM DEPARTMENT;

SELECT * FROM DEPT_COPY;

-- DEPT_COPY���̺��� DEPT_ID�� 'D9'�� ���� DEPT_TITLE�� '������ȹ��'���� ����
UPDATE DEPT_COPY
SET DEPT_TITLE = '������ȹ��';

SELECT * FROM DEPT_COPY;

ROLLBACK;

UPDATE DEPT_COPY
SET DEPT_TITLE = '������ȹ��'
WHERE DEPT_ID = 'D9';

COMMIT;

-- ���� ����� �޿��� ���ʽ� ���� ����� ����� �����ϰ� ����
CREATE TABLE EMP_SALARY
AS SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY, BONUS
    FROM EMPLOYEE;
    
SELECT * FROM EMP_SALARY;

SELECT * FROM EMP_SALARY
WHERE EMP_NAME IN('�����', '����');

UPDATE EMP_SALARY
SET SALARY = (SELECT SALARY
              FROM EMPLOYEE
              WHERE EMP_NAME = '�����'),
    BONUS = (SELECT BONUS
             FROM EMPLOYEE
             WHERE EMP_NAME = '�����')
WHERE EMP_NAME = '����';

UPDATE EMP_SALARY
SET (SALARY, BONUS) = (SELECT SALARY, BONUS
                       FROM EMP_SALARY
                       WHERE EMP_NAME = '�����')
WHERE EMP_NAME IN('���ö', '������', '������', '�ϵ���');

SELECT * 
FROM EMP_SALARY
WHERE EMP_NAME IN('�����', '����', '���ö', '������', '������', '�ϵ���');

-- EMP_SALARY���̺��� �ƽþ������� �ٹ��ϴ� ������ ���ʽ��� 0.3���� ����
-- �ƽþ� ������ �ٹ��ϴ� ������ ���, �̸�, �޿�, ���ʽ�, �ٹ����� ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY, BONUS, LOCAL_NAME
FROM EMP_SALARY
     LEFT JOIN DEPT_COPY ON(DEPT_CODE = DEPT_ID)
     JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE)
WHERE LOCAL_NAME LIKE '%ASIA%';

UPDATE EMP_SALARY
SET BONUS = 0.3
WHERE EMP_ID IN (SELECT EMP_ID
                 FROM EMP_SALARY
                 LEFT JOIN DEPT_COPY ON(DEPT_CODE = DEPT_ID)
                 JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE)
                 WHERE LOCAL_NAME LIKE '%ASIA%');
                 
SELECT * FROM EMP_SALARY;

COMMIT;

-- UPDATE �� ���ǻ���! : UPDATE�� �� ������ ���� �ش� �÷��� ���� �������ǿ� ������� �ʾƾ� ��

-- EMPLOYEE���̺��� DEPT_CODE�� �ܷ�Ű �������� �߰�
-- ���� ���̺��� DEPARTMENT, ���� �÷��� DEPARTMENT�� �⺻ Ű
ALTER TABLE EMPLOYEE ADD FOREIGN KEY(DEPT_CODE) REFERENCES DEPARTMENT;

UPDATE EMPLOYEE
SET DEPT_CODE = '65'
WHERE DEPT_CODE = 'D6';
-- ORA-02291: integrity constraint (KH.SYS_C007129) violated - parent key not found

SELECT * FROM EMPLOYEE;

ROLLBACK;

UPDATE DEPARTMENT
SET LOCATION_ID = '65'
WHERE LOCATION_ID = 'L2';
-- ORA-02291: integrity constraint (KH.SYS_C007106) violated - parent key not found

UPDATE EMPLOYEE
SET EMP_NAME = NULL
WHERE EMP_ID = 200;
-- ORA-01407: cannot update ("KH"."EMPLOYEE"."EMP_NAME") to NULL

-- DELETE : ���̺��� ���� �����ϴ� ����(���̺��� �� ������ �پ��)
-- DELETE FROM ���̺� �� WHERE ���� ����
-- ���� WHERE���� ������ ���� ������ ��� ���� �� ������

COMMIT;

SELECT * FROM EMPLOYEE;

DELETE FROM EMPLOYEE
WHERE EMP_NAME = '��ä��';

SELECT * FROM EMPLOYEE;

ROLLBACK;

SELECT * FROM EMPLOYEE;

DELETE FROM EMPLOYEE;

SELECT * FROM EMPLOYEE;

ROLLBACK;

SELECT * FROM EMPLOYEE;

DELETE FROM DEPARTMENT
WHERE DEPT_ID = 'D1';

ALTER TABLE EMPLOYEE
DISABLE CONSTRAINT SYS_C007129 CASCADE;

SELECT * FROM DEPARTMENT;
SELECT * FROM EMPLOYEE;

ALTER TABLE EMPLOYEE
ENABLE CONSTRAINT SYS_C007129; -- �ٽ� Ȱ��ȭ �� �� ��� �����Ͱ� �������ǿ� �¾ƾ� ��

-- TRUNCATE : ���̺� ��ü �� ���� �� ���
--            DELETE���� ����ӵ��� �� ����
--            ROLLBACK�� ���� ���� �Ұ���

SELECT * FROM EMP_SALARY;
COMMIT;

DELETE FROM EMP_SALARY;
SELECT * FROM EMP_SALARY;
ROLLBACK;
SELECT * FROM EMP_SALARY;

TRUNCATE TABLE EMP_SALARY;
SELECT * FROM EMP_SALARY;
ROLLBACK;
SELECT * FROM EMP_SALARY;
----------------------------------------------------------
