-- SUBQUERY(��������)
-- �ϳ��� SELECT�� �ȿ� ���Ե� �Ǵٸ� SELECT��
-- ��������(���� ����)�� ���� ���������� �ϴ� ������

-- �μ��ڵ尡 ���ö ����� ���� �Ҽ��� ���� ��� ��ȸ
-- 1) ������� ���ö�� ����� �μ� ��ȸ
SELECT DEPT_CODE
FROM EMPLOYEE
WHERE EMP_NAME = '���ö';

-- 2) �μ��ڵ尡 D9�� ���� ��ȸ
SELECT EMP_NAME
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9';

-- 3) 1 + 2
SELECT EMP_NAME
FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_CODE 
                   FROM EMPLOYEE 
                   WHERE EMP_NAME = '���ö');

-- �� ������ ��� �޿����� ���� �޿��� �ް� �ִ� ������ ���, �̸�, �����ڵ�, �޿� ��ȸ
-- 1) �� ������ ��� �޿� ��ȸ
SELECT AVG(SALARY)
FROM EMPLOYEE;

-- 2) 3047662.60869565217391304347826086956522���� ���� �޴� �������� ���, �̸� �����ڵ�, �޿� ��ȸ
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3047662.60869565217391304347826086956522;

-- 1 + 2
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > (SELECT AVG(SALARY)
                FROM EMPLOYEE);

-- �������� ����
-- ������ �������� : ���� ������ ��ȸ ��� ���� ������ 1�� �� ��
-- ������ �������� : ���� ������ ��ȸ ��� ���� ������ ���� ���� ��
-- ���߿� �������� : ���� SELECT���� ������ �׸� ���� ���� ���� ��
-- ������ ���߿� �������� : ��ȸ ��� �� ���� �� ���� ���� ���� ��

-- 1. ������ �������� : ���� ������ ��ȸ ��� ���� ������ 1���� ��
-- �Ϲ������� ������ �������� �տ��� �Ϲ� ������ ��� : < > <= >= = != <> ^=
-- ���ö ����� �޿����� ���� �޴� ������ ���, �̸�, �μ��ڵ�, �����ڵ�, �޿� ��ȸ
-- 1) ���ö ��� �޿� ��ȸ
SELECT SALARY
FROM EMPLOYEE
WHERE EMP_NAME = '���ö';

-- 2) 3700000���� ���� �޴� ������ ���, �̸�, �μ��ڵ�, �����ڵ�, �޿� ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3700000;

-- 3) 1 + 2
SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > (SELECT SALARY
                FROM EMPLOYEE
                WHERE EMP_NAME = '���ö');
                
-- ���� ���� �޿��� �޴� ������ ���, �̸�, �����ڵ�, �μ��ڵ�, �޿�, �Ի��� ��ȸ
-- 1) ���� ���� �޿� ��ȸ
SELECT MIN(SALARY)
FROM EMPLOYEE;

-- 2) 1380000���� �޴� ������ ���, �̸�, �����ڵ�, �μ��ڵ�, �޿�, �Ի��� ��ȸ
SELECT EMP_ID, EMP_NAME, JOB_CODE, DEPT_CODE, SALARY, HIRE_DATE
FROM EMPLOYEE
WHERE SALARY = 1380000;

-- 3) 1 + 2
SELECT EMP_ID, EMP_NAME, JOB_CODE, DEPT_CODE, SALARY, HIRE_DATE
FROM EMPLOYEE
WHERE SALARY = (SELECT MIN(SALARY)
                FROM EMPLOYEE);
                
-- �� ������ �޿� ��պ��� ���� �޿��� �޴� ������ �̸�, �����ڵ�, �μ��ڵ�, �޿� ��ȸ(���� ������ ����)
-- 1) �� ������ �޿� ��� ��ȸ
SELECT AVG(SALARY)
FROM EMPLOYEE;

