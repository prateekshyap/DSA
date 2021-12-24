/*https://leetcode.com/problems/valid-palindrome-ii/*/

class Solution {
    public boolean validPalindrome(String s) {

    	//check if already palindrome
        StringBuffer buffer = new StringBuffer(s);
        int i = 0, j = s.length()-1, k = 0, l = 0;
        boolean flag = true;
        while (i <= j)
        {
            if (buffer.charAt(i) != buffer.charAt(j))
            {
                flag = false;
                break;
            }
            ++i; --j;
        }
        if (flag) return true;

        //delete the first mismatch and check
        buffer.delete(i,i+1);
        flag = true;
        k = 0;
        l = buffer.length()-1;
        while (k <= l)
        {
            if (buffer.charAt(k) != buffer.charAt(l))
            {
                flag = false;
                break;
            }
            ++k; --l;
        }
        if (flag) return true;

        //delete the second mismatch and check
        buffer = new StringBuffer(s);
        buffer.delete(j,j+1);
        flag = true;
        k = 0;
        l = buffer.length()-1;
        while (k <= l)
        {
            if (buffer.charAt(k) != buffer.charAt(l))
            {
                flag = false;
                break;
            }
            ++k; --l;
        }
        if (flag) return true;

        //return false at the end
        return false;
    }
}