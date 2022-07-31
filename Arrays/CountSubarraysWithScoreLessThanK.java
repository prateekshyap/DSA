/*https://leetcode.com/problems/count-subarrays-with-score-less-than-k/*/

class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long count = 0;
        int start = 0, end = 0;
        long sumTillNow = 0, lenTillNow = 0, scoreTillNow = 0;
        while (end < n)
        {
            sumTillNow += nums[end];
            lenTillNow += 1;
            scoreTillNow += sumTillNow;
            scoreTillNow += nums[end]*(lenTillNow-1);
            while (scoreTillNow >= k)
            {
                sumTillNow -= nums[start];
                lenTillNow -= 1;
                scoreTillNow -= sumTillNow;
                scoreTillNow -= nums[start++]*(lenTillNow+1);
            }
            if (scoreTillNow < k)
                count += lenTillNow;
            ++end;
        }
        return count;
    }
}

class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long count = 0;
        int start = 0, end = 0;
        long sumTillNow = 0, lenTillNow = 0, scoreTillNow = 0;
        while (end < n)
        {
            sumTillNow += nums[end];
            ++lenTillNow;
            scoreTillNow = sumTillNow*lenTillNow;
            while (scoreTillNow >= k)
            {
                sumTillNow -= nums[start++];
                --lenTillNow;
                scoreTillNow = sumTillNow*lenTillNow;
            }
            count += lenTillNow;
            ++end;
        }
        return count;
    }
}