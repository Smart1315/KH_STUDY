-- ������ ���� : �����ͺ��̽� ������ ������ ����ϴ� ���� ���� ����
--              ������Ʈ ����, ����, ���� ���� �۾��� �����ϸ� �����ͺ��̽��� ���� ��� ���Ѱ� å���� ������ ����

--        �����̸�          ��й�ȣ
CREATE USER KH IDENTIFIED BY KH; -- ����� ���� ����
GRANT RESOURCE, CONNECT TO KH; -- KH������ ���� �ο�

-- ����� ���� : �����ͺ��̽��� ���Ͽ� ����(Query), ����, ���� �ۼ� ���� �۾��� ������ �� �ִ� ����
--              �Ϲ� ������ ������ ���� ������ �ʿ��� �ּ����� ���Ѹ� ������ ���� ��Ģ���� ��


-- SCOTT ���� �����
CREATE USER SCOTT IDENTIFIED BY SCOTT;
GRANT RESOURCE, CONNECT TO SCOTT;

-- WORKBOOK ���� �����
CREATE USER WORKBOOK IDENTIFIED BY WORKBOOK;
GRANT RESOURCE, CONNECT TO WORKBOOK;
GRANT CREATE VIEW TO WORKBOOK;
REVOKE CREATE VIEW FROM WORKBOOK;