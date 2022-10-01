/*https://leetcode.com/problems/non-decreasing-array/*/

class Solution {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; ++i)
        {
            if (nums[i] < nums[i-1]) //violates non-decreasing condition
            {
                if (++count > 1) return false;
                if (i == 1 || nums[i-2] <= nums[i])
                    nums[i-1] = nums[i];
                else
                    nums[i] = nums[i-1];
            }
        }
        return true;
    }
}