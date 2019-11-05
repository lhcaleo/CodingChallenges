/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// https://leetcode.com/problems/binary-tree-preorder-traversal/
// Recursive Solution
// Time Complexity: O(n) since we must visit all nodes.
// Space Complexity: O(log n) on balanced tree. O(n) otherwise. (height)
class Solution {
	public List<Integer> preorderTraversal(TreeNode root) 
	{
		if(root == null) return new ArrayList<>();
		List<Integer> result_list = new ArrayList<>();
		preOrder(root, result_list);
		return result_list;
	}
	public void preOrder(TreeNode curr, List<Integer> result)
	{
		result.add(curr.val);
		if(curr.left != null)
		{
			preOrder(curr.left, result);
		}
		if(curr.right != null)
		{
			preOrder(curr.right, result);
		}
	}
	
}

// Iterative Solution (DFS using stack)
// Time Complexity: O(n) since we must visit all nodes.
// Space Complexity: O(n) for stack

class Solution {
	public List<Integer> preorderTraversal(TreeNode root) 
	{
		if(root == null) return new ArrayList<>();
		List<Integer> result_list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		
		while(!stack.isEmpty())
		{
			TreeNode curr = stack.pop();
			result_list.add(curr.val);
			if(curr.right != null) stack.push(curr.right);
			if(curr.left != null) stack.push(curr.left);
		}
		return result_list;
	}
}