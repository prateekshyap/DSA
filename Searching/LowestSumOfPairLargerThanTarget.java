/*https://binarysearch.com/problems/Lowest-Sum-of-Pair-Larger-than-Target*/

import java.util.*;

class Solution {
    public int solve(int[] nums, int target) {
        int low, high, mid, n = nums.length, i, j, minSum = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (i = 0; i < n-1; ++i)
        {
            low = i+1;
            high = n-1;
            j = -1;
            while (low <= high)
            {
                mid = low+(high-low)/2;
                if (nums[i]+nums[mid] > target)
                {
                    j = mid;
                    high = mid-1;
                }
                else low = mid+1;
            }
            if (j != -1 && nums[i]+nums[j] < minSum) minSum = nums[i]+nums[j];
        }
        return minSum;
    }
}