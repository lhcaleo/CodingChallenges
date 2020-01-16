/**
 * Time: O(n) visit each node 
 * Space: O(n) # of call stack by dfs
 * 
 */
class Solution 
{
	public int max = 0;
	
	public int diameterOfBinaryTree(TreeNode root) 
	{
		maxDepth(root);
		return max;
	}
	
	private int maxDepth(TreeNode node)
	{
		if (node == null) 
			return 0;
		
		int left = maxDepth(node.left);
		int right = maxDepth(node.right);
		
		if (left + right > max) 
			max = left + right; 
		
		return Math.max(left, right) + 1;
	}

}