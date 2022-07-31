/*
https://binarysearch.com/problems/Maximum-Absolute-Value-of-Sublist
https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/
1749. Maximum Absolute Sum of Any Subarray

*/

class Solution {
public:
    int maxAbsoluteSum(vector<int>& nums) {
        
        int curMax = 0;
        int curMin = 0;
        int maxSum = 0;
        
        for(int i=0; i<nums.size(); i++)
        {
            curMax = curMax + nums[i];
            curMin = curMin + nums[i];
            if(curMax < 0)
                curMax = 0;
            if(curMin > 0)
                curMin = 0;
            maxSum = max({maxSum, curMax, -curMin});
        }
        return maxSum;
    }//end
};