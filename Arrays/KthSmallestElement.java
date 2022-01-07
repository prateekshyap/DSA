/*https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1*/

class Solution{
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    {
        	Heap heap = new Heap(arr);
        
        	//find kth smallest element
        	int result = heap.extractKthSmallest(k);
        	return result;
    } 
}

class Heap
{
int[] arr;
Heap(int[] tokens)
{
	arr = new int[tokens.length];
	for (int i = 0; i < tokens.length; ++i)
		arr[i] = tokens[i];
}

Heap(int[][] mat, int length)
{
	arr = new int[length];
	for (int j = 0; j < length; ++j)
	{
		arr[j] = mat[j][0];
		//mat[j][0] = -2;
	}
}

public void buildMaxHeap()
{
	for (int i = (arr.length/2)-1; i >= 0; --i)
		maxHeapify(i,arr.length);
}

public void maxHeapify(int root, int n)
{
	int l = (root*2)+1;
	int r = (root*2)+2;
	int max = root;
	if (l < n && arr[l] > arr[root])
		max = l;
	else max = root;
	if (r < n && arr[r] > arr[max])
		max = r;
	if (max != root)
	{
		arr[max] += arr[root];
		arr[root] = arr[max] - arr[root];
		arr[max] -= arr[root];
		maxHeapify(max, n);
	}
}

public void buildMinHeap()
{
	for (int i = (arr.length/2)-1; i >= 0; --i)
		minHeapify(i,arr.length);
}

public void minHeapify(int root, int n)
{
	int l = (root*2)+1;
	int r = (root*2)+2;
	int min = root;
	if (l < n && arr[l] < arr[root])
		min = l;
	else min = root;
	if (r < n && arr[r] < arr[min])
		min = r;
	if (min != root)
	{
		arr[min] += arr[root];
		arr[root] = arr[min] - arr[root];
		arr[min] -= arr[root];
		minHeapify(min,n);
	}
}

public int extractKthLargest(int k)
{
	buildMinHeap();
	for (int i = k; i < arr.length; ++i)
	{
		if (arr[i] >= arr[0])
		{
			swap(0,i);
			minHeapify(0, k);
		}
	}
	return arr[0];
}

public int extractKthSmallest(int k)
{
    buildMaxHeap();
    for (int i = k; i < arr.length; ++i)
    {
        if (arr[i] <= arr[0])
        {
            swap(0,i);
            maxHeapify(0,k);
        }
    }
    return arr[0];
}

public void swap(int i1, int i2)
{
	arr[i1] += arr[i2];
	arr[i2] = arr[i1] - arr[i2];
	arr[i1] -= arr[i2];
}

public void printList()
{
	for (int i = 0; i < arr.length; ++i)
		System.out.print(arr[i]+" ");
}
}