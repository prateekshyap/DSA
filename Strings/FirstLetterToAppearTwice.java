/*https://leetcode.com/problems/first-letter-to-appear-twice/*/

class Solution {
    public char repeatedCharacter(String s) {
        int[] hash = new int[26];
        for (char ch : s.toCharArray())
        {
            ++hash[ch-'a'];
            if (hash[ch-'a'] > 1)
                return ch;
        }
        return '\0';
    }
}