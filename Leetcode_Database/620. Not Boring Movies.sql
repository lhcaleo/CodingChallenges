SELECT *
FROM cinema
WHERE NOT id % 2 = 0 AND NOT description = 'boring'
ORDER BY rating DESC
;

# or use mod function
# WHERE NOT mod(id,2) = 0 AND NOT description = 'boring'