/*https://practice.geeksforgeeks.org/problems/count-number-of-subtrees-having-given-sum/1*/

class Tree
{
    int sum, count;
    
    int recur(Node root, int X)
    {
        if (root == null) return 0;
        
        int sum1 = recur(root.left,X);
        int sum2 = recur(root.right,X);
        
        int totalSum = root.data+sum1+sum2;
        
        if (totalSum == X) ++count;
        
        return totalSum;
    }
    
    //Function to count number of subtrees having sum equal to given sum.
    int countSubtreesWithSumX(Node root, int X)
    {
	    //Add your code here.
	    sum = Integer.MIN_VALUE;
	    count = 0;
	    recur(root,X);
	    return count;
    }
}