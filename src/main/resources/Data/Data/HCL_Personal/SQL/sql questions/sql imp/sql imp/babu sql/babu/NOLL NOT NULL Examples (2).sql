/* Formatted on 2012/12/16 11:12 (Formatter Plus v4.8.8) */
SELECT ename, deptno, comm
  FROM emp
 WHERE comm IS NULL;

SELECT ename, deptno, comm
  FROM emp
 WHERE comm IS NOT NULL;

SELECT ename, deptno, mgr, job
  FROM emp
 WHERE mgr IS NULL;

SELECT ename, deptno, mgr, job
  FROM emp
 WHERE mgr IS NOT NULL;