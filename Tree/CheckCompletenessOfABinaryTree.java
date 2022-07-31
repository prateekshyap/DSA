/*https://leetcode.com/problems/check-completeness-of-a-binary-tree/*/

class Solution {
    public boolean isCompleteTree(TreeNode root) {
        boolean end = false;
        TreeNode currentNode;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty())
        {
            currentNode = queue.poll();
            if (currentNode == null) end = true;
            else
            {
                if (end) return false;
                queue.offer(currentNode.left);
                queue.offer(currentNode.right);
            }
        }
        return true;
    }
}