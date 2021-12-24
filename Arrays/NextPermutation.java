/*https://leetcode.com/problems/next-permutation/*/

class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        
        //move till the sequence is non-decreasing
        while(i >= 0 && nums[i + 1] <= nums[i]) i--;
        
        //if such point exists
        if(i >= 0) {
            //swap with the next bigger element on right
            int j = nums.length - 1;
            while(j >= 0 && nums[j] <= nums[i]) j--;
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
        
        //sort the right subarray
        int l = i + 1, r = nums.length - 1;
        while(l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}