/*https://binarysearch.com/problems/Height-Balanced-Tree*/

import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    boolean result;
    public boolean solve(Tree root) {
        result = true;
        recur(root,0);
        return result;
    }
    public int recur(Tree root, int level)
    {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int left = recur(root.left, level+1);
        int right = recur(root.right, level+1);
        if (Math.abs(left-right) >= 2)
            result = false;
        return Math.max(left,right)+1;
    }
}