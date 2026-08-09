# Write your MySQL query statement below
select unique_id , name 
from Employees a
LEFT JOIN  EmployeeUNI b ON a.id=b.id;