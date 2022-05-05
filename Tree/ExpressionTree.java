/*https://practice.geeksforgeeks.org/problems/expression-tree/1*/

class Solution {
    public int evalTree(Node root) {
        // Your code here.
        if (root.left == null && root.right == null) return Integer.parseInt(root.data);
        int left = evalTree(root.left);
        int right = evalTree(root.right);
        if (root.data.equals("+"))
            return left+right;
        else if (root.data.equals("-"))
            return left-right;
        else if (root.data.equals("*"))
            return left*right;
        else if (root.data.equals("/"))
            return left/right;
        return 0;
    }
}