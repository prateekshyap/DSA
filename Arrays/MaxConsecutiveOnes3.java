/*https://leetcode.com/problems/max-consecutive-ones-iii/*/

class Solution {
    public int longestOnes(int[] nums, int k) {
        int start = 0, end = -1, n = nums.length, zero = 0, maxLen = 0, ref;
        while (end < n-1)
        {
            ref = ++end;
            while (end < n && (nums[end] == 1 || zero < k))
            {
                if (nums[end] == 0) ++zero;
                ++end;
            }
            if (ref != end) --end;
            if (end-start+1 > maxLen && (nums[start] == 1 || k != 0)) maxLen = end-start+1;
            while (start < end && nums[start] != 0) ++start;
            if (start < n && nums[start] == 0 && zero > 0) { --zero; ++start; }
            else if (nums[start] == 0 && start == end) ++start;
        }
        return maxLen;
    }
}