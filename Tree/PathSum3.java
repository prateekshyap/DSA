/*https://leetcode.com/problems/path-sum-iii/*/

class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return 0;
        return get(root,targetSum)+pathSum(root.left,targetSum)+pathSum(root.right,targetSum);
    }
    public int get(TreeNode root, int target)
    {
        if (root == null)
            return 0;
        int result = 0;
        if (root.val == target)
            ++result;
        return result+get(root.left,target-root.val)+get(root.right,target-root.val);
    }
}