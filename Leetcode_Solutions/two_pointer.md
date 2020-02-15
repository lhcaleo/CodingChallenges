# Two Pointer
<!-- TOC -->

- [88. Merge Sorted Array (Easy)](#88-merge-sorted-array-easy)
	- [<u>Description</u>](#udescriptionu)
	- [<u>Solution</u>](#usolutionu)
- [141. Linked List Cycle (Easy)](#141-linked-list-cycle-easy)
	- [<u>Description</u>](#udescriptionu-1)
	- [<u>Solution</u>](#usolutionu-1)
- [524. Longest Word in Dictionary through Deleting (Medium)](#524-longest-word-in-dictionary-through-deleting-medium)
	- [Description](#description)
	- [Solution](#solution)
- [167. Two Sum II - Input array is sorted (Easy)](#167-two-sum-ii---input-array-is-sorted-easy)
	- [Description](#description-1)
	- [Solution](#solution-1)
- [633. Sum of Square Numbers (Easy)](#633-sum-of-square-numbers-easy)
	- [Description](#description-2)
	- [Solution](#solution-2)
- [345. Reverse Vowels of a String (Easy)](#345-reverse-vowels-of-a-string-easy)
	- [Description](#description-3)
	- [Solution](#solution-3)
- [680. Valid Palindrome II (Easy)](#680-valid-palindrome-ii-easy)
	- [Description](#description-4)
	- [Solution](#solution-4)

<!-- /TOC -->

**<u>Idea: Use two pointers to iterate an array, each points to different element.</u>**



## 88. Merge Sorted Array (Easy)
<a id="markdown-merge-sorted-array-easy" name="merge-sorted-array-easy"></a>

### <u>Description</u>
<a id="markdown-udescriptionu" name="udescriptionu"></a>

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

### <u>Solution</u>
<a id="markdown-usolutionu" name="usolutionu"></a>

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
        while (i >= 0 && j >= 0)
				{
            // if element in nums1 is greater than the element in nums2
            // store it into merged array
            // and then compare its left element with that element
            if (nums1[i] > nums2[j])
              nums1[k--] = nums1[i--];
            // if element in nums1 is smaller or equal to the element in nums2
            // store the element in nums2 into merged array
            // and them compare the left element of that greater element in nums2
						else
              nums1[k--] = nums2[j--];
				}
        		// store the rest elements in nums2 into sorted array
				while (j >= 0)
        {
          nums1[k--] = nums2[j--];
        }
    }
}
```



## 141. Linked List Cycle (Easy)
<a id="markdown-linked-list-cycle-easy" name="linked-list-cycle-easy"></a>

### <u>Description</u>
<a id="markdown-udescriptionu" name="udescriptionu"></a>

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

### <u>Solution</u>
<a id="markdown-usolutionu" name="usolutionu"></a>

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

```java
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



## 524. Longest Word in Dictionary through Deleting (Medium)
<a id="markdown-longest-word-in-dictionary-through-deleting-medium" name="longest-word-in-dictionary-through-deleting-medium"></a>

### <u>Description</u>
<a id="markdown-description" name="description"></a>

Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some characters of the given string. If there are more than one possible results, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.

**Example 1:**

```
Input:
s = "abpcplea", d = ["ale","apple","monkey","plea"]

Output: 
"apple"
```





**Example 2:**

```
Input:
s = "abpcplea", d = ["a","b","c"]

Output: 
"a"
```



**Note:**

1. All the strings in the input will only contain lower-case letters.
2. The size of the dictionary won't exceed 1,000.
3. The length of all the strings in the input won't exceed 1,000.

### <u>Solution</u>
<a id="markdown-solution" name="solution"></a>

```java
// Two Pointer with subStr()
// Time: O(s*d)  Space: O(1) 
class Solution 
{
    public String findLongestWord(String s, List<String> d) 
    {
        String longest = "";
        for (String str: d)
        {
            int l1 = longest.length();
            int l2 = str.length();
            // if str is shorter than longest word, or same length with smaller order
            if (l1 > l2 || (l1 == l2) && (longest.compareTo(str) < 0))
            {
                continue;
            }
            if (isSubstr(s, str))
            {
                longest = str;
            }
        }
        return longest;
    }
    private boolean isSubstr(String s, String str)
    {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < str.length())
        {
            if (s.charAt(i) == str.charAt(j))
            {
                j++;
            }
            i++;
        }
        return j == str.length();
    }
}
```



## 167. Two Sum II - Input array is sorted (Easy)
<a id="markdown-two-sum-ii---input-array-is-sorted-easy" name="two-sum-ii---input-array-is-sorted-easy"></a>

### <u>Description</u>
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

### <u>Solution</u>
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



## 633. Sum of Square Numbers (Easy)
<a id="markdown-sum-of-square-numbers-easy" name="sum-of-square-numbers-easy"></a>

### <u>Description</u>
<a id="markdown-description" name="description"></a>

Given a non-negative integer `c`, your task is to decide whether there're two integers `a` and `b` such that a2 + b2 = c.

**Example 1:**

```
Input: 5
Output: True
Explanation: 1 * 1 + 2 * 2 = 5
```

 

**Example 2:**

```
Input: 3
Output: False
```

### <u>Solution</u>
<a id="markdown-solution" name="solution"></a>

```java
// Two Pointer
// Time: O(n) Space: O(1)
class Solution 
{
    public boolean judgeSquareSum(int c) 
    {
        int left = 0;
        int right = (int) Math.sqrt(c);
        int sum = 0;
        
        while (left <= right)
        {
            sum = left * left + right * right;
            if (sum == c)
            {
                return true;
            }
            else if (sum < c) 
            {
                left++;
            }
            else 
            {
                right--;
            }
        }
        return false;
    }
}
```



## 345. Reverse Vowels of a String (Easy)
<a id="markdown-reverse-vowels-of-a-string-easy" name="reverse-vowels-of-a-string-easy"></a>

### <u>Description</u>
<a id="markdown-description" name="description"></a>

Write a function that takes a string as input and reverse only the vowels of a string.

**Example 1:**

```
Input: "hello"
Output: "holle"
```

**Example 2:**

```
Input: "leetcode"
Output: "leotcede"
```

**Note:**
The vowels does not include the letter "y".

### <u>Solution</u>
<a id="markdown-solution" name="solution"></a>

```java
// Two Pointer 
// Time: O(n) Space: O(1) constant

class Solution 
{
    // use a HashSet to reduce the look up time to O(1)
    private final static HashSet<Character> vowels = new HashSet<>(
        Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    
    public String reverseVowels(String s) 
    {
        if (s == null)
            return null;
        int left = 0;
        int right = s.length() - 1;
        
        char[] result = new char[s.length()];
        
        while (left <= right)
        {
            char cLeft = s.charAt(left);
            char cRight = s.charAt(right);
            
            if (!vowels.contains(cLeft))
            {
                result[left] = cLeft;
                left++;
            }
            else if (!vowels.contains(cRight))
            {
                result[right] = cRight;
                right--;
            }
            else 
            {
                result[left] = cRight;
                result[right] = cLeft;
                left++;
                right--;
            }
        }
        return new String(result);
    }
}
```



## 680. Valid Palindrome II (Easy)
<a id="markdown-valid-palindrome-ii-easy" name="valid-palindrome-ii-easy"></a>

### <u>Description</u>
<a id="markdown-description" name="description"></a>

Given a non-empty string `s`, you may delete **at most** one character. Judge whether you can make it a palindrome.

**Example 1:**

```
Input: "aba"
Output: True
```



**Example 2:**

```
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
```



**Note:**

1. The string will only contain lowercase characters a-z. The maximum length of the string is 50000.

### <u>Solution</u>
<a id="markdown-solution" name="solution"></a>

```java
// Two Pointer
// Time: O(n) Space: O(1)
class Solution 
{
    public boolean validPalindrome(String s) 
    {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right)
        {
            if (s.charAt(left) == s.charAt(right))
            {
                left++;
                right--;
            }
            else
            {
                // we can delete element pointed by left pointer, or element pointed by right pointer
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
        }
        return true;
    }
    
    private boolean isPalindrome(String s, int left, int right)
    {
        while(left <= right)
        {            
            if (s.charAt(left) == s.charAt(right))
            {
                left++;
                right--;
            }
            else
            {
                return false;
            }
        }
        return true;
    }
}
```

