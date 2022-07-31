/*https://leetcode.com/problems/unique-paths-ii/*/

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] ways = new int[2][n];
        int row, col, index = 0;
        for (col = 0; col < n; ++col)
        {
            if (obstacleGrid[0][col] == 1) break; //if obstacle, we can't move further in that row
            ways[0][col] = 1;
        }
        for (row = 1; row < m; ++row) //for all next rows
        {
            /*
            if there is an obstacle in the first column or we can't reach the first column of the
            previous row, then we can't reach the first column of the current row
            */
            ways[1-index][0] = obstacleGrid[row][0] == 1 || ways[index][0] == 0 ? 0 : 1;
            for (col = 1; col < n; ++col) //for rest of the columns
            {
                if (obstacleGrid[row][col] == 1) //if obstacle
                    ways[1-index][col] = 0; //store 0
                else //otherwise
                    ways[1-index][col] = ways[index][col]+ways[1-index][col-1]; //count
            }
            index = 1-index;
        }
        return ways[index][n-1];
    }
}

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) return 0;
        int row = 0, col = 0;
        for (row = 0; row < m; ++row)
            for (col = 0; col < n; ++col)
                if (obstacleGrid[row][col] == 1)
                    obstacleGrid[row][col] = -1;
        for (col = 0; col < n; ++col)
        {
            if (obstacleGrid[0][col] == -1) break;
            obstacleGrid[0][col] = 1;
        }
        for (row = 1; row < m; ++row)
        {
            if (obstacleGrid[row][0] != -1 && obstacleGrid[row-1][0] != -1 && obstacleGrid[row-1][0] != 0) obstacleGrid[row][0] = 1;
            for (col = 1; col < n; ++col)
            {
                if (obstacleGrid[row][col] != -1)
                    obstacleGrid[row][col] = (obstacleGrid[row][col-1] == -1 ? 0 : obstacleGrid[row][col-1])+(obstacleGrid[row-1][col] == -1 ? 0 : obstacleGrid[row-1][col]);
            }
        }
        
        return obstacleGrid[m-1][n-1];
    }
}

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

/*Pratik's solution*/

import java.io.*;

class NumberOfPathsObstacle
{
    public static void main(String pp[])throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter number of rows : ");
        int rows = Integer.parseInt(br.readLine());
        System.out.print("Enter numer of columns : ");
        int cols = Integer.parseInt(br.readLine());
        int[][] arr = new int[rows][cols];
        System.out.print("Enter number of obstacles : ");
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter cell id(row,col) where you want to add obstacles : ");
            int m = Integer.parseInt(br.readLine());
            while(m>=rows || m<0)
            {
                System.out.println("Enter a number less than number of rows i.e. <"+rows+" as well as the value should be >=0" );
                m = Integer.parseInt(br.readLine());
            }
            int p = Integer.parseInt(br.readLine());
            while(p>=cols || p<0)
            {
                System.out.println("Enter a number less than number of columns i.e. <"+cols+" as well as the value should be >=0" );
                p = Integer.parseInt(br.readLine());
            }
            arr[m][p] = 1;
        }
        Solution s = new Solution();
        System.out.println("Number of ways to move from top left corner to bottom right corner is "+s.uniquePathsWithObstacles(arr));
    }
}
class Solution {
    public int uniquePathsWithObstacles(int[][] arr) 
    {
        int rows = arr.length;
        int cols = arr[0].length;
        if(arr[rows-1][cols-1]==1 || arr[0][0]==1)return 0;
        int dp[][] = new int[rows][cols];
        dp[rows-1][cols-1] = 0;
        dp[0][0] = 1;
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(arr[i][j]==0 && i+1<rows)dp[i+1][j]+=dp[i][j];
                if(arr[i][j]==0 && j+1<cols)dp[i][j+1]+=dp[i][j];
            }
        }
        return dp[rows-1][cols-1];
    }
}