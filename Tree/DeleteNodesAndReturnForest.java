/*https://leetcode.com/problems/delete-nodes-and-return-forest/*/

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
    HashSet<TreeNode> list;
    HashSet<Integer> set;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        list = new HashSet<TreeNode>();
        set = new HashSet<Integer>();
        for (int val : to_delete) set.add(val);
        list.add(root);
        solve(root,new TreeNode(-1));
        return new ArrayList<TreeNode>(list);
    }
    private void solve(TreeNode root, TreeNode parent)
    {
        if (root == null) return;
        if (set.contains(root.val))
        {
            if (parent.left == root) parent.left = null;
            else parent.right = null;
            list.remove(root);
            if (root.left != null)
                list.add(root.left);
            if (root.right != null)
                list.add(root.right);
        }
        solve(root.left,root);
        solve(root.right,root);
    }
}