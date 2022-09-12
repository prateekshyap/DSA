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
    public void flatten(TreeNode root) {
        root = flattenTree(root);
    }
    private TreeNode flattenTree(TreeNode root)
    {
        if (root == null) return null;
        
        TreeNode hold = root.right, temp = root;
        if (root.left != null)
        {
            root.right = flattenTree(root.left);
            root.left = null;
            temp = root;
            while (temp.right != null) temp = temp.right;
        }
        temp.right = flattenTree(hold);
        return root;
    }
}