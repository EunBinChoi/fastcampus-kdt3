DROP TABLE NEW_MEMBER;

CREATE TABLE NEW_MEMBER (
        USER_ID VARCHAR(255) NOT NULL,
        USER_PW VARCHAR(255) NOT NULL,
        USER_EMAIL VARCHAR(255) NOT NULL,
        SURVEY_ID BIGINT DEFAULT NULL,
        PRIMARY KEY (USER_ID),
        FOREIGN KEY (SURVEY_ID) REFERENCES NEW_SURVEY(SURVEY_ID)
);

SELECT * FROM NEW_MEMBER;