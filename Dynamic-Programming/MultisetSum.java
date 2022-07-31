/*https://binarysearch.com/problems/Multiset-Sum*/

import java.util.*;

class Solution {
    public int solve(int[] nums, int k) {
        return recur(nums, k, 0);
    }
    public int recur(int[] nums, int k, int index)
    {
        if (k == 0) return 1;
        int i, result = 0;
        for (i = index; i < nums.length; ++i)
            if (nums[i] <= k)
                result += recur(nums, k-nums[i], i);
        return result;
    }
}

import java.util.*;

class Solution {
    Integer[][] memo;
    public int solve(int[] nums, int k) {
        memo = new Integer[nums.length+1][k+1];
        memo[0][k] = recur(nums, k, 0);
        return memo[0][k];
    }
    public int recur(int[] nums, int k, int index)
    {
        if (k == 0)
        {
            memo[index][k] = 1;
            return 1;
        }
        if (memo[index][k] != null) return memo[index][k];
        int i, result = 0;
        for (i = index; i < nums.length; ++i)
            if (nums[i] <= k)
                result += recur(nums, k-nums[i], i);
        memo[index][k] = result;
        return result;
    }
}

import java.util.*;

class Solution {
    public int solve(int[] nums, int k) {
        int[] memo = new int[k+1];
        memo[0] = 1;
        int sum;
        for (int num : nums)
            for (sum = num; sum <= k; ++sum)
                memo[sum] += memo[sum-num];
        return memo[k];
    }
}