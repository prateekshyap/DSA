/*https://practice.geeksforgeeks.org/problems/count-number-of-substrings4528/1*/

class Solution
{
    long substrCount (String S, int K) {
        // your code here
        return atMost(S,K)-atMost(S,K-1);
    }
    long atMost(String S, int K)
    {
        int[] hash = new int[26];
        int start = 0, end = 0;
        long count = 0;
        int distinctCount = 0, n = S.length();
        while (end < n)
        {
            ++hash[S.charAt(end)-'a'];
            if (hash[S.charAt(end)-'a'] == 1) ++distinctCount;
            while (distinctCount > K)
            {
                --hash[S.charAt(start)-'a'];
                if (hash[S.charAt(start)-'a'] == 0) --distinctCount;
                ++start;
            }
            if (distinctCount <= K) count += (end-start+1);
            ++end;
        }
        return count;
    }
}