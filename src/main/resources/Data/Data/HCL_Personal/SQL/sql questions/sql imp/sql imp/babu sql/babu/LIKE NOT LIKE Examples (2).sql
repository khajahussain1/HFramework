-- LIKE NOT LIKE OPERATORS...

SELECT empno, ename
  FROM emp
 WHERE ename LIKE 'M%';

SELECT empno, ename
  FROM emp
 WHERE ename NOT LIKE 'M%';

SELECT empno, ename
  FROM emp
 WHERE ename LIKE '_O%';

SELECT empno, ename
  FROM emp
 WHERE ename NOT LIKE '_O%';

SELECT empno, ename
  FROM emp
 WHERE ename LIKE 'SM%';

SELECT empno, ename, job
  FROM emp
 WHERE job LIKE '_____';

SELECT empno, ename, hiredate
  FROM emp
 WHERE hiredate LIKE '%-FEB-1981';

SELECT empno, ename, hiredate
  FROM emp
 WHERE hiredate LIKE '%FEB%';

SELECT *
  FROM dept
 WHERE dname LIKE '__\_%' ESCAPE '\';

UPDATE dept
   SET dname = 'SO_FT_WARE'
 WHERE deptno = 50;

SELECT *
  FROM dept;