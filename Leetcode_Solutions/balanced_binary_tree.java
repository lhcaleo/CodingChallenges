/**
 * https://leetcode.com/problems/balanced-binary-tree/
 * DFS Bottom to Top
 * Time: O(n)
 */
class Solution 
{
	private boolean result = true;
	
	public boolean isBalanced(TreeNode root) 
	{
		maxDepth(root);
		return result;
	}
	
	private int maxDepth(TreeNode root)
	{
		if (root == null) return 0;
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		if (Math.abs(left - right) > 1)
			result = false;
		return Math.max(left, right) + 1;
	}
}