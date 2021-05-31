/*https://leetcode.com/problems/rotate-string/*/

class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() == 0 && goal.length() == 0) return true;
        if (s.length() == 0 || goal.length() == 0) return false;
        if (goal.length() != s.length()) return false;
        
        //concatenate s with s
        String concat = s+s;
        for (int i = 0; i < s.length(); ++i)

        	//if goal is a substring of the concatenated string then return true
            if (goal.equalsIgnoreCase(concat.substring(i,i+goal.length())))
                return true;
        return false;
    }
}