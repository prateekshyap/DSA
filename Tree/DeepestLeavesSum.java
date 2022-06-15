/*https://leetcode.com/problems/deepest-leaves-sum/*/

class Solution {
    int sum, maxLevel;
    public int deepestLeavesSum(TreeNode root) {
        sum = 0;
        maxLevel = -1;
        recur(root, 0);
        return sum;
    }
    public void recur(TreeNode root, int level)
    {
        if (root == null) return;
        if (root.left == null && root.right == null)
        {
            if (level == maxLevel)
                sum += root.val;
            else if (level > maxLevel)
            {
                maxLevel = level;
                sum = root.val;
            }
            return;
        }
        recur(root.left, level+1);
        recur(root.right, level+1);
    }
}