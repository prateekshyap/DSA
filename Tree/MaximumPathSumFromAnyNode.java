/*https://practice.geeksforgeeks.org/problems/maximum-path-sum-from-any-node/1*/

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