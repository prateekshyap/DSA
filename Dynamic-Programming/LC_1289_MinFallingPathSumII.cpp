/*
https://binarysearch.com/problems/Minimum-Dropping-Path-Sum

https://leetcode.com/problems/minimum-falling-path-sum-ii/
1289. Minimum Falling Path Sum II


*/

class Solution {
public:
    int minFallingPathSum_1(vector<vector<int>>& grid) {
        int rows = grid.size();
        int cols = grid[0].size();
        
        int minPath = INT_MAX;
        
        for(int i=1; i<rows; i++)
        {
            
            for(int j=0; j<cols; j++)
            {
                int curmin = INT_MAX;
                for(int k=0; k<cols; k++)
                {
                    if(j!=k)
                        curmin = min(curmin, grid[i-1][k]);
                }
                grid[i][j] = curmin + grid[i][j];
            }
        }
        
        for(int i=0; i<cols; i++)
            minPath = min(minPath, grid[rows-1][i]);
        
        return minPath;
    }
    
    int minFallingPathSum(vector<vector<int>>& grid) {
        int rows = grid.size();
        int cols = grid[0].size();

        int min1 = INT_MAX;
        int min2 = INT_MAX;

        for(int j=0; j<cols; j++)
        {
            if(grid[0][j] <= min1)
            {
                min2 = min1;
                min1 = grid[0][j];
            }
            else if(grid[0][j] < min2)
                min2 = grid[0][j];
        }
        // cout<<min1<<" "<<min2<<endl;
        for(int i=1; i<rows; i++)
        {
        int newmin1 = INT_MAX;
        int newmin2 = INT_MAX;

        for(int j=0; j<cols; j++)
        {
                if(grid[i-1][j] == min1)
                    grid[i][j] += min2;
                else
                    grid[i][j] += min1;

                if(grid[i][j] <= newmin1)
                {
                    newmin2 = newmin1;
                    newmin1 = grid[i][j];
                }
                else if(grid[i][j] < newmin2)
                    newmin2 = grid[i][j];
                // cout<<matrix[i][j]<<" ";
            }// for j
            // cout<<endl;
            min1 = newmin1;
            min2 = newmin2;
            // cout<<min1<<" "<<min2<<endl;
        }//for i

        int minsum = INT_MAX;
        for(int i=0; i<cols; i++)
            minsum = min(minsum, grid[rows-1][i]);

        return minsum;
    }
};

//Binary Search -----------------------------------------------------
int solve(vector<vector<int>>& matrix) {
    int rows = matrix.size();
    int cols = matrix[0].size();

    int min1 = INT_MAX;
    int min2 = INT_MAX;

    for(int j=0; j<cols; j++)
    {
        if(matrix[0][j] <= min1)
        {
            min2 = min1;
            min1 = matrix[0][j];
        }
        else if(matrix[0][j] < min2)
            min2 = matrix[0][j];
    }
    // cout<<min1<<" "<<min2<<endl;
    for(int i=1; i<rows; i++)
    {
        int newmin1 = INT_MAX;
        int newmin2 = INT_MAX;

        for(int j=0; j<cols; j++)
        {
            if(matrix[i-1][j] == min1)
                matrix[i][j] += min2;
            else
                matrix[i][j] += min1;

            if(matrix[i][j] <= newmin1)
            {
                newmin2 = newmin1;
                newmin1 = matrix[i][j];
            }
            else if(matrix[i][j] < newmin2)
                newmin2 = matrix[i][j];
            // cout<<matrix[i][j]<<" ";
        }// for j
        // cout<<endl;
        min1 = newmin1;
        min2 = newmin2;
        // cout<<min1<<" "<<min2<<endl;
    }//for i

    int minsum = INT_MAX;
    for(int i=0; i<cols; i++)
        minsum = min(minsum, matrix[rows-1][i]);
    
    return minsum;
}