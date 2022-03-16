/*https://practice.geeksforgeeks.org/problems/single-valued-subtree/1*/

class Solution
{
    int result;
    public int singlevalued(Node root)
    {
        //code here
        result = 0;
        recur(root);
        return result;
    }
    public int recur(Node root)
    {
        if (root == null) return -1;
        int left = recur(root.left);
        int right = recur(root.right);
        if (left == -1 && right == -1)
        {
            ++result;
            return root.data;
        }
        else if (left == -1)
        {
            if (root.data == right)
            {
                ++result;
                return root.data;
            }
            else return -2;
        }
        else if (right == -1)
        {
            if (root.data == left)
            {
                ++result;
                return root.data;
            }
            else return -2;
        }
        if (left == right && root.data == left)
        {
            ++result;
            return root.data;
        }
        return -2;
    }
}