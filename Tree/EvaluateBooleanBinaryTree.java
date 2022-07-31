/*https://leetcode.com/problems/evaluate-boolean-binary-tree/*/

class Solution {
    public boolean evaluateTree(TreeNode root) {
        return evaluate(root) == 1 ? true : false;
    }
    private int evaluate(TreeNode root)
    {
        if (root == null) return -1;
        
        int left = evaluate(root.left);
        int right = evaluate(root.right);
        
        if (left == -1) return root.val;
        int result = -1;
        if (root.val == 2)
            result = (left == 0 && right == 0) ? 0 : 1;
        else if (root.val == 3)
            result = (left == 1 && right == 1) ? 1 : 0;
        return result;
    }
}