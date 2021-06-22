/*https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1*/

class Solution
{
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        int[] pathCosts = new int[V];
        boolean[] checkedVertices = new boolean[V];
        
        //initialize all path costs to infinity except the source
        for (int i = 0; i < V; ++i)
            if (i != S)
                pathCosts[i] = Integer.MAX_VALUE;
                
        for (int count = 1; count < V; ++count)
        {
            //extract minimum from the unchecked vertices and mark it checked
            int minVertex = getMinVertex(pathCosts, checkedVertices, V);
            checkedVertices[minVertex] = true;

            //get the adjacent nodes
            ArrayList<ArrayList<Integer>> adjacentNodes = adj.get(minVertex);
            
            //relax all the adjacent edges
            for (ArrayList<Integer> edge : adjacentNodes)
                pathCosts = relaxEdge(pathCosts, minVertex, (Integer)edge.get(0), (Integer)edge.get(1));
        }
        
        return pathCosts;
    }
    
    static int getMinVertex(int[] costs, boolean[] checked, int V)
    {
        int minValue = Integer.MAX_VALUE, index = -1;
        for (int i = 0; i < V; ++i)
            if (!checked[i] && costs[i] < minValue)
            {
                minValue = costs[i];
                index = i;
            }
        return index;
    }
    
    static int[] relaxEdge(int[] pathCosts, int source, int destination, int weight)
    {
    	//update the path cost
        if (pathCosts[destination] > pathCosts[source]+weight)
            pathCosts[destination] = pathCosts[source]+weight;
        return pathCosts;
    }
}