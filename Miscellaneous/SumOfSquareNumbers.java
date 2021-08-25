/*https://leetcode.com/problems/sum-of-square-numbers/*/

/*My solution*/
class Solution
{
    public boolean judgeSquareSum(int c)
    {
        if (c == 0 || c == 1) return true; //true for 0 or 1
        if ((int)Math.sqrt(c) == Math.sqrt(c)) return true; // true if the number is whole square
        int sum = 1, nextVal = 3, copy = c;
        while (sum <= c/2) //till sum is less than c/2
        {
            if (sum == copy) return true; //true if sum and copy are same
            copy -= sum; //subtract sum from copy
            if ((int)Math.sqrt(copy) == Math.sqrt(copy)) return true; //true if copy is whole square
            copy = c; //copy the given number again
            sum += nextVal; //get the next whole square
            nextVal += 2; //add 2 to next value
        }
        return false; //false for all other cases
    }
}

/*Fermat's theorem*/
class Solution {
    public boolean judgeSquareSum(int c) {
        //fermat's theorem
        for(int i=2; i*i<=c; i++) {
            int count = 0;
            if(c%i == 0) {
                while(c%i == 0) {
                    count++;
                    c = c/i;
                }
                if( i%4 == 3 && count%2 != 0) return false;
            }
        }
        return c%4 != 3;
    }
}