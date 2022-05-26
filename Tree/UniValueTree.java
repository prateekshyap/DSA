/*https://binarysearch.com/problems/Univalue-Tree*/

import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    int val;
    boolean result;
    public boolean solve(Tree root) {
        if (root == null) return true;
        val = root.val;
        result = true;
        recur(root);
        return result;
    }
    public void recur(Tree root)
    {
        if (root == null || !result) return;
        if (root.val != val) result = false;
        recur(root.left);
        recur(root.right);
    }
}

class Solution {
    int val;
    public boolean solve(Tree root) {
        if (root == null) return true;
        boolean result = solve(root.left) & solve(root.right);
        if (root.left != null && root.val != root.left.val) result = false;
        if (root.right != null && root.val != root.right.val) result = false;
        return result;
    }
}