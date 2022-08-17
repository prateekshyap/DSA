/*
https://leetcode.com/problems/combination-sum-iv/
377. Combination Sum IV

*/

class Solution {
public:
    // vector<vector<int>> memo;
    vector<int> memo1;
    int combinationSum4(vector<int>& nums, int target) {
        // memo.resize(nums.size()+1, vector<int>(target+1, -1));
        memo1.resize(target+1, -1);
        return solve(0, target, nums);
    }
    // vector<int> temp;
    int solve(int idx, int sum, vector<int>& nums)
    {
        if(sum==0){
            // for(int x: temp) {cout<<x<<" "; }cout<<endl;
            // return memo[idx][sum]=1;
            return memo1[sum]=1;
        }
        // if(memo[idx][sum] != -1) return memo[idx][sum];
        if(memo1[sum] != -1) return memo1[sum];
        int cnt=0;
        for(int i=0; i<nums.size(); i++)
        {
            if(sum < nums[i]) continue;
            // temp.push_back(nums[i]);
            cnt += solve(i, sum-nums[i], nums);
            // temp.pop_back();
        }
        // return memo[idx][sum]=cnt;
        return memo1[sum] = cnt;
    }
};