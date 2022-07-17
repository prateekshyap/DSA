/*https://practice.geeksforgeeks.org/problems/search-pattern0205/1*/

class Solution
{
    ArrayList<Integer> search(String pat, String txt)
    {
        // your code here
        int i = 1, j = 0, lpsLen = 0, pLen = pat.length(), tLen = txt.length();
        int[] lps = new int[pLen];
        char[] p = pat.toCharArray(), t = txt.toCharArray();
        ArrayList<Integer> result = new ArrayList<Integer>();
        while (i < pLen)
        {
            if (p[i] == p[lpsLen])
                lps[i++] = ++lpsLen;
            else if (lpsLen != 0)
                lpsLen = lps[lpsLen-1];
            else lps[i++] = lpsLen;
        }
        i = 0;
        while (i < tLen)
        {
            if (p[j] == t[i])
            {
                ++i;
                ++j;
            }
            if (j == pLen)
            {
                result.add(i-pLen+1);
                j = lps[j-1];
            }
            else if (i < tLen && p[j] != t[i])
            {
                if (j != 0)
                    j = lps[j-1];
                else ++i; 
            }
        }
        if (result.size() == 0) result.add(-1);
        return result;
    }
}