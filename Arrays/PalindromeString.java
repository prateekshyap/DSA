/*https://practice.geeksforgeeks.org/problems/palindrome-string0817/1*/

class Solution {
    int isPalindrome(String S) {
        // code here
        return checkPalindrome(S,0,S.length()-1);
    }
    public int checkPalindrome(String s, int l, int r)
    {
        if (l >= r)
			return 1;
		if (s.charAt(l) != s.charAt(r))
			return 0;
		return checkPalindrome(s,l+1,r-1);
    }
};