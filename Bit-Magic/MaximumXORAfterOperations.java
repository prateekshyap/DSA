/*https://leetcode.com/problems/maximum-xor-after-operations/*/

class Solution {
    public int maximumXOR(int[] nums) {
        int res = 0;
        for (int a: nums)
            res |= a;
        return res;
    }
}