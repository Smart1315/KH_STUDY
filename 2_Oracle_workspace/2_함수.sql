-- �Լ�(FUNCTION) : �÷��� ���� �о ����� ��� ����
-- ������ �Լ�(SINGLE ROW FUNCTION) : �÷��� ��ϵ� N���� ���� �о N���� ����� ����
-- �׷� �Լ�(GROUP FUNCTION) : �÷��� ��ϵ� N���� ���� �о 1���� ��� ����

-- SELECT���� ���� �� �Լ��� �׷� �Լ��� �Բ� ��� �� �� : ��� ���� ������ �ٸ��� ����

-- �Լ� ��� ���� ��ġ : SELECT��, WHERE��, GROUP BY��, HAVING��, ORDER BY��


-- ���� �� �Լ�
-- 1. ���� ���� �Լ�
-- LENGTH : ���� �� ��ȯ / LENGTHB : ������ ����Ʈ ������ ��ȯ
SELECT LENGTH('����Ŭ'), LENGTHB('����Ŭ') -- �ѱ� 3Byte
FROM DUAL; -- ���� ���̺�

SELECT LENGTH('ABCD'), LENGTHB('ABCD')
FROM DUAL;

SELECT LENGTH(EMAIL), LENGTHB(EMAIL)
FROM EMPLOYEE;

-- INSTR : �ش� ���ڿ��� ��ġ -- Zero-Index��� �ƴ�
SELECT INSTR('AABAACAABBAA', 'B') FROM DUAL;
SELECT INSTR('AABAACAABBAA', 'C') FROM DUAL;
SELECT INSTR('AABAACAABBAA', 'Z') FROM DUAL;

SELECT INSTR('AABAACAABBAA', 'B', 1) FROM DUAL; -- 1���� �б� �����ؼ� ó������ ������ B�� ��ġ ��ȯ
SELECT INSTR('AABAACAABBAA', 'B', -1) FROM DUAL; -- -1(��)���� �б� �����ؼ� ó������ ������ B�� ��ġ ��ȯ
SELECT INSTR('AABAACAABBAA', 'C', -1) FROM DUAL;
SELECT INSTR('AABAACAABBAA', 'B', 1, 2) FROM DUAL; -- 1���� �б� �����ؼ� �� ��°�� ������ B�� ��ġ ��ȯ
SELECT INSTR('AABAACAABBAA', 'B', -1, 2) FROM DUAL;
SELECT INSTR('AABAACAABBAA', 'C', 1, 2) FROM DUAL;

-- EMPLOYEE���̺��� �̸����� @��ġ ��ȯ
SELECT EMP_NAME, EMAIL, INSTR(EMAIL, '@')
FROM EMPLOYEE;

-- LPAD / RPAD
SELECT LPAD(EMAIL, 20)
FROM EMPLOYEE;

SELECT LPAD(EMAIL, 20, '#')
FROM EMPLOYEE;

SELECT RPAD(EMAIL, 20)
FROM EMPLOYEE;

SELECT RPAD(EMAIL, 20, '#')
FROM EMPLOYEE;

-- LOWER / UPPER / INITCAP
-- LOWER : �ҹ��ڷ� ����
-- UPPER : �빮�ڷ� ����
-- INITCAP : �ܾ��� ù���ڸ� �빮�ڷ� ��ȯ
SELECT LOWER('Welcome To My World') FROM DUAL;
SELECT UPPER('Welcome To My World') FROM DUAL;
SELECT INITCAP('welcome to my world') FROM DUAL;

-- CONCAT : ���޹��� ���ڿ��̳� �÷��� �ϳ��� ��ģ �� ��ȯ
SELECT CONCAT('�����ٶ�', 'ABCD') FROM DUAL;
SELECT '�����ٶ�' || 'ABCD' FROM DUAL;

-- LTRIM / RTRIM :  ���ڿ� Ȥ�� �÷��� ����/�����ʿ��� ������ "STR�� ���ԵǾ� �ִ� ��� ���� ����"
SELECT EMP_NAME,  PHONE, LTRIM(PHONE, '010'), EMAIL, RTRIM(EMAIL, '@kh.or.kr')
FROM EMPLOYEE;

