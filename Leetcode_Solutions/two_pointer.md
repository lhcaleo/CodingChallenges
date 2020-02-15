**Two Pointer**
<!-- TOC -->

- [88. Merge Sorted Array (Easy)](#88-merge-sorted-array-easy)
	- [Description](#description)
	- [Solution](#solution)
- [141. Linked List Cycle (Easy)](#141-linked-list-cycle-easy)
	- [Description](#description-1)
	- [Solution](#solution-1)
- [524. Longest Word in Dictionary through Deleting (Medium)](#524-longest-word-in-dictionary-through-deleting-medium)
	- [Description](#description-2)
	- [Solution](#solution-2)
- [167. Two Sum II - Input array is sorted (Easy)](#167-two-sum-ii---input-array-is-sorted-easy)
	- [Description](#description-3)
	- [Solution](#solution-3)
- [633. Sum of Square Numbers (Easy)](#633-sum-of-square-numbers-easy)
	- [Description](#description-4)
	- [Solution](#solution-4)
- [345. Reverse Vowels of a String (Easy)](#345-reverse-vowels-of-a-string-easy)
	- [Description](#description-5)
	- [Solution](#solution-5)
- [680. Valid Palindrome II (Easy)](#680-valid-palindrome-ii-easy)
	- [Description](#description-6)
	- [Solution](#solution-6)

<!-- /TOC -->

Idea: Use two pointers to iterate an array, each points to different element.

### 88. Merge Sorted Array (Easy)
<a id="markdown-merge-sorted-array-easy" name="merge-sorted-array-easy"></a>

#### <u>Description</u>
<a id="markdown-description" name="description"></a>

Given two sorted integer arrays *nums1* and *nums2*, merge *nums2* into *nums1* as one sorted array.

**Note:**

- The number of elements initialized in *nums1* and *nums2* are *m* and *n* respectively.
- You may assume that *nums1* has enough space (size that is greater or equal to *m* + *n*) to hold additional elements from *nums2*.

**Example:**

```
Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
```

#### <u>Solution</u>
<a id="markdown-solution" name="solution"></a>

```java
// https://leetcode.com/problems/merge-sorted-array/submissions/
// O(m+n) time without extra memory
// two-pointer solution
class Solution 
{
    public void merge(int[] nums1, int m, int[] nums2, int n) 
    {
        int i = m - 1;     // from end of nums1
        int j = n - 1;     // from end of nums2
        int k = m + n - 1; // from end of merged array
        while(i >= 0 && j >= 0)
		{
            // if element in nums1 is greater than the element in nums2
            // store it into merged array
            // and then compare its left element with that element
            if(nums1[i] > nums2[j])
			    nums1[k--] = nums1[i--];
            // if element in nums1 is smaller or equal to the element in nums2
            // store the element in nums2 into merged array
            // and them compare the left element of that greater element in nums2
			else
                nums1[k--] = nums2[j--];
		}
        // store the rest elements in nums2 into sorted array
		while(j >= 0)
        {
            nums1[k--] = nums2[j--];
        }
    }
}
```



### 141. Linked List Cycle (Easy)
<a id="markdown-linked-list-cycle-easy" name="linked-list-cycle-easy"></a>

#### <u>Description</u>
<a id="markdown-description" name="description"></a>

Given a linked list, determine if it has a cycle in it.

To represent a cycle in the given linked list, we use an integer `pos` which represents the position (0-indexed) in the linked list where tail connects to. If `pos` is `-1`, then there is no cycle in the linked list.

 

**Example 1:**

```
Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where tail connects to the second node.
```

![img](https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist.png)

**Example 2:**

```
Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where tail connects to the first node.
```

![img](https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist_test2.png)

**Example 3:**

```
Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.
```

![img](https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist_test3.png)

 

**Follow up:**

Can you solve it using *O(1)* (i.e. constant) memory?

#### <u>Solution</u>
<a id="markdown-solution" name="solution"></a>

**Solution using set**

```java
/**
 * https://leetcode.com/problems/linked-list-cycle/
 * Time: O(n)
 * Space: O(n)
 */
public class Solution 
{
	public boolean hasCycle(ListNode head) 
	{
		Set<ListNode> set = new HashSet<>();
		
		while (head != null)
		{
			if (set.contains(head))
				return true;
			else
			{
				set.add(head);
				head = head.next;
			}
		}
		return false;
	}
}
```

**Two pointer with different speed**

```
/**
 * https://leetcode.com/problems/linked-list-cycle/
 * Two pointer with different speed
 * Time: O(n) if no cycle
 * Time: non-cyclic length N, cyclic length = K
 *  distance between 2 runners / speed diff = # of loops for them to meet = K/(2-1) = K
 *  thus, time is O(N+K)
 * Space: O(1)
 */
public class Solution 
{
	public boolean hasCycle(ListNode head) 
	{
		if (head == null || head.next == null) return false;
		ListNode slow = head;
		ListNode fast = head.next;
		
		while (slow != fast)
		{
			if (slow.next == null || fast.next == null || fast.next.next == null) 
				return false;
			else
			{
				slow = slow.next;
				fast = fast.next.next;
			}
		}
		return true;
	}
}
```



### 524. Longest Word in Dictionary through Deleting (Medium)
<a id="markdown-longest-word-in-dictionary-through-deleting-medium" name="longest-word-in-dictionary-through-deleting-medium"></a>

#### Description
<a id="markdown-description" name="description"></a>

#### Solution
<a id="markdown-solution" name="solution"></a>

### 167. Two Sum II - Input array is sorted (Easy)
<a id="markdown-two-sum-ii---input-array-is-sorted-easy" name="two-sum-ii---input-array-is-sorted-easy"></a>

#### Description
<a id="markdown-description" name="description"></a>

Given an array of integers that is already ***sorted in ascending order\***, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

**Note:**

- Your returned answers (both index1 and index2) are not zero-based.
- You may assume that each input would have *exactly* one solution and you may not use the *same* element twice.

**Example:**

```
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
```

#### Solution
<a id="markdown-solution" name="solution"></a>

```java
// Two Pointer
// Time: O(n) Space: O(1)
class Solution 
{
    public int[] twoSum(int[] numbers, int target) 
    {
        int left = 0;
        int right = numbers.length - 1;
        int sum = 0;
        
        while(left < right)
        {
            sum = numbers[left] + numbers[right];
            if (sum == target)
            {
                break;
            }
            else if (sum > target)
            {
                right--;
            }
            // sum < target
            else 
            {
                left++;
            }
        }
        
        return new int[]{left + 1, right + 1};
    }
}
```



### 633. Sum of Square Numbers (Easy)
<a id="markdown-sum-of-square-numbers-easy" name="sum-of-square-numbers-easy"></a>

#### Description
<a id="markdown-description" name="description"></a>

#### Solution
<a id="markdown-solution" name="solution"></a>

### 345. Reverse Vowels of a String (Easy)
<a id="markdown-reverse-vowels-of-a-string-easy" name="reverse-vowels-of-a-string-easy"></a>

#### Description
<a id="markdown-description" name="description"></a>

#### Solution
<a id="markdown-solution" name="solution"></a>

### 680. Valid Palindrome II (Easy)
<a id="markdown-valid-palindrome-ii-easy" name="valid-palindrome-ii-easy"></a>

#### Description
<a id="markdown-description" name="description"></a>

#### Solution
<a id="markdown-solution" name="solution"></a>

