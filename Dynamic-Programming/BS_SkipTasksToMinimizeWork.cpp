/*
https://binarysearch.com/problems/Skip-Tasks-to-Minimize-Work
Skip Tasks to Minimize Work

*/

int solve(vector<int>& nums) {

    int n = nums.size();
    if (n == 0) 
        return 0;

  /*  
  int dp[n][2];

    dp[0][0] = 0;
    dp[0][1] = nums[0];
    // cout<<dp[0][0]<<" "<<dp[0][1]<<endl;
    for(int i=1; i<n; i++)
    {
        dp[i][0] = dp[i-1][1];
        dp[i][1] = min(dp[i-1][0], dp[i-1][1])+nums[i];
        // cout<<dp[i][0]<<" "<<dp[i][1]<<endl;
    }

    return min(dp[n-1][0], dp[n-1][1]);
*/

/*
    int inc = nums[0];
    int exc = 0;
    int included = 0;
    for (int i = 1; i < nums.size(); ++i) {
        included = nums[i] + min(inc, exc);
        exc = inc;
        inc = included;
    }
    return min(exc, inc);
    */
     int dp[n + 1];
    dp[0] = 0;
    dp[1] = nums[0];
    for (int i = 2; i <= n; i++) {
        dp[i] = min(dp[i - 1], dp[i - 2]) + nums[i - 1];
    }
    return min(dp[n - 1], dp[n]);
}