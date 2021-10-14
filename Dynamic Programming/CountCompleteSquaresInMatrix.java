/*https://leetcode.com/problems/count-square-submatrices-with-all-ones/*/

/*Prateekshya*/

class Solution {
    public int countSquares(int[][] matrix) {
        int result = 0;

        //add single 1's
        for (int i = 0; i < matrix.length; ++i)
            for (int j = 0; j < matrix[0].length; ++j)
                result += matrix[i][j];

        //for bigger squares
        for (int i = 1; i < matrix.length; ++i)
        {
            for (int j = 1; j < matrix[0].length; ++j)
            {
            	//get the minimum out of the three previous squares
                int min = Math.min(matrix[i-1][j],Math.min(matrix[i][j-1],matrix[i-1][j-1]));
                
                //if the current square is not 0
                if (matrix[i][j] != 0)
                {
                	//store min+1 in current square
                    matrix[i][j] = min+1;

                    //if minimum is not 0, then add it to the result
                    if (min != 0) result += min;
                }
            }
        }
        
        return result;
    }
}