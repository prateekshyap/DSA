/*https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/*/

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
    int result;
    int distance;
    public int countPairs(TreeNode root, int distance) {
        result = 0;
        this.distance = distance;
        solve(root);
        return result;
    }
    private HashMap<Integer,Integer> solve(TreeNode root)
    {
        if (root.left == null && root.right == null)
        {
            HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
            map.put(0,1);
            return map;
        }
        HashMap<Integer,Integer> left = new HashMap<Integer,Integer>(), right = new HashMap<Integer,Integer>();
        if (root.left != null) left = solve(root.left);
        if (root.right != null) right = solve(root.right);
        for (Map.Entry elem1 : left.entrySet())
        {
            for (Map.Entry elem2 : right.entrySet())
            {
                if ((Integer)elem1.getKey()+(Integer)elem2.getKey()+2 <= distance)
                {
                    result += (Integer)elem1.getValue()*(Integer)elem2.getValue();
                }
            }
        }
        HashMap<Integer,Integer> newMap = new HashMap<Integer,Integer>();
        int key, value;
        for (Map.Entry elem : left.entrySet())
        {
            key = (Integer)elem.getKey();
            value = (Integer)elem.getValue();
            newMap.put(key+1,newMap.getOrDefault(key+1,0)+value);
        }
        for (Map.Entry elem : right.entrySet())
        {
            key = (Integer)elem.getKey();
            value = (Integer)elem.getValue();
            newMap.put(key+1,newMap.getOrDefault(key+1,0)+value);
        }
        return newMap;
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
    int result;
    int distance;
    public int countPairs(TreeNode root, int distance) {
        result = 0;
        this.distance = distance;
        solve(root);
        return result;
    }
    private int[] solve(TreeNode root)
    {
        if (root.left == null && root.right == null)
        {
            int[] map = new int[25];
            Arrays.fill(map,-1);
            map[0] = 1;
            return map;
        }
        int[] left = new int[25], right = new int[25];
        Arrays.fill(left,-1);
        Arrays.fill(right,-1);
        if (root.left != null) left = solve(root.left);
        if (root.right != null) right = solve(root.right);
        int i, j;
        for (i = 0; i < 25; ++i)
        {
            if (i > distance) break;
            if (left[i] == -1) continue;
            for (j = 0; j < 25; ++j)
            {
                if (i+j+2 > distance) break;
                if (right[j] == -1) continue;
                result += left[i]*right[j];
            }
        }
        int[] hash = new int[25];
        Arrays.fill(hash,-1);
        for (i = 0; i < 24; ++i)
            hash[i+1] = left[i] == -1 ? (right[i] == -1 ? -1 : right[i]) : (right[i] == -1 ? left[i] : left[i]+right[i]);
        return hash;
    }
}