/*https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/*/

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
    static final int MIN = (int)-1.6e9-1, MAX = (int)1.6e9+1, wrongMin = (int)-1.6e9-2, wrongMax = (int)1.6e9+2;
    int max;
    public int maxSumBST(TreeNode root) {
        max = MIN;
        find(root,-1);
        return max < 0 ? 0 : max;
    }
    private int[] find(TreeNode root, int dir)
    {
        if (root == null) return dir == 0 ? new int[]{MIN,MIN,MIN} : new int[]{MAX,MAX,MAX};
        
        int[] left = find(root.left,0);
        int[] right = find(root.right,1);
        if (left[1] != wrongMin && left[1] < root.val && right[0] != wrongMax && right[0] > root.val)
        {
            int sum = (left[1] == MIN ? 0 : left[2])+(right[0] == MAX ? 0 : right[2])+root.val;
            if (sum > max) max = sum;
            if (root.left == null && root.right == null) return new int[]{root.val,root.val,root.val};
            return dir == 0 ? (right[1] == MAX ? new int[]{left[0],root.val,sum} : new int[]{left[0],right[1],sum}) : (left[0] == MIN ? new int[]{root.val,right[1],sum} : new int[]{left[0],right[1],sum});
        }
        return dir == 0 ? new int[]{wrongMin,wrongMin,wrongMin} : new int[]{wrongMax,wrongMax,wrongMax};
    }
}