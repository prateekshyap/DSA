/*https://leetcode.com/problems/maximum-subarray/*/
/*https://binarysearch.com/problems/Largest-Sublist-Sum*/

//kadane algo
class Solution {
    public int maxSubArray(int[] nums) {
        int currMax = 0, max = Integer.MIN_VALUE, n = nums.length;
        for (int i = 0; i < n; ++i)
        {
            //get current sum
            currMax += nums[i];

            //if it is greater than maximum sum then update
            if (currMax > max)
                max = currMax;

            //if it is less than 0 then set it to 0
            if (currMax < 0)
                currMax = 0;
        }
        return max;
    }
}