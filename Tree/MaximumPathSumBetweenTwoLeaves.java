/*https://practice.geeksforgeeks.org/problems/maximum-path-sum/1*/

class Solution
{
    int maxSum;
    int maxPathSum(Node root)
    {
        maxSum = Integer.MIN_VALUE;
        int sum = recur(root);
        if (root.left == null || root.right == null)
        maxSum = Math.max(sum,maxSum);
        return maxSum;
    }
    int recur(Node root)
    {
        if (root == null) return 0;
        
        int leftSum = recur(root.left);
        int rightSum = recur(root.right);
        
        if (root.left == null && root.right == null) return root.data;
        if (root.left == null) return root.data+rightSum;
        if (root.right == null) return root.data+leftSum;
        
        maxSum = Math.max(maxSum,leftSum+rightSum+root.data);
        
        return Math.max(leftSum+root.data,rightSum+root.data);
    }
}