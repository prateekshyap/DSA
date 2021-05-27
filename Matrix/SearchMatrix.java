/*https://leetcode.com/problems/search-a-2d-matrix/*/

//a modified binary search
class Solution {
    int col;
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0, high = (matrix.length*matrix[0].length)-1;
        col = matrix[0].length;
        return binarySearch(matrix,low,high,target);
    }
    public boolean binarySearch(int[][] matrix, int low, int high, int tgt) {
        if (low > high) return false;
        int mid = (low+high)/2;
        int r = mid/col;
        int c = mid%col;
        if (matrix[r][c] == tgt)
            return true;
        else if (tgt < matrix[r][c])
            return binarySearch(matrix,low,mid-1,tgt);
        else
            return binarySearch(matrix,mid+1,high,tgt);
    }
}