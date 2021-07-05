/*https://practice.geeksforgeeks.org/problems/largest-square-formed-in-a-matrix0806/1*/

//square extension technique
class Solution{
    static int maxSquare(int n, int m, int mat[][]){
        int row = 1, col =1;
        int max = 0;

        //if there is a single 1, then max becomes 1
        for (int j = 0; j < m; ++j)
            if (mat[0][j] == 1)
            {
                max = 1;
                break;
            }
        for (int i = 0; i < n; ++i)
            if (max == 1 || mat[i][0] == 1)
            {
                max = 1;
                break;
            }

        //for each row and column except the first ones
        for (int i = 1; i < n; ++i)
        {
            for (int j = 1; j < m; ++j)
            {
                //get the minimum of rows and columns
                int min = n > m ? n : m;

                //find out the minimum of the 3 adjacent cells who collectively form a square
                min = Math.min(min,Math.min(mat[i-1][j],Math.min(mat[i-1][j-1],mat[i][j-1])));
                
                //store the min value in current cell and add 1 only if current cell is 1 and minimum is not 0
                if (min != 0 && mat[i][j] == 1) mat[i][j] = min+1;

                //update the max
                max = Math.max(max,mat[i][j]);
            }
        }
        return max;
    }
}