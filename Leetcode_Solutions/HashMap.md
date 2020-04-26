# HashMap

## 1. Two Sum (Easy)

### Description

Given an array of integers, return **indices** of the two numbers such that they add up to a specific target.

You may assume that each input would have ***exactly\*** one solution, and you may not use the *same* element twice.

**Example:**

```
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
```

### Solution

```java
class Solution 
{
    public int[] twoSum(int[] nums, int target) 
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        int complement = 0;
        
        for (int i = 0; i < nums.length; i++)
        {
            complement = target - nums[i];
            // if the complement is in the map
            // return indices i and complement's index
            if (map.containsKey(complement))
            {
                return new int[]{i, map.get(complement)};
            }
            else 
            {
                map.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("No solution is found"); 
    }
}
```

## 217. Contains Duplicate (Easy)

### Description

Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

**Example 1:**

```
Input: [1,2,3,1]
Output: true
```

**Example 2:**

```
Input: [1,2,3,4]
Output: false
```

**Example 3:**

```
Input: [1,1,1,3,3,4,3,2,4,2]
Output: true
```

### Solution

```java
// Time: O(n) Space: O(n)
class Solution 
{
    public boolean containsDuplicate(int[] nums) 
    {
        HashSet<Integer> set = new HashSet<>();
        
        for (int n: nums)
        {
            if (set.contains(n)) 
                return true;
            else set.add(n);   
        }
        return false;
    }
}
```

