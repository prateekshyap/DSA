/*https://leetcode.com/problems/where-will-the-ball-fall/*/

class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int i = 0, j = 0, index, left, right;
        int[] result = new int[n];
        for (index = 0; index < n; ++index) //for each ball
        {
            j = index; //set the current column of the ball as index
            i = 0; //set the current row as 0
            while (i < m) //till we have finished the board
            {
            	/*   (i,j) (i,j+1)
					|\    |\    |
					|  \  |  \  |
					|____\|____\|
            	*/
                if (grid[i][j] == 1) //if the current cell moves the ball to the right
                {
                    left = grid[i][j]; //current cell will be the left boundary
                    right = j+1 < n ? grid[i][j+1] : 0; //right next cell will be the right boundary
                }
                /*  (i,j-1) (i,j)
					|    /|    /|
					|  /  |  /  |
					|/____|/____|
            	*/
                else //if the current cell moves the ball to the left
                {
                    left = j-1 >= 0 ? grid[i][j-1] : 0; //left next cell will be the left boundary
                    right = grid[i][j]; //current cell will be the right boundary
                }
                /*  l  r
					|    /|
					|  /  |
					|/____|
					
					or
					   l  r
					|\    |
					|  \  |
					|____\|
                */
                if (left == 0 || right == 0) break; //if any of them is a wall, ball cannot move further
                /*
					|\    |    /|
					|  \  |  /  |
					|____\|/____|  this is the case

					|    /|\    |
					|  /  |  \  |
					|/____|____\|  case cannot happen because we are deciding left and right such a way
                */
                if (left != right) break; //if both are not equal, ball cannot move further
                j += left; //column changes according to the direction of the current cell
                ++i; //increment the row
            }
            //if we have reached after the last row, store the current column value otherwise store -1
            if (i == m) result[index] = j; else result[index] = -1;
        }
        return result;
    }
}

class Solution {
    public int dfs(int[][] grid, int i, int j){
        if(i == grid.length) {
            return j;
        }
        
        if(j < 0 || j >= grid[0].length) {
            return -1;
        }
            
        if(grid[i][j] == 1 && j+1 < grid[0].length && grid[i][j+1] == 1) {
            return dfs(grid, i+1, j+1);
        } else if(grid[i][j] == -1 && j-1 >= 0 && grid[i][j-1] == -1) {
            return dfs(grid, i+1, j-1);
        }
            
        return -1;
    }
    
    public int[] findBall(int[][] grid) {
        int m = grid[0].length;
        int[] ar = new int[m];
        
        for(int j=0;j<m;j++) {
            ar[j] = dfs(grid,0,j);
        }
        
        return ar;
    }
}