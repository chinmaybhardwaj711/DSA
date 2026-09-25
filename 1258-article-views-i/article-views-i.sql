# Write your MySQL query statement below
SELECT Distinct author_id as id
From Views 
WHERE author_id = viewer_id
Order by id;