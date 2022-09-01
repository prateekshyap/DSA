/*https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/*/

class Solution {
    public int minSteps(String s, String t) {
        int[] sHash = new int[26], tHash = new int[26];
        for (char ch : s.toCharArray())
            ++sHash[ch-'a'];
        for (char ch : t.toCharArray())
            ++tHash[ch-'a'];
        for (int i = 0; i < 26; ++i)
            sHash[i] = Math.max(0,sHash[i]-tHash[i]);
        return sum(sHash);
    }
    private int sum(int[] a)
    {
        int sum = 0;
        for (int val : a)
            sum += val;
        return sum;
    }
}