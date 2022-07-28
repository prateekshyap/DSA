/*https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal/*/

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
    int index;
    List<Integer> result;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        index = 0;
        result = new ArrayList<Integer>();
        boolean check = solve(root,voyage);
        if (check) return result;
        return Arrays.asList(-1);
    }
    private boolean solve(TreeNode root, int[] voyage)
    {
        if (root == null) return true;
        if (root.val != voyage[index]) return false;
        ++index;
        if (root.left != null && root.left.val != voyage[index])
        {
            result.add(root.val);
            return solve(root.right,voyage) && solve(root.left,voyage);
        }
        return solve(root.left,voyage) && solve(root.right,voyage);
    }
}