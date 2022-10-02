/*https://leetcode.com/problems/bitwise-xor-of-all-pairings/*/

class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        if (n1%2 == 0 && n2%2 == 0) return 0;
        int xor = 0;
        if (n1%2 == 1)
        {
            for (int num : nums2)
                xor ^= num;
        }
        if (n2%2 == 1)
        {
            for (int num : nums1)
                xor ^= num;
        }
        return xor;
    }
}