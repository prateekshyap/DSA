/*https://leetcode.com/problems/search-in-rotated-sorted-array/*/

class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length-1);
    }
    public int binarySearch(int[] nums, int target, int start, int end)
    {
        if (start <= end)
        {
            int mid = (start+end)/2;
            if (nums[mid] == target)
            {
                return mid;
            }
            else if (target > nums[mid])
            {
                if (target > nums[end] && nums[end] >= nums[mid])
                    return binarySearch(nums,target,start,mid-1);
                else
                    return binarySearch(nums,target,mid+1,end);
            }
            else if (target < nums[mid])
            {
                if (target < nums[start] && nums[start] <= nums[mid])
                    return binarySearch(nums,target,mid+1,end);
                else
                    return binarySearch(nums,target,start,mid-1);
            }
        }
        return -1;
    }
}