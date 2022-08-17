/*https://leetcode.com/problems/construct-smallest-number-from-di-string/*/

class Solution {
    public String smallestNumber(String pattern) {
        int i, n = pattern.length();
        char[] arr = new char[n+1];
        for (i = 1; i <= n+1; ++i)
            arr[i-1] = (char)(i+'0');
        int start = -1, end = -1;
        i = 0;
        while (i < n)
        {
            if (pattern.charAt(i) == 'D')
            {
                if (start == -1)
                    start = end = i;
                else
                    end = i;
            }
            else if (start != -1)
            {
                ++end;
                arr = reverse(start,end,arr);
                start = end = -1;
            }
            ++i;
        }
        if (start != -1)
        {
            ++end;
            arr = reverse(start,end,arr);
        }
        return new String(arr);
    }
    private char[] reverse(int s, int e, char[] a)
    {
        char temp;
        while (s < e)
        {
            temp = a[s];
            a[s] = a[e];
            a[e] = temp;
            ++s; --e;
        }
        return a;
    }
}