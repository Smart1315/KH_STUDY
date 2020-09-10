-- SELECT
-- Result Set : SELECT�������� �����͸� ��ȸ�� �����(��ȯ�� ����� ����)

-- EMPLOYEE���̺��� ���, �̸� �޿� ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY 
FROM EMPLOYEE;

select emp_id, emp_name, salary
from employee; -- ��ҹ��� ���� ���� -- �빮�� ����

select emp_id, emp_name, salary, ent_yn
from employee
where ent_yn = 'Y'; -- ���ͷ��� ��ҹ��� ����

-- EMPLOYEE���̺��� ��� ���� ��ȸ
SELECT EMP_ID, EMP_NAME, EMP_NO, EMAIL, PHONE, DEPT_CODE, JOB_CODE, SAL_LEVEL, SALARY, BONUS, MANAGER_ID, HIRE_DATE, ENT_DATE, ENT_YN
FROM EMPLOYEE;

SELECT * -- �ƽ�Ʈ��
FROM EMPLOYEE;

------------ �ǽ� ���� ------------
-- 1. JOB ���̺��� ��� ���� ��ȸ
SELECT JOB_CODE, JOB_NAME  
FROM JOB;

SELECT *
FROM JOB;

-- 2. JOB ���̺��� ���� �̸� ��ȸ
SELECT JOB_NAME 
FROM JOB;

-- 3. DEPARTMENT ���̺��� ��� ���� ��ȸ
SELECT DEPT_ID, DEPT_TITLE, LOCATION_ID  
FROM DEPARTMENT;

SELECT * 
FROM DEPARTMENT;

-- 4. EMPLOYEE ���̺��� ������, �̸���, ��ȭ��ȣ, ����� ��ȸ
SELECT EMP_NAME, EMAIL, PHONE, HIRE_DATE 
FROM EMPLOYEE;

-- 5. EMPLOYEE ���̺��� �����, ����̸�, ���� ��ȸ
SELECT HIRE_DATE, EMP_NAME, SALARY 
FROM EMPLOYEE;

----------------------------------
-- �÷� �� ��� ����
-- EMPLOYEE���̺��� ���� ��, ���� ��ȸ(���� = �޿� * 12)
SELECT EMP_NAME, SALARY * 12
FROM EMPLOYEE;

-- EMPLOYEEE���̺��� ������ ���� ��, ����, ���ʽ��� �߰��� ���� ��ȸ
SELECT EMP_NAME, SALARY * 12, (SALARY + (SALARY * BONUS)) * 12
FROM EMPLOYEE;

SELECT EMP_NAME, SALARY * 12, (SALARY * (1 + BONUS)) * 12
FROM EMPLOYEE;

------------ �ǽ� ���� ------------
-- 1. EMPLOYEE ���̺��� �̸�, ����, �Ѽ��ɾ�(���ʽ�����), �Ǽ��ɾ�(�Ѽ��ɾ� - (����*���� 3%)) ��ȸ
SELECT EMP_NAME, SALARY * 12, (SALARY + (SALARY * BONUS)) * 12, ((SALARY + (SALARY * BONUS)) * 12) - ((SALARY * 12) * 0.03)
FROM EMPLOYEE;

-- 2. EMPLOYEE ���̺��� �̸�, �����, �ٹ��ϼ�(���ó�¥ - �����) ��ȸ
SELECT EMP_NAME, HIRE_DATE, SYSDATE - HIRE_DATE
FROM EMPLOYEE;

----------------------------------

-- �÷� ��Ī --
-- �÷� AS ��Ī
-- �÷� "��Ī"    -- ��Ī�� Ư�����ڰ� ���Ե� ��� ������ �ֵ���ǥ(���� �����̼�) ���
-- �÷� AS "��Ī" -- ��Ī�� Ư�����ڰ� ���Ե� ��� ������ �ֵ���ǥ(���� �����̼�) ���
-- �÷� ��Ī
-- EMPLOYEE���̺��� ������ ���� ��(��Ī: �̸�), ����(��Ī: ����(��)), ���ʽ��� �߰��� ����(��Ī: �Ѽҵ�(��)) ��ȸ
SELECT EMP_NAME AS �̸�, SALARY * 12 "����(��)", (SALARY * (1 + BONUS)) * 12 AS "�Ѽҵ�(��)"
FROM EMPLOYEE;

