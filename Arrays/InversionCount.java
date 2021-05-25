/*https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1*/

class Solution
{
    static long inversionCount(long arr[], long N)
    {
        return mergeSort(arr,0,(int)N-1);
    }
    
    static long mergeSort(long[] arr, int low, int high)
    {
        long count = 0;
        if (low < high)
        {
            int mid = (low+high)/2;
            long left = mergeSort(arr,low,mid);
            long right = mergeSort(arr,mid+1,high);
            long getCount = merge(arr,low,mid,high);
            count += left+right+getCount;
        }
        return count;
    }
    
    static long merge(long[] arr, int low, int mid, int high)
    {
        int n1 = mid-low+1;
        int n2 = high-mid;
        long[] arr1 = new long[n1];
        long[] arr2 = new long[n2];
        int x = low;
        for (int i = 0; i < n1; ++i)
            arr1[i] = arr[x++];
        for (int j = 0; j < n2; ++j)
            arr2[j] = arr[x++];
        int i = 0, j = 0;
        long count = 0;
        x = low;
        while (i < n1 && j < n2)
        {
            if (arr1[i] <= arr2[j])
            {
                arr[x++] = arr1[i++];
            }
            else
            {
                arr[x++] = arr2[j++];
                count += (mid+1)-(low+i); //there are mid-i inversions in total
            }
        }
        while (i < n1)
            arr[x++] = arr1[i++];
        while (j < n2)
            arr[x++] = arr2[j++];
        return count;
    }
}