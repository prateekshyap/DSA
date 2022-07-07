/*https://leetcode.com/problems/sum-root-to-leaf-numbers/*/

class Solution {
    int sum;
    public int sumNumbers(TreeNode root) {
        sum = 0;
        solve(root,0);
        return sum;
    }
    public void solve(TreeNode root, int currNum)
    {
        if (root == null) return;
        if (root.left == null && root.right == null)
        {
            currNum *= 10;
            currNum += root.val;
            sum += currNum;
            return;
        }
        currNum *= 10;
        currNum += root.val;
        solve(root.left,currNum);
        solve(root.right,currNum);
    }
}