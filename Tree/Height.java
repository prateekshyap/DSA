/*https://leetcode.com/problems/maximum-depth-of-binary-tree/*/

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}