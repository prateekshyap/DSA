/*https://binarysearch.com/problems/Lexicographically-Smallest-String-of-Distance-K*/


import java.util.*;

class Solution {
    public String solve(int n, int k) {
        int zCount = 0, aCount = 0, letter = 0;
        StringBuffer buffer = new StringBuffer("");
        while (n > 26 && k <= n-26)
        {
            n -= 26;
            ++zCount;
            --k;
        }
        while (k != 1)
        {
            buffer.append("a");
            --n;
            --k;
        }
        buffer.append((char)(n-1+'a'));
        while (zCount != 0)
        {
            buffer.append("z");
            --zCount;
        }
        return buffer.toString();
    }
}

import java.util.*;

class Solution {
    public String solve(int n, int k) {
        n -= k;
        int zCount = 0, aCount = 0, letter = 0;
        StringBuffer buffer = new StringBuffer("");
        while (n > 25)
        {
            n -= 25;
            ++zCount;
            --k;
        }
        letter += n;
        --k;
        while (k != 0)
        {
            buffer.append("a");
            --k;
        }
        buffer.append((char)(letter+'a'));
        while (zCount != 0)
        {
            buffer.append("z");
            --zCount;
        }
        return buffer.toString();
    }
}

import java.util.*;

class Solution {
    public String solve(int n, int k) {
        n = n-k;
        char ans[] = new char[k];
        int len = k-1;
        while (true)
        {
            if (n > 25)
            {
                n = n-25;
                ans[len--] = (char)(25+'a');
            }
            else
            {
                ans[len--] = (char)(n+'a');
                break;
                
            }
        }
        while (len >= 0) ans[len--] = (char)('a');
        return new String(ans);
    }
}

import java.util.*;

class Solution {
    public String solve(int n, int k) {
        char[] s = new char[k];
        n -= k;
        Arrays.fill(s, 'a');
        for (int i = k-1; i >= 0 && n > 0; --i)
        {
            int use = Math.min(n, 25);
            s[i] += use;
            n -= use;
        }
        return new String(s);
    }
}

