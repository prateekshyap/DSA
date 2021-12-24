/*https://leetcode.com/problems/valid-anagram/*/

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] ht = new int[26];
        if (s.length() != t.length()) return false;
        for (int i = 0; i < s.length(); ++i)
        {
            //add frequencies for s
            ++ht[s.charAt(i)-'a'];

            //subtract frequencies for t
            --ht[t.charAt(i)-'a'];
        }

        //if any character is not neutralized then return false
        for (int i = 0; i < 26; ++i)
            if (ht[i] != 0)
                return false;

        //if loop not interrupted, return true
        return true;
    }
}