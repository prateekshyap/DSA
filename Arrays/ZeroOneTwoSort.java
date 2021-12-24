/*https://leetcode.com/problems/sort-colors/*/

class Solution {
    public void sortColors(int[] nums) {
        int[] counter = new int[3];
        for (int i = 0; i < nums.length; ++i)
            ++counter[nums[i]];
        int index = 0;
        for (int i = 0; i < counter[0]; ++i)
            nums[index++] = 0;
        for (int i = 0; i < counter[1]; ++i)
            nums[index++] = 1;
        for (int i = 0; i < counter[2]; ++i)
            nums[index++] = 2;
    }
}