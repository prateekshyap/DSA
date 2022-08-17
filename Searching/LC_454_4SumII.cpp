/*
454. 4Sum II

https://leetcode.com/problems/4sum-ii/
*/

class Solution {
public:
    int fourSumCount(vector<int>& nums1, vector<int>& nums2, vector<int>& nums3, vector<int>& nums4) {
        unordered_map<int, int> hash;
        for(int k: nums3)
        {
            for(int l: nums4)
            {
                hash[l+k]++;
            }
        }
        
        int ans=0;
        
        for(int i: nums1)
        {
            for(int j: nums2)
            {
                ans += hash[-(i+j)];
            }
        }
        
        return ans;
    }
};