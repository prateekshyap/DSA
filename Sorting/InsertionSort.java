/*https://practice.geeksforgeeks.org/problems/insertion-sort/1*/

class Solution
{
  	public void insertionSort(int arr[], int n)
  	{
  		//for each element except the first one
		for(int i = 1; i < n; ++i)
		{
			//set j to the previous element 
		   	int j = i-1;

		   	//hold the current ith value
           	int key = arr[i];

           	//find the correct position for ith value in the sorted part
           	while (j >= 0 && arr[j] > key)
           	{
               	arr[j+1] = arr[j];
               	--j;
           	}

           	//store the ith value
           	arr[j+1] = key;
		}
  	}
}