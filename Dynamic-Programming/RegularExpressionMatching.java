/*https://leetcode.com/problems/regular-expression-matching/*/

class Solution {
    Boolean[][] dp;

    public boolean isMatch(String text, String pattern) {
        dp = new Boolean[text.length()+1][pattern.length()+1];
        return dp(0, 0, text, pattern);
    }

    public boolean dp(int i, int j, String text, String pattern)
    {
        if (dp[i][j] != null) return dp[i][j];
        boolean result;
        if (j == pattern.length())
            result = (i == text.length());
        else
        {
            boolean firstMatch = (i < text.length() &&
                                   (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));

            if (j+1 < pattern.length() && pattern.charAt(j+1) == '*')
                result = (dp(i, j+2, text, pattern) || firstMatch && dp(i+1, j, text, pattern)); //0 occurrence of jth character or matched jth character and some occurrences of jth character
            else
                result = firstMatch && dp(i+1, j+1, text, pattern); //last occurrence of jth character
        }
        dp[i][j] = result ? true : false;
        return result;
    }
}