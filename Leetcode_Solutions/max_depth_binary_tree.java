/**
 * Recursion approach
 * Time: O(n) 
 * Worst Space: O(n) completely not balanced binary tree eg. each node has only left child
 * Best Space: O(log n) with balanced binary tree as height of tree is log n
 */
class Solution 
{
	public int maxDepth(TreeNode root) 
	{
		if (root == null) return 0;
		return recurse(root);
	}
	
	private int recurse(TreeNode node)
	{
		if (node == null) return 0;
		
		int maxDepthLeft = recurse(node.left);
		int maxDepthRight = recurse(node.right);
		return Math.max(maxDepthLeft, maxDepthRight) + 1;
	}
}