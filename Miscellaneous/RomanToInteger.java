/*https://binarysearch.com/problems/Roman-Numeral-to-Integer*/

import java.util.*;

class Solution {
	HashMap<Character,Integer> map;
    public int solve(String numeral) {
    	map = new HashMap<Character,Integer>();
        map.put('I',0);
        map.put('V',1);
        map.put('X',2);
        map.put('L',3);
        map.put('C',4);
        map.put('D',5);
        map.put('M',6);
        map.put('N',-1);
        char[] arr = numeral.toCharArray();
        int n = arr.length, i;
        int maxIndex = getMaxIndex(arr), prevMax = -1;
        long result = 0;
        for (i = 0; i < n; ++i)
        {
            maxIndex = getMaxIndex(arr);
            if (prevMax == -1 || maxIndex > prevMax)
                result += value(arr[maxIndex]);
            else
                result -= value(arr[maxIndex]);
            arr[maxIndex] = 'N';
            prevMax = maxIndex;
        }

        return (int)result;
    }
    public int getMaxIndex(char[] arr)
    {
        int max = 0;
        for (int i = 0; i < arr.length; ++i)
        {
            if (map.get(arr[i]) > map.get(arr[max]))
                max = i;
        }
        return max;
    }
    public int value(char ch)
    {
        if (ch == 'I') return 1;
        if (ch == 'V') return 5;
        if (ch == 'X') return 10;
        if (ch == 'L') return 50;
        if (ch == 'C') return 100;
        if (ch == 'D') return 500;
        return 1000;
    }
}

import java.util.*;

class Solution {
    public int solve(String str) {
        int res = 0, i, n = str.length(), val, nextVal;
 
        for (i = 0; i < n; ++i)
        {
            val = value(str.charAt(i));
 
            if (i+1 < str.length()) 
            {
                nextVal = value(str.charAt(i+1));

                if (val >= nextVal) res += val
                else
                {
                	res += nextVal-val;
                	++i;
                }
            }
            else res += val;
        }
 
        return res;
    }

    int value(char r)
    {
        if (r == 'I') return 1;
        if (r == 'V') return 5;
        if (r == 'X') return 10;
        if (r == 'L') return 50;
        if (r == 'C') return 100;
        if (r == 'D') return 500;
        return 1000;
    }
}