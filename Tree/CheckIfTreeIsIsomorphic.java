/*https://practice.geeksforgeeks.org/problems/check-if-tree-is-isomorphic/1*/

class Solution  
{
    // Return True if the given trees are isomotphic. Else return False.
    boolean isIsomorphic(Node r1, Node r2)  
    {
        if (r1 == null && r2 == null) return true;
        if (r1 == null || r2 == null) return false;
        return (r1.data == r2.data && isIsomorphic(r1.left,r2.right) && isIsomorphic(r1.right,r2.left)) ||
                    (r1.data == r2.data && isIsomorphic(r1.right,r2.right) && isIsomorphic(r1.left,r2.left));
    }
}