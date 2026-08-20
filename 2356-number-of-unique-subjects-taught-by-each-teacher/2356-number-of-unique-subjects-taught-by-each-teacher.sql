# Write your MySQL query statement below
SELECT teacher_id ,COUNT(Distinct subject_id) as cnt
from Teacher
Group by teacher_id;


