/*https://binarysearch.com/problems/Most-Frequent-Subtree-Sum*/
/*https://leetcode.com/problems/most-frequent-subtree-sum/*/

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

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    ArrayList<Integer> result;
    HashMap<Integer,Integer> map;
    int max;
    public int[] findFrequentTreeSum(TreeNode root) {
        result = new ArrayList<Integer>();
        map = new HashMap<Integer,Integer>();
        max = Integer.MIN_VALUE;
        int i = 0;
        findSum(root);
        int[] arr = new int[result.size()];
        for (Integer val : result)
            arr[i++] = val;
        return arr;
    }
    private int findSum(TreeNode root)
    {
        if (root.left == null && root.right == null)
        {
            int sum = root.val;
            map.put(sum,map.getOrDefault(sum,0)+1);
            if (map.get(sum) > max)
            {
                max = map.get(sum);
                result = new ArrayList<Integer>();
                result.add(sum);
            }
            else if (map.get(sum) == max)
                result.add(sum);
            // System.out.println(root.val+" "+result);
            return sum;
        }
        int left = root.left != null ? findSum(root.left) : Integer.MIN_VALUE;
        int right = root.right != null ? findSum(root.right) : Integer.MIN_VALUE;
        int sum = root.val+(left == Integer.MIN_VALUE ? 0 : left)+(right == Integer.MIN_VALUE ? 0 : right);
        map.put(sum,map.getOrDefault(sum,0)+1);
        if (map.get(sum) > max)
        {
            max = map.get(sum);
            result = new ArrayList<Integer>();
            result.add(sum);
        }
        else if (map.get(sum) == max)
            result.add(sum);
        // System.out.println(root.val+" "+result);
        return sum;
    }
}