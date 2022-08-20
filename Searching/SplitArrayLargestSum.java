/*https://leetcode.com/problems/split-array-largest-sum/*/

class Solution {
    int[] nums;
    int m;
    public int splitArray(int[] nums, int m) {
        this.nums = nums;
        this.m = m;
        int low = nums[0], high = 0, mid, result = -1;
        for (int val : nums)
        {
            low = Math.max(low,val);
            high += val;
        }
        while (low <= high)
        {
            mid = low+(high-low)/2;
            if (isPossible(mid))
            {
                result = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return result;
    }
    private boolean isPossible(int limit)
    {
        int curr = 0, count = 1;
        for (int i = 0; i < nums.length; ++i)
        {
            curr += nums[i];
            if (curr > limit)
            {
                ++count;
                if (count > m) return false;
                curr = nums[i];
            }
        }
        
        return true;
    }
}