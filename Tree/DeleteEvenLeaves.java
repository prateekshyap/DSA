/*https://binarysearch.com/problems/Delete-Even-Leaves*/

import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */

//with detached recursion
class Solution {
    public Tree solve(Tree root) {
        if (root == null) return null;
        recur(root, null);
        if (root.left == null && root.right == null && root.val%2 == 0) return null;
        return root;
    }
    public void recur(Tree root, Tree par)
    {
        if (root == null) return;
        recur(root.left, root);
        recur(root.right, root);
        if (root.left == null && root.right == null && root.val%2 == 0)
        {
            if (par != null && par.left == root) par.left = null;
            else if (par != null) par.right = null;
        }
    }
}

//recursion within the same method
class Solution {
    public Tree solve(Tree root) {
        if (root == null) return null;
        root.left = solve(root.left);
        root.right = solve(root.right);
        if (root.left == null && root.right == null && root.val%2 == 0) return null;
        return root;
    }
}