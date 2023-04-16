/*https://leetcode.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary/*/

class Solution {
    public int numWays(String[] words, String target) {
        int n = target.length(), k = words[0].length();
        int[][] freqs = new int[26][k];
        for (String word: words)
            for (int j = 0; j < k; ++j)
                ++freqs[word.charAt(j)-'a'][j];
        Long[][] table = new Long[n+1][k+1];
        return (int)recur(target, freqs, n, k, table);
    }
    private long recur(String target, int[][] freqs, int i, int j, Long[][] table)
    {
        if (j == 0)
            return i == 0 ? 1 : 0;
        if (table[i][j] != null)
            return table[i][j];
        table[i][j] = recur(target, freqs, i, j-1, table);
        if (i > 0)
        {
            table[i][j] += freqs[target.charAt(i-1)-'a'][j-1]*recur(target,freqs,i-1,j-1,table);
            table[i][j] %= (int)1e9+7;
        }
        return table[i][j];
    }
}