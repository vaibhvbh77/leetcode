# Write your MySQL query statement below
select product_name,year,price 
FROM SALES
LEFT JOIN Product on sales.product_id=product.product_id;