SELECT LTRIM('   KH') FROM DUAL;
SELECT LTRIM('   KH', ' ') FROM DUAL;
SELECT LTRIM('000123456' , '0') FROM DUAL;
SELECT LTRIM('123123KH', '123') FROM DUAL;

SELECT RTRIM('KH   ') A FROM DUAL;
SELECT RTRIM('123456000', '0') FROM DUAL;
SELECT RTRIM('KH24392398472' , '0123456789') FROM DUAL;

-- TRIM : ���ڿ��� ��/��/���ʿ� �ִ� ���� ����
SELECT TRIM('   KH   ') FROM DUAL;
SELECT TRIM('Z' FROM 'ZZZKHZZZ') FROM DUAL;
SELECT TRIM('1' FROM '123321KH23212') FROM DUAL;
SELECT TRIM(LEADING 'Z' FROM 'ZZZ123345ZZZ') FROM DUAL;
SELECT TRIM(TRAILING '3' FROM '33KH333333') FROM DUAL;
SELECT TRIM(BOTH '3' FROM '33KH333333') FROM DUAL;

-- SUBSTR : �÷��̳� ���ڿ����� ������ ��ġ���� ������ ������ ���ڿ��� �߶󳻾� ��ȯ
SELECT SUBSTR('SHOWMETHEMONEY', 7) FROM DUAL;
SELECT SUBSTR('SHOWMETHEMONEY', 5, 2) FROM DUAL;
SELECT SUBSTR('SHOWMETHEMONEY', 5, 0) FROM DUAL;
SELECT SUBSTR('SHOWMETHEMONEY', 1, 6) FROM DUAL;
SELECT SUBSTR('SHOWMETHEMONEY', -8, 3) FROM DUAL;
SELECT SUBSTR('SHOWMETHEMONEY', -10, 2) FROM DUAL;
SELECT SUBSTR('��� �� �� �Ӵ�', 2, 5) FROM DUAL;

-- EMPLOYEE���̺��� �̸�, �̸���, @���ĸ� ������ ���̵� ��ȸ
SELECT EMP_NAME, EMAIL, SUBSTR(EMAIL, 1, INSTR(EMAIL, '@') - 1) ID
FROM EMPLOYEE;

-- �ֹε�Ϲ�ȣ�� �̿��Ͽ� ��/�� �Ǵ�
-- EMPLOYEE���̺��� �̸��� �ֹι�ȣ���� ������ ��Ÿ���� �κ� ��ȸ
SELECT EMP_NAME, SUBSTR(EMP_NO, 8, 1)
FROM EMPLOYEE;

-- EMPLOYEE���̺��� ���ڸ� ��ȸ(��� ��, '��')
SELECT EMP_NAME, '��'
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) = 1;

-- EMPLOYEE���̺��� ���ڸ� ��ȸ(��� ��, '��')
SELECT EMP_NAME, '��'
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) = 2;

-- EMPLOYEE���̺��� �������� �ֹι�ȣ�� �̿��Ͽ� ��� ��, ����, ����, ���� ��ȸ
SELECT EMP_NAME, SUBSTR(EMP_NO, 1, 2) ����, 
                 SUBSTR(EMP_NO, 3, 2) ����, 
                 SUBSTR(EMP_NO, 5, 2) ���� 
FROM EMPLOYEE;

-- REPLACE : �÷��� ���� Ȥ�� ���ڿ����� Ư�� ���ڿ��� ������ ���ڿ��� �ٲ� �� ��ȯ
SELECT REPLACE('����� ������ ���ﵿ', '���ﵿ', '�Ｚ��') 
FROM DUAL;

SELECT REPLACE('���� �Ⱓ���� �ݿ� ���� �� �ִ� �л��� ���� 15�� �����Դϴ�.', '15��', '5��')
FROM DUAL;

-- EMPLOYEE���̺��� �̸����� �������� gamil.com���� ����
SELECT REPLACE(EMAIL, 'kh.or.kr', 'gmail.com')
FROM EMPLOYEE;

