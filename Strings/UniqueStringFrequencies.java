/*https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/*/
/*https://binarysearch.com/problems/Unique-String-Frequencies*/

class Solution {
    public int minDeletions(String s) {
        int[] hash = new int[26];
        int i, n = s.length();
        for (i = 0; i < n; ++i)
            ++hash[s.charAt(i)-'a'];
        int[] freq = new int[n+1];
        for (i = 0; i < 26; ++i)
            ++freq[hash[i]];
        int result = 0, val, max = -1;
        // for (i = 0; i < 26; ++i)
        //     System.out.print(hash[i]+" ");
        // System.out.println();
        // for (i = 0; i < n+1; ++i)
        //     System.out.print(freq[i]+" ");
        // System.out.println();
        for (i = n-1; i > 0; --i)
        {
            if (freq[i] > 1)
            {
                result += freq[i]-1;
                freq[i-1] += freq[i]-1;
            }
        }

        return result;
    }
}