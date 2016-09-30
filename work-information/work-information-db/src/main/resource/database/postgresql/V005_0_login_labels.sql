--
-- create tables, constraints, sequences and indexes for course
--

-- TABLE
CREATE TABLE LOGIN_LABELS (
  LOGIN_ID INT[18] NOT NULL,
  LABEL_ID INT[18] NOT NULL,
  -- technical attributes of the table
  CREATED_AT TIMESTAMP WITH TIME ZONE NOT NULL,
  CREATED_BY CHAR(20) NOT NULL,
  MODIFIED_AT TIMESTAMP WITH TIME ZONE NOT NULL,
  MODIFIED_BY CHAR(20) NOT NULL,
  VERSION INT[10] NOT NULL
);

GRANT SELECT, INSERT, UPDATE, DELETE ON LOGIN_LABELS TO WORKER;

-- constraints
ALTER TABLE LOGIN_LABELS ADD CONSTRAINT PK_LOGIN_LABELS PRIMARY KEY (LOGIN_ID, LABEL_ID );
ALTER TABLE LOGIN_LABELS ADD CONSTRAINT FK_LOGIN_LABELS1 FOREIGN KEY (LOGIN_ID) REFERENCES LOGIN (ID) MATCH FULL;
ALTER TABLE LOGIN_LABELS ADD CONSTRAINT FK_LOGIN_LABELS2 FOREIGN KEY (LABEL_ID) REFERENCES LABEL (ID) MATCH FULL;