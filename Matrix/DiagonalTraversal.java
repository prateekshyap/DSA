/*https://practice.geeksforgeeks.org/problems/print-matrix-in-diagonal-pattern/1*/

class Solution {
    public int[] matrixDiagonally(int[][] matrix) {
        // Code here
        int[] result = new int[matrix.length*matrix[0].length];
        int index = 0, n = matrix.length, m = matrix[0].length;
        
        //initialize variables to the top left element
        int rStart = 0, cStart = 0, rEnd = 0, cEnd = 0;
        boolean dir = false;

        //till we reach the topright corner
        while (rStart != n-1 || cStart != m-1)
        {
            //from start to end, add to the list
            if (dir)
                for (int i = rStart, j = cStart; i <= rEnd && j >= cEnd; ++i, --j)
                    result[index++] = matrix[i][j];
            else
                for (int i = rEnd, j = cEnd; i >= rStart && j <= cStart; --i, ++j)
                    result[index++] = matrix[i][j];

            dir = !dir;

            //move downwards after reaching top right corner
            if (cStart != m-1)
                ++cStart;
            else
                ++rStart;

            //move right after reacing bottom left corner
            if (rEnd != n-1)
                ++rEnd;
            else
                ++cEnd;
        }
        result[index] = matrix[n-1][m-1];
        return result;
    }
}