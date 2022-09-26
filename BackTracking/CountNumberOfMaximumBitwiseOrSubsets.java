/*https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/*/

class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        for (int num : nums)
            maxOr |= num;
        return count(nums,0,0,maxOr);
    }
    private int count(int[] nums, int index, int or, int maxOr)
    {
        if (index == nums.length)
            return or == maxOr ? 1 : 0;
        int result = 0;
        result += count(nums,index+1,or,maxOr);
        if ((or|nums[index]) == maxOr)
            result += Math.pow(2,nums.length-index-1);
        else result += count(nums,index+1,or|nums[index],maxOr);
        return result;
    }
}