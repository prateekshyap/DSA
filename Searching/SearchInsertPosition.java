/*https://practice.geeksforgeeks.org/problems/search-insert-position-of-k-in-a-sorted-array/1/*/

class Solution
{
    static int searchInsertK(int Arr[], int N, int k)
    {
        return binarySearch(Arr, k, 0, N-1);
    }
    static int binarySearch(int[] a, int k, int l, int h)
    {
        if (l <= h)
        {
            int m = (l+h)/2;
            if (a[m] == k) return m;
            if (m == 0 && a[m] > k) return m;
            if (m != 0 && a[m] > k && a[m-1] < k) return m;
            if (m == a.length-1 && a[m] < k) return m+1;
            if (k < a[m]) return binarySearch(a, k, l, m-1);
            return binarySearch(a, k, m+1, h);
        }
        return -1;
    }
}