/*
https://binarysearch.com/problems/Lexicographically-Smallest-Non-Palindromic-String
https://leetcode.com/problems/break-a-palindrome/

1328. Break a Palindrome

*/

class Solution {
public:
    string breakPalindrome(string s) {
        int n = s.length();
        if(n==1)
            return "";
        int half = (n%2 == 0)? n/2 : n/2-1;

        for(int i=0; i<=half; i++)
        {
            if(s[i] != 'a')
            {   
                s[i] = 'a';
                return s;
            }

        }
        s[n-1] = 'b';
        return s;
    }
};