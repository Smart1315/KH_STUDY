-- 관리자 계정 : 데이터베이스 생성과 관리를 담당하는 슈퍼 유저 계정
--              오브젝트 생성, 변경, 삭제 등의 작업이 가능하며 데이터베이스에 대한 모든 권한과 책임을 가지는 계정

--        계정이름          비밀번호
CREATE USER KH IDENTIFIED BY KH; -- 사용자 계정 생성
GRANT RESOURCE, CONNECT TO KH; -- KH계정에 권한 부여

-- 사용자 계정 : 데이터베이스에 대하여 질의(Query), 갱신, 보고서 작성 등의 작업을 수행할 수 있는 계정
--              일반 계정은 보안을 위해 업무에 필요한 최소한의 권한만 가지는 것을 원칙으로 함


-- SCOTT 계정 만들기
CREATE USER SCOTT IDENTIFIED BY SCOTT;
GRANT RESOURCE, CONNECT TO SCOTT;

-- WORKBOOK 계정 만들기
CREATE USER WORKBOOK IDENTIFIED BY WORKBOOK;
GRANT RESOURCE, CONNECT TO WORKBOOK;
GRANT CREATE VIEW TO WORKBOOK;
REVOKE CREATE VIEW FROM WORKBOOK;