SELECT REPLACE(EMAIL, SUBSTR(EMAIL, INSTR(EMAIL, '@') + 1), 'gmail.com')
FROM EMPLOYEE;

-- EMPLOYEE���̺��� ��� ��, �ֹι�ȣ ��ȸ
-- ��, �ֹι�ȣ�� ������ϸ� ���̰� �ϰ� '-' ���� ���� '*'�� ����
SELECT EMP_NAME, RPAD(SUBSTR(EMP_NO, 1, 7), LENGTH(EMP_NO), '*') 
FROM EMPLOYEE;

SELECT EMP_NAME, SUBSTR(EMP_NO, 1, 7) || '*******'
FROM EMPLOYEE;

SELECT EMP_NAME, REPLACE(EMP_NO, SUBSTR(EMP_NO, 8), '*******')
FROM EMPLOYEE;

-- 2. ���� ���� �Լ�
-- ABS : ���밪�� ���Ͽ� ��ȯ�ϴ� �Լ�
SELECT ABS(10.9) FROM DUAL;
SELECT ABS(-10.9) FROM DUAL;
SELECT ABS(10) FROM DUAL;
SELECT ABS(-10) FROM DUAL;

-- MOD : �������� ���ϴ� �Լ� -- ������ ���� ��ȣ�� �������� ���� ����
SELECT MOD(10, 3) FROM DUAL;
SELECT MOD(-10, 3) FROM DUAL;
SELECT MOD(10, -3) FROM DUAL;
SELECT MOD(10.9, 3) FROM DUAL;

-- ROUND : �ݿø��Ͽ� �����ϴ� �Լ�
SELECT ROUND(123.456) FROM DUAL;
SELECT ROUND(123.789) FROM DUAL;
SELECT ROUND(123.567, 0) FROM DUAL;
SELECT ROUND(123.456, 1) FROM DUAL;
SELECT ROUND(123.456, 2) FROM DUAL;
SELECT ROUND(123.456, -2) FROM DUAL;

SELECT ROUND(-10.61) FROM DUAL;

-- FLOOR : ����(������)
SELECT FLOOR(123.456) FROM DUAL;
SELECT FLOOR(123.678) FROM DUAL;

-- TRUNC : ����(����)
SELECT TRUNC(123.456) FROM DUAL;
SELECT TRUNC(123.678) FROM DUAL;
SELECT TRUNC(123.456, 1) FROM DUAL;
SELECT TRUNC(123.456, 2) FROM DUAL;
SELECT TRUNC(123.456, -1) FROM DUAL;

-- CEIL : �ø�
SELECT CEIL(123.456) FROM DUAL;
SELECT CEIL(123.789) FROM DUAL;

-- 3. ��¥ ���� �Լ�
-- SYSDATE : �ý��ۿ� ����Ǿ� �ִ� ��¥ ��ȯ
SELECT SYSDATE FROM DUAL;

-- MONTHS_BETWEEN : ���� ���� ���̸� ���ڷ� ����
-- EMPLOYEE���̺��� ����� �̸�, �Ի���, �ٹ� ���� �� ��ȸ
SELECT EMP_NAME, HIRE_DATE, MONTHS_BETWEEN(SYSDATE, HIRE_DATE)
FROM EMPLOYEE;

SELECT EMP_NAME, HIRE_DATE, ABS(MONTHS_BETWEEN(HIRE_DATE, SYSDATE))
FROM EMPLOYEE;

-- ADD_MONTHS : ��¥���� ���ڸ�ŭ ���� ���� ���Ͽ� ����
SELECT ADD_MONTHS(SYSDATE, 5) FROM DUAL;
SELECT ADD_MONTHS(SYSDATE, 3) FROM DUAL;
-- EMPLOYEE���̺��� ��� ��, �Ի���, �Ի� �� 6������ �� ��¥ ��ȸ
SELECT EMP_NAME, HIRE_DATE, ADD_MONTHS(HIRE_DATE, 6)
FROM EMPLOYEE;

-- LAST_DAY : �ش� ���� ������ ��¥ ����
SELECT SYSDATE, LAST_DAY(SYSDATE) FROM DUAL;

