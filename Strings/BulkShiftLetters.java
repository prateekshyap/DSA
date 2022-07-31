/*https://binarysearch.com/problems/Bulk-Shift-Letters*/

import java.util.*;

class Solution {
    public String solve(String s, int[] shifts) {
        int n = s.length(), i;

        //postfix sum array
        for (i = n-2; i >= 0; --i)
            shifts[i] = (shifts[i+1]+(shifts[i]%26))%26;
        char ch;
        int val;

        //circular addition
        StringBuffer buffer = new StringBuffer("");
        for (i = 0; i < n; ++i)
        {
            ch = s.charAt(i);
            val = ch-'a';
            val = (val+shifts[i])%26;
            ch = (char)(val+'a');
            buffer.append(ch);
            // buffer.append((char)((((ch-'a')+post[i++])%26)+'a'));
        }
        return buffer.toString();
    }
}

import java.util.*;

class Solution {
    public String solve(String s, int[] shifts) {
        int n = s.length(), i;
        for (i = n-2; i >= 0; --i)
            shifts[i] = (shifts[i+1]+(shifts[i]%26))%26;
        StringBuffer buffer = new StringBuffer("");
        i = 0;
        for (char ch : s.toCharArray())
            buffer.append((char)(((ch-'a'+shifts[i++])%26)+'a'));
        return buffer.toString();
    }
}