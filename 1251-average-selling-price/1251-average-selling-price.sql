# Write your MySQL query statement below
Select p.product_id, ROUND(COALESCE(SUM(p.price*us.units)/SUM(us.units) ,0),2) as average_price
from Prices p
Left Join UnitsSold us
on p.product_id=us.product_id AND us.purchase_date between p.start_date and p.end_date
Group by p.product_id

