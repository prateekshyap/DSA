/*https://practice.geeksforgeeks.org/problems/mirror-tree/1*/

class Solution {
    void mirror(Node node) {
        if (node != null)
	    {
	    	//swap left and right suhbtrees
	        Node temp = node.left;
	        node.left = node.right;
	        node.right = temp;

	        /*recursion*/
	        mirror(node.left);
	        mirror(node.right);
	    }
    }
}