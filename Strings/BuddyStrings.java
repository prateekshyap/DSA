/*https://leetcode.com/problems/buddy-strings/*/

class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) return false;
        int[] diffIndices = new int[2];
        int[] freq = new int[26];
        int index = 0, S = s.length();
        char ch;
        for (int i = 0; i < S; ++i)
        {
            ++freq[s.charAt(i)-'a'];
            if (s.charAt(i) != goal.charAt(i))
            {
                if (index == 2) return false;
                diffIndices[index++] = i;
            }
        }
        if (index == 0) if (!isDuplicatePresent(freq)) return false; else return true;
        if (s.charAt(diffIndices[0]) == goal.charAt(diffIndices[1]) && s.charAt(diffIndices[1]) == goal.charAt(diffIndices[0]))
            return true;
        return false;
    }
    private boolean isDuplicatePresent(int[] freq)
    {
        for (int val : freq)
            if (val > 1)
                return true;
        return false;
    }
}