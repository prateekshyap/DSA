/*https://practice.geeksforgeeks.org/problems/number-of-paths-in-a-matrix-with-k-coins2728/1*/

class Solution {
    int count;
    Long[][][] store;
    long numberOfPath(int N, int K, int [][]arr) {
        // code here
        count = 0;
        store = new Long[N+1][N+1][K+1];
        store[0][0][0] = dfs(arr,0,0,0,K);
        return store[0][0][0];
    }
    private long dfs(int[][] m, int row, int col, int coins, int K)
    {
        if (row >= m.length || col >= m[0].length || coins > K) return 0;
        if (row == m.length-1 && col == m[0].length-1)
        {
            if (coins+m[row][col] == K) store[row][col][coins+m[row][col]] = (long)1;
            else return 0;
            return store[row][col][coins+m[row][col]];
        }
        if (store[row][col][coins] != null) return store[row][col][coins];
        long count = 0;
        count += dfs(m, row+1, col, coins+m[row][col], K);
        count += dfs(m, row, col+1, coins+m[row][col], K);
        store[row][col][coins] = count;
        return count;
    }
}