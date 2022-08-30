/*https://leetcode.com/problems/removing-stars-from-a-string/*/

class Solution {
    public String removeStars(String s) {
        StringBuilder build = new StringBuilder(s);
        int S = s.length(), i = 0, j = 0, loop = 0, consecStarCount = 0, newI;
        while (i < build.length())
        {
            if (build.charAt(i) == '*') ++consecStarCount;
            if (build.charAt(i) != '*' || i+1 == build.length())
            {
                if (consecStarCount > 0)
                {
                    j = i+1 == build.length() && build.charAt(i) == '*' ? i : i-1;
                    newI = j-(2*consecStarCount)+1;
                    build.delete(newI,j+1);
                    i = newI-1;
                    consecStarCount = 0;
                }
            }
            ++i;
        }
        return build.toString();
    }
}

class Solution {
    public String removeStars(String s) {
        int S = s.length(), i = 0;
        char[] arr = new char[S];
        for (char ch : s.toCharArray())
        {
            if (ch == '*')
                --i;
            else arr[i++] = ch;
        }
        StringBuilder build = new StringBuilder("");
        for (int j = 0; j < i; ++j)
            build.append(arr[j]);
        return build.toString();
    }
}