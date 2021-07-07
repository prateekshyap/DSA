/*https://practice.geeksforgeeks.org/problems/negative-weight-cycle3504/1*/

class Solution
{
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        int[] d = new int[n];
        for (int i = 1; i < n; ++i)
            d[i] = Integer.MAX_VALUE;
        for (int i = 0; i < n-1; ++i)
            for (int[] edge : edges)
                if(d[edge[0]] != Integer.MAX_VALUE && d[edge[0]]+edge[2] < d[edge[1]])
                    d[edge[1]] = d[edge[0]]+edge[2];
        for (int[] edge : edges)
            if (d[edge[0]] != Integer.MAX_VALUE && d[edge[0]]+edge[2] < d[edge[1]])
                return 1;
        return 0;
    }
}

/*https://practice.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1/*/

class Solution
{
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> adj, int S)
    {
        int[] d = new int[V];
        for (int i = 0; i < V; ++i)
            if (i != S) d[i] = 100000000;
        for (int i = 0; i < V-1; ++i)
            for (ArrayList<Integer> edge : adj)
                if(d[edge.get(0)] != Integer.MAX_VALUE && d[edge.get(0)]+edge.get(2) < d[edge.get(1)])
                    d[edge.get(1)] = d[edge.get(0)]+edge.get(2);
        return d;
    }
}