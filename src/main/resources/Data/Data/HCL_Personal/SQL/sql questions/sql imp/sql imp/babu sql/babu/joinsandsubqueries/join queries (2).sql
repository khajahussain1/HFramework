/* Formatted on 2012/12/17 12:39 (Formatter Plus v4.8.8) */
-- Example of Equi-join/Inner Join/Simple Join   
SELECT e.empno "Employee Number"
     , e.ename "Employee Name"
     , e.deptno "Employee Dept.No"
     , d.deptno "Department No"
     , d.loc "Department Location"
  FROM emp e
     , dept d
 WHERE e.deptno = d.deptno;
 
-- Example of Non Equi-join  
SELECT e.ename "Employee Name"
     , e.sal "Employee Salary"
     , s.grade "Employee Grade"
  FROM emp e
     , salgrade s
 WHERE e.sal BETWEEN s.losal AND s.hisal;

-- Example of Outer Join's  
/*  Left Outer Join */
SELECT   e.ename "Employee Name"
       , d.deptno "Department No"
       , d.dname "Department Name"
    FROM emp e
       , dept d
   WHERE e.deptno(+) = d.deptno
ORDER BY e.deptno;

/*  Right Outer Join */
SELECT   e.ename "Employee Name"
       , d.deptno "Department No"
       , d.dname "Department Name"
    FROM emp e
       , dept d
   WHERE e.deptno = d.deptno(+)
ORDER BY e.deptno;



-- Examples of Outer Joins  

INSERT INTO emp
     VALUES (100
           , 'test name'
           , 'test job'
           , 101
           , SYSDATE
           , 5000
           , 200
           , 60
            );



SELECT e.ename
     , d.deptno
  FROM emp e LEFT OUTER JOIN dept d ON (e.deptno = d.deptno);


SELECT e.ename
     , d.deptno
  FROM emp e RIGHT OUTER JOIN dept d ON (e.deptno = d.deptno);


SELECT e.ename
     , d.deptno
  FROM emp e FULL OUTER JOIN dept d ON (e.deptno = d.deptno);

-- Example of Self Join 

SELECT    worker.ename
       || ' works for '
       || manager.ename
  FROM emp worker
     , emp manager
 WHERE worker.mgr = manager.empno;
 

 
 
