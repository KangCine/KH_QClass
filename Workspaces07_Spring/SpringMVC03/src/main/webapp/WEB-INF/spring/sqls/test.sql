DROP SEQUENCE MYNOSEQ;
DROP TABLE MYNOBOARD;

CREATE SEQUENCE MYNOSEQ;

CREATE TABLE MYNOBOARD(
	MYNO NUMBER PRIMARY KEY,
	MYNAME VARCHAR2(1000) NOT NULL,
	MYTITLE VARCHAR2(2000) NOT NULL,
	MYCONTENT VARCHAR2(4000) NOT NULL,
	MYDATE DATE NOT NULL
);

INSERT INTO MYNOBOARD
VALUES(MYNOSEQ.NEXTVAL, '관리자', '스프링 재밌다.', '정말 재밌다.', SYSDATE);

SELECT MYNO, MYNAME, MYTITLE, MYCONTENT, MYDATE
FROM MYNOBOARD
ORDER BY MYNO DESC;