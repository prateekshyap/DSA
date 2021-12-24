/*https://practice.geeksforgeeks.org/problems/add-all-greater-values-to-every-node-in-a-bst/1*/

class Solution
{
    int sum;
    // modify the BST and return its root
    public Node modify(Node root)
    {
        //Write your code here
        sum = 0;
        reverseInOrder(root);
        return root;
    }
    public void reverseInOrder(Node root)
    {
        if (root != null)
        {
            reverseInOrder(root.right);
            int temp = root.data;
            root.data += sum;
            sum += temp;
            reverseInOrder(root.left);
        }
    }
}
