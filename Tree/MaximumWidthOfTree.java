/*https://practice.geeksforgeeks.org/problems/maximum-width-of-tree/1*/

class Solution {
    // Function to get the maximum width of a binary tree.
    int getMaxWidth(Node root) {
        // Your code here
        int len, i, maxLen = 1;
        Node currNode;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            len = queue.size();
            if (len > maxLen) maxLen = len;
            for (i = 0; i < len; ++i)
            {
                currNode = queue.poll();
                if (currNode.left != null) queue.add(currNode.left);
                if (currNode.right != null) queue.add(currNode.right);
            }
        }
        return maxLen;
    }
}