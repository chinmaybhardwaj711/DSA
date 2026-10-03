-- # Write your MySQL query statement below
SELECT m.machine_id,ROUND(AVG( e.timestamp-m.timestamp),3) AS processing_time
FROM Activity m
JOIN Activity e
ON m.machine_id =e.machine_id
AND  m.process_id = e.process_id
Where m.activity_type = 'start'
AND e.activity_type = 'end'
Group by m.machine_id;

























































-- SELECT a.machine_id,ROUND(AVG(b.timestamp-a.timestamp),3) AS processing_time
-- FROM Activity a
-- JOIN Activity b
-- ON a.machine_id = b.machine_id
-- AND a.process_id = b.process_id
-- WHERE a.activity_type = 'start'
-- AND b.activity_type = 'end'
-- GROUP BY a.machine_id;
