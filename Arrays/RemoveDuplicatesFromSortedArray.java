/*https://leetcode.com/problems/remove-duplicates-from-sorted-array/*/

class Solution {
    public int removeDuplicates(int[] nums) {
        int curr = 0;
        for (int i = 1; i < nums.length; ++i)
        {
        	//increase i till the ith element is equal to current element
            while(i < nums.length && nums[i] == nums[curr])
                ++i;
            if (i < nums.length)
            {
            	//update current index and store the next element at the right position
                nums[curr+1] = nums[i];
                ++curr;
            }
        }
        return curr+1;
    }
}