/*https://leetcode.com/problems/longest-cycle-in-a-graph/*/

class Solution {
    Integer[] length;
    int maxLength;
    boolean[] visited;
    Boolean[] cycleHere;
    public int longestCycle(int[] edges) {
        //build the graph
        int max = 0, n = edges.length, i;
        maxLength = -1;
        for (i = 0; i < n; ++i)
        {
            if (i > max) max = i;
            if (edges[i] > max) max = edges[i];
        }
        n = max+1;
        visited = new boolean[n];
        cycleHere = new Boolean[n];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for (i = 0; i < n; ++i)
            graph.add(new ArrayList<Integer>());
        for (i = 0; i < edges.length; ++i)
            if (edges[i] != -1)
                graph.get(i).add(edges[i]);
        length = new Integer[n];
        
        for (i = 0; i < n; ++i) //for each node
        {
            if (!visited[i]) //if unvisited
            {
                cycleHere[i] = dfs(graph,i,-1,0); //call dfs
            }
        }
        
        return maxLength;
    }
    
    
    private boolean dfs(ArrayList<ArrayList<Integer>> graph, int src, int parent, int len)
    {
        if (visited[src]) //if node is already visited
        {
            if (cycleHere[src] == null || cycleHere[src]) //if cycle not yet checked or cycle is found
            {
                maxLength = Math.max(maxLength,len-length[src]); //update max length
                return true; //return true
            }
            return false; //return false
        }
        visited[src] = true; //mark as visited
        length[src] = len; //store length in length array
        boolean result = false; //initialize result as false
        for (int adjNode : graph.get(src)) //for each adjacent node of source
        {
            result |= dfs(graph,adjNode,src,len+1); //call dfs and or with result
        }
        cycleHere[src] = result; //store the result in cycle information
        return result; //return result
    }
}

class Solution {
    Map<Integer, Integer> map;
    boolean [] visited;
    int result;
    
    public int longestCycle(int[] edges) {
        visited = new boolean [edges.length];
        map = new HashMap<>();
        result = -1;
        
        for (int i = 0; i < edges.length; ++i)
        {
            if (visited[i]) continue;
            map = new HashMap<>();
            dfs(i, 0, edges);
        }
        
        return result;
    }
    
    private void dfs(int node, int count, int [] edges){
        if (node == -1)
            return;
        else if (map.containsKey(node))
        {
            result = Math.max(result, count-map.get(node));
            return;
        }
        else if (visited[node])
            return;
        
        visited[node] = true;
        map.put(node,count++);
        dfs(edges[node],count,edges);
    }
}