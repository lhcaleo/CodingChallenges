/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// https://leetcode.com/problems/binary-tree-inorder-traversal/
// Recursive Solution
// Time Complexity: O(n) since we must visit all nodes.
// Space Complexity: O(log n) on balanced tree. O(n) otherwise. (height)
class Solution 
{
	public List<Integer> inorderTraversal(TreeNode root) 
	{
		if(root == null) return new ArrayList<>();
		List<Integer> result_list = new ArrayList<>();
		inOrder(root, result_list);
		return result_list;
	}
	public void inOrder(TreeNode curr, List<Integer> result)
	{
		if(curr.left != null)
		{
			inOrder(curr.left, result);
		}
        result.add(curr.val);
		if(curr.right != null)
		{
			inOrder(curr.right, result);
		}
	}
}

// Iterative Solution using stack
// Time Complexity: O(n) since we must visit all nodes.
// Space Complexity: O(n) for stack
class Solution 
{
	public List<Integer> inorderTraversal(TreeNode root) 
	{
		if(root == null) return new ArrayList<>();
		List<Integer> result_list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        
		// if stack is empty, exit
		while(true)
		{
			// reach the leftmost node
			while (curr != null) 
			{
				stack.push(curr);
				curr = curr.left;
			}
			// if the stack is empty, exit
			if(stack.isEmpty()) break;
			
			// pop node from stack, add its value into result list
			// set curr->right as current node
			curr = stack.pop();
			result_list.add(curr.val);
			curr = curr.right;	
		}
		return result_list;
	}
}