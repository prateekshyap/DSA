/*https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/*/

class Solution {
    TreeNode reference;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        reference = null;
        inorder(original, cloned, target);
        return reference;
    }
    public void inorder(TreeNode original, TreeNode cloned, TreeNode target)
    {
        if (original == null || reference != null) return;
        inorder(original.left, cloned.left, target);
        inorder(original.right, cloned.right, target);
        if (original == target)
        {
            reference = cloned;
            return;
        }
    }
}