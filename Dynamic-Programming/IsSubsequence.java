/*https://leetcode.com/problems/is-subsequence/*/

class Solution {
    public boolean isSubsequence(String s, String t) {
        int index = 0;
        int i;
        
        for (i = 0; i < t.length(); ++i)
        {
            if (index < s.length() && s.charAt(index) == t.charAt(i)) ++index;
            if (index == s.length()) break;
        }
        
        if (index == s.length()) return true;
        return false;
    }
}