/*https://leetcode.com/problems/find-largest-value-in-each-tree-row/*/

//level order traversal
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode curr;
        int len, i, max = Integer.MIN_VALUE;
        queue.add(root);
        while (!queue.isEmpty())
        {
            max = Integer.MIN_VALUE;
            len = queue.size();
            for (i = 0; i < len; ++i)
            {
                curr = queue.poll();
                if (curr.val > max) max = curr.val;
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
            result.add(max);
        }
        return result;
    }
}

//recursion
class Solution {
    ArrayList<Integer> res = new ArrayList<>();
    int depth =0;
    public List<Integer> largestValues(TreeNode root) {
        traverse(root);
        return res;
    }
    private void traverse(TreeNode root)
    {
        if(root==null)
            return;
        depth++;
        if(depth>res.size())
        {
            res.add(root.val);
        }
        else
        {
            if(res.get(depth-1)<root.val)
                res.set(depth-1,root.val);
        }
        traverse(root.left);
        traverse(root.right);
        depth--;
    }
}