/*https://leetcode.com/problems/add-one-row-to-tree/*/

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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1)
        {
            TreeNode newNode = new TreeNode(val);
            newNode.left = root;
            return newNode;
        }
        inorder(root,val,depth,1);
        return root;
    }
    private void inorder(TreeNode root, int val, int depth, int currDepth)
    {
        if (root == null) return;
        inorder(root.left,val,depth,currDepth+1);
        inorder(root.right,val,depth,currDepth+1);
        if (currDepth == depth-1)
        {
            TreeNode rest = root.left;
            root.left = new TreeNode(val);
            root.left.left = rest;
            rest = root.right;
            root.right = new TreeNode(val);
            root.right.right = rest;
        }
    }
}