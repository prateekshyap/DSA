/*https://practice.geeksforgeeks.org/problems/check-whether-bst-contains-dead-end/1*/

class GFG
{
    static Node prev, supPrev;
    static boolean result;
    
    public static boolean isDeadEnd(Node root)
    {
        prev = supPrev = null;
        result = false;
        inOrder(root);
        return result;
    }
    public static void inOrder(Node root)
    {
        if (!result && root != null)
        {
            inOrder(root.left);

            //if prev contains 1 and root contains 2 and 1 is a leaf node, then 1 is a dead end
            if (supPrev == null && prev != null && prev.data == 1 && root.data == 2 && prev.left == null && prev.right == null)
                result = true;

            //if prev contains x, supPreev contains x-1 and root contains x+1 and x is a leaf node then x is a dead end
            if (supPrev != null && supPrev.data == prev.data-1 && prev != null && prev.data == root.data-1 && prev.left == null && prev.right == null)
                result = true;

            //move the pointers
            supPrev = prev;
            prev = root;
            
            inOrder(root.right);
        }
    }
}