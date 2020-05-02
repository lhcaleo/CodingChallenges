# Array & Matrix
- [Array & Matrix](#array--matrix)
  - [283. Move Zeroes (Easy)](#283-move-zeroes-easy)
    - [Description](#description)
    - [Solution](#solution)
  - [566. Reshape Matrix (Easy)](#566-reshape-matrix-easy)
    - [Description](#description-1)
    - [Solution](#solution-1)
  - [485. Max Consecutive Ones (Easy)](#485-max-consecutive-ones-easy)
    - [Description](#description-2)
    - [Solution](#solution-2)
  - [74. Search a 2D Matrix (Medium)](#74-search-a-2d-matrix-medium)
    - [Description](#description-3)
    - [Solution](#solution-3)
  - [240. Search a 2D Matrix II (Medium)](#240-search-a-2d-matrix-ii-medium)
    - [Description](#description-4)
    - [Solution](#solution-4)
  - [378. Kth Smallest Element in a Sorted Matrix (Medium)](#378-kth-smallest-element-in-a-sorted-matrix-medium)
    - [Description](#description-5)
    - [Solution](#solution-5)
  - [287. Find the Duplicate Number (Medium)](#287-find-the-duplicate-number-medium)
    - [Description](#description-6)
    - [Solution](#solution-6)
  - [645. Set Mismatch (Easy)](#645-set-mismatch-easy)
    - [Description](#description-7)
    - [Solution](#solution-7)
  - [667. Beautiful Arrangement II (Medium)](#667-beautiful-arrangement-ii-medium)
    - [Description](#description-8)
    - [Solution](#solution-8)
  - [697. Degree of an Array (Easy)](#697-degree-of-an-array-easy)
    - [Description](#description-9)
    - [Solution](#solution-9)
  - [766. Toeplitz Matrix (Easy)](#766-toeplitz-matrix-easy)
    - [Description](#description-10)
    - [Solution](#solution-10)
  - [565. Array Nesting (Medium)](#565-array-nesting-medium)
    - [Description](#description-11)
    - [Solution](#solution-11)
  - [769. Max Chunks To Make Sorted (Medium)](#769-max-chunks-to-make-sorted-medium)
    - [Description](#description-12)
    - [Solution](#solution-12)
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

## 485. Max Consecutive Ones (Easy)

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

### Description

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

## 287. Find the Duplicate Number (Medium)

### Description

Given an array *nums* containing *n* + 1 integers where each integer is between 1 and *n* (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

**Example 1:**

Copy

```
Input: [1,3,4,2,2]
Output: 2
```

**Example 2:**

```
Input: [3,1,3,4,2]
Output: 3
```

**Note:**

1. You **must not** modify the array (assume the array is read only).
2. You must use only constant, *O*(1) extra space.
3. Your runtime complexity should be less than *O*(*n*2).
4. There is only one duplicate number in the array, but it could be repeated more than once.

### Solution

```c++
// Time: n O(log n) for loop within binary search
// Space: O(1)
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        int left = 0;
        int right = nums.size() - 1;
        
        while (left < right)
        {
            int mid = left + (right - left) / 2;
            int counter = 0;
            
            // count # of numbers <= middle number of the range [1, n] 
            for (int num: nums)
            {
                if (num <= mid)
                    counter++;
            }
            
            // duplicate is in the left portion [left, mid],
            // otherwise, in [mid + 1, right]
            if (counter > mid)
                right = mid;
            else
                left = mid + 1;
        }
        
        return left;
    }
};
```



## 645. Set Mismatch (Easy)

### Description

The set `S` originally contains numbers from 1 to `n`.

Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.

**Example 1:**

```
Input: nums = [1,2,2,4]
Output: [2,3]
```

**Example 2:**

```
Input: nums = [2,2]
Output: [2,1]
```

### Solution

```java
// Time: O(n) Space: O(1)
class Solution 
{
    public int[] findErrorNums(int[] nums) 
    {
        int dup = -1;
        int missing = 1;

        for (int n: nums) 
        {
            // if negative, it's duplicate
            if (nums[Math.abs(n) - 1] < 0)
                dup = Math.abs(n);
            else
                // fisrt visit of a number, change it to negative
                nums[Math.abs(n) - 1] *= -1;
        }

        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i] > 0)
                missing = i + 1;
        }
              
        return new int[]{dup, missing};
    }
}
```

## 667. Beautiful Arrangement II (Medium)

### Description

Given two integers `n` and `k`, you need to construct a list which contains `n` different positive integers ranging from `1` to `n` and obeys the following requirement:
Suppose this list is [a1, a2, a3, ... , an], then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] has exactly `k` distinct integers.

If there are multiple answers, print any of them.

**Example 1:**

```
Input: n = 3, k = 1
Output: [1, 2, 3]
Explanation: The [1, 2, 3] has three different positive integers ranging from 1 to 3, and the [1, 1] has exactly 1 distinct integer: 1.
```

**Example 2:**

```
Input: n = 3, k = 2
Output: [1, 3, 2]
Explanation: The [1, 3, 2] has three different positive integers ranging from 1 to 3, and the [2, 1] has exactly 2 distinct integers: 1 and 2.
```

**Note:**

1. The `n` and `k` are in the range 1 <= k < n <= 104.

### Solution

```c++
// Time: O(n) Space: O(n)
// if k = n - 1, pick numbers interleavingly from head and tail,
// otherwise, simply lay out the rest (i, j) incremental order (all diff is 1)
#include <vector>
using namespace std;

class Solution {
public:
    vector<int> constructArray(int n, int k) {
        vector<int> res;
        
        int i = 1;
        int j = n;
        
        while (i <= j)
        {
            if (k > 1 && k % 2 == 1)
            {
                res.push_back(i++);
                k--;
            }
            else if (k > 1 && k % 2 == 0)
            {
                res.push_back(j--);
                k--;
            }
            else
            {
                res.push_back(i++);
            }
        }
        
        return res;
    }
};
```

## 697. Degree of an Array (Easy)

### Description

Given a non-empty array of non-negative integers `nums`, the **degree** of this array is defined as the maximum frequency of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) subarray of `nums`, that has the same degree as `nums`.

**Example 1:**

```
Input: [1, 2, 2, 3, 1]
Output: 2
Explanation: 
The input array has a degree of 2 because both elements 1 and 2 appear twice.
Of the subarrays that have the same degree:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
The shortest length is 2. So return 2.
```

**Example 2:**

```
Input: [1,2,2,3,1,4,2]
Output: 6
Degree of 3 because 2 appears 3 times
subarrays: [1,2,2,3,1,4,2] = 7, [2,2,3,1,4,2] = 6
thus, return 6
```

**Note:**

`nums.length` will be between 1 and 50,000.

`nums[i]` will be an integer between 0 and 49,999.

### Solution

```c++
// Time: O(n) Space: O(n)
// One pass solution with 2 hashmap
class Solution {
public:
    int findShortestSubArray(vector<int>& nums) 
    {
        unordered_map<int, int> count;
        unordered_map<int, int> first;
        
        int res = 0;
        int degree = 0;
        
        for (int i = 0; i < nums.size(); i++) 
        {
            // record each num's first occurence index
            if (first.count(nums[i]) == 0)
            {
                first[nums[i]] = i;
            } 
            // if num has max frequency, update degree and res
            if (++count[nums[i]] > degree) 
            {
                degree = count[nums[i]];
                res = i - first[nums[i]] + 1;
            } 
            // if num is one of the numbers that has max frequency, 
            // take min of current res and new res (want smallest possible length)
            else if (count[nums[i]] == degree)
            {
                res = min(res, i - first[nums[i]] + 1);
            }
        }
        
        return res;
    }
};
```



## 766. Toeplitz Matrix (Easy)

### Description

A matrix is *Toeplitz* if every diagonal from top-left to bottom-right has the same element.

Now given an `M x N` matrix, return `True` if and only if the matrix is *Toeplitz*.

```
Input:
matrix = [
  [1,2,3,4],
  [5,1,2,3],
  [9,5,1,2]
]
Output: True
Explanation:
In the above grid, the diagonals are:
"[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
In each diagonal all elements are the same, so the answer is True.
```

### Solution

```java
// Time: O(mn) Space: O(1)
// Toeplitz Matrix: staring from second row, each entry is equal to its top-left entry
class Solution {
public:
    bool isToeplitzMatrix(vector<vector<int>>& matrix) 
    {
        int m = matrix.size();
        int n = matrix[0].size();
        
        for (int i = 1; i < m; i++)
        {
            for (int j = 1; j < n; j++)
            {
                if (matrix[i][j] != matrix[i - 1][j - 1])
                    return false;
            }
        }
        
        return true;
    }
};
```



## 565. Array Nesting (Medium)

### Description

A zero-indexed array A of length N contains all integers from 0 to N-1. Find and return the longest length of set S, where S[i] = {A[i], A[A[i]], A[A[A[i]]], ... } subjected to the rule below.

Suppose the first element in S starts with the selection of element A[i] of index = i, the next element in S should be A[A[i]], and then A[A[A[i]]]… By that analogy, we stop adding right before a duplicate element occurs in S.

 

**Example 1:**

```
Input: A = [5,4,0,3,1,6,2]
Output: 4
Explanation: 
A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.

One of the longest S[K]:
S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
```

 **Note:**

1. N is an integer within the range [1, 20,000].
2. The elements of A are all distinct.
3. Each element of A is an integer within the range [0, N-1].

### Solution

```c++
// Time: O(n) Space: O(1)
class Solution {
public:
    int arrayNesting(vector<int>& nums) 
    {
        int max_len = 0;
        int count = 0;
        
        for (int i = 0; i < nums.size(); i++)
        {
            if (nums[i] == -1) // if visited, no need to consider
                continue;
            
            count = 0;
            
            for (int j = i; nums[j] != -1; )
            {
                count++;
                int temp = nums[j];
                nums[j] = -1; // visited: -1
                j = temp;
            }
            
            max_len = max(max_len, count);
        }
        
        return max_len;
    }
};
```



## 769. Max Chunks To Make Sorted (Medium)

### Description

Given an array `arr` that is a permutation of `[0, 1, ..., arr.length - 1]`, we split the array into some number of "chunks" (partitions), and individually sort each chunk. After concatenating them, the result equals the sorted array.

What is the most number of chunks we could have made?

**Example 1:**

```
Input: arr = [4,3,2,1,0]
Output: 1
Explanation:
Splitting into two or more chunks will not return the required result.
For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.
```

**Example 2:**

```
Input: arr = [1,0,2,3,4]
Output: 4
Explanation:
We can split into two chunks, such as [1, 0], [2, 3, 4].
However, splitting into [1, 0], [2], [3], [4] is the highest number of chunks possible.
```

**Note:**

- `arr` will have length in range `[1, 10]`.
- `arr[i]` will be a permutation of `[0, 1, ..., arr.length - 1]`.

### Solution

```c++
// Time: O(n)  Space: O(1)
class Solution {
public:
    int maxChunksToSorted(vector<int>& arr) 
    {
        if (arr.empty())
            return 0;
        
        int res = 0;
        int right = arr[0];
        
        for (int i = 0; i < arr.size(); i++)
        {
            right = max(right, arr[i]);
            
            // numbers range from 0 to arr.length - 1
            // if max = index i, then max can come back to its position 
            // we must put max number at its right position
            if (right == i)
                res++;
        }
        
        return res;
    }
};
```

