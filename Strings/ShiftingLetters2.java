/*https://leetcode.com/problems/shifting-letters-ii/*/

class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        char[] a = s.toCharArray();
        int n = a.length, temp;
        long q;
        long[] changes = new long[n+1];
        for (int[] shift : shifts)
        {
            if (shift[2] == 0)
            {
                changes[shift[0]] += -1;
                changes[shift[1]+1] += 1; 
            }
            else
            {
                changes[shift[0]] += 1;
                changes[shift[1]+1] += -1; 
            }
        }
        for (int i = 1; i <= n; ++i)
        {
            changes[i] += changes[i-1];
            q = changes[i-1]/26;
            if (changes[i-1] <= -26)
                changes[i-1] += 26*(-(q-1));
            else if (changes[i-1] >= 26) changes[i-1] -= 26*q;
        }
        for (int i = 0; i < n; ++i)
        {
            temp = a[i]-'a';
            temp += changes[i];
            if (temp < 0) temp += 26;
            if (temp > 25) temp -= 26;
            a[i] = (char)(temp+'a');
        }
        return new String(a);
    }
}