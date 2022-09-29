/*https://leetcode.com/problems/find-closest-number-to-zero/*/

class Solution {
    public int findClosestNumber(int[] nums) {
        int i = 0, n = nums.length;
        Arrays.sort(nums);
        for (; i < n; ++i)
            if (nums[i] > 0) break;
        int neg = i-1;
        if (neg == -1) return nums[0];
        if (i == n) return nums[n-1];
        return nums[i] > -nums[i-1] ? nums[i-1] : nums[i];
    }
}

class Solution {
    public int findClosestNumber(int[] nums) {
        int n = nums.length, i = n;
        Arrays.sort(nums);
        int low = 0, high = n-1, mid;
        while (low <= high)
        {
            mid = low+(high-low)/2;
            if (nums[mid] > 0)
            {
                i = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        int neg = i-1;
        if (neg == -1) return nums[0];
        if (i == n) return nums[n-1];
        return nums[i] > -nums[i-1] ? nums[i-1] : nums[i];
    }
}

class Solution {
    public int findClosestNumber(int[] nums) {
        int minDiff = Integer.MAX_VALUE;
        int ans = 0;
        for (int x: nums)
        {
            int diff = Math.abs(0-x);
            if (diff < minDiff)
            {
                minDiff = diff;
                ans = x;
            }
            else if (diff == minDiff)
                ans = Math.max(ans,x);
        }
        return ans;
    }
}