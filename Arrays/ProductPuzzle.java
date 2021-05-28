

class Solution 
{ 
    public static long[] productExceptSelf(int nums[], int n) 
    { 
        long product = 1;
        long[] arr = new long[n];
        int zeroCount = 0;
        for (int i = 0; i < n; ++i)
        {
            //if element is not zero, multiply 
            if (nums[i] != 0)
                product *= nums[i];

            //if zero
            else
            {
                //increase the count
                ++zeroCount;

                //if mroe than one zeroes, return array containing zeroes
                if (zeroCount > 1)
                    return arr;
            }
        }
        for (int i = 0; i < n; ++i)

            //if one zero present
            if (zeroCount > 0)

                //everything will be zero apart from the index containing zero
                arr[i] = (nums[i] == 0 ? product : 0);

            //otherwise, normal division
            else
                arr[i] = product/nums[i];
        return arr;
    } 
} 