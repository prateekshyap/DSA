/*
https://leetcode.com/problems/distinct-subsequences/
115. Distinct Subsequences

*/
class Solution {
public:
    vector<vector<int>> memo;
    // int slen=0;
    // int tlen=0;
    int numDistinct(string s, string t) {
        memo.resize(s.length()+1, vector<int>(t.length()+1, -1));
        // int a= solve(0, 0, s, t);
        // for(int i=0; i<=s.length(); i++)
        // {
        //     for(int j=0; j<=t.length(); j++)
        //     {
        //         cout<<memo[i][j]<<" ";
        //     }
        //     cout<<endl;
        // }
        return solve(0, 0, s, t);
    }
    
    int solve(int si, int ti, string &s, string &t)
    {
        if(ti == t.length())
            return memo[si][ti] = 1;
        if(si == s.length())
            return memo[si][ti] = 0;
        
        if(memo[si][ti] != -1)
            return memo[si][ti] ;
        
        int cnt=0;
        
        // cout<<s.length()<<" "<<t.length()<<" "<<((int)s.length() - (int)t.length() + ti)<<endl;
        for(int i=si; i<=((int)s.length() - (int)t.length() + ti) ; i++)
        {
            if(s[i] == t[ti])
            {
                cnt+= solve(i+1, ti+1, s, t);
            }
        }
        
        return memo[si][ti]  = cnt;
    }
};