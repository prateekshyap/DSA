/*https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/*/

class Solution {
    int sum;
    public int sumEvenGrandparent(TreeNode root) {
        sum = 0;
        if (root.val%2 == 0) recur(root, false, false);
        else recur(root, false, false);
        return sum;
    }
    public void recur(TreeNode root, boolean val1, boolean val2)
    {
        if (root == null) return;
        if (val2) sum += root.val;
        if (root.val%2 == 0)
        {
            recur(root.left, true, val1);
            recur(root.right, true, val1);
        }
        else
        {
            recur(root.left, false, val1);
            recur(root.right, false, val1);
        }
    }
}