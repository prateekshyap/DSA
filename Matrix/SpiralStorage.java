/*https://leetcode.com/problems/spiral-matrix-ii/*/

class Solution
{
    public int[][] generateMatrix(int n)
    {
        int[][] matrix = new int[n][n];
        int rs = 0, re = n-1, cs = 0, ce = n-1;
        int element = 1;
        int i = 0, j = 0;

        //till we have more elements
        while (rs <= re && cs <= ce)
        {
        	//add the top row
            for (j = cs; j <= ce; ++j)
                if (matrix[i][j] == 0)
                    matrix[i][j] = element++;

            //delete top row
            ++rs; --j;

            //add right column
            for (i = rs; i <= re; ++i)
                if (matrix[i][j] == 0)
                    matrix[i][j] = element++;

            //delete right column
            --ce; --i;

            //add bottom row
            for (j = ce; j >= cs; --j)
                if (matrix[i][j] == 0)
                    matrix[i][j] = element++;

            //delete bottom row
            --re; ++j;

            //add left column
            for (i = re; i >= rs; --i)
                if (matrix[i][j] == 0)
                    matrix[i][j] = element++;

            //delete left column
            ++cs; ++i;
        }
        return matrix;
    }
}