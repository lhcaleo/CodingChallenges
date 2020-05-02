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
		for (int i = 1; i < queue.size; i++)
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