-- 1. EMPLOYEE ���̺��� �̸�, ����, �Ѽ��ɾ�(���ʽ�����), �Ǽ��ɾ�(�Ѽ��ɾ� - (����*���� 3%)) ��ȸ
SELECT EMP_NAME �̸�, SALARY * 12 ����, (SALARY + (SALARY * BONUS)) * 12 �Ѽ��ɾ�, ((SALARY + (SALARY * BONUS)) * 12) - ((SALARY * 12) * 0.03) �Ǽ��ɾ�
FROM EMPLOYEE;

-- 2. EMPLOYEE ���̺��� �̸�, �����, �ٹ��ϼ�(���ó�¥ - �����) ��ȸ
SELECT EMP_NAME �̸�, HIRE_DATE �����, SYSDATE - HIRE_DATE �ٹ��ϼ�
FROM EMPLOYEE;

-- ���ͷ� : ' '
-- EMPLOYEE���̺��� ������ ���� ��ȣ, ��� ��, �޿�, ����(������ �� : ��) ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY, '��'
FROM EMPLOYEE;

-- DISTINCT : �ߺ� ���� �� ������ ǥ���ϰ��� �� �� ��� -- SELECT������ �� ���� ��밡���ϸ� �� �÷��� �������� �Ұ�
-- EMPLOYEE���̺��� ������ ���� �ڵ� ��ȸ
SELECT JOB_CODE
FROM EMPLOYEE;

SELECT DISTINCT JOB_CODE
FROM EMPLOYEE;

-- EMPLOYEE���̺��� �μ��ڵ�� �����ڵ� ��ȸ
SELECT DISTINCT DEPT_CODE, JOB_CODE
FROM EMPLOYEE;

-- WHERE��: ��ȸ�� ���̺��� ������ �´� ���� ���� ���� ���
-- �� ������
-- = ����, > ũ��, < �۴�, >= ũ�ų� ����, <= �۰ų� ����, != ^= <> ���� �ʴ�

-- EMPLOYEE���̺��� �μ��ڵ尡 D9�� ������ �̸�, �μ��ڵ� ��ȸ
SELECT EMP_NAME, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9';

-- EMPLOYEE���̺��� �޿��� 4000000�̻��� ������ �̸�, �޿� ��ȸ
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE SALARY >= 4000000;

-- EMPLOYEE���̺��� �μ��ڵ尡 D9�� �ƴ� ����� ���, �̸�, �μ��ڵ� ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_CODE
FROM EMPLOYEE
--WHERE DEPT_CODE <> 'D9'
--WHERE DEPT_CODE != 'D9'
WHERE DEPT_CODE ^= 'D9';

-- EMPLOYEE���̺��� ��� ���ΰ� N�� ������ ��ȸ�ϰ� �ٹ� ���θ� ���������� ǥ���Ͽ� ���, �̸�, �����, �ٹ� ���� ��ȸ
SELECT EMP_ID, EMP_NAME, HIRE_DATE, '������' "�ٹ� ����"
FROM EMPLOYEE
WHERE ENT_YN = 'N';

------------ �ǽ� ���� ------------
-- 1. EMPLOYEE ���̺��� ������ 3000000�̻��� ����� �̸�, ����, ����� ��ȸ
SELECT EMP_NAME, SALARY, HIRE_DATE
FROM EMPLOYEE
WHERE SALARY >= 3000000;

-- 2. EMPLOYEE ���̺��� SAL_LEVEL�� S1�� ����� �̸�, ����, �����, ����ó ��ȸ
SELECT EMP_NAME, SALARY, HIRE_DATE, PHONE
FROM EMPLOYEE
WHERE SAL_LEVEL = 'S1';

-- 3. EMPLOYEE ���̺��� �Ǽ��ɾ�(�Ѽ��ɾ� - (���� * ���� 3%))�� 5õ���� �̻��� ����� �̸�, ����, �Ǽ��ɾ�, ����� ��ȸ
SELECT EMP_NAME, SALARY, ((SALARY * (1 + BONUS)) * 12) - ((SALARY * 12) * 0.03), HIRE_DATE
FROM EMPLOYEE
WHERE ((SALARY * (1 + BONUS)) * 12) - ((SALARY * 12) * 0.03) >= 50000000;

----------------------------------

-- �� ������ AND OR
-- EMPLOYEE���̺��� �μ��ڵ尡 'D6'�̰� �޿��� 3�鸸���� ���� �޴� ������ �̸�, �μ��ڵ�, �޿� ��ȸ
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D6' AND SALARY > 3000000;

