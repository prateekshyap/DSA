/* https://leetcode.com/problems/search-a-2d-matrix/
 * 74. Search a 2D Matrix
 Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
 */
 
 class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        
        int r = matrix.size();
        int c = matrix[0].size();
        
        /*
        int smallest_ele = matrix[0][0];
        int largest_ele = matrix[r-1][c-1];
        
        if(target == matrix[0][0] ) return true;
        if( target < smallest_ele || target > largest_ele) return false;
        
        int i=0;
        int j = c-1; // top right most element
        while(i<r && j>=0)
        {
            if(target == matrix[i][j]) return true;
            else if(target > matrix[i][j])
                i++;
            else
                j--;
        }
        
        return false;   
        */
        /****** A2: iterative Binary Search *******/
        int l=0;
        int h=r*c-1;
        while(l <= h){
            int mid = (l)+(h-l)/2;
            
            if(target == matrix[mid/c][mid%c]) return true;
            else if(target < matrix[mid/c][mid%c])
                h=mid-1;
            else
                l=mid+1;
                
        }
              return false;     
    }// end
};
