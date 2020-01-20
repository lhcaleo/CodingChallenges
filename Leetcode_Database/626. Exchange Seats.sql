# Use Multiple Union

# Even id: id - 1
# eg 2,4,6,... to 1,3,5,...
SELECT
    s1.id - 1 AS id,
    s1.student
FROM
    seat s1
WHERE
    MOD(s1.id, 2) = 0 
    
UNION

# Odd id，id + 1. if the largest id is odd, then ignore
# eg 1,3,5,... to 2,4,6,...
SELECT
    s2.id + 1 AS id,
    s2.student
FROM
    seat s2
WHERE
    MOD(s2.id, 2) = 1
    AND s2.id != ( SELECT max( s3.id ) FROM seat s3 ) 
    
UNION

# If largest id is odd, take this out
SELECT
    s4.id AS id,
    s4.student
FROM
    seat s4
WHERE
    MOD(s4.id, 2) = 1
    AND s4.id = ( SELECT max( s5.id ) FROM seat s5 )
ORDER BY id
;