/*https://binarysearch.com/problems/Largest-Sum-of-Non-Adjacent-Numbers*/

import java.util.*;

class Solution {
    public int solve(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0] < 0 ? 0 : nums[0];
        if (nums.length == 2) return Math.max(nums[0],nums[1]) < 0 ? 0 : Math.max(nums[0],nums[1]);
        int[] memo = new int[nums.length];
        int[] maxTillPoint = new int[nums.length];
        memo[0] = maxTillPoint[0] = nums[0] < 0 ? 0 : nums[0];
        memo[1] = nums[1] < 0 ? 0 : nums[1];
        maxTillPoint[1] = Math.max(memo[0],memo[1]);
        for (int i = 2; i < memo.length; ++i)
        {
            memo[i] = maxTillPoint[i-2]+(nums[i] < 0 ? 0 : nums[i]);
            maxTillPoint[i] = Math.max(maxTillPoint[i-1],memo[i]);
        }
        return maxTillPoint[nums.length-1] < 0 ? 0 : maxTillPoint[nums.length-1];
    }
}

import java.util.*;

class Solution {
    public int solve(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0] < 0 ? 0 : nums[0];
        if (nums.length == 2) return Math.max(nums[0],nums[1]) < 0 ? 0 : Math.max(nums[0],nums[1]);
        int[] maxTillPoint = new int[nums.length];
        maxTillPoint[0] = nums[0] < 0 ? 0 : nums[0];
        maxTillPoint[1] = Math.max(maxTillPoint[0],nums[1] < 0 ? 0 : nums[1]);
        for (int i = 2; i < nums.length; ++i)
            maxTillPoint[i] = Math.max(maxTillPoint[i-1],maxTillPoint[i-2]+(nums[i] < 0 ? 0 : nums[i]));
        return maxTillPoint[nums.length-1] < 0 ? 0 : maxTillPoint[nums.length-1];
    }
}

import java.util.*;

class Solution {
    public int solve(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0] < 0 ? 0 : nums[0];
        if (nums.length == 2) return Math.max(nums[0],nums[1]) < 0 ? 0 : Math.max(nums[0],nums[1]);

        int secondLast = nums[0] < 0 ? 0 : nums[0];
        int last = Math.max(secondLast,nums[1] < 0 ? 0 : nums[1]);
        int curr = -1;

        for (int i = 2; i < nums.length; ++i)
        {
            curr = Math.max(last,secondLast+(nums[i] < 0 ? 0 : nums[i]));
            secondLast = last;
            last = curr;
        }

        return curr;
    }
}