/* https://leetcode.com/problems/search-a-2d-matrix-ii/
https://practice.geeksforgeeks.org/problems/search-in-a-matrix-1587115621/1#

Write an efficient algorithm that searches for a target value in an m x n integer matrix. The matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
 */
 class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int r = matrix.size();
        int c = matrix[0].size();
        
        
        int smallest_ele = matrix[0][0];
        int largest_ele = matrix[r-1][c-1];
        
        if( target < smallest_ele || target > largest_ele) return false;
        
        // From Top Most Corner
//         int i=0;
//         int j = c-1; // top right most element
//         while(i<r && j>=0)
//         {
//             if(target == matrix[i][j]) return true;
//             if(target < matrix[i][j] )
//                 j--; //move left;
//             else
//                 i++; // move down
//         }
        
//         return false;   
        
        
        // From Bottom left corner
        int i=r-1;
        int j =0; // top right most element
        while(i>=0 && j<c)
        {
            if(target == matrix[i][j]) return true;
            if(target > matrix[i][j] )
                j++; //move right;
            else
                i--; // move up
        }
        
        return false;   
    }
};
