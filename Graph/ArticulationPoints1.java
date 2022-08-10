/*https://practice.geeksforgeeks.org/problems/articulation-point-1/0/*/

class Solution
{
    int timer;
    boolean[] visited, isArtPoint;
    int[] discovery, parent, low;
    //Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        timer = 0;
        visited = new boolean[V];
        isArtPoint = new boolean[V];
        discovery = new int[V];
        parent = new int[V];
        low = new int[V];
        int v;
        
        ArrayList<Integer> articulationPoints = new ArrayList<Integer>();
        
        for (v = 0; v < V; ++v)
            parent[v] = -1;
        
        for (v = 0; v < V; ++v)
            if (!visited[v])
                dfs(adj,v);
        
        for (v = 0; v < V; ++v)
            if (isArtPoint[v])
                articulationPoints.add(v);

        if (articulationPoints.size() == 0) articulationPoints.add(-1);
                
        return articulationPoints;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> graph, int source)
    {
        int children = 0;
        visited[source] = true;
        discovery[source] = low[source] = ++timer;
        for (Integer adjNode : graph.get(source))
        {
            if (!visited[adjNode]) //tree edge
            {
                ++children;
                parent[adjNode] = source;
                dfs(graph, adjNode);
                low[source] = Math.min(low[source],low[adjNode]); //update the low value from the immediate child of dfs tree
                if (parent[source] != -1 && low[adjNode] >= discovery[source]) //articulation point rule
                    isArtPoint[source] = true;
            }
            else if (adjNode != parent[source]) //back edge //this condition ensures that we are not updating the low value for its immediate parent from which the dfs call started
            {
                low[source] = Math.min(low[source],discovery[adjNode]); //update the low value of the previously visited adjacent node i.e. the destination node of a back edge
            }
        }
        if (parent[source] == -1 && children > 1) //articulation point rule
            isArtPoint[source] = true;
    }
}