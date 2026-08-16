# Write your MySQL query statement below
SELECT *
FROM Cinema 
where description<>'boring' and id%2=1
order by rating desc