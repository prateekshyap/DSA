/*
368. Largest Divisible Subset

https://leetcode.com/problems/largest-divisible-subset/
*/

class Solution {
public:
    vector<int> largestDivisibleSubset(vector<int>& nums) {
        int n = nums.size();
        sort(nums.begin(), nums.end());
        vector<int> dp(n, 1), hash(n,0);
        int len=1, lasti=0;           
//         for(int i=0; i<n; i++)  hash[i] = i;
        
        for(int i=1; i<n; i++)
        {   hash[i] = i;
            for(int prev=0; prev<i; prev++)
            {
                if(nums[i] % nums[prev]==0 and dp[prev]+1 > dp[i])
                {
                    dp[i] = dp[prev]+1;
                    hash[i] = prev;
                }
            }
            if(dp[i] > len) {
                len = dp[i];
                lasti=i;
            }
        }
        // cout<<"len "<<len<<" lasti"<<lasti<<endl;
        // for(int x: hash) cout<<x<<" "; cout<<endl;
        
        vector<int> ans;
        ans.push_back(nums[lasti]);
        while(hash[lasti] != lasti)
        {
            lasti = hash[lasti];
            ans.push_back(nums[lasti]);
        }
        // reverse(ans.begin(), ans.end());
        return ans;
    }//
};