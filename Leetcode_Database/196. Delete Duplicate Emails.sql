DELETE p1
FROM Person p1, Person p2
WHERE p1.Email = p2.Email AND p1.Id > p2.Id
;

-- More efficient way
DELETE FROM Person
WHERE Id NOT IN 
(   -- delete rows that is not in the selection
    SELECT Id FROM
   (
       SELECT MIN(Id) AS Id -- ignore rows with greater Id and same Email
       FROM Person
       GROUP BY Email
   ) AS temp    -- use as temp table, to avoid error
)
;
