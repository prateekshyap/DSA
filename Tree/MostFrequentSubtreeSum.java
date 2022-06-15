/*https://binarysearch.com/problems/Most-Frequent-Subtree-Sum*/

import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    HashMap<Integer,Integer> map;
    public int solve(Tree root) {
        if (root == null) return -1;
        map = new HashMap<Integer,Integer>();
        int sum = recur(root);
        map.put(sum, map.containsKey(sum) ? (Integer)map.get(sum)+1 : 1);
        int maxSum = Integer.MIN_VALUE, maxSumKey = -1;
        for (Map.Entry entry : map.entrySet())
        {
            if ((Integer)entry.getValue() > maxSum)
            {
                maxSum = (Integer)entry.getValue();
                maxSumKey = (Integer)entry.getKey();
            }
        }
        return maxSumKey;
    }
    public int recur(Tree root)
    {
        if (root == null) return 0;
        if (root.left == null && root.right == null)
        {
            map.put(root.val,map.containsKey(root.val) ? (Integer)map.get(root.val)+1 : 1);
            return root.val;
        }
        int sum = recur(root.left) + recur(root.right) + root.val;
        map.put(sum,map.containsKey(sum) ? (Integer)map.get(sum)+1 : 1);
        return sum;
    }
}