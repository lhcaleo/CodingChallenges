// https://leetcode.com/problems/path-sum-iii/description/
// Note: every node can be the starting. so recursively find the path starting from each node
// Time: O(n) visit each node 
// Space: O(h) height of tree
class Solution 
{
	public int pathSum(TreeNode root, int sum) 
	{
		if (root == null) 
			return 0;
		int result = pathSumStartWithRoot(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
		return result;
	}
	
	private int pathSumStartWithRoot(TreeNode root, int sum) 
	{
		if (root == null) 
			return 0;
		
		sum = sum - root.val;
		
		if (sum == 0) 
			return 1 + pathSumStartWithRoot(root.left, sum) + pathSumStartWithRoot(root.right, sum);
		else
			return pathSumStartWithRoot(root.left, sum) + pathSumStartWithRoot(root.right, sum);
	}
}