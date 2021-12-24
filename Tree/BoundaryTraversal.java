/*https://practice.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1*/

class Solution
{
	ArrayList<Integer> al = new ArrayList<>();
	ArrayList <Integer> printBoundary(Node node)
	{
	    al = new ArrayList<Integer>(); //create a new array
	    if (node == null) //if root is null
	        return al; //return the empty array
	    al.add(node.data); //add the root
	    if (node.left != null) //if left is not null
	        preOrder(node.left); //left boundary call
	    inOrder(node); //leaves call
	    if (node.right != null) //if right is not null
	        postOrder(node.right); //right boundary call
	    return al; //return the array
	}
	void preOrder(Node root)
	{
	    if (root.left != null || root.right != null) //if we didn't reach a leaf node
	    {
	        al.add(root.data); //add the node
	        if (root.left != null) //if left child is available
	            preOrder(root.left); //recursively call the left child
	        else //if left child is not there
	            preOrder(root.right); //recursively call the right child
	    }
	}
	void inOrder(Node root)
	{
	    if (root != null) //till we traverse the end
	    {
	        inOrder(root.left); //recursively call the left subtree
	        if (root.left == null && root.right == null) //if the node is a leaf
	            al.add(root.data); //add the data
	        inOrder(root.right); //recursively call the right subtree
	    }
	}
	void postOrder(Node root)
	{
	    if (root.right != null || root.left != null) // if we didn't reach a leaf node
	    {
	        if (root.right != null) //if right child is present
	            postOrder(root.right); //recursively call the right child
	        else //if right child is not present
	            postOrder(root.left); //recursively call the left child
	        al.add(root.data); //add the data
	    }
	}
}