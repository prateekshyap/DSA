/*https://binarysearch.com/problems/XOR-Range-Queries*/

import java.util.*;

class Solution {
    public int[] solve(int[] nums, int[][] queries) {
        if (queries.length == 0) return new int[0];
        int n = nums.length, i, q = queries.length;
        int[] pre = new int[n];
        pre[0] = nums[0];
        for (i = 1; i < n; ++i)
            pre[i] = pre[i-1]^nums[i];
        int[] result = new int[q];
        for (i = 0; i < q; ++i)
        {
            if (queries[i][0] == 0)
            {
                result[i] = pre[queries[i][1]];
                continue;
            }
            result[i] = pre[queries[i][1]]^pre[queries[i][0]-1];
        }
        return result;
    }
}

import java.util.*;

class Solution {
    public int[] solve(int[] nums, int[][] queries) {
        if (queries.length == 0) return new int[0];
        int n = nums.length, i, q = queries.length;
        int[] pre = new int[n];
        pre[0] = nums[0];
        for (i = 1; i < n; ++i)
            pre[i] = pre[i-1]^nums[i];
        int[] result = new int[q];
        for (i = 0; i < q; ++i)
            if (queries[i][0] == 0)
                result[i] = pre[queries[i][1]];
            else
                result[i] = pre[queries[i][1]]^pre[queries[i][0]-1];
        return result;
    }
}

import java.util.*;

class Solution {
    public int[] solve(int[] nums, int[][] queries) {
        if (queries.length == 0) return new int[0];
        int n = nums.length, i, q = queries.length;
        int[] pre = new int[n];
        pre[0] = nums[0];
        for (i = 1; i < n; ++i)
            pre[i] = pre[i-1]^nums[i];
        int[] result = new int[q];
        for (i = 0; i < q; ++i)
            result[i] = pre[queries[i][1]]^pre[queries[i][0]]^nums[queries[i][0]];
        return result;
    }
}