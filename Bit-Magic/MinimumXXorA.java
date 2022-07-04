/*https://practice.geeksforgeeks.org/problems/x-xor-a-is-minimum-and-set-bits-in-x-b/1*/

class Solution {
    public static int minVal(int a, int b) {
        // code here
        int aBitCount = 0, bBitCount = 0, aCopy = a, bCopy = b, i, diff = 0, result = 0;
        //count bits of b
        while (bCopy > 0)
        {
            bBitCount += (bCopy&1);
            bCopy >>= 1;
        }
        //count bits of a
        while (aCopy > 0)
        {
            aBitCount += (aCopy&1);
            aCopy >>= 1;
        }
        //if bits are same, return a
        if (aBitCount == bBitCount) return a;
        char[] aBits = Integer.toBinaryString(a).toCharArray(); //convert to binary array
        if (aBitCount > bBitCount) //if number of bits in a is greater than number of bits in b
        {
            diff = aBitCount-bBitCount; //get the difference
            i = aBits.length-1; //start from last index
            while (i >= 0 && diff > 0) //till the end
            {
                if (aBits[i] == '1') //if current bit is 1
                {
                    aBits[i] = '0'; //change it to 0
                    --diff; //reduce the difference
                }
                --i; //reduce the index
            }
        }
        else if (bBitCount > aBitCount) //if number of bits in b is greater than number of bits in a
        {
            diff = bBitCount-aBitCount; //get the difference
            i = aBits.length-1; //start from last index
            while (i >= 0 && diff > 0) //till the end
            {
                if (aBits[i] == '0') //if current bit is 0
                {
                    aBits[i] = '1'; //change it to 1
                    --diff; //reduce the difference
                }
                --i; //reduce the index
            }
        }
        i = 0; //start from the beginning
        while (i < aBits.length) //convert to integer
        {
            result *= 2;
            result += aBits[i++]-'0';
        }
        while (diff > 0) //till difference is non-zero, keep adding 1
        {
            result *= 2;
            result += 1;
            --diff;
        }
        return result;
    }
}