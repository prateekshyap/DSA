/*https://practice.geeksforgeeks.org/problems/palindrome-string0817/1*/

class Solution {
    int isPalindrome(String S) {
        return checkPalindrome(S,0,S.length()-1);
    }
    public int checkPalindrome(String s, int l, int r)
    {
        //recursion should be stopped when l crosses r
        if (l >= r)
			return 1;

        //check the condition for palindrome
		if (s.charAt(l) != s.charAt(r))
			return 0;

        //recursively call the function for the next pair
		return checkPalindrome(s,l+1,r-1);
    }
}