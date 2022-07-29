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
            sum = Math.abs(a) > b ? subtract(Math.abs(a),b) : subtract(b,Math.abs(a));
            return Math.abs(a) > b ? sum*(-1) : sum;
        }
        if (b < 0)
        {
            sum = Math.abs(b) > a ? subtract(Math.abs(b),a) : subtract(a,Math.abs(b));
            return Math.abs(b) > a ? sum*(-1) : sum;
        }

        //for two positive numbers, simply add them
        return add(a,b);
    }
    public int add(int a, int b)
    {
    	//base cases
        if (a == 0 && b == 0) return 0;
        if ((a == 0 && b == 1) || (a == 1 && b == 0)) return 1;
        if ((a|b) == (a^b)) return a^b; //For the cases like (7,8),(15,16),(31,32) //might cover some additional cases as well
        
        int sum = 0, carry = 0, pos = 1;

        //till the numbers are not exhausted
        while (a > 0 || b > 0)
        {
        	//extract the rightmost bits
            int bit1 = a&1; a >>= 1;
            int bit2 = b&1; b >>= 1;

            /*get the sum and carry
            put the formula of addition of three bits*/
            int currSum = bit1^bit2;
            currSum ^= carry;
            
            int prevCarry = carry;
            carry = bit2&prevCarry;
            carry |= bit1&(bit2^prevCarry);
            
            currSum *= pos;
            pos <<= 1;

            //add it to the sum
            sum = add(sum, currSum);
        }

        //add the carry, if any
        if (carry > 0)
        {
            carry *= pos;
            sum ^= carry;
        }
        
        return sum;
    }
    public int subtract(int a, int b)
    {
        int diff = 0, borrow = 0, pos = 1;
        boolean isBorrowed = false;

        //till the numbers are not exhausted
        while (a > 0 || b > 0)
        {
        	//extract the rightmost bits
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

            //if borrow bit is non-zero, mark it
            if (borrow != 0) isBorrowed = true;
            
            currDiff *= pos;
            pos <<= 1;
            
            //add it to the difference
            diff = add(diff, currDiff);
        }

        return diff;
    }
}

/*Please add a better solution, if any*/
class Solution {
    public int getSum(int a, int b) {
        if(b==0)
            return a;
        return getSum(a^b,(a&b)<<1);
    }
}