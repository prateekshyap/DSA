/*
2366. Minimum Replacements to Sort the Array
https://leetcode.com/problems/minimum-replacements-to-sort-the-array/
*/

class Solution {
public:
    // [3,7,3] --> [1,2 - 2,2,3 - 3]
    // [3,8,3] --> [1,2 - 2,3,3 - 3]
    // [3,9,3] --> [3, - 3,3,3 - 3]

    long long minimumReplacement(vector<int>& nums) {
        int n = nums.size();
        int last = nums[n-1];
        long long ans=0;
        
        for(int i = n-2; i>=0; i--)
        {
            int cur = nums[i];
            if(cur > last)
            {
                int k = cur/last + bool(cur % last);
                ans += k-1; //(k - 1) is the minimum number of times you'll have to spli
                last = cur/k; //(num // k) is the maximal number you can create from splitting (k - 1) times
            }
            else
                last = cur;
        }
        
        return ans;
    }
};