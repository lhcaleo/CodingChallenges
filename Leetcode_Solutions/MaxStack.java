class MaxStack 
{
	// one tracks all numbers
	Stack<Integer> stack = new Stack<>();
	// one tracks latest max value
	Stack<Integer> max_stack = new Stack<>();
	public MaxStack() {}

	// with 2 stacks, one store all numbers, one store 
	public void push(int x) 
	{
		if (stack.isEmpty())
		{
			stack.push(x);
			max_stack.push(x);
		}
		else 
		{
			// max_stack only push new max value, otherwise push old max for same stack size
			if (x >= max_stack.peek())
				max_stack.push(x);
			else
				max_stack.push(max_stack.peek());
	
			stack.push(x);
		}
	}

	public int pop() 
	{
		// keep both stack same size
		max_stack.pop();
		return stack.pop();
	}

	public int top() 
	{
		return stack.peek();
	}

	public int peekMax() 
	{
		return max_stack.peek();
	}

	public int popMax() 
	{
		Stack<Integer> temp = new Stack<>();
		// searching for position of max from regular stack
		while (stack.peek() != max_stack.peek())
		{
			temp.push(stack.pop());
		}
		// then, pop the max from regular stack, and record its value
		int max = stack.pop();
		// pop from max_stack at the same time
		max_stack.pop();
		// push other elements back to regular stack
		while (!temp.isEmpty())
		{
			stack.push(temp.pop());
		}
		return max;
	}
}




