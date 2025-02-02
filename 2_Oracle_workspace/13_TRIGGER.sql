-- TRIGGER(트리거)
-- 테이블이나 뷰가 INSERT, UPDATE, DELETE 등의 DML문에 의해 변경될 경우(테이블에 이벤트가 발생했을 시)
-- 자동으로 실행될 내용을 정의하여 저장하는 객체

-- 트리거 종류
-- SQL문의 실행 시기에 따른 분류
--      BEFORE TRIGGER : SQL문 실행 전 트리거 실행
--      AFTER TRIGGER : SQL문 실행 후 트리거 실행

-- SQL문에 의해 영향을 받는 각 ROW에 따른 분류
--      ROW TRIGGER(행트리거)
--          SQL문 각 ROW에 대해 한 번씩 실행
--          트리거 작성 시 FOR EACH ROW 옵션 작성
--          :OLD --> 참조 전의 열의 값(UPDATE : 수정 전 자료, DELETE : 삭제 할 자료)
--          :NEW --> 참조 후의 열의 값(INSERT : 입력 할 자료, UPDATE : 수정 후 자료) 
--      STATEMENT TRIGGER(문장 트리거)
--          SQL문에 대해 한 번만 실행(DEFAULT TRIGGER)

-- 트리거 생성문
/*
    CREATE [OR REPLACE] TRIGGER 트리거 명
    BEFORE | AFTER
    INSERT | UPDATE | DELETE
    ON 테이블 명
    [FOR EACH ROW]
    [WHEN 조건]
    DECLARE
        -- 선언부
    BEGIN
        -- 실행부
    [EXCEPTION]
    END;
    /
*/

-- EMPLOYEE테이블에 사원이 추가되면 '신입사원이 입사했습니다.'라는 문구가 출력되는 TRG_01 트리거 생성
CREATE OR REPLACE TRIGGER TRG_01
AFTER INSERT ON EMPLOYEE
BEGIN
    DBMS_OUTPUT.PUT_LINE('신입사원이 입사했습니다.');
END;
/

INSERT INTO EMPLOYEE
VALUES(905, '길성춘', '691011-1257943', 'gil_sc@kh.or.kr', '01075431357', 'D5', 'J3', 'S5',
        3000000, 0.1, 200, SYSDATE, NULL, DEFAULT);
DELETE FROM EMPLOYEE WHERE EMP_ID = 905;
ROLLBACK;
COMMIT;

SET SERVEROUTPUT ON;

COMMIT;

-- 상품 정보 테이블
CREATE TABLE PRODUCT(
    PCODE NUMBER PRIMARY KEY, -- 상품코드
    PNAME VARCHAR2(30), -- 상품 명
    BRAND VARCHAR2(30), -- 브랜드
    PRICE NUMBER, -- 가격
    STOCK NUMBER DEFAULT 0 -- 재고
);

-- 상품 입출고 상세 이력 테이블
CREATE TABLE PRO_DETAIL(
    DCODE NUMBER PRIMARY KEY, -- 상세코드
    PCODE NUMBER, -- 상품 코드
    PDATE DATE, -- 상품 입출고일
    AMOUNT NUMBER, -- 입출고 개수
    STATUS VARCHAR2(10) CHECK(STATUS IN ('입고', '출고')), -- 입고/출고
    FOREIGN KEY(PCODE) REFERENCES PRODUCT(PCODE)
);

CREATE SEQUENCE SEQ_PCODE;
CREATE SEQUENCE SEQ_DCODE;

INSERT INTO PRODUCT
VALUES (SEQ_PCODE.NEXTVAL, '갤럭시노트20', '삼성', 9000, DEFAULT);
INSERT INTO PRODUCT
VALUES (SEQ_PCODE.NEXTVAL, '아이폰11', '애플', 9500, DEFAULT);
INSERT INTO PRODUCT
VALUES (SEQ_PCODE.NEXTVAL, '콩순이핸드폰', '영실업', 15000, DEFAULT);

SELECT * FROM PRODUCT;
SELECT * FROM PRO_DETAIL;

-- 상품 입출고 테이블에 입고/출고가 들어갈 때마다 PRODUCT에 있는 재고(STOCK)가 바뀌어야 함
-- 따라서 PRO_DETAIL 테이블에 데이터 삽입(INSERT) 시
-- STATUS컬럼 값에 따른 PRODUCT테이블 STOCK컬럼 값 변경 트리거 작성
CREATE OR REPLACE TRIGGER TGR_02
AFTER INSERT ON PRO_DETAIL
FOR EACH ROW
BEGIN
    IF :NEW.STATUS = '입고'
    THEN
        UPDATE PRODUCT
        SET STOCK = STOCK + :NEW.AMOUNT
        WHERE PCODE = :NEW.PCODE;
    END IF;
    
    IF :NEW.STATUS = '출고'
    THEN
        UPDATE PRODUCT
        SET STOCK = STOCK - :NEW.AMOUNT
        WHERE PCODE = :NEW.PCODE;
    END IF;
END;
/

SELECT * FROM PRODUCT;
SELECT * FROM PRO_DETAIL;

INSERT INTO PRO_DETAIL VALUES(SEQ_DCODE.NEXTVAL, 1, SYSDATE, 5, '입고');
INSERT INTO PRO_DETAIL VALUES(SEQ_DCODE.NEXTVAL, 2, SYSDATE, 15, '입고');
INSERT INTO PRO_DETAIL VALUES(SEQ_DCODE.NEXTVAL, 3, SYSDATE, 1, '입고');
INSERT INTO PRO_DETAIL VALUES(SEQ_DCODE.NEXTVAL, 1, SYSDATE, 2, '출고');

COMMIT;