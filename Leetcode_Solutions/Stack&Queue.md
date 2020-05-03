# Stack & Queue

## 232. Implement Queue using Stacks (Easy)

### Description

Implement the following operations of a queue using stacks.

- push(x) -- Push element x to the back of queue.
- pop() -- Removes the element from in front of queue.
- peek() -- Get the front element.
- empty() -- Return whether the queue is empty.

**Example:**

```
MyQueue queue = new MyQueue();

queue.push(1);
queue.push(2);  
queue.peek();  // returns 1
queue.pop();   // returns 1
queue.empty(); // returns false
```

### Solution

```java
// Queue is first-in-first-out, Stack is first-in-last-out
// By using 2 stacks, we reverse a stack and achieve first-in-fisrt out
class MyQueue 
{

    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();
    
    /** Initialize your data structure here. */
    public MyQueue() {}
    
    /** Push element x to the back of queue. */
    public void push(int x) 
    {
        s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() 
    {
        if (s2.empty())
        {
            while (!s1.empty())
            {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
    
    /** Get the front element. */
    public int peek() 
    {
        if (s2.empty())
        {
            while (!s1.empty())
            {
                s2.push(s1.pop());
            }
        }
        return s2.peek();    
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() 
    {
        return s1.empty()&&s2.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
```

## 225. Implement Stack using Queues (Easy)

### Description

Implement the following operations of a stack using queues.

- push(x) -- Push element x onto stack.
- pop() -- Removes the element on top of the stack.
- top() -- Get the top element.
- empty() -- Return whether the stack is empty.

**Example:**

```
MyStack stack = new MyStack();

stack.push(1);
stack.push(2);  
stack.top();   // returns 2
stack.pop();   // returns 2
stack.empty(); // returns false
```

**Notes:**

- You must use *only* standard operations of a queue -- which means only `push to back`, `peek/pop from front`, `size`, and `is empty` operations are valid.
- Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
- You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).

### Solution

```java
// One queue, push O(n), pop O(1)
// When add a number into list, in order to achieve last-in-first-out
// need add the number at the head of the list, but add() will add num at the end
// thus, after add(x), need all other nums be removed and then add back
class MyStack 
{

    private Queue<Integer> queue = new LinkedList<>();
        
    /** Initialize your data structure here. */
    public MyStack() {}
    
    /** Push element x onto stack. */
    public void push(int x) 
    {
        queue.add(x);
        for (int i = 1; i < queue.size(); i++)
        {
            queue.add(queue.remove());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() 
    {
        return queue.remove();
    }
    
    /** Get the top element. */
    public int top() 
    {
        return queue.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() 
    {
        return queue.isEmpty();
    }
}
```

## 155. Min Stack (Easy)

### Description

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

- push(x) -- Push element x onto stack.
- pop() -- Removes the element on top of the stack.
- top() -- Get the top element.
- getMin() -- Retrieve the minimum element in the stack.

**Example 1:**

```
Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
```

**Constraints:**

- Methods `pop`, `top` and `getMin` operations will always be called on **non-empty** stacks.

### Solution

**Two Stack Solution**

```java
// Two stack solution
class MinStack 
{
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min_stack = new Stack<>();
    
    
    /** initialize your data structure here. */
    public MinStack() 
    {
        min_stack.push(Integer.MAX_VALUE);
    }
    
    public void push(int x) 
    {
        stack.push(x);
        // if a smaller number is pushed in, accpet it
        if (x <= min_stack.peek())
        {
            min_stack.push(x);
        }
    }
    
    public void pop() 
    {
        int poped = stack.peek();
        stack.pop();
        // if minimum number is poped, we pop it from minstack, 
        //  otherwise ignore the pop
        if (poped == min_stack.peek())
        {
            min_stack.pop();
        }
    }
    
    public int top() 
    {
        return stack.peek();
    }
    
    public int getMin() 
    {
        return min_stack.peek();
    }
}
```

**One Stack Solution**

```java
// One stack solution
// Idea: when push（x），x <= min, push current min first，then push x
// thus, each min has its previous min underneath
class MinStack 
{
    private Stack<Integer> stack;
    int min = Integer.MAX_VALUE;

    /** initialize your data structure here. */
    public MinStack() 
    {
        stack = new Stack<>();
    }
    
    public void push(int x) 
    {
        if (x <= min)
        {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }
    
    public void pop() 
    {
        int poped = stack.pop();
        if (poped == min)
        {
            min = stack.pop();
        }
    }
    
    public int top() 
    {
        return stack.peek();
    }
    
    public int getMin() 
    {
        return min;
    }
}
```

