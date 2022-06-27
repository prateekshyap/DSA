/*https://practice.geeksforgeeks.org/problems/minimum-cost-path3833/1*/

class Data implements Comparable<Data>
{
    int i;
    int j;
    int cost;
    Data(int i, int j, int cost)
    {
        this.i = i;
        this.j = j;
        this.cost = cost;
    }
    public int compareTo(Data d)
    {
        return this.cost-d.cost;
    }
}
class Solution
{
    //Function to return the minimum cost to react at bottom
	//right cell from top left cell.
    public int minimumCostPath(int[][] grid)
    {
        // Code here
        //dijkstra algo
        Data first = new Data(0,0,grid[0][0]);
        PriorityQueue<Data> pq = new PriorityQueue<>();
        pq.add(first);
        int n = grid.length, i, j, k, x, y, cost;
        int arr[][] = {{1,0},{-1,0},{0,1},{0,-1}};
        boolean visited[][] = new boolean[n][n];
        while (!pq.isEmpty())
        {
            Data pop = pq.poll();
            i = pop.i;
            j = pop.j;
            cost = pop.cost;
            if (visited[i][j]) continue;
            if (i == n-1 && j == n-1) return cost;
            visited[i][j] = true;
            for (k = 0; k < 4; ++k)
            {
                x = i+arr[k][0];
                y = j+arr[k][1];
                if (x >= 0 && x < n && y >= 0 && y < n)
                {
                    Data d = new Data(x,y,cost+grid[x][y]);
                    pq.add(d);
                }
            }
        }
        return -1;
    }
}