/*https://practice.geeksforgeeks.org/problems/burning-tree/1*/

class Solution
{
    static int max;
    public static int minTime(Node root, int target) 
    {
        max = 0;
        burn(root, target, 0);
        return max;
    }
    public static int burn(Node root, int target, int top)
    {
        if (root == null) return 0;
        if (root.left == null && root.right == null && root.data == target) return -1;
        int left = burn(root.left,target,top+1);
        int right = burn(root.right,target,top+1);
        if (left < 0)
        {
            max = Math.max(max,Math.abs(left)+Math.max(right,top));
            return left-1;
        }
        if (right < 0)
        {
            max = Math.max(max,Math.abs(right)+Math.max(left,top));
            return right-1;
        }
        return 1+Math.max(left,right);
    }
}