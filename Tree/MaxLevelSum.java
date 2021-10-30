/*https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/*/

class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int currSum = 0, maxSum = Integer.MIN_VALUE, maxLevel = 0, levelCount = 0;
        while (!queue.isEmpty())
        {
            ++levelCount;
            currSum = 0;
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; ++i)
            {
                TreeNode node = queue.poll();
                currSum += node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            if (currSum > maxSum)
            {
                maxSum = currSum;
                maxLevel = levelCount;
            }
        }
        return maxLevel;
    }
}