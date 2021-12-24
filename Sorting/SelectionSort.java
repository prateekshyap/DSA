/*https://practice.geeksforgeeks.org/problems/selection-sort/1*/
 
class Solution
{
	void selectionSort(int arr[], int n)
	{
	    for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int minIndex = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[minIndex])
                    minIndex = j;
  
            // Swap the found minimum element with the first element in the unsorted part
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
	}
}