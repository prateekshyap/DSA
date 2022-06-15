/*https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/*/

class Solution {
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        recur(root);
        return root;
    }
    public void recur(TreeNode root)
    {
        if (root == null) return;
        recur(root.right);
        sum += root.val;
        root.val = sum;
        recur(root.left);
    }
}

class Solution {
    public TreeNode bstToGst(TreeNode root) {
        bstToGst(root,0);
        return root;
    }
    int bstToGst(TreeNode root,int sum)
    {
        root.val += (root.right == null) ? sum : bstToGst(root.right,sum);
        return (root.left == null) ? root.val : bstToGst(root.left,root.val);
    }
}