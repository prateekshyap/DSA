/*https://practice.geeksforgeeks.org/problems/populate-inorder-successor-for-all-nodes/1*/

class Solution{
    Node dummy = null; //this holds the previous node in inorder sequence
    public void populateNext(Node root){
        if (root != null)
        {
        	/*recursion*/
            populateNext(root.left);

            //if dummy is not yet found, that means
            //this is the first node in inorder sequence
            //hence hold the node and proceed
            if (dummy == null) dummy = root;

            //if a dummy is already found
            else
            {
            	//store the current node as its successor
                dummy.next = root;

                //store the current node in dummy for finding its successor
                dummy = root;
            }
            
            /*recursion*/
            populateNext(root.right);
        }
    }
}