DROP SEQUENCE BOARDSEQ;
DROP TABLE BOARD;

CREATE SEQUENCE BOARDSEQ;

CREATE TABLE BOARD(
	SEQ NUMBER PRIMARY KEY,
	WRITER VARCHAR2(100) NOT NULL,
	TITLE VARCHAR2(1000) NOT NULL,
	CONTENT VARCHAR2(4000) NOT NULL,
	REGDATE DATE NOT NULL
);

INSERT INTO BOARD
VALUES (BOARDSEQ.NEXTVAL, '관리자', '테스트 글 입니다.', '삭제하고 다시 만들었어요 ㅠㅠ', SYSDATE);

SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE
FROM BOARD
ORDER BY SEQ DESC;