/*https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/*/

class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int N = nums.length;
        int ans = Integer.MAX_VALUE;
        long[] preSum = new long[N+1];
        for (int i = 0; i < N; ++i)
            preSum[i+1] = preSum[i]+nums[i];
        int[] stack = new int[N+1];
        int L = -1;
        int R = -1;
        for (int i = 0; i <= N; ++i) {
            while (R > L && preSum[stack[R]] > preSum[i]) --R;
            while (R > L && preSum[stack[L + 1]] + k <= preSum[i])
                ans = Math.min(ans, i - stack[++L]);
            stack[++R] = i;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}