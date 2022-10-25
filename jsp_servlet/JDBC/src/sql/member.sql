DROP TABLE MEMBER;


CREATE TABLE MEMBER (
        uId VARCHAR(255),
        uPw VARCHAR(255),
        uEmail VARCHAR(255),
        PRIMARY KEY (uId)
);

INSERT INTO MEMBER VALUES ('admin', 'admin', 'admin@gmail.com');
INSERT INTO MEMBER VALUES ('a', 'a1234', 'a@gmail.com');
INSERT INTO MEMBER VALUES ('b', 'b1234', 'b@gmail.com');
INSERT INTO MEMBER VALUES ('c', 'c1234', 'c@gmail.com');
INSERT INTO MEMBER VALUES ('d', 'd1234', 'd@gmail.com');
INSERT INTO MEMBER VALUES ('e', 'e1234', 'e@gmail.com');


SELECT * FROM MEMBER;