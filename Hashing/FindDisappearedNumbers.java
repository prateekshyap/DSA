/*https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/*/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; ++i)
        {
            int temp = Math.abs(nums[i]);
            if (nums[temp-1] > 0)
                nums[temp-1] =- nums[temp-1];    
        }
        for (int i = 0; i < nums.length; ++i)
            if(nums[i] >= 0)
                list.add(i+1);
        return list;
    }
}