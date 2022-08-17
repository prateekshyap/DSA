/*
740. Delete and Earn

https://leetcode.com/problems/delete-and-earn/
*/

// Can be modified to House Robber Version, LIS
class Solution {
public: 
    vector<int> freq;
    vector<int> dp;
    int mxn;
    int deleteAndEarn(vector<int>& nums) {
        // int n = nums.size();
//         vector<int> arr(10001, 0);
//         for(int i=0; i<n; i++){
//             arr[nums[i]] += nums[i];
//         }
//         for(int x=2; x<10001; x++)
//             arr[x] = max(arr[x-1], arr[x-2] + arr[x]);
        
//         return arr[10000];
        
        mxn = *max_element(nums.begin(), nums.end());
        freq.resize(mxn+1, 0);
        for(int &x: nums)
            freq[x] += x; // int->val pair
        // dp.resize(mxn+1, -1);
        // return solve(0);
        
        int prev1=0, prev2=0, curr;
        for(int x=1; x<=mxn; x++)
        {
            curr = max(prev1, prev2+ freq[x]);
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }
    
    int solve(int idx)
    {
        if(idx>mxn)
            return 0;
        if(dp[idx] != -1) return dp[idx];
        return dp[idx]=max(freq[idx] + solve(idx+2), solve(idx+1));
    }
    
    //TLE
//     int solveLIS(vector<int>& nums)
//     {
//         int n = nums.size();
//         sort(nums.begin(), nums.end());
//         vector<int> dp(n,0);
//         int mx=0;
//         for(int i=0; i<n; i++)
//         {
//             dp[i] = nums[i];
//             for(int j=0; j<i; j++)
//             {
//                 if(nums[i] == nums[j] || nums[j]+1 < nums[i] )
//                     dp[i] = max(dp[i], nums[i] + dp[j]);
//             }
//             mx = max(mx, dp[i]);
//         }
//         // for(int i=0; i<n; i++)
//         //     cout<<dp[i]<<" "; cout<<endl;
        
//         return mx;
//     }
    
    
};