-- EMPLOYEE���̺��� �μ��ڵ尡 'D6'�̰ų� �޿��� 3�鸸���� ���� �޴� ������ �̸�, �μ��ڵ�, �޿� ��ȸ
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D6' OR SALARY > 3000000;

-- EMPLOYEE���̺��� �޿��� 350�� �̻� 600�� ���ϸ� �޴� ������ ���, �̸�, �޿�, �μ��ڵ�, �����ڵ� ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY, DEPT_CODE, JOB_CODE
FROM EMPLOYEE
WHERE SALARY >= 3500000 AND SALARY <= 6000000;

------------ �ǽ� ���� ------------
-- 1. EMPLOYEE ���̺� ������ 4000000�̻��̰� JOB_CODE�� J2�� ����� ��ü ���� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE SALARY >= 4000000 AND JOB_CODE = 'J2';

-- 2. EMPLOYEE ���̺� DEPT_CODE�� D9�̰ų� D5�� ��� �� ������� 02�� 1�� 1�Ϻ�Ÿ ���� ����� �̸�, �μ��ڵ�, ����� ��ȸ
SELECT EMP_NAME, DEPT_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE (DEPT_CODE = 'D9' OR DEPT_CODE = 'D5') AND HIRE_DATE < '02/01/01';

----------------------------------

-- BETWEEN ��1 AND ��2 : ��1 �̻� ��2 ����
-- �޿��� 3500000�̻� �ް� 6000000���Ϸ� �޴� ����� �̸�, �޿� ��ȸ
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE SALARY >= 3500000 AND SALARY <= 6000000;

SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE SALARY BETWEEN 3500000 AND 6000000;

-- �ݴ�� �޿��� 350�� �̸�, �Ǵ� 600�� �ʰ��ϴ� ������ ���, �̸�, �޿�, �μ��ڵ�, �����ڵ� ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY, DEPT_CODE, JOB_CODE
FROM EMPLOYEE
WHERE SALARY < 3500000 OR SALARY > 6000000;

SELECT EMP_ID, EMP_NAME, SALARY, DEPT_CODE, JOB_CODE
FROM EMPLOYEE
WHERE SALARY NOT BETWEEN 3500000 AND 6000000;

SELECT EMP_ID, EMP_NAME, SALARY, DEPT_CODE, JOB_CODE
FROM EMPLOYEE
WHERE NOT SALARY BETWEEN 3500000 AND 6000000;

------------ �ǽ� ���� ------------
-- 1. EMPLOYEE ���̺� ������� 90/01/01 ~ 01/01/01�� ����� ��ü ������ ��ȸ
SELECT *
FROM EMPLOYEE
WHERE HIRE_DATE BETWEEN '90/01/01' AND '01/01/01';

----------------------------------

-- LIKE : Ư�� ���� ������ ������Ű���� Ȯ��
-- LIKE���� ����� �� �ִ� ���ϵ� ī�� % _
-- % : 0���� �̻�
-- _ : 1����
-- '����%' : '����'�� �����ϴ� ��
-- '%����' : '����'�� ������ ��
-- '��%��' : '��'�� �����ؼ� '��'�� ������ ��
-- '%����%' : '����'�� ���Ե� ��
-- '_' : �ѱ���
-- '__' : �α���
-- '___' : ������

-- EMPLOYEE���̺��� ���� ������ ����� ���, �̸�, ����� ��ȸ
SELECT EMP_ID, EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '��%';

-- EMPLOYEE���̺��� �̸��� '��'�� ���Ե� ������ �̸�, �ֹι�ȣ, �μ��ڵ� ��ȸ
SELECT EMP_NAME, EMP_NO, DEPT_CODE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%��%';

-- EMPLOYEE���̺��� ��ȭ��ȣ �׹�° �ڸ��� 9�� �����ϴ� ����� ���, �̸�, ��ȭ��ȣ ��ȸ
SELECT EMP_NO, EMP_NAME, PHONE
FROM EMPLOYEE
WHERE PHONE LIKE '___9%';

-- EMPLOYEE���̺��� �̸��� �� _�� �ձ��ڰ� 3�ڸ��� �̸��� �ּҸ� ���� ����� ���, �̸��� �ּ� ��ȸ
SELECT EMP_ID, EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE EMAIL LIKE '____%';
-- ���ϰ� Ư����ȣ�� �������� ���ϱ� ������ ESCAPE OPTION�� ���� ����
SELECT EMP_ID, EMP_NAME, EMAIL
FROM EMPLOYEE
--WHERE EMAIL LIKE '___ _%' ESCAPE ' ';
WHERE EMAIL LIKE '___\_%' ESCAPE '\';

