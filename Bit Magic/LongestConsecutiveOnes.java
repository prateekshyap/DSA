/*https://practice.geeksforgeeks.org/problems/longest-consecutive-1s-1587115620/1*/

class Solution{
    
    /*  Function to calculate the longest consecutive ones
    *   N: given input to calculate the longest consecutive ones
    */
    public static int maxConsecutiveOnes(int N) {
        int counter = 0, max = 0;

        //run from LSB to MSB
        while ( N > 0 )
        {
            //if LSB is 1, increment counter
            if ((N&1) == 1)
                ++counter;

            //update max, set counter to zero
            else
            {
                max = Math.max(max,counter);
                counter = 0;
            }

            //right shift N
            N >>= 1;
        }

        //update max and return
        max = Math.max(max,counter);
        return max;
    }
}