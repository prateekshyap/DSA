/*https://leetcode.com/problems/dice-roll-simulation/*/

class Solution {
    public int[] rollMax;
    Long[][][] store;
    static final int m = (int)1e9+7;
    public int dieSimulator(int n, int[] rollMax) {
        this.rollMax = rollMax;
        int max = 0;
        for (int i = 0; i < 6; ++i)
            max = Math.max(max,rollMax[i]);
        long result = 0;
        store = new Long[n+1][7][max+1];
        for (int i = 1; i <= 6; ++i)
            result = (result+count(n-1,i,1))%m;
        return (int)result;
    }
    private long count(int rem, int curr, int streak)
    {
        if (rem == 0) return 1;
        
        if (store[rem][curr][streak] != null) return store[rem][curr][streak];
        
        long result = 0;
        
        for (int i = 1; i <= 6; ++i)
        {
            if (i == curr)
            {
                if (streak == rollMax[i-1]) continue;
                else result += count(rem-1,i,streak+1);
            }
            else
                result += count(rem-1,i,1);
        }
        
        return store[rem][curr][streak] = result%m;
    }
}