/*https://leetcode.com/problems/path-sum/*/

class Solution
{
    boolean result;
    public boolean hasPathSum(TreeNode root, int targetSum)
    {
        result = false;
        traversePreOrder(root,0,targetSum);
        return result;
    }
    void traversePreOrder(TreeNode root, int sum, int targetSum)
    {
        if (root != null)
        {
            if (root.left == null && root.right == null)
            {
                if (sum+root.val == targetSum) result = true;
                return;
            }
            traversePreOrder(root.left,sum+root.val,targetSum);
            traversePreOrder(root.right,sum+root.val,targetSum);
        }
        if (result) return;
    }
}