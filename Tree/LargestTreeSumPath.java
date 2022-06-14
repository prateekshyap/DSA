/*https://binarysearch.com/problems/Largest-Tree-Sum-Path*/

import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */

class Solution {
    int max = 0;
    public int solve(Tree root) {
        max = 0;
        recur(root);
        return max;
    }
    public int recur(Tree root)
    {
        if (root == null) return 0;

        int left = recur(root.left);
        int right = recur(root.right);

        if (root.val > max) max = root.val;
        if (root.val+left > max) max = left+root.val;
        if (root.val+right > max) max = right+root.val;
        if (left+right+root.val > max) max = left+right+root.val;

        if (root.left == null && root.right == null) return root.val;
        return Math.max(left+root.val,Math.max(root.val,right+root.val));
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
    int max = 0;
    public int solve(Tree root) {
        max = 0;
        recur(root);
        return max;
    }
    public int recur(Tree root)
    {
        if (root == null) return 0;

        int left = recur(root.left);
        int right = recur(root.right);

        max = findMax(max,root.val,root.val+left,root.val+right,root.val+left+right);

        if (root.left == null && root.right == null) return root.val;
        return findMax(root.val,left+root.val,right+root.val);
    }
    public int findMax(int... nums)
    {
        int maxNum = Integer.MIN_VALUE;
        for (int i : nums)
            if (i > maxNum)
                maxNum = i;
        return maxNum;
    }
}

//single function solution
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
        //trick to distinguish between tree root and other nodes
        boolean flag = false;
        if (max == -1)
        {
            max = Integer.MIN_VALUE;
            flag = true;
        }

        //solution
        if (root == null) return 0;

        int left = solve(root.left);
        int right = solve(root.right);

        max = findMax(max,root.val,root.val+left,root.val+right,root.val+left+right);

        //trick to distinguish between tree root and other nodes
        if (flag) return max;
        
        //solution
        if (root.left == null && root.right == null) return root.val;
        return findMax(root.val,left+root.val,right+root.val);
    }
    public int findMax(int... nums)
    {
        int maxNum = Integer.MIN_VALUE;
        for (int i : nums)
            if (i > maxNum)
                maxNum = i;
        return maxNum;
    }
}