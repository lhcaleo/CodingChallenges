[List](#list)
  - [160. Intersection of Two Linked Lists (Easy)](#160-intersection-of-two-linked-lists-easy)
    - [Description](#description)
    - [Solution](#solution)
  - [206. Reverse Linked List](#206-reverse-linked-list)
    - [Description](#description-1)
    - [Solution](#solution-1)
  - [21. Merge Two Sorted Lists](#21-merge-two-sorted-lists)
    - [Description](#description-2)
    - [Solution](#solution-2)
  - [83. Remove Duplicates from Sorted List](#83-remove-duplicates-from-sorted-list)
    - [Description](#description-3)
    - [Solution](#solution-3)
  - [19. Remove Nth Node From End of List](#19-remove-nth-node-from-end-of-list)
    - [Description](#description-4)
    - [Solution](#solution-4)
  - [24. Swap Nodes in Pairs](#24-swap-nodes-in-pairs)
    - [Description](#description-5)
    - [Solution](#solution-5)
  - [445. Add Two Numbers II](#445-add-two-numbers-ii)
    - [Description](#description-6)
    - [Solution](#solution-6)
  - [234. Palindrome Linked List](#234-palindrome-linked-list)
    - [Description](#description-7)
  - [725. Split Linked List in Parts](#725-split-linked-list-in-parts)
    - [Description](#description-8)
    - [Solution](#solution-7)
  - [328. Odd Even Linked List](#328-odd-even-linked-list)
    - [Description](#description-9)
    - [Solution](#solution-8)

# List 
## 160. Intersection of Two Linked Lists (Easy)

### Description

Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:

[![img](https://assets.leetcode.com/uploads/2018/12/13/160_statement.png)](https://assets.leetcode.com/uploads/2018/12/13/160_statement.png)

begin to intersect at node c1.

 

**Example 1:**

[![img](https://assets.leetcode.com/uploads/2018/12/13/160_example_1.png)](https://assets.leetcode.com/uploads/2018/12/13/160_example_1.png)

```
Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
Output: Reference of the node with value = 8
Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
```

 

**Example 2:**

[![img](https://assets.leetcode.com/uploads/2018/12/13/160_example_2.png)](https://assets.leetcode.com/uploads/2018/12/13/160_example_2.png)

```
Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
Output: Reference of the node with value = 2
Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [0,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
```

 

**Example 3:**

[![img](https://assets.leetcode.com/uploads/2018/12/13/160_example_3.png)](https://assets.leetcode.com/uploads/2018/12/13/160_example_3.png)

```
Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
Output: null
Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
Explanation: The two lists do not intersect, so return null.
```

 

**Notes:**

- If the two linked lists have no intersection at all, return `null`.
- The linked lists must retain their original structure after the function returns.
- You may assume there are no cycles anywhere in the entire linked structure.
- Your code should preferably run in O(n) time and use only O(1) memory.

### Solution

- Assume: Length of A = a + c, Length of B = b +c 
- We know that a + c + b = b + c + a, thus 
- when pointer of A reaches the end of A, it points back to the head of B
- when pointer of B reaches the end of B, it points back to the head of A
- **They will all reach the intersection node, or become null.** (while condition)

```java
/*
 * length of A: a + c
 * length of B: b + c
 * so, a + c + b = b + c + a
 * Time: O(n) Space: O(1)
*/
public class Solution 
{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) 
    {
    
        ListNode a = headA;
        ListNode b = headB;
        
        // Wait for a and b both be null or the same
        while (a != b) 
        {
            if (a == null) a = headB;
            else a = a.next;
            
            if (b == null) b = headA;
            else b = b.next;
        }
        
        return a;
    }
}
```



## 206. Reverse Linked List

### Description

Reverse a singly linked list.

**Example:**

```
Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
```

**Follow up:**

A linked list can be reversed either iteratively or recursively. Could you implement both?

### Solution

**Iterative Solution**

```java
class Solution 
{
	public ListNode reverseList(ListNode head) 
    {
		ListNode prev = null;
		ListNode curr = head;
		ListNode newHead = null;
        
		// stop when current node is null
        while (curr != null)
        {
            newHead = curr.next;
            // reverse the arrow
            curr.next = prev;
            // move two pointers forward
            prev = curr;
            curr = newHead;
            
        }
        // return prev, since it's the last node
        return prev;
	}
}
```



**Recursive Solution**

```java
class Solution 
{
    public ListNode reverseList(ListNode head) 
    {
        ListNode curr = head;
        // if curr is null,
		// if curr'next is null, it means it's the last node
		//    which will become head of the reverse list.
        if (curr == null || curr.next == null)
            return curr;
        
        ListNode curr_next = curr.next;
        ListNode newHead = reverseList(curr_next);
        curr_next.next = curr;
        curr.next = null;
        
        return newHead;
    }
}
```





## 21. Merge Two Sorted Lists

### Description

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

**Example:**

```
Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
```

### Solution

**Recursive Solution**

```java
class Solution 
{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) 
    {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        if (l1.val <= l2.val)
        {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
```

**Iterative Solution with Dummy Head**

```java
class Solution 
{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) 
    {
        ListNode dummyHead = new ListNode(0);        
        ListNode curr = dummyHead;
        
        while (l1 != null && l2 != null)
        {
            if (l1.val <= l2.val)
            {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        
        if (l1 == null)
            curr.next = l2;
        else
            curr.next = l1;
        return dummyHead.next;
    }
}
```

## 83. Remove Duplicates from Sorted List

### Description

Given a sorted linked list, delete all duplicates such that each element appear only once.

**Example 1:**

```
Input: 1->1->2
Output: 1->2
```

**Example 2:**

```
Input: 1->1->2->3->3
Output: 1->2->3
```

### Solution

```java
class Solution 
{
    public ListNode deleteDuplicates(ListNode head) 
    {
        ListNode curr = head;
        
        while(curr != null)
        {
            ListNode next = curr.next;
            if (next == null)
                return head;
            else if (next.val == curr.val)
            {
                curr.next = next.next;
                next.next = null;
            } 
            else
                curr = curr.next;
        }
        
        return head;
    }
}
```



## 19. Remove Nth Node From End of List

### Description

Given a linked list, remove the n-th node from the end of list and return its head.

**Example:**

```
Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
```

**Note:**

Given *n* will always be valid.

**Follow up:**

Could you do this in one pass?

### Solution

```java
// Two Pointer, one fast, one slow
// keep their gap at n, and move till the end
// Time: O(n) Space: O(1)
class Solution 
{
    public ListNode removeNthFromEnd(ListNode head, int n) 
    {    
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;
        // Advances fast pointer so that the gap between fast and slow is n nodes apart
        while(n > 0) {
            fast = fast.next;
            n--;
        }
        // Move fast to the end, maintaining the gap
        while(fast.next != null) 
        {
            fast = fast.next;
            slow = slow.next;
        }
        // Slow pointer's next node is the n-th node from the end of list
        slow.next = slow.next.next;
        return dummyHead.next;
    }
}
```



## 24. Swap Nodes in Pairs

### Description

Given a linked list, swap every two adjacent nodes and return its head.

You may **not** modify the values in the list's nodes, only nodes itself may be changed.

**Example:**

```
Given 1->2->3->4, you should return the list as 2->1->4->3.
```

### Solution

```java
// Dummy Head with 3 pointers, prev, left, and right
// Time: O(n) Space: O(1)
class Solution 
{
    public ListNode swapPairs(ListNode head) 
    {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        
        while (prev.next != null && prev.next.next != null)
        {
            ListNode left = prev.next;
            ListNode right = prev.next.next;
            ListNode next = right.next;
            
            left.next = next;
            right.next = left;
            prev.next = right;
            
            prev = left;
        }
        
        return dummyHead.next;
    }
}
```



## 445. Add Two Numbers II

### Description

You are given two **non-empty** linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

**Follow up:**
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

**Example:**

```
Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
```

### Solution

```java
// Time: O(m+n) Space: O(m+n)
class Solution 
{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        Stack<Integer> s1 = newStack(l1);
        Stack<Integer> s2 = newStack(l2);
        
        ListNode head = new ListNode(0);
        int carry = 0;
        
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0)
        {
            int x = s1.isEmpty() ? 0: s1.pop();
            int y = s2.isEmpty() ? 0: s2.pop();
            int sum = x + y + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            node.next = head.next;
            head.next = node;
        }
        return head.next;
    }
    
    private Stack<Integer> newStack(ListNode node)
    {
        Stack<Integer> stack = new Stack<>();
        while (node != null)
        {
            stack.push(node.val);
            node = node.next;
        }
        return stack;
    }
}
```

## 234. Palindrome Linked List

### Description

Given a singly linked list, determine if it is a palindrome.

**Example 1:**

```
Input: 1->2
Output: false
```

**Example 2:**

```
Input: 1->2->2->1
Output: true
```

**Follow up:**
Could you do it in O(n) time and O(1) space?

###Solution

```java
// Time: O(n) Space: O(1)
// Two Pointer and Reverse list

class Solution 
{
    public boolean isPalindrome(ListNode head) 
    {
        if (head == null || head.next == null) 
            return true;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        // even length, move slow one more step, 
        // else odd length, slow is already in the mid
        if (fast != null)
            slow = slow.next;
        // split to two lists
        splitList(head, slow);
        // compare first and reversed-second
        return compareList(head, reverseList(slow));     
    }
    
    private void splitList(ListNode head, ListNode end)
    {
        while (head.next != end)
        {
            head = head.next;
        }
        head.next = null;
    }
    
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode newHead = null;
        // stop when head is null
        while (curr != null)
        {
            newHead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = newHead;
        }
        return prev;
    }
    
    private boolean compareList(ListNode l1, ListNode l2)
    {
        while (l1 != null && l2 != null)
        {
            if (l1.val == l2.val) {
                l1 = l1.next;
                l2 = l2.next;
            } else {
                return false;
            }
        }
        return true;
    }
}
```

## 725. Split Linked List in Parts

### Description

Given a (singly) linked list with head node `root`, write a function to split the linked list into `k` consecutive linked list "parts".

The length of each part should be as equal as possible: no two parts should have a size differing by more than 1. This may lead to some parts being null.

The parts should be in order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal parts occurring later.

Return a List of ListNode's representing the linked list parts that are formed.

Examples 1->2->3->4, k = 5 // 5 equal parts [ [1], [2], [3], [4], null ]

**Example 1:**

```
Input:
root = [1, 2, 3], k = 5
Output: [[1],[2],[3],[],[]]
Explanation:
The input and each element of the output are ListNodes, not arrays.
For example, the input root has root.val = 1, root.next.val = 2, \root.next.next.val = 3, and root.next.next.next = null.
The first element output[0] has output[0].val = 1, output[0].next = null.
The last element output[4] is null, but it's string representation as a ListNode is [].
```



**Example 2:**

```
Input: 
root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
Output: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
Explanation:
The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.
```



**Note:**

The length of `root` will be in the range `[0, 1000]`.

Each value of a node in the input will be an integer in the range `[0, 999]`.

`k` will be an integer in the range `[1, 50]`.

### Solution

```java
// Time: O(n + k) Space: O(k)
class Solution 
{
    public ListNode[] splitListToParts(ListNode root, int k) 
    {
        // Get length of list
        int length = 0;
        ListNode temp = root;
        while (temp != null)
        {
            length++;
            temp = temp.next;
        }
        
        int mod = length % k;
        int size = length / k;
        
        // Create an array of k lists
        ListNode[] result = new ListNode[k];
        
        ListNode curr = root;
        for (int i = 0; curr != null & i < k; i++)
        {
            result[i] = curr;
            int curr_size = 0;
            
            if (mod > 0) 
            {
                curr_size = size + 1;
                mod--;
            } else {
                curr_size = size;
            }
            for (int j = 0; j < curr_size - 1; j++)
            {
                curr = curr.next;
            }
            ListNode nextHead = curr.next;
            curr.next = null;
            curr = nextHead;
        }
        
        return result;
    }
}
```

## 328. Odd Even Linked List

### Description

```
Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example 1:

Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL
Example 2:

Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL
Note:

The relative order inside both the even and odd groups should remain as it was in the input.
The first node is considered odd, the second node even and so on ...
```

### Solution

```java
// Time: O(n) Space: O(1)
class Solution 
{
    public ListNode oddEvenList(ListNode head) 
    {
        if (head == null) 
            return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode even_head = even;
        
        while (even != null && even.next != null)
        {
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        
        odd.next = even_head;
        
        return head;
    }
}
```

