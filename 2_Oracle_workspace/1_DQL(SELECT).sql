-- SELECT
-- Result Set : SELECT구문으로 데이터를 조회한 결과물(반환된 행들의 집합)

-- EMPLOYEE테이블의 사번, 이름 급여 조회
SELECT EMP_ID, EMP_NAME, SALARY 
FROM EMPLOYEE;

select emp_id, emp_name, salary
from employee; -- 대소문자 구분 안함 -- 대문자 권장

select emp_id, emp_name, salary, ent_yn
from employee
where ent_yn = 'Y'; -- 리터럴은 대소문자 구별

-- EMPLOYEE테이블에서 모든 정보 조회
SELECT EMP_ID, EMP_NAME, EMP_NO, EMAIL, PHONE, DEPT_CODE, JOB_CODE, SAL_LEVEL, SALARY, BONUS, MANAGER_ID, HIRE_DATE, ENT_DATE, ENT_YN
FROM EMPLOYEE;

SELECT * -- 아스트로
FROM EMPLOYEE;

------------ 실습 문제 ------------
-- 1. JOB 테이블의 모든 정보 조회
SELECT JOB_CODE, JOB_NAME  
FROM JOB;

SELECT *
FROM JOB;

-- 2. JOB 테이블의 직급 이름 조회
SELECT JOB_NAME 
FROM JOB;

-- 3. DEPARTMENT 테이블의 모든 정보 조회
SELECT DEPT_ID, DEPT_TITLE, LOCATION_ID  
FROM DEPARTMENT;

SELECT * 
FROM DEPARTMENT;

-- 4. EMPLOYEE 테이블의 직원명, 이메일, 전화번호, 고용일 조회
SELECT EMP_NAME, EMAIL, PHONE, HIRE_DATE 
FROM EMPLOYEE;

-- 5. EMPLOYEE 테이블의 고용일, 사원이름, 월급 조회
SELECT HIRE_DATE, EMP_NAME, SALARY 
FROM EMPLOYEE;

----------------------------------
-- 컬럼 값 산술 연산
-- EMPLOYEE테이블에서 직원 명, 연봉 조회(연봉 = 급여 * 12)
SELECT EMP_NAME, SALARY * 12
FROM EMPLOYEE;

-- EMPLOYEEE테이블에서 직원의 직원 명, 연봉, 보너스를 추가한 연봉 조회
SELECT EMP_NAME, SALARY * 12, (SALARY + (SALARY * BONUS)) * 12
FROM EMPLOYEE;

SELECT EMP_NAME, SALARY * 12, (SALARY * (1 + BONUS)) * 12
FROM EMPLOYEE;

------------ 실습 문제 ------------
-- 1. EMPLOYEE 테이블에서 이름, 연봉, 총수령액(보너스포함), 실수령액(총수령액 - (연봉*세금 3%)) 조회
SELECT EMP_NAME, SALARY * 12, (SALARY + (SALARY * BONUS)) * 12, ((SALARY + (SALARY * BONUS)) * 12) - ((SALARY * 12) * 0.03)
FROM EMPLOYEE;

-- 2. EMPLOYEE 테이블에서 이름, 고용일, 근무일수(오늘날짜 - 고용일) 조회
SELECT EMP_NAME, HIRE_DATE, SYSDATE - HIRE_DATE
FROM EMPLOYEE;

----------------------------------

-- 컬럼 별칭 --
-- 컬럼 AS 별칭
-- 컬럼 "별칭"    -- 별칭에 특수문자가 포함된 경우 무조건 쌍따옴표(더블 쿼테이션) 사용
-- 컬럼 AS "별칭" -- 별칭에 특수문자가 포함된 경우 무조건 쌍따옴표(더블 쿼테이션) 사용
-- 컬럼 별칭
-- EMPLOYEE테이블에서 직원의 직원 명(별칭: 이름), 연봉(별칭: 연봉(원)), 보너스를 추가한 연봉(별칭: 총소득(원)) 조회
SELECT EMP_NAME AS 이름, SALARY * 12 "연봉(원)", (SALARY * (1 + BONUS)) * 12 AS "총소득(원)"
FROM EMPLOYEE;

