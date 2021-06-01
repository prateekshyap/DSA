/*https://practice.geeksforgeeks.org/problems/reverse-bits-1611130171/1/*/

class Solution
{
    public int reverseBits(int n)
    {
        int result = 0;
        while (n > 0)
        {
            result <<= 1;
            result += (n&1);
            n >>= 1;
        }
        return result;
    }
}