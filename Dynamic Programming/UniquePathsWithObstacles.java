/*https://leetcode.com/problems/unique-paths-ii/*/

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        //store -1 in place of obstacles
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                obstacleGrid[i][j] *= -1;

        //store 1 in the goal cell if there is no obstacle
        obstacleGrid[m-1][n-1] = obstacleGrid[m-1][n-1] == -1 ? -1 : 1;

        /*
        Approach is same as the normal unique paths problem
        The only twist is, if we get an obstacle at some cell in the last column
        We cannot move down from the cells on its top
        Hence all of them become dead ends 
        Similarly if there is an obstacle in the last row, 
        we cannot cross the obstacle and they also become dead ends
        */
        for (int i = m-2; i >= 0; --i)
            obstacleGrid[i][n-1] = obstacleGrid[i][n-1] == -1 ? -1 : (obstacleGrid[i+1][n-1] == -1 ? -1 : 1);
        for (int i = n-2; i >= 0; --i)
            obstacleGrid[m-1][i] = obstacleGrid[m-1][i] == -1 ? -1 : (obstacleGrid[m-1][i+1] == -1 ? -1 : 1);
        


        for (int i = m-2; i >= 0; --i)
            for (int j = n-2; j >= 0; --j)
            {
                //if the cell itself is an obstacle, we need not check anything
                if (obstacleGrid[i][j] == -1) continue;
                /*
                If there are obstacles below the cell and right of the cell
                That is also a dead end
                So we store an obstacle there
                */
                if (obstacleGrid[i+1][j] == -1 && obstacleGrid[i][j+1] == -1)
                    obstacleGrid[i][j] = -1;
                /*
                If we have obstacle in one direction
                We add the other cell only
                */
                else if (obstacleGrid[i+1][j] == -1)
                    obstacleGrid[i][j] = obstacleGrid[i][j+1];
                else if (obstacleGrid[i][j+1] == -1)
                    obstacleGrid[i][j] = obstacleGrid[i+1][j];
                //normal case
                else
                    obstacleGrid[i][j] = obstacleGrid[i+1][j]+obstacleGrid[i][j+1];
            }
        return obstacleGrid[0][0] == -1 ? 0 : obstacleGrid[0][0];
    }
}
