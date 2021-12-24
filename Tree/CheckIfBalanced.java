/*https://leetcode.com/problems/balanced-binary-tree/*/

class Solution {
    int maxDiff;
    public boolean isBalanced(TreeNode root) {
        maxDiff = 0;
        getHeight(root);
        if (maxDiff >= 2)
            return false;
        return true;
    }
    public int getHeight(TreeNode root) {
        if (root == null)
            return 0;

        /*recursion*/
        int leftSubtreeHeight = getHeight(root.left);
        int rightSubtreeHeight = getHeight(root.right);

        //store the maximum difference
        maxDiff = Math.max(maxDiff,Math.abs(leftSubtreeHeight-rightSubtreeHeight));
        
        //return the maximum height
        return Math.max(leftSubtreeHeight,rightSubtreeHeight)+1;
    }
}