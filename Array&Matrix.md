# Array & Matix

## 283. Move Zeroes (Easy)

### Description

Given an array `nums`, write a function to move all `0`'s to the end of it while maintaining the relative order of the non-zero elements.

**Example:**

```
Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
```

**Note**:

1. You must do this **in-place** without making a copy of the array.
2. Minimize the total number of operations.

### Solution

```java
// Time: O(n) Space: O(1)
class Solution 
{
    public void moveZeroes(int[] nums) 
    {
        int i = 0;
        
        for (int num: nums)
        {
            if (num != 0)
            {
                nums[i] = num;
                i++;
            }
        }
        
        while (i < nums.length)
        {
            nums[i] = 0;
            i++;
        }
    }
}
```

## 566. Reshape Matrix (Easy)

### Description

```
Input: 
nums = 
[[1,2],
 [3,4]]
r = 1, c = 4
Output: 
[[1,2,3,4]]
Explanation:
The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.
```

```
Input: 
nums = 
[[1,2],
 [3,4]]
r = 2, c = 4
Output: 
[[1,2],
 [3,4]]
Explanation:
There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.
```

### Solution

```java
class Solution 
{
    public int[][] matrixReshape(int[][] nums, int r, int c) 
    {
        if (nums == null || nums.length == 0) return null;
        
        int row = nums.length;
        int col = nums[0].length;
        if (row * col != r * c) return nums;
        
        int[][] res = new int[r][c];
        int index = 0;
        
        // index / col = entry's row
        // index % col = entry's column
        for (int i = 0; i < r; i++)
        {
            for (int j = 0; j < c; j++ )
            {
                res[i][j] = nums[index / col][index % col];
                index++;
            }
        }
        return res;
    }
}
```

## 485. Max Consecutive Ones

###Description

Given a binary array, find the maximum number of consecutive 1s in this array.

**Example 1:**

```
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.
```

### Solution

```java
// Time: O(n) Space: O(1)
class Solution 
{
    public int findMaxConsecutiveOnes(int[] nums) 
    {
        int max = 0;
        int temp = 0;
        
        for (int num: nums)
        {
            if (num == 1)
            {
                temp++;
            } 
            else if (num == 0) 
            {
                temp = 0;
            }
            max = Math.max(max, temp);
        }
        return max;
    }
}
```

## Search a 2D Matrix II (Medium)

## Description

Write an efficient algorithm that searches for a value in an *m* x *n* matrix. This matrix has the following properties:

- Integers in each row are sorted in ascending from left to right.
- Integers in each column are sorted in ascending from top to bottom.

**Example:**

Consider the following matrix:

```
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
```

Given target = `5`, return `true`.

Given target = `20`, return `false`.

### Solution

```java
// Binary Search. Time: O(m+n) better than brute force O(m*n)

class Solution 
{
    public boolean searchMatrix(int[][] matrix, int target)
    {
        if (matrix == null || matrix.length == 0) 
            return false;

        int row = 0;
        int col = matrix[0].length - 1; 
        
        // start compareing with last element at first row
        // if element > target, we can ignore the element's column
        // if element < target, we can ignore the elements' row
        while (row < matrix.length && col >= 0)
        {
            if (matrix[row][col] == target) 
                return true;
            if (matrix[row][col] > target)
                col--;
            else
                row++;
        }
        
        return false;
    }
}
```

