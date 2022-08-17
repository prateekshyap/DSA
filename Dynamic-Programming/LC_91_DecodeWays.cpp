/*
91. Decode Ways

https://leetcode.com/problems/decode-ways/
*/

class Solution {
public:
    int n;
    vector<int> memo;
    int numDecodings(string s) {
        n = s.length();
        if(s[0] == '0') return 0;
        // memo.resize(n+1, -1);
        // return solve(0, s);
//         vector<int> dp(n);
//         dp[0]=1;
//         for(int i=1; i<n; i++)
//         {
//             char cur = s[i];
//             char prev= s[i-1];
//             string x = s.substr(i-1, 2);
//             if(cur=='0' and prev=='0') return 0;
            
//             if(cur=='0' and prev!='0')
//             {
//                 if(x <="26")
//                     dp[i] += i-2>=0 ? dp[i-2] : 1;
//                 else 
//                     return 0;
//             }
//             else if(cur!='0' and prev=='0')
//                 dp[i] = dp[i-1];
//             else
//             {
//                 dp[i] = dp[i-1];
//                 if(x <="26")
//                     dp[i] += i-2>=0 ? dp[i-2] : 1; 
//             }
//         }
//         return dp[n-1];
        vector<int> dp(n+1,0);
        dp[0]=1;
        dp[1]=1;
        for(int i=2; i<=n; i++)
        {
            char cur = s[i];
            char prev= s[i-1];
            string x = s.substr(i-2, 2);
            if(prev != '0')
                dp[i] = dp[i-1];
            if(x>="10" and x<="26")
                dp[i] += dp[i-2];
        }
        // for(int i=0; i<=n; i++) cout<<dp[i]<<" "; cout<<endl;
        return dp[n];
    }
    
    int solve(int id, string& s)
    {
        if(id==n) 
            return 1;
        if(s[id] == '0')
            return 0;
        if(memo[id] != -1) return memo[id];
        
        int cnt=solve(id+1, s);
        if(id+1<n)
        {
            string x = s.substr(id, 2);
            if(x>="10" and x<="26")
                cnt+=solve(id+2, s);
        }
            
        
        return memo[id]=cnt;
    }
};