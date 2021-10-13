/*https://leetcode.com/problems/counting-bits/*/

/*Prateekshya*/

class Solution {
    public int[] countBits(int n) {
        int[] table = new int[n+1];
        table[0] = 0;
        if (n == 0) return table;
        table[1] = 1;
        int len = 2;
        while (len <= n)
        {
            int i = 0, j = 0;
            for (i = 0, j = len; i < len && j < table.length; ++i, ++j)
                table[j] = table[i]+1;
            len *= 2;
        }
        return table;
    }
}