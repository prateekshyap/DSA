/*https://practice.geeksforgeeks.org/problems/sum-tree/1*/

class Solution
{
    boolean result;
	boolean isSumTree(Node root)
	{
		//assume the tree is a sum tree
        result = true;

        //check for any violation
        postOrder(root);

        //return the result
        return result;
	}
	int postOrder(Node root)
	{
		//if the tree is still a sum tree and root is not null
	    if (result && root != null)
	    {
	    	//find the left and right subtree sums
	        int leftSum = postOrder(root.left);
	        int rightSum = postOrder(root.right);

	        //if the root is not a leaf and also not equal to the sum of left and right subtrees
	        //store false in the result
	        if (root.left != null && root.right != null && root.data != leftSum+rightSum)
	            result = false;

	        //return the total sum
	        return leftSum+rightSum+root.data;
	    }
	    return 0;
	}
}