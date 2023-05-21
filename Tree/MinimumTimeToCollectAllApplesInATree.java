/*https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/*/

//Tree
class TreeNode
{
    boolean hasApple;
    int value;
    List<TreeNode> children;
    TreeNode (int value, boolean hasApple)
    {
        this.value = value;
        this.hasApple = hasApple;
        this.children = new ArrayList<TreeNode>();
    }
}

class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        TreeNode root = new TreeNode(0,hasApple.get(0));
        boolean[] visited = new boolean[n];
        Map<Integer,TreeNode> nodesMap = new HashMap<>();
        nodesMap.put(0,root);
        visited[0] = true;
        for (int[] edge : edges)
        {
            if (!nodesMap.containsKey(edge[0]))
                nodesMap.put(edge[0],new TreeNode(edge[0],hasApple.get(edge[0])));
            if (!nodesMap.containsKey(edge[1]))
                nodesMap.put(edge[1],new TreeNode(edge[1],hasApple.get(edge[1])));
            if (visited[edge[0]])
            {
                nodesMap.get(edge[0]).children.add(nodesMap.get(edge[1]));
                visited[edge[1]] = true;
            }
            else
            {
                nodesMap.get(edge[1]).children.add(nodesMap.get(edge[0]));
                visited[edge[0]] = true;
            }
        }
        int edgeCount = 0;
        for (TreeNode node : root.children)
            edgeCount += countEdges(node);
        return 2*edgeCount;
    }
    private int countEdges(TreeNode root)
    {
        if (root == null) return 0;
        
        int edges = 0;
        for (TreeNode node : root.children)
            edges += countEdges(node);
        
        if (!root.hasApple && edges == 0) return 0;
        return edges+1;
    }
}

//Tree without actually building it
class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        var parent = new int[n];
        for (var i = 0; i < n; ++i) {
            parent[i] = -2;
        }
        parent[0] = -1;
        for (var edge : edges) {
            if (parent[edge[1]] == -2) {
                parent[edge[1]] = edge[0];
            } else {
                parent[edge[0]] = edge[1];
            }
        }

        // System.out.println(Arrays.toString(parent));

        var visited = new boolean[n];
        var count = 0;
        for (var i = 0; i < n; ++i) {
            if (hasApple.get(i)) {
                var curr = i;
                while (curr >= 0 && !visited[curr]) {
                    visited[curr] = true;
                    ++count;
                    curr = parent[curr];
                }
            }
        }

        return count == 0 ? 0 : (count - 1) * 2;
    }
}

//Graph
class Solution {
    boolean[] visited;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        visited = new boolean[n];
        for (int[] edge : edges)
        {
            if (!graph.containsKey(edge[0])) graph.put(edge[0],new ArrayList<>());
            if (!graph.containsKey(edge[1])) graph.put(edge[1],new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return 2*countEdges(graph,0,-1,hasApple);
    }
    private int countEdges(Map<Integer,List<Integer>> graph, int node, int parent, List<Boolean> hasApple)
    {
        if (!graph.containsKey(node))
            return 0;
        
        int totalEdges = 0, childEdges = 0;
        
        for (Integer adjNode : graph.get(node))
        {
            if (adjNode == parent) continue;
            childEdges = countEdges(graph,adjNode,node,hasApple);
            if (childEdges > 0 || hasApple.get(adjNode))
                totalEdges += childEdges+1;
        }
        
        return totalEdges;
    }
}