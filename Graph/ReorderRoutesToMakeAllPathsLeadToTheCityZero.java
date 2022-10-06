/*https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/*/

class Solution {
    public int minReorder(int n, int[][] connections) {
        Map<Integer,Set<Integer>> diGraph = new HashMap<Integer,Set<Integer>>();
        Map<Integer,List<Integer>> graph = new HashMap<Integer,List<Integer>>();
        int V = 0;
        for (int[] edge : connections)
        {
            graph.putIfAbsent(edge[0], new ArrayList<Integer>());
            graph.putIfAbsent(edge[1], new ArrayList<Integer>());
            diGraph.putIfAbsent(edge[0], new HashSet<Integer>());

            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            diGraph.get(edge[0]).add(edge[1]);

            V = Math.max(V,edge[0]);
            V = Math.max(V,edge[1]);
        }
        boolean[] visited = new boolean[V+1];
        Queue<Integer> queue = new LinkedList<Integer>();
        int count = 0;
        queue.add(0);
        while (!queue.isEmpty())
        {
            int vertex = queue.poll();
            visited[vertex] = true;
            for (int adjVertex : graph.get(vertex))
            { 
                if (!visited[adjVertex] && diGraph.containsKey(vertex) && diGraph.get(vertex).contains(adjVertex))
                    ++count;
                if (!visited[adjVertex]) queue.add(adjVertex);
            }
        }
        return count;
    }
}

class Solution {
    public int minReorder(int n, int[][] connections) {
        Map<Integer,List<Integer>> graph = new HashMap<Integer,List<Integer>>();
        for (int[] edge : connections)
        {
            graph.putIfAbsent(edge[0],new ArrayList<Integer>());
            graph.putIfAbsent(edge[1],new ArrayList<Integer>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(-edge[0]);
        }
        return dfs(graph,0,new boolean[n]);
    }
    
    public int dfs(Map<Integer,List<Integer>> graph, int src, boolean[] visited)
    {
        visited[src] = true;
        int result = 0;
        for (Integer adjNode : graph.get(src))
        {
            if (!visited[Math.abs(adjNode)])
                result += dfs(graph,Math.abs(adjNode),visited)+(adjNode > 0 ? 1 : 0);
        }
        return result;
    }
}