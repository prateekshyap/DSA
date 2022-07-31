/*https://leetcode.com/problems/number-of-zero-filled-subarrays/*/

class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long streak = 0, result = 0;
        for (int num : nums)
        {
            if (num == 0)
                result += (++streak);
            else streak = 0;
        }
        return result;
    }
}