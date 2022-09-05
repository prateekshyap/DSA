/*https://leetcode.com/problems/number-of-ways-to-reach-a-position-after-exactly-k-steps/*/

class Solution {
    static final int M = (int)1e9+7;
    int offset = 1000;
    Integer[][] table;
    public int numberOfWays(int startPos, int endPos, int k) {
        table = new Integer[4001][k+1];
        table[startPos+offset][k] = countWays(startPos,endPos,k);
        return table[startPos+offset][k];
    }
    private int countWays(int pos, int end, int rem)
    {
        if (rem == 0)
        {
            if (pos == end) return table[pos+offset][rem] = 1;
            else return table[pos+offset][rem] = 0;
        }
        int index = pos+offset;
        if (table[index][rem] != null) return table[index][rem];
        int result = 0;
        
        result = (result+countWays(pos+1,end,rem-1))%M;
        result = (result+countWays(pos-1,end,rem-1))%M;
        
        return table[index][rem] = result;
    }
}