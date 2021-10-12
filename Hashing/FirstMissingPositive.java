/*https://leetcode.com/problems/first-missing-positive/*/

/*Prateekshya*/

/*Modifying the existing array*/

class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean isOnePresent = false, isLengthPresent = false;
        for (int i = 0; i < n; ++i)
        {
            if (nums[i] == 1)
                isOnePresent = true;
            else if (nums[i] == n)
                isLengthPresent = true;
            if (nums[i] < 0) nums[i] = 0;
        }
        if (!isOnePresent) return 1;
        if (n == 1) return 2;
        nums[1] = nums[1] == 0 ? -1 : nums[1]*(-1);
        for (int i = 0; i < n; ++i)
        {
            int absValue = Math.abs(nums[i]);
            if (absValue < nums.length && absValue != 1 && nums[absValue] >= 0)
            {
                nums[absValue] = nums[absValue] == 0 ? -1 : nums[absValue]*(-1);
            }
        }
        for (int i = 1; i < n; ++i)
            if (nums[i] >= 0)
                return i;
        return isLengthPresent ? n+1 : n;
    }
}