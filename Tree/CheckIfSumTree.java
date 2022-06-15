/*https://binarysearch.com/problems/Sum-Tree*/

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
        recur(root);
        return result;
    }
    public int recur(Tree root)
    {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;

        int left = recur(root.left);
        int right = recur(root.right);

        if (root.val != left+right)
            result = false;
        
        return root.val;
    }
}