/*https://leetcode.com/problems/generate-a-string-with-characters-that-have-odd-counts/*/

class Solution {
    public String generateTheString(int n) {
        if (n == 1) return "a";
        else if (n == 2) return "ab";
        StringBuilder build = new StringBuilder("");
        if (n%2 == 0)
        {
            for (int i = 0; i < n-1; ++i)
                build.append('a');
            build.append('b');
        }
        else
        {
            for (int i = 0; i < n-2; ++i)
                build.append('a');
            build.append('b');
            build.append('c');
        }
        return build.toString();
    }
}