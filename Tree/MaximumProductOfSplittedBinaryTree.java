/*https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    long treeSum, result;
    public int maxProduct(TreeNode root) {
        treeSum = result = 0;
        travel(root);
        solve(root);
        return (int)(result%(1e9+7));
    }
    private long solve(TreeNode root)
    {
        if (root == null) return 0;
        long left = solve(root.left);
        long right = solve(root.right);
        long subtreeSum = left+right+root.val;
        long product = subtreeSum*(treeSum-subtreeSum);
        if (product > result)
            result = product;
        return subtreeSum;
    }
    private void travel(TreeNode root)
    {
        if (root == null) return;
        treeSum += root.val;
        
        travel(root.left);
        travel(root.right);
    }
}