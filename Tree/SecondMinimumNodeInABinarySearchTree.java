/*https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/*/

class Solution {
    Integer min, secondMin;
    public int findSecondMinimumValue(TreeNode root) {
        recur(root);
        return secondMin == null ? -1 : secondMin;
    }
    public void recur(TreeNode root)
    {
        if (root == null) return;
        recur(root.left);
        recur(root.right);
        if (min == null || root.val < min)
        {
            secondMin = min;
            min = root.val;
        }
        else if ((secondMin == null || root.val < secondMin) && root.val != min)
            secondMin = root.val;
    }
}