-- 2) 3047662.60869565217391304347826086956522���� ���� �޿��� �޴� ������ �̸�, �����ڵ�, �μ��ڵ�, �޿� ��ȸ(���� ������ ����)
SELECT EMP_NAME, JOB_CODE, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY < 3047662.60869565217391304347826086956522
ORDER BY JOB_CODE;

-- 3) 1 + 2
SELECT EMP_NAME, JOB_CODE, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY < (SELECT AVG(SALARY)
                FROM EMPLOYEE)
ORDER BY JOB_CODE;

-- �μ� �� �޿� �հ� �� ���� ū �μ��� �μ� ��, �޿� �հ� ��ȸ
-- 1) �հ谡 ���� ū �μ��� �޿� �հ�
SELECT MAX(SUM(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- 2) �μ� �� �޿� �հ�
SELECT DEPT_TITLE, SUM(SALARY)
FROM EMPLOYEE
    LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
GROUP BY DEPT_TITLE;

-- 3) 1 + 2
SELECT DEPT_TITLE, SUM(SALARY)
FROM EMPLOYEE
    LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
GROUP BY DEPT_TITLE
HAVING SUM(SALARY) = (SELECT MAX(SUM(SALARY))
                      FROM EMPLOYEE
                      GROUP BY DEPT_CODE);

SELECT DEPT_TITLE, SUM(SALARY)
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID(+)
GROUP BY DEPT_TITLE
HAVING SUM(SALARY) = (SELECT MAX(SUM(SALARY))
                      FROM EMPLOYEE
                      GROUP BY DEPT_CODE);

-- 2. ������ �������� : ���� ������ ��ȸ ��� ���� ������ ���� ���� ��
-- ������ �������� �տ��� �Ϲ� �� ������ ��� �Ұ���
-- IN / NOT IN
--      ���� ���� ��� �� �߿��� �� ���� ��ġ�ϴ� ���� �ִ�/���� ���
-- > ANY, < ANY
--      ���� ���� ��� �� �߿��� �� ���� ū/���� ���
--      ���� ���� ������ ū��/���� ū ������ ������
-- > ALL, < ALL
--      ��� ������ ū/���� ���
--      ���� ���� ������ ������/���� ū ������ ū��
-- EXISTS / NOT EXISTS
--      ���� �����ϴ�/�������� �ʴ� ���

-- �μ� �� �ְ� �޿��� �޴� ������ �̸�, �����ڵ�, �μ��ڵ�, �޿� ��ȸ
-- 1) �μ� �� �ְ� �޿� ��ȸ
SELECT MAX(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- 2) �������� �̿�
SELECT EMP_NAME, JOB_CODE, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY IN (SELECT MAX(SALARY)
                 FROM EMPLOYEE
                 GROUP BY DEPT_CODE);
                 
-- �����ڿ� �Ϲ� ������ �ش��ϴ� ��� ���� ����
-- ���, �̸�, �μ� ��, ����, ����(������/����)
-- 1) �����ڿ� �ش��ϴ� ��� ��ȣ ��ȸ
SELECT DISTINCT MANAGER_ID
FROM EMPLOYEE
WHERE MANAGER_ID IS NOT NULL;

-- 2) ������ ���, �̸�, �μ���, ���� ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE
     LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
     JOIN JOB USING(JOB_CODE);
     
-- 3) 1 + 2
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, '������' ����
FROM EMPLOYEE
     LEFT JOIN DEPARTMENT ON(DEPT_ID = DEPT_CODE)
     JOIN JOB USING(JOB_CODE)
WHERE EMP_ID IN (SELECT DISTINCT MANAGER_ID
                 FROM EMPLOYEE
                 WHERE MANAGER_ID IS NOT NULL);
                 
-- 4) 3���� ������ ������(���) ����
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, '���' ����
FROM EMPLOYEE
     LEFT JOIN DEPARTMENT ON(DEPT_ID = DEPT_CODE)
     JOIN JOB USING(JOB_CODE)
