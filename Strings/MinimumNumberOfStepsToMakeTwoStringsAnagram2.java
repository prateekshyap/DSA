/*https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram-ii/*/

class Solution {
    public int minSteps(String s, String t) {
        int[] sHash = new int[26], tHash = new int[26];
        for (char ch : s.toCharArray())
            ++sHash[ch-'a'];
        for (char ch : t.toCharArray())
            ++tHash[ch-'a'];
        int result = 0;
        for (int i = 0; i < 26; ++i)
            result += Math.abs(sHash[i]-tHash[i]);
        return result;
    }
}