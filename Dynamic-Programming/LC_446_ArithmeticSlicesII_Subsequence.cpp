/*
https://leetcode.com/problems/arithmetic-slices-ii-subsequence/
446. Arithmetic Slices II - Subsequence

*/

typedef long long LL ;
class Solution {
public:
    int ans;
    int n;
    int numberOfArithmeticSlices(vector<int>& nums) {
        n = nums.size();
        ans=0;
        // Approach Brute Force TLE
        // vector<LL> cur;
        // dfs(0, nums, cur);
        // return ans;
        
        // // Approach 1: 
        // vector<unordered_map<LL, int>> cnt(n);
        // for(int i=1; i<n; i++)
        // {
        //     for(int j=0; j<i ; j++)
        //     {
        //         LL delta = (LL)nums[i] - (LL)nums[j];
        //         if(delta < INT_MIN or delta > INT_MAX) 
        //             continue; 
        //         int sum=0;
        //         if(cnt[j].find(delta) != cnt[j].end())
        //             sum = cnt[j][delta];
        //         ans += sum;
        //         cnt[i][delta] += sum + 1;
        //     }
        // }
        // return ans;
        
        //Approach 2:
        unordered_map<int, vector<int>> idx;
        for(int i=0; i<n; i++)
            idx[nums[i]].push_back(i);
        vector<vector<int>> dp(n+2, vector<int> (n+2, 0));
        for(int i=1; i<n; i++)
        {
            for(int j=0; j<i; j++)
            {
                LL prev = 2LL * nums[j] - nums[i]; // nj - (ni-nj);
                if(prev > INT_MAX or prev < INT_MIN) continue;
                auto id = idx.find(prev);
                if(id != idx.end())
                {
                    for(auto pind: id->second)
                    {
                        if(pind>=j) break;
                        dp[i][j] += dp[j][pind] +  1;
                    }
                    ans += dp[i][j];
                }
            }
        }
        
         // for(int i=0; i<n+2; i++) {  for(int j=0; j<n+2; j++) {   cout<<dp[i][j]<<" "; } cout<<endl; }
        
        return ans;
    }
    
//     void dfs(int dep, vector<int>& nums, vector<LL> cur)
//     {
//         if(dep == n){
//             int cs = cur.size();
//             if(cs < 3) return;
//             int diff = cur[1] - cur[0];
//             for(int i=2; i<cs; i++)
//             {
//                 if(cur[i] - cur[i-1] != diff)
//                     return;
//             }
//             for(auto &x: cur) cout<<x<<" "; cout<<endl;
//             ans++;
//             return;
//         }
        
//         dfs(dep+1, nums, cur); // without char
//         cur.push_back(nums[dep]);
//         dfs(dep+1, nums, cur); // with char
//     }
};