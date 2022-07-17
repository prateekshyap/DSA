/*https://practice.geeksforgeeks.org/problems/31272eef104840f7430ad9fd1d43b434a4b9596b/1/*/

class Solution
{
    ArrayList<Integer> search(String pat, String S)
    {
        // your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        int i, j, prime = 137, hash = 1, pLen = pat.length(), sLen = S.length(), chars = 128, pHash = 0, sHash = 0;
        char[] s = S.toCharArray(), p = pat.toCharArray();
        for (i = 0; i < pLen-1; ++i)
            hash = (hash*chars)%prime; //hash^(patternlength-1)
        for (i = 0; i < pLen; ++i)
        {
            pHash = (chars*pHash+p[i])%prime;
            sHash = (chars*sHash+s[i])%prime;
        }
        for (i = 0; i <= sLen-pLen; ++i)
        {
            if (pHash == sHash)
            {
                for (j = 0; j < pLen; ++j)
                    if (p[j] != s[i+j])
                        break;
                if (j == pLen)
                    result.add(i+1);
            }
            if (i < sLen-pLen) sHash = (chars*(sHash-s[i]*hash)+s[i+pLen])%prime;
            if (sHash < 0) sHash += prime;
        }
        if (result.size() == 0) result.add(-1);
        return result;
    }
}