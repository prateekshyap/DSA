/*https://leetcode.com/problems/find-the-duplicate-number/*/

class Solution {
    public int findDuplicate(int[] nums) {
        /*
        logic is - if nums[0] = 5, make nums[5] *= -1, if some index is negative already
        that means the value is already visited and it is repeated
        */
        for (int i = 0; i < nums.length; ++i)
        {
            int index = Math.abs(nums[i]);
            
            //if the value is negative, that means it is already visited
            if (nums[index] < 0)
                return index;
            
            //multiply the value with -1
            nums[index] *= -1; 
        }
        return -1;
    }
}
