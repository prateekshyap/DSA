/*https://leetcode.com/problems/increasing-order-search-tree/*/

class Solution {
    TreeNode newRoot, temp;
    public TreeNode increasingBST(TreeNode root) {
        newRoot = new TreeNode(-1);
        temp = newRoot;
        recur(root);
        root = null;
        return newRoot.right;
    }
    
    public void recur(TreeNode root)
    {
        if (root == null) return;
        recur(root.left);
        temp.right = root;
        root.left = null;
        temp = temp.right;
        recur(root.right);
    }
}