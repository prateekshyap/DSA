/*https://binarysearch.com/problems/Tree-Pruning*/

import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    public Tree solve(Tree root) {
        if (root == null) return null;
        root.left = solve(root.left);
        root.right = solve(root.right);
        if (root.left == null && root.right == null && root.val == 0) return null;
        return root;
    }
}