/*
https://leetcode.com/problems/longest-continuous-increasing-subsequence/
674. Longest Continuous Increasing Subsequence

*/

class Solution {
public:
    int findLengthOfLCIS(vector<int>& nums) {
        int n = nums.size();
        if(n==0) return 0;
        
        /*
        vector<int> dp(n,1);
        for(int i=1; i<n; i++)
        {
            for(int j=0; j<i; j++)
            {
                if(nums[j] < nums[i] && i-j==1)
                    dp[i] = dp[j]+1;
            }
        }

        return *max_element(dp.begin(), dp.end());
        */
        int len=1;
        int ans=1;
        
        for(int i=1; i<n; i++)
        {
            if(nums[i-1] < nums[i])
                len++;
            else
            {
                ans = max(ans, len);
                len=1;
            }
        }
        ans = max(ans, len);
        return ans;
    }
};