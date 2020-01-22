SELECT job, LOWER (job)
  FROM emp;

SELECT LOWER ('LOGICAL ERP SOLUTIONS')
  FROM DUAL;

SELECT ename, LOWER (ename)
  FROM emp
 WHERE deptno = 20;

SELECT *
  FROM emp
 WHERE LOWER (job) = 'manager'