/*https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/*/

class Solution {
    public int minimumOperations(int[] nums) {
        int count = 0;
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int val : nums)
            if (val != 0)
                set.add(val);
        return set.size();
    }
}