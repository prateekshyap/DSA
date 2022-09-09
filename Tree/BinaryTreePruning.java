/*https://leetcode.com/problems/binary-tree-pruning/submissions/*/

class Solution {
    public TreeNode pruneTree(TreeNode root) {
        boolean result = prune(root);
        if (!result && root.val == 0) return null;
        return root;
    }
    private boolean prune(TreeNode node)
    {
        if (node == null) return false;
        
        boolean left = prune(node.left);
        boolean right = prune(node.right);
        boolean curr = (node.val == 1);

        if (!left) node.left = null;
        if (!right) node.right = null;
        
        return left | right | curr;
    }
}

class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if (root.left == null && root.right == null && root.val == 0) return null;
        return root;
    }
}