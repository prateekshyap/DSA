/* https://leetcode.com/problems/single-number/
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 */
class Solution {
public:
    int singleNumber(vector<int>& nums) {
        if(nums.size()==1)
            return nums[0];

        int result=0;
        for(int x: nums){
            result = result ^ x;
        }
        return result;
    }
};