/*https://leetcode.com/problems/min-cost-to-connect-all-points/*/

//prim's algorithm
class Solution {
    static int getMinKeyVertex(int[] key, boolean[] mstSet, int V)
    {
        int minKey = Integer.MAX_VALUE, index = -1;
        for (int i = 0; i < V; i++)
        {
            if (!mstSet[i] && key[i] < minKey)
            {
                minKey = key[i];
                index = i;
            }
        }
        return index;
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length, i, j;

        //convert the points and their distances to graph
        int[][] graph = new int[n][n];
        for (i = 0; i < n; ++i)
        {
            for (j = 0; j < n; ++j)
            {
                graph[i][j] = Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
            }
        }
        
        int result = 0;
        int[] parent = new int[n]; //stores mst
        int[] key = new int[n]; //stores key values for each vertex
        boolean[] mstSet = new boolean[n]; //keeps track of the vertices added to the mst
        
        //initializing all keys to inifinite except 0
        for (i = 1; i < n; ++i)
            key[i] = Integer.MAX_VALUE;

        parent[0] = -1; //0th vertex included to the mst
        int minKeyVertex, count;

        //for all vertices
        for (count = 1; count < n; ++count)
        {
            minKeyVertex = getMinKeyVertex(key,mstSet,n);//find the minimum key which is not added to the mst yet
            mstSet[minKeyVertex] = true; //add it to the mst

            //for all the edges from the adjacent vertex
            for (i = 0; i < n; ++i)
            {
            	//if it is not added to the mst and edge weight is smaller than the current key
                if (i != minKeyVertex && !mstSet[i] && graph[i][minKeyVertex] < key[i])
                {
                	//update the value and the parent
                    parent[i] = minKeyVertex;
                    key[i] = graph[i][minKeyVertex];
                }
            }
        }

        //add all the values and return
        for (i = 0; i < key.length; ++i)
            result += key[i];
        return result;
    }
}