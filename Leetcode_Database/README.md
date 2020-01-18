# Solutions of Leetcode Database Problems
<a id="markdown-solutions-of-leetcode-database-problems" name="solutions-of-leetcode-database-problems"></a>
<!-- TOC -->

- [Solutions of Leetcode Database Problems](#solutions-of-leetcode-database-problems)
  - [175. Combine Two Tables](#175-combine-two-tables)
    - [Description](#description)
    - [Solution](#solution)
  - [176. Second Highest Salary](#176-second-highest-salary)
    - [Description](#description-1)
    - [Solution](#solution-1)
  - [595. Big Countries](#595-big-countries)
    - [Description](#description-2)
    - [Solution](#solution-2)
  - [627. Swap Salary](#627-swap-salary)
    - [Description](#description-3)
    - [Solution](#solution-3)
  - [620. Not Boring Movies](#620-not-boring-movies)
    - [Description](#description-4)
    - [Solution](#solution-4)
  - [596. Classes More Than 5 Students](#596-classes-more-than-5-students)
    - [Description](#description-5)
    - [Solution](#solution-5)
  - [182. Duplicate Emails](#182-duplicate-emails)
    - [Description](#description-6)
    - [Solution](#solution-6)
  - [196. Delete Duplicate Emails](#196-delete-duplicate-emails)
    - [Description](#description-7)
    - [Solution](#solution-7)

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

