/*https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/*/

class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n], suf = new int[n], sums = new int[n];
        pre[0] = nums[0];
        for (int i = 1; i < n; ++i)
            pre[i] = pre[i-1]+nums[i];
        suf[n-1] = nums[n-1];
        for (int i = n-2; i >= 0; --i)
            suf[i] = suf[i+1]+nums[i];
        sums[0] = suf[1]-nums[0]*(n-1);
        for (int i = 1; i < n-1; ++i)
            sums[i] = i*nums[i]-(n-i-1)*nums[i]-pre[i-1]+suf[i+1];
        sums[n-1] = nums[n-1]*(n-1)-pre[n-2];
        return sums;
    }
}