-- NEXT_DAY : ���� ��¥���� ���Ϸ��� ���Ͽ� ���� ����� ��¥ ����
SELECT SYSDATE, NEXT_DAY(SYSDATE, '�����') FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, 5) FROM DUAL;
-- �� �� ȭ �� �� �� ��
-- 1  2  3  4 5  6  7
SELECT SYSDATE, NEXT_DAY(SYSDATE, '��') FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, '�������� �츮 �� �̼�õ��') FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, '���ʶ� �Ⱥ��̸� �̷��� �����ѵ� ���ʴ� ��� ��ٷ� �̾��̾��̾��̾�') FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, 'THURSDAY') FROM DUAL;

ALTER SESSION SET NLS_LANGUAGE = AMERICAN;
SELECT SYSDATE, NEXT_DAY(SYSDATE, 'THU') FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, 'THUOOOOOOOOOOOOO') FROM DUAL;

ALTER SESSION SET NLS_LANGUAGE = KOREAN;

------------- �ǽ�����----------------------------
-- 1. EMPLOYEE ���̺��� �����, �Ի���-����, ����-�Ի��� ��ȸ
-- ��, ��Ī�� �ٹ��ϼ�1, �ٹ��ϼ�2�� �ϰ�
-- ��� ����ó��(����), ����� �ǵ��� ó��
SELECT EMP_NAME, ABS(FLOOR(HIRE_DATE - SYSDATE)) �ٹ��ϼ�1, FLOOR(SYSDATE - HIRE_DATE) �ٹ��ϼ�2
FROM EMPLOYEE;

-- 2. EMPLOYEE ���̺��� ����� Ȧ���� �������� ���� ��� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE MOD(EMP_ID, 2) = 1;

-- 3. EMPLOYEE ���̺��� �ٹ� ����� 20�� �̻��� ���� ���� ��ȸ
-- ��Ȯ�� 20�� �̻�
SELECT *
FROM EMPLOYEE
WHERE MONTHS_BETWEEN(SYSDATE, HIRE_DATE) / 12 >= 20;

-- 20���� �̻�
SELECT *
FROM EMPLOYEE
WHERE EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE) >= 20;

-- 4. EMPLOYEE ���̺��� �����, �Ի���, �Ի��� ���� �ٹ��ϼ��� ��ȸ
SELECT EMP_NAME, HIRE_DATE, LAST_DAY(HIRE_DATE) - ADD_MONTHS(HIRE_DATE, 0)
FROM EMPLOYEE;

SELECT EMP_NAME, HIRE_DATE, EXTRACT(DAY FROM LAST_DAY(HIRE_DATE)) - EXTRACT(DAY FROM HIRE_DATE)
FROM EMPLOYEE;
-------------------------------------------------

-- EXTRACT : ��, ��, �� ������ �����Ͽ� ����
-- EXTRACT(YEAR FROM ��¥) : ���� ����
-- EXTRACT(MONTH FROM ��¥) : �� ����
-- EXTRACT(DAY FROM ��¥) : �� ����
-- EMPLOYEE���̺��� ����� �̸�, �Ի� ����, �Ի� ��, �Ի� �� ��ȸ
SELECT EMP_NAME "�̸�",
        EXTRACT(YEAR FROM HIRE_DATE) "�Ի� ����",
        EXTRACT(MONTH FROM HIRE_DATE) "�Ի� ��",
        EXTRACT(DAY FROM HIRE_DATE) "�Ի� ��"
FROM EMPLOYEE
--ORDER BY EXTRACT(YEAR FROM HIRE_DATE);
--ORDER BY EMP_NAME;
--ORDER BY 4;
--ORDER BY "�Ի� ����";
--ORDER BY �̸�;
--ORDER BY �̸� DESC;
--ORDER BY �̸� ASC;
ORDER BY "�Ի� ����", �̸� DESC;

-- EMPLOYEE���̺��� ����� �̸�, �Ի� ��, �ٹ� ��� ��ȸ
-- ��, �ٹ� ����� ����⵵ - �Ի�⵵�� ��ȸ�ϼ���
SELECT EMP_NAME, HIRE_DATE, EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE)
FROM EMPLOYEE;

