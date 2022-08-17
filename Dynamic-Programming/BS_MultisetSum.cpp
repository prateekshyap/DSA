/*
https://binarysearch.com/problems/Multiset-Sum
Multiset Sum

*/

/*
vector<vector<int>> memo;
int solve(int idx, int sum, vector<int>& nums)
{
    if(sum==0)
        return 1;
    if(sum < 0)
        return 0;
    if(memo[idx][sum] != -1)
        return memo[idx][sum];

    int cnt=0;
    for(int i=idx; i<nums.size(); i++)
    {
        cnt+= solve(i, sum-nums[i], nums);
    }

    return memo[idx][sum]=cnt;
}

int solve(vector<int>& nums, int k) {
    memo.clear();
    memo.resize(nums.size()+1, vector<int>(k+1, -1));
    return solve(0, k, nums);

}
*/

int solve(vector<int>& nums, int k) {
    
    vector<int> dp(k+1, 0);
    dp[0] = 1;
    for(int x: nums)
    {
        for(int amt=x; amt<=k; amt++)
        {
            dp[amt] += dp[amt-x];
        }
    }
    return dp[k];
}