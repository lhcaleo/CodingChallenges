// Time: O(n) visit each node
// Space: O(n) height/depth of tree if skewed tree, avg is O(log n)
class Solution 
{
	public boolean isSymmetric(TreeNode root) 
	{
		if (root == null) return true;
		return isSymmetricHelper(root.left, root.right);
	}
	
	private boolean isSymmetricHelper(TreeNode a, TreeNode b)
	{
		if (a == null && b == null) return true;
		if (a == null || b == null) return false;
		if (a.val != b.val) return false;
		return isSymmetricHelper(a.left, b.right) && isSymmetricHelper(a.right, b.left);
	}
}