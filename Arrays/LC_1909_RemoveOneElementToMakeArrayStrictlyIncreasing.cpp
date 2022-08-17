/*
1909. Remove One Element to Make the Array Strictly Increasing

https://leetcode.com/problems/remove-one-element-to-make-the-array-strictly-increasing/
*/
class Solution {
public:
    bool canBeIncreasing(vector<int>& nums) {
        int n = nums.size();
//         int mx=0;
//         vector<int> dp(n, 1);
//         for(int i=0; i<n; i++)
//         {
//             for(int j=0; j<i; j++)
//             {
//                 if(nums[j] < nums[i] and dp[i]< dp[j]+1)
//                     dp[i] = dp[j]+1;
//             }
//             mx = max(mx, dp[i]);
//         }
        
//         if(mx == n-1 or mx == n)
//             return true;
//         else 
//             return false;
        
        int count=0;
        for(int i=1; i<n; i++)
        {
            if(nums[i-1] >= nums[i])
            {
                if(count == 1) return false;
                count=1;
                if(i>=2 and nums[i-2] >= nums[i])
                    nums[i] = nums[i-1];
            }
        }
        // for(int i=0; i<n; i++) cout<<nums[i]<<" "; cout<<endl;
        return true;
    }
};