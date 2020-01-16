// https://leetcode.com/problems/path-sum
// note: def of leaf: leaf.left == null && leaf.right == null
// Time: O(n) visit each node 
// Space:O(n) if skewed tree, otherwise O(log n) in average (depth)

class Solution 
{
	public boolean hasPathSum(TreeNode root, int sum) 
	{
		if (root == null) 
			return false;
		
		sum = sum - root.val;
		
		if (root.left == null && root.right == null && sum == 0)
			return true;
		
		return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
	}
}