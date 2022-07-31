/*https://leetcode.com/problems/greatest-english-letter-in-upper-and-lower-case/*/

class Solution {
    public String greatestLetter(String s) {
        int[] hashU = new int[26], hashL = new int[26];
        int n = s.length(), i;
        for (i = 0; i < n; ++i)
        {
            if (s.charAt(i) <= 'Z' && s.charAt(i) >= 'A') ++hashU[s.charAt(i)-'A'];
            else ++hashL[s.charAt(i)-'a'];
        }
        for (i = 25; i >= 0; --i)
            if (hashU[i] > 0 && hashL[i] > 0) return Character.toString((char)(i+'A'));
        return "";
    }
}

