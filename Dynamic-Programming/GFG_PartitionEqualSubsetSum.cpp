/*
https://practice.geeksforgeeks.org/problems/subset-sum-problem2014/1
Partition Equal Subset Sum
*/

class Solution{
public:
    vector<vector<int>> memo;
    int equalPartition(int N, int arr[])
    {
        int sum = accumulate(arr, arr+N, 0);
        if(sum%2 == 1) return 0;
        memo.assign(N+1, vector<int>(sum+1, -1));
        return solve(arr, sum/2, N);
    }
    
    bool solve(int arr[], int sum, int idx)
    {
        if(sum==0) return memo[idx][sum] = true;
        if(idx == 0) return memo[idx][sum] = false;
        
        if(memo[idx][sum] != -1)
            return memo[idx][sum];
        
        if(arr[idx-1] > sum) return memo[idx][sum] = solve(arr, sum, idx-1);
        
        return memo[idx][sum] = solve(arr, sum, idx-1) || solve(arr, sum - arr[idx-1], idx-1);
    }
};