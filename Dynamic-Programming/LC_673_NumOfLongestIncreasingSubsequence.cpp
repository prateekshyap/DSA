/*
673. Number of Longest Increasing Subsequence
https://leetcode.com/problems/number-of-longest-increasing-subsequence/
*/

class Solution {
public:
    int findNumberOfLIS(vector<int>& nums) {
        int n = nums.size();
        if(n==0) return 0;
        vector<int> dp(n,1), cnt(n, 1);
        int length=1;
        for(int i=1; i<n; i++)
        {
            for(int j=0; j<i; j++)
            {
                if(nums[j] < nums[i] && dp[j]+1 > dp[i])
                {
                    dp[i] = dp[j]+1;
                    cnt[i] = cnt[j]; // new longest
                }
                else if(nums[j] < nums[i] && dp[j]+1 == dp[i])
                    cnt[i] += cnt[j];
            }
            length = max(length, dp[i]);
        }
        
        int ans=0;
        for(int i=0; i<n; i++)
        {
            if(dp[i] == length)
                ans+= cnt[i];
            // cout<<dp[i]<<" "<<cnt[i]<<") ";
        }

        return ans;
    }
};