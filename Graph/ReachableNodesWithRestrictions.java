/*https://leetcode.com/problems/reachable-nodes-with-restrictions/*/

class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        int count = 0;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        Queue<Integer> queue = new LinkedList<Integer>();
        HashSet<Integer> restrictedSet = new HashSet<Integer>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; ++i)
            graph.add(new ArrayList<Integer>());
        for (int[] edge : edges)
        {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        for (int val : restricted)
            restrictedSet.add(val);
        queue.add(0);
        
        while (!queue.isEmpty())
        {
            int node = queue.poll();
            if (visited[node]) continue;
            visited[node] = true;
            if (restrictedSet.contains(node)) continue;
            ++count;
            for (Integer adjNode : graph.get(node))
                if (!visited[adjNode])
                    queue.add(adjNode);
        }
        
        return count;
    }
}

class Solution {
    List<Integer> [] graph;
    boolean [] visited;
    
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        graph = new List[n];
        visited = new boolean [n];
        
        for (int i = 0; i < n; ++i)
            graph[i] = new ArrayList<>();
        
        for (int [] edge : edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        for (int num : restricted)
            visited[num] = true;
        
        return dfs(0);
    }
    
    private int dfs(int node){
        if (visited[node])
            return 0;
        
        visited[node] = true;
        int result = 1;
        
        for (int child : graph[node]){
            result += dfs(child);    
        }
        
        return result;
    }
}