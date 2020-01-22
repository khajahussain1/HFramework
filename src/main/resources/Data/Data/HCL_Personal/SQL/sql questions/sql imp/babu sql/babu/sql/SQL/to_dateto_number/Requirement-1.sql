CREATE TABLE company
(ename VARCHAR2(30),
 url   VARCHAR2(100));
 
 
INSERT INTO company
     VALUES ('x'
           , 'www.oracle.com'
            );

INSERT INTO company
     VALUES ('y'
           , 'www.accenture.com'
            );

INSERT INTO company
     VALUES ('z'
           , 'www.wipro.com'
            );

-- STEPS TO DEVELOPE QUERY  

SELECT *
  FROM company;

SELECT SUBSTR (url, 5)
  FROM company;

SELECT INSTR (SUBSTR (url, 5), '.')
  FROM company


SELECT SUBSTR (url
             , 5
             ,   INSTR (SUBSTR (url, 5), '.')-1
              )
  FROM company;