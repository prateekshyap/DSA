/*
518. Coin Change 2

https://leetcode.com/problems/coin-change-2/
*/

class Solution {
public:
    vector<vector<int>> memo;
    int change(int amount, vector<int>& coins) {
        if(amount == 0) return 1;
        // memo.resize(coins.size()+1, vector<int>(amount+1, -1));
        // return solve(0, amount, coins);
        
        vector<int> dp(amount+1, 0);  // number of way to make this amount
        dp[0]=1;
        for(int cv: coins)
        {
            for(int amt=cv; amt<=amount; amt++)
                dp[amt] += dp[amt-cv];
            cout<<cv<<"-> ";
            for(int x: dp)
                cout<<x<<" "; cout<<endl;
        }
        return dp[amount];
    }
    
    int solve(int idx, int amt, vector<int>& coins)
    {
        if(amt == 0)
            return memo[idx][amt]=1;
        if(idx == coins.size() or amt<0)
            return memo[idx][amt]=0;
        if(memo[idx][amt] != -1) return memo[idx][amt];
        int cnt=0;
        // for(int i=idx; i<coins.size(); i++)
        // {
        //     if(coins[i]<=amt)
        //     {
        //         cnt+= solve(i, amt-coins[i], coins);
        //     }
        // }
        if(coins[idx]<=amt)
            cnt = solve(idx, amt-coins[idx], coins) + solve(idx+1, amt, coins);
        else
            cnt = solve(idx+1, amt, coins);
        return memo[idx][amt]=cnt;
    }
};