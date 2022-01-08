/*https://practice.geeksforgeeks.org/problems/possible-paths-between-2-vertices-1587115620/1*/

class Solution {
    int paths;
    boolean[] visited;
    // Function to count paths between two vertices in a directed graph.
    public int countPaths(int V, ArrayList<ArrayList<Integer>> adj, int source,
                   int destination) {
        // Code here
        paths = 0;
        visited = new boolean[V];
        visited[source] = true;
        
        runDFS(source,adj,destination);
        
        return paths;
    }
    public void runDFS(int source, ArrayList<ArrayList<Integer>> adj, int destination)
    {
        if (source == destination)
        {
            ++paths;
            return;
        }
        ArrayList<Integer> adjNodes = adj.get(source);
        for (int adjNode : adjNodes)
        {
            if (!visited[adjNode]) //automatically avoids cycles, self loops and multiple edges
            {
                visited[adjNode] = true;
                runDFS(adjNode,adj,destination);
                visited[adjNode] = false; //backtracking
            }
        }
    }
}