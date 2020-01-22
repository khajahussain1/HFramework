/* Formatted on 2012/12/14 22:42 (Formatter Plus v4.8.8) */
-- Creating table with constraints but without names to the constraints 

CREATE TABLE t1
(eno NUMBER PRIMARY KEY,
 ename VARCHAR2(10),
 invno CHAR(5) UNIQUE,
 sal NUMBER CHECK (sal>=4000));

-- Displaying the inbuilt names of constraints  

SELECT constraint_name, constraint_type, table_name
  FROM user_constraints
 WHERE table_name = 'T1';

-- Creating table with name to constraint  

CREATE TABLE t2
(eno NUMBER CONSTRAINT pk_eno PRIMARY KEY,
 ename VARCHAR2(10),
 invno CHAR(5) CONSTRAINT uk_ivno UNIQUE,
 sal NUMBER CONSTRAINT ch_sal CHECK (sal>=4000));

 -- Displaying the user defined names of constraints 

SELECT constraint_name, constraint_type, table_name
  FROM user_constraints
 WHERE table_name = 'T2';

-- Table level Constraints 

CREATE TABLE t3
(eno NUMBER,
 ename VARCHAR2(10),
 invno CHAR(5),
 sal NUMBER,
 CONSTRAINT cmpk PRIMARY KEY(eno,invno),
 CONSTRAINT unq UNIQUE(ename),
 CONSTRAINT chk CHECK(sal>=2000));

-- Foreign Key 

CREATE TABLE x
(eno NUMBER CONSTRAINT fk REFERENCES t1(eno) ON DELETE CASCADE,
marks NUMBER);

SELECT constraint_name, constraint_type, table_name
  FROM user_constraints
 WHERE table_name = 'X';

-- Creating a constraint less table  

CREATE TABLE t5
(eno NUMBER,
 ename VARCHAR2(10),
 invno NUMBER,
 sal NUMBER);

-- Adding Constraints after table creation 

ALTER TABLE t5
ADD(CONSTRAINT pk PRIMARY KEY(eno),
    CONSTRAINT un UNIQUE(ename),
    CONSTRAINT chk1 CHECK(sal>=3000));


-- Deferable and No Validate clause 
--  A Table with constrint given as Deferrable 

CREATE TABLE demo(a NUMBER CONSTRAINT c1 PRIMARY KEY DEFERRABLE);

INSERT INTO demo
     VALUES (1);

INSERT INTO demo
     VALUES (2);

INSERT INTO demo
     VALUES (3);

INSERT INTO demo
     VALUES (4);

SELECT *
  FROM demo;

-- Disabling Constraint 

ALTER TABLE demo
DISABLE CONSTRAINT c1;

--Adding a duplicate value which will get accepted due to disable constraint clause 

INSERT INTO demo
     VALUES (4);

-- Trying to enable the constraint 

ALTER TABLE demo
ENABLE CONSTRAINT c1;

-- Enable the constraint with NoValidate clause so that the past data is not checked .

ALTER TABLE demo
ENABLE NOVALIDATE CONSTRAINT c1;

SELECT *
  FROM demo;

INSERT INTO demo
     VALUES (5);
     
-- Without Defferrable 


CREATE TABLE demo1(a NUMBER CONSTRAINT c2 PRIMARY KEY);

INSERT INTO demo1
     VALUES (1);

INSERT INTO demo1
     VALUES (2);

INSERT INTO demo1
     VALUES (3);

INSERT INTO demo1
     VALUES (4);

SELECT *
  FROM demo1;

-- Disabling Constraint 

ALTER TABLE demo1
DISABLE CONSTRAINT c2;

--Adding a duplicate value which will get accepted due to disable constraint clause 

INSERT INTO demo1
     VALUES (4);

-- Trying to enable the constraint 

ALTER TABLE demo
ENABLE CONSTRAINT c2;

-- Enable the constraint with NoValidate clause so that the past data is not checked .

ALTER TABLE demo
ENABLE NOVALIDATE CONSTRAINT c2;

SELECT *
  FROM demo;

INSERT INTO demo
     VALUES (5);    
     
--nullif

select ename,length(ename) expr1,job,length(job) expr2,nullif(length(ename),length(job)) result from emp;


     