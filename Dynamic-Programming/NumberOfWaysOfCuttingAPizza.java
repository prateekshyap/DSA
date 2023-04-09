/*https://leetcode.com/problems/number-of-ways-of-cutting-a-pizza/*/

// 3D recursion and memoization
class Solution {
    private static int M = (int)1e9+7;
    public int ways(String[] pizza, int k) {
        int R = pizza.length, C = pizza[0].length();
        return count(pizza, 0, 0, R-1, C-1, k-1, new Integer[R+1][C+1][k+1]);
    }
    private int count(String[] pizza, int rs, int cs, int re, int ce, int k, Integer[][][] table)
    {
        if (k == 0) // if all cuts are over, check if the last piece has apples
        {
            boolean isApplePresent = false;
            for (int r = rs; r <= re; ++r)
            {
                for (int c = cs; c <= ce; ++c)
                {
                    if (pizza[r].charAt(c) == 'A')
                    {
                        isApplePresent = true;
                        break;
                    }
                }
            }
            if (isApplePresent) return 1; // if apples are present return 1 indicating that this is a successful way of cutting the pizza
            else return 0;
        }
        
        if (table[rs][cs][k] != null) return table[rs][cs][k];
        
        boolean isApplePresent = false; // check if any apple is present in the current piece
        for (int r = rs; r <= re; ++r)
        {
            for (int c = cs; c <= ce; ++c)
            {
                if (pizza[r].charAt(c) == 'A')
                {
                    isApplePresent = true;
                    break;
                }
            }
        }
        if (!isApplePresent) return 0; // if there is no apple present in the current piece, return 0 indicating that this is not the way to cut the pizza
        int cuts = 0;
        int cutR = rs; // this will stop at the row in which the first apple is present for successful horizontal cuts
        while (cutR < re)
        {
            boolean appleStatus = false;
            for (int c = cs; c <= ce; ++c)
            {
                if (pizza[cutR].charAt(c) == 'A')
                {
                    appleStatus = true;
                    break;
                }
            }
            if (appleStatus) break;
            ++cutR;
        }
        
        for (int r = cutR; r < re; ++r) // starting from that row till the end, cut slices and make a recursion call
            cuts = (cuts+count(pizza,r+1,cs,re,ce,k-1,table))%M;
        
        int cutC = cs; // this will stop at the column in which the first apple is present for successful vertical cuts
        while (cutC < ce)
        {
            boolean appleStatus = false;
            for (int r = rs; r <= re; ++r)
            {
                if (pizza[r].charAt(cutC) == 'A')
                {
                    appleStatus = true;
                    break;
                }
            }
            if (appleStatus) break;
            ++cutC;
        }
        
        for (int c = cutC; c < ce; ++c) // starting from that row till the end, cut slices and make a recursion call
            cuts = (cuts+count(pizza,rs,c+1,re,ce,k-1,table))%M;
        
        return table[rs][cs][k] = cuts;
    }
}

// storing apple counts
class Solution {
    private static int M = (int)1e9+7;
    public int ways(String[] pizza, int k) {
        int R = pizza.length, C = pizza[0].length();
        int[][] apples = new int[R+1][C+1];
        for (int r = R-1; r >= 0; --r)
        {
            for (int c = C-1; c >= 0; --c)
            {
                apples[r][c] = (pizza[r].charAt(c) == 'A' ? 1 : 0)+apples[r+1][c]+apples[r][c+1]-apples[r+1][c+1];
            }
        }
        return count(pizza, apples, 0, 0, R-1, C-1, k-1, new Integer[R+1][C+1][k+1]);
    }
    private int count(String[] pizza, int[][] apples, int rs, int cs, int re, int ce, int k, Integer[][][] table)
    {
        if (k == 0)
        {
            if (apples[rs][cs] > 0) return 1;
            else return 0;
        }
        
        if (table[rs][cs][k] != null) return table[rs][cs][k];
        
        if (apples[rs][cs] == 0) return 0;
        
        int cuts = 0;
        
        int cutR = rs;
        while (cutR < re && apples[cutR][cs]-apples[cutR+1][cs] == 0)
            ++cutR;
        
        for (int r = cutR; r < re; ++r)
            cuts = (cuts+count(pizza,apples,r+1,cs,re,ce,k-1,table))%M;
        
        int cutC = cs;
        while (cutC < ce && apples[rs][cutC]-apples[rs][cutC+1] == 0)
            ++cutC;
        
        for (int c = cutC; c < ce; ++c)
            cuts = (cuts+count(pizza,apples,rs,c+1,re,ce,k-1,table))%M;
        
        return table[rs][cs][k] = cuts;
    }
}

// tabulation
class Solution {
    private static int M = (int)1e9+7;
    public int ways(String[] pizza, int k) {
        int R = pizza.length, C = pizza[0].length();
        int[][] apples = new int[R+1][C+1];
        for (int r = R-1; r >= 0; --r)
        {
            for (int c = C-1; c >= 0; --c)
            {
                apples[r][c] = (pizza[r].charAt(c) == 'A' ? 1 : 0)+apples[r+1][c]+apples[r][c+1]-apples[r+1][c+1];
            }
        }
        
        int[][][] table = new int[R][C][k];
        for (int r = 0; r < R; ++r)
        {
            for (int c = 0; c < C; ++c)
            {
                table[r][c][0] = apples[r][c] > 0 ? 1 : 0;
            }
        }
        for (int rem = 1; rem < k; ++rem)
        {
            for (int r = 0; r < R; ++r)
            {
                for (int c = 0; c < C; ++c)
                {
                    for (int nextR = r+1; nextR < R; ++nextR)
                        if (apples[r][c]-apples[nextR][c] > 0)
                            table[r][c][rem] = (table[r][c][rem]+table[nextR][c][rem-1])%M;
                    for (int nextC = c+1; nextC < C; ++nextC)
                        if (apples[r][c]-apples[r][nextC] > 0)
                            table[r][c][rem] = (table[r][c][rem]+table[r][nextC][rem-1])%M;
                }
            }
        }
        return table[0][0][k-1];
    }
}