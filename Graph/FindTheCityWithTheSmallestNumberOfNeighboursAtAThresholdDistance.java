/*https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/*/

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] matrix = new int[n][n];
        int i, j, k, city = -1, minCount = Integer.MAX_VALUE, thresholdCount;
        for (int[] edge : edges) matrix[edge[0]][edge[1]] = matrix[edge[1]][edge[0]] = edge[2];
        
        //floyd warshall all pair shortest path
        for (k = 0; k < n; ++k)
            for (i = 0; i < n; ++i)
                for (j = 0; j < n; ++j)
                {
                    if (i == j || matrix[i][k] == 0 || matrix[k][j] == 0) continue;
                    matrix[i][j] = matrix[i][j] == 0 ? matrix[i][k]+matrix[k][j] : Math.min(matrix[i][j],matrix[i][k]+matrix[k][j]); 
                }
        
        for (i = 0; i < n; ++i)
        {
            thresholdCount = 0;
            for (j = 0; j < n; ++j)
            {
                if (i == j) continue;
                if (matrix[i][j] <= distanceThreshold) ++thresholdCount;
            }
            if (thresholdCount < minCount)
            {
                minCount = thresholdCount;
                city = i;
            }
            else if (thresholdCount == minCount)
                city = i;
        }
        return city;
    }
}