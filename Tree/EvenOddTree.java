/*https://leetcode.com/problems/even-odd-tree/*/

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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int len, i, prev, curr;
        TreeNode node;
        boolean flag = true;
        
        queue.add(root);
        while (!queue.isEmpty())
        {
            len = queue.size();
            if (len == 1)
            {
                node = queue.poll();
                if (flag && node.val%2 == 0) return false;
                else if (!flag && node.val%2 == 1) return false;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                flag = !flag;
                continue;
            }
            if (flag)
            {
                prev = Integer.MIN_VALUE;
                for (i = 0; i < len; ++i)
                {
                    node = queue.poll();
                    curr = node.val;
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                    if (prev >= curr) return false;
                    if (curr%2 == 0) return false;
                    prev = curr;
                }
            }
            else
            {
                prev = Integer.MAX_VALUE;
                for (i = 0; i < len; ++i)
                {
                    node = queue.poll();
                    curr = node.val;
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                    if (prev <= curr) return false;
                    if (curr%2 == 1) return false;
                    prev = curr;
                }
            }
            flag = !flag;
        }
        return true;
    }
}