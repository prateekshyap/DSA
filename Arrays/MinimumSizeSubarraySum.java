/*https://leetcode.com/problems/minimum-size-subarray-sum/*/

/*Simple Sliding Window Solution*/

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0, start = 0, end = -1, len = nums.length+1;
        boolean ended = false;
        while (end < nums.length)
        {
            ++end;

            //add the last element
            if (end < nums.length) sum += nums[end];
            else
            {
                --end;
                ended = true;
            }

            //till sum is greater than target, keep updating length and sliding the window
            while (sum > target)
            {
                len = Math.min(len,end-start+1);
                sum -= nums[start++];
            }

            //for sum = target
            if (sum == target)
                len = Math.min(len,end-start+1);

            //break if scanning ended
            if (ended) break;
        }

        //if length is unchanged, return 0
        return len == nums.length+1 ? 0 : len;
    }
}

/*Efficient solution*/

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int lo = 1, hi = nums.length, min = 0;
        while (lo <= hi) {
            int mid = (lo + hi) >> 1;
            if (windowExist(mid, nums, s)) {
                hi = mid - 1;
                min = mid;
            } else
                lo = mid + 1;
        }
        return min;
    }

    private boolean windowExist(int size, int[] nums, int s) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= size)
                sum -= nums[i - size];
            sum += nums[i];
            if (sum >= s)
                return true;
        }
        return false;
    }
}

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0, start = 0, end = 0, len = nums.length+1;
        while (end < nums.length)
        {
            sum += nums[end];
            while (sum-nums[start] >= target)
                sum -= nums[start++];
            if (sum >= target) len = Math.min(len,end-start+1);
            ++end;
        }
        return len == nums.length+1 ? 0 : len;
    }
}
