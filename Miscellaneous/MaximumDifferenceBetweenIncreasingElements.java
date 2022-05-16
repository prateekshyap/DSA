/*https://leetcode.com/problems/maximum-difference-between-increasing-elements/*/

class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length, i = 0;
        int[] minTillNow = new int[n], maxTillNow = new int[n];
        minTillNow[0] = nums[0];
        for (i = 1; i < n; ++i) minTillNow[i] = Math.min(minTillNow[i-1],nums[i]);
        maxTillNow[n-1] = nums[n-1];
        for (i = n-2; i >= 0; --i) maxTillNow[i] = Math.max(maxTillNow[i+1],nums[i]);
        int maxDiff = -1;
        for (i = 0; i < n; ++i)
            if (maxTillNow[i]-minTillNow[i] > 0 && maxDiff < maxTillNow[i]-minTillNow[i])
                maxDiff = maxTillNow[i]-minTillNow[i];
        return maxDiff;
    }
}