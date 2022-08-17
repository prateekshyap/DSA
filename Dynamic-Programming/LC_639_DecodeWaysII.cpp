/*
639. Decode Ways II

https://leetcode.com/problems/decode-ways-ii/
*/

class Solution {
public:
    typedef long long LL;
    const int mod = 1e9+7;
    int n;
    vector<LL> memo;
    int numDecodings(string s) {
        n = s.length(); 
        memo.resize(n, -1);
        solve(n-1, s);
        // // for(int x: memo) cout<<x<<" "; cout<<endl;
        return memo[n-1];
        
        vector<LL> dp(n+1, 0);
        dp[0] = 1;
        dp[1] = (s[0] == '*') ? 9 : (s[0] == '0' ?  0 : 1);
        for(int i=1; i<n; i++)
        {
            LL cnt=0;
            if(s[i] == '*')
            {
                cnt = 9*dp[i];
                if(i>=1)
                {
                    if(s[i-1] == '1')
                        cnt += 9*dp[i-1]; // 11-19
                    else if(s[i-1] == '2')
                        cnt += 6*dp[i-1]; // 21-26
                    else if(s[i-1] == '*')
                        cnt += 15*dp[i-1]; // 11-19, 21-26
                }
                dp[i+1] = cnt%mod;
            }
            // if current char is 1-9 or 0
            else{
                 cnt = (s[i] != '0')? dp[i]: 0;
                if(i>=1)
                {
                    if(s[i-1] == '1')
                        cnt += dp[i-1]; // 11/12/13/...19
                    else if(s[i-1] == '2' and s[i]<='6')
                        cnt +=  dp[i-1]; // 21/22/23/...26
                    else if(s[i-1] == '*')
                        cnt += (s[i]<='6'? 2 : 1)*dp[i-1]; // 11-19, 21-26
                }
             dp[i+1] = cnt%mod; 
            }
        } //for i=2
        return dp[n];
    }
    
    LL solve(int i, string &s)
    {
        if(i<0) return 1;
        if(memo[i] != -1) return memo[i];
        
        LL cnt=0;
        // if current char is *
        if(s[i] == '*')
        {
            cnt = 9*solve(i-1, s);
            if(i>=1)
            {
                if(s[i-1] == '1')
                    cnt += 9*solve(i-2, s); // 11-19
                else if(s[i-1] == '2')
                    cnt += 6*solve(i-2, s); // 21-26
                else if(s[i-1] == '*')
                    cnt += 15*solve(i-2, s); // 11-19, 21-26
            }
            return memo[i] = cnt%mod;
        }
        // if current char is 1-9 or 0
        if(s[i] == '0')
            cnt = 0;
        else 
            cnt = solve(i-1, s);
        
        if(i>=1)
        {
            if(s[i-1] == '1')
                cnt += solve(i-2, s); // 11/12/13/...19
            else if(s[i-1] == '2' and s[i]<='6')
                cnt +=  solve(i-2, s); // 21/22/23/...26
            else if(s[i-1] == '*')
                cnt += (s[i]<='6'? 2 : 1)*solve(i-2, s); // 11-19, 21-26
        }
        return memo[i] = cnt%mod;
    }
};