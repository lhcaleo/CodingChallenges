# Binary Search
<a id="markdown-binary-search" name="binary-search"></a>
<!-- TOC -->

- [Binary Search](#binary-search)
  - [704. Binary Search (Easy)](#704-binary-search-easy)
    - [Description](#description)
    - [Solution](#solution)
  - [69. Sqrt(x) (Easy)](#69-sqrtx-easy)
    - [Description](#description-1)
    - [Solution](#solution-1)
  - [744. Find Smallest Letter Greater Than Target (Easy)](#744-find-smallest-letter-greater-than-target-easy)
    - [Description](#description-2)
    - [Solution](#solution-2)
  - [540. Single Element in a Sorted Array (Medium)](#540-single-element-in-a-sorted-array-medium)
    - [Description](#description-3)
    - [Solution](#solution-3)
  - [278. First Bad Version (Easy)](#278-first-bad-version-easy)
    - [Description](#description-4)
    - [Solution](#solution-4)
  - [153. Find Minimum in Rotated Sorted Array (Medium)](#153-find-minimum-in-rotated-sorted-array-medium)
    - [Description](#description-5)
    - [Solution](#solution-5)
  - [34. Find First and Last Position of Element in Sorted Array (Medium)](#34-find-first-and-last-position-of-element-in-sorted-array-medium)
    - [Description](#description-6)
    - [Solution](#solution-6)

<!-- /TOC -->
## 704. Binary Search (Easy)
<a id="markdown-binary-search-easy" name="binary-search-easy"></a>

### Description
<a id="markdown-description" name="description"></a>

Given a **sorted** (in ascending order) integer array `nums` of `n` elements and a `target` value, write a function to search `target` in `nums`. If `target` exists, then return its index, otherwise return `-1`.


**Example 1:**

```
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
```

**Example 2:**

```
Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
```

 

**Note:**

1. You may assume that all elements in `nums` are unique.
2. `n` will be in the range `[1, 10000]`.
3. The value of each element in `nums` will be in the range `[-9999, 9999]`.

### Solution
<a id="markdown-solution" name="solution"></a>

```java
class Solution 
{
    public int search(int[] nums, int target) 
    {
      return binarySearch(nums, target, 0, nums.length - 1);
    }
	
	private int binarySearch(int[] nums, int target, int start, int end)
	{
		if (start > end)
			return -1;		
		int mid = start + (end - start)/2;
            
    if (target == nums[mid])
			return mid;
		else if (target < nums[mid])
      return binarySearch(nums, target, start, mid - 1);
    else // if(target > A[mid])
			return binarySearch(nums, target, mid + 1, end);
	}
}
```



## 69. Sqrt(x) (Easy)
<a id="markdown-sqrtx-easy" name="sqrtx-easy"></a>

### Description
<a id="markdown-description" name="description"></a>

Implement `int sqrt(int x)`.

Compute and return the square root of *x*, where *x* is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

**Example 1:**

```
Input: 4
Output: 2
```

**Example 2:**

```
Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since 
             the decimal part is truncated, 2 is returned.
```

### Solution
<a id="markdown-solution" name="solution"></a>

```java
// Binary Search
// Time: O(log n) Space: O(1)
class Solution 
{
    public int mySqrt(int x) 
    {
        if (x == 0 || x == 1) 
            return x;
        
        int start = 1;
        int end = x;
        int mid = 0;
        int sqrt = 0;
        
        while (start <= end)
        {
            mid = start + (end - start) / 2;
            sqrt = x/mid;
            
            if (sqrt == mid)
            {
                return mid;
            } else if (mid < sqrt) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return end;
    }
}
```



## 744. Find Smallest Letter Greater Than Target (Easy)
<a id="markdown-find-smallest-letter-greater-than-target-easy" name="find-smallest-letter-greater-than-target-easy"></a>

### Description
<a id="markdown-description" name="description"></a>

Given a list of sorted characters `letters` containing only lowercase letters, and given a target letter `target`, find the smallest element in the list that is larger than the given target.

Letters also wrap around. For example, if the target is `target = 'z'` and `letters = ['a', 'b']`, the answer is `'a'`.

**Examples:**

```
Input:
letters = ["c", "f", "j"]
target = "a"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "c"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "d"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "g"
Output: "j"

Input:
letters = ["c", "f", "j"]
target = "j"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "k"
Output: "c"
```



**Note:**

1. `letters` has a length in range `[2, 10000]`.
2. `letters` consists of lowercase letters, and contains at least 2 unique letters.
3. `target` is a lowercase letter.

### Solution
<a id="markdown-solution" name="solution"></a>

```java
// Binary Search
// Time: O(log n) Space: O(1)
class Solution 
{
    public char nextGreatestLetter(char[] letters, char target) 
    {
        if (target >= letters[letters.length - 1])
            return letters[0];
        
        int start = 0;
        int end = letters.length - 1;
        int mid = 0;
        
        while (start < end)
        {
            mid = start + (end - start) / 2;
            if (letters[mid] <= target)
            {
                start = mid + 1;
            }
            else 
            {
                end = mid;
            }
        }
        return letters[end];
    }
}
```



## 540. Single Element in a Sorted Array (Medium)
<a id="markdown-single-element-in-a-sorted-array-medium" name="single-element-in-a-sorted-array-medium"></a>

### Description
<a id="markdown-description" name="description"></a>

### Solution
<a id="markdown-solution" name="solution"></a>

## 278. First Bad Version (Easy)
<a id="markdown-first-bad-version-easy" name="first-bad-version-easy"></a>

### Description
<a id="markdown-description" name="description"></a>

### Solution
<a id="markdown-solution" name="solution"></a>

## 153. Find Minimum in Rotated Sorted Array (Medium)
<a id="markdown-find-minimum-in-rotated-sorted-array-medium" name="find-minimum-in-rotated-sorted-array-medium"></a>

### Description
<a id="markdown-description" name="description"></a>

### Solution
<a id="markdown-solution" name="solution"></a>

## 34. Find First and Last Position of Element in Sorted Array (Medium)
<a id="markdown-find-first-and-last-position-of-element-in-sorted-array-medium" name="find-first-and-last-position-of-element-in-sorted-array-medium"></a>

### Description
<a id="markdown-description" name="description"></a>

### Solution
<a id="markdown-solution" name="solution"></a>
