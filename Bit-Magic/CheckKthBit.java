/*https://practice.geeksforgeeks.org/problems/check-whether-k-th-bit-is-set-or-not-1587115620/1*/

class CheckBit
{
    // Function to check if Kth bit is set or not.
    static boolean checkKthBit(int n, int k)
    {
        //right shit k-1 times
        while (k > 0)
        {
            n >>= 1;
            --k;
        }

        //if LSB is set, return true
        if ((n&1) == 1)
            return true;
        return false;
    }
}

class CheckBit
{
    // Function to check if Kth bit is set or not.
    static boolean checkKthBit(int n, int k)
    {
        // Your code here
        return (n&(1<<k)) > 0 ? true : false;
    }
    
}