/*
2369. Check if There is a Valid Partition For The Array
https://leetcode.com/problems/check-if-there-is-a-valid-partition-for-the-array/
*/

class Solution {
public:
    int n;
    vector<int> memo;
    bool validPartition(vector<int>& nums) {
        n = nums.size();
        // memo.resize(n, -1);
        // return solve(0, nums);

        vector<bool> dp(n+1, false);
        dp[0] = true; // 0 elements
        for(int i=0; i<n; i++)
        {
            if(i>=1 and dp[i-1] and nums[i] == nums[i-1])
               dp[i+1] = true;
            if(i>=2 and dp[i-2] and nums[i] == nums[i-2])
                    dp[i+1] = true;
            if(i>=2 and dp[i-2] and nums[i] == nums[i-1]+1 and nums[i-2]+1 == nums[i-1])
                dp[i+1] = true;
            
        }
        // for(int i=0; i<=n; i++)
        //     cout<<dp[i]<<" "; cout<<endl;
        return dp[n]; // n elements
    }
    
    
    bool solve(int i, vector<int>& nums)
    {
        if(i == n) return true;
        if(memo[i]!=-1) return memo[i];
        bool res=false;
        if(i+1<n and nums[i]==nums[i+1])
        {
            if(solve(i+2, nums)) return res=true;
            if(i+2<n and nums[i] == nums[i+2])
            {
                if(solve(i+3, nums)) return res=true;
            }
        }
        
        if(i+2<n and nums[i]+1==nums[i+1] and nums[i+1]+1 == nums[i+2])
        {
            if(solve(i+3, nums)) return res=true;
        }
        return memo[i]=res;
    }
};