# Array & Matrix

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

### Description

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

## 74. Search a 2D Matrix (Medium)

### Description

Write an efficient algorithm that searches for a value in an *m* x *n* matrix. This matrix has the following properties:

- Integers in each row are sorted from left to right.
- The first integer of each row is greater than the last integer of the previous row.

**Example 1:**

```
Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true
```

**Example 2:**

```
Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false
```

### Solution

```java
class Solution 
{
    public boolean searchMatrix(int[][] matrix, int target) 
    {
        if (matrix == null || matrix.length == 0) 
            return false;
        // m rows, n columns
        int m = matrix.length;
		int n = matrix[0].length; 
        
        int start = 0;
        int end = m * n - 1;
        
        while (start <= end)
        {
            int mid = start + (end-start) / 2;
            int x = mid / n; // row index
            int y = mid % n; // column index
            
            if (matrix[x][y] == target)
            {
                return true;
            }
            else if (matrix[x][y] < target)
            {
                start = mid + 1;
            }
            else
            {
                end = mid - 1;
            }
        }    
        
        return false;    
    }
}
```



## 240. Search a 2D Matrix II (Medium)

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

## 378. Kth Smallest Element in a Sorted Matrix (Medium)

### Description

Given a *n* x *n* matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

**Example:**

```
matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
```

### Solution

**Binary Search**

```java
class Solution
{
    public int kthSmallest(int[][] matrix, int k) 
    {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        
        while (left <= right) 
        {
            int mid = left + (right - left) / 2;
            int count = 0;
            
            for (int i = 0; i < n; i++) 
            {
                for (int j = 0; j < n; j++) 
                {
                    if (matrix[i][j] <= mid)
                        count++;
                }
            }
            
            if (count < k) 
                left = mid + 1;
            else 
                right = mid - 1;
        }
        
        return left;
    }
}
```

**Priority Queue** - Max Queue

```java
// Max Queue

class Solution 
{
    public int kthSmallest(int[][] matrix, int k) 
    {
        int n = matrix.length;
        PriorityQueue<Integer> max_queue = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer t1, Integer t2)
            {
                return t2 - t1;
            }
        });
        
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                max_queue.add(matrix[i][j]);
                if (max_queue.size() > k)
                {
                    max_queue.poll();
                }
            }
        }
        
        return max_queue.peek();
    }
}
```

