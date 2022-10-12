/*https://leetcode.com/problems/vowels-of-all-substrings/*/

class Solution {
    public long countVowels(String s) {
        int last[] = new int[26];
        long res = 0;
        for (int i = 0; i < s.length(); ++i)
        {
            if (isVowel(s.charAt(i))) last[s.charAt(i) - 'a'] += i + 1;
            for (int j: last)
                res += j;
        }
        return res;
    }
    public boolean isVowel(char ch)
    {
        if (ch == 'a') return true;
        if (ch == 'e') return true;
        if (ch == 'i') return true;
        if (ch == 'o') return true;
        if (ch == 'u') return true;
        return false;
    }
}