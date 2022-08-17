/*https://practice.geeksforgeeks.org/problems/bridge-edge-in-graph/1#*/

class Solution
{
    static boolean[] visited;
    static int isBridge(int v, ArrayList<ArrayList<Integer>> adj,int c,int d)
    {
        visited = new boolean[v];

        //run DFS and count the number of components
        int components = 0;
        for (int i = 0; i < v; ++i)
        {
            if (!visited[i])
            {
                ++components;
                visited[i] = true;
                runDFS(adj,i);
            }
        }

        //remove the given edge
        adj.get(c).remove(new Integer(d));
        adj.get(d).remove(new Integer(c));

        //run DFS and count the number of components again
        int newComponents = 0;
        visited = new boolean[v];
        for (int i = 0; i < v; ++i)
        {
            if (!visited[i])
            {
                ++newComponents;
                visited[i] = true;
                runDFS(adj,i);
            }
        }

        //return 0 if the components are equal otherwise 1
        return newComponents-components == 0 ? 0 : 1;
    }
    static void runDFS(ArrayList<ArrayList<Integer>> adj, int node)
    {
        for (Integer adjacentNode : adj.get(node))
        {
            if (!visited[adjacentNode])
            {
                visited[adjacentNode] = true;
                runDFS(adj,adjacentNode);
            }
        }
    }
}

// User function Template for Java

class Solution
{
    static boolean[] visited;
    //Function to find if the given edge is a bridge in graph.
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj,int c,int d)
    {
        // code here
        visited = new boolean[V];
        
        adj.get(c).remove(new Integer(d));
        adj.get(d).remove(new Integer(c));
        
        dfs(adj,c);
        
        return visited[d] ? 0 : 1;
    }
    static void dfs(ArrayList<ArrayList<Integer>> graph, int src)
    {
        visited[src] = true;
        
        for (int adjNode : graph.get(src))
            if (!visited[adjNode])
                dfs(graph,adjNode);
    }
}