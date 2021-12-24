/*https://leetcode.com/problems/find-all-duplicates-in-an-array/*/

/*Prateekshya*/

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; ++i)
        {
            int absValue = Math.abs(nums[i]);
            if (nums[absValue-1] < 0)
                list.add(absValue);
            nums[absValue-1] *= (-1);
        }
        return list;
    }
}