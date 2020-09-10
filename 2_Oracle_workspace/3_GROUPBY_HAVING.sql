-- ORDER BY : ���� �� ���
-- SELECT ������ ���� �������� ��ġ, ���� ������ ���� �������� ����
SELECT EMP_ID, EMP_NAME, SALARY �޿�, DEPT_CODE
FROM EMPLOYEE
--ORDER BY EMP_NAME;
--ORDER BY EMP_NAME ASC;
--ORDER BY EMP_NAME DESC;
--ORDER BY DEPT_CODE NULLS FIRST; -- NULLS LAST �⺻��
--ORDER BY 2;
ORDER BY �޿�;

-- GROUP BY : ���� ������ ���� �� ��ϵ� �÷��� ������ ���� ������ �ϳ��� �׷����� ����
SELECT DEPT_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- EMPLOYEE���̺��� �μ� �ڵ� �� �׷��� �����Ͽ�
-- �μ� �ڵ�, �׷캰 �޿� �հ�, �׷캰 �޿� ���(����ó��), �ο��� ��ȸ�ϰ� �μ� �ڵ� ������ ����
SELECT DEPT_CODE, SUM(SALARY), ROUND(AVG(SALARY)), COUNT(*)
FROM EMPLOYEE
GROUP BY DEPT_CODE
ORDER BY DEPT_CODE;

-- EMPLOYEE���̺��� �μ��ڵ�� ���ʽ� �޴� ��� �� ��ȸ�ϰ� �μ��ڵ� ������ ����
SELECT DEPT_CODE, COUNT(BONUS)
FROM EMPLOYEE
GROUP BY DEPT_CODE
ORDER BY DEPT_CODE;

-- EMPLOYEE���̺���, �����ڵ�, ���ʽ��� �޴� ����� ���� ��ȸ�Ͽ� �����ڵ� ������ �������� ����
SELECT JOB_CODE, COUNT(BONUS)
FROM EMPLOYEE
WHERE BONUS IS NOT NULL
GROUP BY JOB_CODE
ORDER BY JOB_CODE;

-- EMPLOYEE���̺��� ������ ���� �� �޿� ���(����ó��), �޿� �հ�, �ο����� ��ȸ�ϰ� �ο����� ��������
SELECT DECODE(SUBSTR(EMP_NO, 8, 1), 1, '��', 2, '��') ����, 
       ROUND(AVG(SALARY)) ���, SUM(SALARY) �հ�, COUNT(*) �ο���
FROM EMPLOYEE
GROUP BY DECODE(SUBSTR(EMP_NO, 8, 1), 1, '��', 2, '��')
ORDER BY 4 DESC;

-- EMPLOYEE���̺��� �μ� �ڵ� ���� ���� ������ ����� �޿� �հ� ��ȸ(�μ� �ڵ� ������ ����)
SELECT DEPT_CODE, JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE, JOB_CODE
ORDER BY DEPT_CODE;

-- HAVINH : �׷��Լ��� ���� �� �׷쿡 ���� ���� ������ �� ���
-- �μ��ڵ�� �޿� 3000000�̻��� ������ �׷캰 ��� �޿� ��ȸ
SELECT DEPT_CODE, ROUND(AVG(SALARY))
FROM EMPLOYEE
WHERE SALARY >= 3000000
GROUP BY DEPT_CODE;

-- �μ��ڵ�� �޿� ����� 3000000 �̻��� �׷� ��ȸ
SELECT DEPT_CODE, ROUND(AVG(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING AVG(SALARY) >= 3000000;

-- �μ��� �׷��� �޿� �հ� �� 9�鸸���� �ʰ��ϴ� �μ��ڵ�� �޿� �հ� ��ȸ(�μ� �ڵ� ������ ����)
SELECT DEPT_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING SUM(SALARY) > 9000000
ORDER BY DEPT_CODE;

/*
    5 : SELECT �÷��� AS ��Ī, ����, �Լ���
    1 : FROM ������ ���̺� ��
    2 : WHERE �÷��� | �Լ��� �񱳿����� �񱳰�
    3 : GROUP BY �׷����� ���� �÷���
    4 : HAVING �׷� �Լ��� �񱳿����� �񱳰�
    6 : ORDER BY �÷��� | ��Ī | �÷����� ���ɹ�� [NULLS FIRST | LAST]
*/

-- �����Լ� : �׷� �� ������ ����� ���踦 ����ϴ� �Լ�
SELECT JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY ROLLUP(JOB_CODE);

-- ROLLUP
-- �׷� �� ���� ���� ������ �׷캰�� �߰��� ���� ��� ��ȯ
SELECT DEPT_CODE, JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY ROLLUP(DEPT_CODE, JOB_CODE)
ORDER BY DEPT_CODE;

-- CUBE : �׷캰 ������ ����� �����ϴ� �Լ�
-- �׷����� ������ ��� �׷쿡 ���� ����� �� �հ踦 ����
SELECT DEPT_CODE, JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY CUBE(DEPT_CODE, JOB_CODE)
ORDER BY DEPT_CODE;

-- ���� ������ : SET OPERATION
-- �������� ������ ���� �� �׿� �ش��ϴ� ���� ���� ��� ���� �����ϰ��� �� �� ���
-- UNION : ������(OR)
-- INTERSECT : ������(AND)
-- UNION ALL : ������ + ������(OR����� AND ���� ������)
-- MINUS : ������

-- UNION : ���� ���� ���� ����� �ϳ��� ������ ������(�ߺ��� ������ �����Ͽ� �ϳ��� ��ħ)
SELECT EMP_ID, EMP_NAME
FROM EMPLOYEE
WHERE EMP_ID = 200
UNION
SELECT EMP_ID, EMP_NAME
FROM EMPLOYEE
WHERE EMP_ID = 201;

SELECT EMP_ID, EMP_NAME
FROM EMPLOYEE
WHERE EMP_ID = 200 OR EMP_ID = 201;

-- UNION�� ����Ͽ� DEPT_CODE�� D5�̰ų� �޿��� 300������ �ʰ��ϴ� ������ ���, �̸�, �μ��ڵ�, �޿� ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE  SALARY > 3000000;

-- OR ���
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' OR SALARY > 3000000;

-- UNION ALL : ���� ���� ���� ����� �ϳ��� ��ġ�� ������
-- UNION���� �������� �ߺ� ������ ��� ����(������ + ������)
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION ALL
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE  SALARY > 3000000;

-- INTERSECT : ���� ���� SELECT�� ������� ���� �κи� ����� ����(������)
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
INTERSECT
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE  SALARY > 3000000;

-- MINUS : ���� SELECT������� ���� SELECT����� ��ġ�� �κ��� ������ ������ �κи� ����(������)
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
MINUS
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE  SALARY > 3000000;

SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID);

