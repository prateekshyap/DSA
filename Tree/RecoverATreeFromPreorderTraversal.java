/*https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/*/

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
    HashMap<Integer,TreeSet<Integer>> depthDashMap;
    int n;
    public TreeNode recoverFromPreorder(String traversal) {
        depthDashMap = new HashMap<Integer,TreeSet<Integer>>();
        int i, count = 0;
        n = traversal.length();
        char[] preorder = traversal.toCharArray();
        for (i = 0; i < n; ++i)
        {
            if (preorder[i] == '-') ++count;
            else
            {
                if (!depthDashMap.containsKey(count))
                    depthDashMap.put(count,new TreeSet<Integer>());
                depthDashMap.get(count).add(i-count);
                count = 0;
                while (i < n && preorder[i] != '-') ++i;
                --i;
            }
        }
        return buildTree(preorder,0,0,n-1);
    }
    private TreeNode buildTree(char[] preorder, int currDepth, int start, int end)
    {
        if (start > end) return null;
        int index = start, value = 0;
        while (preorder[index] == '-') ++index;
        while (index < n && preorder[index] >= '0' && preorder[index] <= '9')
        {
            value = value*10+(preorder[index]-'0');
            ++index;
        }
        
        TreeNode root = new TreeNode(value);
        int nextDepth = currDepth+1;
        int leftLimit = end;
        if (depthDashMap.containsKey(nextDepth) && depthDashMap.get(nextDepth).higher(index+1) != null)
            leftLimit = Math.min(leftLimit,depthDashMap.get(nextDepth).higher(index+1)-1);
        root.left = buildTree(preorder,nextDepth,index,leftLimit);
        root.right = buildTree(preorder,nextDepth,leftLimit+1,end);
        return root;
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
    int n, i;
    char[] preorder;
    public TreeNode recoverFromPreorder(String traversal) {
        n = traversal.length();
        i = 0;
        preorder = traversal.toCharArray();
        return buildTree(0);
    }
    private TreeNode buildTree(int depth)
    {
        if (i >= n) return null;
        int count = 0;
        while (preorder[i] == '-')
        {
            ++count;
            ++i;
        }
        if (count < depth)
        {
            i -= count;
            return null;
        }
        int value = 0;
        while (i < n && preorder[i] >= '0' && preorder[i] <= '9')
        {
            value = value*10+(preorder[i]-'0');
            ++i;
        }
        TreeNode root = new TreeNode(value);
        root.left = buildTree(depth+1);
        if (root.left == null) return root;
        root.right = buildTree(depth+1);
        return root;
    }
}