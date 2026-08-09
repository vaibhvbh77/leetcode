Select a.id
from Weather a
 join Weather b
where DATEDIFF(a.recordDate,b.recordDate)=1 AND a.temperature >b.temperature