/*https://leetcode.com/problems/binary-tree-paths/*/

class Solution {
    List<String> result;
    public List<String> binaryTreePaths(TreeNode root) {
        result = new ArrayList<String>();
        recur(root,new StringBuffer(""));
        return result;
    }
    public void recur(TreeNode root, StringBuffer path)
    {
        if (root == null) return;
        if (root.left == null && root.right == null)
        {
            int len = path.length();
            path.append(root.val);
            result.add(new String(path));
            path.delete(len,path.length());
            return;
        }
        int len = path.length();
        path.append(root.val);
        path.append("->");
        recur(root.left,path);
        recur(root.right,path);
        path.delete(len,path.length());
    }
}