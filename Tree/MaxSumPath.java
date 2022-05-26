/*https://practice.geeksforgeeks.org/problems/maximum-sum-leaf-to-root-path/1*/


class Solution
{
    static int maxSum;
    public static int maxPathSum(Node root)
    {
        //code here
        maxSum = Integer.MIN_VALUE;
        recur(root,0);
        return maxSum;
    }
    public static void recur(Node root, int currSum)
    {
        if (root.left == null && root.right == null)
        {
            maxSum = Math.max(currSum+root.data, maxSum);
            return;
        }
        if (root.left != null) recur(root.left,currSum+root.data);
        if (root.right != null) recur(root.right,currSum+root.data);
    }
}

class Solution {
    public int solve(Tree root) {
        if (root == null) return 0;
        int leftSum = solve(root.left);
        int rightSum = solve(root.right);
        return Math.max(leftSum,rightSum)+root.val;
    }
}