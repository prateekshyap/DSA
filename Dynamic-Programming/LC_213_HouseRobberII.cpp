/*
https://leetcode.com/problems/house-robber-ii/
213. House Robber II

*/

class Solution {
public:
    int rob(vector<int>& nums) {
        
        int n = nums.size();
        
        if(n==0) return 0; // no house to take
        if(n==1) return nums[0]; // only one house to take
        
        
//         vector<int> memo(n, -1);
//         vector<int> memo1(n, -1);
        
//         bool TakeZeroth = true;
//         solve(0, memo, nums, TakeZeroth);
//         solve(1, memo1, nums, !TakeZeroth);
        
//         return max(memo[0], memo1[1]);
        
        int prev1 = 0; //i-1;
        int prev2 = 0; //i-2;
        int curr=0;
        int maxAmount = 0;
        for(int i=0; i<n-1; i++)
        {
            curr = max(prev1, nums[i] + prev2);
            prev2 = prev1;
            prev1 = curr;
        }
        maxAmount = curr;
         prev1 = 0; //i-1;
         prev2 = 0; //i-2;
         curr=0;
        for(int i=1; i<n; i++)
        {
            curr = max(prev1, nums[i] + prev2);
            prev2 = prev1;
            prev1 = curr;
        }
        
        return max(maxAmount, curr);
    }
    
    int solve(int idx, vector<int>& memo, vector<int>& nums, bool TakeZeroth)
    {
        if(idx >= nums.size()-int(TakeZeroth))
            return 0;
        
        if(memo[idx] != -1)
            return memo[idx];
        
        return memo[idx] = max(nums[idx] + solve(idx+2, memo, nums, TakeZeroth), solve(idx+1, memo, nums, TakeZeroth));
    }
    
    /*
    int recur(int idx, vector<int>& memo, vector<int>& nums)
    {
        if(idx >= nums.size()-1)
            return 0;
        
        if(memo[idx] != -1)
            return memo[idx];
        
        return memo[idx] = max(nums[idx] + recur(idx+2, memo, nums), recur(idx+1, memo, nums));
    }
    
    int recur1(int idx, vector<int>& memo, vector<int>& nums)
    {
        if(idx >= nums.size())
            return 0;
        
        if(memo[idx] != -1)
            return memo[idx];
        
        return memo[idx] = max(nums[idx] + recur1(idx+2, memo, nums), recur1(idx+1, memo, nums));
    }
    */
    
    
};