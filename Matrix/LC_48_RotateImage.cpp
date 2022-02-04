/* https://leetcode.com/problems/rotate-image/
 * 48. Rotate Image
 You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 */
 
 class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        int r = matrix.size();
        int c = matrix[0].size();
        
        if(r==1)return;
    /***** APPROACH 1 ********/
        // Transpose the given matrix and then flip vertically
        // Transposing
        // for(int i=0; i<r; i++)
        // {
        //     for(int j=i+1; j<c; j++)
        //     {
        //         swap(matrix[j][i], matrix[i][j]);
        //     }
        // }
        
        //Flipping
        // for(int i=0; i<r; i++)
        // {
        //     for(int j=0; j<c/2; j++)
        //     {
        //        swap(matrix[i][j], matrix[i][c-1-j]);
        //     }
        // }
 /***** APPROACH 2 ********/
    //   Divide matrix into square cycles (n/2) r=c=n
        int n=r;
        for(int i=0; i<n/2; i++) //for each square cycles
        {
            for(int j=i; j<n-1-i; j++) // for each element in sq cycles
            {
                int temp = matrix[i][j];  // first ele
                matrix[i][j] = matrix[n-1-j][i]; 
                 matrix[n-1-j][i] =  matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                 matrix[j][n-1-i] = temp;
            }
        }
        
        
    }//end
};