SELECT EMP_NAME, HIRE_DATE,
        FLOOR(MONTHS_BETWEEN(SYSDATE, HIRE_DATE) / 12)
FROM EMPLOYEE;

-- 4. ����ȯ �Լ�
--TO_CHAR : ��¥/���� �����͸� ���� ������ ����
SELECT TO_CHAR(1234) FROM DUAL;
SELECT TO_CHAR(1234, '99999') A FROM DUAL; -- 5ĭ, ������ ����, ��ĭ ����
SELECT TO_CHAR(1234, '00000') A FROM DUAL; -- 5ĭ, ������ ���� ��ĭ 0
SELECT TO_CHAR(1234, 'FML99999') A FROM DUAL;
SELECT TO_CHAR(1234, '$99999') A FROM DUAL;
SELECT TO_CHAR(1234, 'FM$99999') A FROM DUAL;
SELECT TO_CHAR(1234, '99,999') A FROM DUAL;
SELECT TO_CHAR(1234, 'FM99,999') A FROM DUAL;
SELECT TO_CHAR(1234, '00,000') A FROM DUAL;
SELECT TO_CHAR(1234, '999') A FROM DUAL;

-- EMPLOYEE���̺��� �����, �޿� ��ȸ (�޿��� '\9,000,000'�������� ǥ��)
SELECT EMP_NAME, TO_CHAR(SALARY, 'FML9,999,999') �޿�
FROM EMPLOYEE;

SELECT TO_CHAR(SYSDATE, 'PM HH24:MI:SS') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'AM HH:MI:SS') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'MON DY, YYYY') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD DAY') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YYYY-FMMM-DD DAY') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YEAR, Q') FROM DUAL; -- YEAR : ����� �⵵ǥ�� Q : �б�

-- ���� ��¥�� ���� ���� 4�ڸ�, 2�ڸ�, ���� �̸� ���
SELECT TO_CHAR(SYSDATE, 'YYYY'), TO_CHAR(SYSDATE, 'YY'), TO_CHAR(SYSDATE, 'YEAR') FROM DUAL;

-- ���� ��¥���� ���� ���
SELECT TO_CHAR(SYSDATE, 'MM'),
       TO_CHAR(SYSDATE, 'MONTH'),
       TO_CHAR(SYSDATE, 'MON'),
       TO_CHAR(SYSDATE, 'RM')
FROM DUAL;

-- ���� ��¥���� �ϸ� ���
SELECT TO_CHAR(SYSDATE, 'DDD'), -- ��
       TO_CHAR(SYSDATE, 'DD'), -- ��
       TO_CHAR(SYSDATE, 'D') -- ��
FROM DUAL;

-- EMPLOYEE���̺��� �̸�, �Ի��� ��ȸ
-- �Ի����� ���� ���� : 2020�� 08�� 20��(��)
SELECT EMP_NAME, TO_CHAR(HIRE_DATE, 'YYYY"��" MM"��" DD"��""("DY")"')
FROM EMPLOYEE;

-- TO_DATE : ����/���� �����͸� ��¥ �����ͷ� ��ȯ
SELECT TO_DATE('20200101', 'YYYYMMDD') FROM DUAL;
SELECT TO_DATE(20200101, 'YYYYMMDD') FROM DUAL;
SELECT TO_CHAR(TO_DATE('20200101', 'YYYYMMDD'), 'YYYY, MON') FROM DUAL;
SELECT TO_CHAR(TO_DATE('210208 215000', 'YYMMDD HH24MISS'), 'YY-MM-DD PM HH:MI:SS DY') FROM DUAL;

-- RR�� YY�� ����
-- Y�� ������ ��� �� �ڸ� ������ ���� ���� ����
-- R�� ����� ��� �� �ڸ� ������ 50 �̻��� ���� ���� ����, 50 �̸��� ���� ���� ����
SELECT TO_CHAR(TO_DATE('980504', 'YYMMDD'), 'YYYYMMDD') FROM DUAL; -- 20980504
SELECT TO_CHAR(TO_DATE('140915', 'YYMMDD'), 'YYYYMMDD') FROM DUAL; -- 20140915
SELECT TO_CHAR(TO_DATE('980504', 'RRMMDD'), 'YYYYMMDD') FROM DUAL; -- 19980504
SELECT TO_CHAR(TO_DATE('140915', 'RRMMDD'), 'YYYYMMDD') FROM DUAL; -- 20140915

