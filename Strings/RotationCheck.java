/*https://leetcode.com/problems/rotate-string/*/

class Solution {
    public boolean rotateString(String s, String goal) {
        //if both are of zero length, return true
        if (s.length() == 0 && goal.length() == 0) return true;

        //if one of them is of zero length, return false
        if (s.length() == 0 || goal.length() == 0) return false;

        //if their lengths are different, return false
        if (goal.length() != s.length()) return false;

        //concatenate given string to itself
        String concat = s+s;

        //check if goal is a substring or not
        for (int i = 0; i < s.length(); ++i)
            if (goal.equalsIgnoreCase(concat.substring(i,i+goal.length())))
                return true;
        return false;
    }
}