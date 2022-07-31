/*https://practice.geeksforgeeks.org/problems/travelling-salesman-problem2732/1/*/

class Solution
{
    int n, minCost;
    boolean[] visited;
    public int total_cost(int[][] cost)
    {
        // Code here 
        n = cost.length;
        minCost = Integer.MAX_VALUE;
        visited = new boolean[n];
        
        dfs(cost, 0, 0, 0);
        return minCost;
    }
    public void dfs(int[][] cost, int source, int currCost, int visitCount)
    {
        if (visited[source]) return;
        
        if (visitCount == n-1)
        {
            if (currCost+cost[source][0] < minCost) minCost = currCost+cost[source][0];
            return;
        }
        
        visited[source] = true;
        int adjNode;
        for (adjNode = 0; adjNode < n; ++adjNode)
        {
            if (adjNode == source) continue;
            dfs(cost, adjNode, currCost+cost[source][adjNode], visitCount+1);
        }
        
        visited[source] = false;
    }
}