/* Formatted on 2012/12/19 15:04 (Formatter Plus v4.8.8) */
CREATE OR REPLACE FUNCTION get_rows (
   p_tname                    IN       VARCHAR2
)
   RETURN NUMBER AUTHID CURRENT_USER
AS
   l_columnvalue                 NUMBER DEFAULT NULL;
   sql_stmt                      VARCHAR2 (1000);
BEGIN
   EXECUTE IMMEDIATE    'select count(*) from '
                     || p_tname
                INTO l_columnvalue;

   RETURN l_columnvalue;
END;
/


SELECT USER
     , table_name
     , get_rows ('apps.company') "No.of Rows"
  FROM user_tables
 WHERE table_name = 'COMPANY';
 
 

SELECT get_rows (:p)
  FROM DUAL;



