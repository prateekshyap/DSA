/*https://leetcode.com/problems/maximum-binary-tree/*/

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
    int n;
    Map<Integer,Integer> hash;
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        n = nums.length;
        hash = new HashMap<Integer,Integer>();
        int max = -1;
        for (int i = 0; i < n; ++i)
        {
            hash.put(nums[i],i);
            if (nums[i] > max) max = nums[i];
        }
        
        return buildTree(nums,hash.get(max),0,n-1);
    }
    private TreeNode buildTree(int[] nums, int index, int left, int right)
    {
        TreeNode root = new TreeNode(nums[index]);
        int rightBorder = index-1, leftBorder = index+1;
        if (rightBorder >= left)
        {
            int maxIndex = getMaxIndex(nums,left,rightBorder);
            root.left = buildTree(nums,maxIndex,left,rightBorder);
        }
        if (leftBorder <= right)
        {
            int maxIndex = getMaxIndex(nums,leftBorder,right);
            root.right = buildTree(nums,maxIndex,leftBorder,right);
        }
        return root;
    }
    private int getMaxIndex(int[] nums, int l, int r)
    {
        int max = nums[l], maxIndex = l;
        for (int i = l; i <= r; ++i)
        {
            if (nums[i] > max)
            {
                max = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = new TreeNode(Integer.MAX_VALUE);
        helper(nums, root, 0);
        return root.right;
    }
    
    private int helper(int[] nums, TreeNode root, int pos) {
        while (pos > -1 && pos < nums.length) {
            if (nums[pos] < root.val) {
                TreeNode cur = new TreeNode(nums[pos]), right = root.right;
                root.right = cur;
                cur.left = right;
                pos = helper(nums, cur, pos + 1);
            } else return pos;
        }
        return -1;
    }
}

