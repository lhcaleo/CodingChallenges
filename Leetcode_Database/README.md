# Solutions of 15 Leetcode Database Problems
<a id="markdown-solutions-of-15-leetcode-database-problems" name="solutions-of-15-leetcode-database-problems"></a>
<!-- TOC -->

- [Solutions of 15 Leetcode Database Problems](#solutions-of-15-leetcode-database-problems)
  - [175. Combine Two Tables](#175-combine-two-tables)
    - [Description](#description)
    - [Solution](#solution)
  - [595. Big Countries](#595-big-countries)
    - [Description](#description-1)
    - [Solution](#solution-1)
  - [627. Swap Salary](#627-swap-salary)
    - [Description](#description-2)
    - [Solution](#solution-2)
  - [620. Not Boring Movies](#620-not-boring-movies)
    - [Description](#description-3)
    - [Solution](#solution-3)
  - [596. Classes More Than 5 Students](#596-classes-more-than-5-students)
    - [Description](#description-4)
    - [Solution](#solution-4)
  - [182. Duplicate Emails](#182-duplicate-emails)
    - [Description](#description-5)
    - [Solution](#solution-5)
  - [196. Delete Duplicate Emails](#196-delete-duplicate-emails)
    - [Description](#description-6)
    - [Solution](#solution-6)
  - [181. Employees Earning More Than Their Managers](#181-employees-earning-more-than-their-managers)
    - [Description](#description-7)
    - [Solution](#solution-7)
  - [183. Customers Who Never Order](#183-customers-who-never-order)
    - [Description](#description-8)
    - [Solution](#solution-8)
  - [184. Department Highest Salary](#184-department-highest-salary)
    - [Description](#description-9)
    - [Solution](#solution-9)
  - [176. Second Highest Salary](#176-second-highest-salary)
    - [Description](#description-10)
    - [Solution](#solution-10)
  - [177. Nth Highest Salary](#177-nth-highest-salary)
    - [Description](#description-11)
    - [Solution](#solution-11)
  - [178. Rank Scores](#178-rank-scores)
    - [Description](#description-12)
    - [Solution](#solution-12)
  - [180. Consecutive Numbers](#180-consecutive-numbers)
    - [Description](#description-13)
    - [Solution](#solution-13)
  - [626. Exchange Seats](#626-exchange-seats)
    - [Description](#description-14)
    - [Solution](#solution-14)

<!-- /TOC -->
## 175. Combine Two Tables
<a id="markdown-combine-two-tables" name="combine-two-tables"></a>

https://leetcode.com/problems/combine-two-tables/description/

### Description
<a id="markdown-description" name="description"></a>

Table: `Person`

```
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| PersonId    | int     |
| FirstName   | varchar |
| LastName    | varchar |
+-------------+---------+
PersonId is the primary key column for this table.
```

Table: `Address`

```
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| AddressId   | int     |
| PersonId    | int     |
| City        | varchar |
| State       | varchar |
+-------------+---------+
AddressId is the primary key column for this table.
```

Write a SQL query for a report that provides the following information for each person in the Person table, regardless if there is an address for each of those people:

```
FirstName, LastName, City, State
```

### Solution
<a id="markdown-solution" name="solution"></a>

```mysql
SELECT FirstName, LastName, City, State
FROM Person 
LEFT JOIN Address 
ON Person.PersonId = Address.PersonId
```





## 595. Big Countries
<a id="markdown-big-countries" name="big-countries"></a>

https://leetcode.com/problems/big-countries/

### Description
<a id="markdown-description" name="description"></a>

There is a table `World`

```
+-----------------+------------+------------+--------------+---------------+
| name            | continent  | area       | population   | gdp           |
+-----------------+------------+------------+--------------+---------------+
| Afghanistan     | Asia       | 652230     | 25500100     | 20343000      |
| Albania         | Europe     | 28748      | 2831741      | 12960000      |
| Algeria         | Africa     | 2381741    | 37100000     | 188681000     |
| Andorra         | Europe     | 468        | 78115        | 3712000       |
| Angola          | Africa     | 1246700    | 20609294     | 100990000     |
+-----------------+------------+------------+--------------+---------------+
```

A country is big if it has an area of bigger than 3 million square km or a population of more than 25 million.

Write a SQL solution to output big countries' name, population and area.

For example, according to the above table, we should output:

```
+--------------+-------------+--------------+
| name         | population  | area         |
+--------------+-------------+--------------+
| Afghanistan  | 25500100    | 652230       |
| Algeria      | 37100000    | 2381741      |
+--------------+-------------+--------------+
```

### Solution
<a id="markdown-solution" name="solution"></a>

```mysql
SELECT name, population, area
FROM World
WHERE area > 3000000 OR population > 25000000
```



## 627. Swap Salary
<a id="markdown-swap-salary" name="swap-salary"></a>

https://leetcode.com/problems/swap-salary/

### Description
<a id="markdown-description" name="description"></a>

Given a table `salary`, such as the one below, that has m=male and f=female values. Swap all f and m values (i.e., change all f values to m and vice versa) with a **single update statement** and no intermediate temp table.

Note that you must write a single update statement, **DO NOT** write any select statement for this problem.

 

**Example:**

```
| id | name | sex | salary |
|----|------|-----|--------|
| 1  | A    | m   | 2500   |
| 2  | B    | f   | 1500   |
| 3  | C    | m   | 5500   |
| 4  | D    | f   | 500    |
```

After running your **update** statement, the above salary table should have the following rows:

```
| id | name | sex | salary |
|----|------|-----|--------|
| 1  | A    | f   | 2500   |
| 2  | B    | m   | 1500   |
| 3  | C    | f   | 5500   |
| 4  | D    | m   | 500    |
```



### Solution
<a id="markdown-solution" name="solution"></a>

```mysql
UPDATE salary
SET sex = 
    CASE sex
        WHEN 'm' THEN 'f'
        ELSE 'm'
    END
;
# or 
UPDATE salary
SET sex = 
    CASE
        WHEN sex ='m' THEN 'f'
        ELSE 'm'
    END
;
```

**Or, use IF( ) function**

`IF(condition, value_if_true, value_if_false)`

```
UPDATE salary
SET sex = IF (sex = 'm', 'f', 'm')
;
```



## 620. Not Boring Movies
<a id="markdown-not-boring-movies" name="not-boring-movies"></a>

https://leetcode.com/problems/not-boring-movies/

### Description
<a id="markdown-description" name="description"></a>

X city opened a new cinema, many people would like to go to this cinema. The cinema also gives out a poster indicating the movies’ ratings and descriptions.

Please write a SQL query to output movies with an odd numbered ID and a description that is not 'boring'. Order the result by rating.

For example, table `cinema`:

```
+---------+-----------+--------------+-----------+
|   id    | movie     |  description |  rating   |
+---------+-----------+--------------+-----------+
|   1     | War       |   great 3D   |   8.9     |
|   2     | Science   |   fiction    |   8.5     |
|   3     | irish     |   boring     |   6.2     |
|   4     | Ice song  |   Fantacy    |   8.6     |
|   5     | House card|   Interesting|   9.1     |
+---------+-----------+--------------+-----------+
```

For the example above, the output should be:

```
+---------+-----------+--------------+-----------+
|   id    | movie     |  description |  rating   |
+---------+-----------+--------------+-----------+
|   5     | House card|   Interesting|   9.1     |
|   1     | War       |   great 3D   |   8.9     |
+---------+-----------+--------------+-----------+
```

### Solution
<a id="markdown-solution" name="solution"></a>

```mysql
SELECT *
FROM cinema
WHERE NOT id % 2 = 0 AND NOT description = 'boring'
ORDER BY rating DESC
;

# or use mod function
# WHERE NOT mod(id,2) = 0 AND NOT description = 'boring'
```



## 596. Classes More Than 5 Students
<a id="markdown-classes-more-than-5-students" name="classes-more-than-5-students"></a>

https://leetcode.com/problems/classes-more-than-5-students/

### Description
<a id="markdown-description" name="description"></a>

There is a table `courses` with columns: **student** and **class**

Please list out all classes which have more than or equal to 5 students.

For example, the table:

```
+---------+------------+
| student | class      |
+---------+------------+
| A       | Math       |
| B       | English    |
| C       | Math       |
| D       | Biology    |
| E       | Math       |
| F       | Computer   |
| G       | Math       |
| H       | Math       |
| I       | Math       |
+---------+------------+
```

Should output:

```
+---------+
| class   |
+---------+
| Math    |
+---------+
```

 

**Note:**
The students should not be counted duplicate in each course.

### Solution
<a id="markdown-solution" name="solution"></a>

```mysql
SELECT class
FROM courses
GROUP BY class
HAVING COUNT(DISTINCT student) >= 5
;
```



## 182. Duplicate Emails
<a id="markdown-duplicate-emails" name="duplicate-emails"></a>

https://leetcode.com/problems/duplicate-emails/

### Description
<a id="markdown-description" name="description"></a>

Write a SQL query to find all duplicate emails in a table named `Person`.

```
+----+---------+
| Id | Email   |
+----+---------+
| 1  | a@b.com |
| 2  | c@d.com |
| 3  | a@b.com |
+----+---------+
```

For example, your query should return the following for the above table:

```
+---------+
| Email   |
+---------+
| a@b.com |
+---------+
```

**Note**: All emails are in lowercase.

### Solution
<a id="markdown-solution" name="solution"></a>

```mysql
SELECT Email
FROM Person
GROUP BY Email
HAVING COUNT(Email) > 1
;
```



## 196. Delete Duplicate Emails
<a id="markdown-delete-duplicate-emails" name="delete-duplicate-emails"></a>

https://leetcode.com/problems/delete-duplicate-emails/

### Description
<a id="markdown-description" name="description"></a>

Write a SQL query to **delete** all duplicate email entries in a table named `Person`, keeping only unique emails based on its *smallest* **Id**.

```
+----+------------------+
| Id | Email            |
+----+------------------+
| 1  | john@example.com |
| 2  | bob@example.com  |
| 3  | john@example.com |
+----+------------------+
Id is the primary key column for this table.
```

For example, after running your query, the above `Person` table should have the following rows:

```
+----+------------------+
| Id | Email            |
+----+------------------+
| 1  | john@example.com |
| 2  | bob@example.com  |
+----+------------------+
```

**Note:**

Your output is the whole `Person` table after executing your sql. Use `delete` statement.

### Solution
<a id="markdown-solution" name="solution"></a>

```mysql
DELETE p1
FROM Person p1, Person p2
WHERE p1.Email = p2.Email AND p1.Id > p2.Id
;
```



```mysql
-- More efficient way
DELETE FROM Person
WHERE Id NOT IN -- delete rows that is not in the selection
(   
    SELECT Id FROM
   (
       SELECT MIN(Id) AS Id -- ignore rows with greater Id and same Email
       FROM Person
       GROUP BY Email
   ) AS temp    -- use as temp table, to avoid error
)
;
```



## 181. Employees Earning More Than Their Managers
<a id="markdown-employees-earning-more-than-their-managers" name="employees-earning-more-than-their-managers"></a>

https://leetcode.com/problems/employees-earning-more-than-their-managers/

### Description
<a id="markdown-description" name="description"></a>

The `Employee` table holds all employees including their managers. Every employee has an Id, and there is also a column for the manager Id.

```
+----+-------+--------+-----------+
| Id | Name  | Salary | ManagerId |
+----+-------+--------+-----------+
| 1  | Joe   | 70000  | 3         |
| 2  | Henry | 80000  | 4         |
| 3  | Sam   | 60000  | NULL      |
| 4  | Max   | 90000  | NULL      |
+----+-------+--------+-----------+
```

Given the `Employee` table, write a SQL query that finds out employees who earn more than their managers. For the above table, Joe is the only employee who earns more than his manager.

```
+----------+
| Employee |
+----------+
| Joe      |
+----------+
```

### Solution
<a id="markdown-solution" name="solution"></a>

```mysql
SELECT E1.NAME AS Employee
FROM Employee E1
INNER JOIN Employee E2
ON E1.ManagerId = E2.Id AND E1.Salary > E2.Salary
;
```

## 183. Customers Who Never Order
<a id="markdown-customers-who-never-order" name="customers-who-never-order"></a>
https://leetcode.com/problems/customers-who-never-order/
### Description
<a id="markdown-description" name="description"></a>
Suppose that a website contains two tables, the `Customers` table and the `Orders` table. Write a SQL query to find all customers who never order anything.

Table: `Customers`.

```
+----+-------+
| Id | Name  |
+----+-------+
| 1  | Joe   |
| 2  | Henry |
| 3  | Sam   |
| 4  | Max   |
+----+-------+
```

Table: `Orders`.

```
+----+------------+
| Id | CustomerId |
+----+------------+
| 1  | 3          |
| 2  | 1          |
+----+------------+
```

Using the above tables as example, return the following:

```
+-----------+
| Customers |
+-----------+
| Henry     |
| Max       |
+-----------+
```

### Solution
<a id="markdown-solution" name="solution"></a>

```mysql
SELECT 
    C.Name AS Customers
FROM 
    Customers C
    LEFT JOIN Orders O
    ON C.Id = O.CustomerId
WHERE O.CustomerId IS NULL
;
```

```mysql
-- Or, use subquery
SELECT
    Name AS Customers
FROM
    Customers
WHERE
    Id NOT IN 
    ( 
        SELECT CustomerId 
        FROM Orders 
    )
;
```



## 184. Department Highest Salary
<a id="markdown-department-highest-salary" name="department-highest-salary"></a>

https://leetcode.com/problems/department-highest-salary/

### Description
<a id="markdown-description" name="description"></a>

The `Employee` table holds all employees. Every employee has an Id, a salary, and there is also a column for the department Id.

```
+----+-------+--------+--------------+
| Id | Name  | Salary | DepartmentId |
+----+-------+--------+--------------+
| 1  | Joe   | 70000  | 1            |
| 2  | Jim   | 90000  | 1            |
| 3  | Henry | 80000  | 2            |
| 4  | Sam   | 60000  | 2            |
| 5  | Max   | 90000  | 1            |
+----+-------+--------+--------------+
```

The `Department` table holds all departments of the company.

```
+----+----------+
| Id | Name     |
+----+----------+
| 1  | IT       |
| 2  | Sales    |
+----+----------+
```

Write a SQL query to find employees who have the highest salary in each of the departments. For the above tables, your SQL query should return the following rows (order of rows does not matter).

```
+------------+----------+--------+
| Department | Employee | Salary |
+------------+----------+--------+
| IT         | Max      | 90000  |
| IT         | Jim      | 90000  |
| Sales      | Henry    | 80000  |
+------------+----------+--------+
```

**Explanation:**

Max and Jim both have the highest salary in the IT department and Henry has the highest salary in the Sales department.

### Solution
<a id="markdown-solution" name="solution"></a>

```mysql
SELECT 
    D.Name Department, 
    E.Name Employee, 
    E.Salary
FROM 
    Employee E, 
    Department D,
    ( SELECT DepartmentId, MAX(Salary) Salary
        FROM Employee
        GROUP BY DepartmentId ) M
WHERE
    E.DepartmentId = D.Id
    AND E.DepartmentId = M.DepartmentId
    AND E.Salary = M.Salary
;
```



## 176. Second Highest Salary
<a id="markdown-second-highest-salary" name="second-highest-salary"></a>


https://leetcode.com/problems/second-highest-salary/description/

### Description
<a id="markdown-description" name="description"></a>


Write a SQL query to get the second highest salary from the `Employee` table.

```
+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
```

For example, given the above Employee table, the query should return `200` as the second highest salary. If there is no second highest salary, then the query should return `null`.

```
+---------------------+
| SecondHighestSalary |
+---------------------+
| 200                 |
+---------------------+
```

### Solution
<a id="markdown-solution" name="solution"></a>


```mysql
SELECT
(
    SELECT DISTINCT Salary
    FROM Employee
    ORDER BY Salary DESC
    LIMIT 1,1) 
AS SecondHighestSalary
;
```



```mysql
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
```



```mysql
SELECT MAX(Salary) AS SecondHighestSalary
FROM Employee
WHERE Salary < (SELECT MAX(Salary) FROM Employee)
;
```



## 177. Nth Highest Salary
<a id="markdown-nth-highest-salary" name="nth-highest-salary"></a>

https://leetcode.com/problems/nth-highest-salary/

### Description
<a id="markdown-description" name="description"></a>

Write a SQL query to get the *n*th highest salary from the `Employee` table.

```
+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
```

For example, given the above Employee table, the *n*th highest salary where *n* = 2 is `200`. If there is no *n*th highest salary, then the query should return `null`.

```
+------------------------+
| getNthHighestSalary(2) |
+------------------------+
| 200                    |
+------------------------+
```

### Solution
<a id="markdown-solution" name="solution"></a>

```mysql
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
```



## 178. Rank Scores
<a id="markdown-rank-scores" name="rank-scores"></a>

https://leetcode.com/problems/rank-scores/

### Description
<a id="markdown-description" name="description"></a>

Write a SQL query to rank scores. If there is a tie between two scores, both should have the same ranking. Note that after a tie, the next ranking number should be the next consecutive integer value. In other words, there should be no "holes" between ranks.

```
+----+-------+
| Id | Score |
+----+-------+
| 1  | 3.50  |
| 2  | 3.65  |
| 3  | 4.00  |
| 4  | 3.85  |
| 5  | 4.00  |
| 6  | 3.65  |
+----+-------+
```

For example, given the above `Scores` table, your query should generate the following report (order by highest score):

```
+-------+------+
| Score | Rank |
+-------+------+
| 4.00  | 1    |
| 4.00  | 1    |
| 3.85  | 2    |
| 3.65  | 3    |
| 3.65  | 3    |
| 3.50  | 4    |
+-------+------+
```

### Solution
<a id="markdown-solution" name="solution"></a>

```mysql
-- To determine the ranking of a score, count the number of distinct scores that are >= to that score
SELECT
    S1.Score 'Score',
    ( 
        SELECT 
            COUNT(DISTINCT Score) 
         FROM Scores S2 
         WHERE S2.Score >= S1.Score
    ) AS 'Rank'
FROM Scores S1
ORDER BY Score DESC
;
```



```mysql
-- To determine the ranking of a score, count the number of distinct scores that are >= to that score
SELECT
    S1.Score 'Score',
    COUNT(DISTINCT S2.Score) AS 'Rank'
FROM Scores S1
     INNER JOIN Scores S2
     ON S2.Score >= S1.Score
GROUP BY
    S1.Id, S1.Score
ORDER BY 
    S1.Score DESC
;
```

**Last solution with explaination**

![image](https://assets.leetcode.com/users/sophiesu0827/image_1576871668.png)

```mysql
SELECT S1.Score, COUNT(S2.Score) AS Rank FROM Scores S1,
(SELECT DISTINCT Score FROM Scores) AS S2
WHERE S2.Score >= S1.Score
GROUP BY S1.Id 
ORDER BY S1.Score DESC
;
```



## 180. Consecutive Numbers
<a id="markdown-consecutive-numbers" name="consecutive-numbers"></a>

https://leetcode.com/problems/consecutive-numbers/

### Description
<a id="markdown-description" name="description"></a>

Write a SQL query to find all numbers that appear at least three times consecutively.

```
+----+-----+
| Id | Num |
+----+-----+
| 1  |  1  |
| 2  |  1  |
| 3  |  1  |
| 4  |  2  |
| 5  |  1  |
| 6  |  2  |
| 7  |  2  |
+----+-----+
```

For example, given the above `Logs` table, `1` is the only number that appears consecutively for at least three times.

```
+-----------------+
| ConsecutiveNums |
+-----------------+
| 1               |
+-----------------+
```

### Solution
<a id="markdown-solution" name="solution"></a>

```mysql
SELECT
    DISTINCT L1.Num AS ConsecutiveNums
FROM
    Logs L1,
    Logs L2,
    Logs L3
WHERE L1.Id = L2.Id - 1 AND L2.Id = L3.Id - 1
AND   L1.Num = L2.Num AND L2.Num = L3.Num
;
```



## 626. Exchange Seats
<a id="markdown-exchange-seats" name="exchange-seats"></a>

https://leetcode.com/problems/exchange-seats/

### Description
<a id="markdown-description" name="description"></a>

Mary is a teacher in a middle school and she has a table `seat` storing students' names and their corresponding seat ids.

The column **id** is continuous increment.

 

Mary wants to change seats for the adjacent students.

 

Can you write a SQL query to output the result for Mary?

 

```
+---------+---------+
|    id   | student |
+---------+---------+
|    1    | Abbot   |
|    2    | Doris   |
|    3    | Emerson |
|    4    | Green   |
|    5    | Jeames  |
+---------+---------+
```

For the sample input, the output is:

 

```
+---------+---------+
|    id   | student |
+---------+---------+
|    1    | Doris   |
|    2    | Abbot   |
|    3    | Green   |
|    4    | Emerson |
|    5    | Jeames  |
+---------+---------+
```

**Note:**
If the number of students is odd, there is no need to change the last one's seat.

### Solution
<a id="markdown-solution" name="solution"></a>

**Use Multiple Union**

```mysql
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
```

