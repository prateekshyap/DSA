/*https://practice.geeksforgeeks.org/problems/quick-sort/1#*/

class Solution
{
    static void quickSort(int arr[], int low, int high)
    {
        if (low < high)
        {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot-1);
            quickSort(arr, pivot+1, high);
        }
    }
    static int partition(int arr[], int low, int high)
    {
        //taking the last element as pivot
        int pivot = arr[high];

        //set i outside the window
        int i = low-1;

        //for every element in the window except the pivot
        for (int j = low; j < high; ++j)
        {
            //if the element is smaller
            if (arr[j] <= pivot)
            {
                //increase i and swap with j
                ++i;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        //store the pivot at its correct position
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        //return the index of pivot
        return i+1;
    } 
}