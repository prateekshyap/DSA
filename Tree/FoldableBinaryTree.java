/*https://practice.geeksforgeeks.org/problems/foldable-binary-tree/1*/

class Tree
{
    //Function to check whether a binary tree is foldable or not.
    boolean IsFoldable(Node node) 
	{ 
		// your code
		if (node == null) return true;
		return recur(node.left,node.right);
	}
	boolean recur(Node root1, Node root2)
	{
	    if (root1 == null && root2 == null) return true;
	    if (root1 == null || root2 == null) return false;
	    if ((root1.left == null && root2.right != null) || (root1.left != null && root2.right == null) || (root1.right == null && root2.left != null) || (root1.right != null && root2.left == null))
	    return false;
	    return recur(root1.left,root2.right)&&recur(root1.right,root2.left);
	}
}