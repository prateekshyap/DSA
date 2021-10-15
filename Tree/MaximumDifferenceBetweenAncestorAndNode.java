/*https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/*/

class Solution {
    ArrayList<Integer> currPath;
    int maxDiff;
    public int maxAncestorDiff(TreeNode root) {
        maxDiff = 0;
        currPath = new ArrayList<Integer>();
        currPath.add(root.val);
        recur(root,currPath);
        return maxDiff;
    }
    public void recur(TreeNode root, ArrayList<Integer> currPath)
    {
        if (root.left == null && root.right == null)
        {
            //update maximum difference
            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
            for (Integer value : currPath)
            {
                max = Math.max(max,value);
                min = Math.min(min,value);
            }
            maxDiff = Math.max(maxDiff,Math.abs(max-min));
            return;
        }
        if (root.left != null)
        {
            currPath.add(root.left.val);
            recur(root.left,currPath);
            currPath.remove(currPath.size()-1);
        }
        if (root.right != null)
        {
            currPath.add(root.right.val);
            recur(root.right,currPath);
            currPath.remove(currPath.size()-1);
        }
    }
}