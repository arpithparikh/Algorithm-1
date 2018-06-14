# Write your MySQL query statement below
SELECT DISTINCT c1.seat_id 
FROM cinema AS c1 JOIN cinema AS c2 ON abs(c1.seat_id - c2.seat_id) = 1 AND c1.free = 1 AND c2.free = 1
ORDER BY c1.seat_id