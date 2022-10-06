/*https://leetcode.com/problems/maximum-ascending-subarray-sum/*/

class Solution {
    public int maxAscendingSum(int[] nums) {
        int max = nums[0], sum = nums[0];
        for (int i = 1; i < nums.length; ++i)
        {
            if (nums[i] > nums[i-1])
                sum += nums[i];
            else sum = nums[i];
            max = Math.max(sum,max);
        }
        return max;
    }
}