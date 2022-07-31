/*
https://leetcode.com/problems/target-sum/
494. Target Sum

*/

class Solution {
public:
    int tg, nsum ;
    vector<vector<int>> memo;
    int findTargetSumWays(vector<int>& nums, int target) {
        tg = target;
        int n = nums.size();
        nsum = accumulate(nums.begin(), nums.end(), 0);
        memo.resize(n+1, vector<int>(2*nsum + 1, -1));
        return solve(0, 0, nums);
    }
    
    int solve(int idx, int csum, vector<int>& nums)
    {
        if(idx == nums.size()) {
            return memo[idx][csum+nsum]=(csum == tg);
        }
        if(memo[idx][csum+nsum] != -1) return memo[idx][csum+nsum];
        int cnt=0;
        cnt+= solve(idx+1, csum + nums[idx], nums);
        cnt+= solve(idx+1, csum - nums[idx], nums);
        return memo[idx][csum+nsum]=cnt;
    }
};