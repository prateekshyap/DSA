/*https://binarysearch.com/problems/Add-Binary-Numbers*/

import java.util.*;

class Solution {
    public String solve(String a, String b) {
        StringBuffer buffer = new StringBuffer("");
        char carry = '0', sum;
        int i = a.length()-1, j = b.length()-1, sumVal;
        
        while (i >= 0 || j >= 0)
        {
            sumVal = getSum(i >= 0 ? a.charAt(i) : '0', j >= 0 ? b.charAt(j) : '0', carry);
            if (sumVal >= 2)
            {
                sumVal -= 2;
                carry = '1';
            }
            else carry = '0';
            sum = (char)('0'+sumVal);
            buffer.append(sum);
            --i; --j;
        }
        
        if (carry == '1') buffer.append('1');
        buffer.reverse();
        return buffer.toString();
    }

    public int getSum(char ch1, char ch2, char ch3)
    {
        if (ch1 == '0' && ch2 == '0' && ch3 == '0') return 0;
        if (ch1 == '0' && ch2 == '0' && ch3 == '1') return 1;
        if (ch1 == '0' && ch2 == '1' && ch3 == '0') return 1;
        if (ch1 == '0' && ch2 == '1' && ch3 == '1') return 2;
        if (ch1 == '1' && ch2 == '0' && ch3 == '0') return 1;
        if (ch1 == '1' && ch2 == '0' && ch3 == '1') return 2;
        if (ch1 == '1' && ch2 == '1' && ch3 == '0') return 2;
        return 3;
    }
}