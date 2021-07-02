/*https://www.interviewbit.com/problems/prettyprint/*/

public class Solution {
    public int[][] prettyPrint(int A) 
    {
        int n = A*2-1;
        int mat[][] = new int[n][n];
        //int i=0,j=0;
        for(int i=0;i<A;i++)
        {
            for(int j=i;j<A;j++)
            {
                mat[i][j] = A-i;
                mat[j][i] = A-i;
                mat[n-i-1][j] = A-i;
                mat[j][n-i-1] = A-i;
                mat[i][n-j-1] = A-i;
                mat[n-j-1][i] = A-i;
                mat[n-i-1][n-j-1] = A-i;
                mat[n-j-1][n-i-1] = A-i;
            }
        }
        return mat;
    }
}
