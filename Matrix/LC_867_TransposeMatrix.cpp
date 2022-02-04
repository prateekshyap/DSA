/*
 	https://leetcode.com/problems/transpose-matrix/
	867. Transpose Matrix
Given a 2D integer array matrix, return the transpose of matrix.

The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.
*/

class Solution {
public:
    vector<vector<int>> transpose(vector<vector<int>>& matrix) {
        int r = matrix.size();
        int c = matrix[0].size();
        
          vector<vector<int>> mat_ans( c , vector<int> (r)); // num of rows = colmuns of original matrix, num of cols = num of rows of original matrix
        
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                mat_ans[j][i]=matrix[i][j];
            }
        }
        return mat_ans;
    }

