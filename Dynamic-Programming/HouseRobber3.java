/*https://leetcode.com/problems/house-robber-iii/*/
/*https://practice.geeksforgeeks.org/problems/maximum-sum-of-non-adjacent-nodes/1/*/

class Solution {
    public int rob(TreeNode root) {
        int[] result = solve(root);
        return Math.max(result[0],result[1]);
    }
    public int[] solve(TreeNode root)
    {
        if (root == null) return new int[2];
        
        int[] left = solve(root.left);
        int[] right = solve(root.right);
        
        int[] result = new int[2];
        result[0] = Math.max(left[0]+right[0],root.val+left[1]+right[1]);
        result[1] = left[0]+right[0];
        return result;
    }
}