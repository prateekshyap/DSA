/*https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1*/

class Solution 
{
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] visited = new boolean[V];
        boolean[] currentPath = new boolean[V];

        //check cycle starting from every node
        for (int i = 0; i < V; ++i)
            if (checkCycle(i,adj,visited,currentPath))
                return true;
        return false;
    }
    public boolean checkCycle(int currNode, ArrayList<ArrayList<Integer>> graph, boolean[] visited, boolean[] currentPath)
    {
    	//if the current node is already visited in the current recursion call, cycle exists
        if (currentPath[currNode]) return true;

        //if the current node is checked for cycle and program isn't terminated, cycle doesn't exists
        if (visited[currNode]) return false;

        //mark the current node visited
        visited[currNode] = true;
        currentPath[currNode] = true;

        //get the adjacent nodes
        ArrayList<Integer> adjacentNodes = graph.get(currNode);
        
        //recur for every adjacent node
        for (Integer adjacentNode : adjacentNodes)
            if (checkCycle(adjacentNode,graph,visited,currentPath))
                return true;

        //backtrack
        currentPath[currNode] = false;
        
        return false;
    }
}

class Solution {
    int[] color;
    boolean result;
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        color = new int[V];
        result = false;
        //System.out.println(adj);
        for (int i = 0; i < V; ++i) if (color[i] == 0) dfs(adj, V, i);
                
        return result;
    }
    public void dfs(ArrayList<ArrayList<Integer>> graph, int V, int src)
    {
        if (result) return;
        
        color[src] = 1; // entry color is 1
        for (int adjacentNode : graph.get(src)) // for each neighbour of the current node
        {
            if (color[adjacentNode] == 2) // if color is 2
                continue; // continue
            if (color[adjacentNode] == 1)
            {
                result = true;
                break;
            }
            dfs(graph, V, adjacentNode); //recursion call
        }

        if (result) return;
        color[src] = 2; // exit color is 2
    }
}