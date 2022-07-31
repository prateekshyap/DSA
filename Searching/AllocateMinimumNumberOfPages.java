/*https://practice.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1/*/

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        //Your code here
        int totalPages = 0, i, result = -1, max = -1;
        if (N < M) return -1;
        for (i = 0; i < N; ++i)
        {
            totalPages += A[i];
            if (A[i] > max) max = A[i];
        }
        
        int low = max, high = totalPages, mid;
        boolean isPossible = false;
        while (low <= high)
        {
            mid = low+((high-low)/2);
            isPossible = checkPossibility(A,N,M,mid);
            if (isPossible)
            {
                result = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return result;
    }
    public static boolean checkPossibility(int[] A, int N, int M, int max)
    {
        int pages = 0, i, n = A.length, curr = 1;
        for (i = 0; i < N; ++i)
        {
            pages += A[i];
            if (pages > max)
            {
                ++curr;
                pages = A[i];
            }
            if (curr > M) return false;
        }
        return true;
    }
}