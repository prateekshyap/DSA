/*https://leetcode.com/problems/critical-connections-in-a-network/*/

class Solution {
    int timer;
    int[] disc, low, parent;
    boolean[] visited;
    List<List<Integer>> result;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        result = new ArrayList<List<Integer>>();
        visited = new boolean[n];
        disc = new int[n];
        low = new int[n];
        parent = new int[n];
        Arrays.fill(parent,-1);
        timer = 0;
        
        int i;
        for (i = 0; i < n; ++i)
            graph.add(new ArrayList<Integer>());
        for (List<Integer> edge : connections)
        {
            graph.get(edge.get(0)).add(edge.get(1));
            graph.get(edge.get(1)).add(edge.get(0));
        }
        for (i = 0; i < n; ++i)
            if (!visited[i])
                dfs(graph,i);
        return result;
    }
    private void dfs(ArrayList<ArrayList<Integer>> graph, int src)
    {
        visited[src] = true;
        disc[src] = low[src] = ++timer;
        
        for (int adjNode : graph.get(src))
        {
            if (!visited[adjNode]) //tree edge
            {
                parent[adjNode] = src;
                dfs(graph,adjNode);
                low[src] = Math.min(low[src],low[adjNode]);
            }
            else if (parent[src] != adjNode) //back edge
                low[src] = Math.min(low[src],disc[adjNode]);
            if (low[adjNode] > disc[src]) //bridge rule
                result.add(Arrays.asList(src,adjNode));
        }
    }
}