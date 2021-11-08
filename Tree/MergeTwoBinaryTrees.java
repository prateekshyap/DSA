/*https://leetcode.com/problems/merge-two-binary-trees/*/

class Solution
{
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2)
    {
        if (root1 == null && root2 == null) return null;
        if (root1 == null) root1 = new TreeNode(0, null, null);
        root1.val = (root1 == null ? 0 : root1.val)+(root2 == null ? 0 : root2.val);
        root1.left = mergeTrees(root1 == null ? null : root1.left, root2 == null ? null : root2.left);
        root1.right = mergeTrees(root1 == null ? null : root1.right, root2 == null ? null : root2.right);
        return root1;
    }
}