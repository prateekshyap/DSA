/*
https://leetcode.com/problems/number-of-zero-filled-subarrays/
2348. Number of Zero-Filled Subarrays

*/

class Solution {
public:
    long long zeroFilledSubarray(vector<int>& nums) {
        long long cnt=0;
        int n = nums.size();
        long long z=0;
        // for(int i=0; i<n; i++)
        // {
        //     if(nums[i]==0) z++;
        //     else z=0;
        //     cnt +=z;
        // }
        for(int x: nums)
        {
            if(x==0) z++;
            else {
                cnt+= (z * (z+1))/2;
                z=0;
            }
        }
        cnt+= (z * (z+1))/2;
        return cnt;
    }
};