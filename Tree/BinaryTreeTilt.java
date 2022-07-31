/*https://leetcode.com/problems/binary-tree-tilt/*/

class Solution {
    int sum;
    public int findTilt(TreeNode root) {
        sum = 0;
        recur(root);
        return sum;
    }
    public int recur(TreeNode root)
    {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;
        int left = recur(root.left);
        int right = recur(root.right);
        sum += Math.abs(left-right);
        return root.val+left+right;
    }
}