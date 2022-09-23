/*https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/*/

//TLE
class Solution {
    private static final int m = (int)(1e9+7);
    public int concatenatedBinary(int n) {
        long value = 1, result = 0;
        while (n > 0)
        {
            int copy = n--;
            while (copy > 0)
            {
                int digit = copy%2;
                copy /= 2;
                result += (value*digit);
                result %= m;
                value *= 2;
                value %= m;
            }
        }
        return (int)result;
    }
}

//Accepted
class Solution {
    private static final int m = (int)(1e9+7);
    public int concatenatedBinary(int n) {
        long value = 1, result = 1;
        for (int num = 2; num <= n; ++num)
        {
            int digits = (int)Math.ceil(Math.log(num+1)/Math.log(2));
            result <<= digits;
            result += num;
            result %= m;
        }
        return (int)result;
    }
}

//smart
class Solution {
    private static final int m = (int)(1e9+7);
    public int concatenatedBinary(int n) {
        Set<Integer> set = Set.of(2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536);
        long digits = 1, result = 1;
        for (int num = 2; num <= n; ++num)
        {
            if (set.contains(num)) ++digits;
            result <<= digits;
            result += num;
            result %= m;
        }
        return (int)result;
    }
}

//smart and efficient
class Solution {
    private static final int m = (int)(1e9+7);
    public int concatenatedBinary(int n) {
        long digits = 1, result = 1;
        for (int num = 2; num <= n; ++num)
        {
            if ((num&(num-1)) == 0) ++digits;
            result <<= digits;
            result += num;
            result %= m;
        }
        return (int)result;
    }
}