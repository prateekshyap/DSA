/*https://leetcode.com/problems/find-the-original-array-of-prefix-xor/*/

class Solution {
    public int[] findArray(int[] pref) {
        int[] result = new int[pref.length];
        result[0] = pref[0];
        for (int i = 1; i < pref.length; ++i)
            result[i] = pref[i-1]^pref[i];
        return result;
    }
}