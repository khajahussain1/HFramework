SELECT job, UPPER (job)
  FROM emp;

SELECT UPPER ('logical erp solutions')
  FROM DUAL;

SELECT LOWER(ename), UPPER (ename)
  FROM emp
 WHERE deptno = 20;

SELECT *
  FROM emp
 WHERE job = UPPER('manager')