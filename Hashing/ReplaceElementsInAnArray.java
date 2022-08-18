/*https://leetcode.com/problems/replace-elements-in-an-array/*/

class Solution {
    private static final int[] map = new int[1000001];
    public int[] arrayChange(int[] nums, int[][] operations) {
        for (int i = 0; i < nums.length; ++i)
            map[nums[i]] = i;
        int index;
        for (int[] op : operations)
        {
            index = map[op[0]];
            nums[index] = op[1];
            map[op[1]] = index;
            map[op[0]] = -1;
        }
        return nums;
    }
}