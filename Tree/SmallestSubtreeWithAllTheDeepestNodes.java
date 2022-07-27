/*https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/*/

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
    TreeNode result;
    int max;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        result = null;
        max = getHeight(root);
        solve(root,0);
        return result;
    }
    private int solve(TreeNode root, int val)
    {
        if (root == null) return val;
        int left = solve(root.left,val+1);
        int right = solve(root.right,val+1);
        if (left == max && right == max)
            result = root;
        return Math.max(left,right);
    }
    private int getHeight(TreeNode root)
    {
        if (root == null) return 0;
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
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
    TreeNode n1, n2;
    int max;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        n1 = n2 = null;
        max = -1;
        getTargets(root,0);
        return solve(root,n1.val,n2.val);
    }
    private void getTargets(TreeNode root, int level)
    {
        if (root == null) return;
        getTargets(root.left,level+1);
        getTargets(root.right,level+1);
        if (level > max)
        {
            max = level;
            n1 = n2 = root;
        }
        else if (level == max)
            n2 = root;
    }
    private TreeNode solve(TreeNode root, int a, int b) {
        if (root == null) return null;
        if (root.val == a || root.val == b) return root;
        TreeNode left = solve(root.left, a, b);
        TreeNode right = solve(root.right, a, b);
        if (left != null && right != null) return root;
        if (left != null) return left;
        if (right != null) return right;
        return null;
    }
}

class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        
        if(root==null)
            return root;
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if(leftDepth==rightDepth)
            return root;
        else if(leftDepth> rightDepth)
            return subtreeWithAllDeepest(root.left);
        else
            return subtreeWithAllDeepest(root.right);
    }
    public int getDepth(TreeNode root)
    {
        if(root==null)
            return 0;
        
        return 1 + Math.max(getDepth(root.left), getDepth(root.right));
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

class Pair
{
    TreeNode a;
    int b;
    Pair(TreeNode a, int b)
    {
        this.a = a;
        this.b = b;
    }
}

class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return solve(root).a;
    }
    private Pair solve(TreeNode root)
    {
        if (root == null) return new Pair(null,0);
        Pair left = solve(root.left);
        Pair right = solve(root.right);
        if (left.b == right.b) return new Pair(root,left.b+1);
        if (left.b > right.b) return new Pair(left.a,left.b+1);
        return new Pair(right.a,right.b+1);
    }
}