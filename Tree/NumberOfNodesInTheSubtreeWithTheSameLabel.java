/*https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/*/

class TreeNode
{
    int data;
    char label;
    ArrayList<TreeNode> children;
    TreeNode(int data, char label)
    {
        this.data = data;
        this.label = label;
        this.children = new ArrayList<TreeNode>();
    }
}

class Solution {
    int[] result;
    boolean[] visited;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        result = new int[n];
        char[] label = labels.toCharArray();
        int i;
        HashMap<Integer,TreeNode> map = new HashMap<Integer,TreeNode>();
        map.put(0,new TreeNode(0,label[0]));
        boolean onePresent = false, twoPresent = true;
        for (int[] edge : edges)
        {
            onePresent = twoPresent = false;
            if (!map.containsKey(edge[0])) map.put(edge[0],new TreeNode(edge[0],label[edge[0]])); else onePresent = true;
            if (!map.containsKey(edge[1])) map.put(edge[1],new TreeNode(edge[1],label[edge[1]])); else twoPresent = true;
            if (onePresent) map.get(edge[0]).children.add(map.get(edge[1]));
            else map.get(edge[1]).children.add(map.get(edge[0]));
        }
        solve(map.get(0));
        return result;
    }
    private int[] solve(TreeNode root)
    {
        if (root == null) return new int[26];
        int i;
        int[] hash = new int[26], subtreeHash;
        for (TreeNode child : root.children)
        {
            subtreeHash = solve(child);
            for (i = 0; i < 26; ++i)
                hash[i] += subtreeHash[i];
        }
        ++hash[root.label-'a'];
        result[root.data] = hash[root.label-'a'];
        return hash;
    }
}