/*https://practice.geeksforgeeks.org/problems/tree-from-postorder-and-inorder/1/*/

/*
* is = start index of inorder sequence
* ie = end index of inorder sequence
* ps = start index of postorder sequence
* pe = end index of postorder sequence
*/

class GfG
{
    Node buildTree(int in[], int post[], int n)
    {
        Node root = build(in,post,0,n-1,0,n-1);
        return root;
    }
    public Node build(int[] in, int[] post, int is, int ie, int ps, int pe)
    {
    	//base case
        if (is > ie) return null;

        //build the node with the last value present at the current postorder sequence
        //since it is the root value
        Node node = new Node(post[pe]);

        //if there is just one node in the sequence, return the node
        if (is == ie) return node;

        //otherwise
        int currIn = 0;

        //find the index of the current node in the inorder sequence
        for (int i = is; i <= ie; ++i)
            if (in[i] == post[pe])
            {
                currIn = i;
                break;
            }

        /*recursion*/

        //build the left and right subtrees by adjusting the start and end indices properly
        node.left = build(in,post,is,currIn-1,ps,ps-is+currIn-1);
        node.right = build(in,post,currIn+1,ie,pe-ie+currIn,pe-1);

        //return the subtree
        return node;
    }
}