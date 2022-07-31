/*https://practice.geeksforgeeks.org/problems/count-palindrome-sub-strings-of-a-string0652/1/*/

class Solution
{
    public int CountPS(String s, int N)
    {
        //code here
        if (s == null || N < 1) return 0;
        int start = 0, end = 0, count = 0;

        //for every character
        for (int i = 0; i < s.length(); i++) {

            //find the odd length maximum expansion
            int len1 = expandAroundCenter(s, i, i);

            //find the even length maximum expansion
            int len2 = expandAroundCenter(s, i, i + 1);

            count += len1/2;
            count += len2/2;
        }
        return count;
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