WHERE EMP_ID NOT IN (SELECT DISTINCT MANAGER_ID
                 FROM EMPLOYEE
                 WHERE MANAGER_ID IS NOT NULL);
                 
-- 5) 3 + 4
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, '������' ����
FROM EMPLOYEE
     LEFT JOIN DEPARTMENT ON(DEPT_ID = DEPT_CODE)
     JOIN JOB USING(JOB_CODE)
WHERE EMP_ID IN (SELECT DISTINCT MANAGER_ID
                 FROM EMPLOYEE
                 WHERE MANAGER_ID IS NOT NULL)
UNION
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, '���' ����
FROM EMPLOYEE
     LEFT JOIN DEPARTMENT ON(DEPT_ID = DEPT_CODE)
     JOIN JOB USING(JOB_CODE)
WHERE EMP_ID NOT IN (SELECT DISTINCT MANAGER_ID
                 FROM EMPLOYEE
                 WHERE MANAGER_ID IS NOT NULL);

-- ���� ����
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_CODE,
       CASE WHEN EMP_ID IN (SELECT DISTINCT MANAGER_ID
                            FROM EMPLOYEE
                            WHERE MANAGER_ID IS NOT NULL) THEN '������'
       ELSE '����'
       END ����
FROM EMPLOYEE
     LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
     JOIN JOB USING(JOB_CODE);

-- �븮 ������ ������ �߿��� ���� ������ �ּ� �޿����� ���� �޴� ������ ���, �̸�, ����, �޿� ��ȸ
-- 1) �븮 ���� ��� ���� ��ȸ
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
     JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '�븮';

-- 2) ���� ������ �޿�
SELECT SALARY
FROM EMPLOYEE
     JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '����';

-- 3) 1 + 2
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
     JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '�븮'
      AND SALARY > ANY(SELECT SALARY
                       FROM EMPLOYEE
                            JOIN JOB USING(JOB_CODE)
                       WHERE JOB_NAME = '����');
-- �ٸ� ����
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
     JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '�븮'
      AND SALARY > (SELECT MIN(SALARY)
                    FROM EMPLOYEE
                        JOIN JOB USING(JOB_CODE)
                    WHERE JOB_NAME = '����');
                    
-- ���� ������ �޿��� ���� ū ������ ���� �޴� ���� ������ ���, �̸�, ����, �޿� ��ȸ
-- 1) ���� ������ ���, �̸�, ����, �޿�
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
     JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '����';

-- 2) ���� ���� ������ �޿�
SELECT SALARY
FROM EMPLOYEE
     JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '����';

-- 3) 1 + 2
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
     JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '����'
      AND SALARY > ALL(SELECT SALARY
                       FROM EMPLOYEE
                            JOIN JOB USING(JOB_CODE)
                       WHERE JOB_NAME = '����');
-- �ٸ� ����
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
     JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '����'
      AND SALARY > (SELECT MAX(SALARY)
                    FROM EMPLOYEE
                        JOIN JOB USING(JOB_CODE)
                    WHERE JOB_NAME = '����');
                    
-- 3. ���߿� �������� : ���� SELECT���� ������ �׸� ���� ���� ���� ��
-- ����� �������� ���� �μ�, ���� ���޿� �ش��ϴ� ����� �̸�, �����ڵ�, �μ��ڵ�, �Ի��� ��ȸ
-- 1) ����� �������� �μ�, ���� ��ȸ
SELECT JOB_CODE, DEPT_CODE
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) = 2 AND ENT_YN = 'Y';

-- 2) ����� �������� ���� �μ�, ���� ����
SELECT EMP_NAME, JOB_CODE, DEPT_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_CODE
                   FROM EMPLOYEE
                   WHERE SUBSTR(EMP_NO, 8, 1) = 2 AND ENT_YN = 'Y')
      AND JOB_CODE = (SELECT JOB_CODE
                      FROM EMPLOYEE
                      WHERE SUBSTR(EMP_NO, 8, 1) = 2 AND ENT_YN = 'Y')
      AND EMP_NAME != (SELECT EMP_NAME
                       FROM EMPLOYEE
                       WHERE SUBSTR(EMP_NO, 8, 1) = 2 AND ENT_YN = 'Y');
                       
