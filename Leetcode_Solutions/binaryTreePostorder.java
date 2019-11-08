/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// https://leetcode.com/problems/binary-tree-postorder-traversal/
// Recursive Solution
// Time Complexity: O(n) since we must visit all nodes.
// Space Complexity: O(log n) on balanced tree. O(n) otherwise. (height)
class Solution 
{
	public List<Integer> postorderTraversal(TreeNode root) 
	{
		if(root == null) return new ArrayList<>();
		List<Integer> result_list = new ArrayList<>();
		postOrder(root, result_list);
		return result_list;
	}
	
	public void postOrder(TreeNode curr, List<Integer> result)
	{
		if(curr.left != null)
		{
			postOrder(curr.left, result);
		}
		if(curr.right != null)
		{
			postOrder(curr.right, result);
		}
		result.add(curr.val);
	}
	
}

// Iterative Solution (DFS using 2 stacks)
// Time Complexity: O(n) since we must visit all nodes.
// Space Complexity: O(n) for stack
// Note: post-order traversal is the same as pre-order traversal with right first (root, root.right, root.left)
// using the property of LIFO of stack_2
class Solution {
	public List<Integer> postorderTraversal(TreeNode root) 
	{
		if(root == null) return new ArrayList<>();
		List<Integer> result_list = new ArrayList<>();
		Stack<TreeNode> stack_1 = new Stack<>();
		Stack<TreeNode> stack_2 = new Stack<>();
        stack_1.push(root);

		while (!stack_1.isEmpty()) 
		{
			TreeNode curr = stack_1.pop();
			stack_2.push(curr);            
			if(curr.left != null) stack_1.push(curr.left);
			if(curr.right != null) stack_1.push(curr.right);   // note: right will be poped firstly from stack
		}
		// take out nodes from stack_2
		while (!stack_2.isEmpty()) 
		{
			result_list.add(stack_2.pop().val);
		}

		return result_list;
	}
}