/*https://practice.geeksforgeeks.org/problems/inorder-successor-in-bst/1*/

class Solution
{
    boolean isXLocated;
    Node result;
	public Node inorderSuccessor(Node root, Node x)
    {
        isXLocated = false;
        result = null;

        //recursion call
        traverseInOrder(root,x);

        return result;
    }
    public void traverseInOrder(Node root, Node x)
    {//till result is not found
        if (root != null && result == null)
        {
            /*recursion*/
            traverseInOrder(root.left,x);

            //if x is located and result is not found yet
            if (isXLocated && result == null)
            {
                //mark the current node as the result and return
                result = root;
                return;
            }

            //if x node is located, mark it
            if (root.data == x.data) isXLocated = true;

            /*recursion*/
            traverseInOrder(root.right,x);
        }
    }
}