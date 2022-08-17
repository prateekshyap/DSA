/*
https://leetcode.com/problems/longest-increasing-subsequence/
300. Longest Increasing Subsequence

*/

class Solution {
public:
    int lengthOfLIS_(vector<int>& nums) {
        int n = nums.size();
        vector<int> ans;

        for(int x: nums)
        {
            int ind = lower_bound(ans.begin(), ans.end(), x) - ans.begin();
            if(ind == ans.size())
                ans.push_back(x);
            else
                ans[ind] = x;
            //    for(int x: ans)
            //     cout<<x<<" ";
            //     cout<<endl;
        }

        return ans.size();
    }
    
    int lengthOfLIS(vector<int>& nums) {
        int n = nums.size();
        if(n==0) return 0;
        vector<int> dp(n,1);
        for(int i=1; i<n; i++)
        {
            for(int j=0; j<i; j++)
            {
                if(nums[j] < nums[i] && dp[j]+1 > dp[i])
                    dp[i] = dp[j]+1;
            }
        }

        return *max_element(dp.begin(), dp.end());
    }
};