-- 1. EMPLOYEE 테이블에서 이름, 연봉, 총수령액(보너스포함), 실수령액(총수령액 - (연봉*세금 3%)) 조회
SELECT EMP_NAME 이름, SALARY * 12 연봉, (SALARY + (SALARY * BONUS)) * 12 총수령액, ((SALARY + (SALARY * BONUS)) * 12) - ((SALARY * 12) * 0.03) 실수령액
FROM EMPLOYEE;

-- 2. EMPLOYEE 테이블에서 이름, 고용일, 근무일수(오늘날짜 - 고용일) 조회
SELECT EMP_NAME 이름, HIRE_DATE 고용일, SYSDATE - HIRE_DATE 근무일수
FROM EMPLOYEE;

-- 리터럴 : ' '
-- EMPLOYEE테이블에서 직원의 직원 번호, 사원 명, 급여, 단위(데이터 값 : 원) 조회
SELECT EMP_ID, EMP_NAME, SALARY, '원'
FROM EMPLOYEE;

-- DISTINCT : 중복 값을 한 번씩만 표시하고자 할 때 사용 -- SELECT절에서 한 번만 사용가능하며 한 컬럼만 개별적용 불가
-- EMPLOYEE테이블에서 직원의 직급 코드 조회
SELECT JOB_CODE
FROM EMPLOYEE;

SELECT DISTINCT JOB_CODE
FROM EMPLOYEE;

-- EMPLOYEE테이블에서 부서코드와 직급코드 조회
SELECT DISTINCT DEPT_CODE, JOB_CODE
FROM EMPLOYEE;

-- WHERE절: 조회할 테이블에서 조건이 맞는 값을 가진 행을 골라냄
-- 비교 연산자
-- = 같다, > 크다, < 작다, >= 크거나 같다, <= 작거나 같다, != ^= <> 같지 않다

-- EMPLOYEE테이블에서 부서코드가 D9인 직원의 이름, 부서코드 조회
SELECT EMP_NAME, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9';

-- EMPLOYEE테이블에서 급여가 4000000이상인 직원의 이름, 급여 조회
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE SALARY >= 4000000;

-- EMPLOYEE테이블에서 부서코드가 D9가 아닌 사원의 사번, 이름, 부서코드 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE
FROM EMPLOYEE
--WHERE DEPT_CODE <> 'D9'
--WHERE DEPT_CODE != 'D9'
WHERE DEPT_CODE ^= 'D9';

-- EMPLOYEE테이블에서 퇴사 여부가 N인 직원을 조회하고 근무 여부를 재직중으로 표시하여 사번, 이름, 고용일, 근무 여부 조회
SELECT EMP_ID, EMP_NAME, HIRE_DATE, '재직중' "근무 여부"
FROM EMPLOYEE
WHERE ENT_YN = 'N';

------------ 실습 문제 ------------
-- 1. EMPLOYEE 테이블에서 월급이 3000000이상인 사원의 이름, 월급, 고용일 조회
SELECT EMP_NAME, SALARY, HIRE_DATE
FROM EMPLOYEE
WHERE SALARY >= 3000000;

-- 2. EMPLOYEE 테이블에서 SAL_LEVEL이 S1인 사원의 이름, 월급, 고용일, 연락처 조회
SELECT EMP_NAME, SALARY, HIRE_DATE, PHONE
FROM EMPLOYEE
WHERE SAL_LEVEL = 'S1';

-- 3. EMPLOYEE 테이블에서 실수령액(총수령액 - (연봉 * 세금 3%))이 5천만원 이상인 사원의 이름, 월급, 실수령액, 고용일 조회
SELECT EMP_NAME, SALARY, ((SALARY * (1 + BONUS)) * 12) - ((SALARY * 12) * 0.03), HIRE_DATE
FROM EMPLOYEE
WHERE ((SALARY * (1 + BONUS)) * 12) - ((SALARY * 12) * 0.03) >= 50000000;

----------------------------------

-- 논리 연산자 AND OR
-- EMPLOYEE테이블에서 부서코드가 'D6'이고 급여를 3백만보다 많이 받는 직원의 이름, 부서코드, 급여 조회
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D6' AND SALARY > 3000000;

