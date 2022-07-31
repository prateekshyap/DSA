/*https://binarysearch.com/problems/Palindrome-Splitting*/

import java.util.*;

class Solution {
    Integer[][] dp;
    public int solve(String s) {
        if (s.length() == 0) return 1;
        dp = new Integer[s.length()+1][s.length()+1];
        return recur(s,-1,-1,s.length());
    }
    public int recur(String s, int index, int last, int n)
    {
        if (index == n-1) //if whole string traversed
        {
            dp[index][last] = 1; //store 1
            return 1; //return 1
        }
        if (index!= -1 && last != -1 && dp[index][last] != null) return dp[index][last]; //return stored value in table
        int result = 0;
        for (int i = index+1; i < n; ++i) //for every next index
        {
            if (isPalindrome(s.substring(last+1,i+1))) //if the substring is palindrome
                result += recur(s, i, i, n); //recursion call
        }
        if (index != -1 && last != -1) dp[index][last] = result; //store the result
        return result; //return
    }
    public boolean isPalindrome(String s)
    {
        StringBuffer buffer = new StringBuffer(s);
        String newStr = new String(buffer.reverse());
        return s.equals(newStr);
    }
}