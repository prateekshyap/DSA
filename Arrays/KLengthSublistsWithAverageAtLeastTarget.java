/*https://binarysearch.com/problems/Number-of-K-Length-Sublists-with-Average-at-Least-Target*/

import java.util.*;

class Solution {
    public int solve(int[] nums, int k, int target) {
        int sum = 0, count = 0;
        int i;
        for (i = 0; i < k; ++i)
            sum += nums[i];
        if (sum/k >= target) ++count;
        for (i = k; i < nums.length; ++i)
        {
            sum -= nums[i-k];
            sum += nums[i];
            if (sum/k >= target) ++count;
        }
        return count;
    }
}