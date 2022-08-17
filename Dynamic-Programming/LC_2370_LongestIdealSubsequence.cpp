/*
https://leetcode.com/problems/longest-ideal-subsequence/
2370. Longest Ideal Subsequence

*/
class Solution {
public:
    int longestIdealString(string s, int k) {
        vector<int> dp(26, 0);
        for(int i=0; i<s.size(); i++)
        {
            int cidx = s[i]-'a';
            int len=1;
            for(int j=0; j<26; j++)
            {
                if(abs(cidx-j) <= k)
                    len = max(len, dp[j]+1);
            }
            // for(int j=max(0, cidx-k); j<min(cidx+k+1, 26); j++)
            // {
            //         len = max(len, dp[j]+1);
            // }
            dp[cidx]=len;
        }
        
        // for(int x: dp)  cout<<x<<" ";cout<<endl;
        
        return *max_element(dp.begin(), dp.end());
        
    }//
};