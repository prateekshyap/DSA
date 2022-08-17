/*
2367. Number of Arithmetic Triplets

https://leetcode.com/problems/number-of-arithmetic-triplets/
*/

class Solution {
public:
    int arithmeticTriplets(vector<int>& nums, int diff) {
        int n = nums.size();
        int cnt=0;
        // for(int a=0; a<n-2; a++) {
        //     for(int b=a+1; b<n-1; b++) {
        //         if(nums[b]-nums[a]==diff)
        //         {
        //             for(int c=b+1; c<n; c++) {
        //                 if(nums[c]-nums[b] == diff)
        //                     cnt++;
        //             }
        //         }
        //     }
        // }
        unordered_set<int> seen;
        for(int &x: nums)
        {
            seen.insert(x);
            int prev = x-diff;
            int prev2 = prev-diff;
            if(seen.count(prev) and seen.count(prev2)) 
                cnt++; 
        }
        return cnt;
    }
};