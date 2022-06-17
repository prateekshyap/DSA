/*https://leetcode.com/problems/symmetric-tree/*/
/*https://binarysearch.com/problems/Symmetric-Binary-Tree*/

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

class Solution
{
    public boolean solve(Tree root)
    {
        if (root == null) return true;
        return recur(root.left, root.right); 
    }
    public boolean recur(Tree root1, Tree root2)
    {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;
        return recur(root1.left,root2.right)&&recur(root1.right,root2.left);
    }
}