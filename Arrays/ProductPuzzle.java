/*https://leetcode.com/problems/product-of-array-except-self/*/

/*Prateekshya*/

/*With extra space*/

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

/*Without extra space*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeroCount = 0, zeroIndex = -1, totalProduct = 1;

        //count zeros, update total product except zeros
        for (int i = 0; i < nums.length; ++i)
        {
            if (nums[i] == 0)
            {
                ++zeroCount;
                zeroIndex = i;
            }
            else
                totalProduct *= nums[i];
            if (zeroCount > 1)
                break;
        }

        //if more than one zeros, set everything to 0 and return
        if (zeroCount > 1)
        {
            for (int i = 0; i < nums.length; ++i)
                nums[i] = 0;
            return nums;
        }

        //if a single zero, update everything to 0 apart from that index
        else if (zeroCount == 1)
        {
            for (int i = 0; i < nums.length; ++i)
                nums[i] = 0;
            nums[zeroIndex] = totalProduct;
            return nums;
        }

        //general case
        for (int i = 0; i < nums.length; ++i)
            nums[i] = totalProduct/nums[i];

        return nums;
    }
}