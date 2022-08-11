/*https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/*/

class Solution {
    final int m = (int)1e9+7;
    Long[][] table;
    public int numRollsToTarget(int n, int k, int target) {
        table = new Long[n+1][target+1];
        table[n][target] = count(n, k, target);
        return table[n][target].intValue();
    }
    private long count(int rem, int faces, int target)
    {
        if (target < 0) return 0;
        
        if (table[rem][target] != null) return table[rem][target];
        
        if (rem == 0 && target == 0) return table[rem][target] = 1l;
        if (rem == 0 || target == 0) return table[rem][target] = 0l;
        
        long result = 0;
        for (int i = 1; i <= faces; ++i)
            result = (result+count(rem-1,faces,target-i))%m;
        
        return table[rem][target] = result;
    }
}