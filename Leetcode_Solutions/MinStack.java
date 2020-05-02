// Two stack solution
class MinStack 
{
	private Stack<Integer> stack;
	private Stack<Integer> min_stack;
	
	/** initialize your data structure here. */
	public MinStack() 
	{
		stack = new Stack<>();
		min_stack = new Stack<>();
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


/* ---------------------------------------------------------------- */
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
		if (poped = min)
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