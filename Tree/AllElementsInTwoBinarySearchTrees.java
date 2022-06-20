/*https://leetcode.com/problems/all-elements-in-two-binary-search-trees/*/

class Solution {
    List<Integer> result;
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        result = new ArrayList<Integer>();
        inOrder(root1);
        inOrder(root2);
        Collections.sort(result);
        return result;
    }
    public void inOrder(TreeNode root)
    {
        if (root == null) return;
        inOrder(root.left);
        result.add(root.val);
        inOrder(root.right);
    }
}