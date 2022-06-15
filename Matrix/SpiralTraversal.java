/*https://leetcode.com/problems/spiral-matrix/*/
/*https://practice.geeksforgeeks.org/problems/spirally-traversing-a-matrix-1587115621/1*/
/*https://binarysearch.com/problems/Spiral-Matrix*/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0, bottom = matrix.length-1, left = 0, right = matrix[0].length-1;
        List<Integer> l = new ArrayList<Integer>();
        int i = 0, j = 0;

        //till we have more elements
        while (top <= bottom && left <= right)
        {
        	//add the top row
            for (j = left; j <= right; ++j)
            {
                if (matrix[i][j] != -1000)
                {
                    l.add(matrix[i][j]);
                    matrix[i][j] = -1000;
                }
            }

            //delete top row
            ++top; --j;

            //add right column
            for (i = top; i <= bottom; ++i)
            {
                if (matrix[i][j] != -1000)
                {
                    l.add(matrix[i][j]);
                    matrix[i][j] = -1000;
                }
            }

            //delete right column
            --right; --i;

            //add bottom row
            for (j = right; j >= left; --j)
            {
                if (matrix[i][j] != -1000)
                {
                    l.add(matrix[i][j]);
                    matrix[i][j] = -1000;
                }
            }

            //delete bottom row
            --bottom; ++j;

            //add left column
            for (i = bottom; i >= top; --i)
            {
                if (matrix[i][j] != -1000)
                {
                    l.add(matrix[i][j]);
                    matrix[i][j] = -1000;
                }
            }

            //delete left column
            ++left; ++i;
        }
        return l;
    }
}

import java.util.*;

class Solution {
    public int[] solve(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        if (matrix.length == 1 && matrix[0].length == 0) return new int[0];
        int top = 0, bottom = matrix.length-1, left = 0, right = matrix[0].length-1;
        int i = 0, j = 0, len = (bottom+1)*(right+1);
        int index = 0;
        int[] result = new int[len];
        while (top <= bottom && left <= right)
        {
            //top row (from column start to column end)
            for (j = left; j <= right; ++j) result[index++] = matrix[top][j];
            if (index >= len) break;
            ++top; //delete top row

            //rightmost column (from row start to row end)
            for (i = top; i <= bottom; ++i) result[index++] = matrix[i][right];
            if (index >= len) break;
            --right; //delete rightmost column

            //bottom row (from column end to column start)
            for (j = right; j >= left; --j) result[index++] = matrix[bottom][j];
            if (index >= len) break;
            --bottom; //delete bottom row

            //leftmost column (from row end to row start)
            for (i = bottom; i >= top; --i) result[index++] = matrix[i][left];
            if (index >= len) break;
            ++left; //delete leftmost column
        }
        return result;
    }
}