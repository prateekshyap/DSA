/*https://practice.geeksforgeeks.org/problems/is-binary-tree-heap/1/*/

class Solution
{
    int countNodes(Node root)
    {
        if (root == null)
            return 0;
        return (1+countNodes(root.left)+countNodes(root.right));
    }
 
    boolean isCompleteUtil(Node root, int index, int numberNodes)
    {
        //An empty tree is complete
        if (root == null) return true;
 
        // If index assigned to current
        //  node is more than number of
        //  nodes in tree,  then tree is
        // not complete
        if (index >= numberNodes)
            return false;
 
        //Recur for left and right subtrees
        return isCompleteUtil(root.left,2*index+1,numberNodes)
            && isCompleteUtil(root.right,2*index+2,numberNodes);
    }
 
    //This Function checks the heap property in the tree.
    boolean isHeapUtil(Node root)
    {
        //Base case
        if (root.left == null && root.right == null)
            return true;
 
        //node will be in second last level
        if (root.right == null) {
            //check heap property at Node
            return root.data >= root.left.data;
        }
        else {
            //Check heap property at Node and recursive check heap property at left and right subtree
            if (root.data >= root.left.data && root.data >= root.right.data)
                return isHeapUtil(root.left) && isHeapUtil(root.right);
            else
                return false;
        }
    }
	boolean isHeap(Node root)
	{
	    if (root == null)
            return true;
 
        //These two are used in isCompleteUtil()
        int nodeCount = countNodes(root);
 
        if (isCompleteUtil(root,0,nodeCount) && isHeapUtil(root))
            return true;
        return false;
	}
}