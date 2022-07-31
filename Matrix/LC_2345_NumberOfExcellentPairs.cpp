/*
https://leetcode.com/problems/number-of-excellent-pairs/
2354. Number of Excellent Pairs

*/

class Solution {
public:
    long long countExcellentPairs(vector<int>& nums, int k) {
        long long pairs=0;
        int n = nums.size();
        vector<long long> cnt(32);
        /*
        sort(nums.begin(), nums.end());
        nums.resize(unique(nums.begin(), nums.end()) - nums.begin());
        for(auto &n: nums){
            cnt[__builtin_popcount(n)]++;
        */
        for(int x : unordered_set<int>(begin(nums), end(nums)))
        {
            cnt[__builtin_popcount(x)]++;
        }
        
        for(int i=1; i<30; i++)
        {
            for(int j=max(i, k-i); j<30; j++)
            {
                // if(i+j>=k)
                    pairs += cnt[i]*cnt[j] * (i==j?1:2);
            }
        }
        
        return pairs;
    }
};