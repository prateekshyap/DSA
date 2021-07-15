/*https://practice.geeksforgeeks.org/problems/nth-natural-number/1*/

//just convert to base 9 number :P
class Solution {
    long findNth(long N)
    {
        if (N < 9) return N;
        long result = 0;
        int power = 0;
        while (N > 0)
        {
            result = (long)((N%9)*Math.pow(10,power++))+result;
            N /= 9;
        }
        return result;
    }
}