/*https://practice.geeksforgeeks.org/problems/binary-tree-to-dll/1*/

//inorder traversal approach
class Solution
{
    public Node head, tail;
    void addNodeToRight(int num)
    {
    	//create a new node after tail
        tail.right = new Node(num);

        //set the previous pointer of the new node
        tail.right.left = tail;

        //move tail
        tail = tail.right;
    }
    void inOrder(Node root)
    {
    	//if root is not null
        if (root != null)
        {
        	/*recursion*/
            inOrder(root.left);

            //add the current node to the end of the linked list
            addNodeToRight(root.data);

            /*recursion*/
            inOrder(root.right);
        }
    }
    Node bToDLL(Node root)
    {	
    	//create a dummy node
	    head = new Node(0);
        tail = head;

        //recursion call
	    inOrder(root);

	    //delete the dummy node and return
	    head = head.right;
	    head.left = null;
	    return head;
    }
}