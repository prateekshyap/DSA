/*https://leetcode.com/problems/3sum-with-multiplicity/*/

class Solution {
    public int threeSumMulti(int[] arr, int target) {
        int m = (int)1e9+7;
        long[] count = new long[101];
        for (int num : arr)
            ++count[num];
        
        long result = 0;
        int a, b, c;
        for (a = 0; a <= 100; ++a)
        {
            for (b = a+1; b <= 100; ++b)
            {
                c = target-a-b;
                if (b < c && c <= 100)
                {
                    result += count[a]*count[b]*count[c];
                    result %= m;
                }
            }
        }
        for (a = 0; a <= 100; ++a)
        {
            c = target-2*a;
            if (a < c && c <= 100 && count[a] >= 2)
            {
                result += count[a]*(count[a]-1)*count[c]/2;
                result %= m;
            }
        }
        for (a = 0; a <= 100; ++a)
        {
            if ((target-a)%2 == 0)
            {
                c = (target-a)/2;
                if (a < c && c <= 100 && count[c] >= 2)
                {
                    result += count[a]*count[c]*(count[c]-1)/2;
                    result %= m;
                }
            }
        }
        if (target%3 == 0)
        {
            a = target/3;
            if (0 <= a && a <= 100 && count[a] >= 3)
            {
                result += count[a]*(count[a]-1)*(count[a]-2)/6;
                result %= m;
            }
        }
        
        return (int)result;
    }
}