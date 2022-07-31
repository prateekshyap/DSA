/*https://binarysearch.com/problems/Quadratic-Application*/

import java.util.*;

class Solution {
    public int[] solve(int[] nums, int a, int b, int c) {
        int n = nums.length, i, breakP = 0;
        int[] sq = new int[n];

        for (i = 0; i < n; ++i)
        {
            sq[i] = nums[i]*nums[i];
            if (nums[i] <= 0)
                breakP = i;
        }

        int[] result = new int[n];

        int start = 0, end = n, startVal = 0, endVal = 0;
        i = 0;

        while (end > start)
        {
            startVal = a*sq[start]+b*nums[start]+c;
            endVal = a*sq[end-1]+b*nums[end-1]+c;

            if ((a >= 0 && startVal >= endVal) || (a < 0 && startVal <= endVal))
            {
                result[i++] = startVal;
                ++start;
            }
            else
            {
                result[i++] = endVal;
                --end;
            }
        }

        if (a >= 0)
        {
            start = 0;
            end = n-1;
            while (start < end)
            {
                startVal = result[start];
                result[start] = result[end];
                result[end] = startVal;
                ++start; --end;
            }
        }

        return result;
    }
}