/*https://leetcode.com/problems/move-pieces-to-obtain-a-string/*/


class Solution {
    public boolean canChange(String start, String target) {
        if (start.length() != target.length()) return false;
        int i = 0, j = 0;
        while (i < start.length())
        {
            while (i < start.length() && start.charAt(i) == '_') ++i; //move i till next character
            while (j < target.length() && target.charAt(j) == '_') ++j; //move j till next character
            if (i == start.length() && j != target.length()) return false; //if i is exhausted but j is not, number of L and R not matching
            if (i != start.length() && j == target.length()) return false; //if j is exhausted but i is not, number of L and R not matching
            if (i == start.length() && j == target.length()) return true; //if both are exhausted then feasible
            if (start.charAt(i) != target.charAt(j)) return false; //if the current characters are not matching, then not feasible because letters cannot jump each other
            if (i > j && target.charAt(j) == 'R' && start.charAt(i) == 'R') return false; //if i is on the right but the letter doesn't say L, we cannot move left, so false
            if (i < j && target.charAt(j) == 'L' && start.charAt(i) == 'L') return false; //if i is on the left but the letter doesn't say R, we cannot move right, so false
            ++i; ++j; //increment both i and j
        }
        boolean result = true;
        for (; j < target.length(); ++j)
            if (target.charAt(j) != '_')
            {
                result = false;
                break;
            }
        return result; //if no interruptions, feasible
    }
}