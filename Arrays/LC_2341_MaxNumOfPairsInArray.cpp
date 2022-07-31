/*
https://leetcode.com/problems/maximum-number-of-pairs-in-array/
2341. Maximum Number of Pairs in Array
*/

class Solution {
public:
    vector<int> numberOfPairs(vector<int>& nums) {
        int cnt[101]{};
        int pairs=0, leftover=0;
        /*
        for(auto i: nums)
            cnt[i]++;
        for(int i: cnt)
        {
            pairs += i/2;
            leftover += i%2;
        }
        return {pairs, leftover};
        */
        
        for(int x: nums)
        {
            pairs += ++cnt[x]%2 == 0 ? 1: 0;
        }
        return {pairs, int(nums.size())-pairs*2};
    }
};