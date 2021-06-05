/*https://leetcode.com/problems/valid-palindrome/*/

class Solution {
    int i;
    boolean[] status;
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        boolean flag = false;
        i = 0;
        status = new boolean[s.length()];

        //if the string contains no alphanumeric characters, simply return true
        for (i= 0; i < s.length(); ++i)
        {
            if (isFeasible(s,i))
            {
                status[i] = true;
                flag = true;
                break;
            }
        }
        if (!flag)
            return true;

        //check for palindrome
        return checkPalindrome(s,0,s.length()-1);
    }
    public boolean checkPalindrome(String s, int l, int r) {
        if (l >= r)
			return true;

        //skip the non-alphanumeric characters
        while (l < s.length() && ((l <= i && !status[l]) || !isFeasible(s,l)))
            ++l;
        while (r >= 0 && ((r <= i && !status[r]) || !isFeasible(s,r)))
            --r;

        //normal approach
		if (s.charAt(l) != s.charAt(r))
			return false;
        
        return checkPalindrome(s,l+1,r-1);
    }
    public boolean isFeasible(String s, int index)
    {
        //if alphabet, return true
        if ((int)s.charAt(index) >= 97 && (int)s.charAt(index) <= 122)
            return true;

        //if digit, return true
        if ((int)s.charAt(index) >= 48 && (int)s.charAt(index) <= 57)
            return true;

        return false;
    }
}