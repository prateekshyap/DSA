/*https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/*/

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
    int sum = 0;
    public int sumRootToLeaf(TreeNode root) {
        solve(root,0);
        return sum;
    }
    private void solve(TreeNode root, int curr)
    {
        if (root == null) return;
        if (root.left == null && root.right == null)
        {
            sum += curr*2+root.val;
            return;
        }
        solve(root.left,curr*2+root.val);
        solve(root.right,curr*2+root.val);
    }
}