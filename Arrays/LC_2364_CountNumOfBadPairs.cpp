/*
2364. Count Number of Bad Pairs
https://leetcode.com/problems/count-number-of-bad-pairs/
*/

class Solution {
public:
    long long countBadPairs(vector<int>& nums) {
        long long n = nums.size();
        long long goodpairs=0;
        long long totalpairs=0;
        unordered_map<int, int> hash;
        for(int i=0; i<n; i++)
        {
            int diff = nums[i]-i;
            // if(hash.count(diff)==1) {
            //     goodpairs += hash[diff];
            //     hash[diff]++;
            // }
            // else
            //     hash[diff]=1;
            goodpairs += hash[diff];
            hash[diff]++;
            totalpairs+=i;
        }
        // totalpairs = (long)(n*(n-1))/2;
        return totalpairs-goodpairs;
    }
};