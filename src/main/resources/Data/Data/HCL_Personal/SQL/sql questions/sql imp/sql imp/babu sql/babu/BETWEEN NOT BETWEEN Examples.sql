-- BETWEEN ... AND ....  NOT  BETWEEN ... AND .... 

SELECT empno, ename, comm
  FROM emp
 WHERE comm BETWEEN 500 AND 1000;

SELECT empno, ename, job, sal, comm
  FROM emp
 WHERE sal NOT BETWEEN 1000 AND 1500;

SELECT empno, ename, job, sal, comm
  FROM emp
 WHERE job BETWEEN 'MANAGER' AND 'SALESMAN';

SELECT empno, ename, job, sal, comm
  FROM emp
 WHERE job NOT BETWEEN 'MANAGER' AND 'SALESMAN';

SELECT empno, ename, job, hiredate, sal, comm
  FROM emp
 WHERE hiredate BETWEEN '17-FEB-1981' AND '20-JUN-1983';

SELECT empno, ename, job, hiredate, sal, comm
  FROM emp
 WHERE hiredate NOT BETWEEN '17-FEB-1981' AND '20-JUN-1983';
 
 