/*https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and/submissions/*/

class Solution {
    int[] segmentTree;
    int len;
    public int longestSubarray(int[] nums) {
        int max = 0, n = nums.length;
        for (int i = 0; i < n; ++i)
            if (nums[i] > max)
                max = nums[i];
        int result = 0;
        int start = -1, end = -1;
        for (int i = 0; i < n; ++i)
        {
            if (nums[i] == max)
            {
                if (start == -1) start = end = i;
                else end = i;
            }
            else
            {
                result = Math.max(result,end-start+1);
                start = end = -1;
            }
        }
        if (start != -1)
            result = Math.max(result,end-start+1);
        return result;
    }
}

class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0, n = nums.length;
        for (int i = 0; i < n; ++i)
            if (nums[i] > max)
                max = nums[i];
        int result = 0, count = 0;
        for (int i = 0; i < n; ++i)
        {
            if (nums[i] == max)
            {
                ++count;
                result = Math.max(result,count);
            }
            else count = 0;
        }
        return result;
    }
}

class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int res = 0;
        int i = 0;
        int max = 0;
        while (i < n) {
            if (nums[i] >= max) {
                int j = i;
                while (j < n && nums[j] == nums[i]) j++;
                if (nums[i] > max) {
                    max = nums[i];
                    res = j - i;
                } else {
                    res = Math.max(res, j - i);
                }
                i = j;
            } else i++;
        }
        return res;
    }
}