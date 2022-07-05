/*https://binarysearch.com/problems/Maximum-Absolute-Value-of-Sublist*/

import java.util.*;

class Solution {
    public int solve(int[] nums) {
        if (nums.length == 0) return 0;
        int currMax = 0, max = Integer.MIN_VALUE, n = nums.length, min = Integer.MAX_VALUE, currMin = 0;
        for (int i = 0; i < n; ++i)
        {
            currMax += nums[i];
            if (currMax > max) max = currMax;
            if (currMax < 0) currMax = 0;
            currMin += nums[i];
            if (currMin < min) min = currMin;
            if (currMin > 0) currMin = 0;
        }
        return Math.max(max,Math.abs(min));
    }
}