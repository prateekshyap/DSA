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

class Solution
{
    int[] color;
    int V;
    
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // code here
        color = new int[V];
        this.V = V;
        for (int i = 0; i < V; ++i) if (color[i] == 0 && dfs(adj, i)) return true;
        return false;
    }
    
    private boolean dfs(ArrayList<ArrayList<Integer>> graph, int src)
    {
        color[src] = 1;
        
        for (int adjNode : graph.get(src))
        {
            if (color[adjNode] == 1)
                return true;
            if (color[adjNode] == 0)
                if (dfs(graph,adjNode))
                    return true;
        }
        
        color[src] = 2;
        return false;
    }
}

class Solution
{
    // int[] color;
    enum Color
    {
        WHITE,
        GRAY,
        BLACK
    }
    Color[] color;
    int V;
    
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // code here
        color = new Color[V];
        Arrays.fill(color,Color.WHITE);
        this.V = V;
        for (int i = 0; i < V; ++i) if (color[i] == Color.WHITE && dfs(adj, i)) return true;
        return false;
    }
    
    private boolean dfs(ArrayList<ArrayList<Integer>> graph, int src)
    {
        color[src] = Color.GRAY;
        
        for (int adjNode : graph.get(src))
        {
            if (color[adjNode] == Color.GRAY) return true;
            if (color[adjNode] == Color.WHITE)
                if (dfs(graph,adjNode))
                    return true;
        }
        
        color[src] = Color.BLACK;
        return false;
    }
}