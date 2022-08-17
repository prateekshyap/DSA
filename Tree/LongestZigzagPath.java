/*https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/*/

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
    int max;
    public int longestZigZag(TreeNode root) {
        max = 0;
        recur(root,'\0');
        return max;
    }
    private int recur(TreeNode root, char dir)
    {
        if (root == null) return 0;
        
        int left = recur(root.left, 'l');
        int right = recur(root.right, 'r');
        int curr = 0;
        
        if (dir == 'l') curr = right+1;
        else if (dir == 'r') curr = left+1;
        
        if (curr > max)
            max = curr;
        
        return curr;
    }
}