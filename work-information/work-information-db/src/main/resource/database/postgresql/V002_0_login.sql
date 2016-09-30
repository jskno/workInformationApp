--
-- create tables, constraints, sequences and indexes for course
--

-- TABLE
CREATE TABLE LOGIN (
  ID INT[18] NOT NULL,
  -- base attributes
  TITLE CHAR (30) NOT NULL,
  USERNAME CHAR(20),
  PASSWORD CHAR(10),
  URL CHAR(100),
  -- technical attributes of the table
  CREATED_AT TIMESTAMP WITH TIME ZONE NOT NULL,
  CREATED_BY CHAR(20) NOT NULL,
  MODIFIED_AT TIMESTAMP WITH TIME ZONE NOT NULL,
  MODIFIED_BY CHAR(20) NOT NULL,
  VERSION INT[10] NOT NULL
);

GRANT SELECT, INSERT, UPDATE, DELETE ON LOGIN TO WORKER;

-- constraints
ALTER TABLE LOGIN ADD CONSTRAINT PK_LOGIN PRIMARY KEY (ID);

-- sequences
CREATE SEQUENCE LOGIN_SEQ MINVALUE 1 MAXVALUE 999999999999 INCREMENT BY 1 START WITH 1 CACHE 10 NO CYCLE;

GRANT SELECT, USAGE ON LOGIN_SEQ TO WORKER;