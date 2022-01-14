/*https://practice.geeksforgeeks.org/problems/euler-circuit-in-a-directed-graph/1*/

class Solution
{
    public boolean isEularCircuitExist(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        int[] degrees = new int[V];
        
        for (int i = 0; i < V; ++i)
        {
            ArrayList<Integer> adjVertices = adj.get(i);
            for (Integer vertex : adjVertices)
            ++degrees[vertex];
        }

        for (int i = 0; i < V; ++i)
            if (degrees[i]%2 != 0)
                return false;
                
        return true;
    }
}