-- EMPLOYEE테이블에서 부서코드가 'D6'이거나 급여를 3백만보다 많이 받는 직원의 이름, 부서코드, 급여 조회
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D6' OR SALARY > 3000000;

-- EMPLOYEE테이블에서 급여를 350만 이상 600만 이하를 받는 직원의 사번, 이름, 급여, 부서코드, 직급코드 조회
SELECT EMP_ID, EMP_NAME, SALARY, DEPT_CODE, JOB_CODE
FROM EMPLOYEE
WHERE SALARY >= 3500000 AND SALARY <= 6000000;

------------ 실습 문제 ------------
-- 1. EMPLOYEE 테이블에 월급이 4000000이상이고 JOB_CODE가 J2인 사원의 전체 내용 조회
SELECT *
FROM EMPLOYEE
WHERE SALARY >= 4000000 AND JOB_CODE = 'J2';

-- 2. EMPLOYEE 테이블에 DEPT_CODE가 D9이거나 D5인 사원 중 고용일이 02년 1월 1일보타 빠른 사원의 이름, 부서코드, 고용일 조회
SELECT EMP_NAME, DEPT_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE (DEPT_CODE = 'D9' OR DEPT_CODE = 'D5') AND HIRE_DATE < '02/01/01';

----------------------------------

-- BETWEEN 값1 AND 값2 : 값1 이상 값2 이하
-- 급여를 3500000이상 받고 6000000이하로 받는 사원의 이름, 급여 조회
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE SALARY >= 3500000 AND SALARY <= 6000000;

SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE SALARY BETWEEN 3500000 AND 6000000;

-- 반대로 급여를 350만 미만, 또는 600만 초과하는 직원의 사번, 이름, 급여, 부서코드, 직급코드 조회
SELECT EMP_ID, EMP_NAME, SALARY, DEPT_CODE, JOB_CODE
FROM EMPLOYEE
WHERE SALARY < 3500000 OR SALARY > 6000000;

SELECT EMP_ID, EMP_NAME, SALARY, DEPT_CODE, JOB_CODE
FROM EMPLOYEE
WHERE SALARY NOT BETWEEN 3500000 AND 6000000;

SELECT EMP_ID, EMP_NAME, SALARY, DEPT_CODE, JOB_CODE
FROM EMPLOYEE
WHERE NOT SALARY BETWEEN 3500000 AND 6000000;

------------ 실습 문제 ------------
-- 1. EMPLOYEE 테이블에 고용일이 90/01/01 ~ 01/01/01인 사원의 전체 내용을 조회
SELECT *
FROM EMPLOYEE
WHERE HIRE_DATE BETWEEN '90/01/01' AND '01/01/01';

----------------------------------

-- LIKE : 특정 문자 패턴을 만족시키는지 확인
-- LIKE에서 사용할 수 있는 와일드 카드 % _
-- % : 0글자 이상
-- _ : 1글자
-- '글자%' : '글자'로 시작하는 값
-- '%글자' : '글자'로 끝나는 값
-- '글%자' : '글'로 시작해서 '자'로 끝나는 값
-- '%글자%' : '글자'가 포함된 값
-- '_' : 한글자
-- '__' : 두글자
-- '___' : 세글자

-- EMPLOYEE테이블에서 성이 전씨인 사원의 사번, 이름, 고용일 조회
SELECT EMP_ID, EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '전%';

-- EMPLOYEE테이블에서 이름에 '하'가 포함된 직원의 이름, 주민번호, 부서코드 조회
SELECT EMP_NAME, EMP_NO, DEPT_CODE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%하%';

-- EMPLOYEE테이블에서 전화번호 네번째 자리가 9로 시작하는 사원의 사번, 이름, 전화번호 조회
SELECT EMP_NO, EMP_NAME, PHONE
FROM EMPLOYEE
WHERE PHONE LIKE '___9%';

-- EMPLOYEE테이블에서 이메일 중 _의 앞글자가 3자리인 이메일 주소를 가진 사원의 사번, 이메일 주소 조회
SELECT EMP_ID, EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE EMAIL LIKE '____%';
-- 패턴과 특수기호를 구분하지 못하기 때문에 ESCAPE OPTION을 통해 구분
SELECT EMP_ID, EMP_NAME, EMAIL
FROM EMPLOYEE
--WHERE EMAIL LIKE '___ _%' ESCAPE ' ';
WHERE EMAIL LIKE '___\_%' ESCAPE '\';

