/*https://binarysearch.com/problems/Arithmetic-Sequences*/

import java.util.*;

class Solution {
    public int solve(int[] nums) {
        int start = 0, end = 0, n = nums.length, result = 0, gap = -1, val;

        while (end < n-1)
        {
            if (gap == -1 && start < n-1) gap = nums[start+1]-nums[start]; 
            while (end < n-1 && gap == nums[end+1]-nums[end]) ++end;
            if (end-start+1 >= 3)
            {
                val = end-start-1;
                result += (val*(val+1))/2;
            }
            start = end;
            gap = -1;
        }

        return result;
    }
}

import java.util.*;

class Solution {
    public int solve(int[] nums) {
        int ans = 0, n = nums.length, s = 0;

        for (int i = 2; i<n; i++)
        {
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]) s++;
            else s = 0;

            ans += s;
        }
        return ans;
    }
}