/*https://leetcode.com/problems/sum-of-all-subset-xor-totals/*/

class Solution {
    int sum;
    public int subsetXORSum(int[] nums) {
        sum = 0;
        recur(nums,0,0);
        return sum;
    }
    public void recur(int[] nums, int index, int xor)
    {
        if (index == nums.length) //if all elements are checked
        {
        	sum += xor;
            return;
        }

        /*exclude the current element and recur for the next*/
        recur(nums,index+1,xor);

        /*include the current element and recur for the next*/
		recur(nums,index+1,xor^nums[index]);
    }
}