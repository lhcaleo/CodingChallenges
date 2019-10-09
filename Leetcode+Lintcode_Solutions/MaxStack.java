// https://www.lintcode.com/problem/max-stack/description

import java.util.*;

class MaxStack
{
	Stack<Integer> stack = new Stack<>();
	Stack<Integer> maxStack = new Stack<>();
	
	public MaxStack(){}
	
	public void push(int x)
	{
		if(stack.isEmpty())
		{
			stack.push(x);
			maxStack.push(x);
		} 
		else 
		{
			if(x >= maxStack.peek()) maxStack.push(x);
			else maxStack.push(maxStack.peek());
			stack.push(x);
		}
	}
	
	public int pop(){
		maxStack.pop();
		return stack.pop();
	}
	
	public int top(){
		return stack.peek();
	}
	
	public int peekMax(){
		return maxStack.peek();
	}
	
	public int popMax()
	{
		Stack<Integer> helper = new Stack<>();
		while (stack.peek() != maxStack.peek()) 
		{
			helper.push(stack.pop());
		}
		int max = stack.pop();
		while (!helper.isEmpty())
		{
			stack.push(helper.pop());
		}
		maxStack.pop();
		return max;
	}
}