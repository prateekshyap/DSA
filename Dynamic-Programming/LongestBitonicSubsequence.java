/*https://binarysearch.com/problems/Longest-Bitonic-Subsequence*/

import java.util.*;

class Solution {
    public int solve(int[] a) {
        int size = a.length, i, j;
        int[] result = new int[size], result2 = new int[size];
        for (i = 0; i < size; ++i)
            result[i] = result2[i] = 1;

        //increasing
        for (i = 1; i < size; ++i)
            for (j = 0; j < i; ++j)
                if (a[i] > a[j] && result[i] < result[j]+1)
                    result[i] = result[j]+1;
        
        //decreasing
        for (i = size-2; i >= 0; --i)
            for (j = size-1; j > i; --j)
                if (a[i] > a[j] && result2[i] < result2[j]+1)
                    result2[i] = result2[j]+1;
        int max = 0;
        for (i = 0; i < size; ++i)
            max = findMax(max,result[i],result2[i],result[i]+result2[i]-1);
        return max;
    }
    public int findMax(int... nums)
    {
        int max = Integer.MIN_VALUE;
        for (int i : nums)
            if (i > max)
                max = i;
        return max;
    }
}