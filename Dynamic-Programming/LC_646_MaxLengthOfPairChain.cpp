/*
646. Maximum Length of Pair Chain
https://leetcode.com/problems/maximum-length-of-pair-chain/
*/

class Solution {
public:
    static bool mycmp(vector<int>& a, vector<int>& b)
    {
        return a[1]<b[1];
    }
    
    int findLongestChain_(vector<vector<int>>& pairs) {
        int n = pairs.size();
        sort(pairs.begin(), pairs.end());
        vector<vector<int>> ans; 
        
        // for(auto x: pairs)cout<<x[0]<<", "<<x[1]<<"], ";cout<<endl;
        
        for(auto x: pairs)
        {
            int ind = lower_bound(ans.begin(), ans.end(), x) - ans.begin();
            if(ind == ans.size())
            {
                if(ind==0 or ans.back()[1] < x[0])
                    ans.push_back(x);
                else if(ans.back()[0] <= x[0] and ans.back()[1] >= x[1])
                    ans.back() = x;
                
            }
            else
                ans[ind] = x;
        }
        
        // for(auto x: ans)  cout<<x[0]<<", "<<x[1]<<"], "; cout<<endl;
        
        return ans.size();
    }
    
    int findLongestChain(vector<vector<int>>& pairs) {
        int n = pairs.size();
        int cnt=0;
        sort(pairs.begin(), pairs.end(), mycmp); 
        
        /* approach same as LIS
        vector<int> dp(n, 1);
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(pairs[j][1] < pairs[i][0])
                    dp[i] = max(dp[i], 1 + dp[j]);
            }
        }
        return *max_element(dp.begin(), dp.end());
        */
        // for(auto x: pairs)cout<<x[0]<<", "<<x[1]<<"], ";cout<<endl;
        
        int l=0;
        for(int i=0; i<n; i++)
        {
            if(i==0 or pairs[l][1] < pairs[i][0])
            {
                cnt++;
                l=i;
            }
            // cout<<pairs[l][0]<<", "<<pairs[l][1]<<"], ";
        }
        
        return cnt;
    }
};