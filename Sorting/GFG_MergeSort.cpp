/*
https://practice.geeksforgeeks.org/problems/merge-sort/1
Heap Sort

*/

// { Driver Code Starts
#include <stdio.h>
#include <bits/stdc++.h>
using namespace std;



/* Function to print an array */
void printArray(int arr[], int size)
{
    int i;
    for (i=0; i < size; i++)
        printf("%d ", arr[i]);
    printf("\n");
}


 // } Driver Code Ends
class Solution
{
    public:
    void merge(int arr[], int l, int m, int r)
    {
         // Your code here
         int i=l, k=l;
         int j=m+1;
         int B[r+1];
         
         while(i<=m && j<=r)
         {
             if(arr[i]<arr[j])
                B[k++] = arr[i++];
            else
                B[k++] = arr[j++];
         }
         
         while(i<=m) B[k++] = arr[i++];
         while(j<=r) B[k++] = arr[j++];
         for(int e=l; e<=r; e++)
            arr[e]=B[e];
    }
    public:
    void mergeSort(int arr[], int l, int r)
    {
        //code here
        if(l>=r) return;
        int mid = l + (r-l)/2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        merge(arr,l,mid,r);
    }
};

// { Driver Code Starts.


int main()
{
    int n,T,i;

    scanf("%d",&T);

    while(T--){
    
    scanf("%d",&n);
    int arr[n+1];
    for(i=0;i<n;i++)
      scanf("%d",&arr[i]);

    Solution ob;
    ob.mergeSort(arr, 0, n-1);
    printArray(arr, n);
    }
    return 0;
}  // } Driver Code Ends