/*https://leetcode.com/problems/count-asterisks/*/

class Solution {
    public int countAsterisks(String s) {
        boolean pairStarted = false;
        int n = s.length(), i, counter = 0;
        
        for (i = 0; i < n; ++i)
        {
            if (s.charAt(i) == '|') pairStarted = !pairStarted;
            if (s.charAt(i) == '*' && !pairStarted) ++counter;
        }
        
        return counter;
    }
}