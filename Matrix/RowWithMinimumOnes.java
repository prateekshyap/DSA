/*https://practice.geeksforgeeks.org/problems/row-with-minimum-number-of-1s5430/1*/

class Solution {
    int minRow(int N, int M, int A[][]) {
        // code here
        int maxOnes = Integer.MAX_VALUE, maxRow = -1;
        for (int i = 0; i < N; ++i)
        {
            int ones = 0;
            for (int j = 0; j < M; ++j)
                if (A[i][j] == 1) ++ones;
            if (ones < maxOnes)
            {
                maxOnes = ones;
                maxRow = i+1;
            }
        }
        return maxRow;
    }
}