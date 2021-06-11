/*https://leetcode.com/problems/symmetric-tree/*/

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return checkSymmetry(root.left,root.right);
    }
    public boolean checkSymmetry(TreeNode root1, TreeNode root2)
    {
    	//if both are null it is symmetric
        if (root1 == null && root2 == null)
            return true;

        //if one of them is null then not symmetric
        if (root1 == null || root2 == null)
            return false;

        //if data is different then not symmetric
        if (root1.val != root2.val)
            return false;

        /*recursion*/
        return checkSymmetry(root1.left,root2.right) && checkSymmetry(root1.right,root2.left);
    }
}