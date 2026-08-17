# Write your MySQL query statement below
SELECT distinct author_id
from VIEWS
where author_id=viewer_id
order by author_id asc