-- : 특정 패턴을 만족시키지 않는 값 조회
-- EMPLOYEE테이블에서 김씨 성이 아닌 직원의 사번, 이름, 고용일 조회
SELECT EMP_ID, EMP_NAME, HIRE_DATE
FROM EMPLOYEE
--WHERE NOT EMP_NAME LIKE '김%';
WHERE EMP_NAME NOT LIKE '김%';

------------ 실습 문제 ------------
-- 1. EMPLOYEE 테이블에서 이름 끝이 '연'으로 끝나는 사원의 이름 조회
SELECT EMP_NAME
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%연';

-- 2. EMPLOYEE 테이블에서 전화번호 처음 3자리가 010이 아닌 사원의 이름, 전화번호를 조회
SELECT EMP_NAME, PHONE
FROM EMPLOYEE
WHERE PHONE NOT LIKE '010%';

-- 3. EMPLOYEE 테이블에서 메일주소 '_'의 앞이 4자 이면서 DEPT_CODE가 D9 또는 D6이고
--    고용일이 90/01/01 ~ 00/12/01이고, 급여가 270만 이상인 사원의 전체를 조회
SELECT *
FROM EMPLOYEE
WHERE EMAIL LIKE '____\_%' ESCAPE '\' 
    AND (DEPT_CODE = 'D9' OR DEPT_CODE = 'D6') 
    AND HIRE_DATE BETWEEN '90/01/01' AND '00/12/01' 
    AND SALARY >= 2700000;

----------------------------------

-- IS NULL / IS NOT NULL
-- IS NULL : 컬럼 값이 NULL인 경우
-- IS NOT NULL : 컬럼 값이 NOLL이 아닌 경우

-- EMPLOYEE테이블에서 보너스를 받지 않는 사원의 사번, 이름, 급여, 보너스 조회
SELECT EMP_ID, EMP_NAME, SALARY, BONUS
FROM EMPLOYEE
WHERE BONUS IS NULL;

-- EMPLOYEE테이블에서 보너스를 받는 사원의 사번, 이름, 급여, 보너스 조회
SELECT EMP_ID, EMP_NAME, SALARY, BONUS
FROM EMPLOYEE
WHERE BONUS IS NOT NULL;

-- EMPLOYEE테이블에서 관리자도 없고 부서 배치도 받지 않은 직원의 이름, 관리자, 부서코드 조회
SELECT EMP_NAME, MANAGER_ID, DEPT_CODE
FROM EMPLOYEE
WHERE MANAGER_ID IS NULL AND DEPT_CODE IS NULL;

-- EMPLOYEE테이블에서 부서 배치를 받지 않았지만 보너스를 지급 받는 직원의 이름, 보너스, 부서코드 조회
SELECT EMP_NAME, BONUS, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE IS NULL AND BONUS IS NOT NULL;

-- IN : 비교하려는 값 목록에 일치하는 값이 있으면 TRUE를 반환하는 연산자
-- D6부서와 D9부서원들의 이름, 부서코드, 급여 조회
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D6' OR DEPT_CODE = 'D9';

SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE IN ('D6', 'D9');

-- 직급코드가 J1, J2, J3, J4인 사람들의 이름, 직급코드, 급여 조회
SELECT EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE JOB_CODE = 'J1' 
    OR JOB_CODE = 'J2' 
    OR JOB_CODE = 'J3' 
    OR JOB_CODE = 'J4';

SELECT EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE JOB_CODE IN ('J1', 'J2', 'J3', 'J4');

-- 연결연산자 || 
-- 여러 컬럼을 하나의 컬럼인 것처럼 연결하거나 컬럼과 리터럴을 연결할 수 있음
-- EMPLOYEE테이블에서 사번, 이름, 급여를 연결하여 조회
SELECT EMP_ID || EMP_NAME || SALARY
FROM EMPLOYEE;

-- EMPLOYEE테이블에서 '사원 명의 월급은 급여원 입니다.' 형식으로 조회
SELECT EMP_NAME || '의 월급은 ' || SALARY || '원 입니다.'
FROM EMPLOYEE;
