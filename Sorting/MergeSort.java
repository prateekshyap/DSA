/*https://practice.geeksforgeeks.org/problems/merge-sort/1*/

class Solution
{
    void merge(int arr[], int l, int m, int r)
    {
    	//set the sizes of new arrays
        int n1 = m-l+1;
        int n2 = r-m;

       	//declare the new arrays
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];

        //copy the elements to new arrays
        int x = l;
        for (int i = 0; i < n1; ++i)
            arr1[i] = arr[x++];
        for (int i = 0; i < n2; ++i)
            arr2[i] = arr[x++];

        //merge process
        x = l;
        int i = 0, j = 0;
        while (i < n1 && j < n2)
            if (arr1[i] <= arr2[j])
                arr[x++] = arr1[i++];
            else
                arr[x++] = arr2[j++];
        while (i < n1)
            arr[x++] = arr1[i++];
        while (j < n2)
            arr[x++] = arr2[j++];
    }
    void mergeSort(int arr[], int l, int r)
    {
        if (l < r)
        {
            int m = (l+r)/2;
            mergeSort(arr, l, m);
            mergeSort(arr , m+1, r);
            merge(arr, l, m, r);
        }
    }
}