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