/*https://practice.geeksforgeeks.org/problems/bst-to-greater-sum-tree/1*/

class Solution
{
    static int sum;
    public static void transformTree (Node root)
    {
        //code here
        sum = 0;
        inOrder(root);
    }
    public static void inOrder (Node root)
    {
        if (root != null)
        {
            inOrder(root.right);
            int temp = root.data;
            root.data = sum;
            sum += temp;
            inOrder(root.left);
        }
    }
}