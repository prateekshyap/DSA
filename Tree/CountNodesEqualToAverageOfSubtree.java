/*https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/*/

class Solution {
    int count;
    public int averageOfSubtree(TreeNode root) {
        count = 0;
        recur(root);
        return count;
    }
    public int[] recur(TreeNode root)
    {
        int[] result = new int[2];

        //base case
        if (root == null) return result;

        //recursion
        int[] leftResult = recur(root.left);
        int[] rightResult = recur(root.right);

        //sum and count of nodes
        result[0] = leftResult[0]+rightResult[0]+root.val;
        result[1] = leftResult[1]+rightResult[1]+1;

        //condition checking
        if (result[0]/result[1] == root.val) ++count;
        
        return result;
    }
}