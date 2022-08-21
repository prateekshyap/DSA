/*https://leetcode.com/problems/replace-all-digits-with-characters/*/

class Solution {
    public String replaceDigits(String s) {
        int n = s.length(), i, shift, ch;
        char[] a = s.toCharArray();
        for (i = 0; i < n && i+1 < n; i += 2)
        {
            ch = a[i]-'a';
            shift = a[i+1]-'0';
            ch += shift;
            ch %= 26;
            a[i+1] = (char)(ch+'a');
        }
        return new String(a);
    }
}