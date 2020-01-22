/* Formatted on 2012/12/16 12:05 (Formatter Plus v4.8.8) */
SELECT INITCAP (ename)
  FROM emp;

SELECT INITCAP ('logical erp solutions')
  FROM DUAL;

SELECT empno, INITCAP (ename), deptno
  FROM emp
 WHERE ename = UPPER ('ford')