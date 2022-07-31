/*https://practice.geeksforgeeks.org/problems/maximum-subset-xor/1/*/

class Solution
{
    public static int maxSubarrayXOR(int arr[], int N)
    {
        //add code here.
        if (N == 0) return 0;
        int num = 0, max = 0, i;
        while (true)
        {
            max = Integer.MIN_VALUE;
            for (i = 0; i < N; ++i)
                if (max < arr[i])
                    max = arr[i];
            if (max == 0) return num;
            num = Math.max(num,num^max);
            for(i = 0; i < N; ++i)
                arr[i] = Math.min(arr[i],arr[i]^max);
        }
    }
}