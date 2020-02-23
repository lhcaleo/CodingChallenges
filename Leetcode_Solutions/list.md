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

