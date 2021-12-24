/*https://practice.geeksforgeeks.org/problems/heap-sort/1*/

class Solution
{
	//returns the left child index
    int left(int i) { return (2*i)+1; }

    //returns the right child index
    int right(int i) { return (2*i)+2; }

    //building the heap
    void buildHeap(int arr[], int n)
    {
    	//for all non-leaf elements, call heapify in reverse direction
        for (int i = (n/2)-1; i >= 0; --i)
            heapify(arr,n,i);
    }
 
 	//heapify
    void heapify(int arr[], int n, int i)
    {
    	//set maximum index to the root
        int max = i;

        //if left child is greater, update maximum index
        if (left(i) < n && arr[left(i)] > arr[max])
            max = left(i);

        //if right child is greater, update maximum index
        if (right(i) < n && arr[right(i)] > arr[max])
            max = right(i);

        //if root is not the maximum
        if (max != i)
        {
        	//swap root and maximum
            int temp = arr[max];
            arr[max] = arr[i];
            arr[i] = temp;

            //heapify the child
            heapify(arr,n,max);
        }
    }
    
    public void heapSort(int arr[], int n)
    {
    	//build the heap
        buildHeap(arr,n);
        
        //set the new heap size
        int index = n-1;

        //till more than one elements exist
        while (index > 0)
        {
        	//swap the root with the last element of the heap
            int temp = arr[0];
            arr[0] = arr[index];
            arr[index] = temp;

            //heapify
            heapify(arr,index,0);

            //reduce the heap size
            --index;
        }
    }
}