/*https://practice.geeksforgeeks.org/problems/symmetric-tree/1*/

class GfG
{
    public static boolean isSymmetric(Node root)
    {
        return checkSymmetric(root, root); //pass the same root twice
    }
    public static boolean checkSymmetric(Node root1, Node root2)
    {
    	//return true if both are null
        if (root1 == null && root2 == null) return true;

        /*recursion*/
        //if both are non-null and data is equal, check for symmetry
        if (root1 != null && root2 != null && root1.data == root2.data)
            return checkSymmetric(root1.left, root2.right)&&checkSymmetric(root1.right,root2.left);
        
        //return false otherwise
        return false;
    }
}