/*https://leetcode.com/problems/push-dominoes/*/

class Solution {
    public String pushDominoes(String dominoes) {
        char[] d = dominoes.toCharArray();
        int n = d.length, prevDomino = -1;
        for (int i = 0; i < n; ++i)
        {
            char c = d[i];
            if (c == 'L')
            {
                if (prevDomino == -1 || d[prevDomino] == 'L')
                {
                    for (int j = i-1; j > prevDomino; --j)
                        d[j] = 'L';
                }
                else
                {
                    int left = prevDomino+1;
                    int right = i-1;
                    while (left < right)
                    {
                        d[left++] = 'R';
                        d[right--] = 'L';
                    }
                }
                prevDomino = i;
            }
            else if (c == 'R')
            {
                if (prevDomino != -1 && d[prevDomino] == 'R')
                {
                    for (int j = i-1; j > prevDomino; --j)
                        d[j] = 'R';
                }
                prevDomino = i;
            }
        }
        if (prevDomino != -1 && d[prevDomino] == 'R')
        {
            for (int j = n-1; j > prevDomino; --j)
                d[j] = 'R';
        }
        return new String(d);
    }
}