/*https://leetcode.com/problems/balance-a-binary-search-tree/*/

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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        inorder(root,list);
        return build(list,0,list.size()-1);
    }
    private void inorder(TreeNode root, List<Integer> list)
    {
        if (root == null) return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
    private TreeNode build(List<Integer> list, int low, int high)
    {
        if (low > high) return null;
        if (low == high) return new TreeNode(list.get(low));
        int mid = low+(high-low)/2;
        TreeNode curr = new TreeNode(list.get(mid));
        curr.left = build(list,low,mid-1);
        curr.right = build(list,mid+1,high);
        return curr;
    }
}