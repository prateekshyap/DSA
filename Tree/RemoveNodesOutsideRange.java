/*https://practice.geeksforgeeks.org/problems/remove-bst-keys-outside-given-range/1/*/

class Solution {
    Node removekeys(Node root, int l, int r) {
    	//base case
        if (root == null) return null;

        /*recursion*/
        root.left = removekeys(root.left,l,r);
        root.right = removekeys(root.right,l,r);
        
        /*conditions*/
        /*
		The whole idea is
		if the root value is less than the minimum value
		all the nodes in its left subtree
		will also satisfy the same property
		so we can discard them straight away
		Same for the maximum value 
        */
        if (root.data < l) return root.right;
        if (root.data > r) return root.left;
        
        return root;
    }
}