## 20. Valid Parentheses (Easy)

### Description

Given a string containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid.

An input string is valid if:

1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.

Note that an empty string is also considered valid.

**Example 1:**

```
Input: "()"
Output: true
```

**Example 2:**

```
Input: "()[]{}"
Output: true
```

**Example 3:**

```
Input: "(]"
Output: false
```

### Solution

```java
// Time: O(n) Space: O(n)
class Solution 
{
    public boolean isValid(String s) 
    {
        if (s.length() % 2 != 0)
            return false;
        
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            
            if (c == '(' || c == '{' || c == '[')
            {
                stack.push(c);
            }
            else
            {
                if (stack.isEmpty())
                    return false;
                else if (c == ')')
                {
                    if (stack.pop() != '(')
                        return false;
                }
                else if (c == '}')
                {
                    if (stack.pop() != '{')
                        return false;
                }
                else if (c == ']')
                {
                    if (stack.pop() != '[')
                        return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}
```

## 496. Next Greater Element I (Easy)

### Description

You are given two arrays **(without duplicates)** `nums1` and `nums2` where `nums1`’s elements are subset of `nums2`. Find all the next greater numbers for `nums1`'s elements in the corresponding places of `nums2`.

The Next Greater Number of a number **x** in `nums1` is the first greater number to its right in `nums2`. If it does not exist, output -1 for this number.

**Example 1:**

```
Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
Output: [-1,3,-1]
Explanation:
    For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
    For number 1 in the first array, the next greater number for it in the second array is 3.
    For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
```



**Example 2:**

```
Input: nums1 = [2,4], nums2 = [1,2,3,4].
Output: [3,-1]
Explanation:
    For number 2 in the first array, the next greater number for it in the second array is 3.
    For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
```

### Solution

```java
// Time: O(m) for num2 iteration, Space: O(n + n) for one stack and one hashmap 
// Key: using one single-order stack (elements decreasing from top to bottom)
class Solution 
{
    public int[] nextGreaterElement(int[] nums1, int[] nums2) 
    {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums2.length; i++)
        {
            while (!stack.isEmpty() && nums2[i] > stack.peek())
            {
                // key: element, value: its greater element
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        
        for (int j = 0; j < nums1.length; j++)
        {
            nums1[j] = map.getOrDefault(nums1[j], -1);
        }
        
        return nums1;
    }
}
```



## 503. Next Greater Element II (Medium)

### Description

Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.

**Example 1:**

```
Input: [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number; 
The second 1's next greater number needs to search circularly, which is also 2.
```

### Solution

```java
// Time: O(2n) -> O(n) for array iteration Space: O(n) for one stack and one array
// key: using module % to simulate circular array
class Solution 
{
    public int[] nextGreaterElements(int[] nums) 
    {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        
        for (int greater_index = 0; greater_index < len * 2; greater_index++)
        {   
            int greater_num = nums[greater_index % len];
            
            while (!stack.isEmpty() && greater_num > nums[stack.peek()])
            {
                int reference_index = stack.pop();
                res[reference_index] = greater_num;
            }
            
            if (greater_index < len)
                stack.push(greater_index);
        }
        
        return res;
    }
}
```

## 739. Daily Temperatures (Medium)

### Description

Given a list of daily temperatures `T`, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put `0` instead.

For example, given the list of temperatures `T = [73, 74, 75, 71, 69, 72, 76, 73]`, your output should be `[1, 1, 4, 2, 1, 1, 0, 0]`.

**Note:** The length of `temperatures` will be in the range `[1, 30000]`. Each temperature will be an integer in the range `[30, 100]`.

### Solution

```java
// Time: O(n) for array iteration Space: O(n) one stack + one array
class Solution 
{
    public int[] dailyTemperatures(int[] T) 
    {
        int len = T.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();
        
        for (int warmer_index = 0; warmer_index < len; warmer_index++)
        {
            while (!stack.isEmpty() && T[warmer_index] > T[stack.peek()])
            {
                int reference_index = stack.peek();
                stack.pop();
                // distance of these 2 days is the diff of their index
                
                res[reference_index] = warmer_index - reference_index;
            }
            stack.push(warmer_index);
        }
        
        return res;
    }
}
```

