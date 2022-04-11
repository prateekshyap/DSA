/*https://practice.geeksforgeeks.org/problems/two-mirror-trees/1*/

class Solution {
    boolean areMirror(Node a, Node b) {
        // Your code here
        boolean checkMirror = recur(a, b);
        return a.data == b.data && checkMirror;
    }
    boolean recur(Node a, Node b)
    {
        if (a == null && b == null) return true;
        if (a.left == null && b.left == null && a.right == null && b.right == null && a.data == b.data) return true;
        if (a.left == null && b.right == null && a.right != null && b.left != null && a.data == b.data)
            return areMirror(a.right,b.left);
        if (a.left != null && b.right != null && a.right == null && b.left == null && a.data == b.data)
            return areMirror(a.left,b.right);
        if (a.left != null && b.left != null && a.right != null && b.right != null) return areMirror(a.left,b.right) && areMirror(a.right,b.left);
        return false;
    }
}