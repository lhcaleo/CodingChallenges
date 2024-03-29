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