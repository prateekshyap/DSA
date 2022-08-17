/*
https://leetcode.com/problems/wildcard-matching/
https://practice.geeksforgeeks.org/problems/wildcard-pattern-matching/1
*/
class Solution {
public:
    
    int ns, np;
    string s, p;
    vector<vector<int>> memo;
    
    bool isMatch(string s, string p) {
        ns = s.length();
        np = p.length();
        // this->s = s;
        // this->p = p;
        // cout<<ns<<" "<<np<<endl;
        // memo.assign(ns+1, vector<int>(np+1, -1)); 
        // return solveDPRec(0, 0);
        
        //return solveDP(s,p);
        
        return solveGreedy(s, p);
        
        
    }
   //    1. If *s==*p or *p == ‘?’ which means this is a match, then go to next element s++ p++.
 // 2. If *p=='*', this is also a match, but one or many chars may be available, so save this *'s position and the matched s position.
 // 3. If not match, then we check if there is a * that previously showed up,
 //        → if there is no *,  return false;
 //        → if there is an *,  we set current p to the next element of *, and set current s to the next saved s position.  
    bool solveGreedy(string &s, string &p)
    {
        int i=0, j=0;
        int last_s =-1, last_p = -1;
        
        while(i<ns)
        {
            if(p[j] == '*')
            {
                last_s = i;
                last_p = j;
                ++j;
            }
            else if(s[i] == p[j] || p[j]=='?')
            {
                ++i;
                ++j;
            }
            else if(last_s == -1)
                return false;
            else{
                i = ++last_s;
                j = last_p + 1;
            }
        }
        while(j<np and p[j]=='*')
            j++;
        return j==np;
    }
    
    bool solveDP(string s, string p)
    {
       vector<vector<bool>> dp(np+1, vector<bool>(ns+1, false));
        dp[0][0] = true; // null both
        
        for(int i=1; i<=np; i++)
        {
            if(p[i-1] == '*') dp[i][0] = dp[i-1][0];
            bool match = false;
            for(int j=1; j<= ns; j++)
            {
                if(p[i-1] == s[j-1] || p[i-1] =='?')
                    dp[i][j] = dp[i-1][j-1];
                else if(p[i-1] == '*')
                {
                    if(match) dp[i][j] = true;
                    else if(dp[i-1][j-1] || dp[i-1][j])
                    {
                        match = true;
                        dp[i][j] = true;
                    }
                }
            }
        }
        
        // for(int i=0; i<=np; i++) { for(int j=0; j<=ns; j++){ cout<<dp[i][j]<<" "; } cout<<endl;  }
        
        return dp[np][ns];
    }
    
    bool solveDPRec(int i, int j)
    {
        // cout<<i<<"i "<<j<<"j ";
        if(i>=ns and j>=np) return true;
        if(j>=np) return false; // i!=ns
        if(i>=ns)
        {
            for(int jj=j; jj<np; jj++)
                if(p[jj] != '*') return false;
            return true;
        }
        
        // cout<<s[i]<<" "<<p[j]<<endl;
        if(memo[i][j] != -1) return memo[i][j];
        
        bool match = ((s[i] == p[j]) || (p[j] == '?'));
        
        if(p[j]=='*')
        {
            return memo[i][j] = ((solveDPRec(i+1, j))) || solveDPRec(i, j+1);
        }
        
        return memo[i][j] = match && solveDPRec(i+1, j+1);
        
    }
    
//     bool solve(int i, int j)
//     {
//         cout<<i<<"i "<<j<<"j ";
//         if(i>=ns and j>=np) return true;
//         if(j>=np) return false; // i!=ns
//         if(i>ns) return false;
        
//         // cout<<s[i]<<" "<<p[j]<<endl;
//         if(memo[i][j] != -1) return memo[i][j];
        
//         bool match = (i<ns) and ((s[i] == p[j]) || (p[j] == '?'));
        
//         if(p[j]=='*')
//         {
//             return memo[i][j] = ((i<ns) and (solve(i+1, j))) || solve(i, j+1);
//         }
        
//         return memo[i][j] = match && solve(i+1, j+1);
        
//     }
};