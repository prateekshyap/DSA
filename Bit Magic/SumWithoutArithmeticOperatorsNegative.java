/*https://leetcode.com/problems/sum-of-two-integers/*/

/*Prateekshya*/

class Solution {
    public int getSum(int a, int b)
    {
        int sum = 0;

        //if both the numbers are negative
        if (a < 0 && b < 0)
        {
        	//add the absoluate values and return by multiplying -1
            sum = add(Math.abs(a), Math.abs(b));
            return sum*(-1);
        }

        //if one of them is negative, subtract the smaller from the bigger and put sign accordingly
        if (a < 0)
        {
            if (Math.abs(a) > b)
            {
                sum = subtract(Math.abs(a),b);
                return sum*(-1);
            }
            else
            {
                sum = subtract(b,Math.abs(a));
                return sum;
            }
        }
        if (b < 0)
        {
            if (Math.abs(b) > a)
            {
                sum = subtract(Math.abs(b),a);
                return sum*(-1);
            }
            else
            {
                sum = subtract(a,Math.abs(b));
                return sum;
            }
        }

        //for two positive numbers, simply add them
        return add(a,b);
    }
    public int add(int a, int b)
    {
        int sum = 0, carry = 0, power = 0;

        //till the numbers are not exhausted
        while (a > 0 || b > 0)
        {
        	//get the rightmost bits
            int bit1 = a&1; a >>= 1;
            int bit2 = b&1; b >>= 1;

            //get the sum and carry
            int currSum = bit1^bit2;
            currSum += carry;
            carry = bit1&bit2;
            currSum *= Math.pow(2,power);
            ++power;

            //add it to the sum
            sum += currSum;
        }

        //add the carry, if any
        if (carry > 0)
        {
            carry *= Math.pow(2,power);
            sum += carry;
        }
        
        return sum;
    }
    public int subtract(int a, int b)
    {
        int diff = 0, borrow = 0, power = 0;
        boolean isBorrowed = false;

        //till the numbers are not exhausted
        while (a > 0 || b > 0)
        {
        	//get the rightmost bits
            int bit1 = a&1; a >>= 1;
            int bit2 = b&1; b >>= 1;
            
            //if some bit is previously borrowed and the current bit is 1
            if (isBorrowed && bit1 == 1)
            {
            	//make it 0 and mark borrow marker as false
                bit1 = 0;
                isBorrowed = false;
            }
            //if some bit is previously borrowed and the current bit is 0
            else if (isBorrowed && bit1 == 0)
            {
            	//make it 1
                bit1 = 1;
            }
                
            //get the difference and borrow
            int currDiff = bit1^bit2;
            borrow = (~bit1)&bit2;
            if (borrow != 0) isBorrowed = true;
            
            currDiff *= Math.pow(2,power);
            ++power;
            
            //add it to the difference
            diff += currDiff;
        }

        return diff;
    }
}

/*Please add a better solution, if any*/