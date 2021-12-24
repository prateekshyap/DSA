/*https://practice.geeksforgeeks.org/problems/determine-if-two-trees-are-identical/1*/

class Solution
{
	boolean isIdentical(Node root1, Node root2)
	{
		//return true if both are null
	    if (root1 == null && root2 == null)return true;

	    //return false if one is null and other is not
        if (root1 == null) return false;
        if (root2 == null) return false;

        //recursion
        return root1.data == root2.data && isIdentical(root1.left,root2.left) && isIdentical(root1.right,root2.right);
	}
}