/*https://leetcode.com/problems/count-nodes-with-the-highest-score/*/

class TreeNode
{
    TreeNode left;
    long leftSubtree;
    int data;
    long rightSubtree;
    TreeNode right;
    TreeNode(int data)
    {
        this.data = data;
    }
}

class Solution {
    TreeNode root;
    long totalNodes;
    int maxCount;
    long max;
    public int countHighestScoreNodes(int[] parents) {
        int i, n = parents.length;;
        max = 0l;
        maxCount = 0;
        TreeNode curr, par;
        Map<Integer,TreeNode> map = new HashMap<Integer,TreeNode>();
        for (i = 0; i < n; ++i)
            map.put(i,new TreeNode(i));
        for (i = 1; i < n; ++i)
        {
            curr = map.get(i);
            par = map.get(parents[i]);
            if (par.left == null) par.left = curr;
            else par.right = curr;
        }
        root = map.get(0);
        totalNodes = count(root);
        findMax(root);
        // System.out.println(max);
        return maxCount;
    }
    private long count(TreeNode root)
    {
        if (root == null) return 0;
        root.leftSubtree = count(root.left);
        root.rightSubtree = count(root.right);
        return root.leftSubtree+root.rightSubtree+1;
    }
    private void findMax(TreeNode root)
    {
        if (root == null) return;
        
        long rem = totalNodes-(root.leftSubtree+root.rightSubtree+1);
        long result = (rem == 0 ? 1 : rem)*(root.leftSubtree == 0 ? 1 : root.leftSubtree)*(root.rightSubtree == 0 ? 1 : root.rightSubtree);
        // System.out.println(root.data+" "+result);
        if (result > max)
        {
            max = result;
            maxCount = 1;
        } else if (result == max)
            ++maxCount;
        
        findMax(root.left);
        findMax(root.right);
    }
}

class TreeNode
{
    TreeNode left;
    long leftSubtree;
    int data;
    long rightSubtree;
    TreeNode right;
    TreeNode(int data)
    {
        this.data = data;
    }
}

class Solution {
    TreeNode root;
    long totalNodes;
    int maxCount;
    long max;
    public int countHighestScoreNodes(int[] parents) {
        int i, n = parents.length;;
        max = 0l;
        maxCount = 0;
        TreeNode curr, par;
        TreeNode[] map = new TreeNode[n];
        for (i = 0; i < n; ++i)
            map[i] = new TreeNode(i);
        for (i = 1; i < n; ++i)
        {
            curr = map[i];
            par = map[parents[i]];
            if (par.left == null) par.left = curr;
            else par.right = curr;
        }
        root = map[0];
        totalNodes = count(root);
        findMax(root);
        // System.out.println(max);
        return maxCount;
    }
    private long count(TreeNode root)
    {
        if (root == null) return 0;
        root.leftSubtree = count(root.left);
        root.rightSubtree = count(root.right);
        return root.leftSubtree+root.rightSubtree+1;
    }
    private void findMax(TreeNode root)
    {
        if (root == null) return;
        
        long rem = totalNodes-(root.leftSubtree+root.rightSubtree+1);
        long result = (rem == 0 ? 1 : rem)*(root.leftSubtree == 0 ? 1 : root.leftSubtree)*(root.rightSubtree == 0 ? 1 : root.rightSubtree);
        // System.out.println(root.data+" "+result);
        if (result > max)
        {
            max = result;
            maxCount = 1;
        } else if (result == max)
            ++maxCount;
        
        findMax(root.left);
        findMax(root.right);
    }
}