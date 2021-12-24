/*https://leetcode.com/problems/permutation-in-string/*/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;
        int[] s1Hash = new int[26];
        int[] s2Hash = new int[26];
        for (int i = 0; i < s1.length(); ++i)
            ++s1Hash[s1.charAt(i)-'a'];
        for (int i = 0; i < s1.length(); ++i)
            ++s2Hash[s2.charAt(i)-'a'];
        for (int i = s1.length(); i < s2.length(); ++i)
        {
            if (areEqual(s1Hash,s2Hash)) return true;
            --s2Hash[s2.charAt(i-s1.length())-'a'];
            ++s2Hash[s2.charAt(i)-'a'];
        }
        if (areEqual(s1Hash,s2Hash)) return true;
        return false;
    }
    
    private boolean areEqual(int[] h1, int[] h2)
    {
        for (int i = 0; i < h1.length; ++i)
            if (h1[i] != h2[i]) return false;
        return true;
    }
}