-- EMPLOYEE���̺��� 2000�⵵ ���Ŀ� �Ի��� ����� ���, �̸�, �Ի��� ��ȸ
SELECT EMP_NO, EMP_NAME, HIRE_DATE
FROM EMPLOYEE
--WHERE HIRE_DATE >= '00/01/01';
WHERE HIRE_DATE >= TO_DATE(20000101, 'RRRRMMDD');

-- TO_NUMBER : ���� �����͸� ���� �����ͷ� ��ȯ
SELECT TO_NUMBER('12345789') FROM DUAL;
SELECT '123' + '456' FROM DUAL;
SELECT '123' + '456A' FROM DUAL;
SELECT '1,000,000' + '550,000' FROM DUAL;
SELECT TO_NUMBER('1,000,000', '9,999,999') + TO_NUMBER('550,000', '999,999') FROM DUAL;

-- 5. NULL ���� �Լ�
SELECT SALARY * (1 + BONUS)
FROM EMPLOYEE;

-- NVL(�÷���, �÷����� NULL�϶� �ٲ� ��)
SELECT EMP_NAME, BONUS, NVL(BONUS, 0)
FROM EMPLOYEE;

-- NVL2(�÷� ��, �ٲ� ��1, �ٲ� ��2)
-- �ش� �÷��� ���� ������ �ٲ� ��1�� ����, �÷��� ���� ������ �ٲ� ��2�� ����
-- EMPLOYEE���̺��� ���ʽ��� NULL�� ������ 0.5��, NULL�� �ƴ� ������ 0.7�� ����
SELECT EMP_NAME, BONUS, NVL2(BONUS, 0.7, 0.5)
FROM EMPLOYEE;

-- NULLIF(�񱳴��1, �񱳴��2)
-- �� ���� ���� �����ϸ� NULL, �������� ������ �񱳴��1 ��ȯ
SELECT NULLIF(123, 123), NULLIF(123, 124) FROM DUAL;

-- 6. ���� �Լ�
-- DECODE(����|�÷���, ���ǰ�1, ���ð�1, ���ǰ�2, ���ð�2, ���ǰ�3, ���ð�3, ...)
-- ���ϰ��� �ϴ� �÷��̳� ���� ���ǽİ� ������ ��� ���� ��ȯ
SELECT EMP_ID, EMP_NAME, EMP_NO, 
       DECODE(SUBSTR(EMP_NO, 8, 1), 1, '��', 2, '��') ����
FROM EMPLOYEE;

SELECT EMP_ID, EMP_NAME, EMP_NO, 
       DECODE(SUBSTR(EMP_NO, 8, 1), 1, '��', '��') ����
FROM EMPLOYEE;

-- ������ �޿��� �λ��ϰ��� �Ѵ�
-- �����ڵ尡 J7�̸� �޿��� 10% �λ�
-- �����ڵ尡 J6�̸� �޿��� 15% �λ�
-- �����ڵ尡 J5�̸� �޿��� 20% �λ�
-- �� �� ������ 5% �λ�
-- EMPLOYEE���̺��� ���� ��, �����ڵ�, �޿�, �λ� �޿� ��ȸ
SELECT EMP_NAME, JOB_CODE, SALARY, 
     DECODE(JOB_CODE, 'J7', SALARY * 1.1,
                      'J6', SALARY * 1.15,
                      'J5', SALARY * 1.2,
                      SALARY * 1.05) �λ�޿�
FROM EMPLOYEE;

-- CASE WHEN ���ǽ� THEN �����
--      WHEN ���ǽ� THEN �����
--      ELSE �����
-- END
-- ���ϰ��� �ϴ� �� �Ǵ� �÷��� ���ǽİ� ������ ��� �� ��ȯ(������ ���� �� ����)
SELECT EMP_ID, EMP_NAME, EMP_NO,
        CASE WHEN SUBSTR(EMP_NO, 8, 1) = 1 THEN '��'
             ELSE '��'
        END
