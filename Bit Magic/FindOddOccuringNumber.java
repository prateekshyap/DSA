/*https://leetcode.com/problems/single-number/*/

class Solution {
    public int singleNumber(int[] nums) {
        if (nums.length < 2)
            return nums[0];

        //xor all the numbers
        int result = nums[0]^nums[1];
        for (int i = 2; i < nums.length; ++i)
            result ^= nums[i];

       	//return the final xor value
        return result;
    }
}