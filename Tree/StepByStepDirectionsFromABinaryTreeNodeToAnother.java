/*https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/*/

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
    int start, end;
    StringBuilder build1, build2;
    public String getDirections(TreeNode root, int startValue, int destValue) {
        build1 = new StringBuilder("");
        build2 = new StringBuilder("");
        this.start = startValue;
        this.end = destValue;
        recur(root,new StringBuilder(""));
        int i = 0;
        while (i < build1.length() && i < build2.length() && build1.charAt(i) == build2.charAt(i))
            ++i;
        StringBuilder result = new StringBuilder("");
        for (int move = i; move < build1.length(); ++move)
            result.append("U");
        for (int move = i; move < build2.length(); ++move)
            result.append(build2.charAt(move));
        return result.toString();
    }
    private void recur(TreeNode root, StringBuilder build)
    {
        if (root == null) return;
        
        if (root.val == start) build1 = new StringBuilder(build);
        else if (root.val == end) build2 = new StringBuilder(build);
        
        build.append("L");
        recur(root.left,build);
        build.replace(build.length()-1,build.length(),"R");
        recur(root.right,build);
        build.delete(build.length()-1,build.length());
    }
}