-- : Ư�� ������ ������Ű�� �ʴ� �� ��ȸ
-- EMPLOYEE���̺��� �达 ���� �ƴ� ������ ���, �̸�, ����� ��ȸ
SELECT EMP_ID, EMP_NAME, HIRE_DATE
FROM EMPLOYEE
--WHERE NOT EMP_NAME LIKE '��%';
WHERE EMP_NAME NOT LIKE '��%';

------------ �ǽ� ���� ------------
-- 1. EMPLOYEE ���̺��� �̸� ���� '��'���� ������ ����� �̸� ��ȸ
SELECT EMP_NAME
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%��';

-- 2. EMPLOYEE ���̺��� ��ȭ��ȣ ó�� 3�ڸ��� 010�� �ƴ� ����� �̸�, ��ȭ��ȣ�� ��ȸ
SELECT EMP_NAME, PHONE
FROM EMPLOYEE
WHERE PHONE NOT LIKE '010%';

-- 3. EMPLOYEE ���̺��� �����ּ� '_'�� ���� 4�� �̸鼭 DEPT_CODE�� D9 �Ǵ� D6�̰�
--    ������� 90/01/01 ~ 00/12/01�̰�, �޿��� 270�� �̻��� ����� ��ü�� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE EMAIL LIKE '____\_%' ESCAPE '\' 
    AND (DEPT_CODE = 'D9' OR DEPT_CODE = 'D6') 
    AND HIRE_DATE BETWEEN '90/01/01' AND '00/12/01' 
    AND SALARY >= 2700000;

----------------------------------

-- IS NULL / IS NOT NULL
-- IS NULL : �÷� ���� NULL�� ���
-- IS NOT NULL : �÷� ���� NOLL�� �ƴ� ���

-- EMPLOYEE���̺��� ���ʽ��� ���� �ʴ� ����� ���, �̸�, �޿�, ���ʽ� ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY, BONUS
FROM EMPLOYEE
WHERE BONUS IS NULL;

-- EMPLOYEE���̺��� ���ʽ��� �޴� ����� ���, �̸�, �޿�, ���ʽ� ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY, BONUS
FROM EMPLOYEE
WHERE BONUS IS NOT NULL;

-- EMPLOYEE���̺��� �����ڵ� ���� �μ� ��ġ�� ���� ���� ������ �̸�, ������, �μ��ڵ� ��ȸ
SELECT EMP_NAME, MANAGER_ID, DEPT_CODE
FROM EMPLOYEE
WHERE MANAGER_ID IS NULL AND DEPT_CODE IS NULL;

-- EMPLOYEE���̺��� �μ� ��ġ�� ���� �ʾ����� ���ʽ��� ���� �޴� ������ �̸�, ���ʽ�, �μ��ڵ� ��ȸ
SELECT EMP_NAME, BONUS, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE IS NULL AND BONUS IS NOT NULL;

-- IN : ���Ϸ��� �� ��Ͽ� ��ġ�ϴ� ���� ������ TRUE�� ��ȯ�ϴ� ������
-- D6�μ��� D9�μ������� �̸�, �μ��ڵ�, �޿� ��ȸ
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D6' OR DEPT_CODE = 'D9';

SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE IN ('D6', 'D9');

-- �����ڵ尡 J1, J2, J3, J4�� ������� �̸�, �����ڵ�, �޿� ��ȸ
SELECT EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE JOB_CODE = 'J1' 
    OR JOB_CODE = 'J2' 
    OR JOB_CODE = 'J3' 
    OR JOB_CODE = 'J4';

SELECT EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE JOB_CODE IN ('J1', 'J2', 'J3', 'J4');

-- ���Ῥ���� || 
-- ���� �÷��� �ϳ��� �÷��� ��ó�� �����ϰų� �÷��� ���ͷ��� ������ �� ����
-- EMPLOYEE���̺��� ���, �̸�, �޿��� �����Ͽ� ��ȸ
SELECT EMP_ID || EMP_NAME || SALARY
FROM EMPLOYEE;

-- EMPLOYEE���̺��� '��� ���� ������ �޿��� �Դϴ�.' �������� ��ȸ
SELECT EMP_NAME || '�� ������ ' || SALARY || '�� �Դϴ�.'
FROM EMPLOYEE;
