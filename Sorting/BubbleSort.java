/*https://practice.geeksforgeeks.org/problems/bubble-sort/1*/

class Solution
{
	public static void bubbleSort(int arr[], int n)
    {
        //for each element
        for (int i = 0; i < n-1; i++)
        {
            //run from 0 in the unsorted part
            for (int j = 0; j < n-i-1; j++)
            {
                if (arr[j] > arr[j+1])
                {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}