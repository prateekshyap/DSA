/*https://leetcode.com/problems/truncate-sentence/*/

class Solution {
    public String truncateSentence(String s, int k) {
        int i = 0;
        while (k != 0)
        {
            if (i == s.length()) return s;
            if (s.charAt(i++) == ' ') --k;
        }
        return s.substring(0,i-1);
    }
}