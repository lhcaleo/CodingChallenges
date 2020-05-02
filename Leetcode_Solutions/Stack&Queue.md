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

