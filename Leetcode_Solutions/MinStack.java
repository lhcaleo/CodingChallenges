// https://leetcode.com/problems/min-stack

import java.util.*;
public class MinStack {
	Stack<Integer> stack = new Stack<>();
	Stack<Integer> minstack = new Stack<>();
	
	/** initialize your data structure here. */
	public MinStack() {
		minstack.push(Integer.MAX_VALUE);
	}
	
	public void push(int x) {
		stack.push(x);
		// if a smaller number is pushed in, accpet it
		if(x <= minstack.peek())
		{
			minstack.push(x);
		}
	}
	
	public void pop() {
		int pop = stack.peek();
		stack.pop();
		// if minimum number is poped, we pop it from minstack, otherwise ignore the pop
		if(pop == minstack.peek())
		{
			minstack.pop();
		}
	}
	
	public int top() {
		return stack.peek();
	}
	
	public int getMin() {
		return minstack.peek();
	}
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

//
//// one stack solution
//class MinStack {
//	Stack<Integer> stack = new Stack<>();
//	int min = Integer.MAX_VALUE;
//
//	public void push(int x) {
//		if (x <= min) {
//			stack.push(min);
//			min = x;
//		}
//		stack.push(x);
//	}
//
//	public void pop() {
//		int peek = stack.pop();
//		if (peek == min){
//			min = stack.pop();
//		}
//	}
//
//	public int top() {
//		return stack.peek();
//	}
//
//	public int getMin() {
//		return min;
//	}
//}