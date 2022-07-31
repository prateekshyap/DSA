/*https://binarysearch.com/problems/K-Distinct-Window*/

import java.util.*;

class Solution {
    public int[] solve(int[] nums, int k) {
        int[] hash = new int[100001];
        int n = nums.length, i, j = 0;
        int[] result = new int[n-k+1];
        for (i = 0; i < k; ++i)
        {
            ++hash[nums[i]];
            if (hash[nums[i]] == 1) ++result[j];
        }
        int distinctCount = 0;
        for (i = k; i < n; ++i)
        {
            ++j;
            distinctCount = result[j-1];
            --hash[nums[i-k]];
            if (hash[nums[i-k]] == 0) --distinctCount;
            ++hash[nums[i]];
            if (hash[nums[i]] == 1) ++distinctCount;
            result[j] = distinctCount;
        }

        return result;
    }
}