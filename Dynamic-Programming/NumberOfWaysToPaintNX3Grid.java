/*https://leetcode.com/problems/number-of-ways-to-paint-n-3-grid/*/

class Solution {
    int n;
    Integer[][][][] board;
    public int numOfWays(int n) {
        this.n = n;
        board = new Integer[n][4][4][4];
        return count(0,0,0,0);
    }
    private int count(int index, int color1, int color2, int color3)
    {
        if (index == n) return 1;
        
        if (board[index][color1][color2][color3] != null) return board[index][color1][color2][color3];
        
        int c1, c2, c3, result = 0;
        for (c1 = 1; c1 <= 3; ++c1)
        {
            if (c1 != color1)
            {
                for (c2 = 1; c2 <= 3; ++c2)
                {
                    if (c2 != color2 && c2 != c1)
                    {
                        for (c3 = 1; c3 <= 3; ++c3)
                        {
                            if (c3 != color3 && c3 != c2)
                            {
                                result = (result+count(index+1,c1,c2,c3))%((int)1e9+7);
                            }
                        }
                    }
                }
            }
        }
        
        return board[index][color1][color2][color3] = result;
    }
}

class Solution {
    public int numOfWays(int n) {
        long a121 = 6, a123 = 6, b121, b123, mod = (long)1e9 + 7;
        for (int i = 1; i < n; ++i) {
            b121 = a121 * 3 + a123 * 2;
            b123 = a121 * 2 + a123 * 2;
            a121 = b121 % mod;
            a123 = b123 % mod;
        }
        return (int)((a121 + a123) % mod);
    }
}