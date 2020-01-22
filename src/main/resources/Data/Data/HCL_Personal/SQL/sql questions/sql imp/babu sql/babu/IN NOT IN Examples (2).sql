-- IN  NOT IN  

SELECT ename, sal, job
  FROM emp
 WHERE ename IN ('FORD', 'SMITH');

SELECT ename, sal, job
  FROM emp
 WHERE ename NOT IN ('FORD', 'SMITH');

SELECT ename, sal, job, deptno
  FROM emp
 WHERE deptno IN (20, 30);

SELECT ename, sal, job, deptno
  FROM emp
 WHERE NOT deptno IN (20, 30);

SELECT ename, sal, job, deptno, hiredate
  FROM emp
 WHERE hiredate IN ('20-FEB-1981', '09-JUN-1981');

SELECT ename, sal, job, deptno, hiredate
  FROM emp
 WHERE hiredate NOT IN ('20-FEB-1981', '09-JUN-1981');