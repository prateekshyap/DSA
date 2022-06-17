/*https://binarysearch.com/problems/Minimum-Updates-to-Make-Bitwise-OR-Equal-to-Target*/

import java.util.*;

class Solution {
    public int solve(int a, int b, int target) {
        char[] targetStr = Integer.toBinaryString(target).toCharArray();
        char[] aStr = Integer.toBinaryString(a).toCharArray();
        char[] bStr = Integer.toBinaryString(b).toCharArray();

        int i, j, k, limit = Math.max(targetStr.length,Math.max(aStr.length,bStr.length)), count = 0;

        targetStr = append(targetStr,limit);
        aStr = append(aStr,limit);
        bStr = append(bStr,limit);

        i = j = k = 0;

        while (i < limit)
        {
            if (targetStr[i] == '1' && aStr[j] == '0' && bStr[k] == '0') ++count;
            else if (targetStr[i] == '0' && !(aStr[j] == '0' && bStr[k] == '0'))
            {
                if (aStr[j] == '1') ++count;
                if (bStr[k] == '1') ++count;
            }
            ++i; ++j; ++k;
        }

        return count;
    }
    public char[] append(char[] arr, int limit)
    {
        int i, j;
        char[] temp = new char[limit];
        for (i = 0; i < limit; ++i)
            temp[i] = '0';
        j = limit-1;
        for (i = arr.length-1; i >= 0; --i)
            temp[j--] = arr[i];
        return temp;
    }
}

import java.util.*;

class Solution {
    public int solve(int a, int b, int target) {
        int count = 0;
        int aBit, bBit, targetBit;

        while (a > 0 || b > 0 || target > 0)
        {
            aBit = a&1;
            bBit = b&1;
            targetBit = target&1;

            if (targetBit == 1 && aBit == 0 && bBit == 0) ++count;
            else if (targetBit == 0 && !(aBit == 0 && bBit == 0)) count += aBit+bBit;

            a >>= 1;
            b >>= 1;
            target >>= 1;
        }
        return count;
    }
}