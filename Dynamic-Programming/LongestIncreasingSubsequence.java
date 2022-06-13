/*https://practice.geeksforgeeks.org/problems/longest-increasing-subsequence-1587115620/1*/
/*https://binarysearch.com/problems/Longest-Increasing-Subsequence*/

class Solution 
{
    static int longestSubsequence(int size, int a[])
    {
        int[] result = new int[size];
        for (int i = 0; i < size; ++i)
            result[i] = 1;
        for (int i = 1; i < size; ++i)
        {
            for (int j = 0; j < i; ++j)
            {
                if (a[i] > a[j] && result[i] < result[j]+1)
                    result[i] = result[j]+1;
            }
        }
        int max = result[0];
        for (int i = 1; i < size; ++i)
            max = Math.max(max, result[i]);
        return max;
    }
} 