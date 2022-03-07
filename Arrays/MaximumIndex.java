/*https://practice.geeksforgeeks.org/problems/maximum-index-1587115620/1*/

class Solution
{
    // A[]: input array
    // N: size of array
    // Function to find the maximum index difference.
    static int maxIndexDiff(int A[], int N)
    {
        // Your code here
        int[] maxFromRight = new int[N];
        int[] minFromLeft = new int[N];
        
        minFromLeft[0] = A[0];
        for (int i = 1; i < N; ++i)
            minFromLeft[i] = Math.min(minFromLeft[i-1],A[i]);
        maxFromRight[N-1] = A[N-1];
        for (int i = N-2; i >= 0; --i)
            maxFromRight[i] = Math.max(maxFromRight[i+1],A[i]);
        
        int left = 0, right = 0, diff = -1;
        while (left < N && right < N)
        {
            while (right < N && minFromLeft[left] <= maxFromRight[right])
            {
                ++right;
                diff = Math.max(diff,(right-1)-left);
            }
            while (left < N-1 && minFromLeft[left] == minFromLeft[left+1])
                ++left;
            ++left;
        }
        return diff;
    }
}