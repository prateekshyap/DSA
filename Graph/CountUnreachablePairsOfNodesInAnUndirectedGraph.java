/*https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/*/

//dfs approach
class Solution {
    boolean[] visited;
    List<List<Integer>> components;
    public long countPairs(int n, int[][] edges) {
        visited = new boolean[n];
        components = new ArrayList<List<Integer>>();
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        int i;
        for (i = 0; i < n; ++i) graph.add(new ArrayList<Integer>());
        for (int[] edge : edges)
        {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        for (i = 0; i < n; ++i)
        {
            if (!visited[i])
            {
                Set<Integer> newComponent = new HashSet<Integer>();
                dfs(graph,i,newComponent);
                components.add(new ArrayList<>(newComponent));
            }
        }
        long[] pre = new long[components.size()];
        pre[0] = components.get(0).size();
        for (i = 1; i < pre.length; ++i) pre[i] = pre[i-1]+components.get(i).size();
        long result = 0;
        for (i = 0; i < pre.length-1; ++i)
            result += pre[i]*components.get(i+1).size();
        return result;
    }
    public void dfs(List<List<Integer>> graph, int src, Set<Integer> component)
    {
        visited[src] = true;
        component.add(src);
        
        for (Integer adjNode : graph.get(src))
            if (!visited[adjNode])
                dfs(graph,adjNode,component);
    }
}