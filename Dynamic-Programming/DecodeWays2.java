/*https://leetcode.com/problems/decode-ways-ii/*/

class Solution {
    int n;
    Long[][] table;
    int m = (int)1e9+7;
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        n = s.length();
        table = new Long[n+1][10];
        table[0][0] = count(s.toCharArray(),0,0);
        return table[0][0].intValue();
    }
    private long count(char[] s, int index, int prev)
    {
        if (index == n) return 1l;
        if (table[index][prev] != null) return table[index][prev];
        int curr;
        
        table[index][prev] = 0l;
        
        if (s[index] != '*')
        {
            curr = s[index]-'0';
            if (curr != 0) //if it is non-zero i.e. 1,2,...9 , it can be decoded to some character
                table[index][prev] += count(s,index+1,curr); //hence go for recursion call with next index
            else return table[index][prev]; //if zero, return zero

            if (index < n-1) //if we have not reached the last index
            {
                if (s[index+1] != '*')
                {
                    curr = curr*10+s[index+1]-'0'; //add the next character
                    if (curr <= 26) //if the value is within the limit
                        table[index][prev] += count(s,index+2,s[index+1]-'0'); //then two characters can be decoded to some letter between k to z, hence go for recursion call with second next index
                }
                else
                {
                    int next;
                    for (int i = 1; i <= 9; ++i)
                    {
                        next = curr*10+i;
                        if (next <= 26)
                            table[index][prev] += count(s,index+2,i);
                    }
                }
            }
        }
        else
        {
            for (int i = 1; i <= 9; ++i)
            {
                curr = i;
                if (curr != 0) //if it is non-zero i.e. 1,2,...9 , it can be decoded to some character
                    table[index][prev] += count(s,index+1,curr); //hence go for recursion call with next index
                else return table[index][prev]; //if zero, return zero

                if (index < n-1) //if we have not reached the last index
                {
                    if (s[index+1] != '*')
                    {
                        curr = curr*10+s[index+1]-'0'; //add the next character
                        if (curr <= 26) //if the value is within the limit
                            table[index][prev] += count(s,index+2,s[index+1]-'0'); //then two characters can be decoded to some letter between k to z, hence go for recursion call with second next index
                    }
                    else
                    {
                        int next;
                        for (int j = 1; j <= 9; ++j)
                        {
                            next = curr*10+j;
                            if (next <= 26)
                                table[index][prev] += count(s,index+2,j);
                        }
                    }
                }
            }
        }
        
        return table[index][prev] %= m;
    }
}

public class Solution {
    int M = 1000000007;
    Long[] memo;
    public int numDecodings(String s) {
        memo = new Long[s.length()];
        return (int) ways(s.toCharArray(), s.length() - 1);
    }
    public long ways(char[] s, int i) {
        if (i < 0)
            return 1;
        if (memo[i] != null)
            return memo[i];
        if (s[i] == '*')
        {
            long res = 9 * ways(s, i - 1) % M;
            if (i > 0 && s[i-1] == '1')
                res = (res + 9 * ways(s, i - 2)) % M;
            else if (i > 0 && s[i-1] == '2')
                res = (res + 6 * ways(s, i - 2)) % M;
            else if (i > 0 && s[i-1] == '*')
                res = (res + 15 * ways(s, i - 2)) % M;
            memo[i] = res;
            return memo[i];
        }
        long res = s[i] != '0' ? ways(s, i - 1) : 0;
        if (i > 0 && s[i-1] == '1')
            res = (res + ways(s, i - 2)) % M;
        else if (i > 0 && s[i-1] == '2' && s[i] <= '6')
            res = (res + ways(s, i - 2)) % M;
        else if (i > 0 && s[i-1] == '*')
            res = (res + (s[i] <= '6' ? 2 : 1) * ways(s, i - 2)) % M;
        memo[i] = res;
        return memo[i];
    }
}