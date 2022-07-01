/*https://practice.geeksforgeeks.org/problems/smallest-sum-contiguous-subarray/1/*/

class Solution
{
    static int smallestSumSubarray(int a[], int size)
    {
        // your code here
        int i, minSoFar = a[0], min = a[0];
        
        for (i = 1; i < size; ++i)
        {
            minSoFar = Math.min(minSoFar+a[i],a[i]);
            min = Math.min(min,minSoFar);
        }
        
        return min;
    }
}