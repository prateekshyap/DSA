/*https://leetcode.com/problems/binary-subarrays-with-sum/*/

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int[] cnt = new int[n+1];
        int odd = 0, ans = 0, sum = 0;
        cnt[0] = 1;
        for (int i = 0; i < n; ++i)
        {
            // odd += nums[i] & 1;
            sum += nums[i];
            // ans += odd >= k ? cnt[odd - k] : 0;
            ans += sum >= goal ? cnt[sum-goal] : 0;
            // cnt[odd] += 1;
            cnt[sum] += 1;
        }
        return ans;
    }
}

