/*
https://leetcode.com/problems/coin-change/
322. Coin Change

https://practice.geeksforgeeks.org/problems/number-of-coins1824/1
https://practice.geeksforgeeks.org/problems/coin-change2448/1/
*/

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        
        if(amount == 0)
            return 0;
        // return coinChangeRec(coins, amount);
        
        vector<int> dp(amount+1, 1e9);
        dp[0] = 0;
        
        // for(int amt=1; amt<=amount; amt++)
        // {
        //     for(int c=0; c<coins.size(); c++)
        //     {
        //         if( coins[c] <= amt)
        //         {
        //             if(dp[amt-coins[c]]!=1e9)
        //             dp[amt] = min(dp[amt], 1+dp[amt-coins[c]]);
        //         }
        //     }
        // }
        
        for(int cv: coins)
        {
            for(int amt=cv; amt<=amount; amt++)
            {
                dp[amt] = min(dp[amt], 1+dp[amt-cv]);
            }
        }
        
        return dp[amount] == 1e9 ? -1: dp[amount];
    }//end
    
    /*
     int coinChangeRec(vector<int>& coins, int amount) {
        
        if(amount == 0)
            return 0;
        vector<vector<int>> memo(coins.size()+1, vector<int>(amount+1, -1));
        int ans = solve(coins.size(), amount, coins, memo);
        return ans == INT_MAX-1 ? -1 : ans;
        
    }//end
    
    int solve(int idx, int amt, vector<int> &coins, vector<vector<int>>& memo)
    {
        if(amt == 0)
            return 0;
        
        if(idx == 0)
            return INT_MAX-1;
        
        if(memo[idx][amt] != -1)
            return memo[idx][amt];
        
        if(coins[idx-1] > amt)
            return memo[idx][amt] = solve(idx-1, amt, coins, memo);
        else
            return memo[idx][amt] = min(solve(idx-1, amt, coins, memo), solve(idx, amt-coins[idx-1], coins, memo)+1);
    }
    */
};