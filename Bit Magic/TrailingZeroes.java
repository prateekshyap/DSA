/*https://practice.geeksforgeeks.org/problems/trailing-zeroes-in-factorial5134/1*/

class Solution {
    static int trailingZeroes(int N){
        int i = 5, result = 0;
        while (Math.floor(N/i) > 0)
        {
            result += Math.floor(N/i);
            i *= 5;
        }
        return result;
    }
}