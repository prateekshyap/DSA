/*https://practice.geeksforgeeks.org/problems/maximum-path-sum-from-any-node/1*/
/*https://leetcode.com/problems/binary-tree-maximum-path-sum/*/

class Solution
{
    int sum;
    
    int recur(Node root)
    {
        if (root == null) return 0;
        
        int sum1 = recur(root.left);
        int sum2 = recur(root.right);
        
        sum = Math.max(sum,root.data+(sum1 > 0 ? sum1 : 0)+(sum2 > 0 ? sum2 : 0));
        
        int total = Math.max(sum1,sum2);
        
        if (total > 0) return total+root.data;
        return root.data;
    }
    
    //Function to return maximum path sum from any node in a tree.
    int findMaxSum(Node node)
    {
        //your code goes here
        sum = Integer.MIN_VALUE;
        recur(node);
        return sum;
    }
}

class Solution {
    int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        int sum = recur(root);
        if (root.left == null || root.right == null)
        maxSum = Math.max(sum,maxSum);
        return maxSum;
    }
    int recur(TreeNode root)
    {
        if (root == null) return 0;
        
        int leftSum = recur(root.left);
        int rightSum = recur(root.right);
        
        if (root.left == null && root.right == null) maxSum = Math.max(maxSum,root.val);
        if (root.left == null) maxSum = Math.max(maxSum,Math.max(root.val,rightSum+root.val));
        if (root.right == null) maxSum = Math.max(maxSum,Math.max(root.val,leftSum+root.val));
                
        maxSum = Math.max(maxSum,Math.max(root.val,Math.max(leftSum+root.val,Math.max(rightSum+root.val,leftSum+rightSum+root.val))));
        
        return Math.max(root.val,Math.max(leftSum+root.val,rightSum+root.val));
    }
}