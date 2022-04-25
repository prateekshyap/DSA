/*https://practice.geeksforgeeks.org/problems/substrings-of-length-k-with-k-1-distinct-elements/1#*/

class Solution {
    static int countOfSubstrings(String S, int K) {
        // code here
        int i, uniqueCount = 0, substringCount = 0, N = S.length();
        int[] hash = new int[26];
        for (i = 0; i < K; ++i)
        {
            ++hash[S.charAt(i)-'a'];
            if (hash[S.charAt(i)-'a'] == 1) ++uniqueCount;
        }
        if (uniqueCount == K-1) ++substringCount;
        for (i = K; i < N; ++i)
        {
            --hash[S.charAt(i-K)-'a'];
            if(hash[S.charAt(i-K)-'a'] == 0) --uniqueCount;
            ++hash[S.charAt(i)-'a'];
            if(hash[S.charAt(i)-'a'] == 1) ++uniqueCount;
            if (uniqueCount == K-1) ++substringCount;
        }
        return substringCount;
    }
}