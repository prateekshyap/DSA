/*
https://leetcode.com/problems/russian-doll-envelopes/
354. Russian Doll Envelopes

*/

class Solution {
public:
    
    static bool mycmp(vector<int>& a, vector<int>& b)
    {
        if(a[0] != b[0]) return a[0]<b[0];
        return a[1]>b[1];
    }
    
    int maxEnvelopes(vector<vector<int>>& envelopes) {
        int n = envelopes.size();
        sort(envelopes.begin(), envelopes.end(), mycmp);
        vector<int> ans; // dp on height 
        
        for(auto x: envelopes)
        {
            int ind = lower_bound(ans.begin(), ans.end(), x[1]) - ans.begin();
            if(ind == ans.size())
                ans.push_back(x[1]);
            else
                ans[ind] = x[1];
        }
        
        return ans.size();
    }// end
};