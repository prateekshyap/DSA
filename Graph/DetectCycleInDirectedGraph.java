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