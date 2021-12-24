/*https://leetcode.com/problems/flatten-binary-tree-to-linked-list/*/

class Solution {
    public void flatten(TreeNode root) {
        root = flattenTree(root);
    }
    public TreeNode flattenTree(TreeNode root)
    {
        if (root == null) return null;
        
        TreeNode newRoot = root, temp = root;
        
        while (temp != null)
        {
            while (temp.left == null && temp.right != null)
                temp = temp.right;

            if (temp.left == null) return root;

            TreeNode rest = temp.right;
            temp.right = flattenTree(temp.left);
            temp.left = null;
            while (temp.right != null)
                temp = temp.right;
            temp.right = rest;
        }
        
        return newRoot;
    }
}