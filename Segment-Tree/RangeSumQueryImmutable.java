/*https://leetcode.com/problems/range-sum-query-immutable/*/

class NumArray {
    int[] copy ;
    public NumArray(int[] nums) {
        copy = new int[nums.length];
        copy[0] = nums[0];
        for (int i = 1; i < nums.length ; i++)
               copy[i] = nums[i] + copy[i-1];
    }
    
    public int sumRange(int left, int right) {
        if (left == 0) return copy[right];
        return copy[right] - copy[left - 1]; 
    }
}