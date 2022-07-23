/*https://leetcode.com/problems/recover-binary-search-tree/*/
/*https://practice.geeksforgeeks.org/problems/fixed-two-nodes-of-a-bst/1*/

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
    TreeNode previous, first, second;
    public void recoverTree(TreeNode root) {
        previous = first = second = null;
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    public void inorder(TreeNode root)
    {
        if (root == null) return;
        
        inorder(root.left);
        
        if (first == null && previous != null && previous.val > root.val)
            first = previous;
        if (first != null && previous.val > root.val)
            second = root;
        previous = root;
        
        inorder(root.right);
    }
}