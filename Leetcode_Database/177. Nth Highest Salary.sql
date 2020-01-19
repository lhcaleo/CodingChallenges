CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT

BEGIN
  SET N = N - 1;    -- index offset
  RETURN 
  (
      SELECT DISTINCT 
        Salary
      FROM Employee
      ORDER BY Salary DESC
      LIMIT N, 1
  );
END