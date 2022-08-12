/*https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/*/

class Solution {
    Long[][] table;
    public int numWays(int steps, int arrLen) {
        table = new Long[501][251];
        table[steps-1][0] = count(steps,Math.min(251,arrLen),0);
        return table[steps-1][0].intValue();
    }
    private long count(int remSteps, int limit, int index)
    {
        if (index < 0 || index >= limit) return 0;
        
        if (table[remSteps][index] != null) return table[remSteps][index];
        
        if (remSteps == 0) return table[remSteps][index] = index == 0 ? 1l : 0l;
        
        long result = 0;
        
        result = (result+count(remSteps-1,limit,index))%((long)1e9+7); //stay
        result = (result+count(remSteps-1,limit,index-1))%((long)1e9+7); //left
        result = (result+count(remSteps-1,limit,index+1))%((long)1e9+7); //right
        
        return table[remSteps][index] = result%((long)(1e9+7));
    }
}