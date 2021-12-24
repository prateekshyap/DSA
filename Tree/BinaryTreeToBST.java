/*https://practice.geeksforgeeks.org/problems/binary-tree-to-bst/1*/

class Solution
{
    PriorityQueue<Integer> minHeap;
    Node binaryTreeToBST(Node root)
    {
        minHeap = new PriorityQueue<Integer>();

        //traverse and add everything to minHeap
        inOrder(root);

        //store to node in inorder fashion
        inOrderAndModify(root);
        
        return root;
    }
    void inOrderAndModify(Node root)
    {
        if (root != null)
        {
            inOrderAndModify(root.left);
            root.data = (Integer)minHeap.poll();
            inOrderAndModify(root.right);
        }
    }
    void inOrder(Node root)
    {
        if (root != null)
        {
            inOrder(root.left);
            minHeap.add(root.data);
            inOrder(root.right);
        }
    }
}