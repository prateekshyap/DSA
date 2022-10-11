/*https://leetcode.com/problems/increasing-triplet-subsequence/*/

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, mid = min;
        for (int max : nums)
        {
            if (max < min)
                min = max;
            if (max > min && max < mid)
                mid = max;
            else if (max > mid) return true;
        }
        return false;
    }
}