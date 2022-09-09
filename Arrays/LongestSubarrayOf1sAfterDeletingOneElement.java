/*https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/*/

class Solution {
    public int longestSubarray(int[] nums) {
        int start = 0, end = 0, n = nums.length, zero = 0, max = 0;
        while (end < n)
        {
            if (nums[end] == 0) ++zero;
            ++end;
            while (zero > 1)
            {
                if (nums[start] == 0)
                    --zero;
                ++start;
            }
            if (zero <= 1)
                max = Math.max(max,end-start);
        }
        return max-1;
    }
}