/*https://leetcode.com/problems/insufficient-nodes-in-root-to-leaf-paths/*/

class Solution {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        int sum = recur(root,null,0,limit); //recursion call
        if (sum < limit) return null; //if sum is less than limit for root, return empty tree
        return root;
    }
    public int recur(TreeNode root, TreeNode parent, int pathSum, int limit)
    {
        if (root == null) return pathSum; //base case
        boolean isLeftNull = root.left == null; //store if left child is null
        boolean isRightNull = root.right == null; //store if right child is null
        int left = recur(root.left,root,pathSum+root.val,limit); //recursion on left child
        int right = recur(root.right,root,pathSum+root.val,limit); //recursion on right child
        if (isLeftNull && !isRightNull) left = Integer.MIN_VALUE; //if only left child is null, make left value as -inf
        if (isRightNull && !isLeftNull) right = Integer.MIN_VALUE; //if only right child is null, make right value as -inf
        int maxPathSum = Math.max(left,right); //store the maximum of these two
        if (maxPathSum < limit) //if it is strictly less than limit, delete the node
        {
            if (parent != null && parent.left == root) parent.left = null;
            else if (parent != null) parent.right = null;
        }
        return maxPathSum; //return path sum
    }
}