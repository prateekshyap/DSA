/*https://leetcode.com/problems/smallest-string-starting-from-leaf/*/

class Solution {
    String result;
    public String smallestFromLeaf(TreeNode root) {
        result = "{";
        solve(root,new StringBuilder(""));
        return result;
    }
    public void solve(TreeNode root, StringBuilder currStr)
    {
        if (root == null) return;
        if (root.left == null && root.right == null)
        {
            currStr.insert(0,(char)(root.val+'a'));
            if (result.compareTo(currStr.toString()) > 0)
                result = currStr.toString();
            currStr.delete(0,1);
            return;
        }
        
        currStr.insert(0,(char)(root.val+'a'));
        solve(root.left,currStr);
        solve(root.right,currStr);
        currStr.delete(0,1);
    }
}