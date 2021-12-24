/*https://practice.geeksforgeeks.org/problems/count-bst-nodes-that-lie-in-a-given-range/1/*/

class Tree
{
    int getCount(Node root,int l, int h)
    {
        if (root != null)
        {
            if (root.data <= h && root.data >= l)
                return 1+getCount(root.left,l,h)+getCount(root.right,l,h);
            else
                return getCount(root.left,l,h)+getCount(root.right,l,h);
        }
        return 0;
    }
}