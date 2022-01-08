/*https://leetcode.com/problems/search-a-2d-matrix-ii/*/
/*https://practice.geeksforgeeks.org/problems/search-in-a-matrix-1587115621/1*/

//start from top right corner
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = 0, c = matrix[0].length-1;
        while (r >= 0 && c >= 0 && r < matrix.length && c < matrix[0].length)
        {
            if (matrix[r][c] == target)
                return true;
            //if target is less, move left
            else if (target < matrix[r][c])
                --c;
            //if target is greater, move down
            else
                ++r;
        }
        return false;
    }
}

//start from bottom left corner
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length-1, c = 0;
        while (r >= 0 && c >= 0 && r < matrix.length && c < matrix[0].length)
        {
            if (matrix[r][c] == target)
                return true;
            //if target is greater, move right
            else if (target > matrix[r][c])
                ++c;
            //if target is less, move up
            else
                --r;
        }
        return false;
    }
}