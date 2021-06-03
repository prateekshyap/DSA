/*https://leetcode.com/problems/longest-palindromic-substring/*/

//DP solution
class Solution{
    static String longestPalin(String s){
        boolean[][] table = new boolean[s.length()][s.length()];

        //trivial maximum length will be 1
        int maxLength = 1;

        //fill all the one length strings
        for (int i = 0; i < s.length(); ++i)
            table[i][i] = true;

        //fill all the two length strings
        int start = 0;
        for (int i = 0; i < s.length()-1; ++i)
        {
            if (s.charAt(i) == s.charAt(i+1))
            {
                table[i][i+1] = true;
                if (maxLength == 1)
                    start = i;
                maxLength = 2;
            }
        }

        //fill other positions diagonally
        for (int k = 3; k <= s.length(); ++k) //k = substring size
        {
            for (int i = 0; i < s.length()-k+1; ++i) //i = starting position
            {
                int j = i+k-1; // j = ending position

                //if the two end characters are same and middle part is already a palindrome then store true
                if (table[i+1][j-1] && s.charAt(i) == s.charAt(j))
                {
                    table[i][j] = true;
                    if (k > maxLength)
                    {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }
        return s.substring(start,start+maxLength);
    }
}

//expansion technique
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;

        //for every character
        for (int i = 0; i < s.length(); i++) {

            //find the odd length maximum expansion
            int len1 = expandAroundCenter(s, i, i);

            //find the even length maximum expansion
            int len2 = expandAroundCenter(s, i, i + 1);

            //find and store the maximum length
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;

        //expand till the end characters are same
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}