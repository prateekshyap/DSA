/*https://leetcode.com/problems/sum-of-number-and-its-reverse/*/

class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        if (num == 1) return false;
        if (num == 2) return true;
        if (num == 3) return false;
        double half = (double)num/2;
        int l = 0, r = 0;
        if (num%2 == 0)
        {
            if (num <= 18) return true;
            int copy = (int)half;
            int rev = 0;
            while (copy > 0)
            {
                rev = (rev*10)+(copy%10);
                copy /= 10;
            }
            if (rev == num) return true;
            l = (int)half-1;
            r = (int)half+1;
        }
        else
        {
            l = (int)(half-0.5);
            r = (int)(half+0.5);
        }
        int ls = 1, re = num-1;
        while (l >= ls && r <= re)
        {
            // System.out.println(l+" "+r);
            if (reverse(r) == l) return true;
            --l; ++r;
        }
        return false;
    }
    private int reverse(int num)
    {
        int rev = 0;
        while (num > 0)
        {
            rev = rev*10+(num%10);
            num /= 10;
        }
        return rev;
    }
}

