/*https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1*/

class Solution
{
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] visited = new boolean[V];
        boolean[] currentPath = new boolean[V];
        int[] currString = new int[V*2];

        //check cycle starting from every node
        for (int i = 0; i < V; ++i)
        {
            currString[0] = i;
            if (checkCycle(i,adj,currString,0,visited,currentPath))
                return true;
        }
        return false;
    }
    public boolean checkCycle(int currNode, ArrayList<ArrayList<Integer>> graph, int[] currString, int currInd, boolean[] visited, boolean[] currentPath)
    {
    	//if the current node is already visited in the current recursion call and it is not the parent of the node, cycle exists
        if (currentPath[currNode] && currString[currInd-2] != currNode) return true;

        //if the current node is checked for cycle and program isn't terminated, cycle doesn't exists
        if (visited[currNode]) return false;

        //mark the current node visited
        visited[currNode] = true;
        currentPath[currNode] = true; 

        //get the adjacent nodes
        ArrayList<Integer> adjacentNodes = graph.get(currNode);
        
        //recur for every adjacent node
        for (Integer adjacentNode : adjacentNodes)
        {
            currString[++currInd] = adjacentNode;
            if (checkCycle(adjacentNode,graph,currString,currInd,visited,currentPath))
                return true;
            --currInd;
        }

        //backtrack
        currentPath[currNode] = false;
        
        return false;
    }
}

class Solution {
    int[] color;
    boolean result;
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        color = new int[V];
        result = false;
        for (int i = 0; i < V; ++i) if (color[i] == 0) dfs(adj, V, i, -1);
                
        return result;
    }
    public void dfs(ArrayList<ArrayList<Integer>> graph, int V, int src, int parent)
    {
        if (result) return;
        
        color[src] = 1; // entry color is 1
        for (int adjacentNode : graph.get(src)) // for each neighbour of the current node
        {
            if (color[adjacentNode] == 2) // if color is 2
                continue; // continue
            if (adjacentNode != parent) // if color is 1 or dfs from neighbour is false, return false
            {
                if (color[adjacentNode] == 1)
                {
                    result = true;
                    break;
                }
                dfs(graph, V, adjacentNode, src); //recursion call
            }
        }

        if (result) return;
        color[src] = 2; // exit color is 2
    }
}