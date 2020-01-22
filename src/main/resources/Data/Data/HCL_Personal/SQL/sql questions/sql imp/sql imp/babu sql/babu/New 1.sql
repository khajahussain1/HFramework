ELECT b.assignment_number,
b.full_name,
d.original_date_of_hire,
d.date_of_birth,
a.ELEMENT_NAME,
a.CLASSIFICATION_NAME,
a.OUTPUT_CURRENCY_CODE,
MODIFIED,
UNITS,
a.ASSIGNMENT_ACTION_ID,
a.RUN_RESULT_ID,
a.RESULT_VALUE,
a.UOM,
a.INPUT_VALUE_ID 
FROM PAY_RUN_RESULTS_V a ,
PAY_ASSIGNMENT_ACTIONS_V b,
per_all_assignments_f c,
per_all_people_f d
where
a.assignment_action_id = b.assignment_action_id
and PAYROLL_ACTION_ID = :p_action_id
and b.assignment_id = c.assignment_id
and d.person_id = c.person_id
and sysdate between c.effective_start_date and c.effective_end_date
and sysdate between d.effective_start_date and d.effective_end_date 
order by  b.full_name,a.ELEMENT_NAME;