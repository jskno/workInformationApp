--
-- create tables, constraints, sequences and indexes for course
--

-- TABLE
CREATE TABLE COURSE_LABELS (
  COURSE_ID INT[18] NOT NULL,
  LABEL_ID INT[18] NOT NULL,
  -- technical attributes of the table
  CREATED_AT TIMESTAMP WITH TIME ZONE NOT NULL,
  CREATED_BY CHAR(20) NOT NULL,
  MODIFIED_AT TIMESTAMP WITH TIME ZONE NOT NULL,
  MODIFIED_BY CHAR(20) NOT NULL,
  VERSION INT[10] NOT NULL
);

GRANT SELECT, INSERT, UPDATE, DELETE ON COURSE_LABELS TO WORKER;

-- constraints
ALTER TABLE COURSE_LABELS ADD CONSTRAINT PK_COURSE_LABELS PRIMARY KEY (COURSE_ID, LABEL_ID );
ALTER TABLE COURSE_LABELS ADD CONSTRAINT FK_COURSE_LABELS1 FOREIGN KEY (COURSE_ID) REFERENCES COURSE (ID) MATCH FULL;
ALTER TABLE COURSE_LABELS ADD CONSTRAINT FK_COURSE_LABELS2 FOREIGN KEY (LABEL_ID) REFERENCES LABEL (ID) MATCH FULL;
