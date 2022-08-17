/*https://leetcode.com/problems/knight-dialer/*/

class Solution {
    // int[] counts = new int[]{2,2,2,2,3,0,3,2,2,2};
    int[][] adj = {{4,6},{6,8},{7,9},{4,8},{0,3,9},{},{0,1,7},{2,6},{1,3},{2,4}};
    Long[][] table;
    final int m = (int)1e9+7;
    public int knightDialer(int n) {
        long result = 0;
        table = new Long[10][n+1];
        for (int i = 0; i <= 9; ++i)
            result = (result+count(i,n-1))%m;
        return (int)result;
    }
    private long count(int pos, int rem)
    {
        if (rem == 0) return 1;
        
        if (table[pos][rem] != null) return table[pos][rem];
        
        long result = 0;
        for (int adjNode : adj[pos])
            result = (result+count(adjNode,rem-1))%m;
        
        return table[pos][rem] = result;
    }
}