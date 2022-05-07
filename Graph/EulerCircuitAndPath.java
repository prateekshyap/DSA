/*https://practice.geeksforgeeks.org/problems/euler-circuit-and-path/1*/

class Solution
{
    public int isEularCircuitExist(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        int[] degrees = new int[V];
        int oddDegreeCounter = 0;
        for (int i = 0; i < V; ++i)
        {
            ArrayList<Integer> adjVertices = adj.get(i);
            for (Integer vertex : adjVertices)
            ++degrees[vertex];
        }
        for (int i = 0; i < V; ++i)
        {
            if (degrees[i]%2 != 0)
                ++oddDegreeCounter;
            if (oddDegreeCounter > 2)
                return 0;
        }
                
        if (oddDegreeCounter == 2) return 1;
        else if (oddDegreeCounter == 0) return 2;
        return 0;
    }
}