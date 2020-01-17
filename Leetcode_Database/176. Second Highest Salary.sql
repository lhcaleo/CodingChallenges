SELECT
(
    SELECT DISTINCT Salary
    FROM Employee
    ORDER BY Salary DESC
    LIMIT 1,1) 
AS SecondHighestSalary
;

# The IFNULL() function returns a specified value if the expression is NULL.
# If the expression is NOT NULL, this function returns the expression.
SELECT
    IFNULL
    (
        (SELECT DISTINCT Salary
        FROM Employee
        ORDER BY Salary DESC
        LIMIT 1,1)
        , NULL
    )
AS SecondHighestSalary
;