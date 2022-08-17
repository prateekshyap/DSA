/*https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/*/

class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        int low = 0, high = nums.length-1, mid;
        if (nums[high] > nums[low]) return nums[low];
        while (low <= high)
        {
            mid = low+(high-low)/2;
            if (nums[mid] > nums[mid+1]) return nums[mid+1];
            if (nums[mid-1] > nums[mid]) return nums[mid];
            if (nums[mid] > nums[0]) low = mid+1;
            else high = mid-1;
        }
        return Integer.MAX_VALUE;
    }
}