/*https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/*/

class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0, high = n-1, mid;
        if (nums[low] < nums[high]) return nums[low];
        while (low < high)
        {
            mid = low+(high-low)/2;
            if (nums[mid] < nums[high])
                high = mid;
            else if (nums[mid] > nums[high])
                low = mid+1;
            else --high;
        }
        return nums[low];
    }
}

class Solution {
    public int findMin(int[] nums) {
        int start =0;
        int end = nums.length-1;
        while(start < end){
            int mid = start + (end-start)/2;
            if(mid > 0 && nums[mid] < nums[mid-1]){
                return nums[mid];
            }
            else if(nums[mid] > nums[end]){
                start = mid+1;
            }
            else if(nums[mid] == nums[end] && mid != end){
                end--;
            }
            else if(nums[mid] == nums[start] && mid != start){
                start++;
            }
            else {
                end = mid - 1;
            }
        }     
        return nums[start];
    }
}

