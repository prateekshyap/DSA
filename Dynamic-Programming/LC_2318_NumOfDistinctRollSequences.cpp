/*
https://leetcode.com/problems/number-of-distinct-roll-sequences/
2318. Number of Distinct Roll Sequences

*/

class Solution {
public:
    int N;
    const int MOD = 1e9+7;
    
    int distinctSequences(int n) {
        if (n == 1)
            return 6;
        if (n == 2)
            return 22;
        
        N=n;
        vector<vector<vector<int>>> dp(n,vector<vector<int>>(7,vector<int>(7,-1)));
        return doRoll(0, 0, 0, dp);
    }
    
    int doRoll(int idx, int last, int seclast, vector<vector<vector<int>>>& dp)
    {
        if(idx  == N)
            return 1; // one valid sequence
        
        if(dp[idx][last][seclast] != -1)
            return dp[idx][last][seclast];
        
        int cnt=0;
        
        for(int dv=1; dv<=6; dv++) //dice value
        {
            if(dv != last && dv != seclast && (last == 0 || __gcd(dv, last)==1))
            {
                cnt = (cnt+doRoll(idx+1, dv, last, dp))%MOD;
            }
        }
        return dp[idx][last][seclast] = cnt;
    }
    
};