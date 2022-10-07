/*https://leetcode.com/problems/ugly-number-iii*/

class Solution {
    int max = (int)2e9;
    long lcmAB, lcmBC, lcmAC, lcmABC;
    public int nthUglyNumber(int n, int a, int b, int c) {
        int low = 0, high = max, result = 0;
        lcmAB = lcm(a,b);
        lcmBC = lcm(b,c);
        lcmAC = lcm(a,c);
        lcmABC = lcm(a,lcmBC);
        while (low <= high)
        {
            int mid = low+(high-low)/2;
            if ((int)(mid/a+mid/b+mid/c-mid/lcmAB-mid/lcmBC-mid/lcmAC+mid/lcmABC) >= n)
            {
                result = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return result;
    }

    private long lcm(long a, long b)
    {
        return a * b / gcd(a, b);
    }

    private long gcd(long a, long b)
    {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
}