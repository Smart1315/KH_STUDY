-- PL/SQL (Procedural Language extension to SQL)
-- ����Ŭ ��ü�� ����Ǿ� �ִ� ������ ���
-- SQL���� ������ ������ ����, ����ó��(IF), �ݺ�ó��(LOOP, FOR, WHILE)���� �����Ͽ� SQL�� ���� ����

-- PL/SQL�� ����
-- �����(DECLARE SECTION) : DECLARE�� ����, ����/��� ����
-- �����(EXECUTABLE SECTION) : BEGIN���� ����, ���/�ݺ���/�Լ� ���� �� ���� ���
-- ����ó����(EXCEPTION SECTION) : EXCEPTION���� ����, ���� �߻� �� �ذ��ϱ� ���� ���� ���

-- PL/SQL�� ����
-- BLOCK������ �ټ��� SQL���� �� ���� ORACLE DB�� ���� ó���ϹǷ� ���� �ӵ� ���
-- �ܼ�, ������ ������ ������ ���� �� ���̺��� ������ ����ȭ �÷� �� ���Ͽ� �������� ���� ���� ����

SET SERVEROUTPUT ON;
-- ����ϴ� ������ ȭ�鿡 �����ֵ��� �����ϴ� ȯ�溯���� ON���� ����(�⺻ �� OFF)

-- ȭ�鿡 HELLO WORLD ���
-- System.out.println("Hello World");
BEGIN
    DBMS_OUTPUT.PUT_LINE('Hello World');
END;
/

-- Ÿ�� ���� ����
-- ���� ���� �� �ʱ�ȭ, ���� �� ���
DECLARE
    EMP_ID NUMBER; -- int emp_id;
    EMP_NAME VARCHAR2(20); -- String emp_name
    
    PI CONSTANT NUMBER := 3.14; -- final int PI = 3.14;
    --                 := ���� ���� ������
