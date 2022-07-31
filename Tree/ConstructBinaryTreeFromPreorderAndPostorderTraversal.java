/*https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/*/

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
    HashMap<Integer,Integer> postMap;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        postMap = new HashMap<Integer,Integer>();
        for (int i = 0; i < postorder.length; ++i)
            postMap.put(postorder[i],i);
        return build(preorder,0,preorder.length-1,postorder,0,postorder.length-1);
    }
    TreeNode build(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd)
    {
        if (preStart > preEnd) return null;
        if (preStart == preEnd) return new TreeNode(preorder[preStart]);
        int rootVal = preorder[preStart];
        int leftVal = preorder[preStart+1];
        int postLeftEnd = postMap.get(leftVal);
        int leftSize = postLeftEnd-postStart+1;
        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder,preStart+1,preStart+leftSize,postorder,postStart,postLeftEnd);
        root.right = build(preorder,preStart+leftSize+1,preEnd,postorder,postLeftEnd+1,postEnd);
        return root;
    }
}