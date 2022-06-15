/*
https://leetcode.com/problems/search-a-2d-matrix-ii/
https://practice.geeksforgeeks.org/problems/search-in-a-matrix-1587115621/1#
*/
class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        
        int r = matrix.size();
        int c = matrix[0].size();
        
        // /*
        int smallest_ele = matrix[0][0];
        int largest_ele = matrix[r-1][c-1];
        
        if(target == matrix[0][0] ) return true;
        if( target < smallest_ele || target > largest_ele) return false;
        
        // /*
        //start from top right corner
        int i=0, k=0;
        int j = c-1; // top right most element
        while(i<r && j>=0)
        {
            k=matrix[i][j];
            if(target == k) return true;
            else if(target < k)
                j--; // if target is less, move right
            else
                i++;
        }
        // */
        
        /*
        //start from bottom left corner
        int i=r-1;
        int j = 0; // top right most element
        while(i>=0 && j<c)
        {
            if(target == matrix[i][j]) return true;
            else if(target < matrix[i][j])
                i--; // if target is less, move right
            else
                j++;
        }
        */
        
        return false;    
        // */
    }//end
};