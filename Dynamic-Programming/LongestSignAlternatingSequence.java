/*https://binarysearch.com/problems/Longest-Sign-Alternating-Subsequence*/

import java.util.*;

class Solution {
    public int solve(int[] nums) {
        int n = nums.length, i, j;
        int[] dp = new int[n];
        for (i = 0; i < n; ++i)
            dp[i] = 1;
        int max = 1;
        for (i = 1; i < n; ++i)
        {
            for (j = i-1; j >= 0; --j)
            {
                if (((nums[i] < 0 && nums[j] > 0) || (nums[i] > 0 && nums[j] < 0)) && dp[i] < dp[j]+1)
                {
                    dp[i] = dp[j]+1;
                    break;
                }
            }
        }
        for (i = 0; i < n; ++i)
            if (dp[i] > max)
                max = dp[i];
        return max;
    }
}

import java.util.*;

class Solution {
    public int solve(int[] nums) {
        int n = nums.length, i, j;
        int[] dp = new int[n];
        for (i = 0; i < n; ++i)
            dp[i] = 1;
        int max = 1, lastNeg = -1, lastPos = -1;
        for (i = 0; i < n; ++i)
        {
            if (nums[i] > 0)
            {
                if (lastNeg != -1) dp[i] = dp[lastNeg]+1;
                lastPos = i;
            }
            else if (nums[i] < 0)
            {
                if (lastPos != -1) dp[i] = dp[lastPos]+1;
                lastNeg = i;
            }
        }
        for (i = 0; i < n; ++i)
            if (dp[i] > max)
                max = dp[i];
        return max;
    }
}

import java.util.*;

class Solution {
    public int solve(int[] nums) {
        int n = nums.length, i, j;

        int max = 1, lastNeg = -1, lastPos = -1, uMax = 1, nMax = 1;

        for (i = 0; i < n; ++i)
        {
            if (nums[i] > 0)
            {
                if (lastNeg != -1) uMax = nMax+1;
                lastPos = i;
            }
            else if (nums[i] < 0)
            {
                if (lastPos != -1) nMax = uMax+1;
                lastNeg = i;
            }
        }
        return Math.max(nMax,uMax);
    }
}

import java.util.*;

class Solution {
    public int solve(int[] nums) {
        int n = nums.length;

        int max = 1, uMax = 0, nMax = 0;
        
        for (int num : nums)
        {
            if (num > 0) uMax = nMax+1;
            else nMax = uMax+1;
        }
        return Math.max(nMax,uMax);
    }
}