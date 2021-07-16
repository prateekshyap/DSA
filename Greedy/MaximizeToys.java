/*https://practice.geeksforgeeks.org/problems/maximize-toys0331/1*/

class Solution{
    static int toyCount(int N, int K, int arr[])
    {
        Arrays.sort(arr);
        int count = 0,i = -1;
        while (K > 0 && i < N-1)
        {
            K -= arr[++i];
            if (K >= 0) ++count;
        }
        return count;
    }
}