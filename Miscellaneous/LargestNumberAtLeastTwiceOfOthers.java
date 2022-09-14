/*https://leetcode.com/problems/largest-number-at-least-twice-of-others/*/

class Solution {
    public int dominantIndex(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int mi = 0;
        for (int i = 0; i < n; ++i)
        {
            if (nums[i] > max)
            {
                max = nums[i];
                mi = i;
            }
        }
        for (int i = 0; i < n; ++i)
        {
            if (i != mi && nums[i]*2 > max)
            {
                return -1;
            }
        }
        return mi;
    }
}