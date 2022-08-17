/*
https://binarysearch.com/problems/Largest-Sum-of-Non-Adjacent-Numbers
Largest Sum of Non-Adjacent Numbers

*/


int solve_(vector<int>& nums) {
    
    int n = nums.size();
    if(n==0)
        return 0;

    vector<int> dp(n, 0);
    dp[0] = nums[0] < 0 ? 0 : nums[0];
    dp[1] = max({nums[0], nums[1], 0});

    for(int i=2; i<n; i++)
    {
        dp[i] = max(dp[i-1], dp[i-2] + nums[i] );
        // cout<<dp[i]<<" ";
    }

    return dp[n-1]<0 ? 0 : dp[n-1];
}

int solve(vector<int>& nums) {
    
    int n = nums.size();
    if(n==0)
        return 0;

    // int incl = max(0, nums[0]);
    // int excl = 0;
    // for(int i=1; i<n; i++)
    // {
    //     int temp = incl;
    //     incl = max(excl + nums[i], incl);
    //     excl = temp;
    // }
    // return incl;

    int prev1 = 0;
    int prev2 = 0;
    int cur = 0;
    for(int i=0; i<n; i++)
    {
        cur = max(prev1, prev2 + nums[i]);
        prev2 = prev1;
        prev1 = cur;
    }
    return cur;

}