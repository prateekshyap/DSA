/* https://leetcode.com/problems/count-square-submatrices-with-all-ones/
 * Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
 */
class Solution {
public:
    int countSquares(vector<vector<int>>& mat) {

        int m = mat.size();
        int n = mat[0].size();

        int sum_sq = 0;

        for(int i = 0; i<m; i++){
            for(int j =0; j<n; j++){

                if(i>0 && j>0 && mat[i][j]>0){
                    int min_rowi_1 = min(mat[i-1][j], mat[i-1][j-1]);
                    int min_val_ij = min(min_rowi_1, mat[i][j-1]);
                    mat[i][j] = min_val_ij+1;
                }
                sum_sq = sum_sq + mat[i][j];

            }//for j
        }//for i

        return sum_sq;
    }
};