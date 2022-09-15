/*https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/*/

class Solution {
    public int minSumOfLengths(int[] arr, int target) 
    {
        int n = arr.length, start = 0, end = 0, sum = 0;
        long[] dp = new long[n];
        
        Arrays.fill(dp,Integer.MAX_VALUE);
        
        while (end < n)
        {
            sum += arr[end];
            while (sum > target)
                sum -= arr[start++];
            if (sum == target)
                dp[end] = end-start+1;
            ++end;
        }
        
        long result = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; ++i)
        {
            if (dp[i] < Integer.MAX_VALUE)
            {
                start = i-(int)dp[i];
                if (start >= 0)
                    result = Math.min(result,dp[start]+dp[i]);
            }
            if (i-1 >= 0)
                dp[i] = Math.min(dp[i],dp[i-1]);
        }
        return result > n ? -1 : (int)result;
    }
}