BEGIN
    EMP_ID := 888;
    EMP_NAME := '���峲';
    DBMS_OUTPUT.PUT_LINE('EMP_ID : ' || EMP_ID);
    -- System.out.println("emp_id : " + emp_id);
    DBMS_OUTPUT.PUT_LINE('EMP_NAME : ' || EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('PI : ' || PI);
END;
/

-- ���۷��� ������ ����� �ʱ�ȭ, ���� �� ���
DECLARE
    ID EMPLOYEE.EMP_ID%TYPE;
    -- ���� EMP_ID�� Ÿ���� EMPLOYEE���̺��� EMP_ID�÷�Ÿ������ ����
    NAME EMPLOYEE.EMP_NAME%TYPE;
    
BEGIN
    SELECT EMP_ID, EMP_NAME
    INTO ID, NAME
    FROM EMPLOYEE
    WHERE EMP_ID = '&���';
    
    DBMS_OUTPUT.PUT_LINE('EMP_ID : ' || ID);
    DBMS_OUTPUT.PUT_LINE('EMP_NAME : ' || NAME);
END;
/

-- ���۷��� ������ EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, SALARY�� �����ϰ�
-- EMPLOYEE���̺��� ���, �̸�, �����ڵ�, �μ��ڵ�, �޿��� ��ȸ �� ������ ���۷��� ������ ��� ����Ͻÿ�
-- ��, �Է� ���� �̸��� ��ġ�ϴ� ������ ������ ��ȸ�ϼ���.
DECLARE
    EMP_ID EMPLOYEE.EMP_ID%TYPE;
    EMP_NAME EMPLOYEE.EMP_NAME%TYPE;
    DEPT_CODE EMPLOYEE.DEPT_CODE%TYPE;
    JOB_CODE EMPLOYEE.JOB_CODE%TYPE;
    SALARY EMPLOYEE.SALARY%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, SALARY
    INTO EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, SALARY
    FROM EMPLOYEE
    WHERE EMP_NAME = '&�̸�';
    
    DBMS_OUTPUT.PUT_LINE('EMP_ID : ' || EMP_ID);
    DBMS_OUTPUT.PUT_LINE('EMP_NAME : ' || EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('DEPT_CODE : ' || DEPT_CODE);
    DBMS_OUTPUT.PUT_LINE('JOB_CODE : ' || JOB_CODE);
    DBMS_OUTPUT.PUT_LINE('SALARY : ' || SALARY);
END;
/

-- �� �࿡ ���� ROWTYPE ���� ����� �ʱ�ȭ
DECLARE
    E EMPLOYEE%ROWTYPE;
BEGIN
    SELECT * 
    INTO E
    FROM EMPLOYEE
    WHERE EMP_ID = '&���';
    
    DBMS_OUTPUT.PUT_LINE('EMP_ID : ' || E.EMP_ID);
    DBMS_OUTPUT.PUT_LINE('EMP_NAME : ' || E.EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('EMP_NO : ' || E.EMP_NO);
    DBMS_OUTPUT.PUT_LINE('SALARY : ' || E.SALARY);
END;
/

-- ���ù�(���ǹ�)
-- IF ~ THEN ~ END IF (���� IF��)
-- EMP_ID�� �Է¹��� �ش� ����� ���, �̸�, �޿�, ���ʽ� �� ���
-- ��, ���ʽ��� ���� �ʴ� ����� ���ʽ� �� ��� �� '���ʽ��� ���޹��� �ʴ� ����Դϴ�' ���
DECLARE
    EMP_ID EMPLOYEE.EMP_ID%TYPE;
    EMP_NAME EMPLOYEE.EMP_NAME%TYPE;
    SALARY EMPLOYEE.SALARY%TYPE;
    BONUS EMPLOYEE.BONUS%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME, SALARY, BONUS
    INTO EMP_ID, EMP_NAME, SALARY, BONUS
    FROM EMPLOYEE
    WHERE EMP_ID = '&���';
    
    DBMS_OUTPUT.PUT_LINE('EMP_ID : ' || EMP_ID);
    DBMS_OUTPUT.PUT_LINE('EMP_NAME : ' || EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('SALARY : ' || SALARY);
    
    IF(BONUS IS NULL)
        THEN DBMS_OUTPUT.PUT_LINE('���ʽ��� ���޹��� �ʴ� ����Դϴ�.');
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('BONUS : ' || BONUS * 100 || '%');
END;
/

-- IF ~ THEN ~ ELSE ~ END IF R(IF ~ ELSE��)
-- EMP_ID�� �Է� �޾� �ش� ����� ���, �̸�, �μ���, �Ҽ� ���
-- TEAM ������ ����� �Ҽ��� 'KO'�� ������ '������' �ƴ� ����� '�ؿ���' ����
DECLARE
    EMP_ID EMPLOYEE.EMP_ID%TYPE;
    EMP_NAME EMPLOYEE.EMP_NAME%TYPE;
    DEPT_TITLE DEPARTMENT.DEPT_TITLE%TYPE;
    NATIONAL_CODE LOCATION.NATIONAL_CODE%TYPE;
    
    TEAM VARCHAR2(20);
BEGIN
    SELECT EMP_ID, EMP_NAME, DEPT_TITLE, NATIONAL_CODE
    INTO EMP_ID, EMP_NAME, DEPT_TITLE, NATIONAL_CODE
    FROM EMPLOYEE
         LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
         JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE)
    WHERE EMP_ID = '&���';
    
    IF(NATIONAL_CODE = 'KO')
        THEN TEAM := '������';
    ELSE
        TEAM := '�ؿ���';
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('��� : ' || EMP_ID);
    DBMS_OUTPUT.PUT_LINE('�̸� : ' || EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('�μ� : ' || DEPT_TITLE);
    DBMS_OUTPUT.PUT_LINE('�Ҽ� : ' || NATIONAL_CODE);
    DBMS_OUTPUT.PUT_LINE('���� : ' || TEAM);
END;
/

-- ����� ������ ���ϴ� PL/SQL �ۼ�
-- ���ʽ��� �ִ� ����� ���ʽ��� �����Ͽ� ���
-- �޿� �̸� ����(���ʽ� ����, ��999,999,999 �������� ���)
-- ������ ���� ������ ���� ����
DECLARE
    EMP_NAME EMPLOYEE.EMP_NAME%TYPE;
    SALARY EMPLOYEE.SALARY%TYPE;
    
    YSALARY NUMBER;
BEGIN
    SELECT EMP_NAME, SALARY, (SALARY + (SALARY * NVL(BONUS, 0))) * 12
    INTO EMP_NAME, SALARY, YSALARY
    FROM EMPLOYEE
    WHERE EMP_ID = '&���';
    
    DBMS_OUTPUT.PUT_LINE('�̸� : ' || EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('�޿� : ' || TO_CHAR(SALARY, 'FML999,999,999'));
    DBMS_OUTPUT.PUT_LINE('���� : ' || TO_CHAR(YSALARY, 'FML999,999,999'));
    
END;
/

DECLARE
    VEMP EMPLOYEE%ROWTYPE;
    
    YSALARY NUMBER;
BEGIN
    SELECT *
    INTO VEMP
    FROM EMPLOYEE
    WHERE EMP_ID = '&���';
    
    IF(VEMP.BONUS IS NULL)
        THEN YSALARY := VEMP.SALARY * 12;
    ELSE
        YSALARY := VEMP.SALARY * (1 + VEMP.BONUS) * 12;
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('�̸� : ' || VEMP.EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('�޿� : ' || TO_CHAR(VEMP.SALARY, 'FML999,999,999'));
    DBMS_OUTPUT.PUT_LINE('���� : ' || TO_CHAR(YSALARY, 'FML999,999,999'));
    
END;
/

-- IF ~ THEN ELSIF ~ ELSE ~ END IF(IF ~ ELSE IF ~ ELSE��)
-- ������ �Է¹޾� SCORE������ ����
-- 90�� �̻��� 'A', 80�� �̻��� 'B', 70�� �̻��� 'C', 60�� �̻��� 'D', 60�� �̸��� 'F'�� ó���Ͽ� GRADE���� ����
-- ����� ������ 90���̰�, ������ A�����Դϴ�
DECLARE
    SCORE INT;
    GRADE VARCHAR2(2);
BEGIN
    SCORE := '&����';
    
    IF(SCORE >= 90)
        THEN GRADE := 'A';
    ELSIF(SCORE >= 80)
        THEN GRADE := 'B';
    ELSIF(SCORE >= 70)
        THEN GRADE := 'C';
    ELSIF(SCORE >= 60)
        THEN GRADE := 'D';
    ELSE GRADE := 'F';
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('����� ������ ' || SCORE || '���̰�, ������ ' || GRADE || '�����Դϴ�');
    
    
END;
/

-- CASE ~ WHEN ~ THEN ~ END(SWITCH ~ CASE��)
-- ����� �Է��Ͽ� �ش� ����� ���, �̸�, �μ� �� ���
DECLARE
    EMP EMPLOYEE%ROWTYPE;
    DNAME VARCHAR2(20);
BEGIN
    SELECT *
    INTO EMP
    FROM EMPLOYEE
    WHERE EMP_ID = '&���';
    
    DNAME := CASE EMP.DEPT_CODE
                WHEN 'D1' THEN '�λ������'
                WHEN 'D2' THEN 'ȸ�������'
                WHEN 'D3' THEN '�����ú�'
                WHEN 'D4' THEN '����������'
                WHEN 'D5' THEN '�ؿܿ���1��'
                WHEN 'D6' THEN '�ؿܿ���2��'
                WHEN 'D7' THEN '�ؿܿ���3��'
                WHEN 'D8' THEN '���������'
                WHEN 'D9' THEN '�ѹ���'
            END;
    DBMS_OUTPUT.PUT_LINE('��� �̸� �μ���');
    DBMS_OUTPUT.PUT_LINE(EMP.EMP_ID || ' ' || EMP.EMP_NAME || ' ' || DNAME);
END;
/

DECLARE
    EMP EMPLOYEE%ROWTYPE;
    DNAME VARCHAR2(20);
BEGIN
    SELECT *
    INTO EMP
    FROM EMPLOYEE
    WHERE EMP_ID = '&���';
    
    IF(EMP.DEPT_CODE = 'D1')
        THEN DNAME := '�λ������';
    ELSIF(EMP.DEPT_CODE = 'D2')
        THEN DNAME := 'ȸ�������';
    ELSIF(EMP.DEPT_CODE = 'D3')
        THEN DNAME := '�����ú�';
    ELSIF(EMP.DEPT_CODE = 'D4')
        THEN DNAME := '����������';
    ELSIF(EMP.DEPT_CODE = 'D5')
        THEN DNAME := '�ؿܿ���1��';
    ELSIF(EMP.DEPT_CODE = 'D6')
        THEN DNAME := '�ؿܿ���2��';
    ELSIF(EMP.DEPT_CODE = 'D7')
        THEN DNAME := '�ؿܿ���3��';
    ELSIF(EMP.DEPT_CODE = 'D8')
        THEN DNAME := '���������';
    ELSE DNAME := '�ѹ���';
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('��� �̸� �μ���');
    DBMS_OUTPUT.PUT_LINE(EMP.EMP_ID || ' ' || EMP.EMP_NAME || ' ' || DNAME);
END;
/

-- �ݺ���
-- BASIC LOOP
-- ���ο� ó���� �ۼ��ϰ� �������� LOOP�� ��� ���� ���
-- 1���� 5���� ���������� ���
DECLARE
    N NUMBER := 1;
    LCOUNT NUMBER := 5;
BEGIN
    LOOP
        DBMS_OUTPUT.PUT(N || ' ');
        N := N + 1;
        
--        IF(N > LCOUNT) 
--           THEN EXIT;
--        END IF;
        EXIT WHEN N > LCOUNT;
    END LOOP;
    DBMS_OUTPUT.NEW_LINE;
END;
/

-- FOR LOOP
-- 1���� 5���� ���
BEGIN
    FOR N IN 1..5 LOOP
        DBMS_OUTPUT.PUT_LINE(N);
    END LOOP;
END;
/

-- 1���� 5���� �Ųٷ� ���
BEGIN
    FOR N IN REVERSE 1..5
    LOOP
        DBMS_OUTPUT.PUT_LINE(N);
    END LOOP;
END;
/

-- WHILE LOOP
DECLARE
    N NUMBER := 1;
BEGIN
    WHILE N <= 5
    LOOP
        DBMS_OUTPUT.PUT_LINE(N);
        N := N + 1;
    END LOOP;
END;
/

COMMIT;

BEGIN
    UPDATE EMPLOYEE
    SET EMP_ID = '&���'
    WHERE EMP_ID = 200;
EXCEPTION
    WHEN DUP_VAL_ON_INDEX
    THEN DBMS_OUTPUT.PUT_LINE('�̹� �����ϴ� ����Դϴ�.');
END;
/

DECLARE
    NAME VARCHAR2(30);
BEGIN
    SELECT EMP_NAME
    INTO NAME
    FROM EMPLOYEE
    WHERE EMP_ID = 2044;
EXCEPTION
    WHEN NO_DATA_FOUND
    THEN DBMS_OUTPUT.PUT_LINE('��ȸ ����� �����ϴ�.');
END;
/

-- 1. ����� ������ ���ϴ� PL/SQL �� �ۼ�, ���ʽ��� �ִ� ����� ���ʽ��� �����Ͽ� ���
DECLARE
    E EMPLOYEE%ROWTYPE;
    LSALARY NUMBER;
BEGIN
    SELECT * 
    INTO E
    FROM EMPLOYEE
    WHERE EMP_ID = '&���';
    
    LSALARY := (E.SALARY * (1 * NVL(E.BONUS, 0))) * 12;
    
    DBMS_OUTPUT.PUT_LINE(E.EMP_NAME || '�� ������ '|| LSALARY || '�Դϴ�.');
    
END;
/

-- 2. ������ ¦���� ���
--   2-1) FOR LOOP
DECLARE
    DAN NUMBER := 9;
BEGIN
    FOR N IN 1..DAN LOOP
        IF(MOD(N, 2) = 0)
            THEN FOR M IN 1..9 LOOP
                    DBMS_OUTPUT.PUT_LINE(N || ' X ' || M || ' = ' || N * M);
                 END LOOP;
                 DBMS_OUTPUT.NEW_LINE;
        END IF;
    END LOOP;
END;
/
--   2-2) WHILE LOOP
DECLARE
    DAN NUMBER := 9;
    N NUMBER := 1;
    M NUMBER := 1;
BEGIN
    WHILE N <= DAN
    LOOP
        IF(MOD(N, 2) = 0)
            THEN WHILE M <= 9
                 LOOP  
                    DBMS_OUTPUT.PUT(N || ' X ' || M || ' = ' || N * M || '  ');
                    M := M + 1;
                 END LOOP;
                 M := 1;
                 DBMS_OUTPUT.NEW_LINE;
        END IF;
        N := N + 1;
    END LOOP;
END;
/
