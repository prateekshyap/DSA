
/*
https://practice.geeksforgeeks.org/problems/heap-sort/1
Heap Sort

*/
// { Driver Code Starts
// C++ program for implementation of Heap Sort
#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
// The functions should be written in a way that array become sorted 
// in increasing order when heapSort() is called.

class Solution
{
    public:
    
    int left(int i) {return (2*i+1);}
    int right(int i) {return (2*i+2);}
    int parent(int i) {return ((i-1)/2);}
    //Heapify function to maintain heap property.
    // max heapify
    void heapify(int arr[], int n, int i)  
    {
      // Your Code Here
        
        int l = left(i); //left child
        int r = right(i); // right child
        
        int max = i;
        
        if(l<n && arr[l]>arr[max])
            max = l;
         if(r<n && arr[r]>arr[max])
            max = r;
        if(max!=i)
        {
            swap(arr[i],arr[max]);
            heapify(arr, n, max);
        }
            
            
    }

    public:
    //Function to build a Heap from array.
    void buildHeap(int arr[], int n)  
    { 
    // Your Code Here
        for(int i=(n/2)-1; i>=0; i--)
            heapify(arr,n,i);
    }

    
    public:
    //Function to sort an array using Heap Sort.
    void heapSort(int arr[], int n)
    {
        //code here
        buildHeap(arr, n);
        for(int i=n-1; i>=1; i--)
        {
            swap(arr[0],arr[i]);
            heapify(arr, i, 0);
        }
        
        
    }
};




// { Driver Code Starts.

/* Function to print an array */
void printArray(int arr[], int size)
{
    int i;
    for (i=0; i < size; i++)
        printf("%d ", arr[i]);
    printf("\n");
}

// Driver program to test above functions
int main()
{
    int arr[1000000],n,T,i;
    scanf("%d",&T);
    while(T--){
    scanf("%d",&n);
    for(i=0;i<n;i++)
      scanf("%d",&arr[i]);
    Solution ob;
    ob.heapSort(arr, n);
    printArray(arr, n);
    }
    return 0;
}
  // } Driver Code Ends