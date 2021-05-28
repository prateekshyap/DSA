/*https://practice.geeksforgeeks.org/problems/bit-difference-1587115620/1*/

class Solution{
    public static int countBitsFlip(int a, int b){
        //find the xor
        int xor = a^b;
        int count = 0;

        //find the number of set bits in xor
        while (xor > 0)
        {
            if ((xor&1) == 1)
                ++count;
            xor >>= 1;
        }
        return count;
    }
}