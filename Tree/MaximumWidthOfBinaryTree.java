/*https://leetcode.com/problems/maximum-width-of-binary-tree/*/

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int len, currLen = 0, maxLen = 0, i, firstNode = -1;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode currNode;
        int maxNodes = 1;
        boolean isAdded = false;
        
        queue.add(root);
        
        while (!queue.isEmpty())
        {
            len = queue.size();
            currLen = 0;
            isAdded = false;
            firstNode = -1;
            for (i = 0; i < len; ++i)
            {
                currNode = queue.poll();
                if (currNode.val != -1)
                {
                    if (firstNode == -1) firstNode = i+1;
                    currLen = i+1;
                }
                if (currNode.val != -1 && currNode.left != null) { isAdded = true; queue.add(currNode.left); } else queue.add(new TreeNode(-1));
                if (currNode.val != -1 && currNode.right != null) { isAdded = true; queue.add(currNode.right); } else queue.add(new TreeNode(-1));
            }
            if (currLen-firstNode+1 > maxLen) maxLen = currLen-firstNode+1;
            if (!isAdded) break;
        }
        
        return maxLen;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,root));
        int ans = 0, i;
        while (!q.isEmpty())
        {
            int lh = q.peek().ind;
            int rh = q.peek().ind;
            int s = q.size();
            
            for (i = 0; i < s; ++i)
            {    
                Pair p = q.remove();
                rh = p.ind;
                if (p.node.left != null) q.add(new Pair(rh*2+1,p.node.left));
                if (p.node.right != null) q.add(new Pair(rh*2+2,p.node.right));
                ans = Math.max(ans,rh-lh+1);
                
            }
        }
        return ans;
    }
    static class Pair
    {
        int ind; // for index of the node;
        TreeNode node;
        Pair(int ind, TreeNode node)
        {
            this.ind= ind;
            this.node = node;
        }
    }
}