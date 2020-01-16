// https://leetcode.com/problems/merge-two-binary-trees/
// Recursion
// Time: O(min(n1, n2)) 
// Space: O(min(n1,n2)) The depth of the recursion tree can go up to m with a skewed tree. in average depth is O(log m) where m = min(n1,n2)

class Solution 
{
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) 
	{
		if (t1 == null && t2 == null) 
			return null;
		
		if (t1 == null && t2 != null)
			return t2;
		
		if (t1 != null && t2 == null)
			return t1;
		
		TreeNode root = new TreeNode(t1.val + t2.val);
		root.left = mergeTrees(t1.left, t2.left);
		root.right = mergeTrees(t1.right, t2.right);
		
		return root;
	}
}