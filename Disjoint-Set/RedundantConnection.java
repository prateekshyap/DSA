/*https://leetcode.com/problems/redundant-connection/*/

//cycle finding solution
class Solution {
    int start;
    public int[] findRedundantConnection(int[][] edges) {
        int n = 1, i, maxIndex = -1, temp;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        
        //find the total number of vertices
        for (int[] edge: edges)
        {
            if (edge[0] > n) n = edge[0];
            if (edge[1] > n) n = edge[1];
        }
        
        //create a graph with adjacency list
        for (i = 0; i < n; ++i) graph.add(new ArrayList<Integer>());
        
        for (int[] edge : edges)
        {
            graph.get(edge[0]-1).add(edge[1]-1);
            graph.get(edge[1]-1).add(edge[0]-1);
        }
        
        int[] currentPath = isCycle(n,graph); //get the cycle
        
        //get the starting and ending index of the cycle
        HashSet<Integer[]> cycleEdges = new HashSet<Integer[]>();
        int startIndex = -1, endIndex = -1;
        for (i = 0; i < n*2; ++i)
        {
            if (currentPath[i] == start && startIndex == -1) startIndex = i;
            else if (currentPath[i] == start){
                endIndex = i; break;
            }
        }

        //for each edge in the cycle, add it to hashset
        for (i = startIndex; i < endIndex; ++i)
        {
            Integer[] cycleEdge = new Integer[]{currentPath[i]+1,currentPath[i+1]+1};
            Arrays.sort(cycleEdge);
            cycleEdges.add(cycleEdge);
        }
        
        //iterate over the hashset
        Iterator it = cycleEdges.iterator();
        /*while (it.hasNext())
        {
            Integer[] arr = (Integer[])it.next();
        }*/

        //for each edge in the list, if present in the hashset, store in maxindex
        for (i = 0; i < edges.length; ++i)
        {
            Integer[] edge = new Integer[]{edges[i][0],edges[i][1]};
            if (cycleEdges.stream().anyMatch(c -> Arrays.equals(c, edge))) maxIndex = i;
        }
        
        return edges[maxIndex];
    }
    
    public int[] isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] visited = new boolean[V];
        boolean[] currentPath = new boolean[V];
        int[] currString = new int[V*2];

        for (int i = 0; i < V*2; ++i)
            currString[i] = -1;
        
        //check cycle starting from every node
        for (int i = 0; i < V; ++i)
        {
            currString[0] = i;
            if (checkCycle(i,adj,currString,0,visited,currentPath))
                return currString;
        }
        return currString;
    }
    public boolean checkCycle(int currNode, ArrayList<ArrayList<Integer>> graph, int[] currString, int currInd, boolean[] visited, boolean[] currentPath)
    {
    	//if the current node is already visited in the current recursion call and it is not the parent of the node, cycle exists
        if (currentPath[currNode] && currString[currInd-2] != currNode)
        {
            start = currNode;
            return true;
        }

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

//simple and faster solution using disjoint set
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = 0, i;
        int[] result = null;
        for (int[] edge : edges)
        {
            if (edge[0] > n) n = edge[0];
            if (edge[1] > n) n = edge[1];
        }
        int[] parent = new int[n];
        
        //store nodes as their own parents
        for (i = 0; i < n; ++i)
            parent[i] = i;
        
        for (int[] edge : edges) //for each connection
        {
            boolean isCycle = unionAndFind(parent, edge[0]-1, edge[1]-1); //call union and find
            if (isCycle) result = edge; //if parent is same as current node, it means it was already in the set but still having an edge, so that edge is redundant
        }
        return result;
    }
    public boolean unionAndFind(int[] parent, int x, int y)
    {
        int parentX = find(parent,x);
        int parentY = find(parent,y);
        
        if (parentX == parentY) return true;
        
        parent[parentX] = parentY;
        return false;
    }
    public int find(int[] parent, int node)
    {
        if (parent[node] == node) return node;
        parent[node] = find(parent,parent[node]);
        return parent[node];
    }
}