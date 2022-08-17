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

//random pivot
class Solution
{
    //Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high)
    {
        // code here
        if (low < high)
        {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr,low,pivotIndex-1);
            quickSort(arr,pivotIndex+1,high);
        }
    }
    static int partition(int arr[], int low, int high)
    {
        // your code here
        int pivotIndex = randomIndex(low,high);
        int pivot = arr[pivotIndex];
        
        int[] a = new int[high-low+1];

        int i = low, j = high, temp;
        for (int k = low; k <= high; ++k)
            a[k-low] = arr[k];
        for (int k = low; k <= high; ++k)
        {
            if (k != pivotIndex)
            {
                if (a[k-low] <= pivot)
                    arr[i++] = a[k-low];
                else
                    arr[j--] = a[k-low];
            }
        }
        
        arr[i] = pivot;
        
        return i;
    }
    static int randomIndex(int min, int max)
    {
        return (int)(Math.random()*(max-min+1)+min);
    }
}
