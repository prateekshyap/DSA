/*https://leetcode.com/problems/longest-nice-subarray/*/

class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int start = 0, end = 0, max = 0;
        while (end < n)
        {
            int index = -1;
            for (int i = end-1; i >= start; --i)
            {
                if ((nums[i]&nums[end]) != 0)
                {
                    index = i;
                    break;
                }
            }
            if (index != -1)
                start = index+1;
            max = Math.max(max,end-start+1);
            ++end;
        }
        return max;
    }
}