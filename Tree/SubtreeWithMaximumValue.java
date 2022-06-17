/*https://binarysearch.com/problems/Subtree-with-Maximum-Value*/

import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    int max;
    public int solve(Tree root) {
        max = 0;
        recur(root);
        return max;
    }
    public int recur(Tree root)
    {
        if (root == null) return 0;
        if (root.left == null && root.right == null)
        {
            if (root.val > max) max = root.val;
            return root.val;
        }
        int sum = recur(root.left)+recur(root.right)+root.val;
        if (sum > max) max = sum;
        return sum;
    }
}

import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    int max = -1;
    public int solve(Tree root) {
        boolean changed = false;
        if (max == -1)
        {
            changed = true;
            max = 0;
        }

        if (root == null) return 0;
        if (root.left == null && root.right == null)
        {
            if (root.val > max) max = root.val;
            return root.val;
        }
        int sum = solve(root.left)+solve(root.right)+root.val;
        if (sum > max) max = sum;

        if (changed) return max;
        return sum;
    }
}