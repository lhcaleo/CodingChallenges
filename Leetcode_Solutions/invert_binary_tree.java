// https://leetcode.com/problems/invert-binary-tree/solution/
// Time: O(n) visit every node 
// Space: O(h) h is height of tree. 
//        but h belong to O(n) so Space: O(n)

class Solution 
{
	public TreeNode invertTree(TreeNode root) 
	{
		// base case, if node is null, return
		if (root == null) return null;
	
		// invert left and right of current node
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		// recurse on inverted left and right node
		invertTree(root.left);
		invertTree(root.right);
		
		// all done 
		return root;
	}
}