/*practice.geeksforgeeks.org/problems/count-total-set-bits-1587115620/1*/

//A simple vertical counting technique

/*
* If we travel vertically downwards, the pattern is as follows
* 0 0 0 0 - 0
* 0 0 0 1 - 1
* 0 0 1 0 - 2
* 0 0 1 1 - 3
* 0 1 0 0 - 4
* 0 1 0 1 - 5
* 0 1 1 0 - 6
* 0 1 1 1 - 7
* 1 0 0 0 - 8
* 1 0 0 1 - 9
* 1 0 1 0 - 10
* 1 0 1 1 - 11
* 1 1 0 0 - 12
* ...
* For LSB -  0 1 0 1 ..... (repetition pattern is 0 1)
* For next MSB - 0 0 1 1 0 0 1 1 0 ..... (repetition pattern is 0 0 1 1)
* For next MSB - 0 0 0 0 1 1 1 1 0 0 0 .... (repetition pattern is 0 0 0 0 1 1 1 1)
* and so on.
*/

class Solution{
    public static int countSetBits(int n)
    {
        int noOfBits = 0;
        int copy = n;
        int count = 0;

        //find the total number of bits in n
        while (copy > 0)
        {
            copy = copy >> 1;
            noOfBits++;
        }

        //start from the LSB column
        int iterator = 1;

        //run towards MSB and for every column repeat
        while (iterator <= noOfBits)
        {
        	//find out the repetition pattern size
            int setSize = (int)Math.pow(2,iterator);

            //find out how many such complete patterns are there till n
            int sets = n/setSize;

            //since in each pattern we have equal number of 0s and 1s
            //add half of the pattern size for every pattern
            count += sets*(setSize/2);

            //find out the last incomplete pattern size
            int rem = n-(sets*setSize);

            //since the first half of every pattern contains only zero
            //if the incomplete pattern size is greater than first half size
            if (rem >= (setSize/2))

            	//add required number of 1s
            	//+1 because we start from 0 and not 1
                count += (rem-(setSize/2))+1;

            //go for next more significant bit
            ++iterator;
        }

        return count;
    }
}