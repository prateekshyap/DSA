/*https://leetcode.com/problems/delete-leaves-with-a-given-value/*/

class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        recur(root,null,target);
        if (root.left == null && root.right == null && root.val == target) return null;
        return root;
    }
    public void recur(TreeNode node, TreeNode parent, int target)
    {
        if (node == null) return;
        recur(node.left,node,target);
        recur(node.right,node,target);
        if (node.left == null && node.right == null && node.val == target)
        {
            if (parent == null) return;
            if (parent.left == node) parent.left = null;
            else parent.right = null;
        }
    }
}