FROM EMPLOYEE;

SELECT EMP_NAME, JOB_CODE, SALARY,
        CASE WHEN JOB_CODE = 'J7' THEN SALARY * 1.1
             WHEN JOB_CODE = 'J6' THEN SALARY * 1.15
             WHEN JOB_CODE = 'J5' THEN SALARY * 1.2
             ELSE SALARY * 1.05
        END �λ�޿�
FROM EMPLOYEE;

SELECT EMP_ID, EMP_NAME, SALARY, 
       CASE WHEN SALARY > 5000000 THEN '1���'
            WHEN SALARY > 3500000 THEN '2���'
            WHEN SALARY > 2000000 THEN '3���'
            ELSE '4���'
       END ���
FROM EMPLOYEE;

-- ���, �����, �޿�
-- �޿��� 500���� �̻��̸� '���'
-- �޿��� 300~500�����̸� '�߱�'
-- �� ���ϴ� '�ʱ�'���� ���ó���ϰ� ��Ī�� '����'���� �Ѵ�.
SELECT EMP_ID, EMP_NAME, SALARY,
       CASE WHEN SALARY >= 5000000 THEN '���'
            WHEN SALARY >= 3000000 THEN '�߱�'
            ELSE '�ʱ�'
       END ����
FROM EMPLOYEE;

-- �׷� �Լ�
-- SUM
-- EMPLOYEE���̺��� �� ����� �޿� ���� ��ȸ
SELECT SUM(SALARY)
FROM EMPLOYEE;

-- EMPLOYEE���̺��� ���� ����� �޿� ���� ��ȸ
SELECT SUM(SALARY)
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) = 1;

-- EMPLOYEE���̺��� �μ��ڵ尡 D5�� ������ ���ʽ� ���� ���� �հ� ��ȸ
SELECT SUM(SALARY + (SALARY * NVL(BONUS, 0)) * 12)
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5';

-- AVG : ����� ���Ͽ� ����
-- EMPLOYEE���̺��� �� ����� �޿� ��� ��ȸ
SELECT AVG(SALARY)
FROM EMPLOYEE;

-- EMPLOYEE���̺��� �� ����� ���ʽ� ����� �Ҽ� �� °�ڸ����� �ݿø��� �� ��ȸ
SELECT ROUND(AVG(NVL(BONUS, 0)), 2)
FROM EMPLOYEE;

SELECT AVG(BONUS) �⺻���, AVG(DISTINCT BONUS) �ߺ��������, AVG(NVL(BONUS, 0)) NULL��0���ιٲ����
FROM EMPLOYEE;

-- MIN
-- EMPLOYEE���̺��� ���� ���� �޿� ��ȸ
SELECT MIN(SALARY)
FROM EMPLOYEE;

-- EMPLOYEE���̺��� ���ĺ� ������ ���� ���� �̸���, ���� ���� �Ի��� ��ȸ
SELECT MIN(EMAIL), MIN(HIRE_DATE)
FROM EMPLOYEE;

-- MAX
-- EMPLOYEE���̺��� ���� ���� �޿� ��ȸ
SELECT MAX(SALARY)
FROM EMPLOYEE;

-- EMPLOYEE���̺��� ���ĺ� ������ ���� ���� �̸���, ���� �ֱ� �Ի��� ��ȸ
SELECT MAX(EMAIL), MAX(HIRE_DATE)
FROM EMPLOYEE;

-- COUNT : �� ������ ��Ʒ� ����
-- COUNT([DISTINCT] �÷���) : �ߺ��� ������ �� ������ ��Ʒ� ����
-- COUNT(*) : NULL�� ������ ��ü �� ���� ����
-- COUNT(�÷� ��) : NULL�� ������ ���� ���� ��ϵ� �� ���� ����
-- EMPLOYEE���̺��� ��ü ��� ��, �μ��ڵ尡 �ִ� ��� ��, ������� �����ִ� �μ��� �� ��ȸ
SELECT COUNT(*), COUNT(DEPT_CODE), COUNT(DISTINCT DEPT_CODE)
FROM EMPLOYEE;
