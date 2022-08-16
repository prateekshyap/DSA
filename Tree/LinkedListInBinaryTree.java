/*https://leetcode.com/problems/linked-list-in-binary-tree/*/

class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        return isSameList(head,root) || (root.left != null ? isSubPath(head,root.left) : false) || (root.right != null ? isSubPath(head,root.right) : false);
    }
    private boolean isSameList(ListNode head, TreeNode root)
    {
        if (head == null) return true;
        if (root == null) return false;
        if (head.val == root.val)
            return isSameList(head.next,root.left) || isSameList(head.next,root.right);
        return false;
    }
}