-- ���߿� �������� �̿�
SELECT EMP_NAME, JOB_CODE, DEPT_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE (DEPT_CODE, JOB_CODE) IN (SELECT DEPT_CODE, JOB_CODE
                                FROM EMPLOYEE
                                WHERE SUBSTR(EMP_NO, 8, 1) = 2 AND ENT_YN = 'Y')
      AND EMP_NAME != (SELECT EMP_NAME
                       FROM EMPLOYEE
                       WHERE SUBSTR(EMP_NO, 8, 1) = 2 AND ENT_YN = 'Y');
                       
-- 4. ������ ���߿� �������� : ��ȸ ��� �� ���� �� ���� ���� ���� ��
-- �ڱ� ������ ��� �޿��� �ް� �ִ� ������ ���, �̸�, �����ڵ�, �޿� ��ȸ
-- �޿��� �޿� ����� �ʸ��� ������ ��� == TRUNC(�ø���, -5);
-- 1) ���� �� ��� �޿�
SELECT TRUNC(AVG(SALARY), -5), AVG(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE;

-- 2) �ڱ� ������ ��� �޿��� �ް� �ִ� ����
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE (JOB_CODE, SALARY) IN (SELECT JOB_CODE, TRUNC(AVG(SALARY), -5)
                             FROM EMPLOYEE
                             GROUP BY JOB_CODE);
                             
-- �ζ��� �� : FROM���� �������� ���
-- �� ���� �� �޿��� ���� ���� 5���� ����, �̸�, �޿� ��ȸ
-- ������, ������, ������, ���ȥ, ���ö
SELECT ROWNUM, EMP_NAME, SALARY 
FROM EMPLOYEE
WHERE ROWNUM <= 5
ORDER BY SALARY DESC;
-- �� �ڵ�� ������ ���� ������ �̷�� ��
-- 1)
SELECT * 
FROM EMPLOYEE;
-- 2)
SELECT * 
FROM EMPLOYEE
WHERE ROWNUM <= 5;
-- 3)
SELECT ROWNUM, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE ROWNUM <= 5;
-- 4)
SELECT ROWNUM, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE ROWNUM <= 5
ORDER BY SALARY DESC;

-- �ذ�!
SELECT ROWNUM, EMP_NAME, SALARY
FROM (SELECT * 
      FROM EMPLOYEE
      ORDER BY SALARY DESC)
WHERE ROWNUM <= 5
ORDER BY SALARY DESC; -- �ζ��� �信�� ������ ���־��� ������ ORDER BY���� ����

-- �޿� ����� 3�� �ȿ� ��� �μ��� �μ��ڵ�� �μ� ��, ��� �޿� ��ȸ
SELECT DEPT_CODE, DEPT_TITLE, FLOOR(AVG(SALARY))
FROM EMPLOYEE
     JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
WHERE ROWNUM <= 3
GROUP BY DEPT_CODE, DEPT_TITLE
ORDER BY FLOOR(AVG(SALARY)) DESC; -- WRONG

SELECT DEPT_CODE, DEPT_TITLE, ��ձ޿�
FROM (SELECT DEPT_CODE, DEPT_TITLE, FLOOR(AVG(SALARY)) ��ձ޿�
      FROM EMPLOYEE
           JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
      GROUP BY DEPT_CODE, DEPT_TITLE
      ORDER BY FLOOR(AVG(SALARY)) DESC)
WHERE ROWNUM <= 3;

-- RANK() OVER / DENSE_RANK() OVER
SELECT EMP_NAME, SALARY, RANK() OVER(ORDER BY SALARY DESC) ����
FROM EMPLOYEE;

SELECT EMP_NAME, SALARY, DENSE_RANK() OVER(ORDER BY SALARY DESC) ����
FROM EMPLOYEE;