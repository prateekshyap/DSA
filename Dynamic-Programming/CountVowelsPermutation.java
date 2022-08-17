/*https://leetcode.com/problems/count-vowels-permutation/*/

class Solution {
    private static final int m = (int)1e9+7;
    private static int[][] arr;
    Integer[][] table;
    public int countVowelPermutation(int n) {
        int result = 0;
        arr = new int[26][];
        int[] temp;
        for (int i = 0; i < 26; ++i)
        {
            if (i == 0) temp = new int[]{'e'-'a'};
            else if (i == 'e'-'a') temp = new int[]{0,'i'-'a'};
            else if (i == 'i'-'a') temp = new int[]{0,'e'-'a','o'-'a','u'-'a'};
            else if (i == 'o'-'a') temp = new int[]{'i'-'a','u'-'a'};
            else if (i == 'u'-'a') temp = new int[]{0};
            else temp = new int[0];
            arr[i] = temp;
        }
        table = new Integer[n+1][26];
        result = (result+count('a',n-1))%m;
        result = (result+count('e',n-1))%m;
        result = (result+count('i',n-1))%m;
        result = (result+count('o',n-1))%m;
        result = (result+count('u',n-1))%m;
        return result;
    }
    private int count(char prev, int rem)
    {
        if (rem == 0) return 1;
        if (table[rem][prev-'a'] != null) return table[rem][prev-'a'];
        int result = 0;
        
        int[] adj = arr[prev-'a'];
        for (int val : adj)
            result = (result+count((char)(val+'a'),rem-1))%m;
        table[rem][prev-'a'] = result;
        return result;
    }
}

class Solution {
    public int countVowelPermutation(int n) {
        int modulo = (int)(Math.pow(10, 9) + 7);
        int a = 1;
        int e = 1;
        int i = 1;
        int o = 1;
        int u = 1;
        
        for(int k = 2; k <= n; k++) {
            int newa = ((e + i)%modulo + u)%modulo;
            int newe = (a + i)%modulo;
            int newi = (e + o)%modulo;
            int newo = i;
            int newu = (i + o)%modulo;
            
            a = newa;
            e = newe;
            i = newi;
            o = newo;
            u = newu;
        }
        return (((((a + e)%modulo + i)%modulo) + o)%modulo + u)%modulo;
    }
}