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

/**
 * Iterative approach BFS, record the level, when finish, get max depth
 * Time: O(n) 
 * Worst Space: O(n) completely not balanced binary tree eg. each node has only left child
 * Best Space: O(log n) with balanced binary tree as height of tree is log n
 */
class Solution 
{
	public int maxDepth(TreeNode root) 
	{
		if (root == null) return 0;
		
		int max_depth = 0;
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		while (!queue.isEmpty())
		{
			max_depth++;
			int level_size = queue.size();
			
			for (int i = 0; i < level_size; i++)
			{
				TreeNode curr = queue.poll();
				if (curr.left != null) queue.add(curr.left);
				if (curr.right != null) queue.add(curr.right);
			}
		}
		return max_depth;
	}
}