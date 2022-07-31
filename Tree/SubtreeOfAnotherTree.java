/*https://leetcode.com/problems/subtree-of-another-tree/*/

class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return checkRecursively(root, subRoot, true);
    }
    
    public static boolean checkRecursively(TreeNode root, TreeNode subRoot, Boolean isFirst){
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        if (root.val != subRoot.val && isFirst)
            return checkRecursively(root.left, subRoot, true) || checkRecursively(root.right, subRoot, true);
        if (root.val != subRoot.val && !isFirst) return false;
        return (checkRecursively(root.left, subRoot.left, false) && checkRecursively(root.right, subRoot.right, false))
                || isFirst && (checkRecursively(root.left, subRoot, true) || checkRecursively(root.right, subRoot, true));
    }
}